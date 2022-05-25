public class Jukebox {

    private int topo;
    private final int SIZE = 10;
    private CD[] stack;

    public boolean isFull(){
        if (this.topo==SIZE-1)
            return true;
        else
            return false;
    }

    public void Push(CD valor) {
        try {
            if (this.isFull())
                throw new Exception("Jukebox cheia");
            this.topo++;
            this.stack[this.topo] = valor;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public  boolean isEmpty(){
        if (this.topo==-1)
            return true;
        else
            return false;
    }

    public void retirar(int cd){
        try {
            if (!this.temCd(cd)) {
                throw new Exception("Não há CD correspondente a este valor.");
            }
            this.stack[cd-1] = null;
            this.topo--;
            int aux = cd-1;
            for (int i = cd; i < this.SIZE; i++) {
                if (this.stack[i] == null) {
                    break;
                }
                this.stack[aux] = this.stack[i];
                aux++;
            }
            this.stack[this.topo+1] = null;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void tocar(int cd){
        CD temp = new CD();
        try {
            if (!this.temCd(cd)) {
                throw new Exception("Não há CD correspondente a este valor.");
            }
            int aux = cd-1;
            temp = this.stack[aux];
            for (int i = cd; i < this.SIZE; i++) {
                if (this.stack[i] == null) {
                    break;
                }
                this.stack[aux] = this.stack[i];
                aux++;
            }
            this.stack[this.topo] = temp;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int returnTopo(){
        return this.topo;
    }

    public String Peek(){
        return ("topo:" + this.stack[this.topo]);
    }

    public void ShowAll() {
        for (int i = this.SIZE - 1; i >= 0; i--) {
            System.out.println("[" + i + "]" + this.stack[i]);
        }
    }

    public StringBuilder Imprime() {
        StringBuilder sb = new StringBuilder();
        try {
            if (this.isEmpty()) {
                throw new Exception("A jukebox está vazia.");
            }
            for (int i = 0; i < SIZE; i++) {
                if (this.stack[i]==null)
                    break;

                sb.append("CD " + (i+1) + ": " + this.stack[i].getTitulo() + "\n");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sb;
    }

    public boolean temCd(int n) {
        return (this.stack[n-1] != null);
    }

    public void reorganizarPorTitulo() {
        CD aux = new CD();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.stack[j+1] == null) {
                    break;
                }
                if (Character.valueOf(this.stack[j].getTitulo().charAt(0)) > Character.valueOf(this.stack[j+1].getTitulo().charAt(0))) {
                    aux = this.stack[j+1];
                    this.stack[j+1] = this.stack[j];
                    this.stack[j] = aux;
                }
            }
        }
    }

    public void reorganizarPorCompositor() {
        CD aux = new CD();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.stack[j+1] == null) {
                    break;
                }
                if (Character.valueOf(this.stack[j].getCompositor().charAt(0)) > Character.valueOf(this.stack[j+1].getCompositor().charAt(0))) {
                    aux = this.stack[j+1];
                    this.stack[j+1] = this.stack[j];
                    this.stack[j] = aux;
                }
            }
        }
    }

    public CD[] returnStack() {
        return this.stack;
    }

    public Jukebox() {
        this.stack = new CD[SIZE];
        this.topo = -1;
    }
}
