package abstraction.eq6Distributeur2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import abstraction.eq7Romu.produits.Chocolat;
import abstraction.eq7Romu.produits.Gamme;
import abstraction.fourni.Monde;



public class Temporalite {
	// Nordin
    private Distributeur2 nous;
    private List<Integer> noel ;
    private List<Integer> paques ;
    private List<Integer> saintValentin ;
    private HashMap<Integer,Double> quantiteVendueMG_NE_SHP; // Nous donne pour un mois donnée la quantité maximale vendue 
    private HashMap<Integer,Double> quantiteVendueMG_NE_HP; 
    private HashMap<Integer,Double> quantiteVendueMG_E_SHP; 
    private HashMap<Integer,Double> quantiteVendueHG_E_SHP; 
    
    
	public Temporalite(Distributeur2 dist) {
		nous =dist;
		noel= new ArrayList<Integer>();
		paques= new ArrayList<Integer>();
		saintValentin= new ArrayList<Integer>();
		noel.add(11);
		noel.add(12);
		saintValentin.add(2);
		paques.add(3);
		paques.add(4);
		quantiteVendueHG_E_SHP = new HashMap<>();
		quantiteVendueMG_E_SHP = new HashMap<>();
		quantiteVendueMG_NE_HP = new HashMap<>();
		quantiteVendueMG_NE_SHP = new HashMap<>();
		
		}
	
	
	public void setQuantiteVendue(Chocolat c, int step, double q) {
			if (c.getGamme()==Gamme.MOYENNE && (c.isEquitable()) && (c.isSansHuileDePalme())) {
				if (quantiteVendueMG_E_SHP.get(getPeriode(step))== null) {
					quantiteVendueMG_E_SHP.put(getPeriode(step), q);
					
				}
				else if (quantiteVendueMG_E_SHP.get(getPeriode(step))<q){
					quantiteVendueMG_E_SHP.put(getPeriode(step), q);
				}
				}
			if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && (c.isSansHuileDePalme())) {
				if (quantiteVendueMG_NE_SHP.get(getPeriode(step))== null ) {
					quantiteVendueMG_NE_SHP.put(getPeriode(step), q);
				}
				else if (quantiteVendueMG_NE_SHP.get(getPeriode(step))<q) {
					quantiteVendueMG_NE_SHP.put(getPeriode(step), q);
				}
				}
			if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && !(c.isSansHuileDePalme())){ 
				if (quantiteVendueMG_NE_HP.get(getPeriode(step))== null ) {
					quantiteVendueMG_NE_HP.put(getPeriode(step), q);
				}
				else if (quantiteVendueMG_NE_HP.get(getPeriode(step))<q){
					quantiteVendueMG_NE_HP.put(getPeriode(step), q);
				}
				}
			if (c.getGamme()==Gamme.HAUTE && (c.isEquitable()) && (c.isSansHuileDePalme())){
				if (quantiteVendueHG_E_SHP.get(getPeriode(step))== null ) {
					quantiteVendueHG_E_SHP.put(getPeriode(step), q);
				}
				else if (quantiteVendueHG_E_SHP.get(getPeriode(step))<q) {
					quantiteVendueHG_E_SHP.put(getPeriode(step), q);
				}
				}
		
	}



	
	public int getPeriode (int step) {
		 int modulostep = step%24;
		 if (modulostep ==0) {
			 return 24;
		 }
		 return modulostep; 
		}
	
	public int getMois (int step) {
		 int modulostep = getPeriode(step); 
		 double moisActuel_ = modulostep/2;
		 int mois= (int)moisActuel_;
		 if (mois != moisActuel_) {
			 mois = mois +1;
		 }
		 return mois; 
		}
	// si on est dans la première elle renvoie 0 sinon elle renvoie la meilleur de l'année précedente 
	public int moisInteressant(Chocolat c ) {
		if (Monde.LE_MONDE.getStep() > 26 ) {
		// Méthode qui renvoie le mois de l'année la plus intéressante basée sur les ventes précédente 
		double qmax = 0.0;
		double q =0.0;
		int meilleurmois = 0;
		int moisactuel=	0;
		if (c.getGamme()==Gamme.MOYENNE && (c.isEquitable()) && (c.isSansHuileDePalme())) {
			for (int  step : this.quantiteVendueMG_E_SHP.keySet()) {
				if (getMois(step)== moisactuel) {
					int s = getPeriode(step)-1;
				System.out.println(s+"jnkjn" + quantiteVendueMG_E_SHP.get(getPeriode(step)) +"  "+quantiteVendueMG_E_SHP.get(getPeriode(step)-1));
					 q=quantiteVendueMG_E_SHP.get(getPeriode(step))+quantiteVendueMG_E_SHP.get(s);
					
				}
				else {q=0;}
            	if (q > qmax) {
            		qmax=q;
            		meilleurmois = getMois(step);
            		
            	}
            	moisactuel = getMois(step);
            }
		}
		if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && (c.isSansHuileDePalme())) {
			for (int  step : this.quantiteVendueMG_NE_SHP.keySet()) {
				if (getMois(step)== moisactuel) {
					 q=quantiteVendueMG_NE_SHP.get(getPeriode(step))+quantiteVendueMG_NE_SHP.get(getPeriode(step)-1);
				}
				else {q=0;}
            	if (q > qmax) {
            		qmax=q;
            		meilleurmois = getMois(step);
            		
            	}
            	moisactuel = getMois(step);
            }
		}
		if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && !(c.isSansHuileDePalme())){ 
			for (int  step : this.quantiteVendueMG_NE_HP.keySet()) {
				if (getMois(step)== moisactuel) {
					 q=quantiteVendueMG_NE_HP.get(getPeriode(step))+quantiteVendueMG_NE_HP.get(getPeriode(step)-1);
				}
				else {q=0;}
            	if (q > qmax) {
            		qmax=q;
            		meilleurmois = getMois(step);
            		
            	}
            	moisactuel = getMois(step);
            }
		}
		if (c.getGamme()==Gamme.HAUTE && (c.isEquitable()) && (c.isSansHuileDePalme())){
			for (int  step : this.quantiteVendueMG_NE_HP.keySet()) {
				if (getMois(step)== moisactuel) {
					 q=quantiteVendueHG_E_SHP.get(getPeriode(step))+quantiteVendueHG_E_SHP.get(getPeriode(step)-1);
				}
				else {q=0;}
            	if (q > qmax) {
            		qmax=q;
            		meilleurmois = getMois(step);
            		
            	}
            	moisactuel = getMois(step);
            }
		}
		return meilleurmois;
		}
		else {
			return 0;
		}
	}
	

}
