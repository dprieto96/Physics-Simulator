package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MassLossingBody;

public class MassLosingBodyBuilder extends Builder<Body> {

	//··Constructor MassLosingBodyBuilder
	public MassLosingBodyBuilder() {
		super("mlb", "Mass losing body");
	}

	
	//·Método createTheInstance
	protected Body createTheInstance(JSONObject jsonObject) { //Retorna un objeto MassLosingBody
		
		JSONArray paux = jsonObject.getJSONArray("p");
		Vector2D p = new Vector2D(paux.getDouble(0), paux.getDouble(1));
		
		JSONArray vaux = jsonObject.getJSONArray("v");
		Vector2D v = new Vector2D(vaux.getDouble(0), vaux.getDouble(1));
		
		String id = jsonObject.getString("id");
		double m =  jsonObject.getDouble("m");
		double freq =  jsonObject.getDouble("freq");
		double factor =  jsonObject.getDouble("factor");
		
		return new MassLossingBody(v,p,m,id,factor,freq); //Crea el cuerpo que pierde masa
	}
	
	
	//·Método createData
	protected  JSONObject createData() { //Retorna un JASONObject con los campos que tiene el cuepro que pierde masa
		JSONObject data = new JSONObject();
		data.put("id", "the identifier");
		data.put("p", "the position of the body");
		data.put("v", "the velocity of the body");
		data.put("m", "body's mass");
		data.put("freq", "frequency in which the body loses mass");
		data.put("factor", "mass losing factor");
		return data;
	}
	
	
	

}
