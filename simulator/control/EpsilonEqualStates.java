package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;

public class EpsilonEqualStates implements StateComparator{
	
	//Atributos
	protected double _eps;
	
	
	//··Constructor de EpsilonEqualStates
	public EpsilonEqualStates(double eps) {
		this._eps=eps;
	}

	
	//·Método equal
	public boolean equal(JSONObject s1, JSONObject s2) {
		
		boolean ok=true;
		JSONArray jaux1 = s1.getJSONArray("bodies");
		JSONArray jaux2 = s2.getJSONArray("bodies");
		
		if(s1.getDouble("time")!=s2.getDouble("time")) {  //Si los valores de la clave time son diferentes, falso
			ok=false;
		}
		else if(jaux1.length()!=jaux2.length()) {         //Si el número de bodies es distinto, falso
			ok=false;
		}
		else {
			for(int i=0; i<jaux1.length();i++) {          //Recorre y compara
				
				JSONObject j1 = jaux1.getJSONObject(i);
				JSONObject j2 = jaux2.getJSONObject(i);
			
				
				JSONArray p1 = j1.getJSONArray("p"); //Extraemos el array de  p
				JSONArray p2 = j2.getJSONArray("p"); //Extraemos el array de  p
				
				Vector2D paux1 = new Vector2D(p1.getDouble(0),p1.getDouble(1)); //Creamos un Vector2D con las componentes extraidas de la velocidad
				Vector2D paux2 = new Vector2D(p2.getDouble(0),p2.getDouble(1)); //Creamos un Vector2D con las componentes extraidas de la velocidad
				if(paux1.distanceTo(paux2)>_eps) { //Si es mayor que epsilon, false
					ok=false;
				}
				else {
					
					JSONArray v1 = j1.getJSONArray("v");
					JSONArray v2 = j2.getJSONArray("v");
				
					Vector2D vaux1 = new Vector2D(v1.getDouble(0),v1.getDouble(1)); 
					Vector2D vaux2 = new Vector2D(v2.getDouble(0),v2.getDouble(1)); 
					
					if(vaux1.distanceTo(vaux2)>_eps) {
						ok=false;
					}
					else {
						JSONArray f1 = j1.getJSONArray("f");
						JSONArray f2 = j2.getJSONArray("f");
						
						Vector2D faux1 = new Vector2D(f1.getDouble(0),f1.getDouble(1));
						Vector2D faux2 = new Vector2D(f2.getDouble(0),f2.getDouble(1));
						
						if(faux1.distanceTo(faux2)>_eps) {
							ok=false;
						}
						else {
							double maux1 = j1.getDouble("m");
							double maux2 = j2.getDouble("m");
							
							if(Math.abs(maux1-maux2)>_eps) {
								ok = false;
							}
						}
					}
				}
			}
		}
		return ok;
	}
	
	
	//·Método toString
	public String toString() {
		return "Epsilon Equal States";
	}
	
}
