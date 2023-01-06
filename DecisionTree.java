
import java.io.*;

public class DecisionTree {

    private class BinaryTree {
    
	
	private int     theNodeId;
    	private String  myQuestionOrAnswer = null;
    	private BinaryTree yesChoice  = null;
    	private BinaryTree noChoice   = null;
	
	
	public BinaryTree(int theNewId, String myNewQuestionAnswer) {
	    theNodeId     = theNewId;
	    myQuestionOrAnswer = myNewQuestionAnswer;
            }
	}



    static BufferedReader    br = new
                           BufferedReader(new InputStreamReader(System.in));
    BinaryTree root = null;


    public DecisionTree() {
    	
	}


    public void makeTreeRoot(int idNewOne, String theNewQuestionAnswer) {
	root = new BinaryTree(idNewOne,theNewQuestionAnswer);	
	
	}
			

    public void additionOfYesChoiceNode(int idExisting, int idNewOne, String theNewQuestionAnswer) {
	
	if (root == null) {
	    System.out.println("We did not see root node of the tree");
	    return;
	    }
	
	
	if (searchTreeAndAddYesNode(root,idExisting,idNewOne,theNewQuestionAnswer)) {
	   
	    }
	else System.out.println("Node " + idExisting + " not found");
	}


    private boolean searchTreeAndAddYesNode(BinaryTree currentNodeLeaf,
    			int idExisting, int idNewOne, String theNewQuestionAnswer) {
    	if (currentNodeLeaf.theNodeId == idExisting) {
	    // Found node
	    if (currentNodeLeaf.yesChoice == null) currentNodeLeaf.yesChoice = new
	    		BinaryTree(idNewOne,theNewQuestionAnswer);
	    else {
	       System.out.println("Dont over write " + "(id = " + currentNodeLeaf.yesChoice.theNodeId +") linked to yes branch of node " +idExisting);
	        currentNodeLeaf.yesChoice = new BinaryTree(idNewOne,theNewQuestionAnswer);
		}		
    	    return(true);
	    }

    	else 
    	{

	    if (currentNodeLeaf.yesChoice != null) { 	
	        if (searchTreeAndAddYesNode(currentNodeLeaf.yesChoice,
		        	idExisting,idNewOne,theNewQuestionAnswer)) {    	
	            return(true);
		    }	
		else {
    	
	    	    if (currentNodeLeaf.noChoice != null) {
    	    		return(searchTreeAndAddYesNode(currentNodeLeaf.noChoice,
				idExisting,idNewOne,theNewQuestionAnswer));
			}
		    else return(false);	
		    }
    		}
	    return(false);	
	    }
}
    		

    public void additionOfNoChoiceBranch(int idExisting, int idNewOne, String theNewQuestionAnswer) {
	
	
	if (root == null) {
	    System.out.println("We did not see the root");
	    return;
	    }
	
	
	if (additionOfNoChoiceBranchAfterSearch(root,idExisting,idNewOne,theNewQuestionAnswer)) {
	    
	    }
	
	}
	

    private boolean additionOfNoChoiceBranchAfterSearch(BinaryTree currentNodeLeaf,
    			int idExisting, int idNewOne, String theNewQuestionAnswer) {
    	if (currentNodeLeaf.theNodeId == idExisting) {
    		
	    if (currentNodeLeaf.noChoice == null) currentNodeLeaf.noChoice = new
	    		BinaryTree(idNewOne,theNewQuestionAnswer);
	    else {
	        System.out.println("Dont over ride Node " +
			"(id = " + currentNodeLeaf.noChoice.theNodeId +
			") linked to yes branch of node " +
			idExisting);
		currentNodeLeaf.noChoice = new BinaryTree(idNewOne,theNewQuestionAnswer);
		}		
    	    return(true);
	    }
	else {

	    if (currentNodeLeaf.yesChoice != null) { 	
	        if (additionOfNoChoiceBranchAfterSearch(currentNodeLeaf.yesChoice,
		        	idExisting,idNewOne,theNewQuestionAnswer)) {    	
	            return(true);
		    }	
		else {
    	     
	    	    if (currentNodeLeaf.noChoice != null) {
    	    		return(additionOfNoChoiceBranchAfterSearch(currentNodeLeaf.noChoice,
				idExisting,idNewOne,theNewQuestionAnswer));
			}
		    else return(false);	
		    }
		 }
	    else return(false);	
	    }
   	} 	

    public void queryBinaryTree() throws IOException {
        queryBinaryTree(root);
        }

    private void queryBinaryTree(BinaryTree currentNodeLeaf) throws IOException {


        if (currentNodeLeaf.yesChoice==null) {
            if (currentNodeLeaf.noChoice==null) System.out.println(currentNodeLeaf.myQuestionOrAnswer);
            else System.out.println("Error: Missing \"Yes\" branch at \"" +
            		currentNodeLeaf.myQuestionOrAnswer + "\" question");
            return;
            }
        if (currentNodeLeaf.noChoice==null) {
            System.out.println("Error: Missing \"No\" branch at \"" +
            		currentNodeLeaf.myQuestionOrAnswer + "\" question");
            return;
            }

        // Question

        askQuestion(currentNodeLeaf);
        }

    private void askQuestion(BinaryTree currentNodeLeaf) throws IOException {
        System.out.println(currentNodeLeaf.myQuestionOrAnswer + " (enter \"Yes\" or \"No\")");
        String answer = br.readLine();
        if (answer.equals("Yes")) queryBinaryTree(currentNodeLeaf.yesChoice);
        else {
            if (answer.equals("No")) queryBinaryTree(currentNodeLeaf.noChoice);
            else {
                System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
                askQuestion(currentNodeLeaf);
                }
            }
        }


   
    }