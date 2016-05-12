package Mundo;

/**
 * Created by ASUS on 22/03/2016.
 */
public class Calle {


    //-----------------------------------------------------------------------------------------------------------------//
    //Atributos
    //-----------------------------------------------------------------------------------------------------------------//
    private String interseccionOrigen;
    private String interseccionDestino;
    private int carriles;
    private double ocupacionMaxima;
    private double ocupacionMinima;
    private double ocupacion;
    private int distancia;
    private boolean dobleVia;
    private String tipoTrafico;
    private double pesoPonderado;

    //-----------------------------------------------------------------------------------------------------------------//
    //Constructores
    //-----------------------------------------------------------------------------------------------------------------//


    public Calle(String interseccionOrigen, String interseccionDestino, int distancia, String tipoTrafico, int carriles)
    {
        this.interseccionOrigen = interseccionOrigen;
        this.interseccionDestino = interseccionDestino;
        this.distancia = distancia;
        this.dobleVia=false;
        this.tipoTrafico=tipoTrafico;
        this.carriles=carriles;
        if(tipoTrafico==Constantes.TRAFICO_ALTO)
        {
            ocupacionMaxima= (double) 0.9;
            ocupacionMinima= (double) 0.7;
        }
        else if(tipoTrafico==Constantes.TRAFICO_MEDIO)
        {
            ocupacionMaxima= (double) 0.6;
            ocupacionMinima= (double) 0.4;
        }
        else
        {
            ocupacionMaxima= (double) 0.3;
            ocupacionMinima= (double) 0.1;
        }
    }

    //-----------------------------------------------------------------------------------------------------------------//
    //Métodos
    //-----------------------------------------------------------------------------------------------------------------//


    /**
     * Retorna la intersección origen
     * @return La intersección origen
     */
    public String getInterseccionOrigen()
    {
        return interseccionOrigen;
    }


    /**
     * Retorna la intersección destino.
     * @return La intersección destino.
     */
    public String getInterseccionDestino()
    {
        return interseccionDestino;
    }

    /**
     * Retorna la distancia en metros de la calle.
     * @return La distancia de la calle.
     */
    public int getDistancia()
    {
        return distancia;
    }

    /**
     * Retorna si la calles es doble vía
     * @return boolean
     */
    public boolean esDobleVia()
    {
        return dobleVia;
    }

    /**
     * Establece si es doble vía
     * @param dobleVia boolean que establece si es doble vía
     */
    public void setDobleVia(boolean dobleVia)
    {
        this.dobleVia = dobleVia;
    }

    /**
     * Calcula la ocupación actual de la calle
     */
    public void randomizeOcupacion()
    {
        ocupacion = ocupacionMinima + (Math.random() * (ocupacionMaxima - ocupacionMinima) );
    }

    /**
     * Calcula el peso ponderado basado en el número de carriles y la ocupación actual de la calle
     *
     */
    public void calcularPesoPonderado()
    {
        double velocidad = Constantes.VELOCIDAD_AMBULANCIA ;
        double factorOcupacion = (double) 1-ocupacion;
        double factorCarriles = 1;
        if(carriles==2)
        {
            factorCarriles+=0.2;
        }
        else if(carriles==3)
        {
            factorCarriles+=0.3;
        }
        velocidad = velocidad*factorCarriles*factorOcupacion;
        double peso = (double) distancia/velocidad;
        //System.out.println("distancia: "+distancia+" , velocidad: "+velocidad+" , tiempo: "+peso);
        pesoPonderado = peso;
        //System.out.println(pesoPonderado);
    }

    /**
     * Retorna el peso ponderado de la calle
     * @return pesoPonderado
     */
    public double getPesoPonderado()
    {
        return pesoPonderado;
    }


}
