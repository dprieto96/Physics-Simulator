package simulator.factories;

import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NoForce;

public class NoForceBuilder extends Builder<ForceLaws>{

	
	//··Constructor NoForceBuilder
	public NoForceBuilder() {
		super("nf", "No Force");
	}

	
	//·Método createTheInstance
	protected ForceLaws createTheInstance(JSONObject jsonObject) { //Retorna un objeto NoForce
		return new NoForce();
	}
	
	
	//·Método createData
	protected  JSONObject createData() { //Hace un super para hacer el método de Builder<T>
		return super.createData();
	}

}
