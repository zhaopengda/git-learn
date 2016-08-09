package com.poly.common;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
	
	 private static String username = "test";
	 private static String password = "test";
	 private static String dbName = "testDb"; 			//数据库
	 private static String collectionName = "log";		//集合
	 private static MongoClient mongoClient;
	 private static MongoCollection eventsCollection;
	 
	 /**
	  * 获取mongo连接
	  */
	 public static MongoClient getConnection(){
	     ServerAddress serverAddress = new ServerAddress("192.168.1.112", 27017);
 		 List<ServerAddress> address = new ArrayList<ServerAddress>();
 		 address.add(serverAddress);
 		 MongoCredential credential = MongoCredential.createScramSha1Credential(username, dbName,
 				password.toCharArray());
 		 List<MongoCredential> credentials = new ArrayList<MongoCredential>();
 		 credentials.add(credential);
 		 
 		 mongoClient = new MongoClient(address, credentials);
 		 return mongoClient;
	 }
	 
	 /**
	  * 获取集合
	  * @return
	  */
	 public static MongoCollection getCollection(){
		 getConnection();
		 MongoDatabase db = getConnection().getDatabase(dbName);
 		 eventsCollection = db.getCollection(collectionName);
 		 return eventsCollection;
	 }
	 
	 /**
	  * 查询集合中所有文档
	  */
	 public static void findAll(){
		 eventsCollection = getCollection();
 		 FindIterable table = eventsCollection.find();
 		 MongoCursor  mCursor = table.iterator();

 		 while (mCursor.hasNext()) {
			System.out.println(mCursor.next());
		 }
	 }
	 
	 /**
	  * 条件查询（AND）
	  */
	 public static void findByParam(){
		 BasicDBObject dbObject = new BasicDBObject();
		 dbObject.put("level", "INFO");
		 dbObject.put("thread", "http-nio-8080-exec-27");

		 eventsCollection = getCollection();
		 MongoCursor cursor = eventsCollection.find(dbObject).iterator();
		 while (cursor.hasNext()) {
			System.out.println(cursor.next());
		 }
	 }
	 
	 public static void main( String args[] ){
		 findAll();
//		 findByParam();
	 }

}
