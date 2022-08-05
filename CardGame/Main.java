import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //declaração de variáveis iniciais
        Scanner sc = new Scanner(System.in);
        String carta1;
        String carta2;
        String carta3;

        System.out.println("=========================================");

        System.out.print("Digite a primeira carta: ");
        carta1 = sc.nextLine();

        //declaração de variáveis auxiliares
        char naipeCarta1 = ' ';
        int valorCarta1 = 0;
        boolean carta1valida = false;
        //verificar de o naipe da carta 1 é válido. Para ser válido, o último caracter da carta precisar ser P, C, E ou O.
        //como não se sabe o tamanho da carta, foi utilizado carta1.length()-1, pra obter o último índice da carta
        boolean naipeCarta1Valido = (carta1.charAt(carta1.length()-1) == 'P' || carta1.charAt(carta1.length()-1) == 'C' || carta1.charAt(carta1.length()-1) == 'E' || carta1.charAt(carta1.length()-1) == 'O');

        //switch com tamanho da carta, únicos tamanhos válidos são 2 e 3
        switch (carta1.length()) {
            case 3:
                //único caso válido de uma carta com 3 caracteres é tendo o valor 10 e o naipe válido sendo true
                //logo, se verifica se o primeiro caracter é um, o segundo 0 e o naipeCarta1Valido é true
                if (carta1.charAt(0) == '1' && carta1.charAt(1) == '0' && naipeCarta1Valido) {
                    //caso verdadeiro, a variável que indica que a carta é válida recebe true
                    //o naipeCarta1 recebe o último caracter da carta
                    //e o valor da carta é colocado como 10
                    carta1valida = true;
                    naipeCarta1 = carta1.charAt(2);
                    valorCarta1 = 10;
                } else {
                    //do contrário, a carta não é válida
                    carta1valida = false;
                }
                break;
            case 2:
                /*
                para a carta ser válida com tamanho 2, o primeiro caracter não pode ser 1, tem de ser algum dígito entre 2 e 9
                ou as letras A, J, Q e K. Também precisa ter o naipeCarta1Valido como true.
                Para saber se o char da posição 0 da carta1 é um número, usei o método isDigit da classe Character.
                 */
                if (carta1.charAt(0) != '1' && (Character.isDigit(carta1.charAt(0)) || carta1.charAt(0) == 'A' || carta1.charAt(0) == 'J' || carta1.charAt(0) == 'Q' || carta1.charAt(0) == 'K') && naipeCarta1Valido) {
                    //caso verdadeiro, se faz um switch com o índice 0 da carta, pra saber qual o valor que a carta terá
                    switch (carta1.charAt(0)) {
                        case 'A':
                            valorCarta1 = 1;
                            break;
                        case 'J':
                            valorCarta1 = 11;
                            break;
                        case 'Q':
                            valorCarta1 = 12;
                            break;
                        case 'K':
                            valorCarta1 = 13;
                            break;
                        default:
                            //se não for nenhum dos casos acima, a condição verdadeira no if havia sido o Character.isDigit, ou seja, é um número.
                            valorCarta1 = Character.getNumericValue(carta1.charAt(0));
                            break;
                            //usei o Character.getNumericValue para resgatar o valor int do char. Isso é necessário pois senão daria um valor diferente do número inserido
                            //pelo usuário
                    }
                    //pegar o último char do carta1 e botar no naipeCarta1. Colocar o carta1valida como true.
                    naipeCarta1 = carta1.charAt(1);
                    carta1valida = true;
                } else {
                    //do contrário, a carta não é válida
                    carta1valida = false;
                }
        }

        System.out.print("Digite a segunda carta: ");
        carta2 = sc.nextLine();

        //declaração de variáveis auxiliares
        char naipeCarta2 = ' ';
        int valorCarta2 = 0;
        boolean carta2valida = false;
        //verificar de o naipe da carta 2 é válido. Para ser válido, o último caracter da carta precisar ser P, C, E ou O.
        //como não se sabe o tamanho da carta, foi utilizado carta2.length()-1, pra obter o último índice da carta
        boolean naipeCarta2Valido = (carta2.charAt(carta2.length()-1) == 'P' || carta2.charAt(carta2.length()-1) == 'C' || carta2.charAt(carta2.length()-1) == 'E' || carta2.charAt(carta2.length()-1) == 'O');

        //switch com tamanho da carta, únicos tamanhos válidos são 2 e 3
        switch (carta2.length()) {
            case 3:
                //único caso válido de uma carta com 3 caracteres é tendo o valor 10 e o naipe válido sendo true
                //logo, se verifica se o primeiro caracter é um, o segundo 0 e o naipeCarta1Valido é true
                if (carta2.charAt(0) == '1' && carta2.charAt(1) == '0' && naipeCarta2Valido) {
                    //caso verdadeiro, a variável que indica que a carta é válida recebe true
                    //o naipeCarta2 recebe o último caracter da carta
                    //e o valor da carta é colocado como 10
                    carta2valida = true;
                    naipeCarta2 = carta2.charAt(2);
                    valorCarta2 = 10;
                } else {
                    //do contrário, a carta não é válida
                    carta2valida = false;
                }
                break;
            case 2:
                /*
                para a carta ser válida com tamanho 2, o primeiro caracter não pode ser 1, tem de ser algum dígito entre 2 e 9
                ou as letras A, J, Q e K. Também precisa ter o naipeCarta2Valido como true.
                Para saber se o char da posição 0 da carta2 é um número, usei o método isDigit da classe Character.
                 */
                if (carta2.charAt(0) != '1' && (Character.isDigit(carta2.charAt(0)) || carta2.charAt(0) == 'A' || carta2.charAt(0) == 'J' || carta2.charAt(0) == 'Q' || carta2.charAt(0) == 'K') && naipeCarta2Valido) {
                    //caso verdadeiro, se faz um switch com o índice 0 da carta, pra saber qual o valor que a carta terá
                    switch (carta2.charAt(0)) {
                        case 'A':
                            valorCarta2 = 1;
                            break;
                        case 'J':
                            valorCarta2 = 11;
                            break;
                        case 'Q':
                            valorCarta2 = 12;
                            break;
                        case 'K':
                            valorCarta2 = 13;
                            break;
                        default:
                            //se não for nenhum dos casos acima, a condição verdadeira no if havia sido o Character.isDigit, ou seja, é um número.
                            valorCarta2 = Character.getNumericValue(carta2.charAt(0));
                            break;
                            //usei o Character.getNumericValue para resgatar o valor int do char. Isso é necessário, pois senão daria um valor diferente do número inserido
                            //pelo usuário
                    }
                    //pegar o último char do carta2 e botar no naipeCarta2. Colocar o carta1valida como true.
                    naipeCarta2 = carta2.charAt(1);
                    carta2valida = true;
                } else {
                    //do contrário, a carta não é válida
                    carta2valida = false;
                }
        }

        System.out.print("Digite a terceira carta: ");
        carta3 = sc.nextLine();

        //declaração de variáveis auxiliares
        char naipeCarta3 = ' ';
        int valorCarta3 = 0;
        boolean carta3valida = false;
        //verificar de o naipe da carta 3 é válido. Para ser válido, o último caracter da carta precisar ser P, C, E ou O.
        //como não se sabe o tamanho da carta, foi utilizado carta3.length()-1, pra obter o último índice da carta
        boolean naipeCarta3Valido = (carta3.charAt(carta3.length()-1) == 'P' || carta3.charAt(carta3.length()-1) == 'C' || carta3.charAt(carta3.length()-1) == 'E' || carta3.charAt(carta3.length()-1) == 'O');

        //switch com tamanho da carta, únicos tamanhos válidos são 2 e 3
        switch (carta3.length()) {
            case 3:
                //único caso válido de uma carta com 3 caracteres é tendo o valor 10 e o naipe válido sendo true
                //logo, se verifica se o primeiro caracter é um, o segundo 0 e o naipeCarta1Valido é true
                if (carta3.charAt(0) == '1' && carta3.charAt(1) == '0' && naipeCarta3Valido) {
                    //caso verdadeiro, a variável que indica que a carta é válida recebe true
                    //o naipeCarta3 recebe o último caracter da carta
                    //e o valor da carta é colocado como 10
                    carta3valida = true;
                    naipeCarta3 = carta3.charAt(2);
                    valorCarta3 = 10;
                } else {
                    //do contrário, a carta não é válida
                    carta3valida = false;
                }
                break;
            case 2:
                /*
                para a carta ser válida com tamanho 2, o primeiro caracter não pode ser 1, tem de ser algum dígito entre 2 e 9
                ou as letras A, J, Q e K. Também precisa ter o naipeCarta3Valido como true.
                Para saber se o char da posição 0 da carta3 é um número, usei o método isDigit da classe Character.
                 */
                if (carta3.charAt(0) != '1' && (Character.isDigit(carta3.charAt(0)) || carta3.charAt(0) == 'A' || carta3.charAt(0) == 'J' || carta3.charAt(0) == 'Q' || carta3.charAt(0) == 'K') && naipeCarta3Valido) {
                    //caso verdadeiro, se faz um switch com o índice 0 da carta, pra saber qual o valor que a carta terá
                    switch (carta3.charAt(0)) {
                        case 'A':
                            valorCarta3 = 1;
                            break;
                        case 'J':
                            valorCarta3 = 11;
                            break;
                        case 'Q':
                            valorCarta3 = 12;
                            break;
                        case 'K':
                            valorCarta3 = 13;
                            break;
                        default:
                            //se não for nenhum dos casos acima, a condição verdadeira no if havia sido o Character.isDigit, ou seja, é um número.
                            valorCarta3 = Character.getNumericValue(carta3.charAt(0));
                            break;
                            //usei o Character.getNumericValue para resgatar o valor int do char. Isso é necessário, pois senão daria um valor diferente do número inserido
                            //pelo usuário
                    }
                    //pegar o último char do carta2 e botar no naipeCarta2. Colocar o carta1valida como true.
                    naipeCarta3 = carta3.charAt(1);
                    carta3valida = true;
                } else {
                    //do contrário, a carta não é válida
                    carta3valida = false;
                }
        }

        System.out.println("=========================================");
        System.out.println("              RESULTADOS");
        System.out.println("=========================================");

        //apenas calcula as verificações caso as três cartas sejam válidas
        if (carta1valida && carta2valida && carta3valida) {

            //declaração de variável auxiliar, para não precisar repetir este código na hora de verificar uma sequência premium.
            boolean flush = false;

            //verificar se os naipes das três cartas são iguais. Caso sejam, flush recebe verdadeiro.
            if (naipeCarta1 == naipeCarta2 && naipeCarta2 == naipeCarta3) {
                System.out.println("As cartas são todas do mesmo naipe? Sim");
                flush = true;
            } else {
                System.out.println("As cartas são todas do mesmo naipe? Não");
            }

            //declaração de variável auxiliar, para não precisar repetir este código na hora de verificar uma trinca.
            boolean naipesDiferentes = false;

            //verificar se os naipes das três cartas são diferentes. Caso sejam, naipeDiferentes recebe verdadeiro.
            if (naipeCarta1 != naipeCarta2 && naipeCarta2 != naipeCarta3 && naipeCarta1 != naipeCarta3) {
                System.out.println("As cartas são todas de naipes diferentes? Sim");
                naipesDiferentes = true;
            } else {
                System.out.println("As cartas são todas de naipes diferentes? Não");
            }

            //caso os valores de todas as cartas sejam iguais e o naipeDiferentes for verdadeiro, é uma trinca.
            if (valorCarta1 == valorCarta2 && valorCarta2 == valorCarta3 && naipesDiferentes) {
                System.out.println("É uma trinca? Sim");
            } else {
                System.out.println("É uma trinca? Não");
            }

            //para verificar uma sequência, primeiro se verifica se todas as cartas possuem valores diferentes.
            if (valorCarta1 != valorCarta2 && valorCarta2 != valorCarta3 && valorCarta1 != valorCarta3) {

                //declaração de variáveis auxiliares, para o caso de o usuário ter inserido as cartas fora de ordem.
                int auxMaior = valorCarta3;
                int auxMedio = valorCarta2;
                int auxMenor = valorCarta1;
                int aux;


                if (auxMenor > auxMedio) {
                    aux = auxMedio;
                    auxMedio = auxMenor;
                    auxMenor = aux;
                    if (auxMedio > auxMaior) {
                        aux = auxMaior;
                        auxMaior = auxMedio;
                        auxMedio = aux;
                        if (auxMenor > auxMedio) {
                            aux = auxMedio;
                            auxMedio = auxMenor;
                            auxMenor = aux;
                        }
                    }
                } else if (auxMedio > auxMaior) {
                    aux = auxMaior;
                    auxMaior = auxMedio;
                    auxMedio = aux;
                    if (auxMenor > auxMaior) {
                        aux = auxMaior;
                        auxMaior = auxMenor;
                        auxMenor = auxMaior;
                    } else if (auxMenor > auxMedio){
                        aux = auxMedio;
                        auxMedio = auxMenor;
                        auxMenor = aux;
                    }
                }

                /*
                após ordenar todas as variáveis auxiliares, se verifica se elas formam uma sequência.
                pra ser uma sequência, o primeiro + 1 tem de ser o segundo, e o segundo + 1 precisa ser igual ao terceiro. É assim que sequências funcionam.
                 */
                boolean sequencia = (auxMenor + 1) == auxMedio && (auxMedio + 1) == auxMaior;

                if (sequencia) {
                    //caso verdadeiro, verifica-se o valor do flush. Caso true, será uma sequência premium. Caso falso, será uma sequência comum
                    if (flush) {
                        System.out.println("É uma sequência premium!");
                    } else {
                        System.out.println("É uma sequência comum.");
                    }
                } else {
                    //caso sequência seja false, não é uma sequência.
                    System.out.println("Não é uma sequência.");
                }
            }
        } else {
            //caso falhe no primeiro if, significa que uma das três cartas teve um valor inválido pra carta.
            System.out.println("Nem todas as cartas foram inseridas corretamente. Tente novamente.");
        }
    }
}
