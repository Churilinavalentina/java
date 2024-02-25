package edu.mipt.kozub.reflection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import static edu.mipt.kozub.Utils.fieldCollection;

public class ObjectsWriter {

    private String nameFile;

    public ObjectsWriter(String nameFile) {
        this.nameFile = nameFile;
    }

    public void write(List<Object> obj){
        File f = new File(nameFile);
        FileWriter fw;
        try {
            fw = new FileWriter(f);
            for(Object o:obj){
                fw.write(o.toString());
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
