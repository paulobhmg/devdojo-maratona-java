package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.text.DateFormat;
import java.util.Calendar;

/* A classe DateFormat é do pacote Java.Text e possui alguns métodos que formatam uma data estilizando-as de acordo
   com um formato predefinido pelo próprio método. */
public class A114_DateFormat {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        DateFormat[] dfs = new DateFormat[7];

        dfs[0] = DateFormat.getInstance();
        dfs[1] = DateFormat.getDateInstance();
        dfs[2] = DateFormat.getDateTimeInstance();
        dfs[3] = DateFormat.getDateInstance(DateFormat.SHORT);
        dfs[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        dfs[5] = DateFormat.getDateInstance(DateFormat.LONG);
        dfs[6] = DateFormat.getDateInstance(DateFormat.FULL);

        for(DateFormat df : dfs){
            System.out.println(df.format(c.getTime()));
        }
    }
}
