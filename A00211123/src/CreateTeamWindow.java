import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateTeamWindow extends JFrame implements ActionListener 
{

	private JLabel theTeamRank = new JLabel("Team Rank:");
	private JTextField theTeamRankField = new JTextField();
	private JLabel theTeamName = new JLabel("Team Name:");
	private JTextField theTeamNameField = new JTextField();
	private JLabel theTeamRating = new JLabel("Team Rating:");
	private JTextField theTeamRatingField = new JTextField();
	private JLabel theTeamWinrate = new JLabel("Team Winrate:");
	private JTextField theTeamWinrateField = new JTextField();
	private JLabel theTeamCurrentStreak = new JLabel("Team Current Streak:");
	private JTextField theTeamCurrentStreakField = new JTextField();
	private JLabel theTeamCountry = new JLabel("Team Country:");
	private JTextField theTeamCountryField = new JTextField();
	private JLabel theTeamMatchesPlayed = new JLabel("Team Matches Played:");
	private JTextField theTeamMatchesPlayedField = new JTextField();
	private JLabel theTeamLastMatch = new JLabel("Teams Last Match:");
	private JTextField theTeamLastMatchField = new JTextField();
	private JButton theOKButton = new JButton("Ok");
	private JButton theCloseButton = new JButton("Close");
	private TeamFactory theFactory;

	public CreateTeamWindow() 
	{
		super("Create Team Window");
		try 
		{
			getContentPane().setLayout(new GridLayout(9, 2));
			getContentPane().add(theTeamRank);
			getContentPane().add(theTeamRankField);
			getContentPane().add(theTeamName);
			getContentPane().add(theTeamNameField);
			getContentPane().add(theTeamRating);
			getContentPane().add(theTeamRatingField);
			getContentPane().add(theTeamWinrate);
			getContentPane().add(theTeamWinrateField);
			getContentPane().add(theTeamCurrentStreak);
			getContentPane().add(theTeamCurrentStreakField);
			getContentPane().add(theTeamCountry);
			getContentPane().add(theTeamCountryField);
			getContentPane().add(theTeamMatchesPlayed);
			getContentPane().add(theTeamMatchesPlayedField);
			getContentPane().add(theTeamLastMatch);
			getContentPane().add(theTeamLastMatchField);
			
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
				int aRank = Integer.parseInt(theTeamRankField.getText());
				int aRating = Integer.parseInt(theTeamRatingField.getText());
				int aWinrate= Integer.parseInt(theTeamWinrateField.getText());
				int aCurrentStreak= Integer.parseInt(theTeamCurrentStreakField.getText());
				String aTeamName= theTeamNameField.getText();
				String aCountry= theTeamCountryField.getText();
				String aMatchesPlayed= theTeamMatchesPlayedField.getText();
				String aLastMatch= theTeamLastMatchField.getText();
				
				theFactory.createTeam(aRank, aRating, aWinrate, aCurrentStreak,
						aTeamName, aCountry, aMatchesPlayed,
						aLastMatch);
				JOptionPane.showMessageDialog(new JFrame(), "Team successfully created.");
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