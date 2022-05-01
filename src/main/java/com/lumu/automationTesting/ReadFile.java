package com.lumu.automationTesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	public String readFile(){
		String excepcionMessage = "Error en la lectura del archivo";
		
		File doc = new File(".\\src\\main\\resources\\inputText.txt");
		Scanner scan;
		String line = "";
		try {
			scan = new Scanner(doc);
			while (scan.hasNextLine()) {
				line += scan.nextLine().concat(" ");
			}
		} catch (FileNotFoundException e) {
			System.err.println(excepcionMessage);
		}

		return line.trim();
	}
}
