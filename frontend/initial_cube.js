
let colors ="";
let arrayOfChar;

btn_Color.addEventListener('click', function onClick() {
    init_Sticker();
});

function clickPress(event) {
    if (event.key == "Enter") {
        init_Sticker();
    }
}
function init_Sticker(){
    colors = document.getElementById("sticker_color").value;
    colors = colors.toUpperCase();
    arrayOfChar = Array.from(String (colors));
    sticker();
}

function sticker() {
            //----------------------------------------------
            let Farbe_x_5 = arrayOfChar[4];
            //alert(Farbe_x_5);    
            switch(Farbe_x_5) {
                // Seite mit weißem Mittelblock
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    case "W":
                        //alert("zuerst");
                        color_i = arrayOfChar[0];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('u_1_1').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('u_1_1').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('u_1_1').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('u_1_1').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('u_1_1').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('u_1_1').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[1];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('u_1_2').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('u_1_2').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('u_1_2').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('u_1_2').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('u_1_2').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('u_1_2').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[2];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('u_1_3').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('u_1_3').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('u_1_3').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('u_1_3').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('u_1_3').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('u_1_3').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[3];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('u_1_4').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('u_1_4').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('u_1_4').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('u_1_4').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('u_1_4').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('u_1_4').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[5];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('u_1_6').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('u_1_6').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('u_1_6').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('u_1_6').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('u_1_6').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('u_1_6').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[6];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('u_1_7').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('u_1_7').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('u_1_7').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('u_1_7').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('u_1_7').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('u_1_7').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[7];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('u_1_8').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('u_1_8').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('u_1_8').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('u_1_8').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('u_1_8').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('u_1_8').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[8];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('u_1_9').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('u_1_9').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('u_1_9').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('u_1_9').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('u_1_9').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('u_1_9').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                    break;
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        // Mittelblock Grün
                        
                    case "G":
                        //alert("G");
                        color_i = arrayOfChar[0];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('f_2_1').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('f_2_1').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('f_2_1').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('f_2_1').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('f_2_1').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('f_2_1').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[1];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('f_2_2').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('f_2_2').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('f_2_2').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('f_2_2').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('f_2_2').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('f_2_2').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[2];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('f_2_3').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('f_2_3').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('f_2_3').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('f_2_3').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('f_2_3').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('f_2_3').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[3];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('f_2_4').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('f_2_4').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('f_2_4').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('f_2_4').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('f_2_4').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('f_2_4').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[5];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('f_2_6').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('f_2_6').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('f_2_6').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('f_2_6').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('f_2_6').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('f_2_6').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[6];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('f_2_7').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('f_2_7').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('f_2_7').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('f_2_7').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('f_2_7').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('f_2_7').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[7];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('f_2_8').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('f_2_8').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('f_2_8').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('f_2_8').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('f_2_8').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('f_2_8').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[8];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('f_2_9').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('f_2_9').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('f_2_9').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('f_2_9').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('f_2_9').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('f_2_9').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                    break;
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    case "O":
                        color_i = arrayOfChar[0];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('l_3_1').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('l_3_1').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('l_3_1').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('l_3_1').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('l_3_1').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('l_3_1').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[1];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('l_3_2').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('l_3_2').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('l_3_2').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('l_3_2').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('l_3_2').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('l_3_2').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[2];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('l_3_3').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('l_3_3').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('l_3_3').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('l_3_3').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('l_3_3').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('l_3_3').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[3];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('l_3_4').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('l_3_4').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('l_3_4').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('l_3_4').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('l_3_4').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('l_3_4').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[5];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('l_3_6').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('l_3_6').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('l_3_6').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('l_3_6').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('l_3_6').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('l_3_6').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[6];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('l_3_7').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('l_3_7').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('l_3_7').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('l_3_7').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('l_3_7').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('l_3_7').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[7];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('l_3_8').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('l_3_8').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('l_3_8').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('l_3_8').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('l_3_8').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('l_3_8').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[8];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('l_3_9').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('l_3_9').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('l_3_9').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('l_3_9').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('l_3_9').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('l_3_9').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                    break;
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    case "B":
                        color_i = arrayOfChar[0];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('b_4_1').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('b_4_1').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('b_4_1').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('b_4_1').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('b_4_1').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('b_4_1').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[1];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('b_4_2').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('b_4_2').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('b_4_2').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('b_4_2').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('b_4_2').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('b_4_2').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[2];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('b_4_3').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('b_4_3').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('b_4_3').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('b_4_3').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('b_4_3').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('b_4_3').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[3];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('b_4_4').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('b_4_4').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('b_4_4').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('b_4_4').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('b_4_4').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('b_4_4').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[5];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('b_4_6').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('b_4_6').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('b_4_6').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('b_4_6').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('b_4_6').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('b_4_6').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[6];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('b_4_7').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('b_4_7').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('b_4_7').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('b_4_7').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('b_4_7').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('b_4_7').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[7];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('b_4_8').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('b_4_8').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('b_4_8').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('b_4_8').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('b_4_8').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('b_4_8').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[8];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('b_4_9').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('b_4_9').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('b_4_9').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('b_4_9').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('b_4_9').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('b_4_9').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                    break;           
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    case "R":
                        color_i = arrayOfChar[0];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('r_5_1').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('r_5_1').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('r_5_1').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('r_5_1').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('r_5_1').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('r_5_1').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[1];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('r_5_2').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('r_5_2').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('r_5_2').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('r_5_2').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('r_5_2').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('r_5_2').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[2];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('r_5_3').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('r_5_3').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('r_5_3').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('r_5_3').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('r_5_3').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('r_5_3').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[3];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('r_5_4').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('r_5_4').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('r_5_4').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('r_5_4').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('r_5_4').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('r_5_4').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[5];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('r_5_6').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('r_5_6').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('r_5_6').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('r_5_6').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('r_5_6').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('r_5_6').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[6];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('r_5_7').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('r_5_7').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('r_5_7').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('r_5_7').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('r_5_7').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('r_5_7').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[7];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('r_5_8').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('r_5_8').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('r_5_8').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('r_5_8').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('r_5_8').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('r_5_8').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[8];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('r_5_9').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('r_5_9').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('r_5_9').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('r_5_9').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('r_5_9').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('r_5_9').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                    break;         
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    case "Y":
                        color_i = arrayOfChar[0];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('d_6_1').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('d_6_1').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('d_6_1').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('d_6_1').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('d_6_1').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('d_6_1').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[1];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('d_6_2').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('d_6_2').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('d_6_2').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('d_6_2').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('d_6_2').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('d_6_2').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[2];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('d_6_3').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('d_6_3').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('d_6_3').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('d_6_3').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('d_6_3').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('d_6_3').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[3];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('d_6_4').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('d_6_4').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('d_6_4').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('d_6_4').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('d_6_4').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('d_6_4').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[5];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('d_6_6').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('d_6_6').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('d_6_6').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('d_6_6').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('d_6_6').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('d_6_6').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[6];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('d_6_7').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('d_6_7').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('d_6_7').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('d_6_7').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('d_6_7').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('d_6_7').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[7];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('d_6_8').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('d_6_8').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('d_6_8').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('d_6_8').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('d_6_8').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('d_6_8').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                            color_i = arrayOfChar[8];
                        //alert(color_i);
                            switch(color_i) {
                                case "W":
                                    //alert("W");
                                    document.getElementById('d_6_9').style.backgroundImage = "url('Sticker/White.png')";
                                    break;
                                case "G":
                                    //alert("G");
                                    document.getElementById('d_6_9').style.backgroundImage = "url('Sticker/Green.png')";
                                    break;
                                case "O":
                                    //alert("O");
                                    document.getElementById('d_6_9').style.backgroundImage = "url('Sticker/Orange.png')";
                                    break;
                                case "B":
                                    //alert("B");
                                    document.getElementById('d_6_9').style.backgroundImage = "url('Sticker/Blue.png')";
                                    break;
                                case "R":
                                    //alert("R1");
                                    document.getElementById('d_6_9').style.backgroundImage = "url('Sticker/Red.png')";
                                    break;
                                case "Y":
                                    //alert("Y");
                                    document.getElementById('d_6_9').style.backgroundImage = "url('Sticker/Yellow.png')";
                                    break;
                            }
                    break;          
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                }
       }
