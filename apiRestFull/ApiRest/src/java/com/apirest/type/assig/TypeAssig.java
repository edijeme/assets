/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.type.assig;

import com.apirest.config.Mnemonic;
import com.apirest.system.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

/**
 *
 * @author DyE
 */
@Path("/typeassig")
public class TypeAssig {

  Conexion con = null;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/lstypeassig")
  public Response lstTypeAssig() {
    HashMap<String, Object> out = new HashMap<>();
    JSONObject json = new JSONObject();
    try {
      JSONObject dtJson = new JSONObject();
      HashMap<Integer, String> data = new HashMap<>();
      con = new Conexion();
      Connection conex = con.getConnection();
      Statement s = conex.createStatement();
      ResultSet rs;
      String sql = "SELECT * FROM typeAssignment";
      rs = s.executeQuery(sql);
      out.put(Mnemonic.STATUS, Mnemonic.STATUS_NOT_FOUND);
      out.put(Mnemonic.STATUS_TEXT, Mnemonic.STATUS_TEXT_NOT_FOUND);
      while (rs.next()) {
        out.put(Mnemonic.STATUS, Mnemonic.STATUS_SUCCESS);
        out.put(Mnemonic.STATUS_TEXT, Mnemonic.STATUS_TEXT_SUCCESS);
        data.put(rs.getInt("idTypeAss"), rs.getString("nameTypeAss"));
      }
      dtJson.putAll(data);
      out.put(Mnemonic.DATA, dtJson);
      json.putAll(out);
      con.close();
    } catch (SQLException ex) {
      con.close();
      out.put(Mnemonic.STATUS, Mnemonic.STATUS_ERROR);
      out.put(Mnemonic.STATUS_TEXT, ex.getMessage());
      json.putAll(out);
    }
    return Response.ok(json.toJSONString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
  }
}
