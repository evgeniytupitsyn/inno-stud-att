package ensty;

/**
 * Created by evgeniytupitsyn on 01/11/2016.
 */
public class Box<T extends Number> {
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
