package simulator.control;

import org.json.JSONObject;

public class NotEqualStatesException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private JSONObject _actual;
	private JSONObject _excepted;
	int _step;
	
	
	NotEqualStatesException (JSONObject exp, JSONObject act, int x){
		super("States are different at step " + x + System.lineSeparator() +
				"Actual: " + act + System.lineSeparator());
		
		this._actual = act;
		this._excepted = exp;
		this._step = x;
	}
	
	public JSONObject getActual() {
		return _actual;
	}
	
	public JSONObject getExcepted() {
		return _excepted;
	}
	
	public int getStep() {
		return _step;
	}
	
}
