package person;
import com.rd.dz11.Man;
import com.rd.dz11.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManTest {
    private Man man;
    private Woman woman;

    @BeforeMethod
    public void creatingPersonEntities(){
        man = new Man("Bob","Black", 30, null);
        woman= new Woman("Nancy","Drew",45, null);
    }

    @Test
    public void testIsRetired(){
        man.setAge(70);
        Assert.assertTrue(man.isRetired());
    }

    @Test
    public void testIsNotRetired(){
        Assert.assertFalse(man.isRetired());
    }

    @Test
    public void testRegisterPartnershipIfSingle(){
        man.registerPartnership(woman);
        Assert.assertEquals(man.getPartner(),woman);
        Assert.assertEquals(woman.getPartner(),man);
        Assert.assertEquals(woman.getLastName(), man.getLastName(), "Lastname wasn't changed for woman.");
    }

    @Test
    public void testRegisterPartnershipIfMarried(){
        man.setPartner(woman);
        Woman someAttractiveWoman = new Woman("Belinda","Jonson",25,null);

        man.registerPartnership(someAttractiveWoman);
        Assert.assertEquals(man.getPartner(),woman);
    }

    @Test
    public void testDeregisterPartnershipWithLastNameChange(){
        String oldLastName = woman.getLastName();
        man.setPartner(woman);
        woman.setPartner(man);
        man.deregisterPartnership(true);
        Assert.assertNull(man.getPartner());
        Assert.assertNull(woman.getPartner());
        Assert.assertEquals(woman.getLastName(), oldLastName);
    }

    @Test
    public void testDeregisterPartnershipWithoutLastNameChange(){
        man.setPartner(woman);
        woman.setPartner(man);
        man.deregisterPartnership(false);
        Assert.assertNull(man.getPartner());
        Assert.assertNull(woman.getPartner());
        Assert.assertEquals(woman.getLastName(), man.getLastName());
    }

    @Test
    public void testDeregisterPartnershipIfSingle(){

        man.deregisterPartnership(true);
        Assert.assertNull(man.getPartner());
    }

    @Test
    public void testGetLastName(){
        Assert.assertEquals(man.getLastName(),"Black");
    }
    @Test
    public void testGetFirstName(){
        Assert.assertEquals(man.getFirstName(),"Bob");
    }

    @Test
    public void testGetAge(){
        Assert.assertEquals(man.getAge(),30);
    }
    @Test
    public void testGetPartner(){
        man.setPartner(woman);
        Assert.assertEquals(man.getPartner(),woman);
    }

    @Test
    public void testSetFirstName(){
        man.setFirstName("John");
        Assert.assertEquals(man.getFirstName(), "John");
    }
    @Test
    public void testSetFirstNameIsNotBlank(){
        man.setFirstName(" ");
        Assert.assertEquals(man.getFirstName(), "Bob");
    }

    @Test
    public void testSetLastName(){
        man.setLastName("Bell");
        Assert.assertEquals(man.getLastName(), "Bell");
    }

    @Test
    public void testSetLastNameIsNotBlank(){
        man.setFirstName(" ");
        Assert.assertEquals(man.getLastName(), "Black");
    }

    @Test
    public void testSetAge(){
        man.setAge(56);
        Assert.assertEquals(man.getAge(), 56);
    }

    @Test
    public void testSetAgeNotValid(){
        man.setAge(-2);
        Assert.assertEquals(man.getAge(), 30);
    }

    @Test
    public void testSetPartner(){
        man.setPartner(woman);
        Assert.assertEquals(man.getPartner(), woman);
    }

}
