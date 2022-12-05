/**@autor Gustavo Muniz - Controle e Automação - mat. 818
 * @since 17/11/2022
 * @version 1.0
 * Classe responsável pela criação dos candidatos à eleição bem como,
 * as devidas implementações responsáveis tanto pelo armazenamento dos CPFs dos
 * usuários quanto pela apuração dos votos de cada candidato.
 */

package model;

import controler.FileManager;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe candidato, esta classe herda da Classe FileManager os métodos de leitura e escrita em arquivos.
 */
public class Candidato extends FileManager {

    private String nome;
    private int numero;

    /**
     * Construtor de canidatos
     * @param nome recebe o nome do candidato
     * @param numero numero de voto do candidato
     * writeTxt(nome, content, append) -> escreve um arquivo inicial sem nada com o nome do candidato
     *  content = null -> arquivo vazio
     *  append = false -> não salva as informações que poderiam estar contidas no arquivo antes da RUN
     */
    // Candidatos:
    public Candidato(String nome, int numero){
        this.nome = nome;
        this.numero = numero;
        writeTxt(nome, null, false);
    }

    /**
     * Método de apuração dos votos:
     * Este método é responsável por escrever no arquivo de cada candidato,
     * o CPF dos usuários que nele votaram.
     * @param users recebe todos os usuários que votaram naquele determinado candidato
     */
    public void apurarVotos(User[] users) {
        for (User u: users) {
            if(u != null){
                if (u.getVoto() == numero){
                    writeTxt(nome, u.getCpf(), true);
                }
            }
        }
    }

    /**
     * Método de amostragem dos votos:
     * Este método é responsável por ler o arquivo de cada candidato,
     * armazená-lo em uma Coleção e rodar a coleção para contar quantos usuários votaram
     * neste candidato em questão.
     * @return retorna a quantidade de votos que o candidato teve.
     * @throws IOException classe que lança a exception.
     */
    public int mostrarVotosApurados() throws IOException {
        int quantidadeVotos = 0;

        ArrayList<String> cpfs = readTxt(nome);

        for (String s: cpfs) {
            if (s != null){
                quantidadeVotos++;
            }
        }

        return quantidadeVotos;
    }

    /**
     * Getter de nome:
     * @return devolve o nome do Candidato
     */
    public String getNome() {
        return nome;
    }

    /**
     * Getter de número:
     * @return devolve o número do Candidato
     */
    public int getNumero() {
        return numero;
    }
}
