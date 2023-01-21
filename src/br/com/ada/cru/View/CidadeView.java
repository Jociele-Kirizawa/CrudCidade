package br.com.ada.cru.View;

import br.com.ada.cru.Controler.CidadeController;
import br.com.ada.cru.Model.cidade.Cidade;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CidadeView {
    private Scanner scan;
    private CidadeController controller;

    public CidadeView(CidadeController controller, Scanner scan){
        this.controller=controller;
        this.scan = scan;
    }

    public void exibirOpcoes(){
        System.out.println("Qual a opção desejada: ");
        System.out.println("1- Cadastrar");
        System.out.println("2- Listar");
        System.out.println("3- Atualizar");
        System.out.println("4 - Apagar");
        System.out.println("0 - sair");
        Integer opcao = scan.nextInt();
        scan.nextLine();

        switch (opcao){
            case 1:
                cadastrar();
                break;
            case 2:
                listar();
                break;
            case 3:
                atualizar();
                break;
            case 4:
                apagar();
                break;
            case  0:
                System.exit(0);
                break;
            default:
                System.out.println("opção invalida");
        }
        exibirOpcoes();
    }



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
    public void listar(UUID id) {
        Cidade cidade = controller.ler(id);
        exibirCidade(cidade);

    }
    public void listar(){
        List<Cidade> cidades = controller.listar();

        for (int index=0; index < cidades.size(); index++){
            System.out.println(index+1 + " - " );
            exibirCidade(cidades.get(index));
        }


    }
    public void exibirCidade(Cidade cidade){
        System.out.println("Cidade: " + cidade.getNome() + " Estado: " + cidade.getEstado());
    }
    public void atualizar (){
        listar();
        System.out.println("Informe o numero do cliente que deseja atualizar");
        Integer numeroCidade = scan.nextInt();
        scan.nextLine();
        Cidade cidade = controller.listar().get(numeroCidade - 1);
        atualizar(cidade);

    }
    public void atualizar (Cidade cidade){

        exibirCidade(cidade);

        System.out.println("Informe o nome da cidade");
        String nomeCidade = scan.nextLine();
        cidade.setNome(nomeCidade);

        System.out.println("Informe o EStado?" );
        String nomeEstado = scan.nextLine();
        cidade.setEstado(nomeEstado);

        controller.update(cidade.getId(), cidade);
    }
    public void apagar(){
        listar();
        System.out.println("Informe o numero do cliente que deseja apagar");
        Integer numero = scan.nextInt();
        Cidade cidade = controller.listar().get(numero-1);
        apagar(cidade.getId());

    }
    public void apagar (UUID id) {
        Cidade cidade = controller.Delete(id);
        System.out.println("Pessoa apagada foi ");
        exibirCidade(cidade);
    }




}



