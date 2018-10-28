package nz.ac.auckland.concert.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import nz.ac.auckland.concert.common.Config;
import nz.ac.auckland.concert.domain.Concert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement a simple REST Web service for managing Concerts.
 *
 */

public class ConcertResource {

	private static Logger _logger = LoggerFactory
			.getLogger(ConcertResource.class);

	// Declare necessary instance variables.

 
	/**
	 * Retrieves a Concert based on its unique id. The HTTP response message 
	 * has a status code of either 200 or 404, depending on whether the 
	 * specified Concert is found. 
	 * 
	 * When clientId is null, the HTTP request message doesn't contain a cookie 
	 * named clientId (Config.CLIENT_COOKIE), this method generates a new 
	 * cookie, whose value is a randomly generated UUID. This method returns 
	 * the new cookie as part of the HTTP response message.
	 * 
	 * This method maps to the URI pattern <base-uri>/concerts/{id}.
	 * 
	 * @param id the unique ID of the Concert.
	 * 
	 * @param clientId a cookie named Config.CLIENT_COOKIE that may be sent 
	 * by the client.
	 * 
	 * @return a Response object containing the required Concert.
	 */
	public Response retrieveConcert(long id, Cookie clientId) {

	}
	

	/**
	 * Retrieves a collection of Concerts, where the "start" query parameter
     * identifies an index position, and "size" represents the maximum number
     * of successive Concerts to return. The HTTP response message returns 200.
     * 
     * When clientId is null, the HTTP request message doesn't contain a cookie 
	 * named clientId (Config.CLIENT_COOKIE), this method generates a new 
	 * cookie, whose value is a randomly generated UUID. This method returns 
	 * the new cookie as part of the HTTP response message.
	 * 
	 * This method maps to the URI pattern <base-uri>/concerts?start&size.
	 * 
	 * @param start the ID of a Concert from which to start retrieving 
	 * Concerts.
	 * 
	 * @param size the maximum number of Concerts to retrieve.
	 * 
	 * @param clientId a cookie named Config.CLIENT_COOKIE that may be sent 
	 * by the client.
	 * 
	 * @return a Response object containing a List of Concerts. The List may be
	 * empty.
	 */
	public Response retrieveConcerts(long start, int size, Cookie clientId) {
		// The Response object should store an ArrayList<Concert> entity. The 
		// ArrayList can be empty depending on the start and size arguments, 
		// and Concerts stored.
		//
		// Because of type erasure with Java Generics, any generically typed 
		// entity needs to be wrapped by a javax.ws.rs.core.GenericEntity that 
		// stores the generic type information. Hence to add an ArrayList as a
		// Response object's entity, you should use the following code:
		//
		// List<Concert> concerts = new ArrayList<Concert>();
		// GenericEntity<List<Concert>> entity = new GenericEntity<List<Concert>>(concerts) {};
		// ResponseBuilder builder = Response.ok(entity);
	
	}
	
	
	/**
	 * Creates a new Concert. This method assigns an ID to the new Concert and
	 * stores it in memory. The HTTP Response message returns a Location header 
	 * with the URI of the new Concert and a status code of 201.
	 * 
	 * When clientId is null, the HTTP request message doesn't contain a cookie 
	 * named clientId (Config.CLIENT_COOKIE), this method generates a new 
	 * cookie, whose value is a randomly generated UUID. This method returns 
	 * the new cookie as part of the HTTP response message.
	 * 
	 * This method maps to the URI pattern <base-uri>/concerts.
	 * 
	 * @param concert the new Concert to create.
	 * 
	 * @param clientId a cookie named Config.CLIENT_COOKIE that may be sent 
	 * by the client.
	 * 
	 * @return a Response object containing the status code 201 and a Location
	 * header.
	 */
	public Response createConcert(Concert concert, Cookie clientId) {

	}


	/**
	 * Deletes all Concerts, returning a status code of 204.  
	 * 
	 * When clientId is null, the HTTP request message doesn't contain a cookie 
	 * named clientId (Config.CLIENT_COOKIE), this method generates a new 
	 * cookie, whose value is a randomly generated UUID. This method returns 
	 * the new cookie as part of the HTTP response message.
	 * 
	 * This method maps to the URI pattern <base-uri>/concerts.
	 * 
	 * @param clientId a cookie named Config.CLIENT_COOKIE that may be sent 
	 * by the client.
	 * 
	 * @return a Response object containing the status code 204.
	 */
	public Response deleteAllConcerts(Cookie clientId) {
		
	}
	
	/**
	 * Helper method that can be called from every service method to generate a 
	 * NewCookie instance, if necessary, based on the clientId parameter.
	 * 
	 * @param userId the Cookie whose name is Config.CLIENT_COOKIE, extracted 
	 * from a HTTP request message. This can be null if there was no cookie 
	 * named Config.CLIENT_COOKIE present in the HTTP request message. 
	 * 
	 * @return a NewCookie object, with a generated UUID value, if the clientId 
	 * parameter is null. If the clientId parameter is non-null (i.e. the HTTP 
	 * request message contained a cookie named Config.CLIENT_COOKIE), this 
	 * method returns null as there's no need to return a NewCookie in the HTTP
	 * response message. 
	 */
	private NewCookie makeCookie(Cookie clientId){
		NewCookie newCookie = null;
		
		if(clientId == null) {
			newCookie = new NewCookie(Config.CLIENT_COOKIE, UUID.randomUUID().toString());
			_logger.info("Generated cookie: " + newCookie.getValue());
		} 
		
		return newCookie;
	}
}
