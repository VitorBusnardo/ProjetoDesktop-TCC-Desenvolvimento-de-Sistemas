# Projeto Desktop - Desenvolvimento de Sistemas

<img src="https://raw.githubusercontent.com/MicaelliMedeiros/micaellimedeiros/master/image/computer-illustration.png" min-width="400px" max-width="400px" width="400px" align="right" alt="Computador iuriCode">

<p align="justify"> 
  Foi desenvolvido por nós um software batizado com o nome de Intermedix, com a intenção de te ajudar a administrar seu próprio negócio, batendo forte na tecla do setor Administrativo, com determinadas funções de controle de estoque, relatórios, contas, entre outras. Portanto atuando junto com o serviço web, descrito no outro repositório. Para ter acesso a mais infomações e prévias realize o download do Artigo do projeto.

</p>

<p align="left">
  🦄 Linguagens: <strong>Java Swing, MySql e SQLite.</strong>
</p>

<p align="left">
  💼 Ferramentas: <strong>NetBeans com Java 8. </strong>
</p>

<p align="justify">
  💌 Entre em contato comigo através das plataformas abaixo: ⤵️
</p>

<p align="left">
  <a href="#" alt="Gmail">
  <img src="https://img.shields.io/badge/-Gmail-FF0000?style=flat-square&labelColor=FF0000&logo=gmail&logoColor=white&link=LINK-DO-SEU-EMAIL" /></a>

  <a href="#" alt="Linkedin">
  <img src="https://img.shields.io/badge/-Linkedin-0e76a8?style=flat-square&logo=Linkedin&logoColor=white&link=LINK-DO-SEU-LINKEDIN" /></a>

  <a href="#" alt="WhatsApp">
  <img src="https://img.shields.io/badge/-WhatsApp-25d366?style=flat-square&labelColor=25d366&logo=whatsapp&logoColor=white&link=API-DO-SEU-WHATSAPP"/></a>

  <a href="#" alt="Facebook">
  <img src="https://img.shields.io/badge/-Facebook-3b5998?style=flat-square&labelColor=3b5998&logo=facebook&logoColor=white&link=LINK-DO-SEU-FACEBOOK"/></a>

  <a href="#" alt="Instagram">
  <img src="https://img.shields.io/badge/-Instagram-DF0174?style=flat-square&labelColor=DF0174&logo=instagram&logoColor=white&link=LINK-DO-SEU-INSTAGRAM"/></a>
</p>  

<h3> :rocket: &nbsp;Download do Artigo do Projeto </h3>

```
https://www.mediafire.com/file/qqcj1qmgf730xgu/Artigo_SyTecb.docx/file
```
<h3> :monocle_face: &nbsp;Banco para Login na Aplicação</h3>

```
create database if not exists usuarios_sytecb;

use usuarios_sytecb;

create table usuario(
id integer primary key not null auto_increment,
nome varchar(100) not null,
sobrenome varchar(100) not null,
email varchar(100) not null unique,
nomeUsuario varchar(100) not null unique,
senha varchar(100) not null,
telefone varchar(100) not null unique
) default charset = utf8 ;

insert into Usuario values (null, 'Vitor', 'Busnardo', 'busnardovitor@gmail.com', 'Admin', 'admin', '17981806259');

select * from usuario;
```
