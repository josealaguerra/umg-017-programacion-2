/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import Controlador.Util;
import DAO.rolDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import Modelo.rol;

/**
 * REST Web Service
 *
 * @author josea
 */
@Path("Rol")
public class RolResource {

    @Context
    private UriInfo context;
    
    static final List<rol> lr = new ArrayList<>();

    /**
     * Creates a new instance of EstadoCivilResource
     */
    public RolResource() {
    }

    /**
     * Retrieves representation of an instance of Entidad.RolResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RolResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    /**
     * Retrieves representation of an instance of Entidad.RolResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("lista")
    @Produces(MediaType.APPLICATION_JSON)
    public List<rol> getListRol() {
        /*
        rol nuevoRol =new rol();
        nuevoRol.setId_rol(29);
        nuevoRol.setNombre_rol("Jose");
        
        lr.add(nuevoRol);
        
        return lr;
        */

        rolDAO rdao = null;
        List<rol> listaRoles = null;
        try{
            rdao = new rolDAO();
            listaRoles = new ArrayList<>();
            listaRoles = rdao.seleccionaTodo();
/*
            for(rol rolItem:listaRoles){
                lr.add(rolItem);
            }
            */
        }catch(Exception e){
            Util.printException("RolResource.insertRol", e);
        }

        return listaRoles;
    }    
    
    /**
     * Retrieves representation of an instance of Entidad.RolResource
     * @return an instance of java.lang.String
     */
    @POST
    @Path("insertar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<rol> insertRol(rol r) {

        rolDAO rdao = null;
        List<rol> listaRoles = null;
        try{

            rdao = new rolDAO();
            if( ! rdao.inserta(r) ){
                System.out.println("Error al insertar rol: "+r.getNombre_rol());
            }
            
            lr.removeAll(lr);            

            listaRoles = new ArrayList<>();
            listaRoles = rdao.seleccionaTodo();

            for(rol rolItem:listaRoles){
                lr.add(rolItem);
            }
        }catch(Exception e){
            Util.printException("RolResource.insertRol", e);
        }

        return lr;
    }  
    
    /**
     * Retrieves representation of an instance of Entidad.RolResource
     * @return an instance of java.lang.String
     */
    @POST
    @Path("actualizar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<rol> updateRol(rol r) {
        lr.add(r);
        return lr;
    }      
    
    /**
     * Retrieves representation of an instance of Entidad.RolResource
     * @return an instance of java.lang.String
     */
    @POST
    @Path("eliminar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<rol> deleteRol(rol r) {
        lr.add(r);
        return lr;
    }          
    
}
