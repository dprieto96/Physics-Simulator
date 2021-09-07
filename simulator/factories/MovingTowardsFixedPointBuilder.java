package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;

public class MovingTowardsFixedPointBuilder extends Builder<ForceLaws> {

	
	//··Constructor MovingTowardsFixedPointBuilder
	public MovingTowardsFixedPointBuilder() {
		super("mtfp", "Moving Towards Fixed Point Law");
	}

	
	//·Método createTheInstance
	protected ForceLaws createTheInstance(JSONObject jsonObject) { //Retorna un objeto MovingTowardsFixedPoint
		double g = jsonObject.has("g") ? jsonObject.getDouble("g") : 9.81;
		//Vector2D c = jsonObject.has("c");
		return new MovingTowardsFixedPoint(c,g);
	}
	
	
	//·Método createData
	protected  JSONObject createData() { //Retorna un JASONObject con los campos que tiene el MovingTowardsFixedPoint
		JSONObject data = new JSONObject();
		data.put("c", "origin coordinates");
		data.put("g", "gravity force");
		return data;
	}

}
