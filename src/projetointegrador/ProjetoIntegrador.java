//E:\DOWNLOAD\Arquivos Texto\Texto criptografar.txt
//E:\DOWNLOAD\Arquivos Texto\Texto descriptografar.txt
//==============================================================================
//PROJETO INTEGRADOR: Criar um programa capaz de converter e criptografar.
//Desenvolvedor: Ramesses Carneiro de Souza
//Data: 09/11/2017
//==============================================================================
package projetointegrador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;

public class ProjetoIntegrador 
{   
//==============================================================================
//==================================================================PUBLIC: MAIN
//==============================================================================
    public static void main(String[] args) 
    {
        
        int OpcaoMenu = 100, OpcaoCriptografia = 100, OpcaoConversao = 100, Cifra = 100;
        long InputBin = 0, InputDec = 0, OutDec = 0;
        String OutBin, InputHex, OutHex;
        String EntradaTexto, SaidaTexto;
        String NomeArquivo, TextoEntrada, TextoSaida, Linha;
        
        System.out.println("Sistema desenvolvido para apresentação do Projeto Integrador");
        System.out.println("=========================================================================");
        System.out.println(" ______  __       ______  ______  __    __  ______  ______  ______ (v1.0)");
        System.out.println("/\\  == \\/\\ \\     /\\  == \\/\\  __ \\/\\ \"-./  \\/\\  ___\\/\\  ___\\/\\  ___\\");
        System.out.println("\\ \\  __/\\ \\ \\    \\ \\  __<\\ \\  __ \\ \\ \\-./\\ \\ \\___  \\ \\  __\\\\ \\___  \\  ");
        System.out.println(" \\ \\_\\   \\ \\_\\    \\ \\_\\ \\_\\ \\_\\ \\_\\ \\_\\ \\ \\_\\/\\_____\\ \\_____\\/\\_____\\ ");
        System.out.println("  \\/_/    \\/_/     \\/_/ /_/\\/_/\\/_/\\/_/  \\/_/\\/_____/\\/_____/\\/_____/ ");
        System.out.println("_________________________________________________________________________");
        System.out.println("Curso: Análise e desenvolvimento de sistemas");
        System.out.println("Instituição: SENAC Santo Amaro");
        System.out.println("Desenvolvedor: Ramesses Carneiro de Souza");
        System.out.println("Data: 27/11/2017");
        System.out.println("=========================================================================");
        System.out.println("\n");
        do
        {   
            System.out.println("===============================");
            System.out.println("MENU");
            System.out.println("1 - Criptografia");
            System.out.println("2 - Conversão");
            System.out.println("3 - Sair");
            System.out.print("Opção desejada:");
            
            //Faz tratativa caso entre uma string no scanner
            try 
            { 
                OpcaoMenu = new Scanner(System.in).nextInt();
            }
            catch (Exception e)
            {
                System.out.print("\nValor invádlido! ");
            }
            switch (OpcaoMenu)
            {
                //1 - CRIPTOGRAFIA
                case 1:
                    do
                    {
                        System.out.println("===============================");
                        System.out.println("CRIPTOGRAFIA");
                        System.out.println("Oque você deseja?");
                        System.out.println("4 - Criptografar texto");
                        System.out.println("5 - Criptografar texto de arquivo");
                        System.out.println("6 - Descriptografar texto");
                        System.out.println("7 - Descriptografar texto de arquivo");
                        System.out.println("0 - Menu");
                        System.out.println("3 - Sair");
                        System.out.print("Opção desejada:");
                        
                        //Faz tratativa caso entre uma string no scanner
                        try
                        {    
                            OpcaoCriptografia = new Scanner(System.in).nextInt();
                        }
                        catch (Exception e)
                        {
                            System.out.print("\nValor invádlido! ");
                        }
                        
                        switch (OpcaoCriptografia)
                        {
                            //4 - Criptografar texto
                            case 4:
                                //Entrada de dados
                                System.out.print("\nDigite seu texto:");
                                EntradaTexto = new Scanner(System.in).nextLine();
                                System.out.print("Digite o deslocamento:");
                                //Faz tratativa caso entre uma string no scanner
                                try
                                {    
                                    Cifra = new Scanner(System.in).nextInt();
                                }
                                catch (Exception e)
                                {
                                    System.out.println("\nValor invádlido!");
                                    break;
                                }
                                //Se a cifra for maior que o alfabeto retorna erro
                                if (Cifra > 25)
                                {
                                   System.out.println("\nDeslocamento invádlido! Digite um valor entre 0 e 25.");
                                   break;
                                }
                                else
                                {    
                                    //Processamento
                                    SaidaTexto = CripCesarTexto(EntradaTexto, Cifra);
                                    //Saída
                                    System.out.println("\nTexto criptografado = "+SaidaTexto);
                                    break;
                                }    
                            //5 - Criptografar arquivo
                            case 5:
                                //Entrada de dados
                                System.out.print("\nInforme diretório e nome do arquivo .txt:");
                                NomeArquivo = new Scanner (System.in).nextLine();
                                System.out.print("Digite o deslocamento:");
                                //Faz tratativa caso entre uma string no scanner
                                try
                                {    
                                    Cifra = new Scanner(System.in).nextInt();
                                }
                                catch (Exception e)
                                {
                                    System.out.println("\nValor invádlido!");
                                    break;
                                }
                                //Se a cifra for maior que o alfabeto retorna erro
                                if (Cifra > 25)
                                {
                                   System.out.println("\nDeslocamento invádlido! Digite um valor entre 0 e 25.");
                                   break;
                                }
                                else
                                {
                                    //Trata um erro ocasional na abertura do arquivo
                                    try
                                    {   
                                        //Abre arquivo
                                        FileReader Arquivo = new FileReader(NomeArquivo);
                                        //Lê arquivo
                                        BufferedReader lerArq = new BufferedReader(Arquivo);
                                        
                                        //Tratativa de layout
                                        System.out.println("\n");
                                        //Linha do txt
                                        int i = 1;
                                        
                                        // a variável "linha" recebe o valor "null" quando o processo
                                        // de repetição atingir o final do arquivo .txt
                                        do
                                        {
                                            //ReadLine le a linha inteira do arquivo
                                            Linha = lerArq.readLine();
                                            if (Linha !=null)
                                            {    
                                                //Printa com formatação %s = String (Ja convertendo com a cifra de Cesar)
                                                System.out.printf("Linha "+i+": %s\n", CripCesarTexto(Linha, Cifra));
                                                i++;
                                            }
                                            else{}
                                        }
                                        while (Linha != null);
                                    
                                        //Fecha arquivo
                                        Arquivo.close();
                                    } 
                                    catch (IOException e) 
                                    {
                                        //System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
                                        System.out.println("\nErro na abertura do arquivo!\nVerifique se o diretório está correto.");
                                    }
                                    break;
                                }
                            //6 - Descriptografar texto
                            case 6:
                                //Entrada de dados
                                System.out.print("\nDigite seu texto:");
                                EntradaTexto = new Scanner(System.in).nextLine();
                                System.out.print("Digite o deslocamento:");
                                
                                //Faz tratativa caso entre uma string no scanner
                                try
                                {    
                                    Cifra = new Scanner(System.in).nextInt();
                                }
                                catch (Exception e)
                                {
                                    System.out.println("\nValor invádlido!");
                                    break;
                                }
                                //Se a cifra for maior que o alfabeto retorna erro
                                if (Cifra > 25)
                                {
                                   System.out.println("\nDeslocamento invádlido! Digite um valor entre 0 e 25.");
                                   break;
                                }
                                else
                                {  
                                    //Processamento
                                    SaidaTexto = DescripCesar(EntradaTexto, Cifra);
                                    //Saída
                                    System.out.println("\nTexto descriptografado = "+SaidaTexto);
                                    break;
                                }    
                            //7 - Descriptografar arquivo
                            case 7:
                                //Entrada de dados
                                System.out.print("\nInforme diretório e nome do arquivo .txt:");
                                NomeArquivo = new Scanner (System.in).nextLine();
                                System.out.print("Digite o deslocamento:");
                                //Faz tratativa caso entre uma string no scanner
                                try
                                {    
                                    Cifra = new Scanner(System.in).nextInt();
                                }
                                catch (Exception e)
                                {
                                    System.out.println("\nValor invádlido!");
                                    break;
                                }
                                //Se a cifra for maior que o alfabeto retorna erro
                                if (Cifra > 25)
                                {
                                   System.out.println("\nDeslocamento invádlido! Digite um valor entre 0 e 25.");
                                   break;
                                }
                                else
                                {
                                    //Trata um erro ocasional na abertura do arquivo
                                    try
                                    {   
                                        //Abre arquivo
                                        FileReader Arquivo = new FileReader(NomeArquivo);
                                        //Lê arquivo
                                        BufferedReader lerArq = new BufferedReader(Arquivo);
                                        
                                        //Tratativa de layout
                                        System.out.println("\n");
                                        //Linha do txt
                                        int i = 1;
                                        
                                        //E:\DOWNLOAD\Arquivo Texto\Texto.txt
                                        // a variável "linha" recebe o valor "null" quando o processo
                                        // de repetição atingir o final do arquivo .txt
                                        do
                                        {
                                            //ReadLine le a linha inteira do arquivo
                                            Linha = lerArq.readLine();
                                            if (Linha !=null)
                                            {    
                                                //Printa com formatação %s = String (Ja convertendo com a cifra de Cesar)
                                                System.out.printf("Linha "+i+": %s\n", DescripCesar(Linha, Cifra));
                                                i++;
                                            }
                                            else{}
                                        }
                                        while (Linha != null);
                                    
                                        //Fecha arquivo
                                        Arquivo.close();
                                    } 
                                    catch (IOException e) 
                                    {
                                        //System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
                                        System.out.println("\nErro na abertura do arquivo!\nVerifique se o diretório está correto.");
                                    }
                                    break;
                                }
                            //0 - Menu
                            case 0:
                                OpcaoMenu = 0;
                                break;
                            //3 - Sair
                            case 3:
                                OpcaoMenu = 3;
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                                break;
                        }
                    }while (OpcaoCriptografia != 0 && OpcaoCriptografia != 3);    
                    break;
                
                //2 - CONVERSAO
                case 2:
                    do
                    {   
                        System.out.println("===============================");
                        System.out.println("CONVERSÃO");
                        System.out.println("Em qual base está seu número?");
                        System.out.println("8  -  Binária(2)");
                        System.out.println("9  -  Decimal(10) ");
                        System.out.println("10 -  Hexadecimal(16)");
                        System.out.println("0  -  Menu");
                        System.out.println("3  -  Sair");
                        System.out.print("Opção desejada:");
                        
                        //Faz tratativa caso entre string no scanner
                        try
                        {    
                        OpcaoConversao = new Scanner(System.in).nextInt();
                        }
                        catch (Exception e)
                        {
                            System.out.print("\nValor invádlido! ");
                        }
                        
                        switch (OpcaoConversao)
                        {
                            //8 - Binária (2)
                            case 8:
                                //Entrada de dados
                                System.out.print("\nDigite o número base (2):");
                                //Faz tratativa caso entre string no scanner
                                try
                                {  
                                    InputBin = new Scanner(System.in).nextLong();
                                }
                                catch (Exception e)
                                {
                                    System.out.println("\nValor invádlido!");
                                    break;
                                }
                                
                                //Processamento de dados
                                OutDec = BinToDec(InputBin);
                                OutHex = BinToHex(Long.toString(InputBin));
                                //Saída de dados
                                System.out.println("Decimal(10) = "+OutDec);
                                System.out.println("Hexadecimal(16) = "+OutHex);
                                break;
                            //9 - Decimal (10)
                            case 9:
                                //Entrada de dados
                                System.out.print("\nDigite o número base (10):");
                                //Faz tratativa caso entre string no scanner
                                try
                                { 
                                    InputDec = new Scanner(System.in).nextInt();
                                }
                                catch (Exception e)
                                {
                                    System.out.println("\nValor invádlido!");
                                    break;
                                }
                                //Processamento de dados
                                OutBin = DecToBin(InputDec);
                                OutHex = DecToHex(InputDec);
                                //Saída de dados
                                System.out.println("Binário(2) = "+OutBin);
                                System.out.println("Hexadecimal(16) = "+OutHex);
                                break;
                            //10 - Hexadecimal (16)
                            case 10:
                                //Entrada de dados
                                System.out.print("\nDigite o número base (16):");
                                InputHex = new Scanner(System.in).next();
                                //Processamento de dados
                                OutDec = HexToDec(InputHex);
                                //Se retornar erro (-1)
                                if(OutDec == -1)
                                {
                                    System.out.println("\nValor inválido!");
                                    break;
                                }
                                else
                                {    
                                    OutBin = HexToBin(InputHex);
                                    //Saída de dados
                                    System.out.println("Binário(2) = "+OutBin);
                                }    
                                System.out.println("Decimal(10) = "+OutDec);
                                break;
                            //0 - Menu
                            case 0:
                                
                                OpcaoMenu = 0;
                                break;
                            //3 - Sair
                            case 3:
                                OpcaoMenu = 3;
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                                break;
                        }        
                    }
                    while (OpcaoConversao != 0 && OpcaoConversao != 3);
                    break;
                //SAIR DO PROGRAMA
                case 3:
                break;
                
                default:
                   System.out.println("\nOpção inválida!"); 
            }
        }
        while  (OpcaoMenu != 3) ;   
        
        //SAIR DO PROGRAMA
        System.out.println("\nVocê saiu!");
    }
//==============================================================================
//============================================================FUNÇÃO 1: SUB LONG
//==============================================================================
    static long SubLong(long entrada, long inicio, long tamanho)
    {
        while (entrada > Math.pow(10, tamanho + inicio) - 1)
        {
            entrada /= 10;
        }
        return entrada % (long) Math.pow(10, tamanho);
    }
//==============================================================================
//===================================================FUNCAO 2: INVERTER UM TEXTO
//==============================================================================
    static String InverteString(String Texto)
    {
        String StrInvertida = "";
        
        for(int i = Texto.length(); i>0; i--)
        {
            StrInvertida += Texto.substring(i-1,i);
        }
        return StrInvertida;
    }
//==============================================================================
//================================================FUNCAO 3: DECIMAL PARA BINARIO
//==============================================================================
    static String DecToBin(long Decimal)
    {
        String Bin = "";
        if (Decimal != 0)
        {    
            while(Decimal > 0)
            {
                Bin += Long.toString(Decimal%2);
                Decimal = Decimal/2;
            }
            Bin = InverteString(Bin);
        }
        else
        {
            Bin = "0";
        }
        return Bin;
    }
//==============================================================================
//=========================================FUNCAO 4: DECIMAL PARA BINARIO 4 BITS
//==============================================================================
    static String DecToBin4Bits(long Decimal)
    {
        String Bin = "";
        if (Decimal != 0)
        {    
            while(Decimal > 0)
            {
                Bin += Long.toString(Decimal%2);
                Decimal = Decimal/2;
            }
        Bin = InverteString(Bin);
        switch (Bin.length())
        {
            case 1:
                Bin = "000" + Bin;
                break;
            case 2:
                Bin = "00" + Bin;
                break;
            case 3:
                Bin = "0" + Bin;
                break;
        }
        }
        else
        {
            Bin = "0000";
        }
        return Bin;
    }    
//==============================================================================
//============================================FUNCAO 5: DECIMAL PARA HEXADECIMAL
//==============================================================================
    static String DecToHex(long Decimal)
    {   
        long i = 0;
        String Hex = "", HexTemp;
        
        if (Decimal != 0)
        {    
            while(Decimal > 0)
            {
                
                HexTemp = Long.toString(Decimal%16);
                Decimal = Decimal/16;
                switch (HexTemp)
                {
                    case "10": HexTemp = "A";
                    break;
                    case "11": HexTemp = "B";
                    break;
                    case "12": HexTemp = "C";
                    break;
                    case "13": HexTemp = "D";
                    break;
                    case "14": HexTemp = "E";
                    break;
                    case "15": HexTemp = "F";
                    break;
                }
                Hex += HexTemp;
                i++;
            }
            Hex = InverteString(Hex);
        }
        else
        {
            Hex = "0";
        }    
        return Hex;
    }
//==============================================================================
//================================================FUNCAO 6: BINARIO PARA DECIMAL
//==============================================================================
    static long BinToDec(long Binario)
    {
        long Decimal = 0, DecimalTemp, x = 0;
        String BinString = Long.toString(Binario);
        long TamanhoBin = BinString.length();
                
        for(long i = TamanhoBin; i > 0; i--)
        {
            DecimalTemp = SubLong(Binario, i-1, 1);
            DecimalTemp *= (Math.pow(2, x));
            
            Decimal +=  DecimalTemp;
            x++;  
        }
        return Decimal;
    }
//==============================================================================
//============================================FUNCAO 7: BINARIO PARA HEXADECIMAL
//==============================================================================
    static String BinToHex(String Binario)
    {
        String Hexadecimal = "";
        int x = 0, TamanhoVetor, Bin4Bit;
        long Decimal;
        
        //Completa o número binário com zeros a esquerda
        switch (Binario.length()%4)
        {
            case 1:
                Binario = "000" + Binario;
                break;
            case 2:
                Binario = "00" + Binario;
                break;
            case 3:
                Binario = "0" + Binario;
                break;    
        }
        
        //Define tamanho do Array = (tamanho da string)/4 ou seja blocos de 4
        TamanhoVetor = Binario.length()/4;
        String[] HexTemp = new String[TamanhoVetor];
        
        //Processamento
        for (int i = 0; i < Binario.length(); i = i+4)
        {
            //Separa o numero binario de 4 em 4 bits (Int)
            HexTemp[x] = Binario.substring(i,4+i);
            Bin4Bit = Integer.parseInt(HexTemp[x]);
            //Transforma Binário para Decimal (Int)
            Decimal = BinToDec(Bin4Bit);
            Hexadecimal += DecToHex(Decimal);
            
            x++;
        }
        
        return Hexadecimal; 
    }    
//==============================================================================
//============================================FUNCAO 8: HEXADECIMAL PARA DECIMAL
//Em caso de número inválido o retorno é -1
//==============================================================================
    static int HexToDec(String Hexadecimal)
    {
        String DecimalTempStr;
        int DecimalTempInt = 0, Decimal = 0, x = 0;
        char[] HexValidator = Hexadecimal.toCharArray();
        boolean HexValido = true;
        
        //Valida se o número é um hexadecimal válido
        for (int i = 0; i < HexValidator.length; i++) 
        {
            if
            (
            Character.toLowerCase(HexValidator[i]) == 'a' || Character.toLowerCase(HexValidator[i]) == 'b' ||
            Character.toLowerCase(HexValidator[i]) == 'c' || Character.toLowerCase(HexValidator[i]) == 'd' ||
            Character.toLowerCase(HexValidator[i]) == 'e' || Character.toLowerCase(HexValidator[i]) == 'f' ||
            HexValidator[i] == '0' || HexValidator[i] == '1' || HexValidator[i] == '2' ||
            HexValidator[i] == '3' || HexValidator[i] == '3' || HexValidator[i] == '4' || HexValidator[i] == '5' ||
            HexValidator[i] == '6' || HexValidator[i] == '7' || HexValidator[i] == '8' || HexValidator[i] == '9'
            )
            {   
                HexValido = true;
            }
            else
            {
                HexValido = false;
                break;
            }
        }
        //Se for Hexadecimal válido inicia a conversão
        if (HexValido)
        {
            for(int i = Hexadecimal.length(); i > 0; i--)
            {   
                DecimalTempStr = Hexadecimal.substring(i-1, i);
            
                //===============================================
                //Valida a entrada da substring 
                //(UpperCase) transforma minuscula em maiuscula
                //===============================================
                switch (DecimalTempStr.toUpperCase())
                {
                    case "A": DecimalTempStr = "10";
                    break;
                    case "B": DecimalTempStr = "11";
                    break;
                    case "C": DecimalTempStr = "12";
                    break;
                    case "D": DecimalTempStr = "13";
                    break;
                    case "E": DecimalTempStr = "14";
                    break;
                    case "F": DecimalTempStr = "15";
                    break;
                }
                DecimalTempInt = Integer.parseInt(DecimalTempStr);
                DecimalTempInt *= (Math.pow(16, x));
                Decimal +=  DecimalTempInt;
                x++;
            }
            return Decimal;
        }
        //Caso ao contrário retorna -1 (meu codigo de erro)
        else
        {
            return -1;
        }
    }
//==============================================================================
//============================================FUNCAO 9: HEXADECIMAL PARA BINÁRIO
//Em caso de número inválido o retorno é "Hexadecimal inválido"
//==============================================================================
    static String HexToBin(String Hexadecimal)
    {
        String BinTemp,  Binario="";
        long Decimal;
        char[] HexValidator = Hexadecimal.toCharArray();
        boolean HexValido = true;
        
        //Valida se o número é um hexadecimal válido
        for (int i = 0; i < HexValidator.length; i++) 
        {
            if
            (
            Character.toLowerCase(HexValidator[i]) == 'a' || Character.toLowerCase(HexValidator[i]) == 'b' ||
            Character.toLowerCase(HexValidator[i]) == 'c' || Character.toLowerCase(HexValidator[i]) == 'd' ||
            Character.toLowerCase(HexValidator[i]) == 'e' || Character.toLowerCase(HexValidator[i]) == 'f' ||
            HexValidator[i] == '0' || HexValidator[i] == '1' || HexValidator[i] == '2' ||
            HexValidator[i] == '3' || HexValidator[i] == '3' || HexValidator[i] == '4' || HexValidator[i] == '5' ||
            HexValidator[i] == '6' || HexValidator[i] == '7' || HexValidator[i] == '8' || HexValidator[i] == '9'
            )
            {   
                HexValido = true;
            }
            else
            {
                HexValido = false;
                break;
            }
        }
        //Se for Hexadecimal válido inicia a conversão
        if (HexValido)
        {
        
            for(int i = 0; i<Hexadecimal.length(); i++)
            {
                Decimal = HexToDec(Hexadecimal.substring(i,i+1));
                BinTemp = DecToBin4Bits(Decimal);
                Binario += BinTemp;
            }
            return Binario;
        }    
        else
        {
            return "Hexadecimal inválido";
        }
    }
//==============================================================================
//==============================================FUNÇÃO 10: CRIPTOGRAFIA DE CESAR
//==============================================================================
    static String CripCesarTexto(String Texto, int Deslocamento)
    {
        //Coloca a string separada dentro dos arrays
        Texto = Texto.toLowerCase();
        char[] EntradaTexto = Texto.toCharArray();
        char[] Alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String SaidaTexto = "";
        
        //Olha para cada letra do texto "Texto"
        for (int i = 0; i < EntradaTexto.length; i++) 
        {
            //Olha para cada letra do "Alfabeto"
            for (int j = 0; j < Alfabeto.length; j++) 
            {
                //Se a letra do "Texto" for igual a letra do "Alfabeto"
                if (EntradaTexto[i] == Alfabeto[j])
                {
                    //A letra do "Texto" recebe a letra do "Alfabeto" deslocada
                    if (j + Deslocamento >= 26)
                    {
                        EntradaTexto[i] = Alfabeto[j + Deslocamento - 26];
                    }    
                    else
                    {
                        EntradaTexto[i] = Alfabeto[j + Deslocamento];
                    }   
                    j = 0;
                    break;
                }
            }
            SaidaTexto += EntradaTexto[i];
        }
        
        return SaidaTexto;
    }
//==============================================================================
//===========================================FUNÇÃO 11: DESCRIPTOGRAFIA DE CESAR
//==============================================================================
    static String DescripCesar(String Texto, int Deslocamento)
    {
        //Coloca a string separada dentro dos arrays
        Texto.toLowerCase();
        char[] EntradaTexto = Texto.toCharArray();
        char[] Alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String SaidaTexto = "";
        
        //Olha para cada letra do texto "Texto"
        for (int i = 0; i < EntradaTexto.length; i++) 
        {
            //Olha para cada letra do "Alfabeto"
            for (int j = 0; j < Alfabeto.length; j++) 
            {
                //Se a letra do "Texto" for igual a letra do "Alfabeto"
                if (EntradaTexto[i] == Alfabeto[j])
                {
                    //A letra do "Texto" recebe a letra do "Alfabeto" deslocada
                    if (j - Deslocamento < 0)
                    {
                        EntradaTexto[i] = Alfabeto[j - Deslocamento + 26];
                    }    
                    else
                    {
                        EntradaTexto[i] = Alfabeto[j - Deslocamento];
                    }   
                    j = 0;
                    break;
                }
            }
            SaidaTexto += EntradaTexto[i];
        }
        
        return SaidaTexto;
    }
}
