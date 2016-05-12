package Mundo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 22/03/2016.
 */
public class Interseccion implements Comparable<Interseccion>{

    //-----------------------------------------------------------------------------------------------------------------//
    //Atributos
    //-----------------------------------------------------------------------------------------------------------------//

    private String nombre;
    private double tiempoDijkstraSencillo;
    public Interseccion previous = null;
    public double dist = Integer.MAX_VALUE;
    public final Map<Interseccion, Double> neighbours = new HashMap<>();

    //-----------------------------------------------------------------------------------------------------------------//
    //Constructores
    //-----------------------------------------------------------------------------------------------------------------//



    public Interseccion(String name)
    {
        nombre = name;
    }

    public Interseccion()
    {

    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Métodos
    //-----------------------------------------------------------------------------------------------------------------//


    public void printPath() {
        if (this == this.previous) {
            System.out.printf("%s", this.nombre);
        } else if (this.previous == null) {
            System.out.printf("%s(unreached)", this.nombre);
        } else {
            this.previous.printPath();
            System.out.printf(" -> %s(%f)", this.nombre, this.dist);
        }
    }

    public int compareTo(Interseccion other)
    {
        return Double.compare(dist, other.dist);
    }

    /**
     * Retorna el peso reocorrido hasta la intersección
     * @return La distancia
     */
    public double getPesoRecorrido()
    {
       return this.dist;
    }

    /**
     * Retorna el tiempo de recorrido para el algoritmo de Dijkstra Sencillo
     * @return Tiempo de recorrido para el algoritmo de Dijkstra sencillo
     */
    public double getTiempoDijkstraSencillo()
    {
        return tiempoDijkstraSencillo;
    }

    /**
     * Establece el tiempo de recorrido hasta la intersección, usado ÚNICAMENTE para Dijkstra Sencillo
     */
    public void setTiempoDijkstraSencillo(double tiempoDijkstraSencillo)
    {
        this.tiempoDijkstraSencillo=tiempoDijkstraSencillo;
    }
}
