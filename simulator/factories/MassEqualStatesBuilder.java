package simulator.factories;

import org.json.JSONObject;

import simulator.control.MassEqualStates;
import simulator.control.StateComparator;

public class MassEqualStatesBuilder extends Builder<StateComparator> {

	//··Constructor MassEqualStatesBuilder
	public MassEqualStatesBuilder() {
		super("masseq", "Mass Equal States");
	}

	
	//·Método createTheInstance
	protected StateComparator createTheInstance(JSONObject jsonObject) { //Retorna un objeto MassEqualStates
		return new MassEqualStates();
	}
	
	
	//·Método createData
	protected  JSONObject createData() { //Hace un super para hacer el método de Builder<T>
		return super.createData();
	}

}
