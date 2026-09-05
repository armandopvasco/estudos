import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.Charset;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //String caminho = "G:\\Meu Drive\\Meus Documentos\\Exportacao_MV22 (1).txt"; // Defina o caminho do seu arquivo

//        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
//            String linha;
//            // Lê cada linha até o final do arquivo
//            while ((linha = br.readLine()) != null) {
//                System.out.println(linha);
//            }
//        } catch (IOException e) {
//            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
//        }

//        Charset.forName()
        File arquivo = new File("G:\\Meu Drive\\Meus Documentos\\Exportacao_MV22 (1).txt");
        //Charset ansi = Charset.forName("windows-1252");
//        try (Scanner scanner = new Scanner(arquivo, "windows-1252")) {
        try (Scanner scanner = new Scanner(arquivo, "ASCII")) {

                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
//                System.out.println(contemCaracteresEspeciais(scanner.nextLine()));
                    //System.out.println(temEspecialPorCaractere(scanner.nextLine()));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado: " + e.getMessage());
            }




//        Path caminho = Path.of("G:\\Meu Drive\\Meus Documentos\\Exportacao_MV22 (1).txt");
//        Charset ansi = Charset.forName("windows-1252");
//
//        try {
//            // Lê todo o conteúdo do arquivo forçando o charset ANSI
//            String conteudo = Files.readString(caminho, ansi);
//            System.out.println(conteudo);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static boolean contemCaracteresEspeciais(String texto) {
        // \W busca por qualquer caractere que não seja letra, número ou sublinhado (_)
        Pattern padrao = Pattern.compile("[^a-zA-Z0-9 ]"); // ignora letras, números e espaço
        Matcher matcher = padrao.matcher(texto);
        System.out.println("matcher: "+matcher.toString());

        return matcher.find(); // Retorna true se encontrar algum caractere especial
    }

    public static void temEspecialPorCaractere(String texto) {
        for (char c : texto.toCharArray()) {
            // Se não for letra, número e nem espaço em branco, consideramos especial
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                System.out.println("Caractere: "+c);
            }
        }
    }
}