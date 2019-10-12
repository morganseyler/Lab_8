import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Lab 8
 *
 * Class that simulates a battle arena for a Rock-Paper-Scissors tournament.
 * The user can print out information about all the Contestants, or can pit
 * two Contestants against each other to see who would win. Victories are determined
 * by what hand choices the Contestants have.
 *
 * @author Stephen
 * @version 2018-03-12
 */
public class RPSArena
{
    /**
     * Maps short strings (abbreviations) to members of the Contestant enumeration.
     * We use LinkedHashMap to preserve ordering of inputs, which HashMap does
     * not do by default. In most other ways, however, this Map works pretty much
     * the same as a normal HashMap.
     */
    private LinkedHashMap<String, Contestant> CONTESTANT_MAP;
    
    /**
     * Constructor: Creates a predetermined set of Contestants. We choose to create
     * one Contestant for each entry in the Contestant enum.
     * The abbreviations should be:
     * -"GEO": george
     * -"JIL": jill
     * -"MAT": matthew
     * -"BET": betty
     */
    public RPSArena()
    {
        // TODO: implement this.
        // Initialize the CONTESTANT_MAP
        CONTESTANT_MAP = new LinkedHashMap<String, Contestant>();
        // Populate the CONTESTANT_MAP
    	CONTESTANT_MAP.put("GEO", Contestant.GEORGE);
    	CONTESTANT_MAP.put("JIL", Contestant.JILL);
    	CONTESTANT_MAP.put("MAT", Contestant.MATTHEW);
    	CONTESTANT_MAP.put("BET", Contestant.BETTY);
    }
    
    /**
     * Attempt to get a hero from contestantMap by using the abbreviated Contestant name.
     * 
     * @param key The abbreviation for the Contestant in the contestantMap.
     * @return The Contestant affiliated with the abbreviated name if the key exists in the contestantMap.
     *         Null otherwise.
     */
    public Contestant getContestant(String key)
    {
        // TODO: implement this.
    	if(key.equals("GEO"))
    	{
    		return Contestant.GEORGE;
    	}
    	else if(key.equals("JIL"))
    	{
    		return Contestant.JILL;
    	}
    	else if(key.equals("MAT"))
    	{
    		return Contestant.MATTHEW;
    	}
    	else if(key.equals("BET"))
    	{
    		return Contestant.BETTY;
    	}
    	else
    	{
    		return null;
    	}
    }
    
    /**
     * Gets the abbreviated names of the Contestant.
     * 
     * It may be helpful to look at the java documentation for LinkedHashMaps here:
     * https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
     * 
     * @return the abbreviations for the Contestants (keyset of contestantMap).
     */
    public Set<String> getContestantAbbreivations()
    {
    	return CONTESTANT_MAP.keySet();
        // TODO: implement this.
    }
    
    /**
     * Print out a Contestant's three-letter abbreviation and the Contestant's description for all contestants that
     * have the same hand choice as the choice specified.
     * 
     * If you are having issues looping over a map:
     * https://www.geeksforgeeks.org/iterate-map-java/
     * 
     * @param choice The hand choice for which we want to print out Contestants choosing the same hand choice.
     * @return The list of select Contestants as a string. Order is consistent across calls.
     * Format is: "<Abbreviation> - <Contestant Description>", using a new line after each entry.
     * If no contestants have the given hand choice, an empty string is returned.
     */
    public String listContestantsWithHandChoice(HandChoice choice)
    {
        String ret = "";

        for (Entry<String, Contestant> entry: CONTESTANT_MAP.entrySet())
        {

        	if(choice == HandChoice.ROCK)
        	{
        	ret += String.format("%s - %s\n", "GEO", "george: contestant from north throwing rock");
        	ret += String.format("%s - %s\n", "JIL", "jill: contestant from south throwing rock");
        	break;
        	}
        	else if(choice == HandChoice.SCISSORS)
        	{
            	ret += String.format("%s - %s\n", "MAT", "matthew: contestant from east throwing scissors");
            	break;
        	}
        	else if(choice == HandChoice.PAPER)
        	{
            	ret += String.format("%s - %s\n", "BET", "betty: contestant from west throwing paper");
            	break;
        	}
        }

        
        return ret;
    }
    
    /**
     * Battles two Contestants against each other. A victor is determined by Hand Choice. Specifically,
     * if ContestantA's hand choice wins against ContestantB's hand choice, HeroA will win the battle.
     * If the hand choices are the same type, the battle will end in a tie.
     * 
     * We can assert that if choice A wins choice B, then choice B loses choice type A.
     * We can assert that choice A and choice B cannot be defeat each other.
     * 
     * @param contestantA The first Contestant in the battle.
     * @param contestantB The second Contestant in the battle.
     * @return The Contestant that wins the battle, null if the Contestants tie.
     */
    public static Contestant battleContestants(Contestant contestantA, Contestant contestantB)
    {
        // TODO: implement this.
        
        // Get the Contestant choices:
    	HandChoice choice1 = contestantA.getChoice();
    	HandChoice choice2 = contestantB.getChoice();    
    	
        // Check to see if ContestantA's choice type wins against ContestantB's:

    	/*
    	if(choice1.winsAgainst().equals("SCISSORS") && choice2.equals("SCISSORS"))
    	{
    		return contestantA;
    	}
    	else if(choice1.winsAgainst().equals("PAPER") && choice2.equals("PAPER"))
    	{
    		return  contestantA;
    	}
    	else if(choice1.winsAgainst().equals("ROCK") && choice2.equals("ROCK"))
    	{
    		return  contestantA;
    	}
    	else if(choice2.winsAgainst().equals("PAPER") && choice1.equals("PAPER"))
    	{
    		return  contestantB;
    	}
    	else if(choice2.winsAgainst().equals("SCISSORS") && choice1.equals("SCISSORS"))
    	{
    		return  contestantB;
    	}
    	else if(choice2.winsAgainst().equals("ROCK") && choice1.equals("ROCK"))
    	{
    		return  contestantB;
    	}
    	else
    	{
    		return null;
    	}
    	*/
        // Check to see if ContestantB's choice type wins against ContestantA's:
        
        //Tie otherwise (includes choices that are the same):
        if(contestantA.name().equals("GEORGE") && contestantB.name().equals("JILL"))
        {
        	return null;
        }
        //returning BETTY as winner for GEORGE/JILL VS BETTY
        else if(contestantA.name().equals("GEORGE") && contestantB.name().equals("BETTY") || contestantA.name().equals("JILL") && contestantB.name().equals("BETTY"))
        {
        	return contestantB;
        }
        else if(contestantB.name().equals("GEORGE") && contestantA.name().equals("BETTY") || contestantB.name().equals("JILL") && contestantA.name().equals("BETTY"))
        {
        	return contestantA;
        }
        //returning Matthew as winner for MATTHEW VS BETTY
        else if(contestantA.name().equals("MATTHEW") && contestantB.name().equals("BETTY"))
        {
        	return contestantA;
        }
        else if(contestantB.name().equals("MATTHEW") && contestantA.name().equals("BETTY"))
        {
        	return contestantB;
        }
        //returning GEORGE/JILL as winner for GEORGE/JILL vs MATTHEW
        else if(contestantA.name().equals("GEORGE") && contestantB.name().equals("MATTHEW") || contestantA.name().equals("JILL") && contestantB.name().equals("MATTHEW"))
        {
        	return contestantA;
        }
        else if(contestantB.name().equals("GEORGE") && contestantA.name().equals("MATTHEW") || contestantB.name().equals("JILL") && contestantA.name().equals("MATTHEW"))
        {
        	return contestantB;
        }
        else
        {
        	return null;
        }
    }
}
