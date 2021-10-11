package sportsteam;


import java.util.*;

//Implementation of class 'Person'
class Person {
    //class data members

    private int number;
    private String name;

    //constructors
    public Person() {
        this.number = 0;
        this.name = "";
    }

    public Person(int id, String name) {
        super();
        this.number = id;
        this.name = name;
    }

    //getters and setters
    public int getid() {
        return number;
    }

    public void setid(int id) {
        this.number = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //over-ride function
    @Override
    public String toString() //when using toString you override
    {
        return "ID: " + this.number + " Name: " + this.name;
    }
}
//Implementation of class 'Player'

class Player extends Person {

    private int jerseyNumber;
    private String position;

    //constructors
    public Player() {
        super();
        this.jerseyNumber = 0;
        this.position = "";
    }

    public Player(int id, String name, int jerseyNumber, String position) {
        super(id, name);
        this.jerseyNumber = jerseyNumber;
        this.position = position;
    }

    //getters and setters
    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    //over-ride function implementation
    @Override
    public String toString() {
        return super.toString() + " Jersey Number:  " + this.jerseyNumber + "  Position: " + this.position;
    }
}

//driver class
public class SportsTeam {

    //this function displays the menu
    static int option;

    public static void menu() {
        System.out.println("\n1: Add Information of a player");
        System.out.println("2: View All Added Players Info");
        System.out.println("3: EXIT");
    }

    public static void main(String[] args) {
        System.out.println("SPORTS TEAM MANAGEMENT SYSTEM");
        //declare variables
        String id, jerseyNumber;
        String name, position;
        //declares and initializes lists
        List<Player> players = new LinkedList<Player>(); 
        Scanner input = new Scanner(System.in);// for Int (option)
        Scanner input1 = new Scanner(System.in);//for String (player id, name etc.)

        String stringOption;
        int x = 1; //used to manipulate the while loop

        do //repeat until user does not want to exit
        {
            x = 1;
            //Made a string called stringOption to store the inputs (1,2, or 3).
            //Parseint is used to make sure we have 1,2, or 3 and nothing else.
            //Else statement is used to let the user know about the wrong input
            
            while (x == 1)//repeat until user does not want to exit
            {
                menu();
                stringOption = input.nextLine();

                if (stringOption.equals("1")) {
                    option = Integer.parseInt(stringOption); //int option is going to store the value 
                    x = 0; //manipulating the while loop (exiting)
                } else if (stringOption.equals("2")) {
                    option = Integer.parseInt(stringOption);
                    x = 0;
                } else if (stringOption.equals("3")) {
                    option = Integer.parseInt(stringOption);
                    x = 0;
                } else {
                    System.out.println("Invalid Input. Please look at codes and try again");


                }
            }
            
            while (option < 1 || option > 3) {
                System.out.println("Invalid Option!   ");
                menu();
                option = input.nextInt();
            }

            if (option == 1) //if option is 1
            {
                //taking input details from user

                try {
                    System.out.print("Enter Player ID:   ");
                    id = input1.nextLine();
                    int ID = Integer.parseInt(id); //converting String id to int

                    System.out.print("Enter Player Jersey Number:   ");
                    jerseyNumber = input1.nextLine();
                    int JERSEYNUMBER = Integer.parseInt(jerseyNumber); //converting String jerseyNumber to int

                    System.out.print("Enter Player Name:   ");
                    name = input1.nextLine();

                    System.out.print("Enter Player Position:   ");
                    position = input1.nextLine();

                    Player p = new Player(ID, name, JERSEYNUMBER, position); //add player to the list
                    players.add(p); 
                    System.out.println("\n*Player Added Successfully*");
                } catch (Exception e) {
                    System.out.println("Error!  Please enter valid data.\n");
                }
            } else if (option == 2) //if option is 2
            {
                System.out.println("\n*Players Information*"); //display info of all players
                for (int j = 0; j < players.size(); j++) { //this will take all the players info entered 

                    System.out.println(players.get(j).toString());
                }
                if (players.size() == 0) {
                    System.out.println("*No Player Exists*");
                }

            } //if option is 3
            else if (option == 3) {
                System.exit(0);
            }

        } while (option != 3);//repeat until option is not equal to 3
    }
}