# Sistema de Agenda

## Descrição
Sistema de agenda pessoal desenvolvido em Java com interface gráfica para gerenciamento de compromissos. O sistema permite cadastro de usuários, criação de agendamentos e visualização de compromissos de forma organizada.

## Funcionalidades
- Cadastro e login de usuários
- Criação de agendamentos
- Visualização de compromissos
- Cancelamento de agendamentos
- Persistência de dados com SQLite

## Requisitos
- Java JDK 17 ou superior
- Sistema operacional Windows 10 ou superior
- Mínimo de 4GB de memória RAM
- 500MB de espaço em disco

## Instalação

### Primeira Execução
1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/sistema-agenda.git
cd sistema-agenda
```

2. Execute o script para baixar as dependências:
```bash
baixar_driver.bat
```

3. Execute o script para compilar e iniciar o sistema:
```bash
compilar.bat
```

### Execuções Subsequentes
- Execute apenas o arquivo `compilar.bat` para iniciar o sistema

## Estrutura do Projeto
```
sistema-agenda/
├── src/                    # Código fonte
│   └── main/
│       ├── java/          # Classes Java
│       │   ├── Main.java           # Interface principal
│       │   ├── TextShadowLabel.java # Componente customizado
│       │   ├── DatabaseManager.java # Gerenciador do banco
│       │   ├── Usuario.java        # Classe de usuário
│       │   └── Agendamento.java    # Classe de agendamento
│       └── resources/     # Recursos do sistema
├── lib/                    # Bibliotecas externas
├── docs/                   # Documentação
├── bin/                    # Arquivos compilados
├── target/                 # Arquivos temporários
├── agenda.db              # Banco de dados SQLite
├── baixar_driver.bat      # Script de download
├── compilar.bat          # Script de compilação
├── .gitignore            # Configuração do Git
└── LICENSE               # Licença do projeto
```

## Documentação
A documentação completa do projeto está disponível na pasta `docs/`:
- [Requisitos](docs/Requisitos.md)
- [Arquitetura](docs/Arquitetura.md)
- [Diagramas UML](docs/DiagramasUML.md)
- [Manual do Usuário](docs/ManualUsuario.md)
- [Plano de Testes](docs/PlanoTestes.md)
- [Relatório de Desenvolvimento](docs/RelatorioDesenvolvimento.md)
- [Modelo de Processo](docs/ModeloProcesso.md)

## Desenvolvimento
O projeto foi desenvolvido seguindo:
- Metodologia ágil (Scrum)
- Padrão MVC
- Boas práticas de programação
- Documentação completa

## Contribuição
Para contribuir com o projeto:
1. Faça um fork do repositório
2. Crie uma branch para sua feature
3. Faça commit das alterações
4. Faça push para a branch
5. Abra um Pull Request

## Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Suporte
Para suporte técnico ou dúvidas:
- Email: suporte@sistemaagenda.com
- Telefone: (11) 1234-5678

## Autores
- [Seu Nome](https://github.com/seu-usuario)

## Agradecimentos
- Equipe de desenvolvimento
- Testadores
- Usuários que contribuíram com feedback

