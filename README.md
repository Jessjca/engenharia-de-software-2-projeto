# Sistema de Agenda

Sistema de gerenciamento de agenda desenvolvido em Java com interface gráfica.

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
- SQLite 3
- Sistema operacional Windows 10 ou superior
- Mínimo de 4GB de memória RAM
- 500MB de espaço em disco

## Estrutura do Projeto

```
src/
├── main/
│   └── java/
│       ├── model/
│       │   ├── Usuario.java
│       │   └── Agendamento.java
│       ├── view/
│       │   └── MainFrame.java
│       └── controller/
│           └── DatabaseManager.java
└── test/
    └── java/
        ├── UsuarioTest.java
        └── AgendamentoTest.java
docs/
├── Arquitetura.md
├── ModeloProcesso.md
├── PlanoTestes.md
└── Requisitos.md
scripts/
├── baixar_driver.bat
├── baixar_junit.bat
├── baixar_junit4.bat
├── compilar.bat
├── compilar_testes.bat
└── limpar.bat
```

## Configuração Inicial

1. Execute os scripts na pasta `scripts` na seguinte ordem:
   - `baixar_driver.bat` - Baixa o driver do SQLite
   - `baixar_junit4.bat` - Baixa o JUnit 4.13.2
   - `compilar.bat` - Compila o projeto
   - `compilar_testes.bat` - Compila os testes
   - `limpar.bat` - Limpa arquivos compilados

## Executando o Projeto

1. Compile o projeto:
   ```bash
   cd scripts
   compilar.bat
   ```

2. Execute os testes:
   ```bash
   cd scripts
   compilar_testes.bat
   ```

## Documentação

A documentação completa do projeto está disponível na pasta `docs/`:
- `Arquitetura.md`: Documentação da arquitetura do sistema
- `ModeloProcesso.md`: Documentação do modelo de processo
- `PlanoTestes.md`: Documentação do plano de testes
- `Requisitos.md`: Documentação dos requisitos do sistema

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

