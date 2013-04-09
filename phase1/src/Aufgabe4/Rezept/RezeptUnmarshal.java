package Aufgabe4.Rezept;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Olli
 */
public class RezeptUnmarshal {

    public Rezepte unmarshal() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Rezepte.class);
        Unmarshaller m = context.createUnmarshaller();
        Rezepte XMRezepte = (Rezepte) m.unmarshal(new File("xml/rezept.xml"));

        return XMRezepte;
    }

    public String xmstring() throws JAXBException {
        String s = "\n";
        Rezepte r = unmarshal();
        for (int i = 0; i < r.getRezept().size(); i++) {
            Rezepte.Rezept rz = r.getRezept().get(i);
            s += "\n###############################################\n";
            s += "Rezept Nummer: " + i + "\n";
            s += "Name: "+ rz.getName() +"\nBilder:\n";
            for (int j = 0; j < rz.getPhotos().getPhoto().size(); j++) {
                s += "\tBild: " + (j + 1) + ", Datei: \"" + rz.getPhotos().getPhoto().get(j).getSource() + "\"\n";
            }
            s += "Zutaten:\n";
            for (int j = 0; j < rz.getZutaten().getZutat().size(); j++) {
                s += "\tZutat:" + rz.getZutaten().getZutat().get(j).getName() + " " + rz.getZutaten().getZutat().get(j).getMenge() + " " + rz.getZutaten().getZutat().get(j).getEinheit() + "\n";
            }
            s += "Arbeitszeit: " + rz.getArbeitszeit().getValue() + "\n";
            s += "Kalorien: " + rz.getBrennwert().getValue() + " " + rz.getBrennwert().getEinheit() + "\n";
            s += "Schwierigkeit: " + rz.getSchwierigkeit().getValue() + "\n";
            s += "Zubereitung: " + rz.getZubereitung() + "\n";

        }
        return s;
    }

    public String xmstring(int i) throws JAXBException {
        String s = "\n";
        Rezepte r = unmarshal();
        Rezepte.Rezept rz = r.getRezept().get(i);
        s += "Rezept Nummer: " + i + "\n";
        s += "Name: "+ rz.getName()+ "\nBilder:\n";
        for (int j = 0; j < rz.getPhotos().getPhoto().size(); j++) {
            s += "\tBild: " + (j + 1) + ", Datei: \"" + rz.getPhotos().getPhoto().get(j).getSource() + "\"\n";
        }
        s += "Zutaten:\n";
        for (int j = 0; j < rz.getZutaten().getZutat().size(); j++) {
            s += "\tZutat: " + rz.getZutaten().getZutat().get(j).getName() + " " + rz.getZutaten().getZutat().get(j).getMenge() + " " + rz.getZutaten().getZutat().get(j).getEinheit() + "\n";
        }
        s += "Arbeitszeit: " + rz.getArbeitszeit().getValue() + "\n";
        s += "Kalorien: " + rz.getBrennwert().getValue() + " " + rz.getBrennwert().getEinheit() + "\n";
        s += "Schwierigkeit: " + rz.getSchwierigkeit().getValue() + "\n";
        s += "Zubereitung: " + rz.getZubereitung() + "\n\n###########################################################################\nKommentare:\n\n";

        return s;
    }
}
