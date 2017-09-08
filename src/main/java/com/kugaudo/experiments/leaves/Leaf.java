package com.kugaudo.experiments.leaves;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Leaf {

    private int value;
    private List<Leaf> childs;

    public Leaf(int value) {
        this.value = value;
        this.childs = new ArrayList<>();
    }

    /**
     * Finds a branch of multiple child tree with maximum value sum using recursive java stream.
     * @return sum
     */
    public int maxBranchSumUsingStream() {
        Optional<Integer> max = childs.stream()
                .map(Leaf::maxBranchSumUsingStream)
                .reduce(Integer::max);
        return value + (max.isPresent() ? max.get() : 0);
    }

    /**
     * Finds a branch of multiple child tree with maximum value sum using recursive loop
     * @return sum
     */
    public int maxBranchSumUsingLoop() {
        Integer max = null;
        for (Leaf child : childs) {
            int sum = child.maxBranchSumUsingLoop();
            if (max == null || sum > max) {
                max = sum;
            }
        }
        return value + (max == null ? 0 : max);
    }
    
    /**
     * Finds a maximum value in a branch using recursive java stream
     * @return
     */
    public int maxValueUsingStream() {
        Optional<Integer> max = childs.stream()
                .map(Leaf::maxValueUsingStream)
                .reduce(Integer::max);
        if (!max.isPresent() || value > max.get()) {
            return value;
        }
        return max.get();
    }

    /**
     * Finds a maximum value in a branch using recursive loop
     * @return
     */
    public int maxValueUsingLoop() {
        Integer max = null;
        for (Leaf child : childs) {
            int branchMax = child.maxValueUsingLoop();
            if (max == null || branchMax > max) {
                max = branchMax;
            }
        }
        if (max == null || value > max) {
            return value;
        }
        return max;
    }

    public int getValue() {
        return value;
    }

    public List<Leaf> getChilds() {
        return childs;
    }
    
    public void addChild(Leaf leaf) {
        childs.add(leaf);
    }
}
