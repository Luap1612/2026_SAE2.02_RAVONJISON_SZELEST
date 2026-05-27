import java.util.ArrayList;
import java.util.List;

public class Arcs {
    private List<Arc> arcs = new ArrayList();

    public Arcs() {
    }

    public void ajouterArc(Arc a) {
        this.arcs.add(a);
    }

    public List<Arc> getArcs() {
        return this.arcs;
    }
}
