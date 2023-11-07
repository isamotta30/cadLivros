document.getElementById('cadastroForm').addEventListener('submit', cadastrarLivro);
var result = 0;
function cadastrarLivro(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const plataform = document.getElementById('plataform').value;

    fetch('http://localhost:8080/livro', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, plataform }),
    })
        .then(response => response.json())
        .then(data => {
            alert('Livro cadastrado com sucesso!');
            document.getElementById('cadastroForm').reset();            
        })
        .catch(error => {
            console.error('Erro ao cadastrar livro:', error);
        });
}
function pesquisarLivro() {
    const searchId = document.getElementById('searchId').value;

    fetch(`http://localhost:8080/jogos/${searchId}`)
        .then(response => {
            if (response.status === 404) {
                return Promise.reject('Livro não encontrado');
                result = 0;
            }
            return response.json();
        })
        .then(data => {
            result = 1;
            document.getElementById('name').value = `${data.name}`;
            document.getElementById('plataform').value = `${data.plataform}`;
        })
        .catch(error => {
            console.error('Erro ao pesquisar jogo:', error);
            const resultadoPesquisa = document.getElementById('resultadoPesquisa');
            resultadoPesquisa.innerHTML = 'Jogo não encontrado.'

        });
}
function atualizarLivro() {
    pesquisarJogo();
    if (result == 1) {
        const name = document.getElementById('name').value;
        const plataform = document.getElementById('plataform').value;
        const searchId = document.getElementById('searchId').value;

        fetch(`http://localhost:8080/jogos/${searchId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ name, plataform }),
        })
            .then(response => response.json())
            .then(data => {
                alert('Livro atualizado com sucesso!');
                document.getElementById('cadastroForm').reset();                
            })
            .catch(error => {
                console.error('Erro ao atualizar livro:', error);
            });
    } else {
        alert('ID não encontrado na base de dados. Nenhum livro foi alterado. Favor pesquisar livro a ser alterado !!!');
    }
    function deletarLivro() {
        deletarJogo();
        if (result == 1) {
            const name = document.getElementById('name').value;
            const plataform = document.getElementById('plataform').value;
            const searchId = document.getElementById('searchId').value;
    
            fetch(`http://localhost:8080/jogos/${searchId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ name, plataform }),
            })
                .then(response => response.json())
                .then(data => {
                    alert('Livro deletado com sucesso!');
                    document.getElementById('cadastroForm').reset();                
                })
                .catch(error => {
                    console.error('Erro ao deletar livro:', error);
                });
        } else {
            alert('ID não encontrado na base de dados. Nenhum livro foi alterado. Favor pesquisar livro a ser alterado !!!');
        }
    }
}
