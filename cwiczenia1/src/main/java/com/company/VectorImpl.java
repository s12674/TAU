package com.company;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 28.02.2017.
 */
public class VectorImpl implements Vector {
    List<Double> VektorSum = new ArrayList<Double>();

    public List<Double> getVektorSum() {
        return VektorSum;
    }

    public void setVektorSum(List<Double> vektorSum) {
        VektorSum = vektorSum;
    }

    public List<Double> add(List<Double> Vektor1, List<Double> Vektor2) throws MyOwnException {
        assert Vektor1.size() == Vektor2.size() : "Wektory muszą być równe";
        if(Vektor1.size()!=Vektor2.size()) throw new MyOwnException("Wektory musza byc takie same");
        else {
            for (Double e : Vektor1) {
                VektorSum.add(e + Vektor2.get(Vektor1.indexOf(e)));
            }
            return VektorSum;
        }
    }
}
