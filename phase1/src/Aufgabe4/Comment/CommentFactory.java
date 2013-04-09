//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.03.24 um 05:45:59 PM CET 
//


package Aufgabe4.Comment;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the aufgabe package. 
 * <p>An CommentFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class CommentFactory {


    /**
     * Create a new CommentFactory that can be used to create new instances of schema derived classes for package: aufgabe
     * 
     */
    public CommentFactory() {
    }

    /**
     * Create an instance of {@link Comments }
     * 
     */
    public Comments createComments() {
        return new Comments();
    }

    /**
     * Create an instance of {@link Comments.Rezept }
     * 
     */
    public Comments.Rezept createCommentsRezept() {
        return new Comments.Rezept();
    }

    /**
     * Create an instance of {@link Comments.Rezept.Comment }
     * 
     */
    public Comments.Rezept.Comment createCommentsRezeptComment() {
        return new Comments.Rezept.Comment();
    }

    /**
     * Create an instance of {@link Comments.Rezept.Comment.Userexpirience }
     * 
     */
    public Comments.Rezept.Comment.Userexpirience createCommentsRezeptCommentUserexpirience() {
        return new Comments.Rezept.Comment.Userexpirience();
    }

    /**
     * Create an instance of {@link Comments.Rezept.Comment.Commentwertung }
     * 
     */
    public Comments.Rezept.Comment.Commentwertung createCommentsRezeptCommentCommentwertung() {
        return new Comments.Rezept.Comment.Commentwertung();
    }

}
