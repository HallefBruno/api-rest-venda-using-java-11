create table cliente(
  id serial primary key,
  nome varchar(100)
);

create table produto(
  id serial primary key,
  descricao varchar(100),
  preco_unitario numeric(20,2)
);

create table pedido(
  id serial primary key,
  cliente_id integer references cliente(id),
  data_pedido timestamp,
  total numeric(20,2)
);

create table item_pedido(
  id serial primary key,
  pedido_id integer references pedido(id),
  produto_id integer references produto(id),
  quantidade integer
);


-- insert into product (id, nome) values(1,'Smart Phone Sansung');
-- insert into product (id, nome) values(2,'TV Smart LG');
-- insert into product (id, nome) values(3,'Monitor DELL');
-- insert into product (id, nome) values(4,'Notebook');
-- 
-- insert into category (id, nome) values(1,'Eletronicos');
-- insert into category (id, nome) values(2,'Domesticos');