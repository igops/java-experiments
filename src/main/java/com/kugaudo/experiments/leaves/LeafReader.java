package com.kugaudo.experiments.leaves;

import java.util.ArrayList;
import java.util.List;

public class LeafReader {
    
    /**
     * Reads a tree.
     * 
     * E.g. 
     * 3; 2,5,4; 8,2; 3,7
     * 
     * is being interpreted as
     * 
     *       3
     *     / | \
     *    2  5  4
     *   /|  |\
     *  8 2  3 7
     *  
     * TODO: implement empty nodes in the middle of a level (e.g. using a dash)
     *  
     * @param data - an actual string
     * @return a tree
     */
    Leaf read(String data) {
        String[] rows = data.split(";");

        Leaf root = new Leaf(Integer.valueOf(rows[0].trim()));
        List<Leaf> unprocessed = new ArrayList<>();
        unprocessed.add(root);

        for (int i = 1; i < rows.length; i++) {
            String row = rows[i];
            String[] values = row.trim().split(",");
            for (String value : values) {
                int v = Integer.valueOf(value.trim());
                Leaf child = new Leaf(v);
                unprocessed.get(0).addChild(child);
                unprocessed.add(child);
            }
            unprocessed.remove(0);
        }
        return root;
    }
    
}
