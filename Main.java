import java.util.Scanner;

public class Main {

    public static Scanner scan;
    public static int movesLeft = 30;
    public static String output = "You feel your abdomen. A wet warmth covers your hand. You are bleeding. Who knows how long you will last? Combine a verb and a noun to perform a move. You get 30 moves before you die. Verbs:open, close, light, read, write, play, look, get. Nouns:door, room, bench, chest, candle, note, matches, shelves, book, pen, scroll, music, trumpet, piano, drum, lock. To move input direction only:north, south, east, west.";

    public static boolean inFoyer = true;
    public static boolean inLibrary = false;
    public static boolean inConservatory = false;
    //Foyer
    public static boolean chestOpen = false;
    public static boolean hasMatches = false;
    public static boolean candleLit = false;
    public static boolean door1Locked = true;
    public static boolean door1Open = false;
    //Library
    public static boolean getPen = false;
    public static boolean writeBook = false;
    public static boolean door2Locked = true;
    public static boolean door2Open = false;
    //Conservatory
    public static boolean playTrumpet = false;
    public static boolean playPiano = false;
    public static boolean playDrum = false;

    public static void main(String[] args) {

        System.out.printf("Your head is pounding. You wake up in a large unfamiliar foyer, completely alone. There is a bench, a chest, and a candle. This person has a strange design sense. Did you really drink that much last night? Slowly you realize that this was not simply a drunk night. You look down at yourself in the dim light and see traces of dried blood. You were in a fight, but when? Where? You decide to stand up and create a plan to get out of this place.\n\n");
        for (int i = 1; i < 31; i++) {
            gameUsage();
            movesLeft--;
            if (playTrumpet && playPiano && playDrum) {
                break;
            }
        }
        if (playTrumpet && playPiano && playDrum) {
            System.out.printf("\nThe door opens to an eerie scene. A large open graveyard, with a light layer of fog covering the ground. You sprint out of the conservatory into the graveyard. You have no idea where you are, but at least you have left that creepy mansion. You stumble down the dirt driveway to seek medical attention. Congratulations, you survived. Now time to sue this place, you didn't sign up for this realistic of an escape room. You had %d moves left.", movesLeft);
        }
        else {
            System.out.printf("\nYou black out. As you feel yourself start to fade, you feel a hand grab your leg and begin to drag you across the floor.");
        }
    }

    public static void gameUsage() {
        if (inFoyer) {
            foyer();
        }
        else if (inLibrary) {
            library();
        }
        else if (inConservatory) {
            conservatory();
        }
    }

    public static void foyer() {
        System.out.printf("%s You feel the warmth of the blood coming out of the wound. You need to get out of here, fast. You have %d moves left.\n>>", output, movesLeft);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {

            case "look bench":
                output = "There is a note on the bench.";
                break;

            case "read note":
                output = "May my light show you the way.";
                break;

            case "look chest":
                output = "the chest is closed.";
                break;

            case "open chest":
                chestOpen = true;
                output = "There are matches in the chest.";
                break;

            case "get matches":
                hasMatches = true;
                output = "You have a box of matches.";
                break;

            case "light candle":
                if (hasMatches) {
                    candleLit = true;
                    door1Locked = false;
                    output = "The candle is lit. You heard a metal grinding sound from the north.";
                }
                else {
                    output = "You don't have any matches.";
                }
                break;

            case "look door":
                if (!door1Locked) {
                    if (door1Open) {
                        output = "The door is unlocked and open.";
                    }
                    else {
                        output = "The door is unlocked, but closed.";
                    }
                }
                else {
                    output = "The door is locked.";
                }
                break;

            case "open door":
                if (!door1Locked) {
                    door1Open = true;
                    output = "Wow. That door needs some WD-40. You somehow manage to open the door.";
                }
                break;

            case "north":
                if (door1Open) {
                    inFoyer = false;
                    inLibrary = true;
                    output = "You have left the foyer. On your way out, the door slammed and locked. You are now in the library and cannot return to the foyer. In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll. There is another locked door to the north.";
                }
                break;
        }
    }

    public static void library() {
        System.out.printf("%s You have %d moves left.\n>>", output, movesLeft);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {

            case "look bookshelf":
                output = "There is a book titled 'The Autobiography of ...' with the rest of the title empty.";
                break;

            case "get pen":
                getPen = true;
                output = "You have acquired the pen.";
                break;

            case "read scroll":
                output = "the scroll says, 'Share your story.'";
                break;

            case "write book":
            case "write name":
                writeBook = true;
                door2Locked = false;
                output = "You write your name in the book. You heard a metal grinding sound from the north. But the scroll wanted your whole story, and he is definitely getting that whole story. You sit down and begin to tell your entire life story. After a couple hours, you have filled a couple books with your writing. Satisfied with your work, you put the book down.";
                break;

            case "look door":
                if (!door2Locked) {
                    if (door2Open) {
                        output = "The door is unlocked and open.";
                    }
                    else {
                        output = "The door is unlocked, but closed.";
                    }
                }
                else {
                    output = "The door is locked.";
                }
                break;

            case "open door":
                if (!door2Locked) {
                    door2Open = true;
                    output = "You push the door as hard as you can, to no avail. Seems like it might be jammed shut. Oh wait... never mind, it's a pull door. You open it, thankful that you are alone, and that nobody saw your embarrassing moment.";
                }
                break;

            case "north":
                if (door1Open) {
                    inLibrary = false;
                    inConservatory = true;
                    output = " You have left the library. On your way out, the door slammed and locked. You are now in the conservatory and cannot return to the library. In the conservatory there are there are three instruments: a trumpet, a piano, and a drum. There is a sheet of music on a stand.";
                }
                break;

            default:
                output = "In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll. There is another locked door to the north.";
        }
    }

    public static void conservatory()  {
        System.out.printf("%s You have %d moves left.\n>>", output, movesLeft);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {
            case "read music":
                output = "Timbre, Tone, Time";
                break;

            case "play trumpet":
                if (!playPiano && !playDrum) {
                    playTrumpet = true;
                    output = "You didn't play the trumpet in 4th grade band for nothing. This creepy mansion is about to get a show. You blow into the trumpet. A loud brassy screech echos around the world. You are just amazed you can still make a noise with the instrument.";
                }
                else {
                    output = "You didn't play the trumpet in 4th grade band for nothing. This creepy mansion is about to get a show. You blow into the trumpet... Nothing happens. Maybe you should've stuck with band.";
                }
                break;

            case "play piano":
                if (playTrumpet && !playDrum) {
                    playPiano = true;
                    output = "You break into Beethoven's 7th symphony. Aren't you glad those piano lessons paid off? ";
                }
                else {
                    output = "The piano doesn't make any noise. You silently curse those childhood piano lessons your mom made you take.";
                }
                break;

            case "play drum":
                if (playTrumpet && playPiano) {
                    playDrum = true;
                    output = "Your mom never let you play drums as a kid. Too loud. You bang the drum with ferocity and joy. Childhood dream accomplished.";
                }
                else {
                    output = "You hit the drum, but no noise comes out. Who has a broken drum in their mansion?";
                }
                break;

            default:
                output = "In the conservatory there are there are three instruments: a trumpet, a piano, and a drum. There is a sheet of music on a stand.";
        }
    }
}