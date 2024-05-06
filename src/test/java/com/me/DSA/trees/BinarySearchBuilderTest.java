package com.me.DSA.trees;

import com.me.DSA.tree.structure.BinarySearchTreeBuilder;
import com.me.DSA.tree.structure.TreeNode;
import com.me.DSA.tree.structure.impl.BinarySearchTreeBuilderImpl;
import com.me.DSA.tree.structure.impl.BinarySearchTreeImpl;
import com.me.DSA.utils.ImageViewer;
import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BinarySearchBuilderTest {

    @Test
    public void testVisualizeBST() throws IOException, InterruptedException {
        BinarySearchTreeBuilder<Integer> builder = new BinarySearchTreeBuilderImpl<>();
        Integer[] preorder = {10, 5, 1, 7, 20, 15, 25};
        BinarySearchTreeImpl<Integer> bst = builder.buildBSTFromPreorder(preorder);
        BufferedImage image = visualizeBST((BinarySearchTreeImpl<Integer>) bst);
        // You can choose to display the image or return it for an API call
        ImageViewer.displayImage(image); // Display in Swing frame

        Thread.sleep(100000);
    }

    private BufferedImage visualizeBST(BinarySearchTreeImpl<Integer> bst) throws IOException {
        MutableGraph graph = guru.nidi.graphviz.model.Factory.mutGraph("BST").setDirected(true);
        visualizeBSTHelper(graph, bst.getRoot());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Graphviz.fromGraph(graph).render(Format.PNG).toOutputStream(outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return ImageIO.read(inputStream);
    }

    private void visualizeBSTHelper(MutableGraph graph, TreeNode<Integer> node) {
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
