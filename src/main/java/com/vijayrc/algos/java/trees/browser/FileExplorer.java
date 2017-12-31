package com.vijayrc.algos.java.trees.browser;


import com.vijayrc.algos.java.trees.nodes.BigNode;

import java.io.File;

public class FileExplorer {
    private BigNode<File> root;
    public FileExplorer(String path) {root = new BigNode(new File(path)); recurse(root);}

    private void recurse(BigNode<File> node) {
        for (File file : node.value().listFiles()) {
            BigNode<File> fileNode = new BigNode<>(file);
            node.addChild(fileNode);
            if (file.isDirectory()) recurse(fileNode);
        }
    }
    public boolean exists(File file) {
        if (root == null) return false;
        BigNode<File> toFind = new BigNode<>(file);
        return root.exists(toFind);
    }
}
