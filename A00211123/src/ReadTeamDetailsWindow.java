import java.awt.event.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadTeamDetailsWindow extends JFrame implements ActionListener 
{

	
	private JLabel theTeamName = new JLabel("Team Name:");
	private JTextField theTeamNameField = new JTextField();
	private JButton theOKButton = new JButton("Ok");
	private JButton theCloseButton = new JButton("Close");
	private TeamFactory theFactory;

	public ReadTeamDetailsWindow() 
	{
		super("Read Team Details Window");
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
				
				Team aName = theListOfTeams.get(aTeamName);
				JOptionPane.showMessageDialog(new JFrame(), "Team Details:\nTeam Rank: "+aName.getRank()+"\nTeam Name: "+aName.getTeamName()+"\nTeam Rating: "+aName.getRating()+"\nTeam Winrate: "+aName.getWinrate()+"\nTeam Current Streak: "+aName.getCurrentStreak()+"\nTeam Country: "+aName.getCountry()+"\nTeam Matches Played: "+aName.getMatchesPlayed()+"\nTeams Last Match: "+aName.getLastMatch());
			} 
			catch (Exception aException) 
			{
				JOptionPane.showMessageDialog(new JFrame(), "Team not found!");
			}
		} 
		else if (e.getSource().equals(theCloseButton)) 
		{
			dispose();
		}
	}
}