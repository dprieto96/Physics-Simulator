package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class BuilderBasedFactory<T> implements Factory<T>{
	
	//Atributos
	private List<JSONObject> _factoryElements; //Lista de objetos JASON construidos por defector
	private List<Builder<T>> _builders;        //Lista de constructores, para construir los cuerpos

	
	//··Constructor BuilderBasedFactory
	public BuilderBasedFactory(List<Builder<T>> builders) {
		_builders = new ArrayList<Builder<T>>(builders);  //Inicializa _builders invocando a la constructora por copia de ArrayList
		_factoryElements = new ArrayList<JSONObject>();
		
		for(Builder<T> b : _builders) {                    //Para cada builder b, se llama a b.getBuilderInfo
			_factoryElements.add(b.getBuilderInfo());
		}
	}

	
	//·Método createInstance
	public T createInstance(JSONObject info) { /*a ejecuta los constructores uno a uno hasta que 
													encuentre el constructor capaz de crear el objeto correspondiente*/
		T object = null;
		int i = 0;
		while (object == null && i < this._builders.size()) {
			object = this._builders.get(i).createInstance(info);
			i++;
		}
		if (object == null) throw new IllegalArgumentException("No existe el objeto JSON"); //Sino lanza excepción
		return object;
		
	}

	
	//·Método getInfo
	public List<JSONObject> getInfo() {
		return _factoryElements;
	}

}
