package ensty;

/**
 * Created by evgeniytupitsyn on 01/11/2016.
 */
public class Skill {
    private String description;
    private int level;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Skill(String description, int level) {
        this.description = description;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "description='" + description + '\'' +
                '}';
    }


}
