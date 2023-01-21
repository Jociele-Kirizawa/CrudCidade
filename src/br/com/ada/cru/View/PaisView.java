package br.com.ada.cru.View;

import br.com.ada.cru.Controler.impl.PaisArmazenamentoController;
import br.com.ada.cru.Controler.impl.PaisController;
import br.com.ada.cru.Model.Pais;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class PaisView {
     private PaisController controllerPais;
     private Scanner scan;

    public PaisView(PaisController controllerPais, Scanner scan) {
        this.controllerPais = controllerPais;
        this.scan = scan;
    }

    public void exibirOpcoesPaises(){
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
        exibirOpcoesPaises();
    }

    public void cadastrar(){
        Pais pais = new Pais();
        System.out.println("Informe o pais que vc deseja cadastrar: ");
        String nomePais = scan.nextLine();
        pais.setNome(nomePais);
        System.out.println("Informe a sigla do País: ");
        String siglaPais = scan.nextLine();
        pais.setSigla(siglaPais);
        controllerPais.cadastrar(pais);
    }

     public void listar(UUID id){
         Pais pais = controllerPais.ler(id);
         System.out.println("Pais nome: " + pais.getNome() + "Sigla do pais: " + pais.getSigla());

     }
    public void listar(){
        List<Pais> paises = controllerPais.listar();

        for (int index=0; index < paises.size(); index++){
            System.out.print(index+1 + " - " );
            exibirPais(paises.get(index));
        }


    }
    public void exibirPais(Pais pais){
        System.out.println("País: " + pais.getNome() + " Sigla: " + pais.getSigla());
    }
    public void atualizar (){
        listar();
        System.out.println("Informe o numero do país que deseja atualizar");
        Integer numeroPais = scan.nextInt();
        scan.nextLine();
        Pais pais = controllerPais.listar().get(numeroPais-1);
        atualizar(pais);

    }
    public void atualizar (Pais pais){
        exibirPais(pais);

        System.out.println("Informe o nome do país");
        String nomePais = scan.nextLine();
        pais.setNome(nomePais);

        System.out.println("Informe a sigla?" );
        String siglaPais = scan.nextLine();
        pais.setSigla(siglaPais);

        controllerPais.update(pais.getId(),pais);
    }
    public void apagar(){
        listar();
        System.out.println("Informe o numero do pais que deseja apagar");
        Integer numero = scan.nextInt();
        Pais pais = controllerPais.listar().get(numero-1);
        apagar(pais.getId());

    }
    public void apagar (UUID id) {
        Pais pais = controllerPais.delete(id);
        System.out.println("Pais apagada foi ");
        exibirPais(pais);

    }
}
