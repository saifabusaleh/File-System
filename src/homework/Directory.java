package homework;

import java.util.*;

public class Directory extends Entity{

	private HashSet<Entity> children;
	public Directory() {
		super(new Date(), FileSystem.HOME_DIRECTORY, null);
		this.children = new HashSet<Entity>();
	}
	public Directory(String fileName, Entity parent) {
		super(new Date(), fileName, parent);
		this.children = new HashSet<Entity>();
	}
	@Override
	public String toString() {
		String out = String.format("Directory name: %s creation date: %s",this.getName(), this.getCreationDate() );
		return out;
	}

	@Override
	public void addChild(Entity child) {
		this.children.add(child);
	}

	@Override
	public Set<Entity> getChildren() {
		return children;
	}
}
