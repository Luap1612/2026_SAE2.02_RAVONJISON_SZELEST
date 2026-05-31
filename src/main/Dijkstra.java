import java.util.List;
import java.util.ArrayList;

/**
 * Implémentation de l'algorithme de Dijkstra pour rechercher le plus court chemin
 * dans un graphe avec des poids positifs.
 */
public class Dijkstra {

    /**
     * Résout le problème du plus court chemin en utilisant l'algorithme de Dijkstra.
     * Explore les nœuds de proche en proche en choisissant toujours celui dont
     * la distance cumulée est la plus faible.
     *
     * @param g      Le graphe sur lequel exécuter l'algorithme.
     * @param depart Le nœud de départ.
     * @return Un objet {@link Valeurs} contenant les coûts minimums et les parents de chaque nœud.
     */
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();
        List<String> q = new ArrayList<>();

        for (String v : g.getNoeuds()) {
            valeurs.setValeur(v, Double.MAX_VALUE);
            q.add(v);
        }
        valeurs.setValeur(depart, 0.0);

        while (!q.isEmpty()) {
            String u = null;
            double minVal = Double.MAX_VALUE;

            for (String n : q) {
                double val = valeurs.getValeur(n);
                if (val < minVal) {
                    minVal = val;
                    u = n;
                }
            }

            if (u == null) break;
            q.remove(u);

            for (Arc arc : g.getAdjacence(u)) {
                String v = arc.getCible();
                if (q.contains(v)) {
                    double d = valeurs.getValeur(u) + arc.getPoids();
                    if (d < valeurs.getValeur(v)) {
                        valeurs.setValeur(v, d);
                        valeurs.setParent(v, u);
                    }
                }
            }
        }
        return valeurs;
    }
}