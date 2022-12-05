/**@autor Gustavo Muniz - Controle e Automação - mat. 818
 * @since 17/11/2022
 * @version 1.0
 */

package model;

import erros.ErrouCPFException;
import erros.VotoInvalidoException;

/**
 * Classe responsável pela criação dos usuários e a validação das informações dos mesmos.
 */
public class User {
    // Atributos de Classe:
    private String cpf;
    private int voto;

    /**
     * Getter CPF:
     * @return retorna o CPF do usuário.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Setter CPF:
     * A atribuição de uma string só é passada para o atributo se o CPF digitado estiver dentro do
     * padrão estabelicido (xxx.xxx.xxx-xx)
     * @param cpf recebe o CPF do usuário que está votando.
     */
    public void setCpf(String cpf) {
        if (cpf.length() == 14
                && cpf.contains(".")
                && cpf.contains("-")
                && cpf.substring(0,3).matches("[0-9]*")
                && cpf.substring(5,7).matches("[0-9]*")
                && cpf.substring(9,11).matches("[0-9]*")
                && cpf.substring(13,14).matches("[0-9]*")) {
            this.cpf = cpf;
        } else {
            throw new ErrouCPFException("O CPF foi digitado de forma incorreta!");
        }
    }

    /**
     * Getter Voto:
     * @return retorna o voto que o usuário inseriu
     */
    public int getVoto() {
        return voto;
    }

    /**
     * Setter voto:
     * A atribuição de voto só é passada para o atributo se o VOTO digitado for número e corresponder
     * à um numero de candidato válido.
     * @param voto recebe o VOTO do usuário.
     */
    public void setVoto(int voto) {
        if (voto != 77 && voto != 51 && voto != 43) {
            throw new VotoInvalidoException("O numero inserido nao corresponde a nenhum candidato valido! \n" +
                    "Voce deve reiniciar seu voto!");
        } else {
            this.voto = voto;
        }
    }
}
