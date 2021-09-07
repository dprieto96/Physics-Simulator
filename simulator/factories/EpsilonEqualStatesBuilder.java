package simulator.factories;

import org.json.JSONObject;

import simulator.control.EpsilonEqualStates;
import simulator.control.StateComparator;

public class EpsilonEqualStatesBuilder extends Builder<StateComparator> { 

	//··Constructor EpsilonEqualStatesBuilder
	public EpsilonEqualStatesBuilder() {
		super("epseq", "Epsilon-equal states comparator");
	}

	
	//·Método createTheInstance
	protected StateComparator createTheInstance(JSONObject jsonObject) { //Retorna un objeto epsilon 
		double eps = jsonObject.has("eps") ? jsonObject.getDouble("eps") : 0.0;
		return new EpsilonEqualStates(eps);
	}
	
	
	//·Método createData
	protected  JSONObject createData() { //Retorna un JASONObject con los campos que tiene epsilon
		JSONObject data = new JSONObject();
		data.put("eps", "the allowed error");
		return data;
	}
	
}
