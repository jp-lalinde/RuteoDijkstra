package Mundo;

/**
 * Created by ASUS on 22/03/2016.
 */
public class Ambulancia {

    //-----------------------------------------------------------------------------------------------------------------//
    //Atributos
    //-----------------------------------------------------------------------------------------------------------------//
    private double velocidad;
    private Calle calleActual;

    //-----------------------------------------------------------------------------------------------------------------//
    //Constructor
    //-----------------------------------------------------------------------------------------------------------------//
    public Ambulancia()
    {
        velocidad =40;
        calleActual=null;
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Métodos
    //-----------------------------------------------------------------------------------------------------------------//

    /**
     * Retorna la velocidad actual de la ambulancia, en m/s
     * @return La velocidad de la ambulancia
     */
    public double getVelocidad()
    {
        double factor = (double)1000/3600;
        double velocidadD = velocidad*factor;
        System.out.println(factor);
        return velocidadD;
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
