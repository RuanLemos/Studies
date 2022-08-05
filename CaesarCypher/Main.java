import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op;

        System.out.println("1 - Criptografar mensagem.\n2 - Descriptografar mensagem.");
        System.out.print("Sua escolha: ");
        op = sc.nextInt();
        sc.nextLine();

        if (op != 1 && op != 2) {
            do {
                System.out.println("Número inválido! Insira 1 para criptografar ou 2 para descriptografar.");
                op = sc.nextInt();
                sc.nextLine();
            } while(op != 1 && op != 2);
        }

        if (op == 1) {
            System.out.println("Insira a mensagem para criptografar: ");
            String mensagem = sc.nextLine();
            System.out.println("Sua mensagem criptografada: " + criptografar(mensagem));
        } else {
            System.out.println("Insira a mensagem para descriptografar: ");
            String mensagem = sc.nextLine();
            System.out.println("Sua mensagem descriptografada: " + descriptografar(mensagem));
        }

    }

    public static String criptografar(String mensagem) {

        String msgCripto = "";
        int valorLetra = 0;
        int diferenca = 0;
        int valorVolta;
        char letra;

        for (int i = 0; i < mensagem.length(); i++) {
            letra = mensagem.charAt(i);
            valorLetra = letra;
            if (Character.isLetter(letra)) {
                if (valorLetra < 88) {
                    msgCripto += (char)(letra + 3);
                } else {
                    diferenca = valorLetra - 88;
                    valorVolta = diferenca + 'A';
                    msgCripto += (char)(valorVolta);
                }
            } else if (letra == ' ') {
                msgCripto += " ";
            } else if (Character.isDigit(letra)) {
                if (valorLetra < 55) {
                    msgCripto += (char)(letra + 3);
                } else {
                    diferenca = valorLetra - 55;
                    valorVolta = diferenca + '0';
                    msgCripto += (char)(valorVolta);
                }
            }
        }
        if (msgCripto != "") {
            return msgCripto;
        } else {
            return "Impossível criptografar a mensagem inserida.";
        }
    }

    public static String descriptografar(String mensagem) {

        String msgCripto = "";
        int valorLetra = 0;
        int diferenca = 0;
        int valorVolta;
        char letra;

        for (int i = 0; i < mensagem.length(); i++) {
            letra = mensagem.charAt(i);
            valorLetra = letra;
            if (Character.isLetter(letra)) {
                if (valorLetra <= 67) {
                    diferenca = 67 - valorLetra;
                    valorVolta = 'Z' - diferenca;
                    msgCripto += (char)(valorVolta);
                } else {
                    msgCripto += (char)(letra - 3);
                }
            } else if (letra == ' ') {
                msgCripto += " ";
            } else if (Character.isDigit(letra)) {
                if (valorLetra <= 50) {
                    diferenca = 50 - valorLetra;
                    valorVolta = '9' - diferenca;
                    msgCripto += (char)(valorVolta);
                } else {
                    msgCripto += (char)(letra - 3);
                }
            }
        }
        if (msgCripto != "") {
            return msgCripto;
        } else {
            return "Impossível criptografar a mensagem inserida.";
        }
    }
}
