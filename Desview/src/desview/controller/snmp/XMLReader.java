package desview.controller.snmp;

import desview.util.Message;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.tree.DefaultMutableTreeNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * This class build a tree from the RFC in XML format.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 12/04/2010.
 */
public class XMLReader {

    private DefaultMutableTreeNode root;
    private Document documentoXML;

    /**
     * Default constructor.
     */
    public XMLReader() {
    }

    /**
     * Constructor of class.
     * @param file RFC file.
     * @param root the root node.
     */
    public XMLReader(String file, DefaultMutableTreeNode root) {
        this.root = root;
        InputStream inputStream = XMLReader.class.getResourceAsStream(file);
        // Analisa o arquivo XML
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            documentoXML = db.parse(inputStream);
            inputStream.close();
        } // Arquivo não encontrado ou erros de I/O.
        catch (IOException ioe) {
            throw new RuntimeException("I/O Error: " + ioe);
        } catch (Exception e) {
            throw new RuntimeException("Exception trying to read XML: " + e);
        }
    }

    /**
     * Builds the tree from the XML file and its attributes.
     * @return the tree built.
     */
    public DefaultMutableTreeNode buildTreeFromXML() {
        try {
            Element elementoRaiz = documentoXML.getDocumentElement();
            NodeList modulos = elementoRaiz.getElementsByTagName("module");
            DefaultMutableTreeNode arvore = new DefaultMutableTreeNode(root, true);

            for (int i = 0; i < modulos.getLength(); i++) {
                arvore.add(buildTreeFromXML(modulos.item(i)));
            }

            return arvore;
        } catch (Exception e) {
            Message.error(null, "Error!", " The tree could not be built from XML.\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Recursive method to build the tree.
     * @param node the current node.
     * @return node.
     */
    private DefaultMutableTreeNode buildTreeFromXML(Node node) {

        String tipo = node.getAttributes().getNamedItem("descriptorType").getNodeValue();

        if (!node.hasChildNodes()) {
            if (tipo.equals("NODETYPE")) { // vazio
                return new DefaultMutableTreeNode(new Leaf(node.getAttributes().getNamedItem("name").getNodeValue(), "", "", "", ""), true);
            }
            if (tipo.equals("ATTRIBUTE")) { // folha
                NamedNodeMap NNMap = node.getAttributes();
                // constroi a folha
                Leaf folha = new Leaf(NNMap.getNamedItem("name").getNodeValue(), "", NNMap.getNamedItem("description").getNodeValue(), NNMap.getNamedItem("access").getNodeValue(), NNMap.getNamedItem("type").getNodeValue());
                // retorna a folha
                return new DefaultMutableTreeNode(folha, false);
            }
        } else { // nodo tem filhos
            if (tipo.equals("NODETYPE") || (node.getNodeName().equals("combinedAttribute") && tipo.equals("ATTRIBUTE"))) {
                NodeList listaNodos = node.getChildNodes();
                Leaf folha;
                if (node.getNodeName().equals("combinedAttribute")) {
                    folha = new Leaf(node.getAttributes().getNamedItem("name").getNodeValue(), "", node.getAttributes().getNamedItem("description").getNodeValue(), node.getAttributes().getNamedItem("access").getNodeValue(), node.getAttributes().getNamedItem("type").getNodeValue());
                } else {
                    folha = new Leaf(node.getAttributes().getNamedItem("name").getNodeValue(), "", "", "", "");
                }

                DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(folha, true);
                int qtdFilhos = 0;
                for (int i = 0; i < listaNodos.getLength(); i++) {
                    if ((listaNodos.item(i).getNodeType() == Node.ELEMENT_NODE) && (listaNodos.item(i).getAttributes().getNamedItem("descriptorType") != null)) {
                        nodo.add(buildTreeFromXML(listaNodos.item(i)));
                        qtdFilhos++;
                    }
                }
                if (qtdFilhos == 0) {
                    nodo.setAllowsChildren(false);
                }
                return nodo;
            }
            if (tipo.equals("ATTRIBUTE")) {// tem atributos
                NamedNodeMap NNMap = node.getAttributes();
                Element elemento = (Element) ((Element) node).getElementsByTagName("protocolMap").item(0);
                String s = elemento.getAttribute("identifier"); // oid
                Leaf folha = new Leaf(NNMap.getNamedItem("name").getNodeValue(), s, NNMap.getNamedItem("description").getNodeValue(), NNMap.getNamedItem("access").getNodeValue(), NNMap.getNamedItem("type").getNodeValue());
                return new DefaultMutableTreeNode(folha, false);// mostrar folha com formato de folha.
            }
        }
        Message.error(null, "Error!", "Could not build the tree recursively\n");
        return new DefaultMutableTreeNode("ERROR!! Could not built the tree recursively!");
    }

    /**
     * Returns the root.
     * @return root.
     */
    public DefaultMutableTreeNode getRoot() {
        return root;
    }
}
