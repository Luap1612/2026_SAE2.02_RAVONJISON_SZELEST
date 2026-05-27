import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    private List<String> noeuds = new ArrayList();
    private List<Arcs> adjacence = new ArrayList();

    public GrapheListe() {
    }

    public void ajouterArc(String source, String destination, double poids) {
        if (!this.noeuds.contains(source)) {
            this.noeuds.add(source);
            this.adjacence.add(new Arcs());
        }

        if (!this.noeuds.contains(destination)) {
            this.noeuds.add(destination);
            this.adjacence.add(new Arcs());
        }

        int indexSource = this.noeuds.indexOf(source);
        ((Arcs)this.adjacence.get(indexSource)).ajouterArc(new Arc(destination, poids));
    }

    public List<String> getNoeuds() {
        return this.noeuds;
    }

    public List<Arc> getAdjacence(String noeud) {
        int index = this.noeuds.indexOf(noeud);
        return (List<Arc>)(index != -1 ? ((Arcs)this.adjacence.get(index)).getArcs() : new ArrayList());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < this.noeuds.size(); ++i) {
            sb.append((String)this.noeuds.get(i)).append(" -> ");

            for(Arc a : ((Arcs)this.adjacence.get(i)).getArcs()) {
                sb.append(a.getCible()).append("(").append((int)a.getPoids()).append(") ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
