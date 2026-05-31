import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d'un graphe orienté utilisant des listes d'adjacence.
 */
public class GrapheListe implements Graphe {
    /** Liste contenant les identifiants de tous les nœuds du graphe. */
    private List<String> noeuds = new ArrayList<>();

    /** Liste contenant les objets Arcs (les listes d'adjacence) correspondant à chaque nœud. */
    private List<Arcs> adjacence = new ArrayList<>();

    /**
     * Constructeur par défaut créant un graphe vide.
     */
    public GrapheListe() {
    }

    /**
     * Ajoute un arc orienté au graphe entre une source et une destination avec un poids donné.
     * Si les nœuds n'existent pas encore dans le graphe, ils sont créés.
     *
     * @param source      Le nœud d'origine de l'arc.
     * @param destination Le nœud cible de l'arc.
     * @param poids       Le coût de l'arc.
     */
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

    @Override
    public List<String> getNoeuds() {
        return this.noeuds;
    }

    @Override
    public List<Arc> getAdjacence(String noeud) {
        int index = this.noeuds.indexOf(noeud);
        return (List<Arc>)(index != -1 ? ((Arcs)this.adjacence.get(index)).getArcs() : new ArrayList<>());
    }

    /**
     * Fournit une représentation textuelle du graphe et de ses connexions.
     *
     * @return Une chaîne de caractères formatée décrivant chaque nœud et ses arcs sortants.
     */
    @Override
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