/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DyE
 */
public class Conexion {

  private Connection con = null;
  private String bd = "";
  private String login = "";
  private String password = "";
  private String host = "";
  private String url = "";

  /**
   * Metodo que realiza la conexion a la base de datos
   */
  public Conexion() {
    try {
      host = "localhost";
      bd = "assets";
      login = "root";
      password = "root";
      url = "jdbc:mysql://" + host + "/" + bd;
      //obtenemos el driver de para mysql
      Class.forName("com.mysql.jdbc.Driver");
      //obtenemos la conexión
      con = DriverManager.getConnection(url, login, password);
      if (con != null) {
        System.out.println("Conección a Base de Datos " + bd + " OK");
      }

    } catch (SQLException | ClassNotFoundException e) {
      System.out.println(e);
    }
  }

  /**
   * Permite obtener la conexion a la base de datos
   *
   * @return variable tipo Connection para la ejecucion de consultas
   */
  public Connection getConnection() {
    return con;
  }

  /**
   * Permite obtener el nombre de la base de datos a la cual estamos conectados
   *
   * @return variable tipo String con el nombre de la base de datos
   */
  public String getDb() {
    return bd;
  }

  /**
   * Permite obtener el Host al cual estamos conectados
   *
   * @return variable tipo String con el nombre del host
   */
  public String getHost() {
    return host;
  }

  /**
   * Permite la desconeccion dee la base de datos
   */
  public void close() {
    con = null;
  }
}
