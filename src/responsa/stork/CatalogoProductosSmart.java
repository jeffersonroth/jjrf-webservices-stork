package responsa.stork;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import responsa.stork.db.query.getCatalogoProductosSmart;



/**
 * @author Jefferson Johannes Roth Filho (jjrothfilho@gmail.com)
 *
 */
@Path("/Smart")
public class CatalogoProductosSmart extends Application {

	/**
	 * id to query
	 */
	private String _ID_TO_QUERY = null;
	
	/**
	 * 'EMPRESA' to query
	 * @throws URISyntaxException 
	 */
	//private String _EMPRESA_TO_QUERY = null;
	
	private String INFOSMART_PATH = "/WEB-INF/InfoSmart.jsp";
	
	@Context HttpServletRequest request;
    @Context HttpServletResponse response;
	
	@GET
    @Path("{idQuery: .*}")
    @Produces("application/json")
    public void getSmart(@PathParam("idQuery") String idQuery) throws ParseException, ServletException, IOException {

		_ID_TO_QUERY = idQuery;
		if(!paramHasContent(_ID_TO_QUERY) || !paramHasContent(idQuery)) {
			
			System.out.println("CatalogoProductosSmart.java idQuery is NULL!");
			getInfoSmart(request, response);
			
		} else {

			System.out.println("CatalogoProductosSmart.java _ID_TO_QUERY: " + _ID_TO_QUERY);
			getSmartResponse(_ID_TO_QUERY);
			
		}
    	
    }
	
	protected Response getSmartResponse(String idQuery) throws ParseException, ServletException, IOException {

		_ID_TO_QUERY = idQuery;
		String ResponseValue = null;
	    	
    	System.out.println("CatalogoProductosSmart.java getCatalogoProductosSmart.main(" + _ID_TO_QUERY + ")");
    	ResponseValue = getCatalogoProductosSmart.main(_ID_TO_QUERY);
    	
    	if(ResponseValue == null || !paramHasContent(ResponseValue)) {
    		throw new NotFoundException();
    	}
  
    	return Response.status(200).entity(ResponseValue).build();
    	
    }
	
	protected void getInfoSmart(@Context HttpServletRequest request, 
                        @Context HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(INFOSMART_PATH);
		RequestDispatcher rd = request.getRequestDispatcher(INFOSMART_PATH);
		rd.forward(request, response);
    }
	
	private boolean paramHasContent(String param){
	    String EMPTY_STRING = "";
	    return (param != null) && (!param.trim().equals(EMPTY_STRING));
	  }
	
}
