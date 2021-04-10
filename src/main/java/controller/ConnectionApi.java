package main.java.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionApi{

	public List<LineModelEntity> APIGet() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		
		ResteasyWebTarget apiUrl = client.target("http://localhost:8080/api/linemodel");
		
		Response apiUrlResponse = apiUrl.request().get();
		
		String getAll = apiUrlResponse.readEntity(String.class);
		apiUrlResponse.close();
		
		Type listType = new TypeToken<ArrayList<LineModelEntity>>(){}.getType();
        List<LineModelEntity> listaJson = new Gson().fromJson(getAll, listType);
		
		return listaJson;
	}
}
