import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.PasswordField;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class EjemploWB2 extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JList list;
	private JSpinner spinner;

	public static void main(String[] args) {
		EjemploWB2 frame = new EjemploWB2();
		frame.setVisible(true);
	}

	public EjemploWB2() {
		setTitle("Ejemplo Componentes II");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 27, 78, 14);
		contentPane.add(lblPassword);

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(list.getSelectedValuesList());
			}
		});
		btnOK.setBounds(324, 228, 89, 23);
		contentPane.add(btnOK);

		passwordField = new JPasswordField();
		passwordField.setBounds(72, 24, 108, 17);
		contentPane.add(passwordField);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(2, 2, 200, 2));
		spinner.setBounds(10, 67, 78, 23);
		contentPane.add(spinner);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 177, 80);
		contentPane.add(scrollPane);

		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting())
					System.out
							.println("Item en curso : " + ((JList) e.getSource()).getSelectedValue());
				else if (!e.getValueIsAdjusting())
					System.out.println(
							"Item definitivo : " + ((JList) e.getSource()).getSelectedValue());

			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "DAM", "ASIR", "DAW" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
	}
}
