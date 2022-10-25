package it.fi.meucci;

import java.io.File;
import java.sql.Date;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        int k=1;
        switch (k) 
        {
            case 0: //inizializzazione e valorizzazione classe
                Classe c1 = new Classe();
                Alunno a1 = new Alunno("Daniele", "Noccioli", new Date(2004, 06, 07));
                Alunno a2 = new Alunno("Lorenzo", "Barzanti", new Date(2004, 10, 11));
                Alunno a3 = new Alunno("Giannetto", "Giannetti", new Date(2009, 11, 26));
                Alunno a4 = new Alunno("ci", "vuole", new Date(2023, 7, 2));
                Alunno a5 = new Alunno("troppa", "fantasia", new Date(2006, 1, 20));
                c1.alunni.add(a1);
                c1.alunni.add(a2);
                c1.alunni.add(a3);
                c1.alunni.add(a4);
                c1.alunni.add(a5);
                XmlMapper xmlMapper = new XmlMapper();
                xmlMapper.writeValue(new File("classe.xml"), c1);
                break;
            case 1: //deserializzazione
                XmlMapper xmlMapper2 = new XmlMapper();
                Classe c2 = xmlMapper2.readValue(new File("classe.xml"), Classe.class);
                System.out.println(c2.getAlunni().get(0));
            break;
        }
    }
}

