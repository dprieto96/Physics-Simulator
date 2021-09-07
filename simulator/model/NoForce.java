package simulator.model;

import java.util.List;

public class NoForce implements ForceLaws{
	
	//··Constructor NoForce
	public NoForce() {}
	
	//·Método apply
	public void apply(List<Body> bodies) {}
	
	//·Método toString
	public String toString() {
		return "No gravity";
	}
}
