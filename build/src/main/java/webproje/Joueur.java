package webproje;

public class Joueur {
int ID;
int Numero;
String Nom;
String Poste;
String Nationalite;
float Salaire;
int IDEquipe;

public int getID() {return ID;}
public void setID(int id) {
		this.ID = id;}

public Joueur( int numero, String nom, String poste, String nationalite, float salaire) {
	super();
	Numero = numero;
	Nom = nom;
	Poste = poste;
	Nationalite = nationalite;
	Salaire = salaire;
}
public Joueur(int iD, int numero, String nom, String poste, String nationalite, float salaire) {
	super();
	ID = iD;
	Numero = numero;
	Nom = nom;
	Poste = poste;
	Nationalite = nationalite;
	Salaire = salaire;
}
public Joueur() {
	super();
	// TODO Auto-generated constructor stub
}
public int getNumero() {return Numero;}
public void setNumero(int numero) {
		this.Numero = numero;}

public String getNom() {return Nom;}
public void setNom(String nom) {
		this.Nom = nom;}



public String getPoste() {return Poste;}
public void setPoste(String poste ) {
		this.Poste = poste;}


public String getNationalite() {return Nationalite;}
public void setNationalite(String nationalite) {
this.Nationalite = nationalite;}



public float getSalaire() {return Salaire ;}
public void setSalaire(float salaire) {
		this.Salaire= salaire;}
}
