import java.util.List;

/**
 * Implémentation de l'algorithme du point fixe (Bellman-Ford) pour rechercher
 * le plus court chemin dans un graphe à partir d'un nœud source.
 */
public class BellmanFord {

    /**
     * Constructeur par défaut.
     */
    public BellmanFord() {
    }

    /**
     * Résout le problème du plus court chemin en utilisant l'algorithme de Bellman-Ford.
     * Initialise les distances à l'infini et les met à jour itérativement jusqu'à convergence.
     *
     * @param g      Le graphe sur lequel exécuter l'algorithme.
     * @param depart Le nœud de départ.
     * @return Un objet {@link Valeurs} contenant les distances minimales et les parents de chaque nœud.
     */
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();
        List<String> noeuds = g.getNoeuds();

        for(String n : noeuds) {
            valeurs.setValeur(n, Double.MAX_VALUE);
        }

        valeurs.setValeur(depart, (double)0.0F);
        boolean modifie = true;

        while(modifie) {
            modifie = false;

            for(String x : noeuds) {
                double valX = valeurs.getValeur(x);
                if (valX != Double.MAX_VALUE) {
                    for(Arc arc : g.getAdjacence(x)) {
                        String n = arc.getCible();
                        double nouvelleVal = valX + arc.getPoids();
                        if (nouvelleVal < valeurs.getValeur(n)) {
                            valeurs.setValeur(n, nouvelleVal);
                            valeurs.setParent(n, x);
                            modifie = true;
                        }
                    }
                }
            }
        }

        return valeurs;
    }
}