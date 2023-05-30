package person;

import com.rd.dz11.Man;
import com.rd.dz11.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WomanTest {
    private Man man;
    private Woman woman;

    @BeforeMethod
    public void creatingPersonEntities(){
        man = new Man("Bob","Black", 30, null);
        woman= new Woman("Nancy","Drew",45, null);
    }

    @Test
    public void testIsRetired(){
        woman.setAge(65);
        Assert.assertTrue(woman.isRetired());
    }

    @Test
    public void testIsNotRetired(){
        Assert.assertFalse(man.isRetired());
    }

    @Test
    public void testRegisterPartnershipIfSingle(){
        woman.registerPartnership(man);
        Assert.assertEquals(woman.getPartner(),man);
        Assert.assertEquals(man.getPartner(),woman);
        Assert.assertEquals(woman.getLastName(), man.getLastName(), "Lastname wasn't changed for woman.");
    }

    @Test
    public void testRegisterPartnershipIfMarried(){
        woman.setPartner(man);
        Man someAttractiveMan = new Man("Bob","Black", 70, null);

        woman.registerPartnership(someAttractiveMan);
        Assert.assertEquals(woman.getPartner(),man);
    }

    @Test
    public void testDeregisterPartnershipWithLastNameChange(){
        String oldLastName = woman.getLastName();
        man.setPartner(woman);
        woman.setPartner(man);
        woman.deregisterPartnership(true);
        Assert.assertNull(woman.getPartner());
        Assert.assertNull(man.getPartner());
        Assert.assertEquals(woman.getLastName(), oldLastName);
    }

    @Test
    public void testDeregisterPartnershipWithoutLastNameChange(){
        man.setPartner(woman);
        man.deregisterPartnership(false);
        Assert.assertNull(man.getPartner());
        Assert.assertNull(woman.getPartner());
        Assert.assertEquals(woman.getLastName(), man.getLastName());
    }

    @Test
    public void testDeregisterPartnershipIfSingle(){
        woman.deregisterPartnership(true);
        Assert.assertNull(woman.getPartner());
    }

    @Test
    public void testChangeLastName(){
        woman.setPartner(man);
        man.setPartner(woman);
        Assert.assertEquals(woman.getLastName(),man.getLastName());
    }

    @Test
    public void testChangeOldLastName(){
        String oldLastName = woman.getLastName();
        man.setPartner(woman);
        woman.changeOldLastName(true);
        Assert.assertEquals(woman.getLastName(),oldLastName);
    }

    @Test
    public void testGetLastName(){
        Assert.assertEquals(woman.getLastName(),"Drew");
    }
    @Test
    public void testGetFirstName(){
        Assert.assertEquals(woman.getFirstName(),"Nancy");
    }

    @Test
    public void testGetAge(){
        Assert.assertEquals(woman.getAge(),45);
    }
    @Test
    public void testGetPartner(){
        woman.setPartner(man);
        Assert.assertEquals(woman.getPartner(),man);
    }

    @Test
    public void testSetFirstName(){
        woman.setFirstName("Mary");
        Assert.assertEquals(woman.getFirstName(), "Mary");
    }
    @Test
    public void testSetFirstNameIsNotBlank(){
        woman.setFirstName(" ");
        Assert.assertEquals(woman.getFirstName(), "Nancy");
    }

    @Test
    public void testSetLastName(){
        woman.setLastName("Bell");
        Assert.assertEquals(woman.getLastName(), "Bell");
    }

    @Test
    public void testSetLastNameIsNotBlank(){
        woman.setFirstName(" ");
        Assert.assertEquals(woman.getLastName(), "Drew");
    }

    @Test
    public void testSetAge(){
        woman.setAge(56);
        Assert.assertEquals(woman.getAge(), 56);
    }

    @Test
    public void testSetAgeNotValid(){
        woman.setAge(-2);
        Assert.assertEquals(woman.getAge(), 45);
    }

    @Test
    public void testSetPartner(){
        woman.setPartner(man);
        Assert.assertEquals(woman.getPartner(), man);
    }
}
