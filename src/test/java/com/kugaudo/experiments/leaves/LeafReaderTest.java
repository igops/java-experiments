package com.kugaudo.experiments.leaves;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.kugaudo.experiments.leaves.Leaf;
import com.kugaudo.experiments.leaves.LeafReader;

public class LeafReaderTest {

    private LeafReader reader = new LeafReader();
    
    @Test
    public void testRead() {
        Leaf tree;
        List<Leaf> childs;
        
        tree = reader.read("1");
        assertEquals(1, tree.getValue());
        assertEquals(0, tree.getChilds().size());
        
        tree = reader.read("1;2;3");
        assertEquals(1, tree.getValue());
        childs = tree.getChilds();
        assertEquals(1, childs.size());
        assertEquals(2, childs.get(0).getValue());
        childs = childs.get(0).getChilds();
        assertEquals(1, childs.size());
        assertEquals(3, childs.get(0).getValue());
        childs = childs.get(0).getChilds();
        assertEquals(0, childs.size());
        
        tree = reader.read("3;2,5,4;1,2;3,7");
        assertEquals(3, tree.getValue());
        childs = tree.getChilds();
        assertEquals(3, childs.size());
        assertEquals(2, childs.get(0).getValue());
        assertEquals(5, childs.get(1).getValue());
        assertEquals(4, childs.get(2).getValue());
        childs = tree.getChilds().get(0).getChilds();
        assertEquals(2, childs.size());
        assertEquals(1, childs.get(0).getValue());
        assertEquals(2, childs.get(1).getValue());
        childs = tree.getChilds().get(1).getChilds();
        assertEquals(2, childs.size());
        assertEquals(3, childs.get(0).getValue());
        assertEquals(7, childs.get(1).getValue());
        assertEquals(4, tree.getChilds().get(2).getValue());
        childs = tree.getChilds().get(2).getChilds();
        assertEquals(0, childs.size());
        
        tree = reader.read("  3 ; 2, 5,   4;   1, 2  ;3   , 7 ");
        assertEquals(3, tree.getValue());
        childs = tree.getChilds();
        assertEquals(3, childs.size());
        assertEquals(2, childs.get(0).getValue());
        assertEquals(5, childs.get(1).getValue());
        assertEquals(4, childs.get(2).getValue());
        childs = tree.getChilds().get(0).getChilds();
        assertEquals(2, childs.size());
        assertEquals(1, childs.get(0).getValue());
        assertEquals(2, childs.get(1).getValue());
        childs = tree.getChilds().get(1).getChilds();
        assertEquals(2, childs.size());
        assertEquals(3, childs.get(0).getValue());
        assertEquals(7, childs.get(1).getValue());
        childs = tree.getChilds().get(2).getChilds();
        assertEquals(0, childs.size());

    }
    
}
