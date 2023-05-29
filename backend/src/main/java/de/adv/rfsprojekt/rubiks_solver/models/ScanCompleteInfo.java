package de.adv.rfsprojekt.rubiks_solver.models;

import java.util.List;

public record ScanCompleteInfo(String cubeStructure, List<Move> solvingPath) {
}
