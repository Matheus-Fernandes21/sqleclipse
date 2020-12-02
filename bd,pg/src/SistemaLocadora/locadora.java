package SistemaLocadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;

public class locadora extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtCor;
	private JTextField txtAno;
	private JTable tableC;
	private JTextField txtPreco;
	private JTextField txtNome_cl;
	private JTextField txtEndereco;
	private JTextField txtCNH;
	private JTextField txtCPF;
	private JTextField txtCidade;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					locadora frame = new locadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public locadora() {
		setTitle("Locadora de carro");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tabela();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(10, 32, 161, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 81, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtCor = new JTextField();
		txtCor.setBounds(194, 32, 86, 20);
		contentPane.add(txtCor);
		txtCor.setColumns(10);

		txtAno = new JTextField();
		txtAno.setBounds(288, 81, 86, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome do carro");
		lblNewLabel.setBounds(10, 11, 86, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(10, 63, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cor");
		lblNewLabel_2.setBounds(194, 11, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Ano");
		lblNewLabel_3.setBounds(288, 56, 46, 14);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Cadastrar Carro");
		btnNewButton.setBounds(415, 31, 144, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cadastrarCarro();
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Editar Carro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(417, 80, 142, 23);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 575, 195);
		contentPane.add(scrollPane);

		tableC = new JTable();
		tableC.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Carro", "C\u00F3digo do carro", "Ano", "Cor", "Pre\u00E7o" }));
		tableC.getColumnModel().getColumn(1).setPreferredWidth(106);
		scrollPane.setViewportView(tableC);

		txtPreco = new JTextField();
		txtPreco.setBounds(135, 81, 92, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Pre\u00E7o do aluguel");
		lblNewLabel_4.setBounds(135, 63, 105, 14);
		contentPane.add(lblNewLabel_4);

		txtNome_cl = new JTextField();
		txtNome_cl.setBounds(10, 332, 193, 20);
		contentPane.add(txtNome_cl);
		txtNome_cl.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(235, 379, 161, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(10, 379, 193, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		txtCNH = new JTextField();
		txtCNH.setBounds(426, 332, 133, 20);
		contentPane.add(txtCNH);
		txtCNH.setColumns(10);

		txtCPF = new JTextField();
		txtCPF.setBounds(235, 332, 161, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		JButton btnNewButton_2 = new JButton("Cadastrar Cliente");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cadastrarCliente();
			}
		});
		btnNewButton_2.setBounds(10, 418, 150, 23);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_5 = new JLabel("Nome");
		lblNewLabel_5.setBounds(10, 315, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("CPF");
		lblNewLabel_6.setBounds(236, 315, 46, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("CNH");
		lblNewLabel_7.setBounds(426, 315, 46, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Endere\u00E7o");
		lblNewLabel_8.setBounds(10, 363, 69, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Cidade");
		lblNewLabel_9.setBounds(235, 363, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton_3 = new JButton("Editar Cliente");
		btnNewButton_3.setBounds(7, 452, 153, 23);
		contentPane.add(btnNewButton_3);

	}

	void cadastrarCliente() {

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost;databaseName=LOCADORA_DE_CARRO";
			String usuario = "sa";
			String senha = "sa";
			Connection conex = DriverManager.getConnection(url, usuario, senha);
			Statement stmt = conex.createStatement();

			if (txtCidade.getText().equals("") || txtCNH.getText().equals("") || txtCPF.getText().equals("")
					|| txtEndereco.getText().equals("") || txtNome_cl.getText().equals("")) {

				JOptionPane.showMessageDialog(contentPane, "todos os campos são obrigatórios");
			} else {

				stmt.executeUpdate("insert into cliente(CPF,nome_cliente,endereco,cidade,CNH) values ('"
						+ txtCPF.getText() + "'," + "'" + txtNome_cl.getText() + "'," + " '" + txtEndereco.getText()
						+ "'," + "'" + txtCidade.getText() + "'," + "'" + txtCNH.getText() + "')");
				
				JOptionPane.showMessageDialog(contentPane, "cadastrado com sucesso");

				txtCPF.setText("");
				txtNome_cl.setText("");
				txtEndereco.setText("");
				txtCidade.setText("");
				txtCNH.setText("");
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void cadastrarCarro() {

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost;databaseName=LOCADORA_DE_CARRO";
			String usuario = "sa";
			String senha = "sa";
			Connection conex = DriverManager.getConnection(url, usuario, senha);
			Statement stmt = conex.createStatement();

			if (txtNome.getText().equals("") || txtCodigo.getText().equals("") || txtAno.getText().equals("")
					|| txtCor.getText().equals("") || txtCodigo.getText().equals("")) {

				JOptionPane.showMessageDialog(contentPane, "Todos campos são obrigatórios");
			} else {

				stmt.executeUpdate("insert into carro (cod_carro,nome_carro,ano, cor,preço) values ('"
						+ txtCodigo.getText() + "'," + "'" + txtNome.getText() + "'," + "'" + txtAno.getText() + "',"
						+ "'" + txtCor.getText() + "'," + "'" + txtPreco.getText() + "' )");

				JOptionPane.showMessageDialog(contentPane, "cadastrado com sucesso");

				txtCodigo.setText("");
				txtNome.setText("");
				txtAno.setText("");
				txtCor.setText("");
				txtPreco.setText("");

				// tabela();

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void tabela() {

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost;databaseName=LOCADORA_DE_CARRO";
			String usuario = "sa";
			String senha = "sa";

			Connection conex = DriverManager.getConnection(url, usuario, senha);
			Statement stmt = conex.createStatement();

			ResultSet result = stmt.executeQuery("select* from carro");

			DefaultTableModel dtm = (DefaultTableModel) tableC.getModel();

			dtm.setNumRows(0);
			while (result.next()) {
				dtm.addRow(new Object[] { result.getString("Carro"), result.getInt("Código do carro"),
						result.getInt("Ano"), result.getString("Cor") });

			}
			tableC.setModel(dtm);

			stmt.close();
			conex.close();

		} catch (Exception e) {

		}

	}
}