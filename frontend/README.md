Node.js Manager:
    https://github.com/coreybutler/nvm-windows
Install Angular:
    npm install -g @angular/cli

Betrieb mit Backend von Gruppe 05:
    Der Code ist bereits für den Betrieb mit dem Backend der Gruppe 05 eingestellt.

Betrieb mit Websocket Echo:
    Soll das Frontend im Standalone Modus verwendet werden, muss der beigefügte Websocket-Echo Server eingesetzt werden.
    Zudem müssen im Programmcode einige Anpassungen vorgenommen werden.
        1. Der Wert der socketSolver und socketManual Variablen müssen zu:  new Websocket("ws://localhost:1337") geändert werden.
        2. Bei  socketSolver.onopen müssen bei den eventListener Funtionen die auskommentierten socketSolver.send() wieder aktiviert    werden.
        Dies dient zur Simulation einer Backend-Antwort durch das Echo des Echo-Servers.

Installation des Websocket-Echo Servers:
    Quelle: https://github.com/websockets/websocket-echo-server
    Source Code des Websocket-Echo Servers ist beigelegt
    Readme des Websocket-Echo Servers enthält Installations und Betriebsanweisungen für den Server.

Ausführung des Frontends auf einem apache Server:
Empfohlen:
    Verwendung von XAMPP (https://www.apachefriends.org/download.html)
    frontend Ordner nach xampp/htdocs kopieren
    backend/websocket-echo starten
    xampp apache starten
    Seite unter: http://localhost/frontend/index.html aufrufen
