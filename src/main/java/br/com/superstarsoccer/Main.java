package br.com.superstarsoccer;

import br.com.superstarsoccer.models.Document;
import br.com.superstarsoccer.models.Leaf;
import br.com.superstarsoccer.models.Node;
import br.com.superstarsoccer.services.DocumentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Document allejo = new Document();
    
        int option;
        boolean exit = false;
        Scanner scannerInput = new Scanner(System.in);
        do {
        
            System.out.println("+---------------------------------+");
            System.out.println("| Bem vindo ao Document Assembler |");
            System.out.println("+---------------------------------+");
            System.out.println("|     Escolha uma das opções      |");
            System.out.println("|                                 |");
            System.out.println("| 1 - Executar teste rápido       |");
            System.out.println("| 2 - Adicionar Branch            |");
            System.out.println("| 3 - Adicionar Leaf              |");
            System.out.println("| 4 - Imprimir na tela            |");
            System.out.println("| 5 - Escrever arquivo output.txt |");
            System.out.println("| 9 - Sair                        |");
            System.out.println("+---------------------------------+");
        
            option = scannerInput.nextInt();
        
            switch (option) {
                case 1 -> {
                    System.out.println("Executando teste preconfigurado: ");
                    teste(allejo);
                }
                case 2 -> {
                    Node tmp = new Node();
                    allejo.addBranch(tmp);
                    System.out.println("Branch adicionado\n");
                }
                case 3 -> {
                    System.out.print("Digite o índex do Branch a ser adicionado a Leaf: ");
                    int index = scannerInput.nextInt();
                    try {
                        Node auxNode = allejo.getNodeByIndex(index);
                        System.out.print("Digite o coteúdo da Leaf: ");
                        String garbage = scannerInput.nextLine();
                        Leaf content = new Leaf(scannerInput.nextLine());
                        auxNode.addLeaf(content);
                        System.out.println("Leaf adicionada\n");
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
                case 4 -> {
                    System.out.println(allejo.toString() + "\n");
                }
                case 5 -> {
                    DocumentService documentFinal = new DocumentService(allejo);
                    documentFinal.assemble();
                    System.out.println("Documento salvo como output.txt");
                }
                case 9 -> exit = true;
                default -> System.out.println("Você não selecionou uma opção válida");
            }
        } while(!exit);
    
    }
    public static void teste (Document doc) {
        Leaf leafNode1 = new Leaf("Folha1");
        Node node1 = new Node(leafNode1);
        
        doc.addBranch(node1);
        
        Leaf leafNode2 = new Leaf("Folha2");
        node1.addLeaf(leafNode2);
        
        Node node2 = new Node(leafNode2);
        doc.addBranch(node2);
        
        System.out.println(doc.toString());
        
        DocumentService documentFinal = new DocumentService(doc);
        documentFinal.assemble();
    }
    
    
}