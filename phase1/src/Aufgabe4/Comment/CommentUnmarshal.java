package Aufgabe4.Comment;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Olli
 */
public class CommentUnmarshal {

    private Comments XMComments = null;

    public CommentUnmarshal(String file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Comments.class);
        Unmarshaller m = context.createUnmarshaller();

        XMComments = (Comments) m.unmarshal(new File("xml/comment.xml"));
    }

    public Comments getComments() {
        return this.XMComments;
    }

    public void setComments(Comments c) {
        this.XMComments = c;
    }

    public String comstring(int i) throws JAXBException {
        Comments co = XMComments;
        String s = "";
        for (int j = 0; j < co.getRezept().get(i).getComment().size(); j++) {
            s += "\nUsername: " + co.getRezept().get(i).getComment().get(j).getUsername() + "\n";
            s += "Comment: " + co.getRezept().get(i).getComment().get(j).getText() + "\n\n-~-~-~-~-~-~-~\n";
        }
        return s;
    }
}
