package br.com.ada.cru.View;

import br.com.ada.cru.Controler.impl.EstadoArmazenamentoController;
import br.com.ada.cru.Controler.impl.EstadoController;
import br.com.ada.cru.Model.Estado;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class EstadoView {
    private EstadoController estadoController; //= new EstadoArmazenamentoController();
    private Scanner scan; //= new Scanner(System.in);

    public EstadoView(EstadoController estadoController, Scanner scan) {
        this.estadoController = estadoController;
        this.scan = scan;
    }

    public void exibirOpcoesEstado(){
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
        exibirOpcoesEstado();
    }
    public void cadastrar() {
        Estado estado = new Estado();

        System.out.println("Infome o nome do estado que você deseja cadastrar: ");
        String nomeEstado = scan.nextLine();
        estado.setNome(nomeEstado);


        System.out.println("Informe o pais: ");
        String nomePais = scan.nextLine();
        estado.setPais(nomePais);


        System.out.println("Informe a sigla do estado: ");
        String sigla = scan.nextLine();
        estado.setSigla(sigla);
        estadoController.cadastrar(estado);


    }
    public void exibirEstado(Estado estado){
        System.out.println("Estado: " + estado.getNome() + " Pais: " + estado.getPais() + " sigla: " + estado.getSigla());
    }
    public void listar(UUID id) {
        Estado estado = estadoController.ler(id);
        exibirEstado(estado);

    }
    public void listar() {
        List<Estado> estados = estadoController.listar();

        for (int index = 0; index < estados.size(); index++) {
            System.out.print(index + 1 + " - ");
            exibirEstado(estados.get(index));
        }
    }
    public void atualizar (){
        listar();
        System.out.println("Informe o numero do Estado que deseja atualizar");
        Integer numeroEstado = scan.nextInt();
        scan.nextLine();
       Estado estado = estadoController.listar().get(numeroEstado - 1);
        atualizar(estado);

    }
    public void atualizar (Estado estado){

        exibirEstado(estado);

        System.out.println("Informe o nome do Estado");
        String nomeEstado = scan.nextLine();
        estado.setNome(nomeEstado);

        System.out.println("Informe o pais: ");
        String nomePais = scan.nextLine();
        estado.setPais(nomePais);


        System.out.println("Informe a sigla do estado: ");
        String sigla = scan.nextLine();
        estado.setSigla(sigla);

        estadoController.update(estado.getId(), estado);
    }
    public void apagar(){
        listar();
        System.out.println("Informe o numero do Estado que deseja apagar");
        Integer numero = scan.nextInt();
        Estado estado = estadoController.listar().get(numero-1);
        apagar(estado.getId());

    }
    public void apagar (UUID id) {
        Estado estado = estadoController.delete(id);
        System.out.println("Pessoa apagada foi ");
        exibirEstado(estado);
    }
}
