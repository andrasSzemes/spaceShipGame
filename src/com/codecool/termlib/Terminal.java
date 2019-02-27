package com.codecool.termlib;

public class Terminal {
    /**
     * The beginning of control sequences.
     */
    // HINT: In \033 the '0' means it's an octal number. And 33 in octal equals 0x1B in hexadecimal.
    // Now you have some info to decode that page where the control codes are explained ;)
    private static final String CONTROL_CODE = "\033[";
    /**
     * Command for whole screen clearing.
     *
     * Might be partitioned if needed.
     */
    private static final String CLEAR = "2J";
    /**
     * Command for moving the cursor.
     */
    private static final String MOVE = "H";
    /**
     * Command for printing style settings.
     *
     * Handles foreground color, background color, and any other
     * styles, for example color brightness, or underlines.
     */
    private static final String STYLE = "m";

    /**
     * Reset printing rules in effect to terminal defaults.
     *
     * Reset the color, background color, and any other style
     * (i.e.: underlined, dim, bright) to the terminal defaults.
     */
    public static void resetStyle() {
    }

    /**
     * Clear the whole screen.
     *
     * Might reset cursor position.
     */
    public static void clearScreen() {
	    command(CONTROL_CODE + CLEAR);
    }

    /**
     * Move cursor to the given position.
     *
     * Positions are counted from one.  Cursor position 1,1 is at
     * the top left corner of the screen.
     *
     * @param x Column number.
     * @param y Row number.
     */
    public static void moveTo(Integer x, Integer y) {
	    command(CONTROL_CODE + x + ";" + y + MOVE);
    }

    /**
     * Set the foreground printing color.
     *
     * Already printed text is not affected.
     *
     * @param color The color to set.
     */
    public static void setColor(Color color) {
        String colorCode;
        switch(color){
            case BLACK:
                colorCode = "30";
                break;
            case RED:
                colorCode = "31";
                break;
            case GREEN:
                colorCode = "32";
                break;
            case YELLOW:
                colorCode = "33";
                break;
            case BLUE:
                colorCode = "34";
                break;
            case MAGENTA:
                colorCode = "35";
                break;
            case CYAN:
                colorCode = "36";
                break;
            case WHITE:
                colorCode = "37";
                break;
            default:
                colorCode = "";
        }
        String commandString = CONTROL_CODE + colorCode + STYLE;
        command(commandString);
    }

    /**
     * Set the background printing color.
     *
     * Already printed text is not affected.
     *
     * @param color The background color to set.
     */
    public void setBgColor(Color color) {
        String colorCode;
        switch(color){
            case BLACK:
                colorCode = "40";
                break;
            case RED:
                colorCode = "41";
                break;
            case GREEN:
                colorCode = "42";
                break;
            case YELLOW:
                colorCode = "43";
                break;
            case BLUE:
                colorCode = "44";
                break;
            case MAGENTA:
                colorCode = "45";
                break;
            case CYAN:
                colorCode = "46";
                break;
            case WHITE:
                colorCode = "47";
                break;
            default:
                colorCode = "";
        }
        String commandString = CONTROL_CODE + colorCode + STYLE;
        command(commandString);
    }

    /**
     * Make printed text underlined.
     *
     * On some terminals this might produce slanted text instead of
     * underlined.  Cannot be turned off without turning off colors as
     * well.
     */
    public static void setUnderline() {
    }

    /**
     * Move the cursor relatively.
     *
     * Move the cursor amount from its current position in the given
     * direction.
     *
     * @param direction Step the cursor in this direction.
     * @param amount Step the cursor this many times.
     */
    public static void moveCursor(Direction direction, Integer amount) {
        String commandString = CONTROL_CODE + amount;

        if (direction == Direction.UP) {commandString += "A";}
        else if (direction == Direction.DOWN) {commandString += "B";}
        else if (direction == Direction.FORWARD) {commandString += "C";}
        else if (direction == Direction.BACKWARD) {commandString += "D";}

        command(commandString);
    }

    /**
     * Set the character diplayed under the current cursor position.
     *
     * The actual cursor position after calling this method is the
     * same as beforehand.  This method is useful for drawing shapes
     * (for example frame borders) with cursor movement.
     *
     * @param c the literal character to set for the current cursor
     * position.
     */
    public static void setChar(char c) {
        command(String.valueOf(c));
    }

    /**
     * Helper function for sending commands to the terminal.
     *
     * The common parts of different commands shall be assembled here.
     * The actual printing shall be handled from this command.
     *
     * @param commandString The unique part of a command sequence.
     */
    private static void command(String commandString) {
        System.out.print(commandString);
    }
}
