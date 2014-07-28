package www;

import spark.ResponseTransformer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonTransformer implements ResponseTransformer {

    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    @Override
    public String render(Object model) {
    	try{
    		return gson.toJson(model);
    	}catch(Exception e){
    		return "{'ErrorMessage':'"+e.getMessage()+"'}";
    	}
    }

}