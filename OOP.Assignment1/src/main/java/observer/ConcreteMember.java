package observer;

public class ConcreteMember implements Member{
    private Sender sender;
    private UndoableStringBuilder Sb;
    /**
     * version of the last GroupAdmin update
     * deffult version = 0
     */
    private int version;

    /**
     * new member in the Group admin
     * we create his last version of update ( 0 )
     * and create his stringbuilder where he could get Admin's msg's
     */
    public ConcreteMember(Sender sender)
    {
        Sb=new UndoableStringBuilder();
        register(sender);
        this.version=0;
    }

    /**
     * @param sender connects to his Groupadmin
     * explantion: each sender has his GroupaAdmin
     */
    public void register(Sender sender){
        sender.register(this);
    }

    /**
     * @param usb last version of string in the StringBuilder
     * save last version of the string
     * and update the count of version update
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.Sb=usb;
        this.version++;
    }

    /**
     * @return the count of updates (version is private)
     */
    public int getVersion() {
        return version;
    }

}
