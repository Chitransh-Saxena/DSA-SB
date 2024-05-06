package com.me.DSA.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageViewer {
    public static void displayImage(BufferedImage image) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
