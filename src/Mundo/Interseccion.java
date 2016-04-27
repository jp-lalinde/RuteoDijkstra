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

    private List<Calle> callesSalen;
    private List<Calle> callesEntran;
    private boolean isInterseccionInicial;
    private boolean isInterseccionFinal;

    private String nombre;
    public Interseccion previous = null;
    public int dist = Integer.MAX_VALUE;
    public final Map<Interseccion, Integer> neighbours = new HashMap<>();

    //-----------------------------------------------------------------------------------------------------------------//
    //Constructores
    //-----------------------------------------------------------------------------------------------------------------//

    public Interseccion(List<Calle> callesSalen, List<Calle>callesEntran, boolean isInterseccionInicial, boolean isInterseccionFinal )
    {
        this.callesEntran = callesEntran;
        this.callesSalen = callesSalen;
        this.isInterseccionInicial = isInterseccionInicial;
        this.isInterseccionFinal = isInterseccionFinal;
    }

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

    /**
     * Retorna las calles de entrada.
     * @return Lista de calles que entran a la intersección
     */
    public List<Calle> getCallesEntran()
    {
        return callesEntran;
    }

    /**
     * Retorna las calles de salida.
     * @return Lista de calles que salen de la intersección
     */
    public List<Calle> getCallesSalen()
    {
        return callesSalen;
    }

    /**
     * Establece las calles de salida dada una lista
     * @param callesSalen Lista de calles que salen de la intersección
     */
    public void setCallesSalen(List<Calle> callesSalen)
    {
        this.callesSalen = callesSalen;
    }

    /**
     * Establece las calles de entrada dada una lista
     * @param callesEntran Lista de calles que entran a la intersección
     */
    public void setCallesEntran(List<Calle> callesEntran)
    {
        this.callesEntran = callesEntran;
    }

    /**
     * Verifica el valor de verdad asociado a si la intersección es inicial.
     * @return True es la intersección inicial, False de lo contrario.
     */
    public boolean isInterseccionInicial()
    {
        return isInterseccionInicial;
    }

    /**
     * Establece el valor de verdad asociado a si la intersección inicial.
     * @param interseccionInicial Valor de verdad sobre la intersección inicial.
     */
    public void setInterseccionInicial(boolean interseccionInicial)
    {
        this.isInterseccionInicial = interseccionInicial;
    }

    /**
     * Verifica el valor de verdad asociado a si la intersección es final.
     * @return True si es la intersección final, False de lo contrario.
     */
    public boolean isInterseccionFinal()
    {
        return isInterseccionFinal;
    }

    /**
     * Establece el valor de verdad asociado a si la intersección es final.
     * @param interseccionFinal Valor de verdad sobre la intersección final.
     */
    public void setInterseccionFinal(boolean interseccionFinal)
    {
        isInterseccionFinal = interseccionFinal;
    }

    /**
     * Añade una calle de salida a la lista de calles de salida de la intersección.
     * @param calle La calle a añadir.
     */
    public void addCalleSalida(Calle calle)
    {
        callesSalen.add(calle);
    }

    /**
     * Añade una calle de entrada a la lista de calles de entrada de la intersección.
     * @param calle La calle a añadir.
     */
    public void addCalleEntrada(Calle calle)
    {
        callesEntran.add(calle);
    }

    public void printPath() {
        if (this == this.previous) {
            System.out.printf("%s", this.nombre);
        } else if (this.previous == null) {
            System.out.printf("%s(unreached)", this.nombre);
        } else {
            this.previous.printPath();
            System.out.printf(" -> %s(%d)", this.nombre, this.dist);
        }
    }

    public int compareTo(Interseccion other)
    {
        return Integer.compare(dist, other.dist);
    }

    /**
     * Retorna la distancia recorrida hasta esta intersección
     * @return La distancia
     */
    public int getDistanciaRecorrida()
    {
       return this.dist;
    }
}
