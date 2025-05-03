<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Aluno</title>
    <link rel="stylesheet" href="../estilos/styleVerificar.css">
</head>

<body>

    <header>
        <nav>
            <ul>
                <li><a href="../index.php">Início</a></li>
                <li><a href="adicionar.php">Cadastrar Usuário</a></li>
                <li><a href="verificarCadastro.php">Listar Usuários</a></li>
            </ul>
        </nav>
    </header>

    <main>

        <section id="containerSection">
            <form action="atualizarNota.php" method="post">
            <select id="curso" name="curso" class="estilo">
                <option value="analise_desenvolvimento_sistemas">Análise e Desenvolvimento de Sistemas</option>
                <option value="engenharia_software">Engenharia de Software</option>
                <option value="ciencias_computacao">Ciências da Computação</option>
                <option value="sistemas_informacao">Sistemas da Informação</option>
            </select>
                <input type="submit" value="Buscar">
            </form>

        </section>
        <section>

            <?php
                if (isset($_POST['curso'])) {
                    include("../conexao/conexao.php");

                    $curso = $_POST['curso'];

                    $sql = "SELECT * FROM usuarios WHERE curso = ?";
                    $stmt = $conn->prepare($sql);

                    if ($stmt) {
                        $stmt->bind_param("s", $curso);
                        $stmt->execute();
                        $resultado = $stmt->get_result();

                        if ($resultado->num_rows > 0) {
                            echo " <form action='processaNota.php' method='post' id='form-nota'>
                                <table>
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nome</th>
                                            <th>Sobrenome</th>
                                            <th>Nota Atividade</th>
                                            <th>Nota Prova</th>
                                        </tr>
                                    </thead>
                                    <tbody>";
                                    while ($row = $resultado->fetch_assoc()) {
                                        echo "
                                            <tr>
                                                <td>{$row['ID']}</td>
                                                <td>{$row['NOME']}</td>
                                                <td>{$row['SOBRENOME']}</td>
                                                <td>
                                                    <input type='number' name='nota_atividade[{$row['ID']}]' step='0.01' required>

                                                </td>
                                                <td>
                                                    <input type='number' name='nota_prova[{$row['ID']}]' step='0.01' required>
                                                </td>
                                            </tr>";
                                    }
                                    echo "
                                    </tbody>
                                </table>";
                                echo 
                                    
                                        "<input type='submit' value='Enviar'>
                                    </form>";
                        } else {
                            echo "<div class='mensagem erro'>E-mail <strong>$curso</strong> não encontrado.</div>";
                        }

                        $stmt->close();
                    } else {
                        echo "<div class='mensagem erro'>Erro na consulta: " . $conn->error . "</div>";
                    }

                    $conn->close();
                }
            ?>
        </section>

    </main>

</body>

</html>