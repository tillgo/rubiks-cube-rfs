/*
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
const clientAdress = '192.168.56.1';
var layers = {
	u: { corners: [0, 1, 3, 2], edges: [0, 1, 3, 2] },
	f: { corners: [1, 0, 4, 5], edges: [0, 8, 4, 9] },
	r: { corners: [0, 2, 6, 4], edges: [6, 8, 2, 10] },
	l: { corners: [3, 1, 5, 7], edges: [1, 9, 5, 11] },
	b: { corners: [2, 3, 7, 6], edges: [3, 11, 7, 10] },
	d: { corners: [4, 6, 7, 5], edges: [4, 6, 7, 5] }
};
let merker_rot_face = 0;
var step;
var prevSide = '';
let rotation_X;
let rotation_Y;
let rotation_Z;
let rot_side = 'u';
var turn = 1;
let merker_face = "w";
let face_delay = 100;
let rot_delay = 80;

/** Adds classes to cubies to start animation. */
function move(turn) { // turn examples: 'r1', 'd2', 'u3'
	var side = turn[0];
	var layer = layers[side];
	var m = document.querySelector('.cubie-middle-' + side);
	var cubies = [m.parentNode];
	for (var i = 0; i < layer.corners.length; ++i) {
		var c = document.querySelector('.cubie-corner-position-' + layer.corners[i]);
		cubies.push(c.parentNode);
	}
	for (var i = 0; i < layer.edges.length; ++i) {
		var e = document.querySelector('.cubie-edge-position-' + layer.edges[i]);
		cubies.push(e.parentNode);
	}
	for (var i = 0; i < cubies.length; ++i) {
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
	if (match = div.className.match(re)) {
		var idx = layer.corners.indexOf(+match[2]);
		var newVal = layer.corners[(idx + step) & 3];
		div.className = div.className.replace(re, '$1' + newVal);

		div = div.children[0];
		re = /(cubie-corner-orientation-)(\d+)/;
		match = div.className.match(re);
		newVal = (+match[2] + (side != 'u' && side != 'd') * (step & 1) * (1 + (idx & 1))) % 3;
		div.className = div.className.replace(re, '$1' + newVal);
	}

	re = /(cubie-edge-position-)(\d+)/;
	if (match = div.className.match(re)) {
		var idx = layer.edges.indexOf(+match[2]);
		var newVal = layer.edges[(idx + step) & 3];
		div.className = div.className.replace(re, '$1' + newVal);

		div = div.children[0];
		re = /(cubie-edge-orientation-)(\d+)/;
		match = div.className.match(re);
		newVal = +match[2] ^ (side == 'f' || side == 'b') & step;
		div.className = div.className.replace(re, '$1' + newVal);
	}
}
//-----------------------------------------------------------------
function setButtontextColor(color) {
	document.getElementById("text-invert").style.color = color;
}


const btn_wg = document.getElementById('btn_WG');

btn_wg.addEventListener('click', function onClick() {
	document.getElementById("btn_rot_face").style.background = "white"
	document.getElementById("btn_GY").disabled = false;
	document.getElementById("btn_OY").disabled = false;
	document.getElementById("btn_BY").disabled = false;
	document.getElementById("btn_RY").disabled = false;
	document.getElementById("btn_YO").disabled = false;
	setButtontextColor("black");

	merker_rot_face = 0;
	step = 1;
	rot_side = 'u';
	prevSide = '';
	//nextMove();
	rotation_X = 0 - 20;
	rotation_Y = 0 - 30;
	rotation_Z = 0 - 0;
	var turn = 1;
	const $ = document.querySelector.bind(document);
	$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
	const myTimeout = setTimeout(nextMove, rot_delay);
	setTimeout(() => {
		document.getElementById("btn_GY").disabled = false;
		document.getElementById("btn_OY").disabled = false;
		document.getElementById("btn_BY").disabled = false;
		document.getElementById("btn_RY").disabled = false;
		document.getElementById("btn_YO").disabled = false;
	}, face_delay);

});

//------------------------------------------------------------------
const btn_gy = document.getElementById('btn_GY');

btn_gy.addEventListener('click', function onClick() {
	document.getElementById("btn_rot_face").style.background = "green"
	document.getElementById("btn_WG").disabled = false;
	document.getElementById("btn_OY").disabled = false;
	document.getElementById("btn_BY").disabled = false;
	document.getElementById("btn_RY").disabled = false;
	document.getElementById("btn_YO").disabled = false;
	setButtontextColor("white");
	merker_rot_face = 0;
	step = 1;
	rot_side = 'f';
	prevSide = '';
	rotation_X = 90 - 20;
	rotation_Y = 0 - 0;
	rotation_Z = 30 - 0;
	var turn = 1;
	const $ = document.querySelector.bind(document);
	$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
	const myTimeout = setTimeout(nextMove, rot_delay);
	setTimeout(() => {
		document.getElementById("btn_WG").disabled = false;
		document.getElementById("btn_OY").disabled = false;
		document.getElementById("btn_BY").disabled = false;
		document.getElementById("btn_RY").disabled = false;
		document.getElementById("btn_YO").disabled = false;
	}, face_delay);
});

//------------------------------------------------------------------
const btn_oy = document.getElementById('btn_OY');

btn_oy.addEventListener('click', function onClick() {
	document.getElementById("btn_rot_face").style.background = "orange"
	document.getElementById("btn_WG").disabled = false;
	document.getElementById("btn_GY").disabled = false;
	document.getElementById("btn_BY").disabled = false;
	document.getElementById("btn_RY").disabled = false;
	document.getElementById("btn_YO").disabled = false;
	setButtontextColor("black");
	merker_rot_face = 0;
	step = 2;
	rot_side = 'l';
	prevSide = '';
	let rotation_X = 0 - 20;
	let rotation_Y = 90 - 30;
	let rotation_Z = 90 - 0;
	var turn = 1;
	const $ = document.querySelector.bind(document);
	$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
	const myTimeout = setTimeout(nextMove, rot_delay);

	setTimeout(() => {
		document.getElementById("btn_WG").disabled = false;
		document.getElementById("btn_GY").disabled = false;
		document.getElementById("btn_BY").disabled = false;
		document.getElementById("btn_RY").disabled = false;
		document.getElementById("btn_YO").disabled = false;
	}, face_delay);
});

//------------------------------------------------------------------
const btn_by = document.getElementById('btn_BY');

btn_by.addEventListener('click', function onClick() {
	document.getElementById("btn_rot_face").style.background = "blue"
	document.getElementById("btn_WG").disabled = false;
	document.getElementById("btn_GY").disabled = false;
	document.getElementById("btn_OY").disabled = false;
	document.getElementById("btn_RY").disabled = false;
	document.getElementById("btn_YO").disabled = false;
	setButtontextColor("white");

	merker_rot_face = 0;
	step = 1;
	rot_side = 'b';
	prevSide = '';
	let rotation_X = 0 - 110;
	let rotation_Y = 0 - 0;
	let rotation_Z = 180 - 30;
	var turn = 1;
	const $ = document.querySelector.bind(document);
	$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
	const myTimeout = setTimeout(nextMove, 2500);
	setTimeout(() => {
		document.getElementById("btn_WG").disabled = false;
		document.getElementById("btn_GY").disabled = false;
		document.getElementById("btn_OY").disabled = false;
		document.getElementById("btn_RY").disabled = false;
		document.getElementById("btn_YO").disabled = false;
	}, face_delay);
});

//------------------------------------------------------------------
const btn_ry = document.getElementById('btn_RY');

btn_ry.addEventListener('click', function onClick() {
	document.getElementById("btn_rot_face").style.background = "red"
	document.getElementById("btn_WG").disabled = false;
	document.getElementById("btn_GY").disabled = false;
	document.getElementById("btn_OY").disabled = false;
	document.getElementById("btn_BY").disabled = false;
	document.getElementById("btn_YO").disabled = false;
	setButtontextColor("black");
	merker_rot_face = 0;
	step = 2;
	rot_side = 'r';
	prevSide = '';
	let rotation_X = 0 - 20;
	let rotation_Y = 0 - 120;
	let rotation_Z = 0 - 90;
	var turn = 1;
	const $ = document.querySelector.bind(document);
	$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
	const myTimeout = setTimeout(nextMove, rot_delay);
	setTimeout(() => {
		document.getElementById("btn_WG").disabled = false;
		document.getElementById("btn_GY").disabled = false;
		document.getElementById("btn_OY").disabled = false;
		document.getElementById("btn_RY").disabled = false;
		document.getElementById("btn_YO").disabled = false;
	}, face_delay);
});

//------------------------------------------------------------------
const btn_yo = document.getElementById('btn_YO');

btn_yo.addEventListener('click', function onClick() {
	document.getElementById("btn_rot_face").style.background = "yellow"
	document.getElementById("btn_WG").disabled = false;
	document.getElementById("btn_GY").disabled = false;
	document.getElementById("btn_OY").disabled = false;
	document.getElementById("btn_BY").disabled = false;
	document.getElementById("btn_RY").disabled = false;
	setButtontextColor("black");
	merker_rot_face = 0;
	step = 2;
	rot_side = 'd';
	prevSide = '';
	let rotation_X = 180 - 20;
	let rotation_Y = 0 - 70;
	let rotation_Z = 0 - 0;
	var turn = 1;
	const $ = document.querySelector.bind(document);
	$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
	const myTimeout = setTimeout(nextMove, rot_delay);
	setTimeout(() => {
		document.getElementById("btn_WG").disabled = false;
		document.getElementById("btn_GY").disabled = false;
		document.getElementById("btn_OY").disabled = false;
		document.getElementById("btn_BY").disabled = false;
		document.getElementById("btn_RY").disabled = false;
	}, face_delay);
});

//------------------------------------------------------------------
const face_rot = document.getElementById('btn_rot_face');

face_rot.addEventListener('click', function onClick() {
	merker_rot_face = 1;
	step = 1;

	prevSide = '';
	/*
	 let rotation_X = 180-20;
	 let rotation_Y = 0-70;
	 let rotation_Z = 0-0;*/
	var turn = 1;
	// const $ = document.querySelector.bind(document);
	//$(".cube").style.transform = `rotateX(${rotation_X}deg) rotateY(${rotation_Y}deg) rotateZ(${rotation_Z}deg)`;
	//const myTimeout = setTimeout(nextMove, 10);
	nextMove();
});






//------------------------------------------------------------------
/*	Generates and executes random move */
var nextMove = function () {
	//var prevSide = '';
	//var sides = ['u','f','r','l','b','d'];
	return function () {
		if (document.querySelector('.cube-layer.turn')) return;
		var side = prevSide;
		//alert (side + prevSide);
		if (merker_rot_face == 1) {
			while (side == prevSide) side = rot_side; //sides[Math.random()*6|0];
			//var step = 1 + (Math.random()*3|0);
			setTimeout(function () { move(side + step) }, 10);
			prevSide = side;
			merker_rot_face = 0;
		}
	};
}();


(function () {
	// add `transitionend` listeners for updating classes and starting next move
	var layerDivs = document.querySelectorAll('.cube-layer');
	for (var i = 0; i < layerDivs.length; ++i) {
		layerDivs[i].addEventListener('transitionend', updateCubie, true);
		layerDivs[i].addEventListener('transitionend', nextMove, true);
	}
})();


// start the first move
//nextMove();

//Tooltip Bootstrap
$(function () {
	$('[data-toggle="tooltip"]').tooltip();
});

/*=============================================================*/
/*=========================Websocket===========================*/
/*=============================================================*/

const Z_PLUS = document.getElementById('Z_PLUS');
const Z_MINUS = document.getElementById('Z_MINUS');
const Y_PLUS = document.getElementById('Y_PLUS');
const X_MINUS = document.getElementById('X_MINUS');
const X_PLUS = document.getElementById('X_PLUS');
const Y_MINUS = document.getElementById('Y_MINUS');

//Array of Elements that trigger a message to Backend
var socketElementArray = [Z_MINUS, Z_PLUS, Y_MINUS, Y_PLUS, X_MINUS, X_PLUS];

//ToDo: Add Modus Robo Arm / Tool

//Manuelle Steuerung
var interval;  //Global ID of mouse down interval
async function mousedown(event) {
	//Check what element gets pressed
	var mouseElement = document.elementFromPoint(event.clientX, event.clientY);
	//
	interval = setInterval(() => whilemousedown(mouseElement), 100); // update every 10ms

	whilemousedown(mouseElement);
	//console.log(interval);
}
function mouseup(event) {
	window.clearInterval(interval);
	interval = null;
	// timer is no longer "running"


}
function whilemousedown(elementFromPoint) {
	socketElementArray.forEach(element => {
		if (element == elementFromPoint) {
			//If Backend-Button, send info per websocket
			console.log(`{"commandType": "ROBO_ARM", "command": "` + element.id + `"}`);
			socketManual.send(`{"type": "COMMAND", "payload": {"commandType": "ROBO_ARM", "command": "` + element.id + `"}}`);
		}
	});
}

//let socketManual = new WebSocket("wss://"+clientAdress+"/manual/{clientname}");
let socketManual = new WebSocket("ws://localhost:1337");
//wss://javascript.info/article/websocket/demo/hello
//let socketManual = new WebSocket("ws://localhost:8080/manual/deinpopa");

socketManual.onopen = function (e) {

	//Assign events
	document.addEventListener("mousedown", mousedown);
	document.addEventListener("mouseup", mouseup);
	//Also clear the interval when user leaves the window with mouse
	document.addEventListener("mouseout", mouseup);
	//alert("[open] Connection established");


};

socketManual.onmessage = function (event) {
	//alert(`[message] Data received from server: ${event.data}`);
	console.log(event.data);
};

socketManual.onclose = function (event) {
	if (event.wasClean) {
		alert(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
	} else {
		// e.g. server process killed or network down
		// event.code is usually 1006 in this case
		alert('[close] Connection died');
	}
};

socketManual.onerror = function (error) {
	alert(`[error]`);
};

//Cube solver socket


//let socketSolver = new WebSocket("ws://localhost:8080/cube-solver/deinpopa");
let socketSolver = new WebSocket("ws://localhost:1337");
//wss://"+clientAdress+"/cube-solver/{clientname}
//wss://javascript.info/article/websocket/demo/hello

socketSolver.onopen = function (e) {
	console.log("Solver open");

	const START_SCAN = document.getElementById('START_SCAN');
	const START_SOLVE = document.getElementById('START_SOLVE');
	const STOP = document.getElementById('STOP');

	START_SCAN.addEventListener('click', function onClick() {
		//socketSolver.send(`{"type": "COMMAND", "payload": {"command": "START_SCAN"}}`);
		console.log('### Echo trigger ###');
		socketSolver.send(`{"type": "COMMAND", "payload": 
		{"infoType": "SCAN_FINISHED",   
			"data": {
				  "cubeStructure" : "GGGGGGGGGWWWWWWWWWRRRRRRRRRBBBBBBBBBYYYYYYYYYOOOOOOOOO",
				  "solvingPath": [{"face": "R", "count": 1},{"face": "G", "count": 2}]
				 }
	   	}`);
	});
	START_SOLVE.addEventListener('click', function onClick() {
		//socketSolver.send(`{"type": "COMMAND", "payload": {"command": "START_SOLVE"}}`);
		console.log('### Echo trigger ###');
		socketSolver.send(`{"type": "COMMAND", "payload": 
			{"infoType": "CUBE_UPDATE",
				"data": {
					  "nthMove": 1,
					  "moveSum": 3,
					  "move": {"face": "R", "count": -1}
					}               
	   		}`);
	});
	STOP.addEventListener('click', function onClick() {
		socketSolver.send(`{"type": "COMMAND", "payload": {"command": "STOP"}}`);

	});
}
socketSolver.onmessage = function (event) {
	console.log(event.data);
	const jasonMessage = JSON.parse(event.data);
	if (jasonMessage.payload.infoType == "SCAN_FINISHED") {
		console.log("scan sucess");
		$('#START_SOLVE').css("background-color", "rgb(0, 114, 0)");
		$('#START_SOLVE').css("border-color", "rgb(0, 114, 0)");
		$('#btn_WG').click();
		cubeColorSetter(jasonMessage);
	}
	if (jasonMessage.payload.infoType == "CUBE_UPDATE") {
		//ToDo: Richtige Buttons zuordnen
		cubeUpdateHandler(jasonMessage);
	}
};

socketSolver.onclose = function (event) {
	if (event.wasClean) {
		alert(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
	} else {
		// e.g. server process killed or network down
		// event.code is usually 1006 in this case
		alert('[close] Connection died');
	}
};

socketSolver.onerror = function (error) {
	alert(`[error]`);
};



/*=============================================================*/
/*=====================Websocket=Executor======================*/
/*=============================================================*/

//Live cube rotation data handling
async function cubeRotator(jasonObject) {
	var rotateCount;
	if (jasonObject.payload.data.move.count == -1) {
		rotateCount = 3;
	} else {
		rotateCount = jasonObject.payload.data.move.count;
	}
	console.log(rotateCount);
	for (var i = 0; i < rotateCount; i++) {
		await new Promise((resolve, reject) => setTimeout(resolve, 800));
		$('#btn_rot_face').click();
		//console.log(i + 1 + ". rotation");
	}
}
function cubeUpdateHandler(jasonObject) {
	switch (jasonObject.payload.data.move.face) {
		case 'T':
			console.log(jasonObject.payload.data.move.face);
			$('#btn_WG').click();
			break;
		case 'R':
			console.log(jasonObject.payload.data.move.face);
			$('#btn_RY').click();
			break;
		case 'L':
			console.log(jasonObject.payload.data.move.face);
			$('#btn_OY').click();
			break;
		case 'D':
			console.log(jasonObject.payload.data.move.face);
			$('#btn_YO').click();
			break;
		case 'F':
			console.log(jasonObject.payload.data.move.face);
			$('#btn_GY').click();
			break;
		case 'B':
			console.log(jasonObject.payload.data.move.face);
			$('#btn_BY').click();
			break;

	}
	cubeRotator(jasonObject);
}
//Cube structure handler
function cubeColorSetter(jasonObject) {
	let colorString = jasonObject.payload.data.cubeStructure;
	//Translate Colors
	let facecolorArray = [];
	var temp;
	for (var i = 0; i < colorString.length; i++) {
		temp = colorString.charAt(i);
		facecolorArray[i];
		switch (temp) {
			case 'U':
				facecolorArray[i] = 'W';
				break;
			case 'R':
				facecolorArray[i] = 'R';
				break;
			case 'L':
				facecolorArray[i] = 'O';
				break;
			case 'D':
				facecolorArray[i] = 'Y';
				break;
			case 'F':
				facecolorArray[i] = 'G';
				break;
			case 'B':
				facecolorArray[i] = 'B';
				break;
		}
	}
	colorString = facecolorArray.reduce((prev, curr) => prev + curr, '');
	console.log('Color String: '+ colorString);
	let translateArray = [3,6,9,2,5,8,1,4,7];

	let cubeColorArray = [];
	for (var i = 0; i < colorString.length;) {
		var sliceString = colorString.slice(i, i + 9);
		var tempCharArray = [];
		//Translate yellow side
		if(slice.charAt(4) == 'Y'){
			for(var j = 0; j<sliceString.length;){
				tempCharArray[j]=sliceString.charAt(translateArray[j]);
			}
			cubeColorArray[i] = tempCharArray.reduce((prev, curr) => prev + curr, '');
			console.log('Translated String: '+ cubeColorArray[i]);
		}else{
			cubeColorArray[i] = tempSlice;
		}

		console.log(cubeColorArray[i]);
		$('#manuelle_farbeingabe').val(cubeColorArray[i]);
		$('#btn_Color').click();
		i += 9;
	}
}


/*=============================================================*/
/*======================Websocket=ENDE=========================*/
/*=============================================================*/