import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe utilitaire permettant la lecture d'un réseau et la construction
 * du graphe correspondant depuis des fichiers de données.
 */
public class LireReseau {

    /**
     * Lit un fichier de connexions et génère un graphe basé sur les arêtes fournies.
     * Note: Les connexions lues sont ajoutées de manière bidirectionnelle au graphe.
     *
     * @param fichier_stations   Le chemin vers le fichier contenant les stations (arrêts).
     * @param fichier_connexions Le chemin vers le fichier contenant les connexions entre stations au format "source;cible;poids".
     * @return Un objet implémentant l'interface {@link Graphe} contenant les nœuds et arcs lus.
     */
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