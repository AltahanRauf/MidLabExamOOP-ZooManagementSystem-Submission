public class ZooManagementSystem {
    public static void main(String[] args) {


        Mammal m1 = new Mammal("Leo", 5, "Golden");
        Mammal m2 = new Mammal("Bruno", 8, "Dark Brown");

        Bird b1 = new Bird("Sky", 3, 2.1);
        Bird b2 = new Bird("Polly", 6, 0.5);

        ZooKeeper zk1 = new ZooKeeper("Alice Johnson", "ZK001");
        ZooKeeper zk2 = new ZooKeeper("Bob Smith", "ZK002");

        Enclosure e1 = new Enclosure("E01");
        Enclosure e2 = new Enclosure("E02");

        e1.addAnimal(m1);
        e1.addAnimal(m2);

        e2.addAnimal(b1);
        e2.addAnimal(b2);

        e1.assignKeeper(zk1);
        e2.assignKeeper(zk2);

        System.out.println("==============================================");
        System.out.println("        ZOO MANAGEMENT SYSTEM - REPORT       ");
        System.out.println("==============================================");
        System.out.println("Total Animals Created: " + Animal.getTotalAnimals());
        System.out.println("==============================================");

        System.out.println("\n--- ZOOKEEPER DETAILS ---");
        System.out.println(zk1.toString());
        System.out.println(zk2.toString());
        System.out.println("==============================================");

        System.out.println("\n--- INDIVIDUAL ANIMAL DETAILS ---");
        System.out.println(m1.toString());
        System.out.println(m2.toString());
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println("==============================================");

        System.out.println("\n--- ENCLOSURE DETAILS ---");
        System.out.println(e1.toString());
        System.out.println("----------------------------------------------");
        System.out.println(e2.toString());
        System.out.println("==============================================");

        System.out.println("\n--- FEEDING SCORES SUMMARY ---");
        System.out.println(m1.getName() + " Feeding Score: " + m1.calculateFeedingScore());
        System.out.println(m2.getName() + " Feeding Score: " + m2.calculateFeedingScore());
        System.out.println(b1.getName() + " Feeding Score: " + b1.calculateFeedingScore());
        System.out.println(b2.getName() + " Feeding Score: " + b2.calculateFeedingScore());
        System.out.println("==============================================");
        System.out.println("             END OF REPORT                   ");
        System.out.println("==============================================");
    }
    }



