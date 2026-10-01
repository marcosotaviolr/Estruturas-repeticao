import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Algoritmo01();
        Algoritmo02();
        Algoritmo03();
        Algoritmo04();
        Algoritmo05();
        Algoritmo06();
        Algoritmo07();
        Algoritmo08();
        Algoritmo09();
        Algoritmo10();
        Algoritmo11();
        Algoritmo12();
    }

    private static void Algoritmo01() {
        // Operação aritmética com 2 números inteiros
        Scanner scanner = new Scanner(System.in);
        int programaAtivo = 1;
        int resultadoOperacao;

        while (programaAtivo != 2) {
            System.out.println("Digite o valor do primeiro número: ");
            int numero1 = scanner.nextInt();
            System.out.println("Digite o valor do segundo número:");
            int numero2 = scanner.nextInt();

            System.out.println("Qual operação deseja realizar?");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão (quociente inteiro)");
            int operacao = scanner.nextInt();

            switch (operacao) {
                case 1:
                    resultadoOperacao = numero1 + numero2;
                    System.out.println("O resultado da soma é " + resultadoOperacao);
                    break;
                case 2:
                    resultadoOperacao = numero1 - numero2;
                    System.out.println("O resultado da subtração é " + resultadoOperacao);
                    break;
                case 3:
                    resultadoOperacao = numero1 * numero2;
                    System.out.println("O resultado da multiplicação é " + resultadoOperacao);
                    break;
                case 4:
                    if (numero2 == 0) {
                        System.out.println("Não é possível dividir por 0");
                    } else {
                        resultadoOperacao = numero1 / numero2;
                        System.out.println("O resultado da divisão é " + resultadoOperacao);
                    }
                    break;
                default:
                    System.out.println("Nenhuma operação selecionada");
                    break;
            }

            System.out.println("Deseja continuar? (1: sim / 2: não)");
            programaAtivo = scanner.nextInt();
        }
        scanner.close();
    }

    private static void Algoritmo02() {
        // Soma dos números ímpares múltiplos de 3 até 500
        int somaImpares = 0;
        for (int i = 1; i <= 500; i += 2) {
            if (i % 3 == 0) {
                somaImpares += i;
            }
        }
        System.out.println("A soma dos números ímpares múltiplos de 3 é: " + somaImpares);
    }

    private static void Algoritmo03() {
        // Verifica o empregado mais antigo e mais recente em uma firma
        Scanner scanner = new Scanner(System.in);
        final int NUMERO_MAXIMO_INFORMACOES = 300;
        int maisRecenteMeses;
        int maisAntigoMeses;
        int empregadoMaisRecente;
        int empregadoMaisAntigo;

        System.out.println("Informe o número do empregado (Informe 0 nos dois para terminar): ");
        int numeroEmpregado = scanner.nextInt();
        System.out.println("Informe a quantidade de meses na firma (Informe 0 nos dois para terminar): ");
        int quantidadeMeses = scanner.nextInt();
        if (numeroEmpregado == 0 && quantidadeMeses == 0) {
            scanner.close();
            return;
        }

        maisAntigoMeses = quantidadeMeses;
        maisRecenteMeses = quantidadeMeses;
        empregadoMaisRecente = numeroEmpregado;
        empregadoMaisAntigo = numeroEmpregado;

        for (int i = 1; i < NUMERO_MAXIMO_INFORMACOES; i++) {
            // Começa em 1 pois um registro já foi lido
            System.out.println("Informe o número do empregado (Informe 0 nos dois para terminar): ");
            numeroEmpregado = scanner.nextInt();
            System.out.println("Informe a quantidade de meses na firma (Informe 0 nos dois para terminar): ");
            quantidadeMeses = scanner.nextInt();

            if (numeroEmpregado == 0 && quantidadeMeses == 0) {
                break;
            }

            if (maisAntigoMeses < quantidadeMeses) {
                maisAntigoMeses = quantidadeMeses;
                empregadoMaisAntigo = numeroEmpregado;
            }
            if (maisRecenteMeses > quantidadeMeses) {
                maisRecenteMeses = quantidadeMeses;
                empregadoMaisRecente = numeroEmpregado;
            }
        }

        System.out.println("O empregado mais recente é o " + empregadoMaisRecente + " com " + maisRecenteMeses + " meses.");
        System.out.println("O empregado mais antigo é o " + empregadoMaisAntigo + " com " + maisAntigoMeses + " meses.");
        scanner.close();
    }

    private static void Algoritmo04() {
        // Mostra a menor altura do grupo, a média de altura das mulheres, o número de homens e o sexo da pessoa mais alta
        Scanner scanner = new Scanner(System.in);
        final int NUMERO_PESSOAS = 15;

        double menorAltura = 999.0;
        double maiorAltura = 0;
        double somaAlturaMulheres = 0;
        int numeroMulheres = 0;
        int numeroHomens = 0;
        String sexoMaisAlta = "";

        for (int i = 1; i <= NUMERO_PESSOAS; i++) {
            System.out.println("Qual o sexo da " + i + " pessoa (M ou F)");
            String sexo = scanner.next();
            System.out.println("Altura da " + i + " pessoa (em metros):");
            double altura = scanner.nextDouble();

            if (altura < menorAltura) {
                menorAltura = altura;
            }
            if (altura > maiorAltura) {
                maiorAltura = altura;
                sexoMaisAlta = sexo;
            }

            if (sexo.equals("F")) {
                numeroMulheres++;
                somaAlturaMulheres += altura;
            } else if (sexo.equals("M")) {
                numeroHomens++;
            }
        }
        System.out.println("Menor altura do grupo: " + menorAltura + " metros");
        if (numeroMulheres > 0) {
            double mediaAlturaMulheres = somaAlturaMulheres / numeroMulheres;
            System.out.println("A média de altura das mulheres: " + mediaAlturaMulheres + " metros");
        } else {
            System.out.println("Nenhuma mulher informada");
        }
        System.out.println("Número de homens: " + numeroHomens);
        System.out.println("Sexo da pessoa mais alta: " + sexoMaisAlta);
        scanner.close();
    }

    private static void Algoritmo05() {
        // Calcula a média dos salários, a média de filhos, o maior salário e o percentual de salários até R$250
        Scanner scanner = new Scanner(System.in);
        final double LIMITE_SALARIO = 250.0;

        double somaSalario = 0;
        int somaFilhos = 0;
        int contadorRespostas = 0;
        int salarioAte250 = 0;
        double maiorSalario = 0;

        while (true) {
            System.out.println("Informe o salário (Salário negativo termina o programa): ");
            double salario = scanner.nextDouble();

            if (salario < 0) {
                break;
            }

            System.out.println("Informe o número de filhos: ");
            int numeroFilhos = scanner.nextInt();

            somaSalario += salario;
            somaFilhos += numeroFilhos;
            contadorRespostas++;

            if (salario > maiorSalario) {
                maiorSalario = salario;
            }

            if (salario <= LIMITE_SALARIO) {
                salarioAte250++;
            }
        }

        if (contadorRespostas > 0) {
            double mediaSalario = somaSalario / contadorRespostas;
            double mediaFilhos = (double) somaFilhos / contadorRespostas;
            double percentualAte250 = (salarioAte250 * 100.0) / contadorRespostas;

            System.out.println("Média de salário da população: R$ " + mediaSalario);
            System.out.println("Média de filhos: " + mediaFilhos);
            System.out.println("Maior salário: R$ " + maiorSalario);
            System.out.println("Percentual de pessoas com salário até R$250,00: " + percentualAte250 + "%");
        } else {
            System.out.println("Nenhum dado informado");
        }
        scanner.close();
    }

    private static void Algoritmo06() {
        // Calcula a média, a quantidade e o percentual de valores positivos e negativos
        Scanner scanner = new Scanner(System.in);
        int contadorValores = 0;
        int somaValores = 0;
        int valoresPositivos = 0;
        int valoresNegativos = 0;
        int valor;

        while (true) {
            System.out.println("Informe um valor: ");
            valor = scanner.nextInt();

            contadorValores++;
            somaValores += valor;

            if (valor > 0) {
                valoresPositivos++;
            } else if (valor < 0) {
                valoresNegativos++;
            }

            System.out.println("Deseja continuar? (1 - sim / 2 - não)");
            int desejaContinuar = scanner.nextInt();

            if (desejaContinuar == 2) {
                break;
            }
        }
        double mediaValores = (double) somaValores / contadorValores;
        double percentualNegativos = (double) valoresNegativos * 100 / contadorValores;
        double percentualPositivos = (double) valoresPositivos * 100 / contadorValores;

        System.out.println("Média dos valores: " + mediaValores);
        System.out.println("Quantidade positivos: " + valoresPositivos);
        System.out.println("Quantidade negativos: " + valoresNegativos);
        System.out.println("Percentual negativos: " + percentualNegativos + "%");
        System.out.println("Percentual positivos: " + percentualPositivos + "%");
        scanner.close();
    }

    private static void Algoritmo07() {
        // Calcula a média de 75 valores e mostra a quantidade de valores lidos
        Scanner scanner = new Scanner(System.in);
        final int QUANTIDADE_VALORES = 75;

        int somaValores = 0;

        for (int i = 1; i <= QUANTIDADE_VALORES; i++) {
            System.out.println("Digite o " + i + "º valor:");
            int valor = scanner.nextInt();

            somaValores += valor;
        }
        double mediaValores = (double) somaValores / QUANTIDADE_VALORES;

        System.out.println("Foram lidos " + QUANTIDADE_VALORES + " valores");
        System.out.println("A média dos valores é: " + mediaValores);
        scanner.close();
    }

    private static void Algoritmo08() {
        // Mostra a maior e menor altura, os nomes e as médias de altura dos homens, mulheres e da turma
        Scanner scanner = new Scanner(System.in);
        final int QUANTIDADE_AMIGOS = 15;

        double maiorAltura = 0;
        double menorAltura = 999;
        double somaAlturaMulheres = 0;
        double somaAlturaHomens = 0;
        double somaAlturaTotal = 0;
        String nomeMaior = "";
        String nomeMenor = "";
        int numeroMulheres = 0;
        int numeroHomens = 0;

        for (int i = 1; i <= QUANTIDADE_AMIGOS; i++) {
            System.out.println("Digite o nome do " + i + "º amigo:");
            String nome = scanner.next();
            System.out.println("Digite a altura do " + i + "º amigo (em metros):");
            double altura = scanner.nextDouble();
            System.out.println("Digite o sexo (1 - Masculino / 2 - Feminino):");
            int sexo = scanner.nextInt();

            somaAlturaTotal += altura;

            if (altura > maiorAltura) {
                maiorAltura = altura;
                nomeMaior = nome;
            }

            if (altura < menorAltura) {
                menorAltura = altura;
                nomeMenor = nome;
            }

            if (sexo == 1) {
                numeroHomens++;
                somaAlturaHomens += altura;
            } else if (sexo == 2) {
                numeroMulheres++;
                somaAlturaMulheres += altura;
            }
        }
        double mediaAlturaTotal = somaAlturaTotal / QUANTIDADE_AMIGOS;

        System.out.println("Maior altura: " + maiorAltura + " metros");
        System.out.println("Nome da pessoa mais alta: " + nomeMaior);
        System.out.println("Menor altura: " + menorAltura + " metros");
        System.out.println("Nome da pessoa mais baixa: " + nomeMenor);

        if (numeroMulheres > 0) {
            double mediaAlturaMulheres = somaAlturaMulheres / numeroMulheres;
            System.out.println("Média da altura das mulheres: " + mediaAlturaMulheres + " metros");
        }
        if (numeroHomens > 0) {
            double mediaAlturaHomens = somaAlturaHomens / numeroHomens;
            System.out.println("Média da altura dos homens: " + mediaAlturaHomens + " metros");
        }
        System.out.println("Média da altura da turma: " + mediaAlturaTotal + " metros");
        scanner.close();
    }

    private static void Algoritmo09() {
        // Lê as notas dos alunos e mostra a maior e a menor nota
        Scanner scanner = new Scanner(System.in);
        final double NOTA_MAXIMA = 15;

        System.out.println("Digite a quantidade de alunos:");
        int quantidadeAlunos = scanner.nextInt();

        double maiorNota = 0;
        double menorNota = NOTA_MAXIMA;

        for (int i = 1; i <= quantidadeAlunos; i++) {
            System.out.println("Digite a nota do " + i + "º aluno:");
            double nota = scanner.nextDouble();

            if (nota > maiorNota) {
                maiorNota = nota;
            }

            if (nota < menorNota) {
                menorNota = nota;
            }
        }

        if (quantidadeAlunos > 0) {
            System.out.println("Maior nota: " + maiorNota);
            System.out.println("Menor nota: " + menorNota);
        } else {
            System.out.println("Nenhum aluno informado");
        }
        scanner.close();
    }

    private static void Algoritmo10() {
        // Mostra uma tabela de conversão de polegadas para centímetros de 1 até 20
        final double CENTIMETROS_POR_POLEGADA = 2.54;

        System.out.println("Conversão de polegadas para centímetros:");

        for (int polegada = 1; polegada <= 20; polegada++) {
            double centimetros = polegada * CENTIMETROS_POR_POLEGADA;

            System.out.println(polegada + " polegada(s) = " + centimetros + " centímetros");
        }
    }

    private static void Algoritmo11() {
        // Calcula a soma dos números pares dentro de um intervalo
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o limite inferior:");
        int limiteInferior = scanner.nextInt();
        System.out.println("Digite o limite superior:");
        int limiteSuperior = scanner.nextInt();

        int soma = 0;

        for (int i = limiteInferior; i <= limiteSuperior; i++) {
            if (i % 2 == 0) {
                soma += i;
            }
        }
        System.out.println("A soma dos números pares é: " + soma);
        scanner.close();
    }

    private static void Algoritmo12() {
        // Lê as notas de 100 alunos e mostra as duas maiores notas e suas respectivas matrículas
        Scanner scanner = new Scanner(System.in);
        final int QUANTIDADE_ALUNOS = 100;

        double maiorNota = 0;
        double segundaMaiorNota = 0;
        int matriculaMaiorNota = 0;
        int matriculaSegundaMaiorNota = 0;

        for (int i = 1; i <= QUANTIDADE_ALUNOS; i++) {
            System.out.println("Digite a matrícula do " + i + "º aluno:");
            int matricula = scanner.nextInt();

            System.out.println("Digite a nota do " + i + "º aluno:");
            double nota = scanner.nextDouble();

            if (nota > maiorNota) {
                segundaMaiorNota = maiorNota;
                matriculaSegundaMaiorNota = matriculaMaiorNota;
                maiorNota = nota;
                matriculaMaiorNota = matricula;
            } else if (nota > segundaMaiorNota) {
                segundaMaiorNota = nota;
                matriculaSegundaMaiorNota = matricula;
            }
        }
        System.out.println("Maior nota: " + maiorNota);
        System.out.println("Matrícula do aluno com a maior nota: " + matriculaMaiorNota);
        System.out.println("Segunda maior nota: " + segundaMaiorNota);
        System.out.println("Matrícula do aluno com a segunda maior nota: " + matriculaSegundaMaiorNota);
        scanner.close();
    }
}