//1. 선택자
let d1 = document.getElementById("d1");
let d2 = document.getElementById("d2");
let d3 = document.getElementById("d3");
let year = document.getElementById("year");
let month = document.getElementById("month");
let date = document.getElementById("date");
let d4 = document.getElementById("d4");
// alert(d1.value);
// alert(d1.getAttribute("value"));

d2.type="button";
d2.setAttribute("type", "button");

let count = window.prompt("숫자를 입력하세요");
let t="";
for(let i=0; i<count; i++){
    t=t+'<input type="text">';
}
d3.innerHTML=t;

let y="";
for(let i=2022; i>=1900; i--){
    y=y+'<option>'+i+'</option>';
}
year.innerHTML=y;

let m="";
for(let i=1; i<=12; i++){
    m=m+'<option>'+i+'</option>';
}
month.innerHTML=m;

let d="";
for(let i=1; i<=31; i++){
    d=d+'<option>'+i+'</option>';
}
date.innerHTML=d;

//----------------------------------------------------------
let r=prompt("ROW의 갯수 입력");   //3
let c=prompt("COLUMN의 갯수 입력");//2
let table="";
for(let i=0; i<r; i++){
    table=table+'<tr>';
    for(let j=0; j<c; j++){
        table=table+'<td>'+i+j+'</td>';
    }
    table=tabel+'</tr>';
}
d4.innerHTML=table;