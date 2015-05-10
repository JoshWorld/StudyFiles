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
 *  ��� �߰� �� ���� ����
 */
public class DOMExample3 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder parser = factory.newDocumentBuilder();
		String xmlPath = "src/bookList.xml";
		Document document = parser.parse(xmlPath);
		Element booklistElement = document.getDocumentElement();
		
		// book ������Ʈ ��ü ����
		Element bookElement = document.createElement("book");

		// book ������Ʈ �Ӽ� �߰�
		bookElement.setAttribute("kind", "�Ҽ�");

		// ������Ʈ ��ü ���� �� �ڽĳ�� �߰�
		Element titleElement = document.createElement("title");
		Text titleText = document.createTextNode("���ΰ�����");
		titleElement.appendChild(titleText);

		Element authorElement = document.createElement("author");
		Text authorText = document.createTextNode("�赵��");
		authorElement.appendChild(authorText);

		Element publisherElement = document.createElement("publisher");
		Text publisherText = document.createTextNode("�������ǻ�");
		publisherElement.appendChild(publisherText);

		Element priceElement = document.createElement("price");
		Text priceText = document.createTextNode("9000");
		priceElement.appendChild(priceText);

		bookElement.appendChild(titleElement);
		bookElement.appendChild(authorElement);
		bookElement.appendChild(publisherElement);
		bookElement.appendChild(priceElement);
		//bookElement.insertBefore(newChild, refChild);

		booklistElement.appendChild(bookElement);

		System.out.println("[�����]: ��� �߰� �Ϸ�!");
		System.out.println("[�����]: �߰� �� book ������Ʈ ����: " + booklistElement.getChildNodes().getLength());
		
		
		// XSL ��ȯ�⸦ �̿��� �޸𸮻��� DOM Ʈ���� XML ���Ϸ� ����
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "bookList.dtd");
		
		// DOMSource ��ü ����
		DOMSource source = new DOMSource(document);
		
		// ���� ���� ���
		StreamResult result = new StreamResult(new File("bookList_1.xml"));
		// ��Ʈ��ũ ���
		//Result result = new StreamResult(socket.getOutputStream());
				
		transformer.transform(source, result);
		System.out.println("[�����]: ���� ���� �Ϸ�!!");	
	}
}





