/**@autor Gustavo Muniz - Controle e Automação - mat. 818
 * @since 17/11/2022
 * @version 1.0
 * Classe responsável por gerar a Exception customizada
 * quando o usuário digitar um CPF inválido.
 */

package erros;

/**
 * Classe de exception personalizada para quando o CPF é escrito de forma incorreta.
 */
public class ErrouCPFException extends RuntimeException {

    /**
     * Errou CPF é o método que lança a Exception Personalizada
     * @param mensagem pega a mensagem passagem e faz o Override na exception antes de lançá-la para o usuário.
     */
    public ErrouCPFException(String mensagem){
        super(mensagem);
    }

}
