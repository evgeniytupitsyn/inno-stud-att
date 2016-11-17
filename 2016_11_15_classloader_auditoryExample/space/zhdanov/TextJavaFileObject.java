package space.zhdanov;

import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.net.URI;

/**
 * Created by nikolai on 15.11.16.
 */
public class TextJavaFileObject extends SimpleJavaFileObject {
    private String qualifiedName;
    private String sourceCode;

    /**
     * Converts the name to an URI, as that is the format expected by JavaFileObject
     *
     * @param name fully qualified name given to the class file
     * @param code the source code string
     */
    protected TextJavaFileObject(String name, String code) {
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
