class FileSystem {

  Map<String, Integer> directory;

  public FileSystem() {
    directory = new HashMap<>();
    directory.put("/", 1);
  }
  
  // Returns false if the path already exists or its parent path doesn't exist.
  // paths - format is: / followed by one or more lowercase English letters
  public boolean createPath(String path, int value) {
    int lastSlash = lastSlashIndex(path);
    if (path.length() == 0)
      return false;
    
    String parentDirectory = path.substring(0, lastSlash);
    if ((parentDirectory.length() > 0 && !directory.containsKey(parentDirectory)) || directory.containsKey(path))
      return false;

    directory.put(path, value);
    return true;
  }
  
  public int get(String path) {
    return directory.containsKey(path) ?
      directory.get(path) :
      -1;
  }

  private int lastSlashIndex(String path) {
    int i = path.length() - 1;
    while (i > 0 && path.charAt(i) != '/')
      i--;

    return i;
  }
}