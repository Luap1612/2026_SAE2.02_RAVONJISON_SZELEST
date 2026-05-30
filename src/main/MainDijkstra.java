import java.util.List;

public class MainDijkstra {
    public static void main(String[] args) {
        // 1. Création du graphe de test (Figure 1 du sujet)
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12.0);
        graphe.ajouterArc("A", "D", 87.0);
        graphe.ajouterArc("B", "E", 11.0);
        graphe.ajouterArc("C", "A", 19.0);
        graphe.ajouterArc("D", "B", 23.0);
        graphe.ajouterArc("D", "C", 10.0);
        graphe.ajouterArc("E", "D", 43.0);

        System.out.println("--- Graphe initial ---");
        System.out.println(graphe.toString());

        // 2. Définition du trajet
        String depart = "A";
        String arrivee = "C";

        // 3. Résolution avec Dijkstra
        Dijkstra dijkstra = new Dijkstra();
        Valeurs valeurs = dijkstra.resoudre(graphe, depart);

        // 4. Affichage
        System.out.println("--- Résultats Dijkstra (Départ: " + depart + ") ---");
        System.out.println(valeurs.toString());

        List<String> chemin = valeurs.calculerChemin(arrivee);
        System.out.println("Chemin le plus court de " + depart + " vers " + arrivee + " : " + String.join(" -> ", chemin));
        System.out.println("Coût total : " + valeurs.getValeur(arrivee));
    }
}
