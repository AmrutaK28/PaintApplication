/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapplication;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import paintapplication.Canvas;
/**
 *
 * @author Amruta
 */
public class Draw {
    private int width, height;
    Color color = Color.WHITE;
    JButton GREENbutton, REDbutton, BLUEbutton, BLACKbutton, ORANGEbutton, YELLOWbutton, PINKbutton, 
                        MAGENTAbutton,CYANbutton, GRAYbutton, lightGraybutton, 
			colorPicker, rectangle, pencil;
    private Icon rect = new ImageIcon("D:\\new\\SwingPaint\\src\\bin\\rect.png");
    private Icon pencilIcon = new ImageIcon("D:\\new\\SwingPaint\\src\\bin\\pencil.png");
    Canvas canvas;
    private JLabel filenameBar, thicknessStat;
    private JSlider thicknessSlider;
    ChangeListener thick = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			thicknessStat.setText(String.format("%s",
					thicknessSlider.getValue()));
			canvas.setThickness(thicknessSlider.getValue());
		}
	};
    ActionListener listener = new ActionListener() {
    public void actionPerformed(ActionEvent event) {
			if (event.getSource() == BLACKbutton) {
				canvas.BLACK();
			} else if (event.getSource() == BLUEbutton) {
				canvas.BLUE();
			} else if (event.getSource() == GREENbutton) {
				canvas.GREEN();
			} else if (event.getSource() == REDbutton) {
				canvas.RED();
			} else if (event.getSource() == ORANGEbutton) {
				canvas.ORANGE();
			} else if (event.getSource() == YELLOWbutton) {
				canvas.YELLOW();
			} else if (event.getSource() == PINKbutton) {
				canvas.PINK();
			} else if (event.getSource() == MAGENTAbutton) {
				canvas.MAGENTA();
			} else if (event.getSource() == CYANbutton) {
				canvas.CYAN();
			} else if (event.getSource() == GRAYbutton) {
				canvas.GRAY();
			} else if (event.getSource() == lightGraybutton) {
				canvas.lightGray();
			} 
                        else if (event.getSource() == rectangle) {
				canvas.rect();
			} else if (event.getSource() == pencil) {
				canvas.pencil();
			}
                        else if (event.getSource() == colorPicker) {
				color = JColorChooser.showDialog(null, "Pick your color!",
						color);
				if (color == null)
					color = (Color.WHITE);
				canvas.picker(color);
			}
            }		
    };
    public void setDimension(int width,int height){
        this.width = width;
        this.height = height;
    }
    
    public void startPaint() { 
            JFrame frame = new JFrame("Paint");
            Container container = frame.getContentPane();
            container.setLayout(new BorderLayout());
            canvas = new Canvas();
            container.add(canvas, BorderLayout.CENTER);
            frame.setVisible(true);

            frame.setSize(width+50,height+50);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		Box box = Box.createVerticalBox();
		Box box1 = Box.createHorizontalBox();

		panel1.setLayout(new FlowLayout());

		pencil = new JButton(pencilIcon);
		pencil.setPreferredSize(new Dimension(40, 40));
		pencil.addActionListener(listener);
                
		rectangle = new JButton(rect);
		rectangle.setPreferredSize(new Dimension(40, 40));
		rectangle.addActionListener(listener);
		
                thicknessSlider = new JSlider(JSlider.VERTICAL, 0, 10, 1);
		thicknessSlider.setMajorTickSpacing(25);
		thicknessSlider.setPaintTicks(true);
		thicknessSlider.setPreferredSize(new Dimension(40, 40));
		thicknessSlider.addChangeListener(thick);
		
		BLACKbutton = new JButton();
		BLACKbutton.setBackground(Color.BLACK);
		BLACKbutton.setPreferredSize(new Dimension(40, 40));
		BLACKbutton.addActionListener(listener);
                
		BLUEbutton = new JButton();
		BLUEbutton.setBackground(Color.BLUE);
		BLUEbutton.setPreferredSize(new Dimension(40, 40));
		BLUEbutton.addActionListener(listener);
                
		GREENbutton = new JButton();
		GREENbutton.setBackground(Color.GREEN);
		GREENbutton.setPreferredSize(new Dimension(40, 40));
		GREENbutton.addActionListener(listener);
                
		REDbutton = new JButton();
		REDbutton.setBackground(Color.RED);
		REDbutton.setPreferredSize(new Dimension(40, 40));
		REDbutton.addActionListener(listener);
                
		MAGENTAbutton = new JButton();
		MAGENTAbutton.setBackground(Color.MAGENTA);
		MAGENTAbutton.setPreferredSize(new Dimension(40, 40));
		MAGENTAbutton.addActionListener(listener);
                
		GRAYbutton = new JButton();
		GRAYbutton.setBackground(Color.GRAY);
		GRAYbutton.setPreferredSize(new Dimension(40, 40));
		GRAYbutton.addActionListener(listener);
                
		ORANGEbutton = new JButton();
		ORANGEbutton.setBackground(Color.ORANGE);
		ORANGEbutton.setPreferredSize(new Dimension(40, 40));
		ORANGEbutton.addActionListener(listener);
		
                YELLOWbutton = new JButton();
		YELLOWbutton.setBackground(Color.YELLOW);
		YELLOWbutton.setPreferredSize(new Dimension(40, 40));
		YELLOWbutton.addActionListener(listener);
		
                PINKbutton = new JButton();
		PINKbutton.setBackground(Color.PINK);
		PINKbutton.setPreferredSize(new Dimension(40, 40));
		PINKbutton.addActionListener(listener);
		
                CYANbutton = new JButton();
		CYANbutton.setBackground(Color.CYAN);
		CYANbutton.setPreferredSize(new Dimension(40, 40));
		CYANbutton.addActionListener(listener);
		
                lightGraybutton = new JButton();
		lightGraybutton.setBackground(Color.LIGHT_GRAY);
		lightGraybutton.setPreferredSize(new Dimension(40, 40));
		lightGraybutton.addActionListener(listener);
		
		colorPicker = new JButton("Color Picker");
		colorPicker.addActionListener(listener);
		

		filenameBar = new JLabel("");
		thicknessStat = new JLabel("1");

		box.add(Box.createVerticalStrut(10));
		box1.add(thicknessSlider, BorderLayout.NORTH);
		box1.add(thicknessStat, BorderLayout.NORTH);
		box.add(box1, BorderLayout.NORTH);
		panel1.add(filenameBar, BorderLayout.SOUTH);
		box.add(Box.createVerticalStrut(10));
		
                panel.add(lightGraybutton);
                panel.add(GRAYbutton);
                panel.add(CYANbutton);
                panel.add(PINKbutton);
                panel.add(YELLOWbutton);
                panel.add(ORANGEbutton);
		panel.add(GREENbutton);
                panel.add(BLUEbutton);
                panel.add(MAGENTAbutton);
                panel.add(REDbutton);				
                panel.add(BLACKbutton);
                      
                panel.add(colorPicker);
		
		container.add(panel, BorderLayout.NORTH);
		container.add(panel1, BorderLayout.SOUTH);
		container.add(box, BorderLayout.WEST);

		frame.setVisible(true);

		frame.setSize(width+79,height+11);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public Dimension getCanvasDimension(){
            int width, height;
            Dimension d;
            JTextField wField = new JTextField(5);
            JTextField hField = new JTextField(5);
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Height"));
            myPanel.add(hField);
            myPanel.add(new JLabel("Width"));
            myPanel.add(wField);
            d = new Dimension(800,800);
           
            int result = JOptionPane.showConfirmDialog(null, myPanel,"Enter Dimension", JOptionPane.OK_CANCEL_OPTION);
            try {
            width = Integer.parseInt(wField.getText());
            height = Integer.parseInt(hField.getText());
                        if (result == JOptionPane.OK_OPTION) {
                            if(width<800 || height <800){
                            JOptionPane.showMessageDialog(null, myPanel,"Invalid Values", JOptionPane.ERROR_MESSAGE);
                                return d;
                            }
                             d = new Dimension(Integer.parseInt(wField.getText()), Integer.parseInt(wField.getText()));
                                return d;
                        }

                   } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, myPanel,"Please enter valid number!", JOptionPane.ERROR_MESSAGE);
}
           return d;
 }
}