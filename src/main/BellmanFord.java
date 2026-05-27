import java.util.List;

public class BellmanFord {

    public BellmanFord() {
    }

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
