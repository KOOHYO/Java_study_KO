//1. 선택자
let d1 = document.getElementById("d1");
let d2 = document.getElementById("d2");
let d3 = document.getElementById("d3");
let year = document.getElementById("year");
let month = document.getElementById("month");
let date = document.getElementById("date");
let table = document.getElementById("table");
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

let year1 = window.prompt("년도를 입력하세요");
let y="";
for(let i=1899; i<year1; i++){
    y=y+'<option>'+(i+1)+'</option>';
}
year.innerHTML=y;

let month1 = window.prompt("월을 입력하세요");
let m="";
for(let i=0; i<month1; i++){
    m=m+'<option>'+(i+1)+'</option>';
}
month.innerHTML=m;

let date1 = window.prompt("일을 입력하세요");
let d="";
for(let i=0; i<date1; i++){
    d=d+'<option>'+(i+1)+'</option>';
}
date.innerHTML=d;

let r=prompt("ROW의 갯수 입력");   //3
let c=prompt("COLUMN의 갯수 입력");//2
let row="";
for(let i=0; i<r; i++){
    row=row+'<tr>'+(i+1)+'</tr>'
}