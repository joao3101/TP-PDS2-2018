import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class MyMap 
{ 
    //construtor
    public MyMap()
    {
        this.documentos = new ArrayList<String>();
        this.arrayDeArquivos = new String[] {"hamlet.txt","kinglear.txt","macbeth.txt","othello.txt","romeoandjuliet.txt"};
    }
    
    public MyMap(String[] palavras)
    {
        this.documentos = new ArrayList<String>();
        this.arrayDeArquivos = palavras;
    }
    // tratamento e padronização das palavras 
    public String tratamento(String palavra)
    {   
        palavra = palavra.replaceAll("[^a-zA-Z0-9]+","");
        palavra = palavra.toLowerCase();
        return palavra;
    }

    // pesquisa a palavra nos documentos e em caso afirmativo armazena o nome dos documentos em uma lista
    public void pesquisa(String palavraDoUsuario) throws FileNotFoundException
    {
        for(String s: arrayDeArquivos)
        {
            try
            {   // passando o nome do arquivo como parâmetro
                File file = new File(s);
                Scanner scan = new Scanner(file);
                String palavra;

                // lendo palavra por palavra
                while (scan.hasNext())
                {   
                    palavra = scan.next();
                    palavra = tratamento(palavra);

                    // verificando se a palavra está contida no documento
                    if(palavraDoUsuario.equals(palavra))
                    {
                        documentos.add(s);
                        break; // impede o programa de percorrer o restante do arquivo depois que a primeira palavra foi encontrada
                    }
                }
            }
            catch (FileNotFoundException ex)  
            { 
                System.out.printf("arquivo %s nao encontrado\n", s);
            }
        }
    }
    
    // imprime a lista de documentos que contém a palavra
    public void print()
    {   
        if(documentos.size() == 0)
        {
            System.out.print("nenhum dos documentos contem a palavra");
        }
        else
        {
            Collections.sort(documentos); // coloca os elementos da lista em ordem alfabética
            for (int i=0; i<documentos.size(); i++)
            {
                System.out.printf(" %s\n", documentos.get(i));
            }
            documentos.clear(); // limpa a lista para uma eventual nova pesquisa
        }
        
    }

    private String arrayDeArquivos[];
    private ArrayList<String> documentos;
}