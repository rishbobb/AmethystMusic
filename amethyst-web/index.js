var place = new Audio("place.ogg");
place.mozPreservesPitch = false
var command = "/song ["

function updateView() {
    document.getElementById("output").innerHTML = command.slice(0, -1) + "]";
}

function onPianoClick1() {
    command = command + "0,";
    updateView();
    place.playbackRate = 0.5;
    place.play();
}

function onPianoClick2() {
    command = command + "1,";
    updateView();
    place.playbackRate = 0.529732;
    place.play();
}

function onPianoClick3() {
    command = command + "2,";
    updateView();
    place.playbackRate = 0.561231;
    place.play();
}

function onPianoClick4() {
    command = command + "3,";
    updateView();
    place.playbackRate = 0.594604;
    place.play();
}

function onPianoClick5() {
    command = command + "4,";
    updateView();
    place.playbackRate = 0.629961;
    place.play();
}

function onPianoClick6() {
    command = command + "5,";
    updateView();
    place.playbackRate = 0.667420;
    place.play();
}

function onPianoClick7() {
    command = command + "6,";
    updateView();
    place.playbackRate = 0.707107;
    place.play();
}

function onPianoClick8() {
    command = command + "7,";
    updateView();
    place.playbackRate = 0.749154;
    place.play();
}

function onPianoClick9() {
    command = command + "8,";
    updateView();
    place.playbackRate = 0.793701;
    place.play();
}

function onPianoClick10() {
    command = command + "9,";
    updateView();
    place.playbackRate = 0.840896;
    place.play();
}

function onPianoClick11() {
    command = command + "10,";
    updateView();
    place.playbackRate = 0.890899;
    place.play();
}

function onPianoClick12() {
    command = command + "11,";
    updateView();
    place.playbackRate = 0.943874;
    place.play();
}

function onPianoClick13() {
    command = command + "12,";
    updateView();
    place.playbackRate = 1;
    place.play();
}

function onPianoClick14() {
    command = command + "13,";
    updateView();
    place.playbackRate = 1.059463;
    place.play();
}

function onPianoClick15() {
    command = command + "14,";
    updateView();
    place.playbackRate = 1.122462;
    place.play();
}

function onPianoClick16() {
    command = command + "15,";
    updateView();
    place.playbackRate = 1.189207;
    place.play();
}

function onPianoClick17() {
    command = command + "16,";
    updateView();
    place.playbackRate = 1.259921;
    place.play();
}

function onPianoClick18() {
    command = command + "17,";
    updateView();
    place.playbackRate = 1.334840;
    place.play();
}

function onPianoClick19() {
    command = command + "18,";
    updateView();
    place.playbackRate = 1.414214;
    place.play();
}

function onPianoClick20() {
    command = command + "19,";
    updateView();
    place.playbackRate = 1.498307;
    place.play();
}

function onPianoClick21() {
    command = command + "20,";
    updateView();
    place.playbackRate = 1.587401;
    place.play();
}

function onPianoClick22() {
    command = command + "21,";
    updateView();
    place.playbackRate = 1.681793;
    place.play();
}

function onPianoClick23() {
    command = command + "22,";
    updateView();
    place.playbackRate = 1.781797;
    place.play();
}

function onPianoClick24() {
    command = command + "23,";
    updateView();
    place.playbackRate = 1.887749;
    place.play();
}

function onPianoClick25() {
    command = command + "24,";
    updateView();
    place.playbackRate = 2;
    place.play();
}

function copyElementText() {
    var text = document.getElementById("output").innerText;
    var elem = document.createElement("textarea");
    document.body.appendChild(elem);
    elem.value = text;
    elem.select();
    document.execCommand("copy");
    document.body.removeChild(elem);
}