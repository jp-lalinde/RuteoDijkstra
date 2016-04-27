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

        //Un recorrido para modelar todos los vertices. O(N).
        for (Calle e : calles) {
            if (!graph.containsKey(e.getInterseccionOrigen()))
            {
                graph.put(e.getInterseccionOrigen(), new Interseccion(e.getInterseccionOrigen()));
            }

            if (!graph.containsKey(e.getInterseccionDestino()))
            {
                graph.put(e.getInterseccionDestino(), new Interseccion(e.getInterseccionDestino()));
            }

        }

        //Un recorrido para modelar las relaciones entre los vertices. O(N)
        for (Calle e : calles) {
            graph.get(e.getInterseccionOrigen()).neighbours.put(graph.get(e.getInterseccionDestino()), e.getDistancia());
            if(e.esDobleVia())
            {
                // Arco no dirigido
                //System.out.println("Entro no dirigido: ("+e.getInterseccionOrigen()+","+e.getInterseccionDestino()+")");
                graph.get(e.getInterseccionDestino()).neighbours.put(graph.get(e.getInterseccionOrigen()), e.getDistancia());
            }
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
        minutosTiempoRecorrido = 0;

        // Establece las intersecciones
        for (Interseccion v : graph.values()) {
            v.previous = (v == source ? source : null);
            v.dist = (v == source ? 0 : Integer.MAX_VALUE);
            q.add(v);
        }

        dijkstra(q);
    }

    /** Implementation of dijkstra's algorithm using a binary heap. */
    //Complejidad de O( (|Edges|+|Vertices|)log(|Vertices|) )
    private void dijkstra(final NavigableSet<Interseccion> q) {
        Interseccion u, v;
        while (!q.isEmpty()) {

            u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
            if (u.dist == Integer.MAX_VALUE) break; // we can ignore u (and any other remaining vertices) since they are unreachable

            //look at distances to each neighbour
            for (Map.Entry<Interseccion, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //the neighbour in this iteration

                final int alternateDist = u.dist + a.getValue(); //Distancia hasta el vertices acutal + distancia hasta el vecino
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

    /**
     * Retorna la distancia recorrida hasta el nodo final dado
     * @param endName El nombre del vertice final
     * @return La distancia
     */
    public int getDistanciaRecorrida(String endName){
        int distancia =0;
        if(!graph.containsKey(endName)){
            System.err.printf("El grafo no contiene vertice final con nombre: \"%s\"n", endName);
        }
        else{
            distancia = graph.get(endName).getDistanciaRecorrida();
        }
        return distancia;

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
