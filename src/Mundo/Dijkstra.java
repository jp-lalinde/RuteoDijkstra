package Mundo;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by usuario on 3/28/2016.
 */
public class Dijkstra {


    private static final String START = "a";
    private static final String END = "t'";
    private static double tBarDijkstraSencillo = 0;
    private static double tBarDijkstraPonderado = 0;

    public static void main(String[] args) {
        Calle[] GRAPH = inicializarGrafoBase();
        Calle[] calles = inicializarDobleVia(GRAPH);

        //Escenarios
//        for(int i=0;i<calles.length;i++)
//        {
//            calles[i].setCarriles(1);
//            calles[i].setOcupacionMaxima(0.7);
//            calles[i].setOcupacionMinima(0.9);
//        }

        //DIJKSTRA SENCILLO

        ArrayList tiemposDijkstraTradicional = new ArrayList();
        ArrayList tiemposDijkstraPonderado = new ArrayList();


        for(int i=0;i<100;i++)
        {
            for(int j =0;j<calles.length;j++)
            {
                calles[j].randomizeOcupacion();
                calles[j].calcularPesoPonderado();
            }
            Grafo g = new Grafo(calles);
//            System.out.println("PRUEBA "+(i+1));
//            System.out.println();

            //DIJKSTRA SENCILLO
//            System.out.println("Dijkstra Tradicional");
            g.dijkstra(START);
//            g.printPath(END);
//            System.out.println("El tiempo total de recorrido es: "+g.getTiempoRecorridoDijkstraTradicional(END)+" segundos");
//            System.out.println();
//            tBarDijkstraSencillo+=g.getTiempoRecorridoDijkstraTradicional(END);
            tiemposDijkstraTradicional.add(g.getTiempoRecorridoDijkstraTradicional(END));

            //DIJKSTRA PONDERADO
//            System.out.println("Dijkstra Ponderado");
            long startTime = System.nanoTime();
            g.dijkstraPonderado(START);
            long endTime = System.nanoTime() - startTime;
            double segundos = (double) endTime / 1000000000;
//            g.printPathPonderado(END);
            tiemposDijkstraPonderado.add(g.getTiempoRecorrido(END));
//            System.out.println("El tiempo total de recorrido es: "+g.getTiempoRecorrido(END)+" segundos");
//            System.out.println("El tiempo que tomó en correr Dijkstra Ponderado fue: ");
//            System.out.println(endTime+" nanosegundos");
//            System.out.println(segundos+" segundos");
//            System.out.println();
//            tBarDijkstraPonderado+=g.getTiempoRecorrido(END);
        }

        //System.out.println("Tiempo Promedio Dijkstra Tradicional: "+tBarDijkstraSencillo/100+" segundos");
        //System.out.println("Tiempo Promedio Dijkstra Ponderado: "+tBarDijkstraPonderado/100+" segundos");
        System.out.println("TRADICIONAL");
        for(int i=0;i<tiemposDijkstraTradicional.size();i++)
        {
            System.out.println(tiemposDijkstraTradicional.get(i));
        }
        System.out.println("PONDERADO");
        for (int i=0;i<tiemposDijkstraPonderado.size();i++)
        {
            System.out.println(tiemposDijkstraPonderado.get(i));
        }

        //g.printAllPaths();
    }

    public static Calle[] inicializarGrafoBase()
    {
         Calle[] GRAPH =
            {
                    //Nodo A
                    new Calle("a", "b", 21, Constantes.TRAFICO_BAJO, 2),
                    //Nodo B
                    new Calle("b", "c", 23, Constantes.TRAFICO_BAJO, 2),
                    new Calle("b", "g", 34, Constantes.TRAFICO_BAJO, 1), //3
                    //Nodo C
                    new Calle("c", "d", 22, Constantes.TRAFICO_BAJO, 2),
                    new Calle("c", "f", 23, Constantes.TRAFICO_BAJO, 1), //5
                    //Nodo D
                    new Calle("d", "e", 10, Constantes.TRAFICO_BAJO, 1), //6
                    //Nodo E
                    new Calle("e", "f", 20, Constantes.TRAFICO_BAJO, 1),
                    new Calle("e", "d", 10, Constantes.TRAFICO_BAJO, 1), //8
                    //Nodo F
                    new Calle("f", "c", 23, Constantes.TRAFICO_BAJO, 1), //9
                    new Calle("f", "g", 21, Constantes.TRAFICO_BAJO, 1),
                    new Calle("f", "w", 33, Constantes.TRAFICO_MEDIO, 1),
                    //Nodo G
                    new Calle("g", "b", 34, Constantes.TRAFICO_BAJO, 1),  //12
                    new Calle("g", "h", 31, Constantes.TRAFICO_BAJO, 1),
                    new Calle("g", "v", 29, Constantes.TRAFICO_MEDIO, 2),
                    //Nodo H
                    new Calle("h", "a", 41, Constantes.TRAFICO_BAJO, 2),
                    new Calle("h", "i", 9, Constantes.TRAFICO_BAJO, 1), //16
                    new Calle("h", "j", 11, Constantes.TRAFICO_MEDIO, 2), //17
                    //Nodo I
                    new Calle("i", "h", 9, Constantes.TRAFICO_BAJO, 1), //18
                    new Calle("i", "k", 11, Constantes.TRAFICO_BAJO, 2), //19
                    //Nodo J
                    new Calle("j", "h", 11, Constantes.TRAFICO_MEDIO, 2), //20
                    new Calle("j", "k", 8, Constantes.TRAFICO_MEDIO, 2), //21
                    new Calle("j", "l", 16, Constantes.TRAFICO_MEDIO, 2), //22
                    //Nodo K
                    new Calle("k", "j", 8, Constantes.TRAFICO_MEDIO, 2), //23
                    new Calle("k", "i", 11, Constantes.TRAFICO_BAJO, 2), //24
                    new Calle("k", "n", 14, Constantes.TRAFICO_BAJO, 2),
                    //Nodo L
                    new Calle("l", "j", 16, Constantes.TRAFICO_MEDIO, 2), //26
                    new Calle("l", "m", 15, Constantes.TRAFICO_BAJO, 2), //27
                    new Calle("l", "v", 8, Constantes.TRAFICO_ALTO, 2), //28
                    //Nodo M
                    new Calle("m", "l", 15, Constantes.TRAFICO_BAJO, 2), //29
                    new Calle("m", "n", 23, Constantes.TRAFICO_BAJO, 1), //30
                    new Calle("m", "p", 14, Constantes.TRAFICO_BAJO, 2), //31
                    //Nodo N
                    new Calle("n", "m", 23, Constantes.TRAFICO_BAJO, 1), //32
                    new Calle("n", "o", 13, Constantes.TRAFICO_BAJO, 2),
                    //Nodo O
                    new Calle("o", "p", 24, Constantes.TRAFICO_BAJO, 1), //34
                    new Calle("o", "q", 44, Constantes.TRAFICO_BAJO, 2),
                    //Nodo P
                    new Calle("p", "m", 14, Constantes.TRAFICO_BAJO, 2), //36
                    new Calle("p", "r", 38, Constantes.TRAFICO_BAJO, 2), //37
                    new Calle("p", "o", 24, Constantes.TRAFICO_BAJO, 1), //38
                    //Nodo Q
                    new Calle("q", "r", 36, Constantes.TRAFICO_BAJO, 2), //39
                    //Nodo R
                    new Calle("r", "p", 38, Constantes.TRAFICO_BAJO, 2), //40
                    new Calle("r", "u", 30, Constantes.TRAFICO_MEDIO, 3), //41
                    new Calle("r", "s", 28, Constantes.TRAFICO_BAJO, 1), //42
                    new Calle("r", "q", 36, Constantes.TRAFICO_BAJO, 2), //43
                    //Nodo S
                    new Calle("s", "r", 28, Constantes.TRAFICO_BAJO, 1), //44
                    new Calle("s", "t", 31, Constantes.TRAFICO_BAJO, 2), //45
                    //Nodo T
                    new Calle("t", "s", 31, Constantes.TRAFICO_BAJO, 2), //46
                    new Calle("t", "u", 30, Constantes.TRAFICO_MEDIO, 3),
                    //Nodo U
                    new Calle("u", "r", 30, Constantes.TRAFICO_MEDIO, 3), //48
                    new Calle("u", "x", 120, Constantes.TRAFICO_MEDIO, 3),
                    //Nodo V
                    new Calle("v", "g", 29, Constantes.TRAFICO_MEDIO, 2), //50
                    new Calle("v", "w", 21, Constantes.TRAFICO_ALTO, 2), //51
                    new Calle("v", "l", 8, Constantes.TRAFICO_ALTO, 2), //52
                    //Nodo W
                    new Calle("w", "x", 19, Constantes.TRAFICO_ALTO, 2), //53
                    new Calle("w", "f", 33, Constantes.TRAFICO_MEDIO, 1), //54
                    new Calle("w", "v", 21, Constantes.TRAFICO_ALTO, 2), //55
                    //Nodo X
                    new Calle("x", "w", 19, Constantes.TRAFICO_ALTO, 2), //56
                    new Calle("x", "z", 38, Constantes.TRAFICO_MEDIO, 2),
                    new Calle("x", "g'", 101, Constantes.TRAFICO_ALTO, 2), //58
                    //Nodo Y
                    new Calle("y", "x", 38, Constantes.TRAFICO_ALTO, 2),
                    new Calle("y", "j'", 41, Constantes.TRAFICO_ALTO, 2), //60
                    //Nodo Z
                    new Calle("z", "d'", 27, Constantes.TRAFICO_BAJO, 2),
                    new Calle("z", "a'", 36, Constantes.TRAFICO_MEDIO, 2),
                    //Nodo A'
                    new Calle("a'", "e'", 34, Constantes.TRAFICO_BAJO, 2), //63
                    new Calle("a'", "b'", 46, Constantes.TRAFICO_MEDIO, 2),
                    //Nodo B'
                    new Calle("b'", "c'", 51, Constantes.TRAFICO_ALTO, 2), //65
                    new Calle("b'", "p'", 45, Constantes.TRAFICO_MEDIO, 2),
                    new Calle("b'", "y", 81, Constantes.TRAFICO_ALTO, 2),
                    //Nodo C'
                    new Calle("c'", "b'", 51, Constantes.TRAFICO_ALTO, 2), //68
                    new Calle("c'", "m'", 82, Constantes.TRAFICO_ALTO, 2), //69
                    //Nodo D'
                    new Calle("d'", "e'", 35, Constantes.TRAFICO_BAJO, 2), //70
                    //Nodo E'
                    new Calle("e'", "d'", 35, Constantes.TRAFICO_BAJO, 2), //71
                    new Calle("e'", "f'", 51, Constantes.TRAFICO_BAJO, 2), //72
                    new Calle("e'", "a'", 34, Constantes.TRAFICO_BAJO, 2), //73
                    //Nodo F'
                    new Calle("f'", "e'", 51, Constantes.TRAFICO_BAJO, 2), //74
                    new Calle("f'", "b'", 35, Constantes.TRAFICO_BAJO, 2),
                    //Nodo G'
                    new Calle("g'", "h'", 62, Constantes.TRAFICO_ALTO, 2),
                    //Nodo H'
                    new Calle("h'", "i'", 68, Constantes.TRAFICO_ALTO, 2),
                    //Nodo I'
                    new Calle("i'", "t'", 44, Constantes.TRAFICO_ALTO, 2),
                    //Nodo J'
                    new Calle("j'", "y", 41, Constantes.TRAFICO_ALTO, 2), //79
                    new Calle("j'", "p'", 80, Constantes.TRAFICO_MEDIO, 2), //80
                    new Calle("j'", "k'", 32, Constantes.TRAFICO_MEDIO, 2), //81
                    //Nodo K'
                    new Calle("k'", "j'", 32, Constantes.TRAFICO_MEDIO, 2), //82
                    new Calle("k'", "q'", 79, Constantes.TRAFICO_BAJO, 2), //83
                    new Calle("k'", "l'", 51, Constantes.TRAFICO_MEDIO, 2), //84
                    //Nodo L'
                    new Calle("l'", "k'", 51, Constantes.TRAFICO_MEDIO, 2), //85
                    new Calle("l'", "r'", 79, Constantes.TRAFICO_BAJO, 2), //86
                    new Calle("l'", "t'", 57, Constantes.TRAFICO_MEDIO, 2), //87
                    //Nodo M'
                    new Calle("m'", "q'", 64, Constantes.TRAFICO_MEDIO, 1), //88
                    new Calle("m'", "c'", 82, Constantes.TRAFICO_ALTO, 2), //89
                    new Calle("m'", "n'", 85, Constantes.TRAFICO_ALTO, 2), //90
                    //Nodo N'
                    new Calle("n'", "r'", 63, Constantes.TRAFICO_MEDIO, 1), //91
                    new Calle("n'", "m'", 85, Constantes.TRAFICO_ALTO, 2), //92
                    new Calle("n'", "o'", 82, Constantes.TRAFICO_ALTO, 2), //93
                    //Nodo O'
                    new Calle("o'", "n'", 82, Constantes.TRAFICO_ALTO, 2), //94
                    new Calle("o'", "s'", 65, Constantes.TRAFICO_MEDIO,1), //95
                    //Nodo P'
                    new Calle("p'", "j'", 80, Constantes.TRAFICO_MEDIO, 2),
                    new Calle("p'", "q'", 36, Constantes.TRAFICO_MEDIO, 2),
                    //Nodo Q'
                    new Calle("q'", "k'", 79, Constantes.TRAFICO_MEDIO, 2), //98
                    new Calle("q'", "m'", 64, Constantes.TRAFICO_MEDIO, 1), //99
                    new Calle("q'", "r'", 84, Constantes.TRAFICO_MEDIO, 2),
                    //Nodo R'
                    new Calle("r'", "l'", 79, Constantes.TRAFICO_MEDIO, 2), //101
                    new Calle("r'", "n'", 63, Constantes.TRAFICO_MEDIO, 1), //102
                    new Calle("r'", "s'", 82, Constantes.TRAFICO_MEDIO, 2),
                    //Nodo S'
                    new Calle("s'", "t'", 80, Constantes.TRAFICO_MEDIO, 2), //104
                    new Calle("s'", "o'", 65, Constantes.TRAFICO_MEDIO, 1), //105
                    //Nodo T'
                    new Calle("t'", "i'", 44, Constantes.TRAFICO_ALTO, 2), //106
                    new Calle("t'", "l'", 57, Constantes.TRAFICO_MEDIO, 2), //107
                    new Calle("t'", "s'", 80, Constantes.TRAFICO_MEDIO, 1) //108

            };
        return GRAPH;
    }

    public static Calle[] inicializarDobleVia(Calle[] calles1)
    {
        Calle[] calles = calles1;
        calles[2].setDobleVia(true);
        calles[4].setDobleVia(true);
        calles[5].setDobleVia(true);
        calles[7].setDobleVia(true);
        calles[8].setDobleVia(true);
        calles[11].setDobleVia(true);
        calles[15].setDobleVia(true);
        calles[16].setDobleVia(true);
        calles[17].setDobleVia(true);
        calles[18].setDobleVia(true);
        calles[19].setDobleVia(true);
        calles[20].setDobleVia(true);
        calles[21].setDobleVia(true);
        calles[22].setDobleVia(true);
        calles[23].setDobleVia(true);
        calles[25].setDobleVia(true);
        calles[26].setDobleVia(true);
        calles[27].setDobleVia(true);
        calles[28].setDobleVia(true);
        calles[29].setDobleVia(true);
        calles[30].setDobleVia(true);
        calles[31].setDobleVia(true);
        calles[33].setDobleVia(true);
        calles[35].setDobleVia(true);
        calles[36].setDobleVia(true);
        calles[37].setDobleVia(true);
        calles[38].setDobleVia(true);
        calles[39].setDobleVia(true);
        calles[40].setDobleVia(true);
        calles[41].setDobleVia(true);
        calles[42].setDobleVia(true);
        calles[43].setDobleVia(true);
        calles[44].setDobleVia(true);
        calles[45].setDobleVia(true);
        calles[47].setDobleVia(true);
        calles[49].setDobleVia(true);
        calles[50].setDobleVia(true);
        calles[51].setDobleVia(true);
        calles[52].setDobleVia(true);
        calles[53].setDobleVia(true);
        calles[54].setDobleVia(true);
        calles[55].setDobleVia(true);
        calles[57].setDobleVia(true);
        calles[59].setDobleVia(true);
        calles[62].setDobleVia(true);
        calles[64].setDobleVia(true);
        calles[67].setDobleVia(true);
        calles[68].setDobleVia(true);
        calles[69].setDobleVia(true);
        calles[70].setDobleVia(true);
        calles[71].setDobleVia(true);
        calles[72].setDobleVia(true);
        calles[73].setDobleVia(true);
        calles[78].setDobleVia(true);
        calles[79].setDobleVia(true);
        calles[80].setDobleVia(true);
        calles[81].setDobleVia(true);
        calles[82].setDobleVia(true);
        calles[83].setDobleVia(true);
        calles[84].setDobleVia(true);
        calles[85].setDobleVia(true);
        calles[86].setDobleVia(true);
        calles[87].setDobleVia(true);
        calles[88].setDobleVia(true);
        calles[89].setDobleVia(true);
        calles[90].setDobleVia(true);
        calles[91].setDobleVia(true);
        calles[92].setDobleVia(true);
        calles[93].setDobleVia(true);
        calles[94].setDobleVia(true);
        calles[97].setDobleVia(true);
        calles[98].setDobleVia(true);
        calles[100].setDobleVia(true);
        calles[101].setDobleVia(true);
        calles[103].setDobleVia(true);
        calles[104].setDobleVia(true);
        calles[105].setDobleVia(true);
        calles[106].setDobleVia(true);
        calles[107].setDobleVia(true);

        return calles;
    }

}
