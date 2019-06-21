package homework;

import java.util.HashMap;
import java.util.HashSet;

public class FileSystem {
	private Directory root;
	private HashMap<String, Entity> hm;
	public static final String HOME_DIRECTORY = "/";
	private final String SPACE = "  ";
	public FileSystem() {
		this.root = new Directory();
		this.hm = new HashMap<String, Entity>();
		//add root directory to our map data structures
		this.hm.put(HOME_DIRECTORY, this.root);
	}

	public void addFile(String parentDirName, String fileName, long fileSize) {
		validateNames(fileName, parentDirName);

		checkIfFileOrFolderNameAlreadyExist(fileName);

		Entity parentDirectory = tryGetFileOrFolder(parentDirName);
		// add to tree
		File file = new File(fileName, fileSize, parentDirectory);

		parentDirectory.addChild(file);
		// add to map
		hm.put(fileName, file);
	}
	
	private void validateNames(String name, String parentName) {
		if(parentName == null || parentName.isEmpty()) {
			throw new IllegalArgumentException("parent directory cant be null or empty");
		}
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("name cant be null or empty");
		}
	}
	private void checkIfFileOrFolderNameAlreadyExist(String name) {
		if(hm.get(name) != null) {
			throw new IllegalArgumentException("name: " + name +  " already exist, it must be unique");
		}
	}
	private Entity tryGetFileOrFolder(String name) {
		Entity entity = hm.get(name);
		if (entity == null) {
			throw new IllegalArgumentException("cant find file or folder: " + name);
		}
		return entity;
	}
	public void addDir(String parentDirName, String folderName) {
		validateNames(folderName, parentDirName);

		checkIfFileOrFolderNameAlreadyExist(folderName);

		Entity parentDirectory = tryGetFileOrFolder(parentDirName);
		// add to tree
		Directory directoryToBeAdded = new Directory(folderName, parentDirectory);

		parentDirectory.addChild(directoryToBeAdded);
		// add to map
		hm.put(folderName, directoryToBeAdded);
	}

	public void delete(String name) {
		if(name.equals(HOME_DIRECTORY)) {
			throw new IllegalArgumentException("can't delete system root directory");
		}
		Entity entity = tryGetFileOrFolder(name);

		deleteSuccessors(entity);
	}

	private void deleteSuccessors(Entity root) {
		if(root==null) return;
		//this will detach the node from its parents
		root.deleteSelf();
		//delete also from map
		hm.remove(root.getName()); 
		//continue recursively to children and do the same
		for(Entity child : new HashSet<>(root.getChildren())) {
			deleteSuccessors(child);
		}
	}

	public void showFileSystem() {
		Entity temp = root;
		printHelper(temp, 0);
	}

	private void printHelper(Entity root,int identation) {

		if(root == null) return;
		printSpaces(identation);

		System.out.println( root.toString());

		for(Entity child : root.getChildren()) {
			printHelper(child, identation+1);
		}
	}

	private void printSpaces(int identation) {
		for(int i=0;i<identation;i++) {
			System.out.print(SPACE);
		}
	}
}
