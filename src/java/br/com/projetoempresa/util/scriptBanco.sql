create table PESSOA(

	idpessoa serial not null,
	nomepessoa varchar(50),
	telefonepessoa varchar(11),
	constraint pk_pessoa primary key(idpessoa)

);


create table PESSOAJURIDICA(

	idpessoajuridica serial not null,
	cnpjpessoajuridica varchar(14),
	iepessoajuridica varchar(10),
        tipopessoajuridica varchar(10),
	idpessoa integer,
	constraint pk_pessoajuridica primary key(idpessoajuridica),
	constraint fk_pj_pessoa foreign key(idpessoa) references pessoa(idpessoa)
);

