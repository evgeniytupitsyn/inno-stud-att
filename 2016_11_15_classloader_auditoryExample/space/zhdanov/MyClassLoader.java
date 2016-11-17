package space.zhdanov;

import java.io.*;

/**
 * Created by nikolai on 15.11.16.
 */
public class MyClassLoader extends ClassLoader {

    private String pathtobin;

    public MyClassLoader(ClassLoader parent, String pathtobin) {
        super(parent);
        this.pathtobin = pathtobin;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte b[] = fetchClassFromFS(pathtobin + name.replace(".", "/") + ".class");
            return defineClass(name, b, 0, b.length);
        } catch (FileNotFoundException ex) {
            return super.findClass(name);
        } catch (IOException ex) {
            return super.findClass(name);
        }
    }

    private byte[] fetchClassFromFS(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));

        long length = new File(path).length();
        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead = 0;

        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+path);
        }

        is.close();
        return bytes;
    }
}
