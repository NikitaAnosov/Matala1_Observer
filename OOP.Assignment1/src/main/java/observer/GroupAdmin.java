package observer;

import java.util.LinkedList;
import java.util.List;

public class GroupAdmin implements Sender{
    /**
     * create linked list of members where we will save them
     */
    private List<Member> myMembers;

    /**
     * our StringBuilder that have many actions like append/delete/undo/...
     */
    private UndoableStringBuilder StringBulid;

    /**
     * create an admin of group admins that create a new linked list
     * for his members and creates new StringBuilder where he could write msg in strings with different
     * actions of the Stringbuilder
     */
    public GroupAdmin(){
        this.myMembers=new LinkedList<>();
        this.StringBulid = new UndoableStringBuilder();
    }


    @Override
    /**
     * void: save it the GroupAdmin linkedlist
     */
    public void register(Member obj) {
        this.myMembers.add(obj);
        System.out.println("new member");
    }

    @Override
    /**
     * void: delete from GroupAdmin linkedlist
     */
    public void unregister(Member obj) {
        this.myMembers.remove(obj);
        System.out.println("goodbye member");

    }

    /**
     *
     * @param offset where the string begins
     * @param obj   string that we want to add
     * void: call to our SringBuilder that have same action of insert
     *       and call to func updateMembers to inform about the update
     */
    @Override
    public void insert(int offset, String obj) {
        this.StringBulid.insert(offset,obj);
        updateMembers();
    }

    /**
     *
     * @param obj string that we want to add
     * void: call to our SringBuilder that have same action of append
     *       and call to func updateMembers to inform about the update
     */
    @Override
    public void append(String obj) {
        this.StringBulid.append(obj);
        updateMembers();
    }
    /**
     *
     * @param start where the string begins
     * @param end where the string ends (end-1)
     * void: call to our SringBuilder that have same action of delete
     *       and call to func updateMembers to inform about the update
     */
    @Override
    public void delete(int start, int end) {
        this.StringBulid.delete(start,end);
        updateMembers();
    }

    /**
     * void: call to our SringBuilder that have same action of undo
     *       and call to func updateMembers to inform about the update
     */
    @Override
    public void undo() {
        this.StringBulid.undo();
        updateMembers();
    }

    /**
     * We use a loop that run to the end our linked list
     * and in each iteration we use an update func from Sender interface that got last string
     * that we have in our stringbuilder
     */
    private void updateMembers()
    {
        for (Member member : this.myMembers)
            member.update((this.StringBulid));
    }
}