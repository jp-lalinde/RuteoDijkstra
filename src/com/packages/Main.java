package com.packages;

import java.net.*;
import java.util.Map;

import com.jgraph.layout.JGraphFacade;
import com.jgraph.layout.hierarchical.JGraphHierarchicalLayout;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgrapht.*;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.builder.DirectedWeightedGraphBuilder;

import javax.swing.*;

public class Main {

    private static DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath;

    public static void main(String[] args) {

        ListenableDirectedWeightedGraph g = createDirectedGraph();

        // note directed edges are printed as: (<v1>,<v2>)
        System.out.println(g.toString());
        System.out.println("////////////////////////////////////////////////");
        System.out.println(dijkstraShortestPath.getPath().toString());



        JGraph jGraph =  new JGraph(new JGraphModelAdapter(g));

        final JGraphHierarchicalLayout hir = new JGraphHierarchicalLayout();
        final JGraphFacade graphFacade = new JGraphFacade(jGraph);
        hir.run(graphFacade);
        final Map nestedMap = graphFacade.createNestedMap(true, true);
        jGraph.getGraphLayoutCache().edit(nestedMap);

        JScrollPane scrollPane = new JScrollPane(jGraph);
        scrollPane.setSize(800,800);
        JFrame frame = new JFrame();
        frame.getContentPane().add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    /**
     * Crea un grafo dirigido
     * @return un grafo dirigido
     */
    public static ListenableDirectedWeightedGraph<String, DefaultWeightedEdge> createDirectedGraph()
    {
        ListenableDirectedWeightedGraph<String,DefaultWeightedEdge> g =
                new ListenableDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

        String v1 = "V1";
        String v2 = "V2";
        String v3 = "V3";
        String v4 = "V4";
        String v5 = "V5";
        String v6 = "V6";
        String v7 = "V7";

        // add the vertices
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);

        // add edges to create linking structure
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v1,v4);
        g.addEdge(v2,v3);
        g.addEdge(v3,v5);
        g.addEdge(v3,v6);
        g.addEdge(v3,v7);
        g.addEdge(v4,v5);
        g.addEdge(v5,v7);
        g.addEdge(v6,v7);

        //Add weights to edges
        g.setEdgeWeight(g.getEdge(v1,v2),10);
        g.setEdgeWeight(g.getEdge(v1,v3),30);
        g.setEdgeWeight(g.getEdge(v1,v4),20);
        g.setEdgeWeight(g.getEdge(v2,v3),15);
        g.setEdgeWeight(g.getEdge(v3,v5),8);
        g.setEdgeWeight(g.getEdge(v3,v6),9);
        g.setEdgeWeight(g.getEdge(v3,v7),18);
        g.setEdgeWeight(g.getEdge(v4,v5),5);
        g.setEdgeWeight(g.getEdge(v5,v7),10);
        g.setEdgeWeight(g.getEdge(v6,v7),12);

        dijkstraShortestPath=new DijkstraShortestPath<String, DefaultWeightedEdge>(g, v1,v7);

        return g;
    }



}

