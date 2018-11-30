import java.util.Scanner;

public class Main {

    public static Scanner scan;
    public static int movesLeft = 30;
    public static String output = "You feel your abdomen. A wet warmth covers your hand. You are bleeding. Who knows how long you will last? Combine a verb and a noun to perform a move. You get 30 moves before you die. Verbs:open, go, close, light, read, write, play, look, get. Nouns:door, room, bench, chest, candle, note, matches, shelves, shelf, book, pen, scroll, music, trumpet, piano, drum, lock, north.";

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
    public static boolean gameWon = false;
    public static boolean door3Locked = true;
    public static boolean door3Open = false;

    public static void main(String[] args) {

        System.out.printf("Your head is pounding. You wake up in a large unfamiliar foyer, completely alone. There is a bench, a chest, and a candle. This person has a strange design sense. Did you really drink that much last night? Slowly you realize that this was not simply a drunk night. You look down at yourself in the dim light and see traces of dried blood. You were in a fight, but when? Where? You decide to stand up and create a plan to get out of this place.\n\n");
        for (int i = 1; i < 31; i++) {
            gameUsage();
            movesLeft--;
            if (gameWon) {
                break;
            }
        }
        if (gameWon) {
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
        System.out.printf("%s You feel the warmth of blood coming out of the wound. You need to get out of here, fast. You have %d moves left.\n>>", output, movesLeft);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {

            case "look bench":
                output = "There is a note on the bench.";
                break;

            case "read note":
                output = "The note reads: May my light show you the way.";
                break;

            case "look chest":
                output = "A large ornate chest sits closed. The golden finish gleams in the soft light of the foyer.";
                break;

            case "open chest":
                chestOpen = true;
                output = "You see a box of matches at the bottom of the chest.";
                break;

            case "get matches":
                if (chestOpen) {
                    hasMatches = true;
                    output = "You have a box of matches.";
                }
                else {
                    output = "You channel all of your telekinetic abilites to channel a box of matches out of thin air. You must look like such an idiot right now.";
                }
                break;

            case "light candle":
                if (hasMatches) {
                    candleLit = true;
                    door1Locked = false;
                    output = "The candle is lit. You heard a metal grinding sound from the north.";
                }
                else {
                    output = "You channel your fire bending powers, and focus all of your energy on the candle. You are the Avatar. You need to save the world. After an embarrasing amount of time, you decide to go find something to light the candle with.";
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
                else {
                    output = "The door seems to be locked. You break out the old lock picking skills with your bobby pin. You soon realize that you don't really know how to pick a lock.";
                }
                break;

            case "go north":
                if (door1Open) {
                    inFoyer = false;
                    inLibrary = true;
                    output = "You have left the foyer. On your way out, the door slammed and locked. You are now in the library and cannot return to the foyer. In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll. There is another locked door to the north.";
                }
                else {
                    output = "Can't /noclip your way out of this one buddy. The door isn't open yet.";
                }
                break;
            default:
                output = "Your vision goes spotty, and you sit down to rest. You can't think straight through all this pain.";
        }
    }

    public static void library() {
        System.out.printf("%s You have %d moves left.\n>>", output, movesLeft);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {

            case "look shelf":
            case "look shelves":
            case "look book":
                output = "There is a book titled 'The Autobiography of ...' You always wished that somebody would write a biography on your life...";
                break;

            case "look scroll":
                output = "A worn scroll sits on a grey pedestal in the middle of the library";
                break;

            case "look pen":
                if (getPen) {
                    output = "You study the pen in your hand. The weight is perfect. You will definitely be keeping this pen.";
                }
                if (!getPen) {
                    output = "A beautiful fountain pen sits on a gray pedestal in the middle of the room";
                }
                break;

            case "get pen":
                getPen = true;
                output = "You now have a beautifully weighted fountain pen, with sleek metal sides and a beautiful grip.";
                break;

            case "read scroll":
                output = "the scroll says, 'Share your story.'";
                break;

            case "write book":
            case "write name":
                if (getPen) {
                    writeBook = true;
                    door2Locked = false;
                    output = "You write your name in the book. You heard a metal grinding sound from the north. But the scroll wanted your whole story, and he is definitely getting that whole story. You sit down and begin to tell your entire life story. After a couple hours, you have filled a couple books with your writing. Satisfied with your work, you put the book down.";
                }
                else {
                    output = "You want to share your life story, but you don't have anything to write with. Reminds you of that on time Andre Picazzo stole your only pencil at school.";
                }
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
                else {
                    output = "The door is still locked. You shake the door, frustrated beyond belief. Nothing happens.";
                }
                break;

            case "go north":
                if (door2Open) {
                    inLibrary = false;
                    inConservatory = true;
                    output = " You have left the library. On your way out, the door slammed and locked. You are now in the conservatory and cannot return to the library. In the conservatory there are there are three instruments: a trumpet, a piano, and a drum. There is a sheet of music on a stand.";
                }
                if (!door2Open) {
                    output = "The door isn't open, and you can't phase through walls. Rough.";
                }
                break;

            default:
                output = "You are losing blood fast now. You rip a strip off your shirt and attempt to bandage the wound. Your day job at Starbucks has not prepared you for this situation in the slightest.";
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
                if (playTrumpet && !playDrum && !playPiano) {
                    playPiano = true;
                    output = "You break into Beethoven's 7th symphony. Aren't you glad those piano lessons paid off? ";
                }
                else {
                    playPiano = false;
                    output = "The piano doesn't make any noise. You silently curse those childhood piano lessons your mom made you take.";
                }
                break;

            case "play drum":
                if (playTrumpet && playPiano) {
                    playDrum = true;
                    door3Locked = false;
                    output = "Your mom never let you play drums as a kid. Too loud. You bang the drum with ferocity and joy. Childhood dream accomplished. You notice a loud noise from the north. Maybe it's an echo from the drum, maybe it's something else";
                }
                else {
                    output = "You hit the drum, but no noise comes out. Who has a broken drum in their mansion?";
                }
                break;

            case "open door":
                if (!door3Locked && !door3Open) {
                    door3Open = true;
                    output = "You carefully read the sign next to the door before pulling it open. No pushing pull doors for you anymore.";
                }
                break;

            case "go north":
                if (door3Open) {
                    gameWon = true;
                }

            default:
                output = "You need to get out of here. Wandering around in circles and blathering about nothing isn't getting you anywhere.";
        }
    }
}
