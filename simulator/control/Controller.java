package simulator.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.PhysicsSimulator;

public class Controller { /*Lee el fichero donde estan los JASONObject y utiliza los builders
							para contruir el objecto correspondiente y pasárselo al simulador*/
	
	
	//Atributos
	private PhysicsSimulator _sim; //Para añadir los cuerpos que se leen del fichero en formato JASON al simulador
	private Factory<Body> _bodiesFactory; //Para transformar estructuras JASON en objetos de tipo Body
	
	
	//··Constructor Controller
	public Controller( PhysicsSimulator physics, Factory<Body> _bodiesFactory ) {
		this._sim = physics;
		this._bodiesFactory = _bodiesFactory;
		
	}
	
	
	//·Método loadBodies
	public void loadBodies(InputStream in) { /*Lee el fichero de entrada, JASON a JASON, hace la transformacion
	 											al objeto correspondiente y se lo mete al simulador*/
		JSONObject jsonInupt = new JSONObject(new JSONTokener(in));
		JSONArray bodies = jsonInupt.getJSONArray("bodies");
		
		for(int i=0; i<bodies.length(); i++) {		
			_sim.addBody(_bodiesFactory.createInstance(bodies.getJSONObject(i))); //Añade el cuerpo que crea la instacia
		}
	}
	
	
	//·Método run
	public void run(int n, OutputStream out, InputStream expOut, StateComparator cmp) throws NotEqualStatesException {
		//Es el encargado de decirle al simulador que haga la simulación, y si hay comparadores que los haga
		JSONObject expOutJO = null;
		
		if(expOut != null) {
			expOutJO = new JSONObject(new JSONTokener(expOut));
		}
		if(out==null) {
			out = new OutputStream() {
				public void write(int b) throws IOException {}
			};
		}
		
		PrintStream p = new PrintStream(out);
		p.println("{");
		p.println("\"states\": [");
		
		JSONObject currState = null;
		JSONObject expState = null;
		
		currState = _sim.getState(); 
		p.println(currState);
		if(expOutJO != null) { //Comprobacion de los estados iniciales
			expState = expOutJO.getJSONArray("states").getJSONObject(0);
			if(!cmp.equal(expState,currState)) {
				throw new NotEqualStatesException(expState,currState,0);
			}
		}
		
		for (int i=1; i<=n;i++) { //Comprobacion del resto de los estados
			_sim.advance();
			currState = _sim.getState();
			p.print(",");
			p.println(currState);
			if(expOutJO !=null) {
	            expState=expOutJO.getJSONArray("states").getJSONObject(i);
	            if (!cmp.equal(expState, currState)) {
	                throw new NotEqualStatesException(expState,currState,0);
	            }
			}

        }
		
		p.println("]");
		p.println("}");
		
	}

}
