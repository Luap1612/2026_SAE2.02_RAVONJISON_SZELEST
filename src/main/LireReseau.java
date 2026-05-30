import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LireReseau {
    public static Graphe lire(String fichier_stations, String fichier_connexions) {
        GrapheListe graphe = new GrapheListe();

        try (BufferedReader br = new BufferedReader(new FileReader(fichier_connexions))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split(";");
                if (parts.length >= 3) {
                    String source = parts[0];
                    String cible = parts[1];
                    double poids = Double.parseDouble(parts[2]);

                    graphe.ajouterArc(source, cible, poids);
                    graphe.ajouterArc(cible, source, poids); // Les arcs sont bidirectionnels
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier : " + e.getMessage());
        }

        return graphe;
    }
}