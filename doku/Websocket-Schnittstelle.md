# Websucker-Schniddsdelle Defincion

Messages werden im JSON(Derulo)-Format ausgetauscht

## Manual-Movement-Websocket:
Pfad: /manual/{clientname}

Kann die gleichen Movements wie die Manuellsen Moves beim Teach-Panel

### RoboterArm bewegen (Lineare Moves):
Positive X-Achse:   
{"moveType": "ROBO_ARM", "command": "X_PLUS"}      
Negative X-Achse:     
{"moveType": "ROBO_ARM", "command": "X_MINUS"}   
Positive Y-Achse:      
{"moveType": "ROBO_ARM", "command": "Y_PLUS"}      
Negative Y-Achse:  
{"moveType": "ROBO_ARM", "command": "Y_MINUS"}    
Positive Z-Achse:   
{"moveType": "ROBO_ARM", "command": "Z_PLUS"}     
Negative Z-Achse:    
{"moveType": "ROBO_ARM", "command": "Z_MINUS"}

### TCP Orientation  
Positive X-Achse:   
{"moveType": "ROBO_TOOL", "command": "X_PLUS"}  
Negative X-Achse:  
{"moveType": "ROBO_TOOL", "command": "X_MINUS"}  
Positive Y-Achse:   
{"moveType": "ROBO_TOOL", "command": "Y_PLUS"}    
Negative Y-Achse:  
{"moveType": "ROBO_TOOL", "command": "Y_MINUS"}  
Positive Z-Achse:     
{"moveType": "ROBO_TOOL", "command": "Z_PLUS"}     
Negative Z-Achse:  
{"moveType": "ROBO_TOOL", "command": "Z_MINUS"}  


### Gripper Bewegen  
Gripper Öffnen:    
{"moveType": "GRIPPER", "command": "OPEN"}   
Gripper Schließen:    
{"moveType": "GRIPPER", "command": "CLOSE"}

## TODO:

* Gripper aktivieren
* Roboter aktivieren
* Roboter stoppen
* (Fehlermeldungen entfernen / ignorieren)

 




