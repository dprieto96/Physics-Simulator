package simulator.factories;

import org.json.JSONObject;

public abstract class Builder<T>{  //Clase Genérica
	
	//Atributos
	private String _typeTag;  //Tipo para saber que objecto es
	private String _desc;     //Descripción del objeto
	
	
	//··Constructora Builder
	public Builder(String typetag, String desc) {
		this._typeTag=typetag;
		this._desc=desc;
	}

	
	//·Método createInstance
	public T createInstance(JSONObject info) {                         //Si le metemos un JASONObject que represente un Body, tiene que devolver un objecto de la clase Body
		T b = null;
		if(_typeTag!=null && _typeTag.equals(info.getString("type"))){ //Si los tipos coinciden
			b = createTheInstance(info.getJSONObject("data"));
		}
		return b;
	}
	
	
	//·Método abstracto createTheInstance
	protected abstract T createTheInstance(JSONObject jsonObject);

	
	//·Método getInfo
	public JSONObject getBuilderInfo() {  //Tengo un Objeto y saca su JASONObject
		JSONObject info = new JSONObject();
		info.put("type", _typeTag);
		info.put("data", createData());   //Depende de las subsclases
		info.put("desc", _desc);
		return info;
	}
	
	
	//·Método createData
	protected  JSONObject createData() { //Este método vale para las leyes, para los demás hay que sobrescribirlos
		return new JSONObject();	
	}

}

