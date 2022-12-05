/**@autor Gustavo Muniz - Controle e Automação - mat. 818
 * @since 17/11/2022
 * @version 1.0
 * Classe responsável por gerar a Exception customizada
 * quando o usuário digitar um VOTO inválido.
 */

package erros;

/**
 * Classe de exception personalizada
 */
public class VotoInvalidoException extends RuntimeException{

    /**
     * Método de voto inválido:
     * @param mensagem retorna a mensagem que será passada para o usuário quando o usuário digitar um
     *                 voto que é inválido ou que estava escrito de forma incorreta.
     */
    public VotoInvalidoException (String mensagem){
        super(mensagem);
    }
}
