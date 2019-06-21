package homework;

import java.util.*;

public class File extends Entity{
	private long size;
	public File(String fileName, long fileSize, Entity parent) {
		super(new Date(),fileName, parent);
		this.size = fileSize;
	}


	@Override
	public void addChild(Entity child) {
		throw new IllegalArgumentException("Cannot add: " + child.getName()  + " into parent which is file"); 
	}

	@Override
	public Set<Entity> getChildren() {
		return Collections.emptySet();
	}
	@Override
	public String toString() {
		String out = String.format("File name: %s size: %o creation date: %s",this.getName(),this.size,this.getCreationDate() );
		return out;
	}
}
