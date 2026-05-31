import java.util.List;

/**
 * Interface définissant les opérations fondamentales pour manipuler un graphe orienté.
 */
public interface Graphe {
    /**
     * Récupère la liste de tous les nœuds présents dans le graphe.
     *
     * @return Une liste contenant les noms (identifiants) des nœuds.
     */
    List<String> getNoeuds();

    /**
     * Récupère la liste des arcs adjacents (sortants) pour un nœud donné.
     *
     * @param noeud Le nom du nœud dont on cherche l'adjacence.
     * @return Une liste d'objets {@link Arc} représentant les arêtes sortantes du nœud.
     */
    List<Arc> getAdjacence(String noeud);
}