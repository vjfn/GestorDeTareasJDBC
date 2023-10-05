package org.example.domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Database {

    private static Connection connection;

    private static Logger logger;



    static {//Para inicializar las variables estáticas, se ejecuta la primera vez que se ejecuta la clase

        logger = Logger.getLogger(Database.class.getName());



        String url = "jdbc:mysql://localhost:3306/ad";
        String user = "root";
        String password ="";
        try {
            connection = DriverManager.getConnection(url,user,password);
            logger.info("Successful connection to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static ArrayList<String[]> getALL(){

        var salida = new ArrayList<String[]>();

        try(Statement st = connection.createStatement()){
            ResultSet rs = st.executeQuery("SELECT * FROM tarea");

            while (rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("titulo"));
                System.out.println(rs.getString("prioridad"));
                System.out.println(rs.getInt("usuario_id"));
                System.out.println(rs.getString("categoria"));
                System.out.println(rs.getString("descripcion"));
                String[] fila ={
                        String.valueOf(rs.getInt("id")),
                        rs.getString("titulo"),
                        rs.getString("prioridad"),
                        String.valueOf(rs.getInt("usuario_id")),
                        rs.getString("categoria"),
                        rs.getString("descripcion")
                };

                salida.add(fila);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return salida;
    }

}
