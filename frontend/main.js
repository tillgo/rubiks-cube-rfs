﻿/*
corners  _.-'-._                 edges    _.-'-._
     _.-'-._3_.-'-._                  _.-'-._ _.-'-._
 _.-'-._ _.-'-._ _.-'-._          _.-'-._1_.-'-._3_.-'-._
|-._ _.-'-._U_.-'-._ _.-|        |-._ _.-'-._U_.-'-._ _.-|
| 1 |-._ _.-'-._ _.-| 2 |        |   |-._ _.-'-._ _.-|   |
|-._|   |-._ _.-|   |_.-|        |-._| 0 |-._ _.-| 2 |_.-|
|   |-._|   0   |_.-|   |        | 9 |-._|   |   |_.-| 10|
|-._| F |-._|_.-| R |_.-|        |-._| F |-._|_.-| R |_.-|
| 5 |-._|   |   |_.-| 6 |   5--> |   |-._|  8|   |_.-|   | <--7
'-._|   |-._|_.-|   |_.-'        '-._| 4 |-._|_.-| 6 |_.-'
    '-._|   |   |_.-'                '-._|   |   |_.-'
        '-._4_.-'                        '-._|_.-'

u(weiß) f(green)   R(red)   L(orange)   B(blue)    D(yellow)
up      front      right    left        back       down
*/

var layers = {
	u: {corners: [0, 1, 3, 2], edges: [0, 1, 3, 2]},
	f: {corners: [1, 0, 4, 5], edges: [0, 8, 4, 9]},
	r: {corners: [0, 2, 6, 4], edges: [6, 8, 2, 10]},
	l: {corners: [3, 1, 5, 7], edges: [1, 9, 5, 11]},
	b: {corners: [2, 3, 7, 6], edges: [3, 11, 7, 10]},
	d: {corners: [4, 6, 7, 5], edges: [4, 6, 7, 5]}
};
let merker = 0;
var step;
let rot_side;
var prevSide = '';

/** Adds classes to cubies to start animation. */
function move(turn) { // turn examples: 'r1', 'd2', 'u3'
	var side = turn[0];
	var layer = layers[side];
	var m = document.querySelector('.cubie-middle-' + side);
	var cubies = [m.parentNode];
	for(var i=0; i<layer.corners.length; ++i) {
		var c = document.querySelector('.cubie-corner-position-' + layer.corners[i]);
		cubies.push(c.parentNode);
	}
	for(var i=0; i<layer.edges.length; ++i) {
		var e = document.querySelector('.cubie-edge-position-' + layer.edges[i]);
		cubies.push(e.parentNode);
	}
	for(var i=0; i<cubies.length; ++i) {
		cubies[i].classList.add('turn');
		cubies[i].classList.add('turn-' + turn);
	}
}


/**	Updates classes of cubie. This should be called on completion of
	animation for every cubie that was involved in animation. */
function updateCubie() {
	var match = this.className.match(/turn\-(..)/);
	this.classList.remove('turn');
	this.classList.remove(match[0]);
	
	var step = +match[1][1];
	var side = match[1][0];
	var layer = layers[side];
	var div = this.children[0];
	
	var re = /(cubie-corner-position-)(\d+)/;
	if(match = div.className.match(re)) {
		var idx = layer.corners.indexOf(+match[2]);
		var newVal = layer.corners[(idx + step)&3];
		div.className = div.className.replace(re, '$1' + newVal);
		
		div = div.children[0];
		re = /(cubie-corner-orientation-)(\d+)/;
		match = div.className.match(re);
		newVal = (+match[2] + (side!='u' && side!='d') * (step&1) * (1+(idx&1))) % 3;
		div.className = div.className.replace(re, '$1' + newVal);
	}
	
	re = /(cubie-edge-position-)(\d+)/;
	if(match = div.className.match(re)) {
		var idx = layer.edges.indexOf(+match[2]);
		var newVal = layer.edges[(idx + step)&3];
		div.className = div.className.replace(re, '$1' + newVal);
		
		div = div.children[0];
		re = /(cubie-edge-orientation-)(\d+)/;
		match = div.className.match(re);
		newVal = +match[2]^(side=='f' || side=='b')&step;
		div.className = div.className.replace(re, '$1' + newVal);
	}
}
//-----------------------------------------------------------------
//let id = document.getElementById('u_1_9');

const btn_wg = document.getElementById('btn_WG');

btn_wg.addEventListener('click', function onClick() {
merker = 1;
step = 2;
rot_side = 'u';
prevSide = '';
//nextMove();
 let rotation_X = 0-20;
 let rotation_Y = 0-30;
 let rotation_Z = 0-0;
 var turn = 1;
 const $ = document.querySelector.bind(document);
$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
const myTimeout = setTimeout(nextMove, 2500);
});

//------------------------------------------------------------------
const btn_gy = document.getElementById('btn_GY');

btn_gy.addEventListener('click', function onClick() {
merker = 1;
step = 2;
rot_side = 'f';
prevSide = '';
 let rotation_X = 90-20;
 let rotation_Y = 0-0;
 let rotation_Z = 30-0;
 var turn = 1;
 const $ = document.querySelector.bind(document);
$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
const myTimeout = setTimeout(nextMove, 2500);
});

//------------------------------------------------------------------
const btn_oy = document.getElementById('btn_OY');

btn_oy.addEventListener('click', function onClick() {
merker = 1;
step = 2;
rot_side = 'l';
prevSide = '';
 let rotation_X = 0-20;
 let rotation_Y = 90-30;
 let rotation_Z = 90-0;
 var turn = 1;
 const $ = document.querySelector.bind(document);
$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
const myTimeout = setTimeout(nextMove, 2500);
});

//------------------------------------------------------------------
const btn_by = document.getElementById('btn_BY');

btn_by.addEventListener('click', function onClick() {
merker = 1;
step = 2;
rot_side = 'b';
prevSide = '';
 let rotation_X = 0-110;
 let rotation_Y = 0-0;
 let rotation_Z = 180-30;
 var turn = 1;
 const $ = document.querySelector.bind(document);
$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
const myTimeout = setTimeout(nextMove, 2500);
});

//------------------------------------------------------------------
const btn_ry = document.getElementById('btn_RY');

btn_ry.addEventListener('click', function onClick() {
merker = 1;
step = 2;
rot_side = 'r';
prevSide = '';
 let rotation_X = 0-20;
 let rotation_Y = 0-120;
 let rotation_Z = 0-90;
 var turn = 1;
 const $ = document.querySelector.bind(document);
$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
const myTimeout = setTimeout(nextMove, 2500);
});

//------------------------------------------------------------------
const btn_yo = document.getElementById('btn_YO');

btn_yo.addEventListener('click', function onClick() {
merker = 1;
step = 2;
rot_side = 'd';
prevSide = '';
 let rotation_X = 180-20;
 let rotation_Y = 0-70;
 let rotation_Z = 0-0;
 var turn = 1;
 const $ = document.querySelector.bind(document);
$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
const myTimeout = setTimeout(nextMove, 2500);
});

//------------------------------------------------------------------
/*	Generates and executes random move */ 
var nextMove = function() {
	//var prevSide = '';
	//var sides = ['u','f','r','l','b','d'];
	return function() {
		if(document.querySelector('.cube-layer.turn')) return;
		var side = prevSide;
		//alert (side + prevSide);
		if (merker == 1) {
			while(side == prevSide) side = rot_side; //sides[Math.random()*6|0];
			//var step = 1 + (Math.random()*3|0);
			setTimeout(function() {move(side+step)}, 10);
			prevSide = side;
			merker = 0;
		}	
	};
}();


(function() {
	// add `transitionend` listeners for updating classes and starting next move
	var layerDivs = document.querySelectorAll('.cube-layer');
	for(var i=0; i<layerDivs.length; ++i) {
		layerDivs[i].addEventListener('transitionend', updateCubie, true);
		layerDivs[i].addEventListener('transitionend', nextMove, true);
	}
})();


// start the first move
//nextMove();