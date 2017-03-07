package pl.edu.pjwstk.tau;

import java.util.List;

/**
 * Created by Mateusz on 07.03.2017.
 */
public interface Vektor {
    public void add(Double x);
    public List<Double> getVektor();
    public Vektor addVektors(Vektor v, Vektor v2) throws MyOwnException;
    public Vektor subVektors(Vektor v, Vektor v2) throws MyOwnException;
    public void setVektor(List<Double> vektor);
}
