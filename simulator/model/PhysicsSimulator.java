package simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class PhysicsSimulator { //Lleva la lista de cuerpos
	
	//Atributos
	private double dt;				//Incremento del tiempo
	private ForceLaws _forceLaws; 	//Ley de fuerza a aplicar
	private List<Body> _lista;		//Cuerpos de la simulaci�n
	private double time;			//N�mero de pasos que se ejecuta la simulaci�n
	
	
	//��Constructor PhysicsSimulator
	public PhysicsSimulator(double dt, ForceLaws forcelaws) throws IllegalArgumentException {
		
		if (dt <= 0 || forcelaws==null) {
			throw new IllegalArgumentException ();
		}
		this.dt=dt;
		this._forceLaws=forcelaws;
		this._lista =new ArrayList<Body>();
		this.time=0.0;
	}	
	
	
	//�M�todo advance
	public void advance() { 
		for(Body b: _lista) {          //Resetea la fuerza de todos los cuerpos
			b.resetForce();
		}
		this._forceLaws.apply(_lista); //Aplica las leyes de gravedad de los cuerpos
		for(Body b: _lista) {
			b.move(this.dt);           //Mueve todos los cuepos
		}
		this.time+=this.dt;            //Incrementa time en dt
	}
	
	
	//�M�todo addBody
	public void addBody(Body b) throws IllegalArgumentException {
		
		if(_lista.contains(b)) {
			throw new IllegalArgumentException(); //Lanza la excepcion si b esta en la lista
		}
		this._lista.add(b); 						  //Sino, lo a�ade a la lista
	}
	
	
	//�M�todo getState
	public JSONObject getState() { //Devuelve el objeto JSON, que representa un estado del simulador
		JSONObject state = new JSONObject();
        JSONArray bodies = new JSONArray();

        state.put("time", this.time);

        for (Body body : _lista)
            bodies.put(body.getState());
       
        state.put("bodies", bodies);

        return state;
	}
	
	
	//�M�todo toString
	public String toString() {
		return getState().toString(); 
	}

}
