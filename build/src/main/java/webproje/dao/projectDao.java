package webproje.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webproje.Equipe;
import webproje.Joueur;

public class projectDao {
private String jdbcURL = "jdbc:mysql://localhost:3306/webproject";
private String jdbcUsername ="root";
private String jdbcPassword ="";
private String jdbcDriver = "com.mysql.jdbc.Driver";


private static final String INSERT_USERS_SQL = "INSERT INTO joueur "+"(Numero,Nom, Poste ,Nationalite,Salaire)VALUES" + "(?,?,?,?,?);";

private static final String SELECT_USER_BY_ID = "select ID,Numero,Nom ,Poste ,Nationalite,Salaire from joueur  where ID = ?";
private static final String SELECT_ALL_USERS = "selsct + from joueur ";
private static final String DELETE_USERS_SQL = "delete from joueur where ID=?;";
private static final String UPDATE_USERS_SQL = "update joueur set Numero= ? ,Nom=?, Poste =?, Nationalite =?,Salaire =? where ID= ?;";

private static final String INSERT_USERSs_SQL = "INSERT INTO Equipe "+"(NomEquipe,Pays)VALUES" + "(?,?);";

private static final String SELECT_USERs_BY_ID = "select IDEquipe,NomEquipe,Pays from Equipe where IDEquipe = ?";
private static final String SELECT_ALLs_USERS = "selsct + from Equipe ";
private static final String DELETE_USERSs_SQL = "delete from Equipe where IDEquipe=?;";
private static final String UPDATE_USERSs_SQL = "update Equipe set NomEquipe=? ,Pays=?,   where IDEquipe= ?;";





public projectDao() {
}
protected Connection getConnection() {
	Connection connection = null;
	try{
		Class.forName(jdbcDriver);
		connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	}catch (SQLException e) {
		e.printStackTrace();
	}catch (ClassNotFoundException e ) {
		e.printStackTrace();
	}
	return connection;	
}

// insert joueur 

public void insertjoueur( Joueur joueur )throws SQLException {
	System.out.println( INSERT_USERS_SQL);
	try(Connection connection = getConnection();
			PreparedStatement preparedStatment = connection.prepareStatement(INSERT_USERS_SQL)){
		
		preparedStatment.setLong(1, joueur.getNumero());
		preparedStatment.setString(2, joueur.getNom());
		preparedStatment.setString(3, joueur.getPoste());
		preparedStatment.setString(4, joueur.getNationalite());
		preparedStatment.setLong(5, (long) joueur.getSalaire());
		 System.out.println(preparedStatment);
		 preparedStatment.executeUpdate();
	}catch (SQLException e) {printSQLExcepption(e);}
}


//insert joueur 


public void insertEquipe( Equipe Equipe )throws SQLException {
	System.out.println( INSERT_USERS_SQL);
	try(Connection connection = getConnection();
			PreparedStatement preparedStatment = connection.prepareStatement(INSERT_USERSs_SQL)){
		
		preparedStatment.setString(1, Equipe.getNomEquipe());
		preparedStatment.setString(2, Equipe.getPays());
	
		 System.out.println(preparedStatment);
		 preparedStatment.executeUpdate();
	}catch (SQLException e) {printSQLExcepption(e);}
}
//select by id 
public Joueur selectJoueur(int ID) {
	Joueur joueur  = null;
	 try(Connection connection = getConnection();
			 PreparedStatement preparedStatment = connection.prepareStatement(SELECT_USER_BY_ID );){
		 preparedStatment.setInt(1, ID);
		 System.out.println(preparedStatment);
		 ResultSet rs = preparedStatment.executeQuery();
		 
		 while (rs.next()) {
			
			 int Numero = (int) rs.getLong("Numero ");
			 String Nom = rs.getString("Nom");
			 String Poste = rs.getString("Poste");
			 String Nationalite =rs.getString("Nationalite");
			 float Salaire = rs.getLong("Salaire");
			 joueur = new Joueur(ID,Numero,Nom ,Poste ,Nationalite,Salaire);
		 }
	 }catch (SQLException e) {printSQLExcepption(e);}
	 return joueur;
} 


//select by id 
public Equipe  selectEquipe(int IDEquipe) {
	Equipe Equipe  = null;
	 try(Connection connection = getConnection();
			 PreparedStatement preparedStatment = connection.prepareStatement(SELECT_USERs_BY_ID );){
		 preparedStatment.setInt(1, IDEquipe);
		 System.out.println(preparedStatment);
		 ResultSet rs = preparedStatment.executeQuery();
		 
		 while (rs.next()) {
		
			 String NomEquipe = rs.getString("NomEquipe");
			 String Pays = rs.getString("Pays");
			
			 Equipe = new Equipe (IDEquipe,NomEquipe,Pays);
		 }
	 }catch (SQLException e) {printSQLExcepption(e);}
	 return Equipe;
} 

//select all joueur
   public List<Joueur> selectAllJoueur(){
	   List<Joueur> joueur = new ArrayList<>();
	   try(Connection connection = getConnection();
				 PreparedStatement preparedStatment = connection.prepareStatement(SELECT_ALL_USERS );){
		   System.out.println(preparedStatment);
		   ResultSet rs = preparedStatment.executeQuery();
		   while (rs.next()) {
			     int ID = rs.getInt("ID");
				 int Numero = (int) rs.getLong("Numero ");
				 String Nom = rs.getString("Nom");
				 String Poste = rs.getString("Poste");
				 String Nationalite =rs.getString("Nationalite");
				 float Salaire = rs.getLong("Salaire");
				 joueur.add(new Joueur(ID,Numero,Nom ,Poste ,Nationalite,Salaire));
			 }
		 }catch (SQLException e) {printSQLExcepption(e);}
	   return joueur;
   }
   
   
   
 //select all joueur
   public List<Equipe> selectAllEquipe(){
	   List<Equipe> Equipe = new ArrayList<>();
	   try(Connection connection = getConnection();
				 PreparedStatement preparedStatment = connection.prepareStatement(SELECT_ALLs_USERS );){
		   System.out.println(preparedStatment);
		   ResultSet rs = preparedStatment.executeQuery();
		   while (rs.next()) {
			     int IDEquipe = rs.getInt("IDEquipe");
				
				 String NomEquipe = rs.getString("NomEquipe");
				 String Pays =rs.getString("Pays");
				
				 Equipe.add(new Equipe(IDEquipe,NomEquipe,Pays));
			 }
		 }catch (SQLException e) {printSQLExcepption(e);}
	   return Equipe;
   }
//updale
   
   public boolean updateJoueur(Joueur joueur ) throws SQLException{
	   boolean rowUpdated;
	   try(Connection connection = getConnection();
				 PreparedStatement statement = connection.prepareStatement( UPDATE_USERS_SQL);){
		System.out.println("updated USer:" +statement);
		   statement.setLong(1, joueur.getNumero());
		   statement.setString(2, joueur.getNom());
		   statement.setString(3, joueur.getPoste());
		   statement.setString(4, joueur.getNationalite());
		   statement.setLong(5, (long) joueur.getSalaire());
		   rowUpdated =  statement.executeUpdate()>0;
	   }
	return rowUpdated;
   }
   
   
   public boolean updateEquipe(Equipe Equipe)throws SQLException{
	   boolean rowUpdated;
	   try(Connection connection = getConnection();
				 PreparedStatement statement = connection.prepareStatement( DELETE_USERSs_SQL);){
		System.out.println("updated USer:" +statement);
		  
		   statement.setString(1, Equipe.getNomEquipe());
		   statement.setString(2, Equipe.getPays());
		   
		   rowUpdated =  statement.executeUpdate()>0;
	   }
	return rowUpdated;
   }
//delete

public boolean deleteJoueur(int ID) throws  SQLException{
	boolean rowDeleted;
		try(Connection connection = getConnection();
				 PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL );){ 
			     statement.setInt(1,ID);
			 rowDeleted =  statement.executeUpdate()>0;
		   }
		return rowDeleted;
		}
public boolean deleteEquipe(int IDEquipe) throws  SQLException{
	boolean rowDeleted;
		try(Connection connection = getConnection();
				 PreparedStatement statement = connection.prepareStatement( UPDATE_USERSs_SQL );){ 
			     statement.setInt(1,IDEquipe);
			 rowDeleted =  statement.executeUpdate()>0;
		   }
		return rowDeleted;
		}
		

private void printSQLExcepption(SQLException ex) {
	// TODO Auto-generated method stub
	for(Throwable e :ex) {
		if(e instanceof SQLException ) {
			e.printStackTrace(System.err);
			System.err.println("SQLState:"+ ((SQLException) e).getSQLState());
			System.err.println("Error Code:"+ ((SQLException) e).getErrorCode());
			System.err.println("Message:"+ e.getMessage());
			Throwable t = ex.getCause();
			while (t != null) {
				System.out.println("Cause:" + t);
				t =t.getCause();
			}
		}
	}
}




}
