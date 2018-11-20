import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class MyMapMain 
{ 
   public static void main(String[] args) throws FileNotFoundException
  { 

      MyMap mp = new MyMap();
      Scanner input = new Scanner(System.in);
      String palavraDoUsuario;

      do{
            // lendo palavra que o usuário deseja buscar nos documentos    
            System.out.print("insira uma palavra: ");
            palavraDoUsuario = input.nextLine(); 

            try
            {   
                // pesquisa palavra nos documentos
                mp.pesquisa(mp.tratamento(palavraDoUsuario));
                 
            }
            catch (FileNotFoundException ex)  
            {
                System.out.print("arquivo nao encontrado");
            }

            // imprime os documentos que contem a palavra
            mp.print();

            // consulta ao usuario
            System.out.println();
            System.out.println("deseja realizar mais uma pesquisa?");
            System.out.println("digite o numero da opcao: (1)-sim  (2)-nao");
            palavraDoUsuario = input.nextLine();
            
            while(!(palavraDoUsuario.equals("1")) && !(palavraDoUsuario.equals("2")))
            {
                System.out.print("digite uma opcao valida: ");
                palavraDoUsuario = input.nextLine();
            }
            
      }while(palavraDoUsuario.equals("1"));
      
  }  
}