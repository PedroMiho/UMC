package entidades;

import java.util.ArrayList;

public class GerenciarListaAlunos {
    private ArrayList<Aluno> listaAlunos = new ArrayList<>();

    //Create - Cadastrar Aluno
    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
        System.out.println("Aluno adicionado com sucesso!");
    }

    public void listarAlunos() {
        if(listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno encontrado!");
        } else {
            System.out.println("| ID | NOME | NOTA 1 | NOTA 2 | MÉDIA | SITUAÇÃO |");
            for (int i=0; i<listaAlunos.size(); i++) {
                System.out.println("| " + i +listaAlunos.get(i));
            }
        }
    }

    public void alterarInformacoesAluno(int idAluno, String nome, double nota1, double nota2) {

        Aluno aluno = listaAlunos.get(idAluno);

        aluno.setNome(nome);
        aluno.setNota1(nota1);
        aluno.setNota2(nota2);

        System.out.println("Aluno alterado com sucesso!");

    }

    public void removerAluno(int idAluno) {
        listaAlunos.remove(idAluno);
        System.out.println("Aluno removido com sucesso!");
    }
}
