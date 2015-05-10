
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

/**
 *  DOM �Ծ��� �ؼ��� JAXP �ļ� ��� XML ó��
 *  ��� ����
 */
public class DOMExample5 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder parser = factory.newDocumentBuilder();

		String xmlPath = "src/bookList.xml";
		Document document = parser.parse(xmlPath);
		Element booklistElement = document.getDocumentElement();
		
		Element bookElement = (Element) booklistElement.getFirstChild();
		booklistElement.removeChild(bookElement);
		System.out.println("[�����]: ������ book ������Ʈ ����: " + booklistElement.getChildNodes().getLength());
				
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "bookList.dtd");
				
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("bookList_3.xml"));
		transformer.transform(source, result);
		System.out.println("[�����]: ���� ���� �Ϸ�!!");	
	}
}
