const btn_bw = document.getElementById('btn_BW');

btn_bw.addEventListener('click', function onClick() {

//rotation_X = (rotation_X + angle_X) ;
/*let rotation_X = 0;
//const angle_X = 90;
let rotation_Y = 0;
let rotation_Z = 0;
const $ = document.querySelector.bind(document);
$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;*/
 let rotation_X = 0-20;
 let rotation_Y = 90-20;
 let rotation_Z = 90;
 const $ = document.querySelector.bind(document);
$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;

});

//---------------------------------------------------------------------------------