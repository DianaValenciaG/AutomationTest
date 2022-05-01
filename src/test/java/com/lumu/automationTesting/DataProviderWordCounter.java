package com.lumu.automationTesting;

import org.testng.annotations.DataProvider;

public class DataProviderWordCounter {

	@DataProvider(name="testString")
	public static Object[][] dataSet() {
		return new Object[][] {
				{"Prueba Densidad de Palabras, cuando se tienen números 123 en la cadena, No los debe contar."},
				{"LUMU LUMU LUMU lumu lumu illuminates illuminates attacks and adversaries lumu illuminates all attacks and adversaries"},
				{"Prueba usando caracteres especiales, no deben contar como palabras , * - )"},
				{"Este String no tiene caracteres especiales ni números, así que no debería fallar"}
		};
	}
	
	@DataProvider(name="testStringDensities")
	public static Object[][] dataSetDensities() {
		return new Object[][] {
			    {"SIMPLE COUNT TEST. APP COUNT ARTICLES PREPOSITIONS?"},
				{"TEST TEST TO LUMU, LUMU COUNT WORDS WORDS AND WORDS"},
				{"LUMU LUMU LUMU lumu lumu illuminates illuminates attacks and adversaries lumu illuminates all attacks and adversaries"},
				{"DENSITY OF WORD, THE DENSITY IS IMPORTANT TO LUMU"},
				{"AUTOMATION TEST LUMU, TEST AUTOMATION"}
		};
	}
}
