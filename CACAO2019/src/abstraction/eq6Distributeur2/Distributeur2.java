package abstraction.eq6Distributeur2;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import abstraction.eq7Romu.distributionChocolat.IDistributeurChocolat;
import abstraction.eq7Romu.produits.Chocolat;
import abstraction.eq7Romu.produits.Gamme;
import abstraction.eq7Romu.ventesContratCadre.ContratCadre;
import abstraction.eq7Romu.ventesContratCadre.Echeancier;
import abstraction.eq7Romu.ventesContratCadre.IAcheteurContratCadre;
import abstraction.eq7Romu.ventesContratCadre.IVendeurContratCadre;
import abstraction.eq7Romu.ventesContratCadre.StockEnVente;
import abstraction.fourni.IActeur;
import abstraction.fourni.Indicateur;
import abstraction.fourni.Journal;
import abstraction.fourni.Monde;


public class Distributeur2 implements IActeur, IAcheteurContratCadre<Chocolat>, IDistributeurChocolat {


<<<<<<< HEAD
	private HashMap<Indicateur,IActeur> fidelite;
	private Prix gestionPrix;
	private ArrayList<Double> historiqueMG_E_SHP;
	private ArrayList<Double> historiqueMG_NE_SHP;
	private ArrayList<Double> historiqueMG_NE_HP;
	private ArrayList<Double> historiqueHG_E_SHP;
=======
	private List<ContratCadre<Chocolat>> contratsEnCours;
	private HashMap<Chocolat,Double> margeParProduit;
	private Indicateur soldeBancaire;
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	private List<ContratCadre<Chocolat>> contratsEnCours;
	private Indicateur soldeBancaire;
=======
	private Indicateur stockMG_E_SHP;
	private Indicateur stockMG_NE_SHP;
	private Indicateur stockMG_NE_HP;
	private Indicateur stockHG_E_SHP;
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	private Indicateur stockMG_E_SHP;
	private Indicateur stockMG_NE_SHP;
	private Indicateur stockMG_NE_HP;
	private Indicateur stockHG_E_SHP;
=======
	private Indicateur prixMG_E_SHP;
	private Indicateur prixMG_NE_SHP;
	private Indicateur prixMG_NE_HP;;
	private Indicateur prixHG_E_SHP;
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	private Temporalite temporalitee;
	private int contratEnCoursStep;
	
	private Journal journal;
	private StockEnVente<Chocolat> stockEnVente;
	private HashMap<Chocolat, Double> quantitevenduparstep;



	public Distributeur2() {

		//NORDIN et Carolinecar

		this.contratEnCoursStep=0;
		this.journal = new Journal("Journal EQ6");
		Monde.LE_MONDE.ajouterJournal(this.journal);

		// Partie se référant au journal
		this.soldeBancaire = new Indicateur("EQ6 Solde Bancaire", this, 1000000);
		Monde.LE_MONDE.ajouterIndicateur(this.soldeBancaire);



		//Chnager par nom du chocolat pour que le getNom de indcateur renvoie le type chocolat
		this.stockMG_E_SHP = new Indicateur("EQ6 stock" + Chocolat.MG_E_SHP.toString(), this, 55000);
		Monde.LE_MONDE.ajouterIndicateur(this.stockMG_E_SHP);
		this.stockMG_NE_SHP = new Indicateur("EQ6 stock " + Chocolat.MG_NE_SHP.toString(), this,150000);
		Monde.LE_MONDE.ajouterIndicateur(this.stockMG_NE_SHP);
		this.stockMG_NE_HP = new Indicateur("EQ6 stock " + Chocolat.MG_NE_HP.toString(), this, 55000);
		Monde.LE_MONDE.ajouterIndicateur(this.stockMG_NE_HP);
		this.stockHG_E_SHP = new Indicateur("EQ6 stock "+ Chocolat.HG_E_SHP.toString(), this, 55000);
		Monde.LE_MONDE.ajouterIndicateur(this.stockHG_E_SHP);


		this.stockEnVente = new StockEnVente<Chocolat>();
		this.stockEnVente.ajouter(Chocolat.HG_E_SHP, this.getStockHG_E_SHP().getValeur());
		this.stockEnVente.ajouter(Chocolat.MG_E_SHP, this.getStockMG_E_SHP().getValeur());
		this.stockEnVente.ajouter(Chocolat.MG_NE_SHP,this.getStockMG_NE_SHP().getValeur());
		this.stockEnVente.ajouter(Chocolat.MG_NE_HP, this.getStockMG_NE_HP().getValeur());

		this.contratsEnCours = new ArrayList<ContratCadre<Chocolat>>();
		gestionPrix = new Prix(this);

		this.quantitevenduparstep = new HashMap<>();
		this.quantitevenduparstep.put(Chocolat.HG_E_SHP, 0.0);
		this.quantitevenduparstep.put(Chocolat.MG_E_SHP, 0.0);
		this.quantitevenduparstep.put(Chocolat.MG_NE_SHP,0.0);
		this.quantitevenduparstep.put(Chocolat.MG_NE_HP, 0.0);

		temporalitee = new Temporalite(this);

		// initialisation des historiques
		historiqueMG_E_SHP = new ArrayList<Double> ();
		historiqueMG_NE_SHP = new ArrayList<Double> ();
		historiqueMG_NE_HP = new ArrayList<Double> ();
		historiqueHG_E_SHP = new ArrayList<Double> ();


	}


	public ArrayList<Double> getHistoriqueMG_E_SHP() {
		return historiqueMG_E_SHP;
	}


	public ArrayList<Double> getHistoriqueMG_NE_SHP() {
		return historiqueMG_NE_SHP;
	}


	public ArrayList<Double> getHistoriqueMG_NE_HP() {
		return historiqueMG_NE_HP;
	}


	public ArrayList<Double> getHistoriqueHG_E_SHP() {
		return historiqueHG_E_SHP;
	}

	public Indicateur getSoldeBancaire() {
		return soldeBancaire;
	}


	/**
	 * @return the stockMG_E_SHP
	 */
	public Indicateur getStockMG_E_SHP() {
		return stockMG_E_SHP;
	}

	/**
	 * @return the stockMG_NE_SHP
	 */
	public Indicateur getStockMG_NE_SHP() {
		return stockMG_NE_SHP;
	}

	/**
	 * @return the stockMG_NE_HP
	 */
	public Indicateur getStockMG_NE_HP() {
		return stockMG_NE_HP;
	}
=======
	private Journal journal;
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
        
	public Indicateur getStockHG_E_SHP() {
		return stockHG_E_SHP;
	}
	//Nordin et Caro
	public Indicateur getIndicateurStock(Chocolat c) {
		if (c.getGamme()==Gamme.MOYENNE && (c.isEquitable()) && (c.isSansHuileDePalme())) {
			return this.stockMG_E_SHP;
		}
		if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && (c.isSansHuileDePalme())) {
			return this.stockMG_NE_SHP;
		}
		if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && !(c.isSansHuileDePalme())){
			return this.stockMG_NE_HP;
		}
		if (c.getGamme()==Gamme.HAUTE && (c.isEquitable()) && (c.isSansHuileDePalme())){
			return this.stockHG_E_SHP;
		}
		else {
			return null;
		}
	}
	
	//Caro
		public ArrayList<Double> getHistoriqueVente(Chocolat c) {
			if (c.getGamme()==Gamme.MOYENNE && (c.isEquitable()) && (c.isSansHuileDePalme())) {
				return this.historiqueMG_E_SHP;
			}
			if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && (c.isSansHuileDePalme())) {
				return this.historiqueMG_NE_SHP;
			}
			if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && !(c.isSansHuileDePalme())){
				return this.historiqueMG_NE_HP;
			}
			if (c.getGamme()==Gamme.HAUTE && (c.isEquitable()) && (c.isSansHuileDePalme())){
				return this.historiqueHG_E_SHP;
			}
			else {
				return null;
			}
		}
		
	public List<ContratCadre<Chocolat>> getContratsEnCours() {
		return this.contratsEnCours;
	}
	/**
	 * @return the temporalitee
	 */
	public Temporalite getTemporalitee() {
		return temporalitee;
	}
=======
	private HashMap<Chocolat,Double> prixParProduit;
	private StockEnVente<Chocolat> stockEnVente; 


	public Distributeur2() {

		//NORDIN et Caroline
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git


<<<<<<< HEAD
	public StockEnVente<Chocolat> getStockEnVente() {
		//NORDIN
		return this.stockEnVente;
	}
=======
		// Partie se référant au journal
		this.journal = new Journal ("Marché du Chocolat");
		this.soldeBancaire = new Indicateur("EQ6 Solde Bancaire", this, 100000);
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

		Monde.LE_MONDE.ajouterIndicateur(this.soldeBancaire);

<<<<<<< HEAD
	public void initialiser() {
	}
	//nordin
	public void next() {
=======
		//Chnager par nom du chocolat pour que le getNom de indcateur renvoie le type chocolat
		this.stockMG_E_SHP = new Indicateur("EQ6 stcok" + Chocolat.MG_E_SHP.toString(), this, 5000);
		Monde.LE_MONDE.ajouterIndicateur(this.stockMG_E_SHP);
		this.stockMG_NE_SHP = new Indicateur("EQ6 stock " + Chocolat.MG_NE_SHP.toString(), this,5000);
		Monde.LE_MONDE.ajouterIndicateur(this.stockMG_NE_SHP);
		this.stockMG_NE_HP = new Indicateur("EQ6 stock " + Chocolat.MG_NE_HP.toString(), this, 5000);
		Monde.LE_MONDE.ajouterIndicateur(this.stockMG_NE_HP);
		this.stockHG_E_SHP = new Indicateur("EQ6 stock "+ Chocolat.HG_E_SHP.toString(), this, 5000);
		Monde.LE_MONDE.ajouterIndicateur(this.stockHG_E_SHP);
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		int step = Monde.LE_MONDE.getStep();
        double solde = this.getSoldeBancaire().getValeur();
        for (ContratCadre<Chocolat> cc : this.getContratsEnCours()) {
                solde = solde - cc.getMontantRestantARegler();
        }
        this.journal.ajouter("Solde : "+solde);
        this.contratEnCoursStep=0;
        this.getSoldeBancaire().retirer(this, this.fraisStockage());
        retireVieuxContrats();
=======
		this.prixMG_E_SHP = new Indicateur("EQ6 " + Chocolat.MG_E_SHP.toString(), this, 50);
		Monde.LE_MONDE.ajouterIndicateur(this.prixMG_E_SHP);
		this.prixMG_NE_SHP = new Indicateur("EQ6 " + Chocolat.MG_NE_SHP.toString(), this, 50);
		Monde.LE_MONDE.ajouterIndicateur(this.prixMG_NE_SHP);
		this.prixMG_NE_HP = new Indicateur("EQ6 "+ Chocolat.MG_NE_HP.toString(), this, 100);
		Monde.LE_MONDE.ajouterIndicateur(this.prixMG_NE_HP);
		this.prixHG_E_SHP = new Indicateur("EQ6 " + Chocolat.HG_E_SHP.toString(), this, 100);
		Monde.LE_MONDE.ajouterIndicateur(this.prixHG_E_SHP);

		this.journal = new Journal("Journal EQ6");
		Monde.LE_MONDE.ajouterJournal(this.journal);

		this.stockEnVente = new StockEnVente<Chocolat>();
		this.stockEnVente.ajouter(Chocolat.HG_E_SHP, this.getStockHG_E_SHP().getValeur());
		this.stockEnVente.ajouter(Chocolat.MG_E_SHP, this.getStockMG_E_SHP().getValeur());
		this.stockEnVente.ajouter(Chocolat.MG_NE_SHP,this.getStockMG_NE_SHP().getValeur());
		this.stockEnVente.ajouter(Chocolat.MG_NE_HP, this.getStockMG_NE_HP().getValeur());
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		// On incrémente les historiques
        HashMap<Chocolat, Double> derniereVente = derniereVente();
        for (Chocolat c : derniereVente.keySet()) {
                if (c.getGamme()==Gamme.MOYENNE && (c.isEquitable()) && (c.isSansHuileDePalme())) {
                        getHistoriqueMG_E_SHP().add(derniereVente.get(c));
                        gestionPrix.ajustementMarge(getHistoriqueMG_E_SHP(), c);
                        temporalitee.setQuantiteVendue(c, step, quantitevenduparstep.get(c));
                        quantitevenduparstep.put(c, 0.0);
                }
                if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && (c.isSansHuileDePalme())) {
                        getHistoriqueMG_NE_SHP().add(derniereVente.get(c));
                        gestionPrix.ajustementMarge(getHistoriqueMG_NE_SHP(), c);
                        temporalitee.setQuantiteVendue(c, step, quantitevenduparstep.get(c));
                        quantitevenduparstep.put(c, 0.0);
                }
               
                if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && !(c.isSansHuileDePalme())){
                        getHistoriqueMG_NE_HP().add(derniereVente.get(c));
                        gestionPrix.ajustementMarge(getHistoriqueMG_NE_HP(), c);
                        temporalitee.setQuantiteVendue(c, step, quantitevenduparstep.get(c));
                        quantitevenduparstep.put(c, 0.0);
                }
                if (c.getGamme()==Gamme.HAUTE && (c.isEquitable()) && (c.isSansHuileDePalme())){
                        getHistoriqueHG_E_SHP().add(derniereVente.get(c));
                        gestionPrix.ajustementMarge(getHistoriqueHG_E_SHP(), c);
                        temporalitee.setQuantiteVendue(c, step, quantitevenduparstep.get(c));
                        quantitevenduparstep.put(c, 0.0);
                }
        }
=======
		this.contratsEnCours = new ArrayList<ContratCadre<Chocolat>>();
		this.margeParProduit = new HashMap<Chocolat, Double>();
		this.margeParProduit.put(Chocolat.HG_E_SHP, 1.5);
		this.margeParProduit.put(Chocolat.MG_E_SHP, 1.5);
		this.margeParProduit.put(Chocolat.MG_NE_SHP,1.5);
		this.margeParProduit.put(Chocolat.MG_NE_HP, 1.5);

		//Caroline
		this.prixParProduit =  new HashMap<Chocolat,Double>();
		this.prixParProduit.put(Chocolat.HG_E_SHP, this.getPrixHG_E_SHP().getValeur());
		this.prixParProduit.put(Chocolat.MG_E_SHP, this.getPrixMG_E_SHP().getValeur());
		this.prixParProduit.put(Chocolat.MG_NE_SHP,this.getPrixMG_NE_SHP().getValeur());
		this.prixParProduit.put(Chocolat.MG_NE_HP, this.getPrixMG_NE_HP().getValeur());
	}


	/**
	 * @return the soldeBancaire
	 */
	public Indicateur getSoldeBancaire() {
		return soldeBancaire;
	}


	/**
	 * @return the prixMG_E_SHP
	 */
	public Indicateur getPrixMG_E_SHP() {
		return prixMG_E_SHP;
	}

	/**
	 * @return the prixMG_NE_SHP
	 */
	public Indicateur getPrixMG_NE_SHP() {
		return prixMG_NE_SHP;
	}

	/**
	 * @return the prixMG_NE_HP
	 */
	public Indicateur getPrixMG_NE_HP() {
		return prixMG_NE_HP;
	}

	/**
	 * @return the prixHG_E_SHP
	 */
	public Indicateur getPrixHG_E_SHP() {
		return prixHG_E_SHP;
	}


	/**
	 * @return the stockMG_E_SHP
	 */
	public Indicateur getStockMG_E_SHP() {
		return stockMG_E_SHP;
	}

	/**
	 * @return the stockMG_NE_SHP
	 */
	public Indicateur getStockMG_NE_SHP() {
		return stockMG_NE_SHP;
	}

	/**
	 * @return the stockMG_NE_HP
	 */
	public Indicateur getStockMG_NE_HP() {
		return stockMG_NE_HP;
	}

	/**
	 * @return the stockHG_E_SHP
	 */
	public Indicateur getStockHG_E_SHP() {
		return stockHG_E_SHP;
	}
	//Nordin et Caro
	public Indicateur getIndicateurStock(Chocolat c) {
		if (c.getGamme()==Gamme.MOYENNE && (c.isEquitable()) && (c.isSansHuileDePalme())) {
			return this.stockMG_E_SHP;
		}
		if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && (c.isSansHuileDePalme())) {
			return this.stockMG_NE_SHP;
		}
		if (c.getGamme()==Gamme.MOYENNE && !(c.isEquitable()) && !(c.isSansHuileDePalme())){ 
			return this.stockMG_NE_HP;
		}
		if (c.getGamme()==Gamme.HAUTE && (c.isEquitable()) && (c.isSansHuileDePalme())){
			return this.stockHG_E_SHP;
		}
		else {
			return null;
		}
	}
	//Nordin et Caro
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

	public List<ContratCadre<Chocolat>> getContratsEnCours() {
		return this.contratsEnCours;
	}

	public HashMap<Chocolat,Double> getPrixParProduit () {	
		return this.prixParProduit;
	}

	public StockEnVente<Chocolat> getStockEnVente() {
		//NORDIN
		return this.stockEnVente;
	}

	private double getMargeParProduit(Chocolat c) {
		if  (!getPrixParProduit().containsKey(c)) {
			return 0.0;
		}
		return (this.margeParProduit.containsKey(c)? this.margeParProduit.get(c) : 0.0);
	}

	public String getNom() {
		return "Walmart";

	}

	public void initialiser() {
	}

	public void next() {

	}

	//Nordin
	public double getPrix(Chocolat c) {
		if (!getPrixParProduit().containsKey(c)) {
			return 0.0;
		}
		/*this.prixParProduit==null ? Double.MAX_VALUE */ 
		return	(getPrixParProduit().containsKey(c)? getPrixParProduit().get(c) : 0.0);

	}
	public int getArrondi(double d) {
		double d_2 = d*100;
		int i = (int) d_2;
		return i/100;
		
	}
	

	//NORDIN
	public double vendre(Chocolat c, double quantite) {
		List<String> chocolatsdisponibles = new ArrayList<String>();
		for (Chocolat chocolat : this.getStockEnVente().getProduitsEnVente()) {
			if( c.equals(chocolat)) {
				Double q = Math.min(this.getStockEnVente().get(c), quantite);
				Double stockenvente = this.getStockEnVente().get(c) - q;
				this.getStockEnVente().ajouter(c, stockenvente);
				this.getIndicateurStock(c).retirer(this, q);
				this.getSoldeBancaire().ajouter(this, this.getPrix(c)*q);
				this.journal.ajouter("Vente de "+getArrondi(q)+ " kilos à " +getArrondi(this.getPrix(c)) + " euros pour le chocolat " +c);
				return q;
			}
			else {chocolatsdisponibles.add(""+chocolat);}
		}

		for (String i : chocolatsdisponibles) {
			this.journal.ajouter("Vente de 0.0 (produit demande = "+c+ " vs produit dispo = "+i+")");
		}

		return 0.0;
	}


	/** 
	 * Retire de la liste des contrats en cours les contrats pour lesquels la quantite a livrer 
	 * est nulle et le montant a regler est egalement nul (toutes les livraisons et tous les paiements
	 * ont ete effectues).
	 */

	public void retireVieuxContrats() {
		List<ContratCadre<Chocolat>> aEnlever = new ArrayList<ContratCadre<Chocolat>>();
		for (ContratCadre<Chocolat> c : this.contratsEnCours) {
			if (c.getQuantiteRestantALivrer()<=0.0 && c.getMontantRestantARegler()<=0.0) {
				aEnlever.add(c);
			}
		}
		for (ContratCadre<Chocolat> c : aEnlever) {
			this.contratsEnCours.remove(c);
		}
	}

	// Caroline 
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	}
	//nordin     
=======
	private HashMap<Chocolat, Double> derniere_vente () {
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
=======
		HashMap<Chocolat, Double> vente_produit= new HashMap<Chocolat, Double>();
		double vente_stockMG_E_SHP = 0;
		double vente_stockMG_NE_HP = 0;
		double vente_stockMG_NE_SHP = 0;
		double vente_stockHG_E_SHP = 0;
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	private double fraisStockage() {
		double cout =0;
		cout+= 0.0001*this.getStockHG_E_SHP().getValeur();
		cout+= 0.0001*this.getStockMG_E_SHP().getValeur();
		cout+= 0.0001*this.getStockMG_NE_HP().getValeur();
		cout+= 0.0001*this.getStockMG_NE_SHP().getValeur();
		return cout;
	}
=======
		if (Monde.LE_MONDE.getStep()>0) {
			for (ContratCadre<Chocolat> c  : this.getContratsEnCours()) {
				Chocolat ch = (Chocolat) c.getProduit();
				if (ch.equals(Chocolat.MG_E_SHP)) {
					vente_stockMG_E_SHP +=c.getEcheancier().getQuantite(Monde.LE_MONDE.getStep()-1);
				}
				if (ch.equals(Chocolat.MG_NE_HP)) {
					vente_stockMG_NE_HP +=c.getEcheancier().getQuantite(Monde.LE_MONDE.getStep()-1);
				}
				if (ch.equals(Chocolat.MG_NE_SHP)) {
					vente_stockMG_NE_SHP +=c.getEcheancier().getQuantite(Monde.LE_MONDE.getStep()-1);
				}
				if (ch.equals(Chocolat.HG_E_SHP)) {
					vente_stockHG_E_SHP +=c.getEcheancier().getQuantite(Monde.LE_MONDE.getStep()-1);
				}
			}
		}
		if ( stockMG_E_SHP.getHistorique().getTaille()  > 2 ) {
			vente_stockMG_E_SHP += stockMG_E_SHP.getHistorique().get(stockMG_E_SHP.getHistorique().getTaille() -2).getValeur() - stockMG_E_SHP.getValeur();
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	//Nordin
	public double getPrix(Chocolat c) {
		return gestionPrix.getPrixParProduit(c);
	}
=======
		} else {
			vente_stockMG_E_SHP=0; }
		
		if ( stockMG_NE_SHP.getHistorique().getTaille()  > 2 ) {
			vente_stockMG_NE_SHP += stockMG_NE_SHP.getHistorique().get(stockMG_NE_SHP.getHistorique().getTaille() -2).getValeur() - stockMG_NE_SHP.getValeur();
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	public int getArrondi(double d) {
		double d_2 = d*100;
		int i = (int) d_2;
		return i/100;
=======
		} else {
			vente_stockMG_NE_SHP=0;}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	}
=======
		if ( stockMG_NE_HP.getHistorique().getTaille()  > 2 ) {
			vente_stockMG_NE_HP += stockMG_NE_HP.getHistorique().get(stockMG_NE_HP.getHistorique().getTaille() -2).getValeur() - stockMG_NE_HP.getValeur();
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
=======
		} else {
			vente_stockMG_NE_HP=0;}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	//NORDIN
	public double vendre(Chocolat c, double quantite) {
		List<String> chocolatsdisponibles = new ArrayList<String>();
		for (Chocolat chocolat : this.getStockEnVente().getProduitsEnVente()) {
			if( c.equals(chocolat)) {
				// On ajoute cette vente à la Hashmap Qtité vendue
				double q_precedent= quantitevenduparstep.get(c);
				Double q = Math.min(this.getStockEnVente().get(c), quantite);
				
				quantitevenduparstep.put(c, q + q_precedent);
				
				Double stockenvente = this.getStockEnVente().get(c) - q;
				this.getStockEnVente().ajouter(c, stockenvente);
				this.getIndicateurStock(c).retirer(this, q);
				this.getSoldeBancaire().ajouter(this, this.getPrix(c)*q);
				this.journal.ajouter("Vente de "+getArrondi(q)+ " kilos à " +getArrondi(this.getPrix(c)) + " euros pour le chocolat " +c);
				return q;
=======
		if ( stockHG_E_SHP.getHistorique().getTaille()  > 2 ) {
			vente_stockHG_E_SHP += stockHG_E_SHP.getHistorique().get(stockHG_E_SHP.getHistorique().getTaille() -2).getValeur() - stockHG_E_SHP.getValeur();
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
			}
			else {chocolatsdisponibles.add(""+chocolat);}
		}
=======
		} else {
			vente_stockHG_E_SHP=0;}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		for (String i : chocolatsdisponibles) {
			this.journal.ajouter("Vente de 0.0 (produit demande = "+c+ " vs produit dispo = "+i+")");
		}
=======
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		return Double.NaN;
	}
=======
		vente_produit.put(Chocolat.MG_E_SHP, vente_stockMG_E_SHP);
		vente_produit.put(Chocolat.MG_NE_HP, vente_stockMG_NE_HP);
		vente_produit.put(Chocolat.MG_NE_SHP, vente_stockMG_NE_SHP);
		vente_produit.put(Chocolat.HG_E_SHP, vente_stockHG_E_SHP);
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
=======
		return vente_produit;
	}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	/**
	 * Retire de la liste des contrats en cours les contrats pour lesquels la quantite a livrer
	 * est nulle et le montant a regler est egalement nul (toutes les livraisons et tous les paiements
	 * ont ete effectues).
	 */
=======
	//Caroline
	// À améliorer avec temporalité pour avoir des prévisions de ventes plus valables sur 5 steps environ
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	public void retireVieuxContrats() {
		List<ContratCadre<Chocolat>> aEnlever = new ArrayList<ContratCadre<Chocolat>>();
		for (ContratCadre<Chocolat> c : this.contratsEnCours) {
			if (c.getQuantiteRestantALivrer()<=0.0 && c.getMontantRestantARegler()<=0.0) {
				aEnlever.add(c);
			}
		}
		for (ContratCadre<Chocolat> c : aEnlever) {
			this.contratsEnCours.remove(c);
		}
	}
=======
	private HashMap<Chocolat, Double> prevision_variation_stock_sur_5_STEPS () {
		HashMap<Chocolat, Double> variations_produit= new HashMap<Chocolat, Double>();
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	// Caroline

	private HashMap<Chocolat, Double> derniereVente () {

		HashMap<Chocolat, Double> vente_produit= new HashMap<Chocolat, Double>();
		double vente_stockMG_E_SHP = 0;
		double vente_stockMG_NE_HP = 0;
		double vente_stockMG_NE_SHP = 0;
		double vente_stockHG_E_SHP = 0;

		if (Monde.LE_MONDE.getStep()>0) {
			for (ContratCadre<Chocolat> c  : this.getContratsEnCours()) {
				Chocolat ch = (Chocolat) c.getProduit();
				if (ch.equals(Chocolat.MG_E_SHP)) {
					vente_stockMG_E_SHP +=c.getEcheancier().getQuantite(Monde.LE_MONDE.getStep()-1);
				}
				if (ch.equals(Chocolat.MG_NE_HP)) {
					vente_stockMG_NE_HP +=c.getEcheancier().getQuantite(Monde.LE_MONDE.getStep()-1);
				}
				if (ch.equals(Chocolat.MG_NE_SHP)) {
					vente_stockMG_NE_SHP +=c.getEcheancier().getQuantite(Monde.LE_MONDE.getStep()-1);
				}
				if (ch.equals(Chocolat.HG_E_SHP)) {
					vente_stockHG_E_SHP +=c.getEcheancier().getQuantite(Monde.LE_MONDE.getStep()-1);
				}
			}
		}
		if ( stockMG_E_SHP.getHistorique().getTaille()  > 2 ) {
			vente_stockMG_E_SHP += stockMG_E_SHP.getHistorique().get(stockMG_E_SHP.getHistorique().getTaille() -2).getValeur() - stockMG_E_SHP.getValeur();

		} else {
			vente_stockMG_E_SHP=0; }

		if ( stockMG_NE_SHP.getHistorique().getTaille()  > 2 ) {
			vente_stockMG_NE_SHP += stockMG_NE_SHP.getHistorique().get(stockMG_NE_SHP.getHistorique().getTaille() -2).getValeur() - stockMG_NE_SHP.getValeur();

		} else {
			vente_stockMG_NE_SHP=0;}

		if ( stockMG_NE_HP.getHistorique().getTaille()  > 2 ) {
			vente_stockMG_NE_HP += stockMG_NE_HP.getHistorique().get(stockMG_NE_HP.getHistorique().getTaille() -2).getValeur() - stockMG_NE_HP.getValeur();

		} else {
			vente_stockMG_NE_HP=0;}

		if ( stockHG_E_SHP.getHistorique().getTaille()  > 2 ) {
			vente_stockHG_E_SHP += stockHG_E_SHP.getHistorique().get(stockHG_E_SHP.getHistorique().getTaille() -2).getValeur() - stockHG_E_SHP.getValeur();

		} else {
			vente_stockHG_E_SHP=0;}

		vente_produit.put(Chocolat.MG_E_SHP, vente_stockMG_E_SHP);
		vente_produit.put(Chocolat.MG_NE_HP, vente_stockMG_NE_HP);
		vente_produit.put(Chocolat.MG_NE_SHP, vente_stockMG_NE_SHP);
		vente_produit.put(Chocolat.HG_E_SHP, vente_stockHG_E_SHP);
=======
		//PREVISION stockMG_E_SHP
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		return vente_produit;
	}
=======
		double variation_stockMG_E_SHP = 0;
		double recevoir_stockMG_E_SHP = 0;
		double variation_stockMG_NE_HP = 0;
		double recevoir_stockMG_NE_HP = 0;
		double variation_stockHG_E_SHP = 0;
		double recevoir_stockHG_E_SHP = 0;
		double variation_stockMG_NE_SHP = 0;
		double recevoir_stockMG_NE_SHP = 0;
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	//Caroline
	private HashMap<Chocolat, Double> previsionVente (int step) {
		HashMap<Chocolat, Double> previsionVente= new HashMap<Chocolat, Double>();
=======
		for (ContratCadre<Chocolat> c  : this.getContratsEnCours()) {
			Chocolat ch = (Chocolat) c.getProduit();
			if (ch.equals(Chocolat.MG_E_SHP)) {
				recevoir_stockMG_E_SHP += c.getQuantiteRestantALivrer();}
			if (ch.equals(Chocolat.MG_NE_SHP)) {
				recevoir_stockMG_NE_SHP += c.getQuantiteRestantALivrer(); }
			if (ch.equals(Chocolat.MG_NE_HP)) {
				recevoir_stockMG_NE_HP += c.getQuantiteRestantALivrer(); }
			if (ch.equals(Chocolat.HG_E_SHP)) {
				recevoir_stockHG_E_SHP += c.getQuantiteRestantALivrer(); }
		}
		variation_stockMG_E_SHP = -5*this.derniere_vente().get(Chocolat.MG_E_SHP) + recevoir_stockMG_E_SHP;
		variations_produit.put(Chocolat.MG_E_SHP, variation_stockMG_E_SHP);
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		double demandetotaleMG_E_SHP = 0;
		double demandetotaleMG_NE_SHP= 0;
		double demandetotaleMG_NE_HP = 0;
		double demandetotaleHG_E_SHP = 0;
=======
		variation_stockMG_NE_SHP = -5*this.derniere_vente().get(Chocolat.MG_NE_SHP)  + recevoir_stockMG_NE_SHP;
		variations_produit.put(Chocolat.MG_NE_SHP, variation_stockMG_NE_SHP);
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
=======
		variation_stockMG_NE_HP = -5*this.derniere_vente().get(Chocolat.MG_NE_HP) + recevoir_stockMG_NE_HP;
		variations_produit.put(Chocolat.MG_NE_HP, variation_stockMG_NE_HP);
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		if (Monde.LE_MONDE.getStep() >= 10) {
			for (int k=0 ; k<this.getHistoriqueMG_NE_HP().size(); k++) {
				demandetotaleMG_E_SHP += this.getHistoriqueMG_E_SHP().get(k);
			}
			demandetotaleMG_E_SHP=demandetotaleMG_E_SHP/Monde.LE_MONDE.getStep();
=======
		variation_stockHG_E_SHP = -5*this.derniere_vente().get(Chocolat.HG_E_SHP) + recevoir_stockHG_E_SHP;
		variations_produit.put(Chocolat.HG_E_SHP, variation_stockHG_E_SHP);
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
			for (int k=0 ; k<this.getHistoriqueMG_NE_HP().size(); k++) {
				demandetotaleMG_NE_SHP += this.getHistoriqueMG_NE_SHP().get(k);
			}
			demandetotaleMG_NE_SHP=demandetotaleMG_NE_SHP/Monde.LE_MONDE.getStep();
=======
		return variations_produit;
	}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
			for (int k=0 ; k<this.getHistoriqueMG_NE_HP().size(); k++) {
				demandetotaleMG_NE_HP += this.getHistoriqueMG_NE_HP().get(k);
			}
			demandetotaleMG_NE_HP=demandetotaleMG_NE_HP/Monde.LE_MONDE.getStep();
=======
	//Caroline
	private HashMap<Chocolat, Double> stockIdeal () {
		//HashMap<Chocolat, Double> historique_vente = historique_vente() ;
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
			for (int k=0 ; k<this.getHistoriqueMG_NE_HP().size(); k++) {
				demandetotaleHG_E_SHP += this.getHistoriqueHG_E_SHP().get(k);
			}
			demandetotaleHG_E_SHP=demandetotaleHG_E_SHP/Monde.LE_MONDE.getStep();
=======
		//ETUDE DE MARCHÉ : Prendre en compte l'avis des clients les plus fidèles sur leur avis de produit ainsi que l'historique de leur demande 
		/*
				for (IActeur acteur : Monde.LE_MONDE.getActeurs()) {
					if (acteur instanceof Client1) {
						Client1 c = (Client1)acteur;
						c.Offres(Monde.LE_MONDE.getStep());
					} 
				}
		 
*/
		//Pour l'instant avec 4 clients qui veulent chaquun un produit different avec 7500 par step on prend : 
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		}
		else {
			demandetotaleMG_E_SHP = 5000;
			demandetotaleMG_NE_SHP= 5000;
			demandetotaleMG_NE_HP = 5000;
			demandetotaleHG_E_SHP = 5000;
		}
=======
		HashMap<Chocolat, Double> stockIdeal= new HashMap<Chocolat, Double>();
		stockIdeal.put(Chocolat.MG_E_SHP, 15000.0);
		stockIdeal.put(Chocolat.MG_NE_SHP, 15000.0);
		stockIdeal.put(Chocolat.MG_NE_HP, 15000.0);
		stockIdeal.put(Chocolat.HG_E_SHP, 15000.0);
		//Il serait mieux de voir la quantite reçue par step afin de combler les écarts avec de nouveaux contrats 
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
=======
		//Travail sur le stock idéal par rapport aux ventes précédentes
		
		for (Chocolat c : stockIdeal.keySet() ) {
			
			if (derniere_vente().get(c) < 5000) {
				stockIdeal.put(c, 5000.0);
			}
			if (derniere_vente().get(c) > 10000) {
				stockIdeal.put(c, 20000.0);
			}
		}
		 
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		previsionVente.put(Chocolat.MG_E_SHP, demandetotaleMG_E_SHP*this.getTemporalitee().getFacteur((Monde.LE_MONDE.getStep())%24,Chocolat.MG_E_SHP ));
		previsionVente.put(Chocolat.MG_NE_SHP,demandetotaleMG_NE_SHP*this.getTemporalitee().getFacteur((Monde.LE_MONDE.getStep())%24,Chocolat.MG_NE_SHP));
		previsionVente.put(Chocolat.MG_NE_HP, demandetotaleMG_NE_HP*this.getTemporalitee().getFacteur((Monde.LE_MONDE.getStep())%24,Chocolat.MG_NE_HP));
		previsionVente.put(Chocolat.HG_E_SHP, demandetotaleHG_E_SHP*this.getTemporalitee().getFacteur((Monde.LE_MONDE.getStep())%24,Chocolat.HG_E_SHP));
=======
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		return previsionVente;
=======
		return stockIdeal;
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git
	}


<<<<<<< HEAD
	//Caroline
	// À améliorer avec temporalité pour avoir des prévisions de ventes plus valables sur 5 steps environ
=======
	public ContratCadre<Chocolat> getNouveauContrat() { //ILIAS et Caroline
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	private HashMap<Chocolat, Double> previsionVariationStockSurNSteps (int N) {
		HashMap<Chocolat, Double> variations_produit= new HashMap<Chocolat, Double>();
=======
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		//PREVISION stockMG_E_SHP
=======
		ContratCadre<Chocolat> res=null;
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		double variation_stockMG_E_SHP = 0;
		double recevoir_stockMG_E_SHP = 0;
		double variation_stockMG_NE_HP = 0;
		double recevoir_stockMG_NE_HP = 0;
		double variation_stockHG_E_SHP = 0;
		double recevoir_stockHG_E_SHP = 0;
		double variation_stockMG_NE_SHP = 0;
		double recevoir_stockMG_NE_SHP = 0;

		for (ContratCadre<Chocolat> c  : this.getContratsEnCours()) {
			Chocolat ch = (Chocolat) c.getProduit();
			if (ch.equals(Chocolat.MG_E_SHP)) {
				recevoir_stockMG_E_SHP += c.getEcheancier().getQuantiteJusquA(Monde.LE_MONDE.getStep() +N)- c.getEcheancier().getQuantiteJusquA(Monde.LE_MONDE.getStep());}
			if (ch.equals(Chocolat.MG_NE_SHP)) {
				recevoir_stockMG_NE_SHP += c.getEcheancier().getQuantiteJusquA(Monde.LE_MONDE.getStep() +N)- c.getEcheancier().getQuantiteJusquA(Monde.LE_MONDE.getStep()); }
			if (ch.equals(Chocolat.MG_NE_HP)) {
				recevoir_stockMG_NE_HP += c.getEcheancier().getQuantiteJusquA(Monde.LE_MONDE.getStep() +N)- c.getEcheancier().getQuantiteJusquA(Monde.LE_MONDE.getStep()); }
			if (ch.equals(Chocolat.HG_E_SHP)) {
				recevoir_stockHG_E_SHP += c.getEcheancier().getQuantiteJusquA(Monde.LE_MONDE.getStep() +N)- c.getEcheancier().getQuantiteJusquA(Monde.LE_MONDE.getStep()); }
		}

		double venteprevisionMG_E_SHP = 0;
		for (int k=0 ; k<N ;k++) {
			venteprevisionMG_E_SHP +=this.previsionVente (Monde.LE_MONDE.getStep()+k).get(Chocolat.MG_E_SHP);
		}
		variation_stockMG_E_SHP = -1*venteprevisionMG_E_SHP + recevoir_stockMG_E_SHP;
		variations_produit.put(Chocolat.MG_E_SHP, variation_stockMG_E_SHP);

		double venteprevisionMG_NE_SHP = 0;
		for (int k=0 ; k<N ;k++) {
			venteprevisionMG_NE_SHP +=this.previsionVente (Monde.LE_MONDE.getStep()+k).get(Chocolat.MG_NE_SHP);
		}
		variation_stockMG_NE_SHP = -1*venteprevisionMG_NE_SHP + recevoir_stockMG_NE_SHP;
		variations_produit.put(Chocolat.MG_NE_SHP, variation_stockMG_NE_SHP);

		double venteprevisionMG_NE_HP = 0;
		for (int k=0 ; k<N ;k++) {
			venteprevisionMG_NE_HP +=this.previsionVente (Monde.LE_MONDE.getStep()+k).get(Chocolat.MG_NE_HP);
		}
		variation_stockMG_NE_HP = -1*venteprevisionMG_NE_HP + recevoir_stockMG_NE_HP;
		variations_produit.put(Chocolat.MG_NE_HP, variation_stockMG_NE_HP);

		double venteprevisionHG_E_SHP = 0;
		for (int k=0 ; k<N ;k++) {
			venteprevisionHG_E_SHP +=this.previsionVente (Monde.LE_MONDE.getStep()+k).get(Chocolat.HG_E_SHP);
		}
		variation_stockHG_E_SHP = -1*venteprevisionHG_E_SHP + recevoir_stockHG_E_SHP;
		variations_produit.put(Chocolat.HG_E_SHP, variation_stockHG_E_SHP);

		return variations_produit;
	}

	//Caroline
	private HashMap<Chocolat, Double> stockIdeal (int step) {

		//Pour l'instant avec 4 clients qui veulent chaqun un produit different avec 7500 par step on prend :

		//Se servir de previsionVente
		HashMap<Chocolat, Double> stockIdeal= new HashMap<Chocolat, Double>();
		double stockIdealMG_E_SHP =0;
		double stockIdealMG_NE_SHP=0;
		double stockIdealMG_NE_HP=0;
		double stockIdealHG_E_SHP=0;

		List<Integer> steps = new ArrayList<Integer>();
		steps.add(step);
		steps.add(step+1);

		for (int i : steps) {
			stockIdealMG_E_SHP+=this.previsionVente(i).get(Chocolat.MG_E_SHP);
			stockIdealMG_NE_SHP+=this.previsionVente(i).get(Chocolat.MG_NE_SHP);
			stockIdealMG_NE_HP+=this.previsionVente(i).get(Chocolat.MG_NE_HP);
			stockIdealHG_E_SHP+=this.previsionVente(i).get(Chocolat.HG_E_SHP);
		}

		stockIdeal.put(Chocolat.MG_E_SHP, stockIdealMG_E_SHP);
		stockIdeal.put(Chocolat.MG_NE_SHP, stockIdealMG_NE_SHP);
		stockIdeal.put(Chocolat.MG_NE_HP, stockIdealMG_NE_HP);
		stockIdeal.put(Chocolat.HG_E_SHP, stockIdealHG_E_SHP);
		//Il serait mieux de voir la quantite reçue par step afin de combler les écarts avec de nouveaux contrats

		//Travail sur le stock idéal par rapport aux ventes précédentes

		for (Chocolat c : stockIdeal.keySet() ) {

			if (derniereVente().get(c) < 1000) {
				stockIdeal.put(c, 5000.0);
			}
			if (derniereVente().get(c)>10000 && this.gestionPrix.getMargeParProduit(c) >1.2) {
				double stockavecrenta = stockIdeal.get(c);
				stockavecrenta*=0.2;
				stockIdeal.put(c,stockavecrenta);

			}
		}

		return stockIdeal;
	}

	//Caroline
	private HashMap<Chocolat, Double> achatIdeal () {

		HashMap<Chocolat, Double> achatIdeal= new HashMap<Chocolat, Double>();
		HashMap<Chocolat, Double> stockIdeal= stockIdeal(Monde.LE_MONDE.getStep()+5);
		HashMap<Chocolat, Double> va= previsionVariationStockSurNSteps(3);

		achatIdeal.put(Chocolat.MG_E_SHP, stockIdeal.get(Chocolat.MG_E_SHP) - (Math.max(this.getStockMG_E_SHP().getValeur() +va.get(Chocolat.MG_E_SHP),0)));
		achatIdeal.put(Chocolat.MG_NE_SHP, stockIdeal.get(Chocolat.MG_NE_SHP) - (Math.max(this.getStockMG_NE_SHP().getValeur() +va.get(Chocolat.MG_NE_SHP),0)));
		achatIdeal.put(Chocolat.MG_NE_HP, stockIdeal.get(Chocolat.MG_NE_HP) - (Math.max(this.getStockMG_NE_HP().getValeur() +va.get(Chocolat.MG_NE_HP),0)));
		achatIdeal.put(Chocolat.HG_E_SHP, stockIdeal.get(Chocolat.HG_E_SHP) - (Math.max(this.getStockHG_E_SHP().getValeur() +va.get(Chocolat.HG_E_SHP),0)));

		return achatIdeal;

	}


	public ContratCadre<Chocolat> getNouveauContrat() { //ILIAS et Caroline
		ContratCadre<Chocolat> res=null;

		double solde = this.getSoldeBancaire().getValeur();

		for (ContratCadre<Chocolat> cc : this.getContratsEnCours()) {
			solde = solde - cc.getMontantRestantARegler()+ cc.getQuantiteRestantALivrer()*getPrix(cc.getProduit())*0.70;
		}
		if (solde >10000)
		{
			if (contratEnCoursStep<4) {
				//Choix du produit
				HashMap<Chocolat, Double> achatIdeal = this.achatIdeal ();
=======
		double solde = this.getSoldeBancaire().getValeur();
		for (ContratCadre<Chocolat> cc : this.getContratsEnCours()) {
			solde = solde - cc.getMontantRestantARegler();
		}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				//Choix du produit
=======
		//Choix du produit 
		HashMap<Chocolat, Double> variations_produit = this.prevision_variation_stock_sur_5_STEPS ();
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
=======
		Chocolat produit =  Chocolat.MG_NE_SHP;
		//Écart entre stock ideal et stock supposé dans 5 steps
		double max_ecart = Math.max(this.stockIdeal().get(produit) - (variations_produit.get(produit)+this.getStockEnVente().get(produit)),0.0);
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				List<Chocolat> produitsdispo = new ArrayList<Chocolat>();
				for (IActeur acteur : Monde.LE_MONDE.getActeurs()) {
					if (acteur instanceof IVendeurContratCadre<?>) {
						IVendeurContratCadre<Chocolat> vacteur = (IVendeurContratCadre<Chocolat>)acteur;
						StockEnVente<Chocolat> stock = vacteur.getStockEnVente();
						if (stock.get(Chocolat.MG_E_SHP)>500 && !produitsdispo.contains(Chocolat.MG_E_SHP) ) {
							produitsdispo.add(Chocolat.MG_E_SHP);
						}
						if (stock.get(Chocolat.MG_NE_SHP)>500 && !produitsdispo.contains(Chocolat.MG_NE_SHP)) {
							produitsdispo.add(Chocolat.MG_E_SHP);
						}
						if (stock.get(Chocolat.MG_NE_HP)>500 && !produitsdispo.contains(Chocolat.MG_NE_HP)) {
							produitsdispo.add(Chocolat.MG_NE_HP);
						}
						if (stock.get(Chocolat.HG_E_SHP)>500 && !produitsdispo.contains(Chocolat.HG_E_SHP)) {
							produitsdispo.add(Chocolat.HG_E_SHP);
						}
					}
				}
=======
		for (Chocolat c : variations_produit.keySet()) {
			if (this.stockIdeal().get(c) -  (variations_produit.get(c)+this.getStockEnVente().get(c)) > max_ecart) {
				max_ecart = Math.max(this.stockIdeal().get(c) -  (variations_produit.get(c)+this.getStockEnVente().get(c)),0.0);
				produit = c;
			}
		}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				Chocolat produit =  produitsdispo.get(0);
				//Écart entre stock ideal et stock supposé dans 5 steps
				double max_ecart = Math.max(achatIdeal.get(produit),0.0);
				for (Chocolat c : produitsdispo) {
					if (Math.max(achatIdeal.get(c),0.0) > max_ecart) {
						max_ecart = Math.max(achatIdeal.get(c),0.0);
						produit = c;
					}
				}
				//QUANTITE
				double quantite =  Math.max(achatIdeal.get(produit),0.0);
				if (quantite <500) {
					quantite = 0;
				}
=======
		//QUANTITE
		double quantite;
		if (variations_produit.get(produit) + this.getStockEnVente().get(produit) > this.stockIdeal().get(produit)) {
			quantite = 0;
		}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
=======
		else 
		{   quantite =  Math.max(this.stockIdeal().get(produit) - (variations_produit.get(produit)+this.getStockEnVente().get(produit)),0.0);
			if (quantite <1000) {
				quantite = 0;
			}
		}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				List<IVendeurContratCadre<Chocolat>> vendeurs = new ArrayList<IVendeurContratCadre<Chocolat>>();
				for (IActeur acteur : Monde.LE_MONDE.getActeurs()) {
					if (acteur instanceof IVendeurContratCadre<?>) {
						IVendeurContratCadre<Chocolat> vacteur = (IVendeurContratCadre<Chocolat>)acteur;
						StockEnVente<Chocolat> stock = vacteur.getStockEnVente();
						if (stock.get(produit)>500) {// on souhaite faire des contrats d'au moins 500kg
							vendeurs.add((IVendeurContratCadre<Chocolat>)vacteur);
						}
					}
				}
=======
		retireVieuxContrats();
		
		if (solde >10000 && quantite > 1000 ) 
		{
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				//VENDEUR
				if (vendeurs.size() >0) {
					IVendeurContratCadre<Chocolat> vendeur = vendeurs.get(0);
					double meilleurprix = vendeur.getPrix(produit, quantite);
					for (IVendeurContratCadre<Chocolat> v : vendeurs)
					{
						if (v.getPrix(produit, Math.min(v.getStockEnVente().get(produit),quantite)) < meilleurprix)
						{   vendeur = v;
						meilleurprix = v.getPrix(produit, Math.min(v.getStockEnVente().get(produit),quantite));        
						}
					}
					if (vendeur != null & produit != null && quantite != 0)
					{
						quantite = Math.min(vendeur.getStockEnVente().get(produit),quantite);
						res = new ContratCadre<Chocolat>(this, vendeur, produit, Math.min(vendeur.getStockEnVente().get(produit),quantite));
						this.journal.ajouter("Pour le step " +Monde.LE_MONDE.getStep()+
								" nouveau contrat non signé : " + res.getNumero()  +" Produit : "+ produit +
								" Quantité = " +  getArrondi(Math.min(vendeur.getStockEnVente().get(produit),quantite)) + " kilos "
								+ " vendeur= " + vendeur);
					}
					else
					{ res = null;
					}
				}
				else {
					this.journal.ajouter("Pas de vendeur");
				}
			} else {
				this.journal.ajouter("Trop de contrats en cours à ce step");
			}
		}
=======
			List<IVendeurContratCadre<Chocolat>> vendeurs = new ArrayList<IVendeurContratCadre<Chocolat>>();
			for (IActeur acteur : Monde.LE_MONDE.getActeurs()) {
				if (acteur instanceof IVendeurContratCadre<?>) {
					IVendeurContratCadre<Chocolat> vacteur = (IVendeurContratCadre<Chocolat>)acteur;
					StockEnVente<Chocolat> stock = vacteur.getStockEnVente();
					if (stock.get(produit)>quantite*0.7) {// on souhaite faire des contrats d'au moins 100kg
						vendeurs.add((IVendeurContratCadre<Chocolat>)vacteur);
					}
				}
			}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		else {this.journal.ajouter(" Il ne reste que "+getArrondi(solde)+" euros une"
				+ " fois tous les contrats payes donc nous ne souhaitons pas en creer d'autres pour l'instant");}
=======
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		return res;
=======
			//VENDEUR
			double meilleurprix = 5000000;
			IVendeurContratCadre<Chocolat> vendeur = null;
			for (IVendeurContratCadre<Chocolat> v : vendeurs) 
			{
				if (v.getPrix(produit, Math.min(v.getStockEnVente().get(produit),quantite)) < meilleurprix) 
				{
					vendeur = v;
				}
			}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	}
=======
			if (vendeur != null & produit != null && quantite != 0) 
			{
				res = new ContratCadre<Chocolat>(this, vendeur, produit, Math.min(vendeur.getStockEnVente().get(produit),quantite));
				this.journal.ajouter("Pour le step " +Monde.LE_MONDE.getStep()+ 
						" nouveau contrat non signé : " + res.getNumero()  +" Produit : "+ produit +
					" Quantité = " +  getArrondi(Math.min(vendeur.getStockEnVente().get(produit),quantite)) + " kilos "
					+ " vendeur= " + vendeur);
			}
			else 
			{ res = null;
			}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	@Override
	//Caroline
	//A ameliorer selon la quantite demandée dans contrat, la quantite nécessaire aux prochains steps selon la demande en prévoyant des futurs coûrts de stockage
	public void proposerEcheancierAcheteur(ContratCadre<Chocolat> cc) {
		if (cc!=null) {
=======
		}
		if (quantite > 1000) {this.journal.ajouter("La quantité de stock est suffisante");}
		else {this.journal.ajouter(" Il ne reste que "+getArrondi(solde)+" euros une"
				+ " fois tous les contrats payes donc nous ne souhaitons pas en creer d'autres pour l'instant");}
		return res;
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
			if (cc.getEcheancier()==null) { // il n'y a pas encore eu de contre-proposition de la part du vendeur
				Chocolat produit = cc.getProduit();
				double qtotale = cc.getQuantite();
				Echeancier ech = new Echeancier(Monde.LE_MONDE.getStep());
=======
	}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				double step1= 	this.stockIdeal(Monde.LE_MONDE.getStep() +1).get(produit) - (this.getStockEnVente().get(produit) + this.previsionVariationStockSurNSteps(1).get(produit)) ;
				step1 = Math.min(Math.abs(step1*0.7), qtotale);
				qtotale=qtotale-step1;
=======
	@Override
	//Caroline 
	//A ameliorer selon la quantite demandée dans contrat, la quantite nécessaire aux prochains steps selon la demande en prévoyant des futurs coûrts de stockage
	public void proposerEcheancierAcheteur(ContratCadre<Chocolat> cc) {
		if (cc!=null) {
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				double step2=0;
				if (qtotale >0) {
					step2= this.stockIdeal(Monde.LE_MONDE.getStep() +2).get(produit) - (this.getStockEnVente().get(produit) +step1 + this.previsionVariationStockSurNSteps(2).get(produit)) ;
					step2 = Math.min(Math.abs(step2*0.8), qtotale);
					qtotale=qtotale-step2;
				}
=======
			if (cc.getEcheancier()==null) { // il n'y a pas encore eu de contre-proposition de la part du vendeur
				cc.ajouterEcheancier(new Echeancier(Monde.LE_MONDE.getStep(), 5, cc.getQuantite()/5));
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				double step3 =0;
				if (qtotale >0) {
					step3= this.stockIdeal(Monde.LE_MONDE.getStep() +3).get(produit) - (this.getStockEnVente().get(produit) +step1 +step2+ this.previsionVariationStockSurNSteps(3).get(produit)) ;
					step3 = Math.min(Math.abs(step3*0.8), qtotale);
					qtotale=qtotale-step3;
				}
=======
			}   
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				double step4 =0;
				if (qtotale >0) {
					step4= this.stockIdeal(Monde.LE_MONDE.getStep() +4).get(produit) - (this.getStockEnVente().get(produit) +step1 +step2+ step3+ this.previsionVariationStockSurNSteps(4).get(produit)) ;
					step4 = Math.min(Math.abs(step4*0.8), qtotale);
					qtotale=qtotale-step4;
				}
=======
			else {
				cc.ajouterEcheancier(new Echeancier(cc.getEcheancier())); // on accepte la contre-proposition du vendeur 
				this.journal.ajouter("Contrat n° " + cc.getNumero() + " avec " + cc.getEcheancier().getNbEcheances()+ " échéances");
			}
		}
	}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				double step5 =0;
				if (qtotale >0) {
					step5= this.stockIdeal(Monde.LE_MONDE.getStep() +5).get(produit) - (this.getStockEnVente().get(produit) +step1 +step2+ step3+step4+ this.previsionVariationStockSurNSteps(5).get(produit)) ;
					step5 = Math.min(Math.abs(step5*0.8), qtotale);
					qtotale=qtotale-step5;
				}
=======
	//Caroline
	// il faudra prendre en compte le prix de stockage 
	public boolean satisfaitParPrixContratCadre (ContratCadre<Chocolat> cc) {
		boolean satisfait = true;
		Chocolat produit = cc.getProduit();
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
=======
		double dernierprixpropose = cc.getPrixAuKilo();
		double notreprix = this.getPrix(produit);
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				int i =1;
				if (step1 > 0) {
					ech.set(Monde.LE_MONDE.getStep() +i, step1);
					i+=1;
				}
				if (step2>0) {
					ech.set(Monde.LE_MONDE.getStep() +i, step2);
					i+=1;
				}
				if (step3>0) {
					ech.set(Monde.LE_MONDE.getStep() +i, step3);
					i+=1;
				}
				if (step4>0) {
					ech.set(Monde.LE_MONDE.getStep() +i, step4);
					i+=1;
				}
				if (step5>0) {
					ech.set(Monde.LE_MONDE.getStep() +i, step5);
					i+=1;
				}
				if (qtotale>0) {
					ech.set(Monde.LE_MONDE.getStep() +i, qtotale);
					i+=1;
				}
				cc.ajouterEcheancier(ech);
=======
		if (notreprix/dernierprixpropose >= this.getMargeParProduit(cc.getProduit())) {
			satisfait = true;
		}else {
			satisfait = false;
		}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
			}  
=======
		return satisfait;
	}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
			else {
				cc.ajouterEcheancier(new Echeancier(cc.getEcheancier())); // on accepte la contre-proposition du vendeur
				this.journal.ajouter("Contrat n° " + cc.getNumero() + " avec " + cc.getEcheancier().getNbEcheances()+ " échéances");
			}
		}
	}
=======
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	//Caroline
	// il faudra prendre en compte le prix de stockage
	public boolean satisfaitParPrixContratCadre (ContratCadre<Chocolat> cc) {
		boolean satisfait = true;
		Chocolat produit = cc.getProduit();
=======
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		double dernierprixpropose = cc.getPrixAuKilo();
		double notreprix = this.gestionPrix.getPrixachatParProduit(produit);
=======
	@Override
	//Caroline
	public void proposerPrixAcheteur(ContratCadre<Chocolat> cc) {
		//Si le dernier prix de la liste nous satisfait => proposer le même prix
		//Sinon, le dernier prix nous satisfait pas :
		//Si le vendeur propose 2 fois le même prix et pas satisfait => ne pas ajouter de prix
		// Sinon proposer un nouveau prix 
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		if (notreprix/dernierprixpropose >= this.gestionPrix.getMargeParProduit(produit)) {
			satisfait = true;
			
		}else {
			satisfait = false;
		}
=======
		if (cc!=null && 25 > cc.getListePrixAuKilo().size()) {
			if (satisfaitParPrixContratCadre (cc)) {
				cc.ajouterPrixAuKilo(cc.getPrixAuKilo());
				this.getIndicateurPrix(cc.getProduit()).ajouter(this,cc.getPrixAuKilo());
				this.journal.ajouter("Accord sur Prix sur contrat n° " + cc.getNumero());
			} else {
				if (cc.getListePrixAuKilo().size() >= 2) {
					if (cc.getListePrixAuKilo().get(cc.getListePrixAuKilo().size() -2)*1.02 < this.prixParProduit.get(cc.getProduit())) {
						cc.ajouterPrixAuKilo(cc.getListePrixAuKilo().get(cc.getListePrixAuKilo().size() -2)*1.02);
					} 
				}else {
					cc.ajouterPrixAuKilo(cc.getVendeur().getPrix(cc.getProduit(), cc.getQuantite())*0.8);
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		return satisfait;
	}
=======
				}	}}}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	@Override
	//Caroline
	public void proposerPrixAcheteur(ContratCadre<Chocolat> cc) {
		//Si le dernier prix de la liste nous satisfait => proposer le même prix
		//Sinon, le dernier prix nous satisfait pas :
=======
	@Override//Caroline
	public void notifierAcheteur(ContratCadre<Chocolat> cc) {
		if (cc!=null) {
			this.journal.ajouter("Le contrat n° " + cc.getNumero()+ " est signé");
			this.getContratsEnCours().add(cc);
		}
	}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		if (cc!=null) {
			if (satisfaitParPrixContratCadre (cc)) {
				cc.ajouterPrixAuKilo(cc.getPrixAuKilo());
				this.journal.ajouter("Accord sur Prix sur contrat n° " + cc.getNumero() + " au prix " + cc.getPrixAuKilo());
=======
	@Override//Caroline
	public void receptionner(Chocolat produit, double quantite, ContratCadre<Chocolat> cc) {
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
			} else {
=======
		this.journal.ajouter("Réception du produit " + produit.toString() +
				" en quantité " + getArrondi(quantite) + " kilos "+ " provenant du contrat n° " + cc.getNumero());
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
				if (cc.getListePrixAuKilo().size() >= 2) {
					if (this.getPrix(cc.getProduit())/(cc.getPrixAuKilo()*1.03) >=this.gestionPrix.getMargeParProduit(cc.getProduit()) ) { 
						cc.ajouterPrixAuKilo(cc.getPrixAuKilo()*1.03);
					}
					else {
						cc.ajouterPrixAuKilo(cc.getListePrixAuKilo().get(cc.getListePrixAuKilo().size() -2)*1.02);
					}
				}
				else {
					cc.ajouterPrixAuKilo(cc.getVendeur().getPrix(cc.getProduit(), cc.getQuantite())*0.95);
				}
			}
		}
	}
=======
		if (cc != null && quantite >0 && cc.getProduit().equals(produit)) {
			double quantiteajoutee= this.getStockEnVente().get(produit)+quantite;
			this.getStockEnVente().ajouter(produit, quantiteajoutee);
			this.getIndicateurStock(produit).ajouter(this, quantite);
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	@Override//Caroline
	public void notifierAcheteur(ContratCadre<Chocolat> cc) {
		if (cc!=null) {
			this.journal.ajouter("Le contrat n° " + cc.getNumero()+ " est signé");
			this.getContratsEnCours().add(cc);
			contratEnCoursStep+=1;
		}
=======
		}
	}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	}
=======
	@Override//Caroline et Nordin
	public double payer(double montant, ContratCadre<Chocolat> cc) {
		double montantpaye = 0;
		double solde = getSoldeBancaire().getValeur();
		if (cc!=null | montant ==0.0 ) {
			return 0.0;
		}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	@Override//Caroline
	public void receptionner(Chocolat produit, double quantite, ContratCadre<Chocolat> cc) {
		if (cc != null && quantite >0 && cc.getProduit().equals(produit)) {
			double quantiteajoutee= this.getStockEnVente().get(produit)+quantite;
			this.getStockEnVente().ajouter(produit, quantiteajoutee);
			this.getIndicateurStock(produit).ajouter(this, quantite);
=======
		if (montant<0.0) {
			throw new IllegalArgumentException("Appel de la methode payer avec un montant negatif");
		}
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		}
		
		this.journal.ajouter("Réception du produit " + produit.toString() +
				" en quantité " + getArrondi(quantite) + " kilos "+ " provenant du contrat n° " + cc.getNumero());
	}
=======
		if (solde - montant > -5000) {
			montantpaye = montant;
			this.soldeBancaire.retirer(this, montantpaye);
		} 
		else   {
			montantpaye = solde+5000;
			this.soldeBancaire.retirer(this, montantpaye);
		} 
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
	@Override//Caroline et Nordin
	public double payer(double montant, ContratCadre<Chocolat> cc) {
		double montantpaye = 0;
		double solde = getSoldeBancaire().getValeur();
		if (montant ==0.0 || cc==null) {
			return 0.0;
		}
		if (montant<0.0) {
			throw new IllegalArgumentException("Appel de la methode payer avec un montant negatif");
		}
=======
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		if (solde - montant > -5000) {
			montantpaye = montant;
			this.soldeBancaire.retirer(this, montantpaye);
		}
		else   {
			montantpaye = solde+5000;
			this.soldeBancaire.retirer(this, montantpaye);
		}
=======
		this.journal.ajouter(montantpaye + "€ sur le contrat n° " + cc.getNumero());
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

		return montantpaye;
	}

<<<<<<< HEAD
		this.journal.ajouter(montantpaye + "€ sur le contrat n° " + cc.getNumero());
=======
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git

<<<<<<< HEAD
		return montantpaye;
	}
=======
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git


<<<<<<< HEAD
	@Override
	public String getNom() {
		return "WallMart";
	}
=======
>>>>>>> branch 'master' of https://github.com/ErineDupont/CACAO2019.git
}
