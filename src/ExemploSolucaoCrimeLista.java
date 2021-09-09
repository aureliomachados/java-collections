import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExemploSolucaoCrimeLista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> perguntasCrime = new ArrayList<>();

        System.out.println("Responda S para Sim e N para não: ");
        System.out.println("1 - Telefonou para a vítima?");
        perguntasCrime.add(scanner.nextLine());
        System.out.println("2 - Esteve no local do crime?");
        perguntasCrime.add(scanner.nextLine());
        System.out.println("3 - Mora perto da vítima?");
        perguntasCrime.add(scanner.nextLine());
        System.out.println("4 - Devia para a vitima?");
        perguntasCrime.add(scanner.nextLine());
        System.out.println("5 - Já trabalhou para a vítima?");
        perguntasCrime.add(scanner.nextLine());

        int respostasSim = 0;
        for (String perguntaCrime:
             perguntasCrime) {
            if (perguntaCrime.equalsIgnoreCase("S")) {
                respostasSim += 1;
            }
            }
        if (respostasSim == 2){
            System.out.println("Você é considerado suspeito!");
        }
        else if(respostasSim >= 3 && respostasSim <= 4){
            System.out.println("Você é considerado cúmplice!");
        } else if (respostasSim == 5) {
            System.out.println("Você é considerado assassino(a)!");
        }
        else{
            System.out.println("Você é considerado como inocente");
        }

        switch (respostasSim){
            case 2:
                System.out.println("Suspeito"); break;
            case 3:
            case 4:
                System.out.println("Cúmplice"); break;
            case 5:
                System.out.println("Assassino"); break;
            default:
                System.out.println("Inocente");break;
        }
    }
}
