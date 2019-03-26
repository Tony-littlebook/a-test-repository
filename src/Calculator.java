import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
public class Calculator extends JFrame implements ActionListener{
	private JTextField result_TextField;
	private JButton button_0, button_1, button_2, button_3, button_4;
	private JButton button_5, button_6, button_7, button_8, button_9;
	private JButton button_Point;
	
	private JButton button_Clear, button_Add, button_Dec;
	private JButton button_Mul, button_Divi, button_Equal;
	private JPanel pan1, pan2;
	private String operatorType = "";//运算符类型
	private double res = 0.0;//存储运算中间结果
	private boolean isFirstDig = true, isSameDig = true;//是否第一个数：控制中间结果，是否同一数：控制数字输入连接
	Calculator(){
	    super();
	    this.setBounds(400, 300, 310, 210);
	    this.setResizable(false);//设置不可改变显示框大小
	    this.setTitle("Calculator");
	    this.setLayout(new BorderLayout());
	    
            result_TextField = new JTextField("", 20);
	     
	    button_0 = new JButton("0");
	    button_1 = new JButton("1");
	    button_2 = new JButton("2");
	    button_3 = new JButton("3");
	    button_4 = new JButton("4");
	    button_5 = new JButton("5");
	    button_6 = new JButton("6");
	    button_7 = new JButton("7");
	    button_8 = new JButton("8");
	    button_9 = new JButton("9");
	    
	    button_Point = new JButton(".");
	    
	    button_Add = new JButton("+");
	    button_Dec = new JButton("-");
	    button_Mul = new JButton("*");
	    button_Divi = new JButton("/");
	    button_Clear = new JButton("Clear");
	    button_Equal = new JButton("=");
	    
	    button_0.addActionListener(this);
	    button_1.addActionListener(this);
	    button_2.addActionListener(this);
	    button_3.addActionListener(this);
	    button_4.addActionListener(this);
	    button_5.addActionListener(this);
	    button_6.addActionListener(this);
	    button_7.addActionListener(this);
	    button_8.addActionListener(this);
	    button_9.addActionListener(this);
	    button_Clear.addActionListener(this);
	    button_Point.addActionListener(this);
	    button_Add.addActionListener(this);
	    button_Dec.addActionListener(this);
	    button_Mul.addActionListener(this);
	    button_Divi.addActionListener(this);
	    button_Equal.addActionListener(this);
	    
	    
	    pan1 = new JPanel();
	    pan1.setLayout(new GridLayout(4, 4, 5, 5));
	    
	    pan1.add(button_7);
	    pan1.add(button_8);
	    pan1.add(button_9);
	    pan1.add(button_Divi);
	    pan1.add(button_4);
	    pan1.add(button_5);
	    pan1.add(button_6);
	    pan1.add(button_Mul);
	    pan1.add(button_1);
	    pan1.add(button_2);
	    pan1.add(button_3);
	    pan1.add(button_Dec);
	    pan1.add(button_0);
	    pan1.add(button_Point);
	    pan1.add(button_Equal);
	    pan1.add(button_Add);
	    
	    pan1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    
	    pan2 = new JPanel();
	    pan2.setLayout(new BorderLayout());
	    pan2.add(result_TextField, BorderLayout.WEST);
	    pan2.add(button_Clear, BorderLayout.EAST);
	    
	    this.add(pan2, BorderLayout.NORTH);
	    this.add(pan1, BorderLayout.SOUTH);
	    result_TextField.setText("0");
	};
	
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		if("0123456789.".indexOf(label) >= 0)
                handleDigit(label);
		else
		    handleOperator(label);
	}
	
	private void handleDigit(String label) {
		if(!isSameDig)//不是同一数，先将文本编辑栏的内容置零
			result_TextField.setText("0");
		String text = result_TextField.getText();
		if(text.equals("0"))
			result_TextField.setText(label); 
		else {
		    if(!label.equals("."))
			    result_TextField.setText(text + label); 
		    else if(!text.contains("."))//小数点不可多次输入
			    result_TextField.setText(text + ".");
		}
		isSameDig = true;
	}
	
	private void handleOperator(String label) {
		isSameDig = false;//每进行一次运算符输入操作，应将isSameDig置为false
		String text = result_TextField.getText();
		if(isFirstDig) {
			res = Double.valueOf(text);//是第一个操作数，则将中间结果设为第一个操作数
			isFirstDig = false;
		}
		else{//否则应计算之前运算的中间结果存储于res中
			if(operatorType.equals("+")) 
			    res += Double.valueOf(text);
			else if(operatorType.equals("-"))
				res -= Double.valueOf(text);
			else if(operatorType.equals("*"))
			    res *= Double.valueOf(text);
			else if(operatorType.equals("/")) {
				if(Double.valueOf(text)== 0.0) {
					result_TextField.setText("除数不能为0！");
					isFirstDig = true;
					return;
				}
				else
					res /= Double.valueOf(text);
			}
		}
		if(label.equals("=")) {
			result_TextField.setText(String.valueOf(res));
			isFirstDig = true;
		}
		else if(label.equals("Clear")) {
        	        result_TextField.setText("0");
        	        isFirstDig = true;
                }
                else{//每次输入运算符也显示中间结果在文本编辑栏
        	        result_TextField.setText(String.valueOf(res));
        	        operatorType = label;
                }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator myCalculator = new Calculator();
		myCalculator.setVisible(true);
		myCalculator.setDefaultCloseOperation(EXIT_ON_CLOSE);;
	}   
}
