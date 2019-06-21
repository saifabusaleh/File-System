package homework;

import java.util.Date;
import java.util.Set;

public abstract class Entity {
	private Date creationDate;
	private String name;
	private Entity parent;
	private final int MAX_SIZE = 32;
	public Entity(Date creationDate, String name, Entity parent) {
		if(name.length() > MAX_SIZE) {
			throw new IllegalArgumentException(String.format("Entity name can't be longer then %d characters", MAX_SIZE));
		}
		this.creationDate = creationDate;
		this.name = name;
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Entity getParent() {
		return parent;
	}

	public void setParent(Entity parent) {
		this.parent = parent;
	}

	abstract void addChild(Entity child);

	abstract Set<Entity> getChildren();


	public void deleteSelf() {
		this.getParent().getChildren().remove(this);
		setParent(null);
	}
}
