import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.File;

public class Main {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Agendamento> agendamentos = new ArrayList<>();
    private static Usuario usuarioLogado = null;
    private static JFrame frame;
    private static JPanel mainPanel;
    private static CardLayout cardLayout;
    private static final Dimension TAMANHO_PADRAO = new Dimension(800, 600);
    private static DatabaseManager db;

    public static void main(String[] args) {
        // Inicializar o banco de dados
        db = new DatabaseManager();
        db.inicializarBanco();
        
        SwingUtilities.invokeLater(() -> {
            criarInterface();
        });
    }

    private static void criarInterface() {
        frame = new JFrame("Sistema de Agenda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(TAMANHO_PADRAO);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Criar o layout de cards para trocar entre telas
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setOpaque(false);

        // Criar e adicionar os painéis
        mainPanel.add(criarPainelLogin(), "login");
        mainPanel.add(criarPainelPrincipal(), "principal");

        // Criar o painel de fundo com imagem
        JPanel backgroundPanel = criarPainelFundo();
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(mainPanel, BorderLayout.CENTER);

        frame.add(backgroundPanel);
        frame.setVisible(true);
    }

    private static JPanel criarPainelLogin() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Título
        TextShadowLabel titulo = new TextShadowLabel("Sistema de Agenda");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(titulo, gbc);

        // Campos de login
        JTextField emailField = new JTextField(20);
        JPasswordField senhaField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton cadastroButton = new JButton("Cadastrar");

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
        emailLabel.setForeground(Color.WHITE);
        panel.add(emailLabel, gbc);
        gbc.gridy = 2;
        panel.add(emailField, gbc);
        gbc.gridy = 3;
        
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        senhaLabel.setForeground(Color.WHITE);
        panel.add(senhaLabel, gbc);
        gbc.gridy = 4;
        panel.add(senhaField, gbc);
        gbc.gridy = 5;
        panel.add(loginButton, gbc);
        gbc.gridy = 6;
        panel.add(cadastroButton, gbc);

        // Estilização dos componentes
        Color corFundo = new Color(0, 0, 0, 150);
        Color corTexto = Color.WHITE;
        Color corBotao = new Color(70, 130, 180);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        emailField.setBackground(corFundo);
        emailField.setForeground(corTexto);
        senhaField.setBackground(corFundo);
        senhaField.setForeground(corTexto);
        loginButton.setBackground(corBotao);
        loginButton.setForeground(corTexto);
        cadastroButton.setBackground(corBotao);
        cadastroButton.setForeground(corTexto);

        // Adicionar eventos
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());
            fazerLogin(email, senha);
        });

        cadastroButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "cadastro");
        });

        return panel;
    }

    private static JPanel criarPainelPrincipal() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Título
        TextShadowLabel titulo = new TextShadowLabel("Menu Principal");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(titulo, gbc);

        // Botões
        JButton verAgendamentosButton = new JButton("Ver Agendamentos");
        JButton criarAgendamentoButton = new JButton("Criar Agendamento");
        JButton cancelarAgendamentoButton = new JButton("Cancelar Agendamento");
        JButton sairButton = new JButton("Sair");

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panel.add(verAgendamentosButton, gbc);
        gbc.gridy = 2;
        panel.add(criarAgendamentoButton, gbc);
        gbc.gridy = 3;
        panel.add(cancelarAgendamentoButton, gbc);
        gbc.gridy = 4;
        panel.add(sairButton, gbc);

        // Estilização
        Color corBotao = new Color(70, 130, 180);
        Color corTexto = Color.WHITE;

        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        verAgendamentosButton.setBackground(corBotao);
        verAgendamentosButton.setForeground(corTexto);
        criarAgendamentoButton.setBackground(corBotao);
        criarAgendamentoButton.setForeground(corTexto);
        cancelarAgendamentoButton.setBackground(corBotao);
        cancelarAgendamentoButton.setForeground(corTexto);
        sairButton.setBackground(corBotao);
        sairButton.setForeground(corTexto);

        // Ações dos botões
        verAgendamentosButton.addActionListener(e -> verAgendamentos());
        criarAgendamentoButton.addActionListener(e -> criarAgendamento());
        cancelarAgendamentoButton.addActionListener(e -> cancelarAgendamento());
        sairButton.addActionListener(e -> {
            usuarioLogado = null;
            cardLayout.show(mainPanel, "login");
        });

        return panel;
    }

    private static void fazerLogin(String email, String senha) {
        Usuario usuario = db.buscarUsuario(email);
        if (usuario != null && usuario.validarSenha(senha)) {
            usuarioLogado = usuario;
            agendamentos = db.listarAgendamentos(1); // TODO: Implementar busca por ID do usuário
            cardLayout.show(mainPanel, "principal");
        } else {
            JOptionPane.showMessageDialog(frame, "Email ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static JPanel criarPainelFundo() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Carrega a imagem como um recurso
                    java.net.URL imageUrl = getClass().getResource("/resources/background.jpg");
                    if (imageUrl == null) {
                        System.out.println("Imagem não encontrada nos recursos!");
                        return;
                    }
                    
                    System.out.println("Carregando imagem de: " + imageUrl);
                    ImageIcon icon = new ImageIcon(imageUrl);
                    if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                        System.out.println("Erro ao carregar imagem!");
                    } else {
                        System.out.println("Imagem carregada com sucesso!");
                    }
                    
                    Image img = icon.getImage();
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                } catch (Exception e) {
                    System.out.println("Erro ao carregar imagem: " + e.getMessage());
                }
            }
        };
    }

    private static JPanel criarPainelCadastro() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Título
        TextShadowLabel titulo = new TextShadowLabel("Cadastro de Usuário");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(titulo, gbc);

        // Campos de cadastro
        JTextField nomeField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JPasswordField senhaField = new JPasswordField(20);
        JPasswordField confirmarSenhaField = new JPasswordField(20);
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton voltarButton = new JButton("Voltar");

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        nomeLabel.setForeground(Color.WHITE);
        panel.add(nomeLabel, gbc);
        gbc.gridy = 2;
        panel.add(nomeField, gbc);
        gbc.gridy = 3;
        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
        emailLabel.setForeground(Color.WHITE);
        panel.add(emailLabel, gbc);
        gbc.gridy = 4;
        panel.add(emailField, gbc);
        gbc.gridy = 5;
        
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        senhaLabel.setForeground(Color.WHITE);
        panel.add(senhaLabel, gbc);
        gbc.gridy = 6;
        panel.add(senhaField, gbc);
        gbc.gridy = 7;
        
        JLabel confirmarSenhaLabel = new JLabel("Confirmar Senha:");
        confirmarSenhaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        confirmarSenhaLabel.setForeground(Color.WHITE);
        panel.add(confirmarSenhaLabel, gbc);
        gbc.gridy = 8;
        panel.add(confirmarSenhaField, gbc);
        gbc.gridy = 9;
        panel.add(cadastrarButton, gbc);
        gbc.gridy = 10;
        panel.add(voltarButton, gbc);

        // Estilização dos componentes
        Color corFundo = new Color(0, 0, 0, 150);
        Color corTexto = Color.WHITE;
        Color corBotao = new Color(70, 130, 180);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        nomeField.setBackground(corFundo);
        nomeField.setForeground(corTexto);
        emailField.setBackground(corFundo);
        emailField.setForeground(corTexto);
        senhaField.setBackground(corFundo);
        senhaField.setForeground(corTexto);
        confirmarSenhaField.setBackground(corFundo);
        confirmarSenhaField.setForeground(corTexto);
        cadastrarButton.setBackground(corBotao);
        cadastrarButton.setForeground(corTexto);
        voltarButton.setBackground(corBotao);
        voltarButton.setForeground(corTexto);

        // Adicionar eventos
        cadastrarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());
            String confirmarSenha = new String(confirmarSenhaField.getPassword());
            cadastrarUsuario(nome, email, senha, confirmarSenha);
        });

        voltarButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "login");
        });

        return panel;
    }

    private static void verAgendamentos() {
        StringBuilder sb = new StringBuilder();
        boolean encontrou = false;

        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getUsuarioId() == 1) { // TODO: Implementar busca por ID do usuário
                sb.append("Data: ").append(agendamento.getData()).append("\n");
                sb.append("Hora: ").append(agendamento.getHora()).append("\n");
                sb.append("Descrição: ").append(agendamento.getDescricao()).append("\n");
                sb.append("-------------------\n");
                encontrou = true;
            }
        }

        if (!encontrou) {
            sb.append("Você não tem agendamentos.");
        }

        JDialog dialog = new JDialog(frame, "Meus Agendamentos", true);
        dialog.setSize(TAMANHO_PADRAO);
        dialog.setLocationRelativeTo(frame);
        dialog.setResizable(false);

        JPanel backgroundPanel = criarPainelFundo();
        backgroundPanel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        textArea.setBackground(new Color(0, 0, 0, 150));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        dialog.add(backgroundPanel);
        dialog.setVisible(true);
    }

    private static void criarAgendamento() {
        JDialog dialog = new JDialog(frame, "Novo Agendamento", true);
        dialog.setSize(TAMANHO_PADRAO);
        dialog.setLocationRelativeTo(frame);
        dialog.setResizable(false);

        JPanel backgroundPanel = criarPainelFundo();
        backgroundPanel.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField dataField = new JTextField(20);
        JTextField horaField = new JTextField(20);
        JTextField descricaoField = new JTextField(20);
        JButton criarButton = new JButton("Criar");

        gbc.gridy = 0;
        // panel.add(new TextShadowLabel("Data (dd/mm/aaaa):"), gbc);

        JLabel dataLabel = new JLabel("Data (dd/mm/aaaa):");
        dataLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(dataLabel, gbc);

        gbc.gridy = 1;
        panel.add(dataField, gbc);


        gbc.gridy = 2;
        JLabel horaLabel = new JLabel("Hora (hh:mm):");
        horaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(horaLabel, gbc);

        gbc.gridy = 3;
        panel.add(horaField, gbc);

        gbc.gridy = 4;
        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(descricaoLabel, gbc);

        gbc.gridy = 5;
        panel.add(descricaoField, gbc);
        gbc.gridy = 6;
        panel.add(criarButton, gbc);

        // Estilização
        Color corFundo = Color.WHITE;
        Color corTexto = Color.WHITE;
        Color corBotao = new Color(70, 130, 180);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        dataField.setBackground(corFundo);
        dataField.setForeground(corTexto);
        horaField.setBackground(corFundo);
        horaField.setForeground(corTexto);
        descricaoField.setBackground(corFundo);
        descricaoField.setForeground(corTexto);
        criarButton.setBackground(corBotao);
        criarButton.setForeground(corTexto);

        criarButton.addActionListener(e -> {
            String data = dataField.getText();
            String hora = horaField.getText();
            String descricao = descricaoField.getText();

            if (data.isEmpty() || hora.isEmpty() || descricao.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Agendamento novoAgendamento = new Agendamento(1, data, hora, descricao); // TODO: Implementar busca por ID do usuário
            if (db.criarAgendamento(novoAgendamento)) {
                JOptionPane.showMessageDialog(dialog, "Agendamento criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                agendamentos = db.listarAgendamentos(1); // TODO: Implementar busca por ID do usuário
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Erro ao criar agendamento.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        backgroundPanel.add(panel, BorderLayout.CENTER);
        dialog.add(backgroundPanel);
        dialog.setVisible(true);
    }

    private static void cancelarAgendamento() {
        ArrayList<Agendamento> agendamentosUsuario = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int contador = 1;

        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getUsuarioId() == 1) { // TODO: Implementar busca por ID do usuário
                sb.append(contador).append(". Data: ").append(agendamento.getData())
                  .append(" Hora: ").append(agendamento.getHora())
                  .append(" Descrição: ").append(agendamento.getDescricao()).append("\n");
                agendamentosUsuario.add(agendamento);
                contador++;
            }
        }

        if (agendamentosUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Você não tem agendamentos para cancelar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JDialog dialog = new JDialog(frame, "Cancelar Agendamento", true);
        dialog.setSize(TAMANHO_PADRAO);
        dialog.setLocationRelativeTo(frame);
        dialog.setResizable(false);

        JPanel backgroundPanel = criarPainelFundo();
        backgroundPanel.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        TextShadowLabel titulo = new TextShadowLabel("Seus Agendamentos");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titulo, gbc);

        // Lista de agendamentos
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        textArea.setBackground(new Color(0, 0, 0, 150));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700, 350));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(scrollPane, gbc);

        // Painel para entrada do número
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setOpaque(false);

        GridBagConstraints inputGbc = new GridBagConstraints();
        inputGbc.gridwidth = 2;
        inputGbc.insets = new Insets(10, 10, 10, 10);
        inputGbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel inputLabel = new JLabel("Digite o número do agendamento para cancelar:");
        inputLabel.setForeground(Color.BLACK);
        inputLabel.setFont(new Font("Arial", Font.BOLD, 16));
        inputGbc.gridy = 0;
        inputPanel.add(inputLabel, inputGbc);

        JTextField inputField = new JTextField(10);
        inputField.setPreferredSize(new Dimension(300, 40));
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputGbc.gridy = 1;
        inputPanel.add(inputField, inputGbc);

        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        panel.add(inputPanel, gbc);

        // Botão de confirmar
        JButton confirmarButton = new JButton("Confirmar Cancelamento");
        confirmarButton.setPreferredSize(new Dimension(300, 40));
        confirmarButton.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(confirmarButton, gbc);

        // Estilização
        Color corFundo = Color.WHITE;
        Color corTexto = Color.BLACK;
        Color corBotao = new Color(70, 130, 180);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        inputField.setBackground(corFundo);
        inputField.setForeground(corTexto);
        confirmarButton.setBackground(corBotao);
        confirmarButton.setForeground(corTexto);

        confirmarButton.addActionListener(e -> {
            try {
                int opcao = Integer.parseInt(inputField.getText());
                if (opcao > 0 && opcao <= agendamentosUsuario.size()) {
                    Agendamento agendamento = agendamentosUsuario.get(opcao - 1);
                    if (db.excluirAgendamento(agendamento)) {
                        agendamentos.remove(agendamento);
                        JOptionPane.showMessageDialog(dialog, "Agendamento cancelado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        dialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Erro ao cancelar agendamento.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(dialog, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Por favor, digite um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        backgroundPanel.add(panel, BorderLayout.CENTER);
        dialog.add(backgroundPanel);
        dialog.setVisible(true);
    }

    private static void cadastrarUsuario(String nome, String email, String senha, String confirmarSenha) {
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!senha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(frame, "As senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario novoUsuario = new Usuario(nome, email, senha);
        if (db.cadastrarUsuario(novoUsuario)) {
            JOptionPane.showMessageDialog(frame, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(mainPanel, "login");
        } else {
            JOptionPane.showMessageDialog(frame, "Erro ao cadastrar usuário. Email já existe.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
} 