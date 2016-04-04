package Mundo;

import java.util.*;

/**
 * Created by ASUS on 22/03/2016.
 */
public class Grafo {

    //-----------------------------------------------------------------------------------------------------------------//
    //Atributos
    //-----------------------------------------------------------------------------------------------------------------//
    private List<Interseccion> intersecciones;
    private List<Calle> calles;
    private Ambulancia ambulancia;
    private double minutosTiempoRecorrido;

    private final Map<String, Interseccion> graph;
    //-----------------------------------------------------------------------------------------------------------------//
    //Constructores
    //-----------------------------------------------------------------------------------------------------------------//

    public Grafo (Calle[] calles)
    {
        graph = new HashMap<>(calles.length);

        //one pass to find all vertices
        for (Calle e : calles) {
            if (!graph.containsKey(e.getInterseccionOrigen())) graph.put(e.getInterseccionOrigen(), new Interseccion(e.getInterseccionOrigen()));
            if (!graph.containsKey(e.getInterseccionDestino())) graph.put(e.getInterseccionDestino(), new Interseccion(e.getInterseccionDestino()));
        }

        //another pass to set neighbouring vertices
        for (Calle e : calles) {
            graph.get(e.getInterseccionOrigen()).neighbours.put(graph.get(e.getInterseccionDestino()), e.getDistancia());
            //graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also do this for an undirected graph
        }
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Métodos
    //-----------------------------------------------------------------------------------------------------------------//

    /**
     * Retorna los minutos transcurridos desde el inicio del thread de ruteo.
     * @return Los minutos desde el inicio del thread.
     */
    public double getMinutosTiempoRecorrido()
    {
        return minutosTiempoRecorrido;
    }

    public void dijkstra(String startName)
    {
        if (!graph.containsKey(startName)) {
            System.err.printf("El grafo no contiene el nombre del vertice inicial: \"%s\"\n", startName);
            return;
        }
        final Interseccion source = graph.get(startName);
        NavigableSet<Interseccion> q = new TreeSet<>();

        // set-up vertices
        for (Interseccion v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    /** Implementation of dijkstra's algorithm using a binary heap. */
    private void dijkstra(final NavigableSet<Interseccion> q) {
        Interseccion u, v;
        while (!q.isEmpty()) {

            u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
            if (u.dist == Integer.MAX_VALUE) break; // we can ignore u (and any other remaining vertices) since they are unreachable

            //look at distances to each neighbour
            for (Map.Entry<Interseccion, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //the neighbour in this iteration

                final int alternateDist = u.dist + a.getValue();
                if (alternateDist < v.dist) { // shorter path to neighbour found
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    /** Prints a path from the source to the specified vertex */
    public void printPath(String endName) {
        if (!graph.containsKey(endName)) {
            System.err.printf("El grafo no contiene vertice final con nombre: \"%s\"\n", endName);
            return;
        }

        graph.get(endName).printPath();
        System.out.println();
    }

    /** Prints the path from the source to every vertex (output order is not guaranteed) */
    public void printAllPaths() {
        for (Interseccion v : graph.values()) {
            v.printPath();
            System.out.println();
        }
    }

    public void iniciarThreadRuteo()
    {
        //TODO Construir thread
    }
}
