import java.util.Scanner;

public class Main {

    public static Scanner scan;
    public static String output = "Our journey with each other continues...";
    public static int turnsToEscape = 30;
    public static boolean Trumpet = false;
    public static boolean Piano = false;
    public static boolean Drum = false;
    public static boolean Foyer = true;
    public static boolean Library = false;
    public static boolean Conservatory = false;
    public static boolean Pen = false;
    public static boolean Book = true;
    public static boolean DoorLocked = true;
    public static boolean DoorOpen = false ;
    public static boolean chest = false;
    public static boolean Matches = false;
    public static boolean candle = false;
    public static boolean redDoorLocked = true;
    public static boolean redDoorOpen = false;


    public static void main(String[] args) {

        System.out.printf("\nWhere am I? Why is it so dark here? As I continue to look around I see that I am in some sorts of a fancy house. I look up to see a door with a gold handle. To the right there is a treasure chest, one that is black, and just sitting on the floor. As I walk around I trip over an unlit candle, that was smack-dab in the middle of the room. To my left is a bench, one that appears to be red, and is pinned on the wall. What is going on?\n");
        System.out.printf("\nUh oh! It looks like you have fallen as the next victim in Ryan's House of Horror! \n However, I am feeling nice today, it is after all the holiday season, which is all about giving. \n So I am going to give you a chance to escape.\n");
        System.out.printf("Here is your gift: You have 30 opportunities. \n 30 opportunities before you earn your spot on our Thanksgiving table, and you would not be there as a guest...\n");
        System.out.printf("Now, here is how you play our little game to determine your fate, MUAHAHAHA \n To catch my attention, command help, but be wise as I can get cranky. But by doing this I will guide you in the right direction. Remember, because of my illiteracy I only understand two word expressions (verb then noun). I only understand the verbs: open, read, look, close, write, get, light, and play.  \n I did study nouns more in primary school, so you can command me these nouns: door, candle, book, trumpet, room, note, pen, piano, bench, matches, scroll, drum, chest, shelves, music, and lock.\n");
        System.out.printf("Lastly, you need to know where you are going. You have four options for this step: north, south, east, and west. \n Cherish your last hours in this world!\n");

        for (int i = 1; i < 31; i++) {
            playGame();
            turnsToEscape--;
            if (Trumpet && Piano && Drum) {
                break;
            }
        }

        if (Trumpet && Piano && Drum) {
            System.out.printf("\nUgh, it looks like you have defeated the game. Congratulations! For now...\n", turnsToEscape);
        }
        else {
            System.out.printf("Hehe, you are going to be a delicious delight!");
        }
    }

    public static void playGame() {
        if (Foyer) {
            foyer();
        }
        else if (Library) {
            library();
        }
        else if (Conservatory) {
            conservatory();
        }
    }

    public static void foyer()
    {
        System.out.printf("\n%s You have %d turns to escape.\n>>", output, turnsToEscape);
        scan = new Scanner(System.in);
        String testFoyer = scan.nextLine();

        switch (testFoyer) {
            case "help":
                output = "Remember to only use two word expressions, hurry, you are losing time...\n";
                break;

            case "look candle":
                output = "It's dark man, obviously it isn't lit.\n";
                break;

            case "look bench":
                output = "Aha! Locate the note that is on the bench.\n";
                break;

            case "read note":
                output = "May my light show you the way\n";
                break;

            case "look chest":
                output = "That is peculiar, the chest seems to be closed\n";
                break;

            case "open chest":
                chest = true;
                output = "Narts! You found my matches!\n";
                break;

            case "get matches":
                Matches = true;
                output = "Keep going, what are you going to do with these?\n";
                break;

            case "light candle":
                if (Matches) {
                    candle = true;
                    redDoorLocked = false;
                    output = "After lighting, you are immediately struck with a loud noise above you.\n";
                }
                else {
                    output = "You couldn't even light the candle?!?\n";
                }
                break;

            case "open door":
                if (!redDoorLocked) {
                    redDoorOpen = true;
                    output = "Welcome, go ahead now, the door has been opened.\n";
                }
                break;

            case "look door":
                if (!redDoorLocked) {
                    if (redDoorOpen) {
                        output = "The entrance is open for you to go...\n";
                    }
                    else {
                        output = "This entrance has not yet been unlocked for you\n";
                    }
                }
                else {
                    output = "Nope! It's locked.\n";
                }
                break;

            case "go north":
                if (redDoorOpen) {
                    Foyer = false;
                    Library = true;
                    output = "Now you come across a new room, with no possible way of turning back. You can see that there is a books and a  desk. Also, you can find a blue door above you. What could these mean? Continue to find out.\n";
                }
                break;

            default:
                output = "Come on now, you are not dealing with an idiot! Don't forget the items around the room and the door above you.\n";
        }
    }

    public static void library()
    {
        System.out.printf("\n%sYou have %d turns left.\n>>", output, turnsToEscape);
        scan = new Scanner(System.in);
        String testLibrary = scan.nextLine();

        switch (testLibrary) {
            case "help":
                output = "Remember to only use two word expressions, hurry, you are losing time...\n";
                break;

            case "look shelves":
                output= "One book is poking out. It is titled: The Autobiography of... with the rest of the title missing.\n";
                break;

            case "get pen":
                Pen = true;
                output = "The pen is now in your hands.\n";
                break;

            case "read scroll":
                output = "It asks for you name. The catch is, you must write it. *Am I writing the story of my own life?*\n";
                break;

            case "write book":
                Book = true;
                DoorLocked = false;
                output = "Immediately after completing this step, you hear a noise above you.\n";
                break;

            case "open door":
                if (!DoorLocked) {
                    DoorOpen = true;
                    output = "Door opens, keep going to reveal your future.\n";
                }
                break;

            case "look door":
                if (!DoorLocked) {
                    if (DoorOpen) {
                        output = "The door above you is now open.\n";
                    }
                    else {
                        output = "You can't do anything right! The door remains closed.\n";
                    }
                }
                else {
                    output = "Door remains looked(\n";
                }
                break;

            case "go north":
                if (DoorOpen) {
                    Library = false;
                    Conservatory = true;
                    output = "As you leave this library, you are now stuck in a new room, lined only with a shiny trumpet, a drum, and a grand piano. Also in this new room is a piece of sheet music on a stand in the middle of the room.\n";
                }
                break;

            default:
                output = "Nice try... Look around again and observe the looked door, potentially the last door you have to go through...\n";
        }
    }

    public static void conservatory()
    {
        System.out.printf("\n%s You have %d turns left.\n>>", output, turnsToEscape);
        scan = new Scanner(System.in);
        String testConservatory = scan.nextLine();

        switch (testConservatory) {
            case "help":
                output = "Remember to only use two word expressions, hurry, you are losing time...\n";
                break;

            case "look music":
                output= "Almost, but there is nothing here, maybe check out the musical staff?\n";
                break;

            case "read music":
                output = "Timbre, Tone, and Time. But I know you are dumb and do not understand this so here is your hint: trumpet, piano, and drum.\n";
                break;

            case "play trumpet":
                if (!Piano && !Drum) {
                    Trumpet = true;
                    output = "Those fifth grade music classes pays off, you can know play the trumpet.\n";
                }
                else {
                    output = "If only you weren't a twat, and could play the trumpet.\n";
                }
                break;

            case "play piano":
                if (Trumpet && !Drum) {
                    Piano = true;
                    output = "Look at you, a musical prodigy playing the piano\n";
                }
                else {
                    output = "Either the keys are stuck or you just do not know how to play the piano.\n";
                }
                break;

            case "play drum":
                if (Trumpet && Piano) {
                    Drum = true;
                    output = "What a rockstar we have on our hands, you are almost there, rockstar!\n";
                }
                else {
                    output = "I can't believe that you can't play the drums\n";
                }
                break;

            default:
                output = "Wrong, but don't give up yet. This last door is the key to getting out. On second thought, please give up, I am hungry.\n";
        }
    }
}

