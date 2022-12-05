/**@autor Gustavo Muniz - Controle e Automação - mat. 818
 * @since 17/11/2022
 * @version 1.0
 * Classe responsável pela interação com usuário, e
 * chamada das funções que implementam o sistema.
 */

package view;

import erros.ErrouCPFException;
import erros.VotoInvalidoException;
import model.Candidato;
import model.User;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe Principal:
 *  Toda a interação com o usuário é feita nesta classe.
 */
public class Main {
    /**
     * Método MAIN
     * @param args sem comentário específico.
     * @throws IOException herda a Exceptions da Classe IOException
     */
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        Boolean resp;
        Boolean verifica;
        Boolean cancelaVoto = false;

        User[] users = new User[10000];
        int i = 0;
        String cpf;
        int voto;

        // Candidatos:
        Candidato[] candidatos = new Candidato[3];
        candidatos[0] = new Candidato("Paulinho Anao", 77);
        candidatos[1] = new Candidato("Rogerao", 51);
        candidatos[2] = new Candidato("Dart Verde", 43);

        // Implementacao do sistema:
        System.out.print("Deseja iniciar as votacoes? ");
        resp = input.nextBoolean();
        if (resp) {

            while (resp) {
                // Criação de usuário:
                users[i] = new User();
                do {
                    try {
                        // Próxima linha:
                        input.nextLine();
                        System.out.print("Digite seu cpf no formato (xxx.xxx.xxx-xx): ");
                        cpf = input.nextLine();
                        users[i].setCpf(cpf);
                        verifica = true;
                    } catch (ErrouCPFException e) {
                        verifica = false;
                        System.err.println(e.getMessage());
                        System.out.println();
                    }

                    if (!verifica) {
                        System.out.print("Cancelar votacao? ");
                        resp = input.nextBoolean();
                        if (resp) {
                            cancelaVoto = true;
                            break;
                        }
                        else cancelaVoto = false;
                    }
                } while (!verifica);

                if (!cancelaVoto) {
                    do {
                        try {
                            System.out.print("Digite seu voto: ");
                            voto = input.nextInt();
                            users[i].setVoto(voto);
                            verifica = true;
                        } catch (VotoInvalidoException e) {
                            verifica = false;

                            System.err.println(e.getMessage());
                            System.out.println();
                        } catch (InputMismatchException e) {
                            verifica = false;
                            System.err.println("Voce nao digitou numeros!");
                            System.out.println();
                            input.nextLine();
                        }

                        if (!verifica) {
                            System.out.print("Cancelar votacao? ");
                            resp = input.nextBoolean();
                            if (resp) {
                                break;
                            }
                        }
                    } while (!verifica);
                }

                //fim
                System.out.print("Proximo eleitor? ");
                resp = input.nextBoolean();

                //proximo user:
                if (resp) {
                    i++;
                }
            }

            //amostragem dos resultados
            System.out.print("Apurar os votos? ");
            resp = input.nextBoolean();
            if (resp) {
                for (Candidato c : candidatos) {
                    if (c != null) {
                        c.apurarVotos(users);
                    }
                }

                for (Candidato c : candidatos) {
                    if (c != null) {
                        System.out.println("Votos de " + c.getNome() +
                                " numero " + c.getNumero() + ": " + c.mostrarVotosApurados());
                    }
                }
            }
        }
    }
}
