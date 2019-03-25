/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.config;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author DyE
 */
@ApplicationPath("rest")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    addRestResourceClasses(resources);
    return resources;
  }

  /**
   * Do not modify addRestResourceClasses() method. It is automatically
   * populated with all resources defined in the project. If required, comment
   * out calling this method in getClasses().
   */
  private void addRestResourceClasses(Set<Class<?>> resources) {
    resources.add(com.apirest.assets.AssetsRest.class);
    resources.add(com.apirest.assets.area.AreaRest.class);
    resources.add(com.apirest.assets.person.PersonRest.class);
    resources.add(com.apirest.assets.status.StatusRest.class);
    resources.add(com.apirest.assets.typeassignment.TypeAssignmentRest.class);
    resources.add(com.apirest.person.PersonRest.class);
    resources.add(com.apirest.type.assig.TypeAssig.class);
  }

}
