package com.wwttr.dao;

import com.wwttr.database.DatabaseFacade;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.PipedOutputStream;
import java.io.PipedInputStream;

public class UserDAOSQL extends UserDAO {

  protected Connection conn;

  public UserDAOSQL(Connection conn) {
    this.conn = conn;
  }

  @Override
  public DatabaseFacade loadFromPersistence() {
    try {
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery("SELECT data FROM users where userId = '1'");
      if (!result.next()) {
        return new DatabaseFacade();
      }
      ObjectInputStream objectInputStream = new ObjectInputStream(result.getBinaryStream("data"));
      DatabaseFacade toReturn = (DatabaseFacade) objectInputStream.readObject();
      result.close();
      statement.close();
      return toReturn;
    }
    catch (SQLException e){
      e.printStackTrace();
      //throw new IllegalArgumentException("SQL read exception");
      return new DatabaseFacade();
    }
    catch (IOException e){
      e.printStackTrace();
      throw new IllegalArgumentException("Object Conversion Error");
    }
    catch (ClassNotFoundException e){
      e.printStackTrace();
      throw new IllegalArgumentException("Object Conversion to Database Error");
    }
    catch (Exception e) {
      e.printStackTrace();
      return new DatabaseFacade();
    }

  }

  @Override
  public void saveToPersistence(DatabaseFacade facade) {
    try {

      java.io.ByteArrayOutputStream buf = new java.io.ByteArrayOutputStream();
      java.io.ObjectOutputStream outputStream = new java.io.ObjectOutputStream(buf);
      outputStream.writeObject(facade);
      outputStream.close();

      java.io.InputStream in = new java.io.ByteArrayInputStream(buf.toByteArray());

      PreparedStatement statement = conn.prepareStatement("INSERT INTO users (userId,data) VALUES(?,?) ON CONFLICT (userId) DO UPDATE SET data = EXCLUDED.data");
      statement.setString(1,"1");
      statement.setBinaryStream(2, in);
      statement.executeUpdate();
      statement.close();
    }
    catch (SQLException e){
      e.printStackTrace();
      throw new IllegalArgumentException("SQL read exception");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
