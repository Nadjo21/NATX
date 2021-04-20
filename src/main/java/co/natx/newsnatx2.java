
package co.natx;

import java.sql.*;
import java.util.Scanner;


public class newsnatx2 {

    public static void main(String[] args) throws SQLException {


        String url = "jdbc:postgresql://localhost:5432/news2";
        String user = "postgres";
        String password = "postgres";

        //on cree la connexion
        Connection connection = DriverManager.getConnection(url, user, password);


//on execute la requete
        Statement statement = connection.createStatement();

        ResultSet news = statement.executeQuery("select titlefr,contentfr,id from news");


        try {



            //affichage du resultat en parcourant nos lignes de résultats de requetes telles qu'elles appraissent dans la console SQL

            while (news.next()) {

                System.out.println("Titre" + " contenu " + "id");
                System.out.println(news.getString("titlefr") + "   " +news.getString("contentfr") +news.getString("id"));


            }


            //     ResultSet.close();

            statement.close();


            //Je ferme la connexion.


            connection.close();




    } catch(SQLException exception)

    {
        // Ma gestion du problème
        System.out.println("Erreur de connexion à la base de données");
        exception.printStackTrace();
    }

}

}