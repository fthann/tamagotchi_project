import java.util.Scanner;

class Tamagotchi {
    private String name;
    private int lapar;
    private int bahagia;
    private int energi;

    public Tamagotchi(String name) {
        this.name = name;
        this.lapar = 50;
        this.bahagia = 50;
        this.energi = 50;
    }

    public void makan() {
        if (lapar > 0) {
            lapar -= 10;
            if (lapar < 0) lapar = 0;
            energi -= 5;
            System.out.println(name + " telah diberi makan.");
        } else {
            System.out.println(name + " tidak lapar saat ini.");
        }
        checkCondition();
    }

    public void main() {
        if (bahagia < 100) {
            bahagia += 10;
            if (bahagia > 100) bahagia = 100;
            energi -= 10;
            System.out.println(name + " sedang bermain!");
        } else {
            System.out.println(name + " sedang bahagia!");
        }
        checkCondition();
    }

    public void rehat() {
        if (energi < 100) {
            energi += 15;
            if (energi > 100) energi = 100;
            bahagia -= 5;
            System.out.println(name + " sedang beristirahat.");
        } else {
            System.out.println(name + " sudah cukup istirahat!");
        }
        checkCondition();
    }

    

    public void showStatus() {
        System.out.println("--- Status " + name + " ---");
        System.out.println("kelaparann: " + lapar);
        System.out.println("bahagia: " + bahagia);
        System.out.println("energi: " + energi);
    }

    private void checkCondition() {
        if (lapar >= 100) {
            System.out.println(name + " sakit karena kelaparan!");
        }
        if (energi <= 0) {
            System.out.println(name + " tertidur karena kelelahan.");
            energi = 20;
        }
        if (bahagia <= 0) {
            System.out.println(name + " sangat sedih dan mogok beraktivitas.");
        }
    }
}

public class TamagotchiGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama Tamagotchi: ");
        String name = scanner.nextLine();
        Tamagotchi tama = new Tamagotchi(name);

        while (true) {
            System.out.println("\n1. beri makan");
            System.out.println("2. ajak bermain");
            System.out.println("3. istirahat");
            System.out.println("4. lihat status");
            System.out.println("5. keluar");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tama.makan();
                    break;
                case 2:
                    tama.main();
                    break;
                case 3:
                    tama.rehat();
                    break;
                case 4:
                    tama.showStatus();
                    break;
                case 5:
                    System.out.println("Terima kasih telah bermain!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
