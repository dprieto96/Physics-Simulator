package simulator.model;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class MassLossingBody extends Body{

	//Atributos
	private double lossFactor;     //Factor de p�rdida de masa
	private double lossFrequency;  //Frecuencia con la que se pierde masa
	protected double cont;         //Acumula el tiempo
	
	
	//��Constructor MassLossingBody
	public MassLossingBody(Vector2D v, Vector2D p, double m, String id, double lossFactor, double lossFrequency) {
		super(v,p,m,id);
		this.lossFactor= lossFactor;
		this.lossFrequency=lossFrequency;
		this.cont=0.0;
	}
	
	
	//�M�todo move
	public void move(double t) {
		super.move(t);              //Llamamos al move de Body
		cont+=t;
		if(cont>=lossFrequency) {   //Si cont supera a al factor de perdida de masa
			cont=0.0;               //Reinicia
			m=m*(1-lossFactor);     //Reduce la masa
		}
	}
	
	
	//�M�todo getState 
	public JSONObject getState() {               //Coge un objeto de la clase masslosingbody y lo transforma en un JSON
			JSONObject jo = new JSONObject();
			jo.put("id", getId());
			jo.put("m", getMass());
			jo.put("p", getPosition().asJSONArray());//Lo metemos con el m�todo de la clase Vector2D
			jo.put("v", getVelocity().asJSONArray());
			jo.put("f", getForce().asJSONArray());
			jo.put("freq", getlossFrequency());
			jo.put("factor", getlossFactor());
			return jo;
	}
	
	
	//�M�todo toString
	public String toString() {
		return getState().toString();
	}
	
	
	//�M�todo getlossFactor
	public double getlossFactor() {
		return this.lossFactor;
	}
	
	//�M�todo getlossFrequency
	public double getlossFrequency() {
		return this.lossFrequency;
	}
}
