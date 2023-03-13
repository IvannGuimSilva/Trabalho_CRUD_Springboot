-- Criando banco de dados

create database Alunos;

-- Usando o banco de dados que foi criado no comendo acima

-- \c Alunos;

-- Desenvolvimento do banco de dados
-- Tabelas

create table instituicao(
	cd_instituicao serial not null,
	nm_instituicao varchar(45) ,
	constraint PK_instituicao primary key (cd_instituicao)
);

create table cursos(
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



create table alunos(
    cd_aluno serial not null,
    nm_aluno varchar(45),
    sg_sexoAluno char(1),
    cd_curso serial,
    qt_notaAluno decimal(3,1),
	qt_idade integer,
    constraint PK_Aluno primary key (cd_aluno),
    constraint FK_CursoAluno foreign key (cd_curso)
        references cursos(cd_curso),
    constraint Check_nota
        check (qt_notaAluno between 0 and 10),
	constraint Check_sexo
		 check (sg_sexoAluno = 'F' or
				sg_sexoAluno = 'M'),
    constraint Check_idade
        check (qt_idade between 16 and 120)
);



create sequence cd_instituicao_seq;
create sequence cd_curso_seq;
create sequence cd_aluno_seq;


alter table instituicao
alter column cd_instituicao set default nextval('cd_instituicao_seq');

alter table cursos
alter column cd_curso set default nextval('cd_curso_seq');

alter table alunos
alter column cd_aluno set default nextval('cd_aluno_seq');






-- Comandos de inserção de dados no banco

--Inserir instituições

insert into instituicao
	(nm_instituicao)
	values('Fatec Rubes Lara');


--Inserir Cursos no banco
insert into cursos
	(nm_curso, sg_curso, cd_instituicao)
	values('Análise e Desenvolvimento de Sistemas', 'ADS', 01),
		  ('Gestão Empresarial', 'GE', 01),
		  ('Gestão Portuária', 'GP', 01),
		  ('Logística', 'LOG', 01),
		  ('Sistemas para Internet', 'SI', 01);



--Inserindo alunos no banco
insert into alunos
	(nm_aluno, sg_sexoAluno, cd_curso, qt_notaAluno, qt_idade)
	values('Ivan Guimarães', 'M', 05, 9.9, 20),
		  ('Nathalia Souza', 'F', 05, 8.5, 24),
		  ('Breno Lins', 'M', 05, 8, 19),
		  ('Lucas Lins', 'M', 02, 8, 35),
		  ('Maria Eduarda', 'F', 01, 6, 28),
		  ('Mariana Costa', 'F', 03, 5, 35),
		  ('João Pedro', 'M', 04, 5.9, 16),
		  ('Lucas Martins', 'M', 02, 8, 34),
		  ('Eduarda Ribeiro', 'F', 03, 6, 58),
		  ('Roberta Souza', 'F', 04, 6.5, 18),
		  ('Romero Rocha', 'M', 03, 2, 37),
		  ('Luis Algusto', 'M', 04, 7, 22),
		  ('Joana Martins', 'F', 01, 8, 27);





/*

	-- texte de erros

	insert into cursos
		(nm_curso, sg_curso, cd_instituicao)
		values('Analise e Desenvolvimento de Sistemas', 'AbS', 01);

	insert into alunos
		(nm_aluno, sg_sexoAluno, cd_curso, qt_notaAluno, qt_idade)
		values('Ivan Guimarães', 'M', 01, 11, 18);

*/



--Comando de Seleção de grupos de alunos


-- Alunos reprovados

select  a.nm_aluno as Nome, a.qt_idade as Idade, a.sg_sexoAluno as Sexo, c.sg_curso as Curso, a.qt_notaAluno as Media_Final
	from alunos as a, cursos as c
	where qt_notaAluno  < 6 and c.cd_curso = a.cd_curso
	order by nm_aluno asc ;



--Alunos em geral
select  a.nm_aluno as Nome, a.qt_idade as Idade, a.sg_sexoAluno as Sexo, c.sg_curso as Curso, a.qt_notaAluno as Media_Final
	from alunos as a, cursos as c
	where c.cd_curso = a.cd_curso
	order by nm_aluno asc ;



-- alunos APROVADOS
select  a.nm_aluno as Nome, a.qt_idade as Idade, a.sg_sexoAluno as Sexo, c.sg_curso as Curso, a.qt_notaAluno as Media_Final
	from alunos as a, cursos as c
	where qt_notaAluno  >= 6 and c.cd_curso = a.cd_curso
	order by nm_aluno asc ;



-- Alunos HOMENS
select  a.nm_aluno as Nome, a.qt_idade as Idade, a.sg_sexoAluno as Sexo, c.sg_curso as Curso, a.qt_notaAluno as Media_Final
	from alunos as a, cursos as c
	where sg_sexoAluno = 'M' and c.cd_curso = a.cd_curso
	order by nm_aluno asc ;


-- Alunas Mulheres
select  a.nm_aluno as Nome, a.qt_idade as Idade, a.sg_sexoAluno as Sexo, c.sg_curso as Curso, a.qt_notaAluno as Media_Final
	from alunos as a, cursos as c
	where sg_sexoAluno = 'F' and c.cd_curso = a.cd_curso
	order by nm_aluno asc ;



-- Alunos de ADS
select  a.nm_aluno as Nome, a.qt_idade as Idade, a.sg_sexoAluno as Sexo, c.sg_curso as Curso, a.qt_notaAluno as Media_Final
	from alunos as a, cursos as c
	where sg_curso = 'ADS' and c.cd_curso = a.cd_curso
	order by nm_aluno asc ;



-- Alunos de SI
select  a.nm_aluno as Nome, a.qt_idade as Idade, a.sg_sexoAluno as Sexo, c.sg_curso as Curso, a.qt_notaAluno as Media_Final
	from alunos as a, cursos as c
	where sg_curso = 'SI' and c.cd_curso = a.cd_curso
	order by nm_aluno asc ;



-- Alunos de LOG
select  a.nm_aluno as Nome, a.qt_idade as Idade, a.sg_sexoAluno as Sexo, c.sg_curso as Curso, a.qt_notaAluno as Media_Final
	from alunos as a, cursos as c
	where sg_curso = 'LOG' and c.cd_curso = a.cd_curso
	order by nm_aluno asc ;




-- Comando de Exclusão - Delete

--Deletando Aluno no banco
delete from alunos
	where cd_aluno = 8;



--Observando o comando feito acima
select * from Alunos;




--Atualizando dados dos alunos
Update alunos
	set nm_aluno = 'Ivan Guimarães', sg_sexoAluno = 'M', qt_notaAluno = 10, qt_idade = 21
	where cd_aluno = 1;

--Observando o comando feito acima
select * from Alunos;


