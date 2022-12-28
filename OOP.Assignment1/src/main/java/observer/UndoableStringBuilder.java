package observer;

import java.util.Stack;

public class UndoableStringBuilder {

    /**
     * create a Stack that stores Stringbuilder actions
     */
    private Stack<StringBuilder> stackBuilder;
    private StringBuilder newbuilder;

    /**
     * create a new StringBuilder and Stack
     */
    public UndoableStringBuilder() {
        newbuilder = new StringBuilder();
        stackBuilder = new Stack<>();
//        newbuilder.append("");
//        StringBuilder temp = new StringBuilder(newbuilder);
//        stackBuilder.push(temp);
    }

    /**
     * @param str is a String that give a user to add to current String in the Stack
     * @return the whole String with adding a str to last character sequence
     * Example:
     * current:abc
     * append: str = def
     * return: abcdef
     */
    public UndoableStringBuilder append(String str) {
        newbuilder.append(str);
        StringBuilder temp = new StringBuilder(newbuilder);
        stackBuilder.push(temp);
        return this;
    }

    /**
     * @param start beginning point of current String in the Stack
     * @param end finsh point -1  of current String in the Stack
     * @return the String witcout a String between start and end-1
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            newbuilder.delete(start, end);
            StringBuilder temp = new StringBuilder(newbuilder);
            stackBuilder.push(temp);
        }
        catch (Exception ex){
            System.err.println("Exception:\n" + ex);
            ex.printStackTrace();
        }
        return this;
    }

    /**
     * @param offset is a spot where to add a str to current String in the Stack
     * @param str a String that we want to add in the current String in offset spot
     * @return a String with the str that was added in offset spot and the whole string that goes after it (if exists)
     */
    public UndoableStringBuilder insert(int offset, String str) {
        try {
            newbuilder.insert(offset, str);
            StringBuilder temp = new StringBuilder(newbuilder);
            stackBuilder.push(temp);
        } catch (Exception ex) {
            System.err.println("Exception:\n" + ex);
            ex.printStackTrace();
        }
            return this;
    }

    /**
     * @param start beginning point of current String in the Stack
     * @param end finsh point -1 of current String in the Stack
     * @param str a String that user wants to replace with other String that is found between the start and end-1
     * @return a String with replaced substring betwwen the start and end-1
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        try {
            newbuilder.replace(start, end, str);
            StringBuilder temp = new StringBuilder(newbuilder);
            stackBuilder.push(temp);
        } catch (Exception ex) {
            System.err.println("Exception:\n" + ex);
            ex.printStackTrace();
        }
        return this;
    }

    /**
     * @return a reversed String in the Stack
     * Example:
     * current: "abcde"
     * reverse(): "edcba"
     */
    public UndoableStringBuilder reverse() {
        newbuilder.reverse();
        StringBuilder temp = new StringBuilder(newbuilder);
        stackBuilder.push(temp);
        return this;
    }

    /**
     * @return what the value in the current String in the Stack
     */
    public String toString() {
        return newbuilder.toString();
    }

    /**
     * return the previous StringBuilder action in the Stack
     */
    public void undo() {
       try {
            stackBuilder.pop();
            if(!stackBuilder.empty()) {
                newbuilder = stackBuilder.peek();
            }
            else {
                StringBuilder temp = new StringBuilder();
                newbuilder = temp;
            }
        } catch (Exception ex) {
        }
    }
}
