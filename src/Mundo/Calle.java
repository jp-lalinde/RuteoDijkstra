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
    private boolean hayAccidente;
    private int carriles;
    private double capacidad;
    private double ocupacionMaxima;
    private double ocupacionMinima;
    private double ocupacion;
    private double[][] tamanioVehiculos;
    private int distancia;
    private boolean ambulanciaEnTransito;
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
     * Establece la intersección origen
     * @param interseccionOrigen La intersección origen
     */
    public void setInterseccionOrigen(String interseccionOrigen)
    {
        this.interseccionOrigen = interseccionOrigen;
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
     * Establece la intersección destino
     * @param interseccionDestino La intersección destino
     */
    public void setInterseccionDestino(String interseccionDestino)
    {
        this.interseccionDestino = interseccionDestino;
    }

    /**
     * Retorna el valor de verdad asociado a si hay un accidente en la calle.
     * @return True en caso de haber un accidente, False de lo contrario
     */
    public boolean isHayAccidente()
    {
        return hayAccidente;
    }

    /**
     * Establece el valor de verdad asociado a si hay un accidente en la calle
     * @param hayAccidente El valor de verdad.
     */
    public void setHayAccidente(boolean hayAccidente)
    {
        this.hayAccidente = hayAccidente;
    }

    /**
     * Retorna el número de carriles de la calle.
     * @return El número de carriles.
     */
    public int getCarriles()
    {
        return carriles;
    }

    /**
     * Establece el número de carriles de la calle.
     * @param carriles El número de carriles.
     */
    public void setCarriles(int carriles)
    {
        this.carriles = carriles;
    }

    /**
     * Retorna la capacidad (en número de vehículos) de la calle.
     * @return La capacidad de la calle.
     */
    public double getCapacidad()
    {
        return capacidad;
    }

    /**
     * Retorna la ocupación máxima que se encontrarán en la calle.
     * @return La ocupación de vehículos máximo.
     */
    public double getOcupacionMaxima()
    {
        return ocupacionMaxima;
    }

    /**
     * Establece la ocupación máxima vehículos que se encontrarán en la calle.
     * @param ocupacionMaxima La ocupación máxima vehículos.
     */
    public void setOcupacionMaxima(double ocupacionMaxima)
    {
        this.ocupacionMaxima = ocupacionMaxima;
    }

    /**
     * Retorna la ocupación mínima que se encontrarán en la calle.
     * @return la ocupación de vehículos mínimo.
     */
    public double getOcupacionMinimo()
    {
        return ocupacionMinima;
    }

    /**
     * Establec la ocupación mínima de vehículos que se encontrarán en la calle.
     * @param ocupacionMinima Ocupación mínima de vehículos.
     */
    public void setOcupacionMinima(double ocupacionMinima)
    {
        this.ocupacionMinima = ocupacionMinima;
    }

    /**
     * Retorna la matriz vehículo-tamaño
     * @return La matriz.
     */
    public double[][] getTamanioVehiculos()
    {
        return tamanioVehiculos;
    }

    /**
     * Establece la matriz vehículo-tamaño
     * @param tamanioVehiculos La matriz.
     */
    public void setTamanioVehiculos(double[][] tamanioVehiculos)
    {
        this.tamanioVehiculos = tamanioVehiculos;
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
     * Establece la distancia en metros de la calle.
     * @param distancia La distancia de la calle.
     */
    public void setDistancia(int distancia)
    {
        this.distancia = distancia;
    }

    /**
     * Retorna el valor de verdad asociado a si hay una ambulancia en la calle.
     * @return True si hay una ambulancia, False de lo contrario.
     */
    public boolean isAmbulanciaEnTransito()
    {
        return ambulanciaEnTransito;
    }

    /**
     * Establece el valor de verdad asociado a si hay una ambulancia en la calle.
     * @param ambulanciaEnTransito El nuevo valor de verdad.
     */
    public void setAmbulanciaEnTransito(boolean ambulanciaEnTransito)
    {
        this.ambulanciaEnTransito = ambulanciaEnTransito;
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
     * Retorna la ocupación de la calle
     * @return La ocupacion
     */
    public double getOcupacion()
    {
        return ocupacion;
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
