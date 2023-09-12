/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ri.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacques
 */
public class Start {

    public static void main(String[] args) {
        
        try {
            ArrayList<ProgrammeurBean> listeProgrammeurs = new ArrayList<>();
            Connection dbConn = DriverManager.getConnection("jdbc:derby://localhost:1527/TP2_RI_JAVA", "adm", "adm");
            Statement stmnt = dbConn.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT NOM,PRENOM,PSEUDO from PROGRAMMEUR");
            while (rs.next()) {
                ProgrammeurBean progBean = new ProgrammeurBean();
                        
                progBean.setNom(rs.getString("NOM"));
                progBean.setPrenom(rs.getString("PRENOM"));
                progBean.setPseudo(rs.getString("PSEUDO"));
                
                listeProgrammeurs.add(progBean);
            }

            for(int i=0; i< listeProgrammeurs.size();i++){
                
                System.out.println(listeProgrammeurs.get(i).getPrenom()+ "  "+
                                    listeProgrammeurs.get(i).getNom()+ "  "+
                                    listeProgrammeurs.get(i).getPseudo());
            }
            
        } catch (SQLException ex) {
            System.out.println("ERREUR!!! PROBLEME !!!");
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
