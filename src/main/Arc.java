/**
 * Représente un arc orienté et pondéré dans un graphe.
 */
public class Arc {
    /** Le nœud de destination ciblé par cet arc. */
    private String cible;

    /** Le coût ou poids associé à la traversée de cet arc. */
    private double poids;

    /**
     * Construit un nouvel arc avec une cible et un poids donnés.
     *
     * @param cible Le nom du nœud de destination.
     * @param poids Le poids de l'arc (doit être positif).
     */
    public Arc(String cible, double poids) {
        this.cible = cible;
        this.poids = poids;
    }

    /**
     * Récupère le nœud cible de l'arc.
     *
     * @return Le nom du nœud de destination.
     */
    public String getCible() {
        return this.cible;
    }

    /**
     * Récupère le poids de l'arc.
     *
     * @return Le coût de l'arc.
     */
    public double getPoids() {
        return this.poids;
    }
}