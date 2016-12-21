import javax.swing.*;
import java.awt.*;
public class Int extends JFrame {
    private Container pane;
    private JButton toC;
    private JLabel Celcius;
    private JTextField inputC;
    private JTextField inputF;
    private JButton toF;
    private JLabel Fahrenheit;

 
    //CONSTRUCTOR SETS EVERYTHING UP
    public Int () {
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
	toC = new JButton ("Convert to C");
	toF = new JButton ("Covert to F");
	Celcius = new JLabel ("Fahrenheit",null,JLabel.CENTER);
	t = new JTextField(12);
	c = new JCheckBox("Overclock!!!");
	pane.add(l);
	pane.add(b);
	pane.add(t);
	pane.add(c);
 }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window2 g = new Window2();
     g.setVisible(true);
  }
}

