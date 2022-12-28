import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import observer.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    /**
     * Here we wanna to check the count of updates in each member of the group and
     * members of different groups
     */
    @Test
    public void  testObserver()
    {
        GroupAdmin admin = new GroupAdmin();
        GroupAdmin admin2 = new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember(admin);
        ConcreteMember m2 = new ConcreteMember(admin);
        ConcreteMember a1 = new ConcreteMember(admin2);
        ConcreteMember a2 = new ConcreteMember(admin2);
        //add data
        admin2.unregister(a2);
        admin.append("123");
        admin2.append("321");
        assertEquals(m1.getVersion() , a1.getVersion()); // m1 has 1 update from admin ,  a1 has 1 update from admin 2
        assertEquals(m1.getVersion() , m2.getVersion()); // m1 has 1 update from admin ,  m2 has 1 update from admin
        assertNotEquals(m1.getVersion(), a2.getVersion()); // m1 has 1 update from admin, a2 has 0 update from amin 2
        // because he un register from the admin 2 before first update
        admin2.register(a2); // return a2 to the admin a2
        admin2.undo();
        assertNotEquals(a1.getVersion(), a2.getVersion()); // a1 has 2 update because receive second update from amin2, a2 registered after first
        // and before the second (undo) so he has 1 update

    }
}
