public class Main {

    public static void main(String[] args) {

        Tree arvore = new Tree();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Pre-ordem:");
        arvore.preOrdem();

        System.out.println("Em ordem:");
        arvore.emOrdem();

        System.out.println("Pos-ordem:");
        arvore.posOrdem();

        System.out.println("\nExcluindo o valor 30...");
        arvore.excluir(30);

        System.out.println("Em ordem apos a exclusao:");
        arvore.emOrdem();
    }
}
