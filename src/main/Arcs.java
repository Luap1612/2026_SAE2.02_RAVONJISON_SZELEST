import java.util.ArrayList;
import java.util.List;

/**
 * Encapsule une liste d'arcs partant d'un nœud spécifique.
 */
public class Arcs {
    /** La liste des arcs. */
    private List<Arc> arcs = new ArrayList<>();

    /**
     * Constructeur par défaut initialisant une liste d'arcs vide.
     */
    public Arcs() {
    }

    /**
     * Ajoute un nouvel arc à la liste.
     *
     * @param a L'arc à ajouter.
     */
    public void ajouterArc(Arc a) {
        this.arcs.add(a);
    }

    /**
     * Récupère la liste complète des arcs.
     *
     * @return Une liste d'objets {@link Arc}.
     */
    public List<Arc> getArcs() {
        return this.arcs;
    }
}