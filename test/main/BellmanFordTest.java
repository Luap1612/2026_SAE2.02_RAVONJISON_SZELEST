import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BellmanFordTest {
    private GrapheListe graphe;
    private BellmanFord bf;

    @BeforeEach
    public void setUp() {
        graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12.0);
        graphe.ajouterArc("A", "D", 87.0);
        graphe.ajouterArc("B", "E", 11.0);
        graphe.ajouterArc("C", "A", 19.0);
        graphe.ajouterArc("D", "B", 23.0);
        graphe.ajouterArc("D", "C", 10.0);
        graphe.ajouterArc("E", "D", 43.0);
        
        bf = new BellmanFord();
    }

    @Test
    public void testValeursPlusCourtChemin() {
        Valeurs valeurs = bf.resoudre(graphe, "A");
        
        // Le chemin optimal pour C est A -> B -> E -> D -> C
        // A=0, B=12, E=23, D=66, C=76
        assertEquals(0.0, valeurs.getValeur("A"), "La valeur de A devrait être 0.");
        assertEquals(12.0, valeurs.getValeur("B"), "La valeur de B devrait être 12.");
        assertEquals(23.0, valeurs.getValeur("E"), "La valeur de E devrait être 23.");
        assertEquals(66.0, valeurs.getValeur("D"), "La valeur de D devrait être 66.");
        assertEquals(76.0, valeurs.getValeur("C"), "La valeur de C devrait être 76.");
    }

    @Test
    public void testReconstitutionChemin() {
        Valeurs valeurs = bf.resoudre(graphe, "A");
        List<String> chemin = valeurs.calculerChemin("C");
        
        assertEquals(5, chemin.size(), "Le chemin vers C devrait comporter 5 noeuds.");
        assertEquals(List.of("A", "B", "E", "D", "C"), chemin, "Le chemin vers C est incorrect.");
    }
}