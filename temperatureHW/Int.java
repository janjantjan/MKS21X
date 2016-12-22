import javax.swing.*;
import java.awt.*;
public class Int extends JFrame {
    private Container pane;
    private JButton toC;
    private JButton toF;
    private JLabel Fahrenheit;
    private JLabel Celcius;
    private JTextField inputC;
    private JTextField inputF;
   
    //CONSTRUCTOR SETS EVERYTHING UP
    public Int () {
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
	toC = new JButton ("Convert to C");
	Fahrenheit = new JLabel ("Fahrenheit",null,JLabel.CENTER);
	inputF = new JTextField(12);
	toF = new JButton ("Covert to F");
	Celcius = new JLabel ("Celcius",null,JLabel.CENTER);
        inputC = new JTextField(12);
	
	pane.add(toC);
	pane.add(toF);
	pane.add(Celcius);
	pane.add(Fahrenheit);
	pane.add(inputC);
	pane.add(inputF);

 }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Int g = new Int();
     g.setVisible(true);
  }
}

