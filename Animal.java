public class Animal {

    private String name;
    private int age;
    private static int totalAnimals = 0;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        totalAnimals++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }

    public int calculateFeedingScore() {
        int score = 0;
        for (int i = 1; i <= age; i++) {
            score++;
        }
        return score;
    }


}