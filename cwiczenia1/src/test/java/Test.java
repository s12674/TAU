/**
 * Created by Mateusz on 28.02.2017.
 */

    import static org.junit.Assert.*;

    import com.company.Vector;
    import com.company.VectorImpl;
    import com.company.X;
    import com.company.XMockImp;
    import org.junit.After;
    import org.junit.Before;
    import org.junit.runner.*;
    import org.junit.runners.JUnit4;

    import java.util.ArrayList;
    import java.util.List;

@RunWith ( JUnit4. class )
    public class Test {
    X x = new XMockImp();
    Vector vector = new VectorImpl();
    @Before
    public void prepare(){
        System.out.println("Przed testem");

    }
    @After
    public void afterM(){
        System.out.println("Po tescie");
    }

    @org.junit.Test
    public void testSum(){
        assertEquals(7, x.sum(5,2));
        assertEquals(6, x.sum(4,2));
    }
    @org.junit.Test
    public void testVektor(){
        List<Double> VektorSum = new ArrayList<Double>();
        List<Double> Vektor1 = new ArrayList<Double>();
        List<Double> Vektor2 = new ArrayList<Double>();
        Vektor1.add(2.2);
        Vektor1.add(7.2);


        Vektor2.add(3.2);
        Vektor2.add(2.5);


        VektorSum.add(5.4);
        VektorSum.add(9.7);
        assertEquals(VektorSum, vector.add(Vektor1, Vektor2));
    }
    }

