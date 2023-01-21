package br.com.ada.cru.cidade;

import br.com.ada.cru.Controler.CidadeArmazenamentoTipo;
import br.com.ada.cru.Controler.CidadeControllerFactory;
import br.com.ada.cru.Controler.impl.*;
import br.com.ada.cru.View.CidadeView;
import br.com.ada.cru.View.EstadoView;
import br.com.ada.cru.View.PaisView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main  {
    private static final String ARQUIVO_PROPRIEDADES = "crud.properties";
    private static final String CONTROLLER_TIPO = "cidade.controller.tipo";

    private static final String ARQUIVO_PROPRIEDADES_ESTADO = "crud.properties.estado";
    private static final String CONTROLLER_TIPO_ESTADO = "estado.controller.tipo";

    private static final String ARQUIVO_PROPRIEDADES_PAIS = "crud.properties.pais";

    private static final String CONTROLLER_TIPO_PAIS = "pais.controller.tipo";
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(ARQUIVO_PROPRIEDADES_ESTADO));
        String tipoArmazenamentoEstado = properties.getProperty(CONTROLLER_TIPO_ESTADO);
        EstadoArmazenamentoTipo tipoEstado = EstadoArmazenamentoTipo.valueOf(
                tipoArmazenamentoEstado);

        properties.load(new FileInputStream(ARQUIVO_PROPRIEDADES));
        String tipoArmazenamento = properties.getProperty(CONTROLLER_TIPO);
        CidadeArmazenamentoTipo tipo = CidadeArmazenamentoTipo.valueOf(
                tipoArmazenamento);


        properties.load(new FileInputStream(ARQUIVO_PROPRIEDADES_PAIS));
        String tipoArmazenamentoPais = properties.getProperty(CONTROLLER_TIPO_PAIS);
        PaisArmazenamentoTipo tipoPais = PaisArmazenamentoTipo.valueOf(
                tipoArmazenamentoPais);


        CidadeControllerFactory factory = new CidadeControllerFactory();
        EstadoControllerFactory factoryEstado = new EstadoControllerFactory();
        PaisControllerFactory factoryPais = new PaisControllerFactory();

        PaisView paisView = new PaisView(factoryPais.criar(tipoPais), new Scanner(System.in) );
        EstadoView estadoView = new EstadoView(factoryEstado.criar(tipoEstado), new Scanner(System.in));
        CidadeView cidadeView = new CidadeView(factory.criar(tipo), new Scanner(System.in));

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
