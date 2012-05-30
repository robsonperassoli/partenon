package br.com.syspartenon.partenon.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class FileUtil {
    
    public static String getAppRootDir() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext ctx = (ServletContext) externalContext.getContext();
        return ctx.getRealPath("/");
    }

    public static String getImgDir() {
        String dir = getAppRootDir() + "/images/";
        if(!(new File(dir).exists()))
            new File(dir).mkdirs();
        return dir;
    }

    public static String getThumbDir() {
        String dir = getAppRootDir() + "/images/thumbnails/";
        if(!(new File(dir).exists()))
            new File(dir).mkdirs();
        return dir;
    }

    public static String getTempDir() {
        String dir = getAppRootDir() + "/temp/";
        if(!(new File(dir).exists()))
            new File(dir).mkdirs();
        return dir;
    }

    public static String getExtension(String fileName) {
        String[] split = fileName.split("\\.");
        return split[1];
    }

    public static boolean saveToFile(String filename, byte[] content) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            fos.write(content);
            fos.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
