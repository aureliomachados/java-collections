import java.util.LinkedList;

public class ExemploLinkedList {
    public static void main(String[] args) {
        System.out.println("Cria uma lista chamada notas2 e coloque todos os elementos da list arraylist nesta lista: ");
        LinkedList<Double> notas2 = new LinkedList<>();

        notas2.add(7.0);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5.0);
        notas2.add(7.0);
        notas2.add(0.0);
        notas2.add(3.6);

        System.out.println("Mostre a primeira nota da nova lista sem removê-lo: " + notas2.getFirst());

        System.out.println("Mostre a primeira nota da nova lista removendo-a: ");

        notas2.removeFirst();

        System.out.println(notas2);
    }
}
