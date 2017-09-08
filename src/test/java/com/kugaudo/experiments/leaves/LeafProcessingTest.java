package com.kugaudo.experiments.leaves;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kugaudo.experiments.leaves.Leaf;
import com.kugaudo.experiments.leaves.LeafReader;

public class LeafProcessingTest {

    private LeafReader reader = new LeafReader();
    
    @Test
    public void testMaxBranchSum() {
        Leaf tree;

        tree = reader.read("3; 2,5,4; 1,2; 3,7");
        assertEquals(15, tree.maxBranchSumUsingStream());
        assertEquals(15, tree.maxBranchSumUsingLoop());
        
        tree = reader.read("1; 1,2;");
        assertEquals(3, tree.maxBranchSumUsingStream());
        assertEquals(3, tree.maxBranchSumUsingLoop());
        
        tree = reader.read("1; 1,1; 1,1; 1,2");
        assertEquals(4, tree.maxBranchSumUsingStream());
        assertEquals(4, tree.maxBranchSumUsingLoop());

        tree = reader.read("1; 1,1; 1,1; 1,1; 1,1; 1,1; 1,2");
        assertEquals(5, tree.maxBranchSumUsingStream());
        assertEquals(5, tree.maxBranchSumUsingLoop());
    }
    
}
