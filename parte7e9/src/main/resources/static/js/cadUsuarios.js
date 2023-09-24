$(document).ready(function () {
    function criaUsuario(user) {
        $.ajax({
            url: 'http://localhost:8080/user/adicionar',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(user),
            success: function (data) {
                $('#nome').val('');
                $('#login').val('');
                $('#senha').val('');
            },
            error: function () {
                alert('Não foi possível criar o usuário na API.');
            }
        });
    }

    $('#formCriaUser').submit(function (event) {
        event.preventDefault();
        let nome = $('#nome').val();
        let senha = $('#login').val();
        let login = $('#senha').val();
        let user = {
            nome: nome,
            senha: login,
            login: senha
        };
        criaUsuario(user);
    });
}); 