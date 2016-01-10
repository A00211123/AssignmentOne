import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class TeamFactory 
{
		private static TeamFactory theInstance=null;
		private HashMap<String,Team> theListOfTeams = new HashMap<String,Team>();

		private TeamFactory()
		{
			System.out.println("Constructor for factory has been called");
			try
			{
				FileInputStream aFileInStream = new FileInputStream("TeamBackup.ser");
				ObjectInputStream aObjectInStream = new ObjectInputStream(aFileInStream);
				theListOfTeams = (HashMap<String,Team>) aObjectInStream.readObject();
				aObjectInStream.close();
			}
			catch(java.io.FileNotFoundException e){
				
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static TeamFactory getInstance()
		{
			if(theInstance == null)
			{
				theInstance = new TeamFactory();
				return theInstance;
			}
			else
			{
				System.out.println("The factory does already exist");
				return theInstance;
			}
		}
		
		public void createTeam(int aRank, int aRating, int aWinrate, int aCurrentStreak,
				String aTeamName, String aCountry, String aMatchesPlayed,
				String aLastMatch)
		{
		    System.out.println("Creating a Team called "+aTeamName);
		    Team aTeamRef = new Team(aRank, aRating, aWinrate, aCurrentStreak,
					aTeamName, aCountry, aMatchesPlayed,
					aLastMatch);
		    theListOfTeams.put(aTeamName, aTeamRef);
		    
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


		}
		
		public Team readTeam(String aName)
		{
			return theListOfTeams.get(aName);	
		}

	


}