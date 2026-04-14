import java.util.ArrayList;

public class Enclosure {

    String enclosureId;
    ArrayList<Animal> animals;
    private ZooKeeper keeper;

    public Enclosure(String enclosureId) {
        this.enclosureId = enclosureId;
        animals = new ArrayList<Animal>();
        keeper = null;
    }

    public void addAnimal(Animal a) {
        animals.add(a);
    }

    public void assignKeeper(ZooKeeper k) {
        keeper = k;
    }

    public String getEnclosureId() {
        return enclosureId;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ZooKeeper getKeeper() {
        return keeper;
    }


}