package Mundo;

/**
 * Created by usuario on 3/28/2016.
 */
public class Dijkstra {

    private static final Calle[] GRAPH =
            {
                    new Calle("a", "b", (int) Math.floor(Math.random()*101)),
                    new Calle("a", "c", (int) Math.floor(Math.random()*101)),
                    new Calle("a", "f", (int) Math.floor(Math.random()*101)),
                    new Calle("b", "c", (int) Math.floor(Math.random()*101)),
                    new Calle("b", "d", (int) Math.floor(Math.random()*101)),
                    new Calle("c", "d", (int) Math.floor(Math.random()*101)),
                    new Calle("c", "f", (int) Math.floor(Math.random()*101)),
                    new Calle("d", "e", (int) Math.floor(Math.random()*101)),
                    new Calle("e", "f", (int) Math.floor(Math.random()*101)),
            };

    private static final String START = "a";
    private static final String END = "e";

    public static void main(String[] args) {
        Grafo g = new Grafo(GRAPH);
        g.dijkstra(START);
        g.printPath(END);
        //g.printAllPaths();
    }
}
