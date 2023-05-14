package webproje;

public class Equipe {
int IDEquipe;
String NomEquipe;
String Pays;

public Equipe(int iDEquipe, String nomEquipe, String pays) {
	super();
	IDEquipe = iDEquipe;
	NomEquipe = nomEquipe;
	Pays = pays;
}
public Equipe(String nomEquipe, String pays) {
	super();
	NomEquipe = nomEquipe;
	Pays = pays;
}
public Equipe() {
	super();
	// TODO Auto-generated constructor stub
}
public int getIDEquipe() {return IDEquipe;}
public void setIDEquipe(int idE) {
		this.IDEquipe = idE;}


public  String getNomEquipe() {return NomEquipe;}
public void setNomEquipe(String nomEquipe) {
		this.NomEquipe = nomEquipe;}



public String  getPays() {return Pays;}
public void setPays( String  pays) {
		this.Pays = pays;}








}
