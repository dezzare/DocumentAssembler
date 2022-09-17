package br.com.superstarsoccer.models;

import java.util.ArrayList;
import java.util.LinkedList;

public class Document {
    
    protected final LinkedList<Node> document;
    
    
    public Document() {
        document = new LinkedList<>();
    }
    
    public LinkedList<Node> getDocument() {
        return document;
    }
    
    public Node getFirstNode(){
        return document.getFirst();
    }
    
    public Node getNodeByIndex(int index){
        return document.get(index);
    }
    
    public int getSize(){
        return document.size();
    }
    
    public boolean isLast(Node node){
        return (document.indexOf(node)+1 == document.size()) ? true : false;
    }
    
    public void addBranch(Node node){
        document.add(node);
    }
    
    public void addBranchIntoIndex(int index, Node node){
        document.add(index, node);
    }
    
    public void removeBranchByName(Node node){
        document.remove(node);
    }
    
    public void removeBranchByIndex(int index){
        document.remove(index);
    }
    
    @Override
    public String toString() {
        String returnString = "";
        for(int i = 0; i < document.size(); i++){
            returnString += "[Nó "+i+"]";
            Node auxNode = this.getNodeByIndex(i);
            ArrayList<Leaf> leaves = auxNode.getLeaves();
            for(Leaf leaf : leaves){
                returnString += "\n" +
                        "   Leaf " + leaves.indexOf(leaf) + leaf.toString() + " ";
            }
            returnString += "\n";
        }
        returnString += "end\n";
        return returnString;
    }
}
