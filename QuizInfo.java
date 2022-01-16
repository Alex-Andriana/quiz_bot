package Quiz;


public class QuizInfo implements Comparable<QuizInfo>{
    private int index;
    private String question;
    private String answer;

    public QuizInfo(int index, String question, String answer){
        this.index = index;
        this.question = question;
        this.answer = answer;
    }

    public int getIndex() {
	    	return this.index;
	    }
	    
	    public void setIndex(int toset) {
	    	this.index = toset;
	    }
	    
	    
	public String getAnswer() {
		return this.answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestion() {
		return this.question;
	}
	
	public void setQuestion(String question) {
		this.answer = question;
	}
	
	
    @Override
    public int compareTo(QuizInfo quizInfo){
        if (this.index == quizInfo.index){
            return 0;
        }
        if (this.index > quizInfo.index){
            return 1;
        }
        else{
            return -1;
        }
    }
}

