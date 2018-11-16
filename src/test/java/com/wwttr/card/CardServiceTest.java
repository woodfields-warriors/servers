package com.wwttr.card;

import com.wwttr.api.NotFoundException;
import com.wwttr.database.DatabaseFacade;
import com.wwttr.models.DestinationCard;
import com.wwttr.models.CreateResponse;
import com.wwttr.models.TrainCard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CardServiceTest {
  CardService cs = CardService.getInstance();
  DatabaseFacade df = DatabaseFacade.getInstance();
  private String[] name = {"test", "test2"};
  private Integer[] points = {1, 2};
  private TrainCard.Color[] trainCardColors = {TrainCard.Color.PINK,TrainCard.Color.GREEN};
  private TrainCard.State[] trainCardStates = {TrainCard.State.HIDDEN,TrainCard.State.HIDDEN};
  private Integer[] trainCardCounts = {5,20};
  GameServiceFacade gs = GameServiceFacade.getInstance();
  String GameId = null;
  String playerId = null;

  @Before
  public void setUp() throws Exception {
    cs.setDefaultTemplates();
    CreateResponse cr = gs.createGame("gameName", "user", 4);
    GameId = cr.getGameID();
    playerId = cr.getPlayerID();
  }

  @After
  public void tearDown() throws Exception {
    df.clearCards();
    df.clearUsers();
    df.clearGames();
    df.clearPlayers();
  }

  @Test
  public void generateDeckTemplate() {
    System.out.println("generateDeckTemplateTest");
    String[] name = {"test", "test2"};
    Integer[] point = {1, 2};
    try {
      cs.generateDestinationDeckTemplate(name, name, point);
      assert (cs.getFullDestinationDeckTemplate().size() == 2);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      fail();
    }
  }

  @Test
  public void createFullDeckForGame() {
    System.out.println("createFullDeckForGameTest");
    try {
      df.clearTrainCards();
      cs.generateTrainCardDeckTemplate(trainCardColors,trainCardStates,trainCardCounts);
      cs.generateDestinationDeckTemplate(name, name, points);
      cs.createFullDecksForGame(GameId);
      assert (df.getDestinationCards().size() == name.length);
      System.out.println("train card deck size = " + df.getTrainCards().size());
      assert (df.getTrainCards().size() == 25);
    } catch (Exception e) {
      e.printStackTrace();
      fail();
    }
  }

  @Test
  public void getDestinationCard() {
    System.out.println("getDestinationCardTest");
    try {
      cs.createFullDecksForGame(GameId);
      List<DestinationCard> cards = cs.peekDestinationCards(GameId);
      DestinationCard card = cs.getDestinationCard(cards.get(0).getId());
      assertNotNull(card);
    } catch (NotFoundException e) {
      e.printStackTrace();
      fail();
    }
  }

  @Test
  public void peekDestinationCards() {
    System.out.println("peekDestinationCardsTest");
    try {
      cs.createFullDecksForGame(GameId);
      List<DestinationCard> cards = cs.peekDestinationCards(GameId);
      assertNotNull(cards);
    } catch (NotFoundException e) {
      e.printStackTrace();
      fail();
    }
  }

  @Test
  public void claimDestinationCards(){
    System.out.println("claimDestinationCardsTest");
    try {
      cs.createFullDecksForGame(GameId);
      List<DestinationCard> cards = cs.peekDestinationCards(GameId);
      List<String> idsToClaim = new ArrayList<>();
      for (DestinationCard card : cards) {
        System.out.println(card.getId());
        idsToClaim.add(card.getId());
      }
      cs.claimDestinationCards(idsToClaim, playerId);
      for (int i = 0; i < cards.size(); i++) {
        assert (cs.getDestinationCard(cards.get(i).getId()).getPlayerId().equals(playerId));
      }
    } catch (NotFoundException e) {
      e.printStackTrace();
      fail();
    }
  }


  @Test
  public void streamDeckStats() {
  }

  @Test
  public void dealTrainCards() {
  }

  @Test
  public void claimTrainCardFromDeck() {
  }

  @Test
  public void claimFaceUpTrainCard() {
  }

  @Test
  public void getTrainCardsInHand() {
  }

  @Test
  public void streamTrainCards() {
  }
}
