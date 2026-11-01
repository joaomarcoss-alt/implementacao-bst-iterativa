import java.util.Stack;

public class Tree {

    Node raiz;

    public Tree() {
        raiz = null;
    }

    public void inserir(int valor) {

        Node novo = new Node(valor);

        if (raiz == null) {
            raiz = novo;
            return;
        }

        Node atual = raiz;
        Node anterior = null;

        while (atual != null) {
            anterior = atual;

            if (valor < atual.valor) {
                atual = atual.esquerda;
            } else if (valor > atual.valor) {
                atual = atual.direita;
            } else {
                return;
            }
        }

        if (valor < anterior.valor) {
            anterior.esquerda = novo;
        } else {
            anterior.direita = novo;
        }
    }

    public void preOrdem() {

        if (raiz == null) {
            return;
        }

        Stack<Node> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {

            Node atual = pilha.pop();

            System.out.print(atual.valor + " ");

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }

            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }

        System.out.println();
    }

    public void emOrdem() {

        Stack<Node> pilha = new Stack<>();
        Node atual = raiz;

        while (atual != null || !pilha.isEmpty()) {

            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }

            atual = pilha.pop();

            System.out.print(atual.valor + " ");

            atual = atual.direita;
        }

        System.out.println();
    }

    public void posOrdem() {

        if (raiz == null) {
            return;
        }

        Stack<Node> pilha1 = new Stack<>();
        Stack<Node> pilha2 = new Stack<>();

        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {

            Node atual = pilha1.pop();
            pilha2.push(atual);

            if (atual.esquerda != null) {
                pilha1.push(atual.esquerda);
            }

            if (atual.direita != null) {
                pilha1.push(atual.direita);
            }
        }

        while (!pilha2.isEmpty()) {
            System.out.print(pilha2.pop().valor + " ");
        }

        System.out.println();
    }
  
    public void excluir(int valor) {

        Node atual = raiz;
        Node pai = null;

        while (atual != null && atual.valor != valor) {

            pai = atual;

            if (valor < atual.valor) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }
      
        if (atual == null) {
            System.out.println("Valor nao encontrado.");
            return;
        }
      
        if (atual.esquerda != null && atual.direita != null) {

            Node paiSucessor = atual;
            Node sucessor = atual.direita;

            while (sucessor.esquerda != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.esquerda;
            }

            atual.valor = sucessor.valor;

            atual = sucessor;
            pai = paiSucessor;
        }

        Node filho;

        if (atual.esquerda != null) {
            filho = atual.esquerda;
        } else {
            filho = atual.direita;
        }
      
        if (pai == null) {
            raiz = filho;
        } else if (pai.esquerda == atual) {
            pai.esquerda = filho;
        } else {
            pai.direita = filho;
        }
    }
}
