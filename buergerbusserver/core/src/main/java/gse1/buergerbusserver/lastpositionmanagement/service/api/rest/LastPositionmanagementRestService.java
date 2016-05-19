package gse1.buergerbusserver.lastpositionmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import gse1.buergerbusserver.lastpositionmanagement.dataaccess.api.LastPositionEntity;
import gse1.buergerbusserver.lastpositionmanagement.logic.api.to.LastPositionEto;

/**
 *
 *
 * @author razadfki
 * @since 0.1
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/busmanagement/v1")
public interface LastPositionmanagementRestService {

  @GET
  @Path("/getLastPosition/{busId}/")
  public LastPositionEto getLastPosition(@PathParam("busId") String busId);

  @POST
  @Path("/setLastPosition/")
  public void setLastPosition(LastPositionEntity lpe);
  /*
   * public void setLastPosition(@FormParam("busId") Long busId, @FormParam("lon") double lon,
   * 
   * @FormParam("lat") double lat);
   */

}
