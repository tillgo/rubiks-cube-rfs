package de.adv.rfsprojekt.rubiks_solver;

import de.adv.rfsprojekt.util.CubeColor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RubiksReader {

    private List<CubeColor> upperColors;
    private List<CubeColor> frontColors;
    private List<CubeColor> leftColors;
    private List<CubeColor> rightColors;
    private List<CubeColor> backColors;
    private List<CubeColor> downColors;


    public void readIn() {
        //Upper-Face anfahren
        //Thread.sleep(10000)
        //Upper einlesen (upperColors = bliblablub)

        //Front-Face anfahren
        //Thread.sleep(10000)
        //Front einlesen (frontColors = bliblablub)

        //...


        //Wenn alles Faces eingelesen und Cube zurück in Startposi:


        //Solver aufrufen und solving String returnen
    }

}
