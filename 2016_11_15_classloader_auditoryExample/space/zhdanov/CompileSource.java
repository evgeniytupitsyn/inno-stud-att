package space.zhdanov;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by nikolai on 15.11.16.
 */
public class CompileSource {

    public static void doCompilation(File outputDir, String source, String name) throws IOException, ClassNotFoundException {

        SimpleJavaFileObject fileObject = new TextJavaFileObject(name, source);
        JavaFileObject javaFileObjects[] = new JavaFileObject[]{fileObject};
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager stdFileManager = compiler.getStandardFileManager(null, Locale.getDefault(), null);
        Iterable compilationUnits = Arrays.asList(javaFileObjects);
        String[] compileOptions = new String[]{"-d", outputDir.getAbsolutePath(), "-cp", "./src/main/java"};
        Iterable compilationOptions = Arrays.asList(compileOptions);
        DiagnosticCollector diagnostics = new DiagnosticCollector();
        JavaCompiler.CompilationTask compilerTask = compiler.getTask(null, stdFileManager, diagnostics, compilationOptions, null, compilationUnits);
        boolean status = compilerTask.call();
        if (!status) { // If compilation error occurs
            // Iterate through each compilation problem and print it
            for (Object diagnostic : diagnostics.getDiagnostics()) {
                System.err.format("Error on line %d in %s", ((Diagnostic)diagnostic).getLineNumber(), diagnostic);
            }
        }
        stdFileManager.close();
    }
}
