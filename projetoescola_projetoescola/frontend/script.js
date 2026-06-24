
    const API = "http://localhost:8080/usuarios";

    // Cadastro
    document.querySelector("#formCadastro").addEventListener("submit", async e => {
      e.preventDefault();
      try {
        const res = await fetch(API, {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            nomecompleto: document.querySelector("#nomeCadastro").value,
            usuario: document.querySelector("#usuarioCadastro").value,
            email: document.querySelector("#emailCadastro").value,
            senha: document.querySelector("#senhaCadastro").value,
            telefone: document.querySelector("#telefoneCadastro").value
          })
        });
        const msg = await res.text();
        alert(msg);
      } catch (err) {
        alert("Erro ao cadastrar!");
      }
    });

    // Listar
    document.querySelector("#btnListar").addEventListener("click", async () => {
      try {
        const res = await fetch(API);
        const usuarios = await res.json();
        const lista = document.querySelector("#listaUsuarios");
        lista.innerHTML = "";
        usuarios.forEach(u => {
          const li = document.createElement("li");
          li.textContent = `${u.id} - ${u.nomecompleto} (${u.email})`;
          lista.appendChild(li);
        });
      } catch (err) {
        alert("Erro ao listar!");
      }
    });

    // Atualizar
    document.querySelector("#formAtualizar").addEventListener("submit", async e => {
      e.preventDefault();
      const token = localStorage.getItem("jwt");
      if (!token) {
        alert("Faça login primeiro para obter o token!");
        return;
      }
      try {
        const res = await fetch(API + "/" + document.querySelector("#idAtualizar").value, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + token
          },
          body: JSON.stringify({
            nomecompleto: document.querySelector("#nomeAtualizar").value,
            usuario: document.querySelector("#usuarioAtualizar").value,
            email: document.querySelector("#emailAtualizar").value,
            senha: document.querySelector("#senhaAtualizar").value,
            telefone: document.querySelector("#telefoneAtualizar").value
          })
        });
        const msg = await res.text();
        alert(msg);
      } catch (err) {
        alert("Erro ao atualizar!");
      }
    });

    // Excluir
    document.querySelector("#formExcluir").addEventListener("submit", async e => {
      e.preventDefault();
      const token = localStorage.getItem("jwt");
      if (!token) {
        alert("Faça login primeiro para obter o token!");
        return;
      }
      try {
        const res = await fetch(API + "/" + document.querySelector("#idExcluir").value, {
          method: "DELETE",
          headers: { "Authorization": "Bearer " + token }
        });
        const msg = await res.text();
        alert(msg);
      } catch (err) {
        alert("Erro ao excluir!");
      }
    });
  