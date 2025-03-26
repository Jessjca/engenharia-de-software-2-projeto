package view;

import model.Usuario;
import model.Agendamento;
import controller.MainController;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JFrame {
    private MainController controller;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public MainView() {
        super("Sistema de Agenda");
        controller = new MainController();
        criarInterface();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }

    private void criarInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new BackgroundPanel();
        mainPanel.setLayout(cardLayout);

        mainPanel.add(criarPainelLogin(), "login");
        mainPanel.add(criarPainelCadastro(), "cadastro");
        mainPanel.add(criarPainelPrincipal(), "principal");

        add(mainPanel);
    }

    private JPanel criarPainelLogin() {
        BackgroundPanel panel = new BackgroundPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        panel.add(emailLabel, gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(20);
        panel.add(emailField, gbc);

        // Senha
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setForeground(Color.WHITE);
        panel.add(senhaLabel, gbc);

        gbc.gridx = 1;
        JPasswordField senhaField = new JPasswordField(20);
        panel.add(senhaField, gbc);

        // Botões
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Login");
        panel.add(loginButton, gbc);

        gbc.gridy = 3;
        JButton cadastrarButton = new JButton("Cadastrar");
        panel.add(cadastrarButton, gbc);

        // Ações
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());
            if (controller.fazerLogin(email, senha)) {
                cardLayout.show(mainPanel, "principal");
            } else {
                JOptionPane.showMessageDialog(this, "Email ou senha inválidos!");
            }
        });

        cadastrarButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "cadastro");
        });

        return panel;
    }

    private JPanel criarPainelCadastro() {
        BackgroundPanel panel = new BackgroundPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setForeground(Color.WHITE);
        panel.add(nomeLabel, gbc);

        gbc.gridx = 1;
        JTextField nomeField = new JTextField(20);
        panel.add(nomeField, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        panel.add(emailLabel, gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(20);
        panel.add(emailField, gbc);

        // Senha
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setForeground(Color.WHITE);
        panel.add(senhaLabel, gbc);

        gbc.gridx = 1;
        JPasswordField senhaField = new JPasswordField(20);
        panel.add(senhaField, gbc);

        // Botões
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton cadastrarButton = new JButton("Cadastrar");
        panel.add(cadastrarButton, gbc);

        gbc.gridy = 4;
        JButton voltarButton = new JButton("Voltar");
        panel.add(voltarButton, gbc);

        // Ações
        cadastrarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());
            
            Usuario usuario = new Usuario(nome, email, senha);
            if (controller.cadastrarUsuario(usuario)) {
                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
                cardLayout.show(mainPanel, "login");
            } else {
                JOptionPane.showMessageDialog(this, "Email já cadastrado!");
            }
        });

        voltarButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "login");
        });

        return panel;
    }

    private JPanel criarPainelPrincipal() {
        BackgroundPanel panel = new BackgroundPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Botões
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JButton novoAgendamentoButton = new JButton("Novo Agendamento");
        panel.add(novoAgendamentoButton, gbc);

        gbc.gridy = 1;
        JButton verAgendamentosButton = new JButton("Ver Agendamentos");
        panel.add(verAgendamentosButton, gbc);

        gbc.gridy = 2;
        JButton cancelarAgendamentoButton = new JButton("Cancelar Agendamento");
        panel.add(cancelarAgendamentoButton, gbc);

        gbc.gridy = 3;
        JButton sairButton = new JButton("Sair");
        panel.add(sairButton, gbc);

        // Ações
        novoAgendamentoButton.addActionListener(e -> {
            JDialog dialog = new JDialog(this, "Novo Agendamento", true);
            dialog.setSize(300, 200);
            dialog.setLocationRelativeTo(this);

            BackgroundPanel dialogPanel = new BackgroundPanel();
            dialogPanel.setLayout(new GridBagLayout());
            GridBagConstraints dialogGbc = new GridBagConstraints();
            dialogGbc.insets = new Insets(5, 5, 5, 5);

            // Data
            dialogGbc.gridx = 0;
            dialogGbc.gridy = 0;
            JLabel dataLabel = new JLabel("Data (dd/MM/yyyy):");
            dataLabel.setForeground(Color.WHITE);
            dialogPanel.add(dataLabel, dialogGbc);

            dialogGbc.gridx = 1;
            JTextField dataField = new JTextField(10);
            dialogPanel.add(dataField, dialogGbc);

            // Hora
            dialogGbc.gridx = 0;
            dialogGbc.gridy = 1;
            JLabel horaLabel = new JLabel("Hora (HH:mm):");
            horaLabel.setForeground(Color.WHITE);
            dialogPanel.add(horaLabel, dialogGbc);

            dialogGbc.gridx = 1;
            JTextField horaField = new JTextField(10);
            dialogPanel.add(horaField, dialogGbc);

            // Descrição
            dialogGbc.gridx = 0;
            dialogGbc.gridy = 2;
            JLabel descricaoLabel = new JLabel("Descrição:");
            descricaoLabel.setForeground(Color.WHITE);
            dialogPanel.add(descricaoLabel, dialogGbc);

            dialogGbc.gridx = 1;
            JTextField descricaoField = new JTextField(10);
            dialogPanel.add(descricaoField, dialogGbc);

            // Botão
            dialogGbc.gridx = 0;
            dialogGbc.gridy = 3;
            dialogGbc.gridwidth = 2;
            JButton criarButton = new JButton("Criar Agendamento");
            dialogPanel.add(criarButton, dialogGbc);

            criarButton.addActionListener(e2 -> {
                String data = dataField.getText();
                String hora = horaField.getText();
                String descricao = descricaoField.getText();
                
                if (controller.criarAgendamento(data, hora, descricao)) {
                    JOptionPane.showMessageDialog(dialog, "Agendamento criado com sucesso!");
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, 
                        "Erro ao criar agendamento. Verifique se:\n" +
                        "1. A data não está no passado\n" +
                        "2. A data está no formato dd/MM/yyyy\n" +
                        "3. A hora está no formato HH:mm",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                }
            });

            dialog.add(dialogPanel);
            dialog.setVisible(true);
        });

        verAgendamentosButton.addActionListener(e -> {
            ArrayList<Agendamento> agendamentos = controller.listarAgendamentos(controller.getUsuarioLogado().getId());
            
            StringBuilder mensagem = new StringBuilder("Seus agendamentos:\n\n");
            for (Agendamento a : agendamentos) {
                mensagem.append("ID: ").append(a.getId())
                       .append("\nData: ").append(a.getData())
                       .append("\nHora: ").append(a.getHora())
                       .append("\nDescrição: ").append(a.getDescricao())
                       .append("\n\n");
            }
            
            JOptionPane.showMessageDialog(this, mensagem.toString());
        });

        cancelarAgendamentoButton.addActionListener(e -> {
            ArrayList<Agendamento> agendamentos = controller.listarAgendamentos(controller.getUsuarioLogado().getId());
            
            if (agendamentos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Você não tem agendamentos para cancelar.");
                return;
            }

            String[] opcoes = new String[agendamentos.size()];
            for (int i = 0; i < agendamentos.size(); i++) {
                Agendamento a = agendamentos.get(i);
                opcoes[i] = String.format("Data: %s, Hora: %s, Descrição: %s", 
                    a.getData(), a.getHora(), a.getDescricao());
            }

            String selecionado = (String) JOptionPane.showInputDialog(
                this,
                "Selecione o agendamento para cancelar:",
                "Cancelar Agendamento",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            if (selecionado != null) {
                int indice = -1;
                for (int i = 0; i < opcoes.length; i++) {
                    if (opcoes[i].equals(selecionado)) {
                        indice = i;
                        break;
                    }
                }

                if (indice >= 0) {
                    Agendamento agendamento = agendamentos.get(indice);
                    int confirmacao = JOptionPane.showConfirmDialog(
                        this,
                        "Tem certeza que deseja cancelar este agendamento?",
                        "Confirmar Cancelamento",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                    );

                    if (confirmacao == JOptionPane.YES_OPTION) {
                        if (controller.excluirAgendamento(agendamento)) {
                            JOptionPane.showMessageDialog(this, "Agendamento cancelado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(this, 
                                "Erro ao cancelar agendamento. Tente novamente.",
                                "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        sairButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "login");
        });

        return panel;
    }
} 