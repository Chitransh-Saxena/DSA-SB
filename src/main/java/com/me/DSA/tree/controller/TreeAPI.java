package com.me.DSA.tree.controller;


import com.me.DSA.tree.structure.BinarySearchTreeBuilder;
import com.me.DSA.tree.structure.impl.BinarySearchTreeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.me.DSA.utils.Visualiser.visualizeBST;

@RestController
public class TreeAPI {

    @Autowired
    BinarySearchTreeBuilder<Integer> builder;

    @GetMapping("/image")
    public ResponseEntity<byte[]> getImage(
            @RequestParam(required = false) String traversal,
            @RequestParam Integer[] elements
    ) throws IOException {


        // Use strategy + factory to instantiate correct tree builder or use the correct method based on traversal type

        BinarySearchTreeImpl<Integer> bst = builder.buildBSTFromPreorder(elements);
        BufferedImage image = visualizeBST(bst);

        // Write image to byte array output stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);

        // Set HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(outputStream.size());

        // Return image data in response body
        return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
    }

}
