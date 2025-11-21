    ==1==
    Página Cadastrar Comprador:
        Campo de texto Código: campo de texto para escrever o código do comprador;
        Campo de texto Nome: campo de texto para escrever o nome do comprador;
        Campo de texto Pais: campo de texto para escrever o pais do comprador;
        Campo de texto Email: campo de texto para escrever o email do comprador;
        Botão Limpar: limpa todos os campos de texto da página;
        Botão Enviar: tenta cadastrar um fornecedor no sistema;
        Botão Voltar: volta para a página anterior.

    ==2==
    Página Cadastrar Fornecedor:
        Campo de texto Código: campo de texto para escrever o código do fornecedor;
        Campo de texto Nome: campo de texto para escrever o nome do fornecedor;
        Campo de texto Fundação: campo de texto para escrever a data de fundação do fornecedor;
        Botão de Área: escolhe uma das 4 áreas fornecidas no enum de Área (TI, ANDROIDES, EMERGENTE, ALIMENTOS);
        Botão Limpar: limpa todos os campos de texto da página;
        Botão Enviar: tenta cadastrar um fornecedor no sistema;
        Botão Voltar: volta para a página anterior.

    ==3==
    Página Cadastrar Tecnologia:
        Campo de texto ID: campo de texto para escrever o ID da tecnologia;
        Campo de texto Modelo: campo de texto para escrever o modelo da tecnologia;
        Campo de texto Descrição: campo de texto para escrever a descrição da tecnologia;
        Campo de texto Valor Base: campo de texto para escrever o valor base da tecnologia;
        Campo de texto Peso: campo de texto para escrever o peso da tecnologia;
        Campo de texto Temperatura: campo de texto para escrever a temperatura da tecnologia;
        Botão Selecionar Fornecedor: escolhe um dos fornecedores cadastrados no sistema;
        Botão Limpar: limpa todos os campos de texto da página;
        Botão Enviar: tenta cadastrar um fornecedor no sistema;
        Botão Voltar: volta para a página anterior.

    ==4==
    Home Page:
        Botão Fornecedor: redireciona a interface para a página com os métodos de fornecedor;
        Botão Comprador: redireciona a interface para a página com os métodos de comprador;
        Botão Venda: redireciona a interface para a página com métodos de Venda;
        Botão Tecnologia: redireciona a interface para a página com os métodos de Tecnologia;
        Botão Salvar/Carregar dados: redireciona a interface para a página de salvar ou carregar dados;
        Botão Sair: Fecha a interface.

    ==5==
    Página Cadastrar Venda:
        Botão Comprador: Mostra os compradores cadastrados e usuário escolhe um;
        Botão Tecnologia: Mostra as tecnologias cadastradas e o usuário escolhe uma;
        Campo de texto Número: campo de texto para escrever o número da venda;
        Campo de texto Data: campo de texto para escrever a data da venda;
        Botão Limpar: limpa todos os campos de texto da página;
        Botão Enviar: tenta cadastrar um fornecedor no sistema;
        Botão Voltar: volta para a página anterior.

    ==6==
    Página Comprador:
        Botão Cadastrar: redireciona a interface para a página de cadastrar comprador;
        Botão Mostrar Comprador: redireciona a interface para a página de mostrar relatório de compradores OU
            Cria uma nova janela com todos os dados de todos os compradores cadastrados;
        Botão Alterar dados: redireciona a interface para a página de alterar dados de um determinado comprador;
        Botão Consultar Maior: redireciona a interface para a página de consultar comprador com maior número de vendas OU
            Cria uma nova janela mostrando todos os dados do comprador com maior número de vendas;
        Botão Voltar: volta para a página anterior.

    ==7==
    Página Fornecedor:
        Botão Cadastrar: redireciona a interface para a página de cadastro de fornecedor;
        Botão Mostrar Relatório: redireciona a interface para a página de mostrar relatório de fornecedores OU
            Cria uma nova janela mostrando todos os dados de todos fornecedores cadastrados;
        Botão Consultar Maior: redireciona a interface para a página de consultar fornecedor com maior número de tecnologias OU
            Cria uma nova janela mostrando todos os dados do fornecedor com maior número de tecnologias junto com número de 	tecnologias que ele possui;
        Botão Voltar: volta para a página anterior.

    ==8==
    Página Tecnologia: 
        Botão Cadastrar: redireciona a interface para a página de cadastrar tecnologia;
        Botão Mostrar Relatório: redireciona a interface para a página de mostrar relatório de tecnologias OU
            Cria uma nova janela mostrando todos os dados de todas as tecnologias cadastradas junto dos dados do fornecedor 	correspondente;
        Botão Consultar Maior: redireciona a interface para a página de consultar tecnologia com maior valor OU
            Cria uma nova janela mostrando todos os dados da tecnologia com maior valor;
        Botão Voltar: volta para a página anterior.

    ==9==
    Página Venda:
        Botão Cadastrar: redireciona a interface para a página de cadastrar venda;
        Botão Mostrar Relatório: redireciona a interface para a página de mostrar relatório de vendas OU
            Cria uma nova janela com todos os dados de todas as vendas cadastradas junto dos dados do comprador e da tecnologia correspondentes;
        Botão Remover dados: redireciona a interface para a página de remover dados de uma determinada venda;
        Botão Consultar Maior: redireciona a interface para a página de consultar venda com maior valor OU
            Cria uma nova janela mostrando todos os dados da venda com maior valor junto da tecnologia e comprador correspondentes;
        Botão Voltar: volta para a página anterior.

==10==
Página Alterar Dados de um Determinado Comprador:
    Campo de texto Código: campo de texto para escrever o código do comprador;
    Botão Confirmar: busca um comprador com código fornecido, se achar abre uma página chamada Modificar Comprador.
    Botão Voltar: volta para a página anterior.

==11==
Página Modificar Comprador:
    Área de texto: mostra todos os dados do comprador localizado;
    Campo de texto Nome: campo de texto para escrever o nome do comprador;
    Campo de texto Pais: campo de texto para escrever o pais do comprador;
    Campo de texto Email: campo de texto para escrever o email do comprador;
    Botão Limpar: limpa todos os campos de texto da página;
    Botão Enviar: tenta cadastrar um fornecedor no sistema;
    Botão Voltar: volta para a página anterior.

==12==
Página Remover Dados de uma Determinada Venda:
    Campo de texto Número: campo de texto para escrever o número da venda;
    Botão Confirmar: busca uma venda com número fornecido, se achar remove ela do sistema.
    Botão Voltar: volta para a página anterior.

    ==13==
    Página Salvar/Carregar Dados:
        Botão Salvar Dados: redireciona a interface para a página de salvar dados;
        Botão Carregar Dados: redireciona a interface para a página de carregar dados.
        Botão Voltar: volta para a página anterior.

==14==
Página Salvar Dados:
    Campo de texto Nome: campo de texto para escrever o nome do arquivo a ser salvo todos os dados cadastrados no sistema;
    Botão Confirmar: busca uma venda com número fornecido, se achar remove ela do sistema.
    Botão Voltar: volta para a página anterior.

==15==
Página Carregar Dados:
    Campo de texto Nome: campo de texto para escrever o nome do arquivo a ser carregado todos os dados contidos nele;
    Botão Confirmar: busca uma venda com número fornecido, se achar remove ela do sistema.
    Botão Voltar: volta para a página anterior.
    

/*OPCIONAIS*/
==16==
Página Mostrar Relatório de Fornecedores:
    Área de texto: área de texto com todos os dados de todos os fornecedores cadastrados;
    Botão Voltar: volta para a página anterior.

==17==
Página Consultar Fornecedor com Maior Número de Tecnologias:
    Área de texto: mostra todos os dados do fornecedor com maior número de tecnologias junto com o número de tecnologias que ele possui;
    Botão Voltar: volta para a página anterior.

==18==
Página Mostrar Relatório de Tecnologias:
    Área de texto: área de texto com todos os dados de todos as tecnologias cadastradas junto com os dados do fornecedor correspondente;
    Botão Voltar: volta para a página anterior.

==19==
Página Consultar Tecnologia com maior valor:
    Área de texto: mostra todos os dados da tecnologia com maior valor;
    Botão Voltar: volta para a página anterior.

==20==
Página Mostrar Relatório de Compradores:
    Área de texto: área de texto com todos os dados de todos os compradores cadastrados;
    Botão Voltar: volta para a página anterior.

==21==
Página Consultar Comprador com maior Número de Vendas:
    Área de texto: mostra todos os dados do comprador com maior número de vendas;
    Botão Voltar: volta para a página anterior.

==22==
Página Mostrar Relatório de Vendas:
    Área de texto: área de texto com todos os dados de todos as vendas cadastradas junto dos dados correspondentes de comprador e tecnologia;
    Botão Voltar: volta para a página anterior.

==23==
Página Consultar Venda com maior valor:
    Área de texto: mostra todos os dados da venda com maior valor junto dos dados da tecnologia e comprador correspondentes;
    Botão Voltar: volta para a página anterior.