package com.kreitek.files;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemItemBase implements FileSystemItem {

    private final List<FileSystemItem> files;

    public Directory(FileSystemItem parent, String name) {
        super(parent, name);
        files = new ArrayList<>();
        // Aquí vendría lógica que rellena la lista de ficheros
    }

    @Override
    public List<FileSystemItem> listFiles() {
        return files;
    }

    @Override
    public void addFile(FileSystemItem file) {
        if (!files.contains(file)) {
            files.add(file);
            file.setParent(this);
        }
    }

    @Override
    public void removeFile(FileSystemItem file) {
        files.remove(file);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for(FileSystemItem file : files) {
            totalSize += file.getSize();
        }
        return totalSize;
    }
}
