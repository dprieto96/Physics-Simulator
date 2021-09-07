package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws{

	//Atributos
	private double _g;
	private Vector2D _c;
	
	
	//��Constructor MovingTowarsFixedPoint
	public MovingTowardsFixedPoint(Vector2D c, double g){
		this._g = g;
		this._c = c;
	}

	
	//�M�todo apply
	public void apply(List<Body> bodies) { //A�ade la fuerza correspondiente a los cuerpos
		for(Body b : bodies) {
			b.addForce(_c.minus(b.getPosition()).direction().scale(_g*b.getMass()));
		}
	}
	
	
	//�M�todo toString
	public String toString() {
		return "Falling to center gravity";
	}
}
