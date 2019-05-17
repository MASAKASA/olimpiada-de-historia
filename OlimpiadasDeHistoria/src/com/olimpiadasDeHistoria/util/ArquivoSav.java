package com.olimpiadasDeHistoria.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoSav {
	
    private static File arquivo = new File("BD.sav");
    private static FileReader fileReader;
    private static BufferedReader bufferedReader;
    private static FileWriter fileWriter;
    private static BufferedWriter bufferedWriter;
    
    /**
     * Essa função serve para recuperar dados de um arquivo em disco.
     */
    public static boolean recuperarDado() {
        boolean isPrimeirao = false;
        String dado = "";
        try {
        	fileReader = new FileReader(arquivo);
			bufferedReader = new BufferedReader(fileReader);
            //Recuperando dados em disco
            while(bufferedReader.ready()){
                dado += bufferedReader.readLine();
            }
            
            if (dado.equals("true")) {
            	isPrimeirao = true;
			}
            
	        //Fechando arquivo    
	        bufferedReader.close();
        }catch (FileNotFoundException e) {
			try {
                arquivo.createNewFile();
                armazenarDado("true");
                isPrimeirao = recuperarDado();//Retorna true
            } catch (IOException ex1) {
            	ex1.printStackTrace();
            }
		} catch (IOException ex) {
            ex.printStackTrace();
        }
        return isPrimeirao;
    }

    /**
     * Essa função serve para editar um arquivo em disco.
     * 
     * @param arquivarDado Uma String com os dados para edição.
     */
    public static void armazenarDado(String arquivarDado) {
        
        try {
        	fileWriter = new FileWriter(arquivo);
            bufferedWriter = new BufferedWriter(fileWriter);
			
            //Atualizando o arquivo   
            bufferedWriter.write(arquivarDado);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException ex) {
        	//TODO exception
            System.out.println("...Erro! " + ex);
        }
    }
}
