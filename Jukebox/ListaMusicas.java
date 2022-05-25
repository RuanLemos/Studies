public class ListaMusicas {
    private final int SIZE = 10;
    private final int SIZE2 = 12;
    private Musica[][] lista;

    public ListaMusicas() {
        this.lista = new Musica[SIZE][SIZE2];
    }

    public boolean CDcheio(int cd) {
        for (int i = 0; i < 12; i++) {
            if (lista[cd][i] == null) {
                return false;
            }
        }
        return true;
    }

    public int topo(int cd) {
        for (int i = 0; i < 12; i++) {
            if (lista[cd][i] == null) {
                return i-1;
            }
        }
        return SIZE2-1;
    }

    public StringBuilder ImprimePreviaMusicas(int cd) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {

                if (this.lista[cd-1][i]==null)  break;
            sb.append("Música " + (i+1) + ": " + this.lista[cd-1][i].getTitulo() + "\n");
        }
        return sb;
    }

    public boolean temMusica(int cd, int n) {
        return (this.lista[cd-1][n-1] != null);
    }

    public StringBuilder ImprimeUmaMusica(int cd, int musica) {
        StringBuilder sb = new StringBuilder();
            if (!(this.lista[cd-1][musica-1]==null)){
                sb.append("Música " + (musica) + "\n" + "Título: "+ this.lista[cd-1][musica-1].getTitulo() + "\n");
                sb.append("Compositor: " + this.lista[cd-1][musica-1].getCompositor() + "\n");
                sb.append("Tempo de duração: " + this.lista[cd-1][musica-1].getDuracao() + "\n");
            }
        return sb;
    }

    public StringBuilder ImprimeTodas(int cd) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (this.lista[cd-1][i]==null)
                break;
            sb.append("Música " + (i+1) + "\n" + "Título: "+ this.lista[cd-1][i].getTitulo() + "\n");
            sb.append("Compositor: " + this.lista[cd-1][i].getCompositor() + "\n");
            sb.append("Tempo de duração: " + this.lista[cd-1][i].getDuracao() + "\n");
        }
        return sb;
    }

    public void Inserir(Musica[] m, int cd) {
        try {
            if (CDcheio(cd))
                throw new Exception("CD cheio");
            this.lista[cd] = m;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void reorganizarMusicas(CD[] cd){
        for (int i = 0; i < SIZE; i++) {
            if (cd[i] == null) {
                break;
            }
            this.lista[i] = cd[i].getMusicas();
        }
    }
}
