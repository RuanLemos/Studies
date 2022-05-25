import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        ListaMusicas listaMusicas = new ListaMusicas();
        Scanner sc = new Scanner(System.in);

        int op;
        String op2;

        do {
            CD cd = new CD();
            Musica[] msc = new Musica[12];
            System.out.println("   _       _        _               \n" +
                    "  (_)     | |      | |              \n" +
                    "   _ _   _| | _____| |__   _____  __\n" +
                    "  | | | | | |/ / _ \\ '_ \\ / _ \\ \\/ /\n" +
                    "  | | |_| |   <  __/ |_) | (_) >  < \n" +
                    "  | |\\__,_|_|\\_\\___|_.__/ \\___/_/\\_\\\n" +
                    " _/ |                               \n" +
                    "|__/ ");
            System.out.println("==================================");
            System.out.println("1 - Inserir CD");
            System.out.println("2 - Retirar CD");
            System.out.println("3 - Tocar um CD");
            System.out.println("4 - Mostrar todos os CDs");
            System.out.println("5 - Consultar CD");
            System.out.println("6 - Ordenar CDs");
            System.out.println("0 - Quit");
            System.out.println("==================================");
            System.out.print("Opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Insira o título do CD: ");
                    cd.setTitulo(sc.nextLine());
                    System.out.println("Insira o compositor/coletânea: ");
                    cd.setCompositor(sc.nextLine());
                    int qtdMusicas = 0;
                    String opMsc = "";
                    do {
                        Musica auxMsc = new Musica();
                        if (qtdMusicas != 0) {
                            System.out.println("CASO QUEIRA PARAR, DIGITE 0. PARA CONTINUAR INSERINDO MÚSICAS, INSIRA QUALQUER OUTRA COISA");
                            opMsc = sc.nextLine();
                        }
                        if (!opMsc.equals("0")) {
                            System.out.println("Insira o título da música " + (qtdMusicas+1) +": ");
                            auxMsc.setTitulo(sc.nextLine());
                            System.out.println("Insira o cantor/conjunto: ");
                            auxMsc.setCompositor(sc.nextLine());
                            System.out.println("Insira a duração da música: ");
                            auxMsc.setDuracao(sc.nextLine());
                            msc[qtdMusicas] = auxMsc;
                            qtdMusicas++;
                        }
                    } while(!opMsc.equals("0"));
                    //System.out.println(jukebox.returnTopo());
                    cd.setMusicas(msc);
                    jukebox.Push(cd);
                    listaMusicas.Inserir(msc, jukebox.returnTopo());
                    break;
                case 2:
                    if (!jukebox.isEmpty()) {
                        System.out.println(jukebox.Imprime());
                        System.out.println("==================================");
                        System.out.println("Digite o número do CD a ser deletado: ");
                        op = sc.nextInt();
                        sc.nextLine();
                        jukebox.retirar(op);
                        listaMusicas.reorganizarMusicas(jukebox.returnStack());
                        if (jukebox.temCd(op)) {
                            System.out.println("CD retirado com sucesso!");
                        }
                        op = 2;
                    } else {
                        System.out.println(jukebox.Imprime());
                    }
                    break;
                case 3:
                    if (!jukebox.isEmpty()) {
                        System.out.println(jukebox.Imprime());
                        System.out.println("==================================");
                        System.out.println("Digite o número do CD a ser tocado: ");
                        op = sc.nextInt();
                        sc.nextLine();
                        jukebox.tocar(op);
                        listaMusicas.reorganizarMusicas(jukebox.returnStack());
                        if (jukebox.temCd(op)) {
                            System.out.println("o CD " + op + " está tocando agora!");
                        }
                        op = 3;
                    } else {
                        System.out.println("A jukebox está vazia!");
                    }
                    break;
                case 4:
                    System.out.println(jukebox.Imprime());
                    System.out.println("==================================");
                    System.out.println("Digite qualquer coisa para prosseguir...");
                    op2 = sc.nextLine();
                    break;
                case 5:
                    if (!jukebox.isEmpty()) {
                        System.out.println(jukebox.Imprime());
                        System.out.println("==================================");
                        System.out.println("Insira o número do CD que deseja consultar: ");
                        op = sc.nextInt();
                        sc.nextLine();
                        if(jukebox.temCd(op)) {
                            System.out.println("==================================");
                            System.out.println(listaMusicas.ImprimePreviaMusicas(op));
                            System.out.println("==================================");
                            System.out.println("Caso deseja consultar todas as músicas, digite -1\n" +
                                    "Do contrário, insira o número de qual música deseja consultar.");
                            int aux = sc.nextInt();
                            sc.nextLine();
                            if (aux == -1) {
                                System.out.println(listaMusicas.ImprimeTodas(op));
                            } else if (listaMusicas.temMusica(op, aux)){
                                System.out.println(listaMusicas.ImprimeUmaMusica(op, aux));
                            } else {
                                System.out.println("A música selecionada não existe!");
                            }
                        } else {
                            System.out.println("Este CD não existe!");
                        }
                    } else {
                        System.out.println("A jukebox está vazia!");
                    }
                    break;
                case 6:
                    if (jukebox.isEmpty()) {
                        System.out.println("A jukebox está vazia!");
                    } else {
                        System.out.println("==================================");
                        System.out.println("Para organizar alfabeticamente por título, digite um.\n" +
                                "Para organizar alfabeticamente por compositor, digite dois.");
                        op = sc.nextInt();
                        sc.nextLine();
                        if (op == 1) {
                            jukebox.reorganizarPorTitulo();
                        } else if (op == 2) {
                            jukebox.reorganizarPorCompositor();
                        }
                        listaMusicas.reorganizarMusicas(jukebox.returnStack());
                        System.out.println("Jukebox reorganizada com sucesso!");
                    }
                    break;
            }
        } while (op != 0);
    }
}
