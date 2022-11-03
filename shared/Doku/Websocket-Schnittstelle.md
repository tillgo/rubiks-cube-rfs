# Websucker-Schniddsdelle Defincion

Messages werden im JSON(Derulo)-Format ausgetauscht

## Manual-Movement-Websocket:
Pfad: /manual/{clientname}

Kann die gleichen Movements wie die Manuellsen Moves beim Teach-Panel

RoboterArm bewegen (Lineare Moves):

Positive X-Achse:   
{"moveType": "ROBO_ARM", "moveDirection": "X_PLUS"}      
Negative X-Achse:     
{"moveType": "ROBO_ARM", "moveDirection": "X_MINUS"}   
Positive Y-Achse:      
{"moveType": "ROBO_ARM", "moveDirection": "Y_PLUS"}      
Negative Y-Achse:  
{"moveType": "ROBO_ARM", "moveDirection": "Y_MINUS"}    
Positive Z-Achse:   
{"moveType": "ROBO_ARM", "moveDirection": "Z_PLUS"}     
Negative Z-Achse:    
{"moveType": "ROBO_ARM", "moveDirection": "Z_MINUS"}

TCP Orientation  
Positive X-Achse:   
{"moveType": "ROBO_TOOL", "moveDirection": "X_PLUS"}  
Negative X-Achse:  
{"moveType": "ROBO_TOOL", "moveDirection": "X_MINUS"}  
Positive Y-Achse:   
{"moveType": "ROBO_TOOL", "moveDirection": "Y_PLUS"}    
Negative Y-Achse:  
{"moveType": "ROBO_TOOL", "moveDirection": "Y_MINUS"}  
Positive Z-Achse:     
{"moveType": "ROBO_TOOL", "moveDirection": "Z_PLUS"}     
Negative Z-Achse:  
{"moveType": "ROBO_TOOL", "moveDirection": "Z_MINUS"}  


Gripper Bewegen  
Gripper Öffnen    
{"moveType": "GRIPPER", "moveDirection": "OPEN"}   
Gripper Schließen    
{"moveType": "GRIPPER", "moveDirection": "CLOSE"}

 




