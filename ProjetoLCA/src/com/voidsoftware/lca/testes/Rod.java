package com.voidsoftware.lca.testes;

import java.io.*;
//Importa pacotes para a criação de sockets.
import java.net.*;

/**
*
* @author Danilo
*/
public class Rod {
  
  /** Cria uma nova instância de Main */
  public Rod() {
  }
  
  /**
   * @param args argumentos da linha de comando
   */
  public static void main(String[] args) throws Exception {
     
	  while(true){
	  
	  try {
          //Crio um socket
//          Socket socket = new Socket("127.0.0.1", 8800);
          Socket socket = new Socket("192.2.71.52", 8800);        
          //Crio o fluxo para o envio de dados
          OutputStream saida = socket.getOutputStream();
          
          PrintStream escrita = new PrintStream(saida);
          
          if(args.length > 0) {
              //Envio a string passada
              escrita.println(args[0]);
              
          } else {
              escrita.println("03-07-2012 18:02:37R03P00404564");
              //Thread.sleep(250);
          } 
       
		
		
      //Caso não encontre o host    
      } catch (UnknownHostException ex) {
          ex.printStackTrace();
      //Caso ocorra alguma exceção na criação do fluxo
      } catch (IOException ex) {
          ex.printStackTrace();
      }
      
	  }
   }
}