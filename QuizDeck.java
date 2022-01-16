package Quiz;

import java.io.*;
import java.util.*;


//Things to do:
// 1. Create the data objects - Nick
// 2. Create the "deck" that holds all the questions = arraylist - Nick
    // when initialize, all index = 0;
    // Index in arraylist = index field of that object
// 3. Calculating basic quiz stats - Joellyne
    // Get the user's answer, by traversing the array (arraylists are iteable)
    // If answer is the same, then point is added
    // If answer is wrong, then index is increased - Work with Aly
    // At the end of the "quiz", print # correct answers 
// 4. Creating the sorting algorithm (sorts from min to max) - aly
// 5. User interaction (all throughout code) - Alex
// 6. Fun quiz stats - Alex

public class QuizDeck{
    private ArrayList <QuizInfo> quizzes;
    
    public QuizDeck(){
        this.quizzes = new ArrayList<>();
    }

    public void addQuizInfo(QuizInfo info){
        this.quizzes.add(info);
    }
    
    static void mysorting(ArrayList<QuizInfo> quizzes) {
    	Collections.sort(quizzes);
    }

    // Calculating Basic Quiz Stats
// This function will traverse through the deck of questions and receive answers from the user
    static void quizMe(ArrayList<QuizInfo> quizzes) {
    // Create a Scanner object
    Scanner scan = new Scanner(System.in);

    // Create points variable
    int correct = 0;
    
    // Iterate through the array
    for (int i=0 ; i < quizzes.size() ; i++){
        // Print out the question to the user
        System.out.println(quizzes.get(i).getQuestion());
    
        
        // Ask user to type in their answer
        System.out.println("Your answer: ");
        String ans = scan.nextLine();
        
        // For testing purposes
        System.out.println("You entered: " + ans);
        System.out.println("Correct answer: " + quizzes.get(i).getAnswer());
        
        // For calculating # of correct responses
        // This may need to be re-evaluated during testing ****
        if (ans.equalsIgnoreCase(quizzes.get(i).getAnswer())){
        	quizzes.get(i).setIndex(quizzes.get(i).getIndex() + 1);
            correct++;
        }

     
  
    }

    // Give the user basic statistics on how well they did
    System.out.println("*****************************************");
    System.out.println("QUIZ RESULTS");
    System.out.println("     You scored: " + correct + "/" + quizzes.size());
    System.out.println("*****************************************");
    mysorting(quizzes);
}
    
    public static void addQuiz(ArrayList<QuizInfo> quizzes)
    {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Input Question: ");
    	String ans = scan.nextLine();
    	String QU = ans;
    	if(QU.equals(""))
    	{
    		System.out.println("No question");
    	}
    	else {
    	System.out.println("Input Answer: ");
    	ans = scan.nextLine();
    	String AN = ans;
    	QuizInfo newQuiz = new QuizInfo(0, QU, AN);
    	quizzes.add(newQuiz);
    	System.out.println("New Question added");
    	}
    	 
    }

//user interface
//asks for user commands
//asks question and receives answers
//display right awnswers
//display stats

static int command()
{
    
    System.out.println("Choose your next step:");
    Scanner scan = new Scanner(System.in);
    while(true)
    {
    	
        System.out.println("1.Quiz Me!\n2.Input card\n3.Exit");
        
        String command = scan.nextLine();
       
        if(command.equals("1") || command.equals("2") || command.equals("3"))
        {
        	
            return Integer.parseInt(command);
        }
        else {

        System.out.println("Invalid input, try again");}
  
    }
}

static boolean exit()
{
    

    //add things that need to be done in exit here
    //print cool stats
	return false;
}


    public static void main(String[] args){
    	
    	QuizDeck deck = new QuizDeck();
        String name;
        Scanner scan = new Scanner(System.in);
        System.out.println("*****************************************");
        System.out.println("Your name:");
         name = scan.nextLine();
        System.out.println("Hello " + name);
        System.out.println("*****************************************");
        
        
        boolean run = true;
        System.out.println("*****************************************");
        System.out.println("*****************************************");
        while(run)
        {
            int com = command();
            
            if(com == 1)
            {
            	System.out.println("You chose to get a question");
            	quizMe(deck.quizzes);
            	
            }
            else if (com == 2)
            {
            	System.out.println("You chose to add a question");
            	addQuiz(deck.quizzes);
            }

            else if (com == 3)
            {
            	System.out.println("Goodbye");
                run = exit();
            }
            
            

        }
        
        
        
}

}
