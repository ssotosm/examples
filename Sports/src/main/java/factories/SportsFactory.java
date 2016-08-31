package factories;

import entities.Entity;

public class SportsFactory<T extends Entity> {

	private Class<T> type;

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

	public Entity create(){
		try {
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
