package www;

import java.io.File;

import spark.Spark;
import www.blog.Bobagento;
import www.blog.NaoSalvo;

public class Main {
   public static void main(String[] args) {
	   String parent = new File(Main.class.getResource("index.html").getPath()).getParent();
	   System.out.println(parent);
	   spark.SparkBase.externalStaticFileLocation(parent);
	   
       Spark.get("/pirate/:search", "application/json", (request, response) -> {
           String search = request.params(":search");
           return PirateBay.search(search);
       }, new JsonTransformer());

       Spark.get("/naosalvo", "application/json", (request, response) -> {
    	   return NaoSalvo.open();
       }, new JsonTransformer());
       
       Spark.get("/bobagento", "application/json", (request, response) -> {
    	   return Bobagento.open();
       }, new JsonTransformer());

   }
}