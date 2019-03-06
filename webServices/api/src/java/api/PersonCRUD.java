/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.json.simple.JSONObject;

/**
 *
 * @author DyE
 */
@WebService(serviceName = "AssetsCrud")
public class PersonCRUD {

  /**
   * This is a sample web service operation
   *
   * @return
   */
  @WebMethod(operationName = "listperson")
  public String listperson() {
    HashMap<Integer, String> person = null;
    HashMap<String, String> out = new HashMap<>();
    JSONObject json = new JSONObject();
    try {
      Conexion con = new Conexion();
      Connection conex = con.getConnection();
      Statement s = conex.createStatement();
      ResultSet rs;
      String sql = "SELECT * FROM person ";
      rs = s.executeQuery(sql);
      out.put("code", "404");
      out.put("desc", "busqueda sin resultados");
      person = new HashMap<>();
      while (rs.next()) {
        out.put("code", "200");
        out.put("desc", "consulta exitosa");
        out.put(rs.getString("idPerson"), rs.getString("namePerson"));
      }
      json.putAll(person);
      return json.toJSONString();
    } catch (SQLException ex) {
      out.put("code", "500");
      out.put("desc", ex.getMessage());
      Logger.getLogger(PersonCRUD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return json.toJSONString();
  }

  /**
   * This is a sample web service operation
   */
  @WebMethod(operationName = "put")
  public String put(@WebParam(name = "name") String txt) {
    return "Hello " + txt + " !";
  }

  /**
   * This is a sample web service operation
   */
  @WebMethod(operationName = "post")
  public String post(@WebParam(name = "name") String txt) {
    return "Hello " + txt + " !";
  }
}
