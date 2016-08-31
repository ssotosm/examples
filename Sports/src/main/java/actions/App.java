package actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entities.AmericanFootball;
import entities.Football;
import entities.Tennis;
import factories.SportsFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonProcessingException
    {
     
    	ObjectMapper mapper=new ObjectMapper();
    	System.out.println( "\nSports generate json object by input text: " );
     	String inputFootball = "F.C. Barcelona 3-2 Real Madrid";
    	System.out.println("\n -FOOTBALL: " + inputFootball);
   
    	SportsFactory factory = new SportsFactory();
		factory.setType(Football.class);
		Football football = (Football) factory.create();
		football.generate(inputFootball);	
    	System.out.println("\n" +mapper.writeValueAsString(football));
    	
    	String inputTennis = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko";
    	System.out.println("\n -TENNIS: " + inputTennis);
    	
    	
		factory.setType(Tennis.class);
		Tennis tennis = (Tennis) factory.create();
		tennis.generate(inputTennis);	
    	System.out.println("\n" +mapper.writeValueAsString(tennis));
    	
    	String inputAmericalFootball = "Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter";
    	System.out.println("\n -AMERICAN FOOTBALL: " + inputAmericalFootball);
    	
    
		factory.setType(AmericanFootball.class);
		AmericanFootball americanFootball = (AmericanFootball) factory.create();
		americanFootball.generate(inputAmericalFootball);	
    	System.out.println("\n" +mapper.writeValueAsString(americanFootball));
    }
}
