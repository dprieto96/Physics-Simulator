package simulator.model;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class Body {
	
	//Atributos
	protected String id;
	protected Vector2D v;
	protected double m;
	protected Vector2D _f;
	protected Vector2D p;
	
	
	//··Constructor de Body
	public Body(Vector2D v, Vector2D p, double m, String id) {
		this.v=v;
		this.p =p;
		this.m=m;
		resetForce();
		this.id=id;
	}
	
	
	//·Métodos Getters de los atributos
	public String getId() {
		return this.id;
	}
	
	public double getMass() {
		return this.m;
	}
	
	public Vector2D getVelocity() {
		return new Vector2D(v);
	}
	
	public Vector2D getForce() {
		return new Vector2D(_f);
	}
	
	public Vector2D getPosition() {
		return new Vector2D(p);
	}
	
	
	//·Método addForce
	public void addForce(Vector2D f) { //le suma el vector que le llega como parámetro
		this._f = this._f.plus(f);
	}
	
	
	//·Método resetForce
	public void resetForce() {
		this._f = new Vector2D(); //Pone la fuerza a 0.0
	}
	
	
	//·Método move
	public void move(double t) {
		Vector2D a;
		if(this.m!=0) { //Calcula la aceleracion respecto a la masa
			a =_f.scale(1.0 / m); 
		}
		else {
			 a =new Vector2D(); 
		}
		
		this.p=this.p.plus(v.scale(t).plus(a.scale(0.5 * t * t))); //Actualiza el vector posicion
		this.v=this.v.plus(a.scale(t));                            //Actualiza el vector velocidad
	}
	

	//·Método equals
	public boolean equals(Object obj) { 
		Body other = (Body) obj;
		if (id == null) {                            //Si uno es null y otro no retorna falso 
			if (other.id != null) return false; 
		} 
		else if (!id.equals(other.id)) return false; //Sino son iguales retorna falso
		
		return true;                                 //Retorna true si son iguales
	}
	
	
	//·Método getState 
	public JSONObject getState() {               //Coge un objeto de la clase body y lo transforma en un JSON
		JSONObject jo = new JSONObject();
		jo.put("id", getId());
		jo.put("m", getMass());
		jo.put("p", getPosition().asJSONArray());//Lo metemos con el método de la clase Vector2D
		jo.put("v", getVelocity().asJSONArray());
		jo.put("f", getForce().asJSONArray());
		return jo;
	}
	
	
	//·Método toString
	public String toString() {
		return getState().toString();
	}
	
}
