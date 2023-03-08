# Websucker-Schniddsdelle Definicion

Messages werden im JSON(Derulo)-Format ausgetauscht


Alle Messages enthalten einen Type sowie eine entsprechende Payload

``{"type": <type>, "payload": <payload>}``

Es gibt folgende Messagetypes:

- ERROR
- COMMAND
- INFO


## Manual-Movement-Websocket:
Pfad: /manual/{clientname}

Kann die gleichen Movements wie die Manuellsen Moves beim Teach-Panel

### Command-Payloads (Client -> Server)

#### RoboterArm bewegen (Lineare Moves):
Positive X-Achse:   
``{"commandType": "ROBO_ARM", "command": "X_PLUS"}``   
  
Negative X-Achse:     
``{"commandType": "ROBO_ARM", "command": "X_MINUS"}``  
  
Positive Y-Achse:      
``{"commandType": "ROBO_ARM", "command": "Y_PLUS"}`` 
  
Negative Y-Achse:  
``{"commandType": "ROBO_ARM", "command": "Y_MINUS"}``  
  
Positive Z-Achse:   
``{"commandType": "ROBO_ARM", "command": "Z_PLUS"} `` 
  
Negative Z-Achse:    
``{"commandType": "ROBO_ARM", "command": "Z_MINUS"}``

#### TCP Orientation  
Positive X-Achse:   
``{"commandType": "ROBO_TOOL", "command": "X_PLUS"}``  
  
Negative X-Achse:  
``{"commandType": "ROBO_TOOL", "command": "X_MINUS"} `` 
  
Positive Y-Achse:   
``{"commandType": "ROBO_TOOL", "command": "Y_PLUS"}``  
  
Negative Y-Achse:  
``{"commandType": "ROBO_TOOL", "command": "Y_MINUS"}``  
  
Positive Z-Achse:     
``{"commandType": "ROBO_TOOL", "command": "Z_PLUS"}``   
  
Negative Z-Achse:  
``{"commandType": "ROBO_TOOL", "command": "Z_MINUS"}``  


#### Gripper Bewegen  
Gripper aktivieren  
``{"commandType": "GRIPPER", "command": "ACTIVATE"}``
  
Gripper Öffnen:      
``{"commandType": "GRIPPER", "command": "OPEN"}``   
  
Gripper Schließen:      
``{"commandType": "GRIPPER", "command": "CLOSE"}``


#### Robo Setup
Roboter aktivieren  
``{"commandType": "ROBO_SETUP", "command": "ON"}``
  
Roboter deaktivieren  
``{"commandType": "ROBO_SETUP", "command": "OFF"}``


### INFO Payloads (Server -> Client)

#### Robo-Status

    {"infoType": "ROBO_STATUS", 
        "data": {
                          "REDUCED_MODE": <boolean>
                          "SAFETY_STOPPED": <boolean>
                          "ROBOT_EMERGENCY_STOPPED": <boolean>
                          "RECOVERY_MODE": <boolean>
                          "PROTECTIVE_STOPPED": <boolean>
                          "SYSTEM_EMERGENCY_STOPPED": <boolean> 
                          "EMERGENCY_STOPPED": <boolean>
                          "SAFEGUARD_STOPPED": <boolean>
                          "VIOLATION": <boolean>
                          "NORMAL_MODE": <boolean>
                          "FAULT": <boolean> 
    }

### ERROR Payloads

``{"message": <string>}``



## Cube-Solver Websocket
Pfad: /cube-solver/{clientname}  
Schnittstelle für das Lösen des Rubiks-Cubes  

### Command-Payloads (Client -> Server)

Scannen des Würfels starten:  
``{"command": "START_SCAN"}``    

Starten des Lösens des Würfels (Wenn davor nicht gescannt: Error)  
``{"command": "START_SOLVE"}``  

Generelles Stoppen/Abbrechen des gesamten Vorgangs (Sowohl Einlesen als auch Lösen):  
``{"command": "STOP"}``


### Info-Payloads (Server -> Client)
#### Scan-Finished
Liefert die eingelesene Cube-Struktur sowie den berechneten Lösungsweg  

        {"infoType": "SCAN_FINISHED",   
         "data": {
                   "cubeStructure" : "URBLURRL..."
                   "solvingPath": [{"face": "R", "count": 1}, ...]
                  }
        }

- face: T (Top) | R (Right) | L (Left) | D (Down) | F (Front) | B (Back)
- count: -1 (90° Counterclockwise) | 1 (90° Clockwise) |  2 (180° Clockwise, izz aber eigentlich egal wie rum)


#### Cube-Update
Wird immer gesendet, wenn ein neuer Move gestartet wird

        {"infoType": "CUBE_UPDATE",
         "data": {
                   "nthMove": <int>,
                   "moveSum": <int>,
                   "move: {"face": "R", "count": 1}
                 }               
        }

- nthMove: Besagt, der wievielte Move gerade ausgeführt wird
- moveSum: Gesamtanzahl an Moves zum Lösen ders Cubes
- move: Siehe Scan-Finished

### Error-Payloads (Server -> Client)
``{"message": <string>}``  





 




