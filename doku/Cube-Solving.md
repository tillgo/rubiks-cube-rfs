# Cube-Solving

Wir nutzen die folgende Library welche den min2phase Algorithmus nutzt: https://github.com/cs0x7f/min2phase

Die Struktur des zu lösenden Cubes muss dabei als String mit folgendem Aufbau bereitsgestellt werden:


                     |************|
                     |*U1**U2**U3*|
                     |************|
                     |*U4**U5**U6*|
                     |************|
                     |*U7**U8**U9*|
                     |************|
        |************|************|************|************|
        |*L1**L2**L3*|*F1**F2**F3*|*R1**R2**R3*|*B1**B2**B3*|
        |************|************|************|************|
        |*L4**L5**L6*|*F4**F5**F6*|*R4**R5**R6*|*B4**B5**B6*|
        |************|************|************|************|
        |*L7**L8**L9*|*F7**F8**F9*|*R7**R8**R9*|*B7**B8**B9*|
        |************|************|************|************|
                     |************|
                     |*D1**D2**D3*|
                     |************|
                     |*D4**D5**D6*|
                     |************|
                     |*D7**D8**D9*|
                     |************|
       
        -> U1 U2 ... U9 R1 ... R9 F1 ... F9 D1 ... D9 L1 ... L9 B1 ... B9


- U = Upper-Face = Weiß
- R = Right-Face = Rot
- F = Front-Face = Grün
- D = Down-Face = Gelb
- L = Left-Face = Orange
- B = Back-Face = Blau


# Ablauf des Lösungsprozesses aus Frontend-Sicht
1. Frontend schickt befehl zum Einlesen von Würfel
2. Backend schickt Fortschritt an Frontend (1/6, 2/6,... Seiten eingelesen)
3. Wenn fertig eingelesen: Backend schickt Würfelstruktur an Frontend
4. Frontend schickt Befehl für Lösen von Würfel
5. Backend schickt Fortschritt und den Move der aktuell ausgeführt wird,
   ans Frontend
6. Frontend kann zu jeder Zeit Prozess abbrechen