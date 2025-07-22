import java.util.Scanner;

public class Principal {
  public static void main(String[] args) {
    String menu = """
        ********************************
        
        Seja bem-vindo/a ao Conversor de Moedas!
        
        1) Dólar ==> Peso chileno
        2) Dólar ==> Peso argentino
        3) Dólar ==> Boliviano
        4) Dólar ==> Real brasileiro
        5) Dólar ==> Peso Colombiano
        6) Real brasileiro ==> Dólar
        7) Sair
        
        ********************************
        """;

    Scanner leitura = new Scanner(System.in);
    int opcaoMenu = 0;

    while (opcaoMenu != 7) {
      System.out.println("\n" + menu);
      System.out.println("Digite uma opção válida:");
      opcaoMenu = leitura.nextInt();
      selecionarOpcao(opcaoMenu, leitura);

      if (opcaoMenu < 7 && !continuarConversao()) {
        opcaoMenu = 7;
        System.out.println("Obrigada por usar nosso Conversor de moedas, aplicação encerrada!");
      }
    }
  }

  public static boolean continuarConversao() {
    Scanner leituraResposta = new Scanner(System.in);
    System.out.println("\nDeseja continuar usando o Conversor de moedas? Digite 'sim' ou 'sair'");
    String resposta = leituraResposta.nextLine();

    if(resposta.equalsIgnoreCase("sair")) {
      return false;
    }

    return true;
  }

  public static void executarConversao(String moedaOrigem, String moedaDestino, Scanner leitura) {
    double valor = leitura.nextDouble();
    String valorConvertido = ConversaoDeValor.converterMoeda(moedaOrigem, moedaDestino, valor);
    System.out.println(valorConvertido);
  }

  public static void selecionarOpcao(int opcaoMenu, Scanner leitura) {

    switch(opcaoMenu) {
      case 1:
        System.out.println("Digite o valor em Dólar: ");
        executarConversao("USD", "CLP", leitura);
        break;

      case 2:
        System.out.println("Digite o valor em Dólar: ");
        executarConversao("USD", "ARS", leitura);
        break;

      case 3:
        System.out.println("Digite o valor em Dólar: ");
        executarConversao("USD", "BOB", leitura);
        break;

      case 4:
        System.out.println("Digite o valor em Dólar: ");
        executarConversao("USD", "BRL", leitura);
        break;

      case 5:
        System.out.println("Digite o valor em Dólar: ");
        executarConversao("USD", "COP", leitura);
        break;

      case 6:
        System.out.println("Digite o valor em Real brasileiro: ");
        executarConversao("BRL", "USD", leitura);
        break;

      case 7:
        System.out.println("Obrigada por usar nosso Conversor de moedas, aplicação encerrada!");
        break;

      default:
        System.out.println("Opção inválida, digite uma opção válida");
        break;
    }
  }
}
