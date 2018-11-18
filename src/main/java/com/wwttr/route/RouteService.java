package com.wwttr.route;

import java.util.*;
import java.util.stream.Stream;

import com.wwttr.api.ApiError;
import com.wwttr.database.DatabaseFacade;
import com.wwttr.api.NotFoundException;
import com.wwttr.models.TrainCard;
import com.wwttr.models.Route;


// Game Service is of the Singleton Pattern
public class RouteService {

  //singleton object
  private DatabaseFacade database;


  private static RouteService globalInstance;
  public static RouteService getInstance(){
    if(globalInstance == null){
      globalInstance = new RouteService();
    }
    return globalInstance;
  }

  private RouteService() {
    database = DatabaseFacade.getInstance();
  }

  public void initRoutes(String gameId) {
      database.addRoute(new Route("vancouver-seattle", "Vancouver", "Seattle",  TrainCard.Color.GREY, 1, gameId));
      database.addRoute(new Route("vancouver-seattle", "Vancouver", "Seattle",  TrainCard.Color.GREY, 1, gameId));
      database.addRoute(new Route("vancouver-calgary", "Vancouver", "Calgary",    TrainCard.Color.GREY, 3, gameId));
      database.addRoute(new Route("sanFrancisco-losAngeles", "San Francisco", "Los Angeles",   TrainCard.Color.PINK, 3, gameId));
      database.addRoute(new Route("sanFrancisco-losAngeles", "San Francisco", "Los Angeles",   TrainCard.Color.YELLOW, 3, gameId));
      database.addRoute(new Route("sanFrancisco-portland", "San Francisco", "Portland",  TrainCard.Color.PINK, 5, gameId));
      database.addRoute(new Route("sanFrancisco-portland", "San Francisco", "Portland",  TrainCard.Color.GREEN, 5, gameId));
      database.addRoute(new Route("sanFrancisco-saltLakeCity", "San Francisco", "Salt Lake City",  TrainCard.Color.ORANGE, 5, gameId));
      database.addRoute(new Route("sanFrancisco-saltLakeCity", "San Francisco", "Salt Lake City",  TrainCard.Color.WHITE, 5, gameId));
      database.addRoute(new Route("portland - Salt Lake City", "portland", "Salt Lake City", TrainCard.Color.BLUE,  6, gameId));
      database.addRoute(new Route("Seattle - Calgary", "Seattle", "Calgary", TrainCard.Color.GREY,  4, gameId));
      database.addRoute(new Route("Los Angeles - Las Vegas", "Los Angeles", "Las Vegas", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Los Angeles - Pheonix", "Los Angeles", "Pheonix", TrainCard.Color.GREY,   3, gameId));
      database.addRoute(new Route("Los Angeles - El Paso", "Los Angeles", "El Paso", TrainCard.Color.BLACK,  6, gameId));
      database.addRoute(new Route("Las Vegas - SaltLake City", "Las Vegas", "SaltLake City", TrainCard.Color.ORANGE,  3, gameId));
      database.addRoute(new Route("Calgary - Helena", "Calgary", "Helena", TrainCard.Color.GREY,    4, gameId));
      database.addRoute(new Route("Calgary - Winnipeg", "Calgary", "Winnipeg", TrainCard.Color.WHITE,    6, gameId));
      database.addRoute(new Route("Helena - Winnipeg", "Helena", "Winnipeg", TrainCard.Color.BLUE,    4, gameId));
      database.addRoute(new Route("Helena - Duluth", "Helena", "Duluth", TrainCard.Color.ORANGE,   6, gameId));
      database.addRoute(new Route("Helena - Omaha", "Helena", "Omaha", TrainCard.Color.RED,    5, gameId));
      database.addRoute(new Route("Helena - Denver", "Helena", "Denver", TrainCard.Color.GREEN,   4, gameId));
      database.addRoute(new Route("Salt Lake City - Helena", "Salt Lake City", "Helena", TrainCard.Color.PINK,  3, gameId));
      database.addRoute(new Route("Pheonix - El Paso", "Pheonix", "El Paso", TrainCard.Color.GREY,  3, gameId));
      database.addRoute(new Route("Pheonix - Santa Fe", "Pheonix", "Santa Fe", TrainCard.Color.GREY,   3, gameId));
      database.addRoute(new Route("Pheonix - Denver", "Pheonix", "Denver", TrainCard.Color.WHITE,  5, gameId));
      database.addRoute(new Route("Santa Fe - Denver", "Santa Fe", "Denver", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Santa Fe - El Paso", "Santa Fe", "El Paso", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Santa Fe - Oklahoma City", "Santa Fe", "Oklahoma City", TrainCard.Color.BLUE,   3, gameId));
      database.addRoute(new Route("El Paso - Oklahoma City", "El Paso", "Oklahoma City", TrainCard.Color.YELLOW,  5, gameId));
      database.addRoute(new Route("El Paso - Houston", "El Paso", "Houston", TrainCard.Color.GREEN,  6, gameId));
      database.addRoute(new Route("Dallas - El Paso", "Dallas", "El Paso", TrainCard.Color.RED,  4, gameId));
      database.addRoute(new Route("Denver - Salt Lake City", "Denver", "Salt Lake City", TrainCard.Color.RED,  3, gameId));
      database.addRoute(new Route("Denver - Salt Lake City", "Denver", "Salt Lake City", TrainCard.Color.YELLOW,  3, gameId));
      database.addRoute(new Route("Denver - Oklahoma City", "Denver", "Oklahoma City", TrainCard.Color.RED,  4, gameId));
      database.addRoute(new Route("Denver - Kansas City", "Denver", "Kansas City", TrainCard.Color.ORANGE,  4, gameId));
      database.addRoute(new Route("Denver - Kansas City", "Denver", "Kansas City", TrainCard.Color.BLACK,  4, gameId));
      database.addRoute(new Route("Denver - Omaha", "Denver", "Omaha", TrainCard.Color.PINK,   4, gameId));
      database.addRoute(new Route("Duluth - Winnipeg", "Duluth", "Winnipeg", TrainCard.Color.BLACK,   4, gameId));
      database.addRoute(new Route("Duluth - Sault St. Marie", "Duluth", "Sault St. Marie", TrainCard.Color.GREY,   3, gameId));
      database.addRoute(new Route("Duluth - Toronto", "Duluth", "Toronto", TrainCard.Color.PINK,  6, gameId));
      database.addRoute(new Route("Duluth - Chicago", "Duluth", "Chicago", TrainCard.Color.RED,  3, gameId));
      database.addRoute(new Route("Duluth - Omaha", "Duluth", "Omaha", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Duluth - Omaha", "Duluth", "Omaha", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Winnipeg - Sault St. Mary", "Winnipeg", "Sault St. Mary", TrainCard.Color.GREY,    6, gameId));
      database.addRoute(new Route("Omaha - Chicago", "Omaha", "Chicago", TrainCard.Color.BLUE,   4, gameId));
      database.addRoute(new Route("Omaha - Kansas City", "Omaha", "Kansas City", TrainCard.Color.BLUE,   1, gameId));
      database.addRoute(new Route("Omaha - Kansas City", "Omaha", "Kansas City", TrainCard.Color.PINK,   1, gameId));
      database.addRoute(new Route("Oklahoma City - Kansas City", "Oklahoma City", "Kansas City", TrainCard.Color.GREY,  2, gameId));
      database.addRoute(new Route("Oklahoma City - Kansas City", "Oklahoma City", "Kansas City", TrainCard.Color.GREY,  2, gameId));
      database.addRoute(new Route("Oklahoma City - Little Rock", "Oklahoma City", "Little Rock", TrainCard.Color.GREY,  2, gameId));
      database.addRoute(new Route("Oklahoma City - Dallas", "Oklahoma City", "Dallas", TrainCard.Color.GREY,  2, gameId));
      database.addRoute(new Route("Oklahoma City - Dallas", "Oklahoma City", "Dallas", TrainCard.Color.GREY,  2, gameId));
      database.addRoute(new Route("Dallas - Houston", "Dallas", "Houston", TrainCard.Color.GREY,  1, gameId));
      database.addRoute(new Route("Dallas - Houston", "Dallas", "Houston", TrainCard.Color.GREY,  1, gameId));
      database.addRoute(new Route("Dallas - Little Rock", "Dallas", "Little Rock", TrainCard.Color.GREY,  2, gameId));
      database.addRoute(new Route("New Orleans - Little Rock", "New Orleans", "Little Rock", TrainCard.Color.GREEN,  3, gameId));
      database.addRoute(new Route("New Orleans - Houston", "New Orleans", "Houston", TrainCard.Color.GREY,  2, gameId));
      database.addRoute(new Route("New Orleans - Atlanta", "New Orleans", "Atlanta", TrainCard.Color.YELLOW,   4, gameId));
      database.addRoute(new Route("New Orleans - Atlanta", "New Orleans", "Atlanta", TrainCard.Color.ORANGE,   4, gameId));
      database.addRoute(new Route("New Orleans - Miami", "New Orleans", "Miami", TrainCard.Color.RED,  6, gameId));
      database.addRoute(new Route("Saint Louis - Little Rock", "Saint Louis", "Little Rock", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Saint Louis - Nashville", "Saint Louis", "Nashville", TrainCard.Color.GREY,    2, gameId));
      database.addRoute(new Route("Saint Louis - Pittsburgh", "Saint Louis", "Pittsburgh", TrainCard.Color.GREEN,    5, gameId));
      database.addRoute(new Route("Saint Louis - Chicago", "Saint Louis", "Chicago", TrainCard.Color.GREEN,   2, gameId));
      database.addRoute(new Route("Saint Louis - Chicago", "Saint Louis", "Chicago", TrainCard.Color.WHITE,   2, gameId));
      database.addRoute(new Route("Nashville - Little Rock", "Nashville", "Little Rock", TrainCard.Color.WHITE,   3, gameId));
      database.addRoute(new Route("Nashville - Atlanta", "Nashville", "Atlanta", TrainCard.Color.GREY,    1, gameId));
      database.addRoute(new Route("Nashville - Raleigh", "Nashville", "Raleigh", TrainCard.Color.BLACK,   3, gameId));
      database.addRoute(new Route("Nashville - Pittsburgh", "Nashville", "Pittsburgh", TrainCard.Color.YELLOW,    4, gameId));
      database.addRoute(new Route("Pittsburgh - Chicago", "Pittsburgh", "Chicago", TrainCard.Color.ORANGE,   3, gameId));
      database.addRoute(new Route("Pittsburgh - Chicago", "Pittsburgh", "Chicago", TrainCard.Color.BLACK,   3, gameId));
      database.addRoute(new Route("Pittsburgh - Raleigh", "Pittsburgh", "Raleigh", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Pittsburgh - Washington", "Pittsburgh", "Washington", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Pittsburgh - New York", "Pittsburgh", "New York", TrainCard.Color.WHITE,   2, gameId));
      database.addRoute(new Route("Pittsburgh - New York", "Pittsburgh", "New York", TrainCard.Color.GREEN,   2, gameId));
      database.addRoute(new Route("Pittsburgh - Toronto", "Pittsburgh", "Toronto", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Atlanta - Miami", "Atlanta", "Miami", TrainCard.Color.BLUE,   5, gameId));
      database.addRoute(new Route("Atlanta - Charleston", "Atlanta", "Charleston", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Atlanta - Raleigh", "Atlanta", "Raleigh", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Atlanta - Raleigh", "Atlanta", "Raleigh", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Charleston - Raleigh", "Charleston", "Raleigh", TrainCard.Color.GREY,  2, gameId));
      database.addRoute(new Route("Charleston - Miami", "Charleston", "Miami", TrainCard.Color.PINK,  4, gameId));
      database.addRoute(new Route("Releigh - Washington", "Releigh", "Washington", TrainCard.Color.GREY,  2, gameId));
      database.addRoute(new Route("Releigh - Washington", "Releigh", "Washington", TrainCard.Color.GREY,  2, gameId));
      database.addRoute(new Route("New York - Washington", "New York", "Washington", TrainCard.Color.ORANGE,  2, gameId));
      database.addRoute(new Route("New York - Washington", "New York", "Washington", TrainCard.Color.BLACK,  2, gameId));
      database.addRoute(new Route("New York - Boston", "New York", "Boston", TrainCard.Color.YELLOW,  2, gameId));
      database.addRoute(new Route("New York - Boston", "New York", "Boston", TrainCard.Color.RED,  2, gameId));
      database.addRoute(new Route("New York - Montreal", "New York", "Montreal", TrainCard.Color.BLUE,   3, gameId));
      database.addRoute(new Route("Montreal - Boston", "Montreal", "Boston", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Montreal - Boston", "Montreal", "Boston", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Montreal - Toronto", "Montreal", "Toronto", TrainCard.Color.GREY,   3, gameId));
      database.addRoute(new Route("Montreal - Sault St. Marie", "Montreal", "Sault St. Marie", TrainCard.Color.BLACK,    5, gameId));
      database.addRoute(new Route("Toronto - Sault St. Marie", "Toronto", "Sault St. Marie", TrainCard.Color.GREY,   2, gameId));
      database.addRoute(new Route("Toronto - Chicago", "Toronto", "Chicago", TrainCard.Color.WHITE,  4, gameId));
      database.addRoute(new Route("seattle - Helena", "seattle", "Helena", TrainCard.Color.YELLOW,  6, gameId));
      database.addRoute(new Route("Kansas City - Saint Louis", "Kansas City", "Saint Louis", TrainCard.Color.PINK,   2, gameId));
      database.addRoute(new Route("Kansas City - Saint Louis", "Kansas City", "Saint Louis", TrainCard.Color.BLUE,   2, gameId));
  }

  public Stream<Route> streamRoutes(String gameId) {
    return database.streamRoutes().filter((Route r) -> r.getGameId().equals(gameId));
  }


}