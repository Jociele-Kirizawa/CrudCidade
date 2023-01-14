package View;

import Controler.CidadeController;
import Controler.impl.CidadeArmazenamentoController;
import Model.Cidade;

import java.util.Scanner;
import java.util.UUID;

public class CidadeView {
    private Scanner scan = new Scanner(System.in);
    private CidadeController controller = new CidadeArmazenamentoController();


    public void cadastrar() {
        Cidade cidade = new Cidade();

        System.out.println("Infome o nome da cidade que você deseja cadastrar: ");
        String nomeCidade = scan.nextLine();
        cidade.setNome(nomeCidade);


        System.out.println("Informe o estado: ");
        String nomeEstado = scan.nextLine();
        cidade.setEstado(nomeEstado);
        controller.cadastrar(cidade);

    }


}



