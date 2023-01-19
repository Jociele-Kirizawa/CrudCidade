package br.com.ada.cru.cidade;

import br.com.ada.cru.View.CidadeView;
import br.com.ada.cru.View.EstadoView;
import br.com.ada.cru.View.PaisView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaisView paisView = new PaisView();
        EstadoView estadoView = new EstadoView();
        CidadeView cidadeView = new CidadeView();

        Scanner scan = new Scanner(System.in);
        int opcao;
        
        do {

            System.out.println("Qual a opção desejada: ");
            System.out.println("1- Cadastrar Países");
            System.out.println("2- Cadastrar Estados");
            System.out.println("3- Cadastrar Cidades");
            System.out.println("0- sair");

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    paisView.exibirOpcoesPaises();
                    break;
                case 2:
                    estadoView.exibirOpcoesEstado();
                    break;
                case 3:
                    cidadeView.exibirOpcoes();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("opção invalida");
            }
        }  while (opcao!=0);
    }


}
