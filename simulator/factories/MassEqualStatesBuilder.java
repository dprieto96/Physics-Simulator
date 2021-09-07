package simulator.factories;

import org.json.JSONObject;

import simulator.control.MassEqualStates;
import simulator.control.StateComparator;

public class MassEqualStatesBuilder extends Builder<StateComparator> {

	//��Constructor MassEqualStatesBuilder
	public MassEqualStatesBuilder() {
		super("masseq", "Mass Equal States");
	}

	
	//�M�todo createTheInstance
	protected StateComparator createTheInstance(JSONObject jsonObject) { //Retorna un objeto MassEqualStates
		return new MassEqualStates();
	}
	
	
	//�M�todo createData
	protected  JSONObject createData() { //Hace un super para hacer el m�todo de Builder<T>
		return super.createData();
	}

}
