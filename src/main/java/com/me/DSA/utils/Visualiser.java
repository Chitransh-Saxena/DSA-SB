package com.me.DSA.utils;

import com.me.DSA.tree.structure.TreeNode;
import com.me.DSA.tree.structure.impl.BinarySearchTreeImpl;
import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Visualiser {

    public static BufferedImage visualizeBST(BinarySearchTreeImpl<Integer> bst) throws IOException {
        MutableGraph graph = guru.nidi.graphviz.model.Factory.mutGraph("BST").setDirected(true);
        visualizeBSTHelper(graph, bst.getRoot());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Graphviz.fromGraph(graph).render(Format.PNG).toOutputStream(outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return ImageIO.read(inputStream);
    }

    public static void visualizeBSTHelper(MutableGraph graph, TreeNode<Integer> node) {
        if (node != null) {
            MutableNode mutableNode = guru.nidi.graphviz.model.Factory.mutNode(String.valueOf(node.getVal()))
                    .add(Label.of(String.valueOf(node.getVal())));
            graph.add(mutableNode);

            if (node.getLeft() != null) {
                visualizeBSTHelper(graph, node.getLeft());
                MutableNode leftChild = guru.nidi.graphviz.model.Factory.mutNode(String.valueOf(node.getLeft().getVal()));
                graph.add(leftChild);
                graph.add(mutableNode.addLink(leftChild));
            }

            if (node.getRight() != null) {
                visualizeBSTHelper(graph, node.getRight());
                MutableNode rightChild = guru.nidi.graphviz.model.Factory.mutNode(String.valueOf(node.getRight().getVal()));
                graph.add(rightChild);
                graph.add(mutableNode.addLink(rightChild));
            }
        }
    }
}
