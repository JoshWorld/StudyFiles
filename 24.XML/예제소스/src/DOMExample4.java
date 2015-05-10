
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *  DOM �Ծ��� �ؼ��� JAXP �ļ� ��� XML ó��
 *  ��� ����
 */
public class DOMExample4 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder parser = factory.newDocumentBuilder();

		String xmlPath = "src/bookList.xml";
		Document document = parser.parse(xmlPath);

		Element booklistElement = document.getDocumentElement();

		// ù��° å ���� �����ϱ�
		Element bookElement = (Element) booklistElement.getFirstChild();
		Element titleElement = (Element) bookElement.getFirstChild();
		Text titleText = (Text) titleElement.getFirstChild();
		titleText.setNodeValue("������ ���� ����");
		// titleText.setData("������ ���� ����");
		System.out.println("[�����]: ������ ����: " + titleText.getNodeValue());

		// �Ӽ� �����ϱ�
		bookElement.setAttribute("kind", "�Ҽ�");
		System.out.println("[�����]: ������ ����: " + bookElement.getAttribute("kind"));
		

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "bookList.dtd");
				
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("bookList_2.xml"));
		transformer.transform(source, result);
		System.out.println("[�����]: ���� ���� �Ϸ�!!");	
	}
}
