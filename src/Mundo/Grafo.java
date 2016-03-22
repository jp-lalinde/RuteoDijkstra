package Mundo;

import java.util.List;

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

    //-----------------------------------------------------------------------------------------------------------------//
    //Constructores
    //-----------------------------------------------------------------------------------------------------------------//

    public Grafo ()
    {
        //TODO Inicializar un grafo
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

    public void calcularRutaDijkstra()
    {
        //TODO Calcula dijkstra
    }

    public void iniciarThreadRuteo()
    {
        //TODO Construir thread
    }
}
