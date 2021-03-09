package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	
	private List<String> elencoP;
		
	public Parole() {
		this.elencoP = new ArrayList<>();
	}
	
	public void addParola(String p) {
		p=p.toLowerCase();
		this.elencoP.add(p);
	}
	
	public List<String> getElenco() {
		//List<String> pe = new ArrayList<String>();
		//pe=this.elencoP;
		Collections.sort(this.elencoP);
		return this.elencoP;
	}
	
	public void reset() {
		this.elencoP.clear();
	}
	
	public List<String> eliminaParola(String ppp){
		
		for(int i=0; i<elencoP.size(); i++) {
			if(elencoP.get(i).equals(ppp)) {
				elencoP.remove(i);
				break;
			}
		}
		
		Collections.sort(this.elencoP);
		return this.elencoP;
		
	}

}
