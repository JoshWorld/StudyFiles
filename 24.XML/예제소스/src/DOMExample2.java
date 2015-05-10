import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *  DOM �Ծ��� �ؼ��� JAXP �ļ� ��� XML ó��
 *  ���ļ� ���� �� ��� �˻�
 */
public class DOMExample2 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder parser = factory.newDocumentBuilder();

		String xmlPath = "src/bookList.xml";
		Document document = parser.parse(xmlPath);
		
		// ��Ʈ ������Ʈ ���
		Element booklistElement = document.getDocumentElement();
		
		// ��Ʈ ������Ʈ�� ��� �ڽ� ��� �˻�
		NodeList bookElements = booklistElement.getChildNodes();
		System.out.println("[�����]: �ڽĳ���: " + bookElements.getLength());
		for (int i = 0; i < bookElements.getLength(); i++) {
			Node node = bookElements.item(i);
			System.out.println("[�����]: " + node.toString());
		}
		
		System.out.println("------------------------------------------------------");

		// Ư�� ������Ʈ �̸����� ������Ʈ �˻�
		NodeList bookList = document.getElementsByTagName("book");
		System.out.println("[�����]: book ������Ʈ ����: " + bookList.getLength());
		for (int i = 0; i < bookList.getLength(); i++) {
			Element bookE = (Element) bookList.item(i);
			
			NodeList list = bookE.getChildNodes();
			for(int j=0; j<list.getLength(); j++){
				String name = null;
				String value = null;
				Element e = (Element)list.item(j);
				name = e.getNodeName();
				Text t = (Text)e.getFirstChild();
				value = t.getNodeValue();
				System.out.println(name + ": " + value);
			}
			System.out.println();
		}
		
		// Ư�� ���̵�� ������Ʈ �˻�
		//Element ee =  document.getElementById("b101");
	}
}











