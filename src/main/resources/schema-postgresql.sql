/*
    Script.sql o qual está ligado ao postgre no Heroku
    e fará a modelagem do mesmo.
*/

/*
    Primeiramente criarei entidades as quais diretamente, nunca serão
    manipuladas pelo usuário mas se relacionam e definem carácteristicas do mesmo.
    Por isso devem ser já previamente definidas aqui, no caso; Instituição e Cursos
    que o Aluno pode fazer.
*/

create table if not exists Instituicao (
    cd_instituicao serial not null,
    nm_instituicao varchar(45) ,
    constraint PK_instituicao primary key (cd_instituicao)
);

create table if not exists Cursos (
    cd_curso serial not null ,
    nm_curso varchar(45),
    sg_curso char(3),
    cd_instituicao serial,
    constraint PK_Curso primary key (cd_curso),
    constraint FK_CodInstituicao foreign key (cd_instituicao)
        references Instituicao (cd_instituicao),
    constraint Check_sgCurso
        check (sg_curso = 'ADS' or
                sg_curso = 'GE' or
                sg_curso = 'GP' or
                sg_curso = 'LOG' or
                sg_curso = 'SI'),
    constraint Check_nomeCurso
        check (nm_curso = 'Análise e Desenvolvimento de Sistemas' or
                nm_curso = 'Gestão Empresarial' or
                nm_curso = 'Gestão Portuária' or
                nm_curso = 'Logística' or
                nm_curso = 'Sistemas para Internet')
);

--   Criando finalmente minha tabela de Alunos, no caso criei nessa ordem só
--   para dar enfase a esse processo.

create table if not exists Aluno (
    id serial not null,
    nome varchar(45),
    sexo char(1),
    codigoCurso serial,
    nota decimal(3,1),
    idade integer,
    constraint PK_Aluno primary key (id),
    constraint FK_CursoAluno foreign key (codigoCurso)
        references cursos(cd_curso),
    constraint Check_nota
        check (nota between 0 and 10),
    constraint Check_sexo
        check (sexo = 'F' or
                sexo = 'M'),
    constraint Check_idade
        check (idade between 16 and 120)
);

/*
    Terceiro passo:
    Inserindo valores dentro das 2 primeiras tabelas, para
    futuramente serem abordados pelo usuário / Aluno.
*/


-- NOTA:
-- Como valores repetidos são criados sempre a aplicação
-- for rodada dentro de Instituição e Cursos,
--  esses comandos serão feitos diretamente no BD.



-- Inserir instituições
/*
    insert into Instituicao (nm_instituicao)
        values('Fatec Rubes Lara');
*/
-- Inserir Cursos no banco
/*
    insert into Cursos (nm_curso, sg_curso, cd_instituicao)
        values('Análise e Desenvolvimento de Sistemas', 'ADS', 1),
              ('Gestão Empresarial', 'GE', 1),
              ('Gestão Portuária', 'GP', 1),
              ('Logística', 'LOG', 1),
              ('Sistemas para Internet', 'SI', 1);
*/

-- NOTA:
-- Tentei inserir pelo psql e deu erro, acho q porque ele não suporta
-- assentuação e não reconhece os inserts. Rodei eles aqui mesmo e os
-- apaguei.