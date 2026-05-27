import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GrapheListeTest {
    private GrapheListe graphe;

    @BeforeEach
    public void setUp() {
        graphe = new GrapheListe();
        // Construction du graphe de la Figure 1
        graphe.ajouterArc("A", "B", 12.0);
        graphe.ajouterArc("A", "D", 87.0);
        graphe.ajouterArc("B", "E", 11.0);
        graphe.ajouterArc("C", "A", 19.0);
        graphe.ajouterArc("D", "B", 23.0);
        graphe.ajouterArc("D", "C", 10.0);
        graphe.ajouterArc("E", "D", 43.0);
    }

    @Test
    public void testNoeudsPresents() {
        List<String> noeuds = graphe.getNoeuds();
        assertEquals(5, noeuds.size(), "Le graphe devrait contenir 5 noeuds.");
        assertTrue(noeuds.contains("A"));
        assertTrue(noeuds.contains("E"));
    }

    @Test
    public void testAdjacenceA() {
        List<Arc> arcsA = graphe.getAdjacence("A");
        assertEquals(2, arcsA.size(), "Le noeud A devrait avoir 2 arcs sortants.");
        
        boolean hasB = false, hasD = false;
        for (Arc arc : arcsA) {
            if (arc.getCible().equals("B") && arc.getPoids() == 12.0) hasB = true;
            if (arc.getCible().equals("D") && arc.getPoids() == 87.0) hasD = true;
        }
        assertTrue(hasB, "L'arc A -> B(12.0) est manquant.");
        assertTrue(hasD, "L'arc A -> D(87.0) est manquant.");
    }
}