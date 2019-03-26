/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.status;

import com.apirest.config.StringConfig;
import com.apirest.config.Utils;
import com.apirest.system.Conexion;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@Path("/status")
public class StatusRest {

  Conexion con = null;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/")
  public Response getStatus() {
    HashMap<String, Object> out = new HashMap<>();
    JSONObject json = new JSONObject();
    List<StatusDto> lst = null;
    try {
      con = new Conexion();
      Connection conex = con.getConnection();
      Statement s = conex.createStatement();
      ResultSet rs;
      String sql = "SELECT idStatus 'id', nameStatus 'name' FROM status";
      rs = s.executeQuery(sql);
      lst = new ArrayList<>();
      boolean empty = false;
      StatusDto dto = null;
      while (rs.next()) {
        empty = true;
        dto = new StatusDto();
        dto.setId(rs.getInt("id"));
        dto.setName(rs.getString("name"));
        lst.add(dto);
      }
      if (!empty) {
        out.put(StringConfig.STATUS, Response.Status.NOT_FOUND.getStatusCode());
        out.put(StringConfig.STATUS_TEXT, StringConfig.STATUS_TEXT_NOT_FOUND);
        json.putAll(out);
        return Utils.status404(json);
      } else {
        out.put(StringConfig.STATUS, Response.Status.OK.getStatusCode());
        out.put(StringConfig.STATUS_TEXT, StringConfig.STATUS_TEXT_SUCCESS);
      }
      Gson gson = new Gson();
      out.put(StringConfig.DATA, gson.toJsonTree(lst));
      json.putAll(out);
      con.close();
    } catch (SQLException ex) {
      con.close();
      out.put(StringConfig.STATUS, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
      out.put(StringConfig.STATUS_TEXT, ex.getMessage());
      json.putAll(out);
      return Utils.status500(json);
    }
    return Utils.status200(json);
  }

}
