/**@autor Gustavo Muniz - Controle e Automação - mat. 818
 * @since 17/11/2022
 * @version 1.0
 */

package controler;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe responsável por CRIAR, LER e ESCREVER arquivos.
 */
public class FileManager {
    /**
     * No fileName, tanto do "writeTxt() quanto do readTxt()"
     * ,foi passado o caminho do arquivo com o nome do arquivo,
     * que neste caso é o nome do Candidato.
     * @param filePath nome do arquivo
     * @param content conteúdo passado para o arquivo
     * @param append determina se o que já existe no arquivo será ou não guardado naquela determinada RUN
     */
    public static void writeTxt(String filePath, String content, Boolean append) {
        try {
            /**
             * @constructor constroi um arquivo txt para armazenar as informações de escrita.
             * @param filePath nome do arquivo
             * @param append determina se o que já existe no arquivo será ou não guardado naquela determinada RUN
             */
            FileWriter fw = new FileWriter(
                    "C:\\Users\\gusta\\Desktop\\C206\\Teoria\\ExercicioAvaliativo03\\src\\Arquivos\\" + filePath,
                    append);
            /**
             * @constructor constroi um buffer para mandar as informações para o arquivo por meio do método write().
             * @param fw recebe o arquivo onde será feito a escrita.
             */
            BufferedWriter bw = new BufferedWriter(fw);
            if (content != null) {
                bw.write(content + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Função para leitura de arquivo:
     * @param filePath arquivo que será lido
     * @return retorna a string que estava dentro do arquivo
     * @throws IOException lança uma exception caso haja um erro na leitura do arquivo
     */
    public static ArrayList<String> readTxt(String filePath) throws IOException {

        ArrayList<String> cpfs = new ArrayList<>();

        try {
            /**
             * @constructor constroi um arquivo txt para armazenar as informações de leitura.
             * @param filePath recebe o arquivo que será lido.
             */
            FileReader fr = new FileReader(
                    "C:\\Users\\gusta\\Desktop\\C206\\Teoria\\ExercicioAvaliativo03\\src\\Arquivos\\" + filePath);
            /**
             * @constructor constroi um buffer para mandar as informações para a requisição por meio do método read().
             * @param fr recebe o arquivo de leitura.
             */
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                cpfs.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return cpfs;
    }
}
