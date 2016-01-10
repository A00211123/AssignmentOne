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

public class UpdateTeamDetailsWindow extends JFrame implements ActionListener 
{

	
	private JLabel theOldTeamName = new JLabel("Team Name to Update:");
	private JLabel theNewRank = new JLabel("New Team Rank:");
	private JLabel theNewTeamName = new JLabel("New Team Name:");
	private JLabel theNewRating = new JLabel("New Team Rating:");
	private JLabel theNewWinrate = new JLabel("New Team Winrate:");
	private JLabel theNewCurrentStreak = new JLabel("New Team CurrentStreak:");
	private JLabel theNewCountry = new JLabel("New Team Country:");
	private JLabel theNewMatchesPlayed = new JLabel("New Team MatchesPlayed:");
	private JLabel theNewLastMatch = new JLabel("New Team Last Match:");
	
	
	private JTextField theOldTeamNameField = new JTextField();
	private JTextField theNewRankField = new JTextField();
	private JTextField theNewTeamNameField = new JTextField();
	private JTextField theNewRatingField = new JTextField();
	private JTextField theNewWinrateField = new JTextField();
	private JTextField theNewCurrentStreakField = new JTextField();
	private JTextField theNewCountryField = new JTextField();
	private JTextField theNewMatchesPlayedField = new JTextField();
	private JTextField theNewLastMatchField = new JTextField();
	
	private JButton theOKButton = new JButton("Ok");
	private JButton theCloseButton = new JButton("Close");
	private TeamFactory theFactory;

	public UpdateTeamDetailsWindow() 
	{
		super("Update Team Details Window");
		try 
		{
			getContentPane().setLayout(new GridLayout(10, 2));
			
			getContentPane().add(theOldTeamName);
			getContentPane().add(theOldTeamNameField);
			getContentPane().add(theNewRank);
			getContentPane().add(theNewRankField);
			getContentPane().add(theNewTeamName);
			getContentPane().add(theNewTeamNameField);
			getContentPane().add(theNewRating);
			getContentPane().add(theNewRatingField);
			getContentPane().add(theNewWinrate);
			getContentPane().add(theNewWinrateField);
			getContentPane().add(theNewCurrentStreak);
			getContentPane().add(theNewCurrentStreakField);
			getContentPane().add(theNewCountry);
			getContentPane().add(theNewCountryField);
			getContentPane().add(theNewMatchesPlayed);
			getContentPane().add(theNewMatchesPlayedField);
			getContentPane().add(theNewLastMatch);
			getContentPane().add(theNewLastMatchField);
			
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
				String aTeamName = theOldTeamNameField.getText();
				String aNewTeamName = theNewTeamNameField.getText();
				int aNewRank = Integer.parseInt(theNewRankField.getText());
				int aNewRating = Integer.parseInt(theNewRatingField.getText());
				int aNewWinrate = Integer.parseInt(theNewWinrateField.getText());
				int aNewCurrentStreak = Integer.parseInt(theNewCurrentStreakField.getText());
				String aNewCountry = theNewCountryField.getText();
				String aNewMatchesPlayed = theNewMatchesPlayedField.getText();
				String aNewLastMatch = theNewLastMatchField.getText();
				
				FileInputStream aFileInStream = new FileInputStream("TeamBackup.ser");
				ObjectInputStream aObjectInStream = new ObjectInputStream(aFileInStream);
				HashMap<String,Team> theListOfTeams = (HashMap<String,Team>) aObjectInStream.readObject();
				aObjectInStream.close();
				
				Team aName = theListOfTeams.get(aTeamName);
				
				aName.setTeamName(aNewTeamName);
				aName.setRank(aNewRank);
				aName.setRating(aNewRating);
				aName.setWinrate(aNewWinrate);
				aName.setCurrentStreak(aNewCurrentStreak);
				aName.setCountry(aNewCountry);
				aName.setMatchesPlayed(aNewMatchesPlayed);
				aName.setLastMatch(aNewLastMatch);
				theListOfTeams.put(aNewTeamName, theListOfTeams.get(aTeamName));
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

				
				JOptionPane.showMessageDialog(new JFrame(), "Team Details:\nTeam Rank: "+aName.getRank()+"\nTeam Name: "+aName.getTeamName()+"\nTeam Rating: "+aName.getRating()+"\nTeam Winrate: "+aName.getWinrate()+"\nTeam Current Streak: "+aName.getCurrentStreak()+"\nTeam Country: "+aName.getCountry()+"\nTeam Matches Played: "+aName.getMatchesPlayed()+"\nTeams Last Match: "+aName.getLastMatch());
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