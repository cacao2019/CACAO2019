package abstraction.eq4Transformateur2;

// Kelian
public class TasProduit<T> {
	/** Représente une livraison de fèves ou de chocolat */
	
	private double quantité; // kg
	private double prixAuKilo;
	private int datePeremption;
	
	public TasProduit(double quantité, double prixAuKilo) {
		this.quantité = quantité;
		this.prixAuKilo = prixAuKilo;
	}
	
	public double getQuantité() {
		return quantité;
	}
	
	public double getPrixUnitaire() {
		return prixAuKilo;
	}
	
	public int getDatePeremption() {
		return datePeremption;
	}
	
	public double getPrixAuKilo() {
		return prixAuKilo;
	}
	
	public boolean prendre(double qte) {
		if(qte <= this.quantité) {
			this.quantité -= qte;
			return true;
		}
		return false;
	}
}