package br.com.superstarsoccer.services;

import br.com.superstarsoccer.models.Document;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class DocumentService {

    private Document documentToAseemble = null;
    
    public DocumentService(){
    }
    
    public DocumentService(Document documentToAseemble) {
        this.documentToAseemble = documentToAseemble;
    }
    
    public Document getDocumentToAseemble() {
        return documentToAseemble;
    }
    
    public void setDocumentToAseemble(Document documentToAseemble) {
        this.documentToAseemble = documentToAseemble;
    }
    
    public void assemble(){
        FileWriter outputFile = null;
        String documentOutput = documentToAseemble.toString();
    
        try {
        
            outputFile = new FileWriter( "output.txt", true );
            outputFile.write( documentOutput );
            outputFile.write("\nLog: " + LocalDate.now() + " " + LocalTime.now() + "\n");
            outputFile.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
