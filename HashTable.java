import java.util.Scanner;

public class HashTable {
    
    static class Node {
        int key;
        int value; 
        Node next;
        
        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    private Node[] tabel = new Node[10];

    public void insert(int key) {
        int indeks = key % 10; 
        int value = key % 10;  
        
        Node newNode = new Node(key, value);
        
        newNode.next = tabel[indeks];
        tabel[indeks] = newNode;
    }

    public String search(int key) {
        int indeks = key % 10; 
        Node temp = tabel[indeks];
        
        while (temp != null) {
            if (temp.key == key) {
                return "Ditemukan! Value: " + temp.value;
            }
            temp = temp.next;
        }
        return "Tidak ditemukan";
    }

    public void display() {
        System.out.println("\n=== HASH TABLE ===");
        for (int i = 0; i < 10; i++) {
            System.out.print("Indeks " + i + ": ");
            Node temp = tabel[i];
            
            if (temp == null) {
                System.out.print("kosong");
            }
            
            while (temp != null) {
                System.out.print("[" + temp.key + " -> Val: " + temp.value + "]");
                if (temp.next != null) {
                    System.out.print(" -> ");
                }
                temp = temp.next;
            }
            System.out.println();
        }
        System.out.println("======================\n");
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();
    
        int[] dataKeys = {43, 22, 1, 12, 34, 56, 77, 88};
        for (int k : dataKeys) {
            ht.insert(k);
        }
        
        ht.display();
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.print("Masukkan key yang dicari (atau ketik -1 untuk keluar): ");
            int keyDicari = input.nextInt();
            
            if (keyDicari == -1) {
                System.out.println("Program selesai. Terima kasih!");
                break; 
            }
            
            String hasilPencarian = ht.search(keyDicari);
            System.out.println("Hasil untuk key " + keyDicari + ": " + hasilPencarian);
            System.out.println("--------------------------------------------------");
        }
    }
}