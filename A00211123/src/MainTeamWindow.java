import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainTeamWindow extends JFrame implements ActionListener
{
	
	private JButton theCreateWindowButton = new JButton("Create Team");
	private JButton theReadWindowButton = new JButton("Read Team Details");
	private JButton theUpdateWindowButton = new JButton("Update Team Details");
	private JButton theDeleteWindowButton = new JButton("Delete a Team");
	private JButton theCloseButton = new JButton("Exit");
	
	public MainTeamWindow()
	{
		super("MainTeam Window");
		getContentPane().setLayout(new GridLayout(3,1));
		getContentPane().add(theCreateWindowButton);
		getContentPane().add(theReadWindowButton);
		getContentPane().add(theUpdateWindowButton);
		getContentPane().add(theDeleteWindowButton);
		getContentPane().add(theCloseButton);
		
		theCreateWindowButton.addActionListener(this);
		theReadWindowButton.addActionListener(this);
		theUpdateWindowButton.addActionListener(this);
		theDeleteWindowButton.addActionListener(this);
		theCloseButton.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);	
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(theCreateWindowButton))
		{
			new CreateTeamWindow();	
			
		}
		
		else if(e.getSource().equals(theReadWindowButton))
		{
			new ReadTeamDetailsWindow();	
			
		}
		
		else if(e.getSource().equals(theUpdateWindowButton))
		{
			new UpdateTeamDetailsWindow();	
			
		}
		else if(e.getSource().equals(theDeleteWindowButton))
		{
			new DeleteTeamDetailsWindow();	
			
		}
		else{
			System.exit(0);
		}
		
		
		
	}
	
	

}