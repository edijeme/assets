/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.assets;

import com.apirest.config.StringConfig;
import com.apirest.config.Utils;
import com.apirest.system.Conexion;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

/**
 *
 * @author DyE
 */
@Path("/assets")
public class AssetsRest {

  Conexion con = null;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/listassest")
  public Response listAssest() {
    HashMap<String, Object> out = new HashMap<>();
    JSONObject json = new JSONObject();
    List<AssetsDto> lst = new ArrayList<>();
    Gson gson = new Gson();
    try {
      JSONObject dtJson = new JSONObject();
      HashMap<Integer, Object> data = new HashMap<>();
      con = new Conexion();
      Connection conex = con.getConnection();
      Statement s = conex.createStatement();
      ResultSet rs;
      String sql = "CALL getAssets()";
      rs = s.executeQuery(sql);
      AssetsDto dt = null;
      boolean empty = false;
      while (rs.next()) {
        empty = true;
        dt = new AssetsDto();
        dt.setColourAssets(rs.getString("colourAssets"));
        dt.setDateBuyAssets(rs.getString("dateBuyAssets"));
        dt.setDateLowAssets(rs.getString("dateLowAssets"));
        dt.setDescptAssets(rs.getString("descptAssets"));
        dt.setHeightAssets(rs.getString("heightAssets"));
        dt.setIdAsig(rs.getInt("idAsig"));
        dt.setIdAssets(rs.getInt("idAssets"));
        dt.setIdStatus(rs.getInt("idStatus"));
        dt.setIdTypeAss(rs.getInt("idTypeAss"));
        dt.setInternalNumAssets(rs.getString("internalNumAssets"));
        dt.setNameAsig(rs.getString("nameAsig"));
        dt.setNameAssets(rs.getString("nameAssets"));
        dt.setNameStatus(rs.getString("nameStatus"));
        dt.setNameTypeAss(rs.getString("nameTypeAss"));
        dt.setSerialAssets(rs.getString("serialAssets"));
        dt.setTypeAssets(rs.getString("typeAssets"));
        dt.setValueBuyAssets(rs.getString("valueBuyAssets"));
        dt.setWeightAssets(rs.getString("weightAssets"));
        dt.setWidthAssets(rs.getString("widthAssets"));
        lst.add(dt);
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
      dtJson.putAll(data);
      out.put(StringConfig.DATA, gson.toJsonTree(lst));
      json.putAll(out);
      con.close();
    } catch (Exception ex) {
      con.close();
      out.put(StringConfig.STATUS, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
      out.put(StringConfig.STATUS_TEXT, ex.getMessage());
      json.putAll(out);
      return Utils.status500(json);
    }
    return Utils.status200(json);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getid/{id}")
  public Response getAssestById(@PathParam("id") String id) {
    HashMap<String, Object> out = new HashMap<>();
    JSONObject json = new JSONObject();
    List<AssetsDto> lst = null;
    try {
      con = new Conexion();
      Connection conex = con.getConnection();
      Statement s = conex.createStatement();
      ResultSet rs;
      String sql = "CALL getAssestsById('" + id + "')";
      rs = s.executeQuery(sql);
      lst = new ArrayList<>();
      boolean empty = false;
      AssetsDto dt = null;
      while (rs.next()) {
        empty = true;
        dt = new AssetsDto();
        dt.setColourAssets(rs.getString("colourAssets"));
        dt.setDateBuyAssets(rs.getString("dateBuyAssets"));
        dt.setDateLowAssets(rs.getString("dateLowAssets"));
        dt.setDescptAssets(rs.getString("descptAssets"));
        dt.setHeightAssets(rs.getString("heightAssets"));
        dt.setIdAsig(rs.getInt("idAsig"));
        dt.setIdAssets(rs.getInt("idAssets"));
        dt.setIdStatus(rs.getInt("idStatus"));
        dt.setIdTypeAss(rs.getInt("idTypeAss"));
        dt.setInternalNumAssets(rs.getString("internalNumAssets"));
        dt.setNameAsig(rs.getString("nameAsig"));
        dt.setNameAssets(rs.getString("nameAssets"));
        dt.setNameStatus(rs.getString("nameStatus"));
        dt.setNameTypeAss(rs.getString("nameTypeAss"));
        dt.setSerialAssets(rs.getString("serialAssets"));
        dt.setTypeAssets(rs.getString("typeAssets"));
        dt.setValueBuyAssets(rs.getString("valueBuyAssets"));
        dt.setWeightAssets(rs.getString("weightAssets"));
        dt.setWidthAssets(rs.getString("widthAssets"));
        lst.add(dt);
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
