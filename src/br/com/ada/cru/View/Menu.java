package br.com.ada.cru.View;

import br.com.ada.cru.Controler.CidadeArmazenamentoTipo;
import br.com.ada.cru.Controler.CidadeControllerFactory;
import br.com.ada.cru.Controler.impl.EstadoArmazenamentoTipo;
import br.com.ada.cru.Controler.impl.EstadoControllerFactory;
import br.com.ada.cru.Controler.impl.PaisArmazenamentoTipo;
import br.com.ada.cru.Controler.impl.PaisControllerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Menu {
    private static final String ARQUIVO_PROPRIEDADES = "crud.properties";
    private static final String CONTROLLER_TIPO = "cidade.controller.tipo";

    private static final String ARQUIVO_PROPRIEDADES_ESTADO = "crud.properties.estado";
    private static final String CONTROLLER_TIPO_ESTADO = "estado.controller.tipo";

    private static final String ARQUIVO_PROPRIEDADES_PAIS = "crud.properties.pais";

    private static final String CONTROLLER_TIPO_PAIS = "pais.controller.tipo";

    public void apresentacao() throws IOException {

        Scanner scan = new Scanner(System.in);
        int opcao;
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
