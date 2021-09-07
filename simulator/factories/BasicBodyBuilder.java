package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;

public class BasicBodyBuilder extends Builder<Body> {

	
	//··Constructor BasicBodyBuilder
	public BasicBodyBuilder() {
		super("basic", "Default body");
	}
	
	
	//·Método createTheInstance
	protected Body createTheInstance(JSONObject jsonObject){ //Retorna un objeto body básico
		
		JSONArray paux = jsonObject.getJSONArray("p");
		Vector2D p = new Vector2D(paux.getDouble(0), paux.getDouble(1));
		
		JSONArray vaux = jsonObject.getJSONArray("v");
		Vector2D v = new Vector2D(vaux.getDouble(0), vaux.getDouble(1));
		
		String id = jsonObject.getString("id");
		
		double m =  jsonObject.getDouble("m");
		
		return new Body(v,p,m,id); //Creamos el nuevo objeto
	}
	
	
	//·Método createData
	protected  JSONObject createData() { //Retorna un JASONObject con los campos que tiene los Body
		JSONObject data = new JSONObject();
		data.put("id", "the identifier");
		data.put("p", "the position of the body");
		data.put("v", "the velocity of the body");
		data.put("m", "body's mass");
		return data;
	}

}
