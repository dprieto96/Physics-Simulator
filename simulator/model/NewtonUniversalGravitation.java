package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class NewtonUniversalGravitation implements ForceLaws{

	//Atributos
	protected double _g;

	
	//··Constructor NewtonUniversalGravitation
	public NewtonUniversalGravitation(double g) {
		this._g= g;
	}
	
	
	//·Método apply
	public void apply(List<Body> bodies) { //Para cada cuerpo b le añadimos la fuerza
		int n=bodies.size();
		for(int i=0;i<n;i++) {
			Body bi=bodies.get(i);
			for(int j=0;j<n;j++) {
				if(i!=j) {
					bi.addForce(force(bi,bodies.get(j)));
				}
			}
		}
	}
	
	
	//·Método force
	private Vector2D force(Body a, Body b) { //Calcula la fuerza que genera el cuerpo b sobre el cuerpo a
	    Vector2D delta = b.getPosition().minus(a.getPosition());
	    double dist = delta.magnitude();
	    double magnitude = dist>0 ? (_g * a.getMass() * b.getMass()) / (dist * dist) : 0.0;
	    return delta.direction().scale(magnitude);
	   }
	
	
	//·Método toString
	public String toString() {
		return "Newton’s universal gravitation";
	}
	
	
}
	
	
	
	
	
	
