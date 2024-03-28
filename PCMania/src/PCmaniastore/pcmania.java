package PCmaniastore;

import java.util.Scanner;

public class pcmania {

    // Membros da classe
    String nome;
    int tipo;
    long cpf;
    float calculaTotalCompra;
    int capacidade;
    String marca;
    float preco;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cliente
        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();
        System.out.println("Digite o CPF do cliente:");
        long cpfCliente = scanner.nextLong();
        Cliente cliente = new Cliente(nomeCliente, cpfCliente);

        float totalCompra = 0.0f;
        

        // PCs comprados list
        StringBuilder PCsComprados = new StringBuilder();

        // Computadores
        pcmania pc1 = new pcmania();
        pc1.marca = "Positivo";
        pc1.preco = 3300.00f;

        HardwareBasico hard1 = new HardwareBasico("Pentium Core i3", "8Gb", "500Gb", 2200, 8, 500);
        SistemaOperacional so1 = new SistemaOperacional("Linux Ubuntu", 32);
        MemoriaUSB memusb1 = new MemoriaUSB("Pen-drive", 16);

        pcmania pc2 = new pcmania();
        pc2.marca = "Acer";
        pc2.preco = 8800.00f;

        HardwareBasico hard2 = new HardwareBasico("Pentium Core i5", "16Gb", "1Tb", 3370, 16, 1000);
        SistemaOperacional so2 = new SistemaOperacional("Windows 8", 64);
        MemoriaUSB memusb2 = new MemoriaUSB("Pen-drive", 32);

        pcmania pc3 = new pcmania();
        pc3.marca = "Vaio";
        pc3.preco = 4800.00f;

        HardwareBasico hard3 = new HardwareBasico("Pentium Core i7", "32Gb", "2Tb", 4500, 32, 2000);
        SistemaOperacional so3 = new SistemaOperacional("Windows 10", 64);
        MemoriaUSB memusb3 = new MemoriaUSB("HD Externo", 1);

        // tabela de configurações dos pcs não utilizado o método mostraPCConfigs()
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|	       Promoção 1      		|	       Promoção 2   	  	|	       Promoção 3 		|");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("| Marca: %-30s | Marca: %-30s | Marca: %-30s |", pc1.marca, pc2.marca, pc3.marca));
        System.out.println(String.format("| Preço: R$%-28s | Preço: R$%-28s | Preço: R$%-28s |", pc1.preco, pc2.preco, pc3.preco));
        System.out.println(String.format("| Processador:%-7s (%d MHz)|Processador: %-7s (%d MHz)|Processador: %-7s (%d MHz)|", hard1.processador, hard1.capacidadeProcessador, hard2.processador, hard2.capacidadeProcessador, hard3.processador, hard3.capacidadeProcessador));
        System.out.println(String.format("| RAM: %-32s | RAM: %-32s | RAM: %-32s |", hard1.memoriaRam, hard2.memoriaRam, hard3.memoriaRam));
        System.out.println(String.format("| HD: %-33s | HD: %-33s | HD: %-33s |", hard1.hd, hard2.hd, hard3.hd));
        System.out.println(String.format("| SO: %-23s (%s bits) | SO: %-23s (%s bits) | SO: %-23s (%s bits) |", so1.nome, so1.tipo, so2.nome, so2.tipo, so3.nome, so3.tipo));
        System.out.println(String.format("| Memória USB: %-16s (%s Gb) | Memória USB: %-16s (%s Gb) | Memória USB: %-17s (%s Tb) |", memusb1.nome, memusb1.capacidade, memusb2.nome, memusb2.capacidade, memusb3.nome, memusb3.capacidade));
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

        // compre mas pela configuração está tudo caro
        while (true) {
            System.out.println("Digite o número do PC desejado (1, 2 ou 3) ou 0 para sair:");
            int escolha = scanner.nextInt();
            if (escolha == 0) {
                break;
            }

            switch (escolha) {
            case 1:
                totalCompra += pc1.preco;
                PCsComprados.append("Promoção 1 (Positivo): ").append(pc1.marca).append("\n");
                break;
            case 2:
                totalCompra += pc2.preco;
                PCsComprados.append("Promoção 2 (Acer): ").append(pc2.marca).append("\n");
                break;
            case 3:
                totalCompra += pc3.preco;
                PCsComprados.append("Promoção 3 (Vaio): ").append(pc3.marca).append("\n");
                break;
            default:
                System.out.println("Escolha inválida!");
            }
        }
        

     // informações do cliente, PCs comprados e total da compra
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("CPF: " + cliente.cpf);
        System.out.println("PCs comprados:");
        System.out.println(PCsComprados.toString());
        System.out.println("Total da compra: R$" + totalCompra);

        scanner.close();
    }
}

class Cliente {
    // Membros da classe
    String nome;
    long cpf;

    public Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

}

class HardwareBasico {
    // Membros da classe
    String processador;
    String memoriaRam;
    String hd;
    int capacidadeProcessador;
    int capacidadeMemoriaRam;
    int capacidadeHd;

    public HardwareBasico(String processador, String memoriaRam, String hd, int capacidadeProcessador, int capacidadeMemoriaRam, int capacidadeHd) {
        this.processador = processador;
        this.memoriaRam = memoriaRam;
        this.hd = hd;
        this.capacidadeProcessador = capacidadeProcessador;
        this.capacidadeMemoriaRam = capacidadeMemoriaRam;
        this.capacidadeHd = capacidadeHd;
    }
}

class SistemaOperacional {
    // Membros da classe
    String nome;
    int tipo;

    public SistemaOperacional(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }
}

class MemoriaUSB {
    // Membros da classe
    String nome;
    int capacidade;

    public MemoriaUSB(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }
}
