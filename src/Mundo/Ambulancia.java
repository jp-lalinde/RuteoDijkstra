package Mundo;

/**
 * Created by ASUS on 22/03/2016.
 */
public class Ambulancia {

    //-----------------------------------------------------------------------------------------------------------------//
    //Atributos
    //-----------------------------------------------------------------------------------------------------------------//
    private int velocidad;
    private Calle calleActual;

    //-----------------------------------------------------------------------------------------------------------------//
    //Constructor
    //-----------------------------------------------------------------------------------------------------------------//
    public Ambulancia()
    {
        velocidad =0;
        calleActual=null;
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Métodos
    //-----------------------------------------------------------------------------------------------------------------//

    /**
     * Retorna la velocidad actual de la ambulancia
     * @return La velocidad de la ambulancia
     */
    public int getVelocidad()
    {
        return velocidad;
    }

    /**
     * Establece la velocidad de la ambulancia.
     * @param velocidad La nueva velocidad
     */
    public void setVelocidad(int velocidad)
    {
        this.velocidad = velocidad;
    }

    /**
     * Retorna la calle por donde la ambulancia transita actualmente.
     * @return La calle donde transita la ambulancia.
     */
    public Calle getCalleActual()
    {
        return calleActual;
    }

    /**
     * Establece la calle por donde la ambulancia transita actualmente.
     * @param calleActual La calle por donde transita.
     */
    public void setCalleActual(Calle calleActual)
    {
        this.calleActual = calleActual;
    }
}
