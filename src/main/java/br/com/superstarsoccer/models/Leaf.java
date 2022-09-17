package br.com.superstarsoccer.models;

public class Leaf {
    private String content;
    
    public Leaf(String content) {
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        return " = " + content;
    }
    
}
