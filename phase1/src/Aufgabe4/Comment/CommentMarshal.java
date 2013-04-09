package Aufgabe4.Comment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Olli
 */
public class CommentMarshal {

    private FileOutputStream f;

    public CommentMarshal() throws JAXBException {
    }

    public void setComments(Comments s) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Comments.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        f = new FileOutputStream("xml/comment.xml");
        m.marshal(s, f);
    }
}
