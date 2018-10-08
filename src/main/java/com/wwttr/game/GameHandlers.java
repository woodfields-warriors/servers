package com.wwttr.game;

import com.google.protobuf.RpcController;
import com.wwttr.models.CreateResponse;
import com.wwttr.models.Game;
import java.util.*;
import com.wwttr.api.ApiError;
import com.wwttr.auth.AuthService;
import com.wwttr.api.Code;

public class GameHandlers implements Api.GameService.BlockingInterface {

  private GameService service;
  private AuthService authService;

  public GameHandlers(GameService service, AuthService authService) {
    this.service = service;
    this.authService = authService;
  }

  //Creates a player object, then creates a game and adds that to the
  // the database.  Then it gives the created player the game that was
  // created so that player knows what game it is a part of
  // then it returns the game Id and playerID
  public Api.CreateResponse createGame(RpcController controller, Api.CreateGameRequest request) {

    // Validate input
    if (request.getDisplayName() == "") {
      throw new ApiError(Code.INVALID_ARGUMENT, "argument 'display_name' is required");
    }
    if (request.getUserId() == "") {
      throw new ApiError(Code.INVALID_ARGUMENT, "argument 'host_user_id' is required");
    }
    int maxPlayers = request.getMaxPlayers();
    if (maxPlayers == 0) {
      maxPlayers = 5;
    }
    if(maxPlayers < 2 || maxPlayers > 6){
      throw new ApiError(Code.INVALID_ARGUMENT,"argument 'max_players' must be between 2 and 6");
    }
    CreateResponse response = service.createGame(request.getDisplayName(),request.getUserId(),
                                                 request.getMaxPlayers());
    Api.CreateResponse.Builder builder = Api.CreateResponse.newBuilder();
    builder.setGameId(response.getGameID());
    builder.setPlayerId(response.getPlayerID());
    return builder.build();
  }

  public Api.Empty leaveGame(RpcController controller, Api.LeaveGameRequest request) {
    service.leaveGame(request.getPlayerId(),request.getGameId());
    Api.Empty.Builder toReturn = Api.Empty.newBuilder();
    return toReturn.build();
  }

  public Api.ListGamesResponse listGames(RpcController controller, Api.ListGamesRequest request) {
    List<Game> allGames = service.listGames();
    List<Api.Game> protoGames = new ArrayList<Api.Game>();
    for(Game game: allGames){
      Api.Game.Builder gameBuilder = Api.Game.newBuilder();
      gameBuilder.setGameId(game.getGameID());
      gameBuilder.setDisplayName(game.getDisplayName());
      gameBuilder.setMaxPlayers(game.getMaxPlayers());
      gameBuilder.setHostPlayerId(game.getHostPlayerID());
      for(String i: game.getPlayerIDs()){
        gameBuilder.addPlayerIds(i);
      }
      protoGames.add(gameBuilder.build());
    }
    Api.ListGamesResponse.Builder responseBuilder = Api.ListGamesResponse.newBuilder();
    for(Api.Game game: protoGames){
      responseBuilder.addGames(game);
    }
    //responseBuilder.setGames(protoGames);
    return responseBuilder.build();



    // if (authService.getAccount(game.getHostUserId()) == null) {
    //   throw new ApiException(Code.NOT_FOUND, "host user " + game.getHostUserId() + " was not found");
    // }

    // Execute request
  }

  public Api.Game getGame(RpcController controller, Api.GetGameRequest request) {
    Game game = service.getGame(request.getGameId());
    if (game == null){
        throw new ApiError(Code.NOT_FOUND, "Game with that ID not found");
    }
    Api.Game.Builder gameBuilder = Api.Game.newBuilder();
    gameBuilder.setGameId(game.getGameID());
    gameBuilder.setDisplayName(game.getDisplayName());
    gameBuilder.setMaxPlayers(game.getMaxPlayers());
    gameBuilder.setHostPlayerId(game.getHostPlayerID());
    for(String i: game.getPlayerIDs()){
      gameBuilder.addPlayerIds(i);
    }
    return gameBuilder.build();
  }



  public Api.Game startGame(RpcController controller, Api.StartGameRequest request){
    Game game = service.startGame(request.getGameId());
    Api.Game.Builder gameBuilder = Api.Game.newBuilder();
    gameBuilder.setGameId(game.getGameID());
    gameBuilder.setDisplayName(game.getDisplayName());
    gameBuilder.setMaxPlayers(game.getMaxPlayers());
    gameBuilder.setHostPlayerId(game.getHostPlayerID());
    for(String i: game.getPlayerIDs()){
      gameBuilder.addPlayerIds(i);
    }
    return gameBuilder.build();
  }

  public Api.Empty deleteGame(RpcController controller, Api.DeleteGameRequest request) {
    service.deleteGame(request.getGameId());
    Api.Empty.Builder toReturn = Api.Empty.newBuilder();
    return toReturn.build();
  }

  // This method is the replacement for JoinGame().
  // It takes the given request and creates a Player object,
  //   adds that player to the requested game then returns the player ID
  // in the createPlayerResponse
  public Api.CreatePlayerResponse createPlayer(RpcController controller, Api.CreatePlayerRequest request){
    String newPlayerID = service.createPlayer(request.getUserId(), request.getGameId());
    Api.CreatePlayerResponse.Builder toReturn = Api.CreatePlayerResponse.newBuilder();
    toReturn.setPlayerId(newPlayerID);
    return toReturn.build();
  }

}
