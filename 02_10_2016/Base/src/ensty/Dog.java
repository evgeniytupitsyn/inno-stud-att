package ensty;

import java.io.Externalizable;
import java.io.Serializable;

/**
 * Created by evgeniytupitsyn on 01/11/2016.
 */
public class Dog extends Pet implements Externalizable{
    private transient String name;
    private int weight;
    //private Skill skill;
    public void bark(){

    }

    public Dog(String name, int weight) {
        super(5);
        this.name = name;
        this.weight = weight;
    }

    /*public void setSkill(Skill skill) {
        this.skill = skill;
    }*/
}
