package minigames;

import java.util.Random;

import javax.swing.*; //für 2.Methode
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Randomizer_Leukozyten {
	
	JLabel label;
	
	
	 ImageIcon icon1;{
	  
	 
	icon1 = new ImageIcon("Leukozyt guckt rechts.png"); //Leukozyt 1, untere Vene, Eingang links und guckt nach rechts
	
	label = new JLabel();
	label.setBounds(0, 400, 50, 50); // hier noch die Positionen der Veneneingänge reinpacken
	label.setIcon(icon1);

	
	ImageIcon icon2;{

	icon2 = new ImageIcon("Leukozyt guckt links.png"); //Leukozyt 2, zweite Vene von unten, Eingang rechts und guckt nach links
	
	label = new JLabel();
	label.setBounds(0, 400, 50, 50); // hier noch die Positionen der Veneneingänge reinpacken
	label.setIcon(icon2);
	 
	
	ImageIcon icon3;{ 
	

	icon3 = new ImageIcon("Leukozyt guckt rechts.png"); // Leukozyt 3, dritte Vene von unten, Eingang rechts und guckt nach rechts
	
	label = new JLabel();
	label.setBounds(0, 400, 50, 50); // hier noch die Positionen der Veneneingänge reinpacken
	label.setIcon(icon3);
	
	
	ImageIcon icon4;{

	icon4 = new ImageIcon("Leukozyt guckt links.png"); //Leukozyt 4, oberste Vene, Eingang rechts, guckt nach links

	
	label = new JLabel();
	label.setBounds(0, 400, 50, 50); // hier noch die Positionen der Veneneingänge reinpacken
	label.setIcon(icon4);
	
	
	ImageIcon icon5;{
	

	icon5 = new ImageIcon("Leukozyt guckt rechts.png"); //Leukozyt 5, oberste Vene, Eingang links, guckt nach rechts
	
	label = new JLabel();
	label.setBounds(0, 400, 50, 50); // hier noch die Positionen der Veneneingänge reinpacken
	label.setIcon(icon5);}

		
		public class main {
			public static void main(String[] args) {
				Random number = new Random();
				int numbers = number.nextInt(5); //Zufällige Zahlen von 0,1,2,3,4, denn 5 Eingänge von denen Leukozyten kommen können
				
				switch(numbers) {
				 case 0:
					 label.setIcon(icon1); 
					 break;
				 case 1:
					 //...
					 break;
				 case 2:
					 //...
					 break;
				 case 3:
					 //...
					 break;
				 case 4:
					 //...
					 break;
					 
					 
					 
					 
				
				
				
	private String[] images = {"Leukozyt guckt rechts.png", "Leukozyt guckt links.png"};//aus einem Video aber iwie komisch und nicht verstanden
	
				Timer timer = new Timer (1000, new ActionListener[] {
						public void actionPerformed(ActionEvent e) {
							int n=(int)Math.floor(Math.random()*5);
							String images = images [n];
							
						}
				});

						
				
				
				
			
				
				
			}
			
		}
		
}
				
			
				
				
			
}			
				
				
				
			
		
		
		


