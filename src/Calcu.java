
import javax.swing.JFrame;
import javax.script.*;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;


public class Calcu {

	private JFrame frame;
	private JTextField txtS;
	private StringBuffer e= new StringBuffer();  //不写new会出错
	private StringBuffer e1= new StringBuffer();
	private double result=0.0; 
	private double m,n = 0.0; 
	ScriptEngineManager manager = new ScriptEngineManager();
	final ScriptEngine engine = manager.getEngineByName("js");
	private JTextField txtE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Calcu window = new Calcu();
		window.frame.setVisible(true);
		
	}

	/**
	 * Create the application.
	 */
	public Calcu() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		CardLayout Cardpanel = new CardLayout(0, 0);
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 20));
		frame.getContentPane().setLayout(Cardpanel);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_375686819177846");
		panel.setLayout(null);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.window);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 35));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(52, 69, 472, 123);
		panel.add(scrollPane);
				
		JButton button = new JButton("DEL");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					textArea.setText(textArea.getText().substring(0, textArea.getText().length()-1));
				    e.deleteCharAt(e.length()-1);
				    }catch(Exception e){
					
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 23));
		button.setBackground(SystemColor.menu);
		button.setBounds(249, 213, 80, 56);
		panel.add(button);
		
		JButton button_1 = new JButton("÷");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("÷");
				e.append('/');
				
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 23));
		button_1.setBackground(SystemColor.menu);
		button_1.setBounds(339, 213, 80, 56);
		panel.add(button_1);
		
		JButton button_2 = new JButton("×");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("×");
				e.append('*');
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 23));
		button_2.setBackground(SystemColor.menu);
		button_2.setBounds(429, 213, 80, 56);
		panel.add(button_2);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				e.delete(0, e.length());
				textArea.setText("");
			}
		});
		btnC.setFont(new Font("宋体", Font.PLAIN, 23));
		btnC.setBackground(SystemColor.menu);
		btnC.setBounds(159, 213, 80, 56);
		panel.add(btnC);
		
		JButton btnM_1 = new JButton("MS");
		btnM_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] lineString = textArea.getText().split("\n");
				try {
				   m = Double.valueOf(lineString[lineString.length-1]);
				}catch(Exception e){
					textArea.append("\r\n"+"Error"+"\r\n");
				}
			}
		});
		btnM_1.setFont(new Font("宋体", Font.PLAIN, 23));
		btnM_1.setBackground(SystemColor.menu);
		btnM_1.setBounds(69, 213, 80, 56);
		panel.add(btnM_1);
		
		JButton button_5 = new JButton("MC");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m = 0.0;
			}
		});
		button_5.setFont(new Font("宋体", Font.PLAIN, 23));
		button_5.setBackground(SystemColor.menu);
		button_5.setBounds(69, 293, 80, 56);
		panel.add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("7");
				e.append('7');
			}
		});
		button_6.setFont(new Font("宋体", Font.PLAIN, 23));
		button_6.setBackground(SystemColor.menu);
		button_6.setBounds(159, 293, 80, 56);
		panel.add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("8");
				e.append('8');
			}
		});
		button_7.setFont(new Font("宋体", Font.PLAIN, 23));
		button_7.setBackground(SystemColor.menu);
		button_7.setBounds(249, 293, 80, 56);
		panel.add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("9");
				e.append('9');
			}
		});
		button_8.setFont(new Font("宋体", Font.PLAIN, 23));
		button_8.setBackground(SystemColor.menu);
		button_8.setBounds(339, 293, 80, 56);
		panel.add(button_8);
		
		JButton button_9 = new JButton("-");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("-");
				e.append('-');
			}
		});
		button_9.setFont(new Font("宋体", Font.PLAIN, 23));
		button_9.setBackground(SystemColor.menu);
		button_9.setBounds(429, 293, 80, 56);
		panel.add(button_9);
		
		JButton button_10 = new JButton("+");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("+");
				e.append('+');
			}
		});
		button_10.setFont(new Font("宋体", Font.PLAIN, 23));
		button_10.setBackground(SystemColor.menu);
		button_10.setBounds(429, 374, 80, 56);
		panel.add(button_10);
		
		JButton button_11 = new JButton("6");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("6");
				e.append('6');
			}
		});
		button_11.setFont(new Font("宋体", Font.PLAIN, 23));
		button_11.setBackground(SystemColor.menu);
		button_11.setBounds(339, 374, 80, 56);
		panel.add(button_11);
		
		JButton button_12 = new JButton("5");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("5");
				e.append('5');
			}
		});
		button_12.setFont(new Font("宋体", Font.PLAIN, 23));
		button_12.setBackground(SystemColor.menu);
		button_12.setBounds(249, 374, 80, 56);
		panel.add(button_12);
		
		JButton button_13 = new JButton("4");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("4");
				e.append('4');
			}
		});
		button_13.setFont(new Font("宋体", Font.PLAIN, 23));
		button_13.setBackground(SystemColor.menu);
		button_13.setBounds(159, 374, 80, 56);
		panel.add(button_13);
		
		JButton btnM = new JButton("MR");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("\r\n"+m);
				e.delete(0, e.length());
				e.append(m);
				
			}
		});
		btnM.setFont(new Font("宋体", Font.PLAIN, 23));
		btnM.setBackground(SystemColor.menu);
		btnM.setBounds(69, 374, 80, 56);
		panel.add(btnM);
		
		JButton button_15 = new JButton("(");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("(");
				e.append('(');
			}
		});
		button_15.setFont(new Font("宋体", Font.PLAIN, 23));
		button_15.setBackground(SystemColor.menu);
		button_15.setBounds(69, 540, 80, 56);
		panel.add(button_15);
		
		JButton button_16 = new JButton("1");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("1");
				e.append('1');
			}
		});
		button_16.setFont(new Font("宋体", Font.PLAIN, 23));
		button_16.setBackground(SystemColor.menu);
		button_16.setBounds(159, 460, 80, 56);
		panel.add(button_16);
		
		JButton button_17 = new JButton("2");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("2");
				e.append('2');
			}
		});
		button_17.setFont(new Font("宋体", Font.PLAIN, 23));
		button_17.setBackground(SystemColor.menu);
		button_17.setBounds(249, 460, 80, 56);
		panel.add(button_17);
		
		JButton button_18 = new JButton("3");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("3");
				e.append('3');
			}
		});
		button_18.setFont(new Font("宋体", Font.PLAIN, 23));
		button_18.setBackground(SystemColor.menu);
		button_18.setBounds(339, 460, 80, 56);
		panel.add(button_18);
		
		JButton button_19 = new JButton(".");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append(".");
				e.append('.');
			}
		});
		button_19.setFont(new Font("宋体", Font.PLAIN, 23));
		button_19.setBackground(SystemColor.menu);
		button_19.setBounds(339, 540, 80, 56);
		panel.add(button_19);
		
		JButton button_20 = new JButton("=");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String expre = e.toString();
				try {
					/*
					Expression expression=new Expression(expre);
				    result = expression.evaluate();
				    */
					
					Object result=engine.eval(expre);
		            String str = result+"";
				    textArea.append("\r\n"+str+"\r\n");
				    e.delete(0, e.length());
				    e.append(str);
				}
				catch(Exception ex){
					textArea.append("\r\n"+"Error"+"\r\n");
					e.delete(0, e.length());
				}
	
			}
		});
		button_20.setFont(new Font("宋体", Font.PLAIN, 23));
		button_20.setBackground(SystemColor.menu);
		button_20.setBounds(429, 460, 80, 136);
		panel.add(button_20);
		
		JButton button_21 = new JButton("0");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("0");
				e.append('0');
			}
		});
		button_21.setFont(new Font("宋体", Font.PLAIN, 23));
		button_21.setBackground(SystemColor.menu);
		button_21.setBounds(249, 540, 80, 56);
		panel.add(button_21);
		
		JButton button_22 = new JButton("Mod");
		button_22.setForeground(SystemColor.controlText);
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cardpanel.show(frame.getContentPane(), "name_428622412208820");
				result = 0;			
			}
		});
		button_22.setFont(new Font("宋体", Font.PLAIN, 23));
		button_22.setBackground(Color.WHITE);
		button_22.setBounds(0, 656, 584, 55);
		panel.add(button_22);
		
		txtS = new JTextField();
		txtS.setBorder(new EmptyBorder(0,0,0,0));
		txtS.setEditable(false);
		txtS.setFont(new Font("宋体", Font.PLAIN, 20));
		txtS.setForeground(Color.DARK_GRAY);
		txtS.setBackground(SystemColor.menu);
		txtS.setText("   Simple Calculator");
		txtS.setBounds(170, 10, 236, 36);
		panel.add(txtS);
		txtS.setColumns(10);
		
		JButton button_23 = new JButton(")");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append(")");
				e.append(')');
			}
		});
		button_23.setFont(new Font("宋体", Font.PLAIN, 23));
		button_23.setBackground(SystemColor.menu);
		button_23.setBounds(159, 540, 80, 56);
		panel.add(button_23);
		
		JButton btnM_2 = new JButton("M+");
		btnM_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] lineString = textArea.getText().split("\n");
				try {
				   m = m + Double.valueOf(lineString[lineString.length-1]);
				}catch(Exception e){
					textArea.append("\r\n"+"Error"+"\r\n");
				}
			}
		});
		btnM_2.setFont(new Font("宋体", Font.PLAIN, 23));
		btnM_2.setBackground(SystemColor.menu);
		btnM_2.setBounds(69, 460, 80, 56);
		panel.add(btnM_2);
		
		
		//第一页到此结束，第二页由下面开始
		
		
		
		
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_428622412208820");
		panel_1.setLayout(null);
		
		JButton btnMod = new JButton("Mod");
		btnMod.setFont(new Font("宋体", Font.PLAIN, 23));
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cardpanel.show(frame.getContentPane(), "name_375686819177846");
			}
		});
		btnMod.setBounds(0, 656, 584, 55);
		panel_1.add(btnMod);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(SystemColor.window);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 35));
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		scrollPane_1.setBounds(52, 69, 472, 123);
		panel_1.add(scrollPane_1);
		
		JButton btnX = new JButton("x\uFF01");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					result = 1;
					int i = Integer.valueOf(e1.toString());
					for (int j = 1;j<=i;j++) {
						result = result * j;				
					}
					textArea_1.append("\r\n"+e1+"! = "+result+"\r\n");
				}catch(Exception e) {
					textArea_1.append("\r\n"+"Error");
				}
				e1.delete(0, e1.length());
				
			}
		});
		btnX.setFont(new Font("宋体", Font.PLAIN, 23));
		btnX.setBackground(SystemColor.menu);
		btnX.setBounds(183, 580, 94, 47);
		panel_1.add(btnX);
		
		JButton button_4 = new JButton("\u221A\uFFE3");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Double i = Double.valueOf(e1.toString());
					result = Math.sqrt(i);				
					textArea_1.append("\r\n"+e1+"^-1 = "+result+"\r\n");
				}catch(Exception e) {
					textArea_1.append("\r\n"+"Error");
				}
				e1.delete(0, e1.length());
			}
		});
		button_4.setFont(new Font("宋体", Font.PLAIN, 23));
		button_4.setBackground(SystemColor.menu);
		button_4.setBounds(52, 440, 94, 47);
		panel_1.add(button_4);
		
		JButton btnX_1 = new JButton("x\u00B2");
		btnX_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Double i = Double.valueOf(e1.toString());
					result = i*i;				
					textArea_1.append("\r\n"+e1+"^2 = "+result+"\r\n");
				}catch(Exception e) {
					textArea_1.append("\r\n"+"Error");
				}
				e1.delete(0, e1.length());
			}
		});
		btnX_1.setFont(new Font("宋体", Font.PLAIN, 23));
		btnX_1.setBackground(SystemColor.menu);
		btnX_1.setBounds(183, 440, 94, 47);
		panel_1.add(btnX_1);
		
		JButton btnX_2 = new JButton("x\u00B3");
		btnX_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Double i = Double.valueOf(e1.toString());
					result = i*i*i;				
					textArea_1.append("\r\n"+e1+"^3 = "+result+"\r\n");
				}catch(Exception e) {
					textArea_1.append("\r\n"+"Error");
				}
				e1.delete(0, e1.length());
			}
		});
		btnX_2.setFont(new Font("宋体", Font.PLAIN, 23));
		btnX_2.setBackground(SystemColor.menu);
		btnX_2.setBounds(316, 440, 94, 47);
		panel_1.add(btnX_2);
		
		JButton btnSin = new JButton("sinn\u00B0");
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Double i = Double.valueOf(e1.toString());
					result = Math.sin(Math.toRadians(i));				
					textArea_1.append("\r\n"+"sin"+i+"° = "+result+"\r\n");
				}catch(Exception e) {
					textArea_1.append("\r\n"+"Error");
				}
				e1.delete(0, e1.length());
			}
		});
		btnSin.setFont(new Font("宋体", Font.PLAIN, 23));
		btnSin.setBackground(SystemColor.menu);
		btnSin.setBounds(52, 509, 110, 47);
		panel_1.add(btnSin);
		
		JButton btnCos = new JButton("cosn\u00B0");
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Double i = Double.valueOf(e1.toString());
					result = Math.cos(Math.toRadians(i));				
					textArea_1.append("\r\n"+"cos"+i+"° = "+result+"\r\n");
				}catch(Exception e) {
					textArea_1.append("\r\n"+"Error");
				}
				e1.delete(0, e1.length());
			}
		});
		btnCos.setFont(new Font("宋体", Font.PLAIN, 23));
		btnCos.setBackground(SystemColor.menu);
		btnCos.setBounds(183, 509, 110, 47);
		panel_1.add(btnCos);
		
		JButton btnTan = new JButton("tann\u00B0");
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Double i = Double.valueOf(e1.toString());
					result = Math.tan(Math.toRadians(i));				
					textArea_1.append("\r\n"+"sin"+i+"° = "+result+"\r\n");
				}catch(Exception e) {
					textArea_1.append("\r\n"+"Error");
				}
				e1.delete(0, e1.length());
			}
		});
		btnTan.setFont(new Font("宋体", Font.PLAIN, 23));
		btnTan.setBackground(SystemColor.menu);
		btnTan.setBounds(316, 509, 110, 47);
		panel_1.add(btnTan);
		
		JButton btnXn = new JButton("x^n");
		btnXn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				BigDecimal data1 = new BigDecimal(n); 
				BigDecimal data2 = new BigDecimal(0.0); 				
				if (data1.compareTo(data2)==0) {
					textArea_1.append(" Please n :");
				    n = Double.valueOf(e1.toString());
				    e1.delete(0, e1.length());
				}else{
					Double i = Double.valueOf(e1.toString());
					result = Math.pow(n, i);
					textArea_1.append("\r\n"+n+"^"+i+" = "+result);
					e1.delete(0, e1.length());
					n=0.0;
				}
				}catch(Exception e) {
					textArea_1.append("\r\n"+"Error");
					e1.delete(0, e1.length());
					n=0.0;
				}
			}
		});
		btnXn.setFont(new Font("宋体", Font.PLAIN, 23));
		btnXn.setBackground(SystemColor.menu);
		btnXn.setBounds(442, 440, 94, 47);
		panel_1.add(btnXn);
		
		JButton btnLn = new JButton("ln");
		btnLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Double i = Double.valueOf(e1.toString());
				    result = Math.log(i);
				}catch(Exception e) {
					textArea_1.append("\r\n"+"Error");
				    e1.delete(0, e1.length());
			}
				}
		});
		btnLn.setFont(new Font("宋体", Font.PLAIN, 23));
		btnLn.setBackground(SystemColor.menu);
		btnLn.setBounds(52, 580, 94, 47);
		panel_1.add(btnLn);
		
		JButton btnEvaluate = new JButton("Clc");
		btnEvaluate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				e1.delete(0, e.length());
				textArea_1.setText("");
			}
		});
		btnEvaluate.setFont(new Font("宋体", Font.PLAIN, 23));
		btnEvaluate.setBackground(SystemColor.menu);
		btnEvaluate.setBounds(316, 580, 220, 47);
		panel_1.add(btnEvaluate);
		
		JButton button_32 = new JButton("7");
		button_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.append("7");
				e1.append('7');
			}
		});
		button_32.setFont(new Font("宋体", Font.PLAIN, 23));
		button_32.setBackground(SystemColor.menu);
		button_32.setBounds(52, 228, 80, 56);
		panel_1.add(button_32);
		
		JButton button_33 = new JButton("8");
		button_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.append("8");
				e1.append('8');
			}
		});
		button_33.setFont(new Font("宋体", Font.PLAIN, 23));
		button_33.setBackground(SystemColor.menu);
		button_33.setBounds(142, 228, 80, 56);
		panel_1.add(button_33);
		
		JButton button_34 = new JButton("9");
		button_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.append("9");
				e1.append('9');
			}
		});
		button_34.setFont(new Font("宋体", Font.PLAIN, 23));
		button_34.setBackground(SystemColor.menu);
		button_34.setBounds(232, 228, 80, 56);
		panel_1.add(button_34);
		
		JButton button_35 = new JButton("6");
		button_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.append("6");
				e1.append('6');
			}
		});
		button_35.setFont(new Font("宋体", Font.PLAIN, 23));
		button_35.setBackground(SystemColor.menu);
		button_35.setBounds(232, 294, 80, 56);
		panel_1.add(button_35);
		
		JButton button_36 = new JButton("5");
		button_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.append("5");
				e1.append('5');
			}
		});
		button_36.setFont(new Font("宋体", Font.PLAIN, 23));
		button_36.setBackground(SystemColor.menu);
		button_36.setBounds(142, 294, 80, 56);
		panel_1.add(button_36);
		
		JButton button_37 = new JButton("4");
		button_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.append("4");
				e1.append('4');
			}
		});
		button_37.setFont(new Font("宋体", Font.PLAIN, 23));
		button_37.setBackground(SystemColor.menu);
		button_37.setBounds(52, 294, 80, 56);
		panel_1.add(button_37);
		
		JButton button_38 = new JButton("1");
		button_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.append("1");
				e1.append('1');
			}
		});
		button_38.setFont(new Font("宋体", Font.PLAIN, 23));
		button_38.setBackground(SystemColor.menu);
		button_38.setBounds(52, 360, 80, 56);
		panel_1.add(button_38);
		
		JButton button_39 = new JButton("2");
		button_39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.append("2");
				e1.append('2');
			}
		});
		button_39.setFont(new Font("宋体", Font.PLAIN, 23));
		button_39.setBackground(SystemColor.menu);
		button_39.setBounds(142, 360, 80, 56);
		panel_1.add(button_39);
		
		JButton button_40 = new JButton("3");
		button_40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.append("3");
				e1.append('3');
			}
		});
		button_40.setFont(new Font("宋体", Font.PLAIN, 23));
		button_40.setBackground(SystemColor.menu);
		button_40.setBounds(232, 360, 80, 56);
		panel_1.add(button_40);
		
		JButton button_41 = new JButton("0");
		button_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.append("0");
				e1.append('0');
			}
		});
		button_41.setFont(new Font("宋体", Font.PLAIN, 23));
		button_41.setBackground(SystemColor.menu);
		button_41.setBounds(322, 294, 80, 122);
		panel_1.add(button_41);
		
		JButton button_42 = new JButton(".");
		button_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.append(".");
				e1.append('.');
			}
		});
		button_42.setFont(new Font("宋体", Font.PLAIN, 23));
		button_42.setBackground(SystemColor.menu);
		button_42.setBounds(322, 228, 80, 56);
		panel_1.add(button_42);
		
		txtE = new JTextField();
		txtE.setText("       Evaluate");
		txtE.setForeground(Color.DARK_GRAY);
		txtE.setFont(new Font("宋体", Font.PLAIN, 20));
		txtE.setEditable(false);
		txtE.setColumns(10);
		txtE.setBorder(new EmptyBorder(0,0,0,0));
		txtE.setBackground(SystemColor.menu);
		txtE.setBounds(167, 23, 236, 36);
		panel_1.add(txtE);
		
		JButton button_3 = new JButton("DEL");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{textArea_1.setText(textArea_1.getText().substring(0, textArea_1.getText().length()-1));
				e1.deleteCharAt(e1.length()-1);}catch(Exception e) {
					textArea_1.append("\r\n");
				    e1.delete(0, e1.length());
				}
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 23));
		button_3.setBackground(SystemColor.menu);
		button_3.setBounds(445, 509, 91, 47);
		panel_1.add(button_3);
		
		

		frame.setBounds(50, 50, 600, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
