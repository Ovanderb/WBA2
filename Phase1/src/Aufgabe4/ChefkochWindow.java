package Aufgabe4;

import Aufgabe4.Comment.*;
import Aufgabe4.Comment.Comments.Rezept;
import Aufgabe4.Rezept.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Olli
 */
public class ChefkochWindow extends Frame {

    Panel XMpanel = new Panel();
    Panel Btnp = new Panel();
    Panel ppath = new Panel();
    Button readXM = new Button("Lese Rezept Nr");
    Button readCom = new Button("Clear");
    Button addCom = new Button("Add Comment");
    TextArea TextOut = new TextArea("", 30, 80);
    Label rezlabel = new Label("Rezept Nummer");
    TextField path = new TextField("Output path", 15);
    TextField rezeptnr = new TextField("0", 10);
    TextField usern = new TextField("User", 15);
    TextField Comment = new TextField("Comment", 50);
    CommentUnmarshal CW = null;

    public ChefkochWindow() {
        setTitle("Chefkoch XML in Volkers knuffiger Konsole");
        setSize(800, 600);
        setLayout(null);
        addWindowListener(new TestWindowListener());

        readXM.addActionListener(new readXListener(this));
        readXM.setSize(150, 40);
        readXM.setLocation(20, 120);

        readCom.addActionListener(new readComListener());
        readCom.setSize(150, 40);
        readCom.setLocation(20, 180);

        usern.addFocusListener(new ul());
        Comment.addFocusListener(new cl());
        addCom.addActionListener(new firecomment(this));
        rezeptnr.addFocusListener(new reznr());
        XMpanel.setSize(600, 570);
        XMpanel.setLocation(200, 30);
        XMpanel.setBackground(Color.LIGHT_GRAY);
        XMpanel.add(TextOut);
        XMpanel.add(usern);
        XMpanel.add(Comment);
        XMpanel.add(addCom);

        ppath.add(path);
        ppath.setSize(150, 60);
        ppath.setLocation(20, 550);

        Btnp.setSize(150, 60);
        Btnp.setLocation(20, 30);
        Btnp.add(rezlabel);
        Btnp.add(rezeptnr);

        add(readXM);
        add(readCom);


        add(XMpanel);
        add(Btnp);
        setVisible(true);
    }

    class reznr implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            rezeptnr.setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }

    class ul implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            usern.setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }

    class firecomment implements ActionListener {

        public ChefkochWindow CW = null;
        private CommentUnmarshal CU;
        private Comments newcom;

        public firecomment(ChefkochWindow w) {
            CW = w;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String xms = null;
            CW.TextOut.setText(xms);

            try {

                RezeptUnmarshal rez = new RezeptUnmarshal();
                CU = new CommentUnmarshal("src/Aufgabe4/xml/comment.xml");
                newcom = CU.getComments();
                int z = Integer.parseInt(CW.rezeptnr.getText());
                xms = rez.xmstring(z);
                Rezept.Comment nc = new Comments.Rezept.Comment();
                nc.setUsername(CW.usern.getText());
                nc.setText(CW.Comment.getText());
                newcom.getRezept().get(z).getComment().add(nc);
                CU.setComments(newcom);
                xms += CU.comstring(z);
            } catch (JAXBException ex) {
                Logger.getLogger(ChefkochWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            CW.TextOut.setText(xms);
            try {
                try {
                    new CommentMarshal().setComments(newcom);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ChefkochWindow.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (JAXBException ex) {
                Logger.getLogger(ChefkochWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            usern.setText("Name");
            Comment.setText("Comment");
        }
    }

    class cl implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            Comment.setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }

    class readXListener implements ActionListener {

        ChefkochWindow CW = null;

        public readXListener(ChefkochWindow w) {
            CW = w;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String xms = null;
            int z = Integer.parseInt(CW.rezeptnr.getText());
            try {
                int og = new RezeptUnmarshal().unmarshal().getRezept().size();
                if (z < 0 || z >= og) {
                    xms = "Diese Rezeptnummer existiert nicht!";
                } else {
                    xms = new RezeptUnmarshal().xmstring(z);
                    xms += new CommentUnmarshal(CW.path.getText() + "/comment.xml").comstring(z);
                }
            } catch (JAXBException ex) {
                Logger.getLogger(ChefkochWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            CW.TextOut.setText(xms);
        }
    }

    class readComListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TextOut.setText(null);
        }
    }

    class TestWindowListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().dispose();                   
            System.exit(0);
        }
    }
}
