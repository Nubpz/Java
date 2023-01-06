import java.io.*;

public class DecisionTreeTest {

    static BufferedReader br = new
                           BufferedReader(new InputStreamReader(System.in));
    static DecisionTree testTree;


    public static void main(String[] args) throws IOException {


        testTree = new DecisionTree();


        makeTree();

        getTree();
        }


    static void makeTree() {
      
        testTree.makeTreeRoot(1,"What type of Animal? Yes for Carnivorous and No for Herbivorous");
        testTree.additionOfYesChoiceNode(1,2,"Is the animal carnivorous?");
        testTree.additionOfNoChoiceBranch(1,3,"Is the animal harbivorous?");
        testTree.additionOfYesChoiceNode(2,4,"Is the animal domestic?");
        testTree.additionOfNoChoiceBranch(2,5,"Is the animal Non-domestic?");
        testTree.additionOfYesChoiceNode(3,6,"Does animal mews as sound?");
        testTree.additionOfNoChoiceBranch(3,7,"Does the animal chew cult?");
        testTree.additionOfYesChoiceNode(4,8,"Does the animal have stripes?");
        testTree.additionOfNoChoiceBranch(4,9,"Does the animal provide us meat?");
        testTree.additionOfYesChoiceNode(5,10,"Does the animal provide security at homes?");
        testTree.additionOfNoChoiceBranch(5,11,"Does the animal assist in home labour?");
        testTree.additionOfYesChoiceNode(6,12,"Does the animal feed by browsing?");
        testTree.additionOfNoChoiceBranch(6,13,"Does the animal give birth to more than one little one?");
        testTree.additionOfYesChoiceNode(7,14,"Does the animal give milk?");
        testTree.additionOfNoChoiceBranch(7,15,"Is the animal among the big Five?");
        testTree.additionOfYesChoiceNode(8,16,"it is a dog");
        testTree.additionOfNoChoiceBranch(8,17,"it is a lion");
        testTree.additionOfYesChoiceNode(9,18,"it is a zebra");
        testTree.additionOfNoChoiceBranch(9,19,"it is a leopard");
        testTree.additionOfYesChoiceNode(10,20,"it is a goat");
        testTree.additionOfNoChoiceBranch(10,21,"it is a donkey");
        testTree.additionOfYesChoiceNode(11,22,"it is a cheetah");
        testTree.additionOfNoChoiceBranch(11,23,"No animal");
        testTree.additionOfYesChoiceNode(12,24,"No animal");
        testTree.additionOfNoChoiceBranch(12,25,"no animal");
        testTree.additionOfYesChoiceNode(13,26,"No animal");
        testTree.additionOfNoChoiceBranch(13,27,"It is elephant");
        testTree.additionOfYesChoiceNode(14,28,"it is a rhino");
        testTree.additionOfNoChoiceBranch(14,29,"No animal");
        testTree.additionOfYesChoiceNode(15,30,"No animal");
        testTree.additionOfNoChoiceBranch(15,31,"No animal");
        
        }
	
    static void getTree() throws IOException {
        System.out.println("\nQUERY DECISION TREE");
        System.out.println("===================");
        testTree.queryBinaryTree();
        exitCode();
        }

    static void exitCode() throws IOException {
        System.out.println("Quit? (enter \"Yes\" or \"No\")");
        String correctAnswer = br.readLine();
        if (correctAnswer.equals("Yes")) return;
        else {
            if (correctAnswer.equals("No")) getTree();
            else {
                System.out.println("OOps: Must Enter correct Answer which is \"Yes\" or \"No\"");
                exitCode();
                }
            }
        }
    }