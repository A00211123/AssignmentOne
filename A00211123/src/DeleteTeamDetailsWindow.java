import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.*;

public class DeleteTeamDetailsWindow extends JFrame implements ActionListener 
{

	
	private JLabel theTeamName = new JLabel("Team Name:");
	private JTextField theTeamNameField = new JTextField();
	private JButton theOKButton = new JButton("Ok");
	private JButton theCloseButton = new JButton("Close");
	private TeamFactory theFactory;

	public DeleteTeamDetailsWindow() 
	{
		super("Delete Team Window");
		try 
		{
			getContentPane().setLayout(new GridLayout(2, 2));
			
			getContentPane().add(theTeamName);
			getContentPane().add(theTeamNameField);
			getContentPane().add(theCloseButton);
			getContentPane().add(theOKButton);
			theOKButton.addActionListener(this);
			theCloseButton.addActionListener(this);
			theFactory = TeamFactory.getInstance();
			setSize(300,300);
			setVisible(true);
		} 
		catch (Exception aException) 
		{
			aException.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(theOKButton))
		{
			try 
			{
				String aTeamName = theTeamNameField.getText();
				
				FileInputStream aFileInStream = new FileInputStream("TeamBackup.ser");
				ObjectInputStream aObjectInStream = new ObjectInputStream(aFileInStream);
				HashMap<String,Team> theListOfTeams = (HashMap<String,Team>) aObjectInStream.readObject();
				aObjectInStream.close();
				
				theListOfTeams.remove(aTeamName);
				
				try
			    {
			  	  FileOutputStream aFileOutStream = new FileOutputStream("TeamBackup.ser");
			  	  ObjectOutputStream aObjectOutStream = new ObjectOutputStream(aFileOutStream);
			  	  aObjectOutStream.writeObject(theListOfTeams);
			  	  aObjectOutStream.close();
			    }
			  	catch(Exception e1)
			    {
			    	  e1.printStackTrace();
			    }

				
				JOptionPane.showMessageDialog(new JFrame(), "Team Deleted!");
			} 
			catch (Exception aException) 
			{
				aException.printStackTrace();
			}
		} 
		else if (e.getSource().equals(theCloseButton)) 
		{
			dispose();
		}
	}
}