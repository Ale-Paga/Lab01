package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		Parole p = new Parole();
		
		List<String> el = new ArrayList<>();
		
		p.addParola("Ciao");
		p.addParola("Tetto");
		p.addParola("Prato");
		p.addParola("Zecca");
		p.addParola("Sasso");
		
		el = p.getElenco();
		
		for(String i: el) {
			System.out.println(i+"\n");
		}

	}

}
