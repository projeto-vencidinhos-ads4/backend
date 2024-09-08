
## Passo a passo para execução do projeto
As instruções abaixo possibilitarão que você execute uma cópia do projeto em sua máquina.
### Clone o repositório no local:
```bash
git clone https://github.com/projeto-vencidinhos-ads4/backend.git
```
### Preparação do projeto para execução:
Após clonar o projeto, abra o diretório: `backend` em sua **IDE** de preferência, que tenha capacidade de executar projetos **Java**.
> [!NOTE]
> No projeto, a equipe de desenvolvimento trabalhou com o **IntelliJ IDEA** para o _desenvolvimento_ e _debugging_ do projeto, para obtê-lo acesse a [página oficial da JetBrains](https://www.jetbrains.com/idea/).
### Configuração da imagem do Banco de Dados:
Nos arquivos `docker-compose.yml` e `application.properties` configure seu **usuário** e **senha** de acesso, nos campos referentes aos mesmos.
### Incialização da imagem do Banco de Dados:
Após configuração de seu acesso ao Banco de Dados, abra seu terminal e execute o comando:
```pwsh
docker-compose up -d #-d stands for detached
```
#### Conferência da execução da imagem:
Para conferir se sua **Imagem Docker** está sendo executada, em seu terminal execute o comando:
```pwsh
docker ps #ps stands for "Process Status"
```
O banco de dados estará acessível com usuário e senha definidos, em qualquer **cliente SQL** na porta **3307** do servidor local: `jdbc:mysql://localhost:3307/db_vencidinhos`.

> [!IMPORTANT]
> Para criar e executar imagens Docker, você necessitará do **Docker Desktop**. Caso não o possua, acesse a [página oficial da ferramenta](https://docs.docker.com/get-started/get-docker/) para instalação da mesma.
### Inicialização do projeto:
Após criar sua **Imagem Docker** e se assegurar de sua execução, em sua **IDE** execute o arquivo: `VencidinhosApplication.java`.
</br>

O projeto será executado na porta **8085**: [http://localhost:8085/](http://localhost:8085/)