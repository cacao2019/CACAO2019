package abstraction.eq6Distributeur2;


import java.util.ArrayList;
import java.util.HashMap;

import abstraction.eq7Romu.produits.Chocolat;
import abstraction.eq7Romu.produits.Gamme;
import abstraction.eq7Romu.ventesContratCadre.ContratCadre;
import abstraction.eq7Romu.ventesContratCadre.IVendeurContratCadre;
import abstraction.eq7Romu.ventesContratCadre.StockEnVente;
import abstraction.fourni.IActeur;
import abstraction.fourni.Indicateur;
import abstraction.fourni.Monde;

public class Prix {
	// Nordin
    private HashMap<Chocolat,Double> prixachatParProduit;
    private HashMap<Chocolat,Double> margeParProduit;
    private double massesalariale = 100000; //à harmoniser avec le sscond distributeur
    private double coutstructure = 10000 ; //à harmoniser avec le sscond distributeur
    private double tva = 1.2 ;
    private Distributeur2 nous;

    private Indicateur prixMG_E_SHP;
    private Indicateur prixMG_NE_SHP;
    private Indicateur prixMG_NE_HP;;
    private Indicateur prixHG_E_SHP;
    

	public Prix(Distributeur2 distributeur) {
		
		nous = distributeur; 

		this.prixMG_E_SHP = new Indicateur("EQ6 " + Chocolat.MG_E_SHP.toString(), nous, 20);
        Monde.LE_MONDE.ajouterIndicateur(this.prixMG_E_SHP);
        this.prixMG_NE_SHP = new Indicateur("EQ6 " + Chocolat.MG_NE_SHP.toString(), nous, 50);
        Monde.LE_MONDE.ajouterIndicateur(this.prixMG_NE_SHP);

        this.prixMG_NE_HP = new Indicateur("EQ6 "+ Chocolat.MG_NE_HP.toString(), nous, 30);

        Monde.LE_MONDE.ajouterIndicateur(this.prixMG_NE_HP);

        this.prixHG_E_SHP = new Indicateur("EQ6 " + Chocolat.HG_E_SHP.toString(), nous, 70);

        this.prixHG_E_SHP = new Indicateur("EQ6 " + Chocolat.HG_E_SHP.toString(), nous, 50);

        Monde.LE_MONDE.ajouterIndicateur(this.prixHG_E_SHP);
        
        this.margeParProduit = new HashMap<Chocolat, Double>();
        this.margeParProduit.put(Chocolat.HG_E_SHP, 1.5);
        this.margeParProduit.put(Chocolat.MG_E_SHP, 1.25);
        this.margeParProduit.put(Chocolat.MG_NE_SHP,1.25);
        this.margeParProduit.put(Chocolat.MG_NE_HP, 1.1);
        
        this.prixachatParProduit =  new HashMap<Chocolat,Double>();
        this.prixachatParProduit.put(Chocolat.HG_E_SHP, this.getPrixHG_E_SHP().getValeur());
        this.prixachatParProduit.put(Chocolat.MG_E_SHP, this.getPrixMG_E_SHP().getValeur());
        this.prixachatParProduit.put(Chocolat.MG_NE_SHP,this.getPrixMG_NE_SHP().getValeur());
        this.prixachatParProduit.put(Chocolat.MG_NE_HP, this.getPrixMG_NE_HP().getValeur());
	}
	
    public Indicateur getIndicateurPrix (Chocolat c) {

        if (c.getGamme()==Gamme.MOYENNE && (c.isEquitable()) && (c.isSansHuileDePalme())) {
                return this.prixMG_E_SHP;
        }
        if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && (c.isSansHuileDePalme())) {
                return this.prixMG_NE_SHP;
        }
        if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && !(c.isSansHuileDePalme())){ 
                return this.prixMG_NE_HP;
        }
        if (c.getGamme()==Gamme.HAUTE && (c.isEquitable()) && (c.isSansHuileDePalme())){
                return this.prixHG_E_SHP;
        }
        else {
                return null;
        	}

    }

    public void setMargeParProduit(Chocolat c, double marge) {
    	 if  (!this.margeParProduit.containsKey(c)) {
             return ;
    	 }
     this.margeParProduit.put(c, marge);
    }
    
    
    public void setPrixachatParProduit(Chocolat c, double prix) {
   	 if  (!this.prixachatParProduit.containsKey(c)) {
            return ;
   	 }
    this.prixachatParProduit.put(c, prix);
   }
    
    
    
    public double getMargeParProduit(Chocolat c) {
        if  (!this.margeParProduit.containsKey(c)) {
                return Double.NaN;
        }
        return (this.margeParProduit.containsKey(c)? this.margeParProduit.get(c) : 0.0);
    }
    public double getPrixachatParProduit(Chocolat c) {
        if  (!this.prixachatParProduit.containsKey(c)) {
                return Double.NaN;
        }
        return this.prixachatParProduit.get(c);
}

    
    public double cout (Chocolat choco) { // cout de structure a pendre en compte lors de la vente d'un produit
    	int i = Monde.LE_MONDE.getStep()%24 - 1;
    	int t = Monde.LE_MONDE.getStep();
    	/*double qv=0;
    	double c = 0.25;
    	if (i != 0) {
    		for (int j = 24*i; j <24*i+24 ; j++) {
    			qv = qv + nous.getIndicateurStock(choco).getHistorique().get(nous.getIndicateurStock(choco).getHistorique().getTaille() -t+j).getValeur();
    			}
    		c = (coutstructure+massesalariale)*.25/qv;

    	}
    	else { c = 0.25; } */
    	
    	return 1.25;
    }
	
    public void ajustementMarge(ArrayList<Double> historique, Chocolat c ) {
        // je récupère le chocoalt et l'historique des variations 

    	//moyenne de vente
    	double vente_stockC= 0;
    	int steps = 0;

    	if (Monde.LE_MONDE.getStep() >= 24) {
    		for (int k=0 ; k<historique.size()-1; k++) {
    			vente_stockC+=historique.get(k);
    			steps+=1;
    		}
    	}

    	double moyenneventeavant = vente_stockC/steps;

    	//moyenne prix vendeur pour une quantité moyenne
    	double moyenneprixvendeur =0;
    	int nbvendeur =0;

    	for (IActeur acteur : Monde.LE_MONDE.getActeurs()) {
    		if (acteur instanceof IVendeurContratCadre<?>) {
    			IVendeurContratCadre<Chocolat> vacteur = (IVendeurContratCadre<Chocolat>)acteur;
    			StockEnVente<Chocolat> stock = vacteur.getStockEnVente();
    			if (stock.get(c) >500) {
    				nbvendeur+=1;
    				moyenneprixvendeur+=vacteur.getPrix(c, moyenneventeavant);
    			}
    		}
    	}
    	moyenneprixvendeur=moyenneprixvendeur/nbvendeur;

    	//baisse de la marge si les dernières ventes sont mauvaises et si notre prix reste au dessus de 0.95*moyenneprixvendeur
    	if (historique.size() > 24 && historique.get(historique.size() -1) < moyenneventeavant*0.7) {
    		if (getPrixParProduit(c) > moyenneprixvendeur) {
    			double nouvellemarge = this.getMargeParProduit(c)*0.95;
    			setMargeParProduit(c, nouvellemarge);
    		}
    	}

    	//augmentation de la marge si les dernières ventes sont hautes et si prix actuel pas trop grand
    	if (historique.size() > 24 && historique.get(historique.size() -1) > moyenneventeavant*2) {
    		if (getPrixParProduit(c) <1.7*moyenneprixvendeur) {
    			double nouvellemarge = this.getMargeParProduit(c)*1.05;
    			setMargeParProduit(c, nouvellemarge);
    		}
    	}
    }

    public double getPrixParProduit(Chocolat c) {
    	return getIndicateurPrix(c).getValeur();
    }
    public void setPrixParProduit(Chocolat c ) {
    	double prix = getPrixachatParProduit(c)*getMargeParProduit(c)*this.cout(c)*tva;
    	this.getIndicateurPrix(c).setValeur(nous, prix);
    }
    
        
    
	public Indicateur getPrixMG_E_SHP() {
		return prixMG_E_SHP;
	}

	public Indicateur getPrixMG_NE_SHP() {
		return prixMG_NE_SHP;
	}

	public Indicateur getPrixMG_NE_HP() {
		return prixMG_NE_HP;
	}

	public Indicateur getPrixHG_E_SHP() {
		return prixHG_E_SHP;
	}
    
   
}
