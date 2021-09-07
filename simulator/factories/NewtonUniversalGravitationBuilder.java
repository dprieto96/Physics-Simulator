package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws> {

	//··Constructor NewtonUniversalGravitationBuilder
	public NewtonUniversalGravitationBuilder() {
		super("nlug", "Newton Universal Gravitation Law");
	}

	
	//·Método createTheInstance
	protected ForceLaws createTheInstance(JSONObject jsonObject) { //Retorna un objeto NewtonUniversalGravitationBuilder
		double g = jsonObject.has("G") ? jsonObject.getDouble("G") : 6.67e-11;
		return new NewtonUniversalGravitation(g);
	}
	
	
	//·Método createData
	protected  JSONObject createData() { //Retorna un JASONObject con los campos que tiene el NewtonUniversalGravitationBuilder
		JSONObject data = new JSONObject();
		data.put("G", "gravitational constant");
		return data;
	}


}
