package pl.edu.pjwstk.tau;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 07.03.2017.
 */
public class VektorImpl implements Vektor {
    List<Double> vektor = new ArrayList<Double>();

    public void add(Double x) {
        vektor.add(x);
    }

    public List<Double> getVektor() {
        return vektor;
    }

    public Vektor addVektors(Vektor vektor1, Vektor vektor2) throws MyOwnException {
        List<Double> vektorSum = new ArrayList<Double>();
        assert vektor1.getVektor().size() == vektor2.getVektor().size() : "Wektory muszą być tej samej wielkości";
        if(vektor1.getVektor().size()!=vektor2.getVektor().size()) throw new MyOwnException("Wektory musza być samej wielkości");
        if(vektor1.getVektor().isEmpty()) throw new MyOwnException("Wektor nie moze byc pusty");
        else {
            for (Double e : vektor1.getVektor()) {
                vektorSum.add(e + vektor2.getVektor().get(vektor1.getVektor().indexOf(e)));
            }
        }
        Vektor vektorSuma = new VektorImpl();
        vektorSuma.setVektor(vektorSum);
        return vektorSuma;
    }

    public Vektor subVektors(Vektor vektor1, Vektor vektor2) throws MyOwnException {
        List<Double> vektorSum = new ArrayList<Double>();
        assert vektor1.getVektor().size() == vektor2.getVektor().size() : "Wektory muszą być tej samej wielkości";
        if(vektor1.getVektor().size()!=vektor2.getVektor().size()) throw new MyOwnException("Wektory musza być samej wielkości");
        if(vektor1.getVektor().isEmpty()) throw new MyOwnException("Wektor nie moze byc pusty");
        else {
            for (Double e : vektor1.getVektor()) {
                vektorSum.add(e - vektor2.getVektor().get(vektor1.getVektor().indexOf(e)));
            }
        }
        Vektor vektorSuma = new VektorImpl();
        vektorSuma.setVektor(vektorSum);
        return vektorSuma;
    }

    public void setVektor(List<Double> vektor) {
        this.vektor = vektor;
    }
}
