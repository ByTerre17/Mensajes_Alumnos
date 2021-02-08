/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author DAW2-PROFESOR
 */
public class Utilidades {
    public static ArrayList<Alumno> getAlumnos(String fichero) throws FileNotFoundException, IOException{
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		try {
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fichero), "utf-8"));
			String linea;			
			try {
				
				while((linea = buffer.readLine())!=null) {
                                    String [] atributosAlumno = linea.split(";");
		Alumno alumn = new Alumno( atributosAlumno[1]  , 
                                                                   atributosAlumno[2],
                                                                    atributosAlumno[3]);

                                  alumnos.add(alumn);
                                                            
				 }
				
				buffer.close();
			} catch (IOException e) {
				
			}
		
		} catch (UnsupportedEncodingException e) {
			
		}
		return alumnos;		
	}
}
