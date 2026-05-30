import java.util.List;
import java.util.ArrayList;

public class Dijkstra {
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
