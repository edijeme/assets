/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.config;

import java.sql.SQLException;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

/**
 *
 * @author edeje
 */
public class Utils {

  public static Response status200(JSONObject json) {
    return Response.ok(json.toJSONString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
  }

  public static Response status400(JSONObject json) {
    return Response.ok(json.toJSONString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
  }

  public static Response status404(JSONObject json) {
    return Response.status(Response.Status.NOT_FOUND).entity(json.toJSONString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
  }

  public static Response status500(JSONObject json) {
    return Response.serverError().entity(json.toJSONString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
  }

}
