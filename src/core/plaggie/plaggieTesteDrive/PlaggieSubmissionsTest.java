/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.plaggie.plaggieTesteDrive;

import static core.plaggie.Plaggie.compare2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import plag.parser.Stats;
import plag.parser.StatsException;

/**
 *
 * @author Luis
 */
public class PlaggieSubmissionsTest {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, NullPointerException {
        
        try {
            Stats.newCounter("files_to_parse");
            Stats.newCounter("file_comparisons");
        } catch (StatsException ex) {
            Logger.getLogger(PlaggieSubmissionsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String alunos[]={"Nivel0","Nivel1","Nivel2","Nivel3","Nivel4","Nivel5","Nivel6","Nivel7","Nivel8"};

        String ficheiros[]={
            "/myGitHub/LEI2016PSI/Algorithmi-Core-Plaggie-Git/algorithmi-code/src/core/plaggie/plaggieTesteDrive/Submissions/Nivel0/Factorial.java.teste",
            "/myGitHub/LEI2016PSI/Algorithmi-Core-Plaggie-Git/algorithmi-code/src/core/plaggie/plaggieTesteDrive/Submissions/Nivel1/Factorial.java.teste",
            "/myGitHub/LEI2016PSI/Algorithmi-Core-Plaggie-Git/algorithmi-code/src/core/plaggie/plaggieTesteDrive/Submissions/Nivel2/Factorial.java.teste",
            "/myGitHub/LEI2016PSI/Algorithmi-Core-Plaggie-Git/algorithmi-code/src/core/plaggie/plaggieTesteDrive/Submissions/Nivel3/Factorial.java.teste",
            "/myGitHub/LEI2016PSI/Algorithmi-Core-Plaggie-Git/algorithmi-code/src/core/plaggie/plaggieTesteDrive/Submissions/Nivel4/Factorial.java.teste",
            "/myGitHub/LEI2016PSI/Algorithmi-Core-Plaggie-Git/algorithmi-code/src/core/plaggie/plaggieTesteDrive/Submissions/Nivel5/Factorial.java.teste",
            "/myGitHub/LEI2016PSI/Algorithmi-Core-Plaggie-Git/algorithmi-code/src/core/plaggie/plaggieTesteDrive/Submissions/Nivel6/Factorial.java.teste",
            "/myGitHub/LEI2016PSI/Algorithmi-Core-Plaggie-Git/algorithmi-code/src/core/plaggie/plaggieTesteDrive/Submissions/Nivel7/Factorial.java.teste",
            "/myGitHub/LEI2016PSI/Algorithmi-Core-Plaggie-Git/algorithmi-code/src/core/plaggie/plaggieTesteDrive/Submissions/Nivel8/Factorial.java.teste"};         
        try{
            System.out.println("\n\t\t==[ N�veis de Detec�ao de Pl�gio ]==\n");
            System.out.println("\n\t N�vel 0 - SEM altera�ao de c�digo:              "+Stats.getPercentage(compare2( ficheiros[0], ficheiros[0])));
            System.out.println("\n\t N�vel 1 - Altera�ao do NOME das vari�veis:      "+Stats.getPercentage(compare2( ficheiros[0], ficheiros[1])));
            System.out.println("\n\t N�vel 2 - Altera�ao da POSI�AO das Vari�veis:   "+Stats.getPercentage(compare2( ficheiros[0], ficheiros[2])));
            System.out.println("\n\t N�vel 3 - Altera�ao da POSI�AO de C�lculo:      "+Stats.getPercentage(compare2( ficheiros[0], ficheiros[3])));
            System.out.println("\n\t N�vel 4 - Altera�ao de EXPRESSOES de c�lculo:   "+Stats.getPercentage(compare2( ficheiros[0], ficheiros[4])));
            System.out.println("\n\t N�vel 5 - Altera�ao de IF por ELSE:             "+Stats.getPercentage(compare2( ficheiros[0], ficheiros[5])));
            System.out.println("\n\t N�vel 6 - Altera�ao de CICLO:                   "+Stats.getPercentage(compare2( ficheiros[0], ficheiros[6])));
            System.out.println("\n\t N�vel 7 - Altera�ao para RECURSIVIDADE:         "+Stats.getPercentage(compare2( ficheiros[0], ficheiros[7])));
            System.out.println("\n\t N�vel 8 - Incorpora�ao de FUN�AO no MAIN:       "+Stats.getPercentage(compare2( ficheiros[0], ficheiros[8])));
            System.out.println("\n");
        }catch (NullPointerException ex) {
            Logger.getLogger(core.plaggie.plaggieTesteDrive.PlaggieSubmissionsTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }  
}
