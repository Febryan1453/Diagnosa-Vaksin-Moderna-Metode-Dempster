package com.example.dempster.app;

import java.util.ArrayList;
import java.util.List;

public class Dempter {
    public double hasil[] = new double[20];
    public double bel[] = new double[20];
    public List<Integer> setusers = new ArrayList();
    private double teta;
    public int gejalaterpilih;
    public String penyakit[] = new String[]{"Anda Positif","Anda Negatif"};
    public double believe[] = new
            double[]{0.6,
            0.5,
            0.5,
            0.6,
            0.5,
            0.8,
            0.5,
            0.6,
            0.5,
            0.6,
            0.6,
            0.6,
            0.8,
            0.6,
            0.6,
            0.8,
            0.8,
            0.6,
            0.6,
            0.8};
    public int rule[][] = new
            int[][]{{1, 2, 3, 4, 5},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 4, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 3, 0, 0},
            {0, 2, 0, 0, 0},
            {0, 0, 3, 0, 0},
            {0, 2, 0, 0, 0},
            {0, 2, 3, 0, 0},
            {0, 0, 3, 0, 5},
            {0, 0, 0, 0, 5},
            {0, 0, 3, 0, 5},
            {0, 0, 0, 4, 0},
            {0, 0, 0, 4, 0},
            {0, 0, 0, 4, 0},
            {0, 2, 0, 0, 5},
            {1, 2, 0, 0, 0},
            {1, 0, 0, 0, 0}};
    private Integer imax;
    private String Penangananterpilh;
    // private String penanganan1;
    public int ipenyakit;

    public Integer getImax() {
        return imax;
    }

    public Dempter(List<Integer> setusers) {
        this.setusers = setusers;
    }

    public void rumus() {
        Integer k = 0;
        int hold[] = new int[20];
        int l = 0;
        for (Integer i : setusers) {
            bel[k] = believe[i];
            hold[k] = i;
            k++;
        }
        gejalaterpilih = k;
        dst();
        Integer max = 0;
        Integer temp = 0;
        for (double cek : bel) {
            if (hasil[max] < hasil[temp]) {
                max = temp;
            }
            temp++;
        }
        ipenyakit = hold[max];
        imax = max;
    }

    // public String getPenanganan1() {
    // return penanganan1;
    // }
    public double persentase() {
        rumus();
        return bel[imax];
    }

    public String getPenangananterpilh() {
        return Penangananterpilh;
    }

    public String getDiagnosapenyakit() {
        rumus();
        Penangananterpilh = "";
        String j = "";
        int status = 0;
        for (int a = 0; a < 5; a++) {
            int b;
            b = rule[ipenyakit][a];
            if (b > 0) {
                if (status > 0) {
                    j += ", ";
                    Penangananterpilh += "\n\n--------------------\n\n";
                    // penanganan1+="/n____________/n";
                }
                j += penyakit[b - 1];
                // penanganan1+=penanganan[b-1];
                status++;
            }
        }
        return j;
    }

    private double env(double o, Integer a) {
        double x = 0;
        for (int i = 0; i <= a; i++) {
            x = x + (bel[i] * o);
        }
        return 1 - x;
    }

    public void dst() {
        for (int i = 0; i <= gejalaterpilih - 2; i++) {
            if (i == 0) {
                teta = 1 - bel[i];
            }
            for (int j = 0; j <= i; j++) {
                hasil[j] = (bel[j] * (1 - bel[i + 1])) / env(bel[i + 1], i);
            }
            hasil[i + 1] = (teta * (bel[i + 1])) / env(bel[i + 1], i);
            teta = (teta * (1 - bel[i + 1])) / env(bel[i + 1], i);
            for (int k = 0; k <= i + 1; k++) {
                bel[k] = hasil[k];
            }
        }
    }
}
