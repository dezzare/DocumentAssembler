package br.com.superstarsoccer.models;

import java.util.ArrayList;

public class Node {

    private ArrayList<Leaf> leaves = new ArrayList<>();
    
    public Node(){
    }
    public Node(Leaf leaf){
        this.leaves.add(leaf) ;
    }
    
    public Node(ArrayList<Leaf> leaves) {
        this.leaves = leaves;
    }
    
    public ArrayList<Leaf> getLeaves() {

        return leaves;
   }
    
    public void addLeaf(Leaf content) {
        this.leaves.add(content);
    }
    
    @Override
    public String toString() {
        return "Node{" + leaves.toString() + "} --->";
    }
    
}