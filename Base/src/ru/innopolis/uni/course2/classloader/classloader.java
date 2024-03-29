
package ru.innopolis.uni.course2.classloader;


/**
 * Created by evgeniytupitsyn on 15/11/2016.
 */

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

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

/** A test class to test dynamic compilation API. *//*

public class CompilerAPITest {

    private static final String CLASS_NAME = "name.stokito.javaDynamicCompiler.HelloWorld";

    */
/** Java source code to be compiled dynamically *//*

    private static final String SOURCE_CODE = "package name.stokito.javaDynamicCompiler;" +
            "public class HelloWorld {" +
            "public static void main (String args[]){" +
            "System.out.println (\"Hello, dynamic compilation world!\");" +
            "}" +
            "}";

    */
/** Does the required object initialization and compilation. *//*

    public void doCompilation(File outputDir) throws IOException, ClassNotFoundException {
        // Creating dynamic java source code file object
        SimpleJavaFileObject fileObject = new DynamicJavaSourceCodeObject(CLASS_NAME, SOURCE_CODE);
        JavaFileObject javaFileObjects[] = new JavaFileObject[]{fileObject};
        // Instantiating the java compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        */
/**
         * Retrieving the standard file manager from compiler object, which is used to provide
         * basic building block for customizing how a compiler reads and writes to files.
         *
         * The same file manager can be reopened for another compiler task.
         * Thus we reduce the overhead of scanning through file system and jar files each time
         *//*

        StandardJavaFileManager stdFileManager = compiler.getStandardFileManager(null, Locale.getDefault(), null);
        // Prepare a list of compilation units (java source code file objects) to input to compilation task
        Iterable compilationUnits = Arrays.asList(javaFileObjects);
        // Prepare any compilation options to be used during compilation
        // In this example, we are asking the compiler to place the output files under bin folder.
        String[] compileOptions = new String[]{"-d", outputDir.getAbsolutePath()};
        Iterable compilationOptions = Arrays.asList(compileOptions);
        // Create a diagnostic controller, which holds the compilation problems
        DiagnosticCollector diagnostics = new DiagnosticCollector();
        // Create a compilation task from compiler by passing in the required input objects prepared above
        CompilationTask compilerTask = compiler.getTask(null, stdFileManager, diagnostics, compilationOptions, null, compilationUnits);
        // Perform the compilation by calling the call method on compilerTask object.
        boolean status = compilerTask.call();
        if (!status) { // If compilation error occurs
            // Iterate through each compilation problem and print it
            for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
                System.err.format("Error on line %d in %s", diagnostic.getLineNumber(), diagnostic);
            }
        }
        stdFileManager.close(); // Close the file manager
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        File outputDir = new File("target" + File.separator + "bin");
        outputDir.mkdir();
        new CompilerAPITest().doCompilation(outputDir);
        invoke(outputDir);
    }

    private static void invoke(File outputDir) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        URL[] urls = new URL[]{outputDir.toURI().toURL()};
        URLClassLoader ucl = new URLClassLoader(urls);
        Class clazz = ucl.loadClass(CLASS_NAME);
        Method main = clazz.getMethod("main", String[].class);
        String[] mainArgs = new String[]{};
        System.out.format("invoking %s.main()%n", clazz.getName());
        main.invoke(null, (Object) mainArgs);
    }

}

*/
/**
 * Creates a dynamic source code file object
 * <p />* This is an example of how we can prepare a dynamic java source code for compilation.
 * This class reads the java code from a string and prepares a JavaFileObject
 *//*

class DynamicJavaSourceCodeObject extends SimpleJavaFileObject {
    private String qualifiedName;
    private String sourceCode;

    */
/**
     * Converts the name to an URI, as that is the format expected by JavaFileObject
     *
     * @param name fully qualified name given to the class file
     * @param code the source code string
     *//*

    protected DynamicJavaSourceCodeObject(String name, String code) {
        super(URI.create("string:///" + name.replaceAll("\\.", "/") + Kind.SOURCE.extension), Kind.SOURCE);
        this.qualifiedName = name;
        this.sourceCode = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return sourceCode;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public void setQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }
}
*/
