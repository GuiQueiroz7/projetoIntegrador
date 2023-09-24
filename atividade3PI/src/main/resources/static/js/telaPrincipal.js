$(document).ready(function () {
    function carregarFilmes() {
        $.ajax({
            url: 'http://localhost:8080/filme/listar',
            method: 'GET',
            success: function (data) {
                $('#paraAssisF tbody').empty();
                $('#assistindoF tbody').empty();
                $('#assistidoF tbody').empty();
                for (let i = 0; i < data.length; i++) {
                    let filme = data[i];

                    let titulo = $('<td>').text(filme.nome);

                    let botaoDeletar = $('<button>')
                            .text('Excluir')
                            .click(function () {
                                deletarFilme($(this).parent().parent().attr('data-id'), {});
                            });
                    let excluir = $('<td>')
                            .append(botaoDeletar);

                    let tr = $('<tr>').attr('data-id', filme.id)
                            .append(titulo)
                            .append(excluir);

                    if (filme.status === "Para assistir") {
                        $('#paraAssisF tbody').append(tr);
                    } else if (filme.status === "Assistindo") {
                        $('#assistindoF tbody').append(tr);
                    } else if (filme.status === "Assistido") {
                        $('#assistidoF tbody').append(tr);
                    }
                    ;
                }
            },
            error: function () {
                alert('Não foi possível carregar os filmes da API.');
            }
        });
    }
    function criaFilme(filme) {
        $.ajax({
            url: 'http://localhost:8080/filme/adicionar',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(filme),
            success: function (data) {
                $('#nomeF').val('');
                $('#nomeDiretorF').val('');
                $('#anoF').val('');
                $('#tempoF').val('');
                $('#statusF').val('');
                carregarFilmes();
            },
            error: function () {
                alert('Não foi possível criar o filme na API.');
            }
        });
    }

    $('#formAddFilme').submit(function (event) {
        event.preventDefault();
        let nome = $('#nomeF').val();
        let nomeDir = $('#nomeDiretorF').val();
        let anoLanc = $('#anoF').val();
        let tempoDur = $('#tempoF').val();
        let status = $('#statusF').val();
        let filme = {
            nome: nome,
            diretor: nomeDir,
            anoLancamento: anoLanc,
            tempoDuracao: tempoDur,
            status: status
        };
        criaFilme(filme);
    });
    
    function deletarFilme(id) {
        $.ajax({
            url: 'http://localhost:8080/filme/deletar/' + id,
            method: 'DELETE',
            success: function (data) {
                alert('Filme removido na API com sucesso!');
                carregarFilmes();
            },
            error: function () {
                alert('Não foi possível deletar o filme na API.');
            }
        });
    }

    function carregarSeries() {
        $.ajax({
            url: 'http://localhost:8080/serie/listar',
            method: 'GET',
            success: function (data) {
                $('#paraAssisS tbody').empty();
                $('#assistindoS tbody').empty();
                $('#assistidoS tbody').empty();
                for (let i = 0; i < data.length; i++) {
                    let serie = data[i];

                    let titulo = $('<td>').text(serie.nome);

                    let botaoDeletar = $('<button>')
                            .text('Excluir')
                            .click(function () {
                                deletarSerie($(this).parent().parent().attr('data-id'), {});
                            });
                    let excluir = $('<td>')
                            .append(botaoDeletar);

                    let tr = $('<tr>').attr('data-id', serie.id)
                            .append(titulo)
                            .append(excluir);

                    if (serie.status === "Para assistir") {
                        $('#paraAssisS tbody').append(tr);
                    } else if (serie.status === "Assistindo") {
                        $('#assistindoS tbody').append(tr);
                    } else if (serie.status === "Assistido") {
                        $('#assistidoS tbody').append(tr);
                    }
                    ;
                }
            },
            error: function () {
                alert('Não foi possível carregar as séries da API.');
            }
        });
    }
    function criaSerie(serie) {
        $.ajax({
            url: 'http://localhost:8080/serie/adicionar',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(serie),
            success: function (data) {
                $('#nomeS').val('');
                $('#nomeDiretorS').val('');
                $('#anoS').val('');
                $('#statusS').val('');
                carregarSeries();
            },
            error: function () {
                alert('Não foi possível criar a série na API.');
            }
        });
    }

    $('#formAddSerie').submit(function (event) {
        event.preventDefault();
        let nome = $('#nomeS').val();
        let nomeDir = $('#nomeDiretorS').val();
        let anoLanc = $('#anoS').val();
        let status = $('#statusS').val();
        let serie = {
            nome: nome,
            diretor: nomeDir,
            anoLancamento: anoLanc,
            status: status
        };
        criaSerie(serie);
    });

    function deletarSerie(id) {
        $.ajax({
            url: 'http://localhost:8080/serie/deletar/' + id,
            method: 'DELETE',
            success: function (data) {
                alert('Série removida na API com sucesso!');
                carregarSeries();
            },
            error: function () {
                alert('Não foi possível deletar a série na API.');
            }
        });
    }

    function carregarLivros() {
        $.ajax({
            url: 'http://localhost:8080/livro/listar',
            method: 'GET',
            success: function (data) {
                $('#paraLer tbody').empty();
                $('#lendo tbody').empty();
                $('#lido tbody').empty();
                for (let i = 0; i < data.length; i++) {
                    let livro = data[i];

                    let titulo = $('<td>').text(livro.nome);

                    let botaoDeletar = $('<button>')
                            .text('Excluir')
                            .click(function () {
                                deletarLivro($(this).parent().parent().attr('data-id'), {});
                            });
                    let excluir = $('<td>')
                            .append(botaoDeletar);

                    let tr = $('<tr>').attr('data-id', livro.id)
                            .append(titulo)
                            .append(excluir);

                    if (livro.status === "Para ler") {
                        $('#paraLer tbody').append(tr);
                    } else if (livro.status === "Lendo") {
                        $('#lendo tbody').append(tr);
                    } else if (livro.status === "Lido") {
                        $('#lido tbody').append(tr);
                    }
                    ;
                }
            },
            error: function () {
                alert('Não foi possível carregar os livros da API.');
            }
        });
    }

    function crialivro(livro) {
        $.ajax({
            url: 'http://localhost:8080/livro/adicionar',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(livro),
            success: function (data) {
                $('#nomeL').val('');
                $('#nomeEscritor').val('');
                $('#anoL').val('');
                $('#statusL').val('');
                carregarLivros();
            },
            error: function () {
                alert('Não foi possível criar o livro na API.');
            }
        });
    }

    $('#formAddLivro').submit(function (event) {
        event.preventDefault();
        let nome = $('#nomeL').val();
        let nomeEscr = $('#nomeEscritor').val();
        let anoLanc = $('#anoL').val();
        let status = $('#statusL').val();
        let livro = {
            nome: nome,
            escritor: nomeEscr,
            anoLancamento: anoLanc,
            status: status
        };
        crialivro(livro);
    });

    function deletarLivro(id) {
        $.ajax({
            url: 'http://localhost:8080/livro/deletar/' + id,
            method: 'DELETE',
            success: function (data) {
                alert('Livro removido na API com sucesso!');
                carregarLivros();
            },
            error: function () {
                alert('Não foi possível deletar o livro na API.');
            }
        });
    }

    function carregarJogos() {
        $.ajax({
            url: 'http://localhost:8080/jogo/listar',
            method: 'GET',
            success: function (data) {
                $('#paraJogar tbody').empty();
                $('#jogando tbody').empty();
                $('#jogado tbody').empty();
                for (let i = 0; i < data.length; i++) {
                    let jogo = data[i];

                    let titulo = $('<td>').text(jogo.nome);

                    let botaoDeletar = $('<button>')
                            .text('Excluir')
                            .click(function () {
                                deletarJogo($(this).parent().parent().attr('data-id'), {});
                            });
                    let excluir = $('<td>')
                            .append(botaoDeletar);

                    let tr = $('<tr>').attr('data-id', jogo.id)
                            .append(titulo)
                            .append(excluir);

                    if (jogo.status === "Para jogar") {
                        $('#paraJogar tbody').append(tr);
                    } else if (jogo.status === "Jogando") {
                        $('#jogando tbody').append(tr);
                    } else if (jogo.status === "Jogado") {
                        $('#jogado tbody').append(tr);
                    }
                    ;
                }
            },
            error: function () {
                alert('Não foi possível carregar os jogos da API.');
            }
        });
    }
    function criaJogo(jogo) {
        $.ajax({
            url: 'http://localhost:8080/jogo/adicionar',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(jogo),
            success: function (data) {
                $('#nomeJ').val('');
                $('#nomeCriador').val('');
                $('#anoJ').val('');
                $('#statusJ').val('');
                carregarJogos();
            },
            error: function () {
                alert('Não foi possível criar o jogo na API.');
            }
        });
    }

    $('#formAddJogo').submit(function (event) {
        event.preventDefault();
        let nome = $('#nomeJ').val();
        let nomeCriad = $('#nomeCriador').val();
        let anoLanc = $('#anoJ').val();
        let status = $('#statusJ').val();
        let jogo = {
            nome: nome,
            criador: nomeCriad,
            anoLancamento: anoLanc,
            status: status
        };
        criaJogo(jogo);
    });

    function deletarJogo(id) {
        $.ajax({
            url: 'http://localhost:8080/jogo/deletar/' + id,
            method: 'DELETE',
            success: function (data) {
                alert('jogo removido na API com sucesso!');
                carregarJogos();
            },
            error: function () {
                alert('Não foi possível deletar o jogo na API.');
            }
        });
    }
    
    carregarFilmes();
    carregarSeries();
    carregarLivros();
    carregarJogos();
}); 