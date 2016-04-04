package Mundo;

/**
 * Created by ASUS on 22/03/2016.
 */
public class Calle {

    //Constantes temporales de tamaño de carros en metros
    private static final double TAMANIO_CARRO=4.5;
    private static final double TAMANIO_ESPACIO=1;

    //-----------------------------------------------------------------------------------------------------------------//
    //Atributos
    //-----------------------------------------------------------------------------------------------------------------//
    private String interseccionOrigen;
    private String interseccionDestino;
    private boolean hayAccidente;
    private int carriles;
    private double capacidad;
    private int numeroVehiculosMaximo;
    private int numeroVehiculosMinimo;
    private double[][] tamanioVehiculos;
    private int distancia;
    private boolean ambulanciaEnTransito;

    //-----------------------------------------------------------------------------------------------------------------//
    //Constructores
    //-----------------------------------------------------------------------------------------------------------------//

    public Calle(String interseccionOrigen, String interseccionDestino,
                 int carriles, int numeroVehiculosMaximo, int numeroVehiculosMinimo,
                 double[][] tamanioVehiculos, int distancia)
    {
        this.interseccionOrigen=interseccionOrigen;
        this.interseccionDestino=interseccionDestino;
        this.carriles=carriles;
        this.numeroVehiculosMaximo=numeroVehiculosMaximo;
        this.numeroVehiculosMinimo=numeroVehiculosMinimo;
        this.tamanioVehiculos=tamanioVehiculos;
        this.distancia=distancia;
        hayAccidente=false;
        ambulanciaEnTransito=false;
        calcularCapacidad();
    }

    public Calle(String interseccionOrigen, String interseccionDestino, int distancia)
    {
        this.interseccionOrigen = interseccionOrigen;
        this.interseccionDestino = interseccionDestino;
        this.distancia = distancia;
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
        calcularCapacidad();
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
     * Retorna el número de vehículos máximo que se encontrarán en la calle.
     * @return El número de vehículos máximo.
     */
    public int getNumeroVehiculosMaximo()
    {
        return numeroVehiculosMaximo;
    }

    /**
     * Establece el número máximo de vehículos que se encontrarán en la calle.
     * @param numeroVehiculosMaximo El número de vehículos.
     */
    public void setNumeroVehiculosMaximo(int numeroVehiculosMaximo)
    {
        this.numeroVehiculosMaximo = numeroVehiculosMaximo;
    }

    /**
     * Retorna el número de vehículos mínimo que se encontrarán en la calle.
     * @return El número de vehículos mínimo.
     */
    public int getNumeroVehiculosMinimo()
    {
        return numeroVehiculosMinimo;
    }

    /**
     * Establece el número mínimo de vehículos que se encontrarán en la calle.
     * @param numeroVehiculosMinimo El número de vehículos.
     */
    public void setNumeroVehiculosMinimo(int numeroVehiculosMinimo)
    {
        this.numeroVehiculosMinimo = numeroVehiculosMinimo;
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
     * Calcula la capacidad de la calle.
     */
    public void calcularCapacidad()
    {
        double distanciaTotal = distancia*carriles;
        double tamanioCarro = TAMANIO_CARRO+TAMANIO_ESPACIO;
        double cap = distanciaTotal/tamanioCarro;
        capacidad = cap-(cap%1);
    }
}
