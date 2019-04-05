package myedit;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
public class FileWindow extends JFrame implements ActionListener,Runnable{
    
	private static final long serialVersionUID = 1L;
	private CardLayout mycard;
	private Thread runThread, compilerThread;
	private File file_saved;
	private JButton button_program_input, button_compiler_res, button_program_res;
	private JButton button_compiler, button_program_run;
	
	private JPanel p1,p2;
	
	private JTextArea input_text, compiler_text, run_text;
	private JScrollPane jslp1, jslp2, jslp3;
	
	private JTextField file_name_text, main_class_name;
	
	private JLabel label1, label2;
	
	public FileWindow() {
		super("Java语言编辑器");
		button_program_input = new JButton("程序输入区(白色)");
		button_compiler_res =  new JButton("编译结果区(粉红色)");
		button_program_res = new JButton("程序运行结果区(浅蓝色)");
		button_compiler = new JButton("编译程序");
		button_program_run = new JButton("运行程序");
		
		file_name_text = new JTextField();
		main_class_name = new JTextField();
		
		label1 = new JLabel("输入编译文件名(.java):");
		label2 = new JLabel("输入应用程序主类名:");
		
		input_text = new JTextArea();
		compiler_text = new JTextArea();
		compiler_text.setBackground(Color.PINK);
		run_text = new JTextArea();
		run_text.setBackground(Color.CYAN);
		
		p1 = new JPanel();
		mycard = new CardLayout();
		p1.setLayout(mycard);
		//p1.add("input", input_text);
		//p1.add("compiler", compiler_text);
		//p1.add("run", run_text);
		jslp1 = new JScrollPane(input_text);
		jslp2 = new JScrollPane(compiler_text);
		jslp3 = new JScrollPane(run_text);
		
		jslp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jslp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		jslp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jslp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		jslp3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jslp3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		p1.add("input", jslp1);//每个界面都有滚动条，问题解决
		p1.add("compiler", jslp2);
		p1.add("run", jslp3);
		this.add(p1, BorderLayout.CENTER);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(3, 3));
		p2.add(button_program_input);
		p2.add(button_compiler_res);
		p2.add(button_program_res);
		p2.add(label1);
		p2.add(file_name_text);
		p2.add(button_compiler);
		p2.add(label2);
		p2.add(main_class_name);
		p2.add(button_program_run);
		this.add(p2, BorderLayout.NORTH);
		
		button_program_input.addActionListener(this);
		button_compiler_res.addActionListener(this);
		button_program_res.addActionListener(this);
		button_compiler.addActionListener(this);
		button_program_run.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button_program_input)
			mycard.show(p1, "input");
		else if(e.getSource() == button_compiler_res)
			mycard.show(p1, "compiler");
		else if(e.getSource() == button_program_res)
			mycard.show(p1, "run");
		else if(e.getSource() == button_program_run) {
			if(!runThread.isAlive())
			    runThread = new Thread(this, "program_run");
			try {
				runThread.start();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		else {
			if(!compilerThread.isAlive())
				compilerThread = new Thread(this, "compiler");
			try {
				compilerThread.start();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
	    }
	}
	
	public void run() {
		if(Thread.currentThread() == compilerThread) {
			compiler_text.setText(null);
			byte[] buffer = input_text.getText().trim().getBytes();
			String fileName = file_name_text.getText().trim();
			try {
				file_saved = new File(fileName);
				FileOutputStream writeFile = new FileOutputStream(file_saved);
				writeFile.write(buffer, 0, buffer.length);
				writeFile.close();
			}catch(Exception e3) {
				System.out.println("error");
			}
			try {
				Runtime rt = Runtime.getRuntime();
				InputStream in = rt.exec("javac " + fileName).getErrorStream();
				BufferedInputStream bufIn = new BufferedInputStream(in);
				byte[] b = new byte[100];
				int n = 0;
				while((n = bufIn.read(b, 0, b.length)) != -1) {
					compiler_text.append(new String(b, 0, n));
				}
				if(compiler_text.getText() != null) {
					compiler_text.append("Copiler Successed!");
				}
			}catch(Exception e4) {
		        e4.printStackTrace();
			}
		}
	}
}
