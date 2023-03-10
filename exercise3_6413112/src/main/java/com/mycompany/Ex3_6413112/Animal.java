//MR.SASIT SRIRAT 6413112
//MR.WATCHARASAK PROMMANEE 6413110
//remain: organize output
//update 5/02/2023 19.37

package com.mycompany.Ex3_6413112;

import java.io.File;
import java.util.*;

class Animal {
    private String name; // fix
    private int weight, sleep, lifespan, gestation; // fix

    public Animal(String name, int weight, int sleep, int lifespan, int gestation) {
        this.name = name;
        this.weight = weight;
        this.sleep = sleep;
        this.lifespan = lifespan;
        this.gestation = gestation;
    }

    public String getName() {
        return name;
    };

    public int getWeight() {
        return weight;
    };

    public int getSleep() {
        return sleep;
    };

    public int getLifespan() {
        return lifespan;
    };

    public int getGestation() {
        return gestation; 
    };
}

class SortAnimalByName implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        // TODO Auto-generated method stub
        return o1.getName().compareToIgnoreCase(o2.getName());
    }

}

class SortAnimalByWeight implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        // TODO Auto-generated method stub
        if (o1.getWeight() > o2.getWeight()) {
            return 1;
        } else if (o1.getWeight() < o2.getWeight()) {
            return -1;
        } else if (o1.getWeight() == o2.getWeight()) {
            if (o1.getSleep() > o2.getSleep()) {
                return -1;
            }
        } else
            return 0;
        return 0;
    }
}

class SortAnimalBySleep implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        // TODO Auto-generated method stub
        if (o1.getSleep() > o2.getSleep()) {
            return 1;
        } else if (o1.getSleep() < o2.getSleep()) {
            return -1;
        } else if (o1.getSleep() == o2.getSleep()) {
            if (o1.getLifespan() > o2.getLifespan()) {
                return -1;
            }
        } else
            return 0;
        return 0;
    }

}

class SortAnimalByLifespan implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        // TODO Auto-generated method stub
        if (o1.getLifespan() > o2.getLifespan()) {
            return 1;
        } else if (o1.getLifespan() < o2.getLifespan()) {
            return -1;
        } else if (o1.getLifespan() == o2.getLifespan()) {
            if (o1.getGestation() > o2.getGestation()) {
                return -1;
            }
        } else
            return 0;
        return 0;
    }
}

class SortAnimalByGestation implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        if (o1.getGestation() > o2.getGestation()) {
            return 1;
        } else if (o1.getGestation() < o2.getGestation()) {
            return -1;
        } else if (o1.getGestation() == o2.getGestation()) {
            if (o1.getLifespan() > o2.getLifespan()) {
                return -1;
            }
        } else
            return 0;
        return 0;
    }
}

public class process {
    public static void main(String[] args) throws Exception {

        ArrayList<Animal> AnimalRecords = new ArrayList<Animal>();
        File file = new File("src/main/java/animals.txt");
        Scanner scanfile = new Scanner(file);

        while (scanfile.hasNext()) {
            
            String line = scanfile.nextLine();
            String[] buf = line.split(",");
            String name = buf[0].trim();

            int weight = Integer.parseInt(buf[1].trim());
            int sleep = Integer.parseInt(buf[2].trim());
            int lifespan = Integer.parseInt(buf[3].trim());
            int gestation = Integer.parseInt(buf[4].trim());
            AnimalRecords.add(new Animal(name, weight, sleep, lifespan, gestation));
        }
        scanfile.close();

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Sort by >> n = name, w= weight, s = sleep, l = lifespan, g = gestation, other = quit");
            System.out.print("Select sort : ");
            String menu = input.next();
            if (!menu.equalsIgnoreCase("G") && !menu.equalsIgnoreCase("L")
            && !menu.equalsIgnoreCase("S") && !menu.equalsIgnoreCase("W") && !menu.equalsIgnoreCase("N")) {
        break;
    }
            System.out
                    .println("Animal\t\t Weight (kg)\tSleep time (hrs/day)\tMaximum lifespan (yrs)\tGestation (days)");
            System.out.println(
                    "===============================================================================================");

            if (menu.equalsIgnoreCase("N")) {
                Collections.sort(AnimalRecords, new SortAnimalByName());
                for (Animal m : AnimalRecords) {
                    System.out.println(m.getName() + "\r\t\t\t" + m.getWeight() + "\t\t" +
                            m.getSleep() + "\t\t\t" + m.getLifespan() + "\t\t\t" + m.getGestation());
                }
            } else if (menu.equalsIgnoreCase("W")) {
                Collections.sort(AnimalRecords, new SortAnimalByWeight());
                for (Animal m : AnimalRecords) {
                    System.out.println(m.getName() + "\r\t\t\t" + m.getWeight() + "\t\t" +
                            m.getSleep() + "\t\t\t" + m.getLifespan() + "\t\t\t" + m.getGestation());
                }
            } else if (menu.equalsIgnoreCase("S")) {
                Collections.sort(AnimalRecords, new SortAnimalBySleep());
                for (Animal m : AnimalRecords) {
                    System.out.println(m.getName() + "\r\t\t\t" + m.getWeight() + "\t\t" +
                            m.getSleep() + "\t\t\t" + m.getLifespan() + "\t\t\t" + m.getGestation());
                }
            } else if (menu.equalsIgnoreCase("L")) {
                Collections.sort(AnimalRecords, new SortAnimalByLifespan());
                for (Animal m : AnimalRecords) {
                    System.out.println(m.getName() + "\r\t\t\t" + m.getWeight() + "\t\t" +
                            m.getSleep() + "\t\t\t" + m.getLifespan() + "\t\t\t" + m.getGestation());
                }
            }
            else if (menu.equalsIgnoreCase("G")) {
                Collections.sort(AnimalRecords, new SortAnimalByGestation());
                for (Animal m : AnimalRecords) {
                    System.out.println(m.getName() + "\r\t\t\t" + m.getWeight() + "\t\t" +
                            m.getSleep() + "\t\t\t" + m.getLifespan() + "\t\t\t" + m.getGestation());
                }
            }
        }
    }
}
