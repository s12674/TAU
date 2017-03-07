package pl.edu.pjwstk.tau;

/**
 * Created by Mateusz on 07.03.2017.
 */

 import static org.junit.Assert.*;

        import org.junit.runner.*;
        import org.junit.runners.JUnit4;

@RunWith ( JUnit4. class )
public class VektorTest {
    @org.junit.Test
    public void addToVektorTest() throws MyOwnException {
        Vektor v1 = new VektorImpl();
        Vektor v2 = new VektorImpl();
        Vektor sum = new VektorImpl();
        Vektor tempSum = new VektorImpl();
        v1.add(2.2);
        v1.add(7.2);
        v2.add(3.2);
        v2.add(2.5);
        sum.add(5.4);
        sum.add(9.7);
        tempSum = tempSum.addVektors(v1, v2);
        assertEquals(sum.getVektor(), tempSum.getVektor());
    }

    @org.junit.Test
    public void subVektorTest() throws MyOwnException {
        Vektor v1 = new VektorImpl();
        Vektor v2 = new VektorImpl();
        Vektor sum = new VektorImpl();
        Vektor tempSub = new VektorImpl();
        v1.add(2.2);
        v1.add(7.2);
        v2.add(3.2);
        v2.add(2.5);
        sum.add(-1.0);
        sum.add(4.7);
        tempSub = tempSub.subVektors(v1, v2);
        assertEquals(sum.getVektor(), tempSub.getVektor());
    }

    @org.junit.Test(expected = AssertionError.class)
    public void expectedTest() throws MyOwnException {
        Vektor v1 = new VektorImpl();
        Vektor v2 = new VektorImpl();
        Vektor sum = new VektorImpl();
        Vektor tempSum = new VektorImpl();

        v1.add(2.2);
        v1.add(7.2);
        v2.add(3.2);
        sum.add(5.4);
        sum.add(9.7);
        tempSum = tempSum.addVektors(v1, v2);
    }
}
