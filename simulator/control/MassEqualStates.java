package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

public class MassEqualStates implements StateComparator{

	//··Constructor de MassEqualStates
	public MassEqualStates() {}
	
	
	//·Método equal
	public boolean equal(JSONObject s1, JSONObject s2) {
		
		boolean ok = true;
		JSONArray jaux1 = s1.getJSONArray("bodies");
		JSONArray jaux2 = s2.getJSONArray("bodies");
		
		if(s1.getDouble("time")!=s2.getDouble("time")) { //Si los valores de la clave time son diferentes, falso
			ok=false;
		}
		else if(jaux1.length()!=jaux2.length()) {        //Si el número de bodies es distinto, falso
			ok=false;
		}
		else {
			for(int i=0; i<jaux1.length();i++) {         //Recorre los cuerpos y si m o id son diferentes, falso
				if((jaux1.getJSONObject(i).getDouble("m") != jaux2.getJSONObject(i).getDouble("m")) || jaux1.getJSONObject(i).getString("id") != jaux2.getJSONObject(i).getString("id")) {
					ok=false;
				}
			}
		}
		return ok;
	}
	
	
	//·Método toString
	public String toString() {
		return "Mass equal States";
	}

}
