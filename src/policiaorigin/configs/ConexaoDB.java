/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package policiaorigin.configs;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class ConexaoDB {
    public void ConectarMysql(){
        
    }
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    private final String host=  "axirouxe.com";
    private final String banco= "axiroux1_cbgta";
    private final String user=  "cborigin";
    private final String pass=  "4_iDca63";
    

    public ResultSet readDataBase(String tabelad) {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://"+host+"/"+banco+"?"
                            + "user="+user+"&password="+pass);

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from "+tabelad+" ORDER BY id DESC");
            //writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
            
            /*preparedStatement = connect
                    .prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)");*/
            
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            
            /*preparedStatement.setString(1, "Test");
            preparedStatement.setString(2, "TestEmail");
            preparedStatement.setString(3, "TestWebpage");
            preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
            preparedStatement.setString(5, "TestSummary");
            preparedStatement.setString(6, "TestComment");
            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);*/

            // Remove again the insert comment
            
            /*preparedStatement = connect
            .prepareStatement("delete from feedback.comments where myuser= ? ; ");
            preparedStatement.setString(1, "Test");*/
                    
            //preparedStatement.executeUpdate();

            /*resultSet = statement
            .executeQuery("select * from feedback.comments");
            writeMetaData(resultSet);*/
            
           
            System.out.println("Conectado ao servidor: "+host);
            return resultSet;

        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String versao =     resultSet.getString("versao");
            String build =      resultSet.getString("build");
            Integer need =       resultSet.getInt("need");
            String link =       resultSet.getString("link");
            String mensagem =   resultSet.getString("mensagem");
            
            //Date date = resultSet.getDate("datum");
            
            System.out.println("versao: " + versao);
            System.out.println("build: " + build);
            System.out.println("need: " + need);
            System.out.println("link: " + link);
            System.out.println("mensagem: " + mensagem);
        }
        
    }
    
    public void ConfigCarregar() throws SQLException {
        // ResultSet is initially before the first data set
        //ArrayList<String> Conf = new ArrayList();
        
        ResultSet config = readDataBase("config");
        while (config.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String versao =     config.getString("versao");
            String build =      config.getString("build");
            Integer need =       config.getInt("need");
            String link =       config.getString("link");
            String mensagem =   config.getString("mensagem");
            
            //Date date = resultSet.getDate("datum");
            /*Conf.add(build);
            Conf.add(versao);
            Conf.add(need.toString());
            Conf.add(link);
            Conf.add(mensagem);*/
            
            Config configu = new Config();
            configu.setBuild(build);
            configu.setVersao(versao);
            configu.setNeed(need.toString());
            configu.setLink(link);
            configu.setMensagem(mensagem);
            
            System.out.println("versao: " + versao);
            System.out.println("build: " + build);
            System.out.println("need: " + need);
            System.out.println("link: " + link);
            System.out.println("mensagem: " + mensagem);
        }
        close();
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
