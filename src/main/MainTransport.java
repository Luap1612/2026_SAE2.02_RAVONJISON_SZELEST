import java.util.List;

public class MainTransport {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java MainTransport <depart> <arrivee>");
            return;
        }

        String depart = args[0];
        String arrivee = args[1];

        // Remplacer par le chemin relatif exact vers vos fichiers de données
        Graphe graphe = LireReseau.lire("../../STAN.GTFS", "../../STAN.GTFS");

        Dijkstra dijkstra = new Dijkstra();
        Valeurs valeurs = dijkstra.resoudre(graphe, depart);

        List<String> chemin = valeurs.calculerChemin(arrivee);

        // Affichage requis pour l'interface graphique
        System.out.println(String.join(";", chemin));
    }
}
