/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// @author Aelyo Pinto, Carlos Henrique e Jimmy Peterson

public class ConnectionDataBase {

    private static final String URL_MYSQL = "jdbc:mysql://localhost/cursopoosenac";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "root";// no meu caso a senha é root

    /* o método getConnection()  retorna um objeto de conexão com o banco
     chamamos o método estático getConnection(...) da classe DriverMenager
     Quando precisarmos uma conexão como o banco, vamos apenas fazer uma chamada ao método criado.
     Com esta classe podemos usar qualquer banco, é só mudar os parametros DRIVER_CLASS, URL_MYSQL, USER, PASS e
     adicionar no projeto o driver JDBC referente ao banco de dados usado.
     */
    public static Connection getConnection() {
        System.out.println("Conectando ao Banco de Dados");
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(URL_MYSQL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
