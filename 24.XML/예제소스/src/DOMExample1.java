import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *  DOM �Ծ��� �ؼ��� JAXP �ļ� ��� XML ó��
 *  ���ļ� ���� �� ��� �˻�
 */
public class DOMExample1 {
	public static void main(String[] args){
		//DOM �ļ� Factory ����
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		// WhiteSpace�� ������(XML������ �������������� �־�� ��ȿ)
		// DTD���� �Ǵ� XML Schema ������ �����Ǿ�� �Ѵ�.
		factory.setIgnoringElementContentWhitespace(true); 
		// DTD Validation �˻縦 �ϰ��� 
		factory.setValidating(true); 
		// NameSpace�� �ؼ��ϵ��� �� 
		//factory.setNamespaceAware(true); 

		//DOM �ļ� ����(JAXP)
		DocumentBuilder parser = null;
		try {
			parser = factory.newDocumentBuilder();
			System.out.println("[�����]: DOM �ļ� �ε� �Ϸ�!");
			System.out.println(parser);
		} catch (ParserConfigurationException e) {
			System.out.println("[�����]: " + e);
		}
		
		String xmlPath = "src/bookList.xml";
		// ���� ��ũ�� XML������ ���� ��Ҹ� ��ü Ʈ���� ����
		Document document = null;
		try {
			document = parser.parse(xmlPath);
			System.out.println("[�����]: DOM Ʈ�� ��ü ���� �Ϸ�:" + document);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// ��Ʈ��ũ�� ���޵Ǵ� XML ���� �Ľ�
		//URL url = new URL("http://www.xxx.co.kr/bml.xml"); 
		//InputStream is = url.openStream();
		//document = parser.parse(is); 

		/** DOM API�� �̿��� ��� �˻� */

		// Node �ֻ��� �������̽��� �߻� �޼ҵ带 �̿��� ����, ��� ����, ��尪 �б� 
		System.out.println("���� : " + document.getNodeName());
		System.out.println("������� : " + document.getNodeType());
		System.out.println(Node.DOCUMENT_NODE);
		System.out.println("��尪 : " + document.getNodeValue());
		

		// ��Ʈ ������Ʈ(booklist) ��ü ��� 
		Element bookListElement = document.getDocumentElement();
		System.out.println("���� : " + bookListElement.getNodeName());
		System.out.println("������Ʈ�� : " + bookListElement.getTagName());// Element�� �߰��� �߻�޼ҵ�
		System.out.println("������� : " + bookListElement.getNodeType());
		System.out.println("��尪 : " + bookListElement.getNodeValue());
		
		// ù��° book ������Ʈ ��ü ���
		Node bookElement = bookListElement.getFirstChild();
		
		Element titleElement = (Element) bookElement.getFirstChild();
		Text titleText = (Text) titleElement.getFirstChild();
		//String title = titleText.getNodeValue();
		String title = titleText.getData();
		System.out.println("����: " + title);

		Element authorElement = (Element) titleElement.getNextSibling();
		Node authorText = authorElement.getFirstChild();
		String author = authorText.getNodeValue();
		System.out.println("����: " + author);
		
		Node publisherElement = authorElement.getNextSibling();
		String publisher = publisherElement.getFirstChild().getNodeValue();
		System.out.println("���ǻ�: " + publisher);
		
		Node priceElement = publisherElement.getNextSibling();
		String price = priceElement.getFirstChild().getNodeValue();
		System.out.println("����: " + price);

		// Ư�� ������Ʈ�� �Ӽ� ��ȸ
		String kind = ((Element)bookElement).getAttribute("kind");
		System.out.println("�з�: "+ kind);
	}
}
