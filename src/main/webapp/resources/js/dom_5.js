//dom_5.js

const d2 = document.getElementById("d2");
const d1 = document.getElementById("d1");
const d3 = document.getElementById("d3");
const d5 = document.getElementById("d5");
const d4 = document.getElementById("d4");
const d6 = document.getElementById("d6");

d2.addEventListener("focus", function(){
    console.log("입력 준비");
});

d2.addEventListener("blur", function(){
    console.log("blur 실행");
});

// d1 입력하고 나왔을 때 글자의 길이가 3글자 이하라면 d1 강제로 다시 입력 대기 상태
d1.addEventListener("blur", function(){
    // 처음찍을때 빈 문자열
    // 글자 입력 후 다음 입력창 가면 벨류가 있음
    console.log(d1.value);
    let v = d1.value;
    if(v.length<4){
        d1.focus();
    }
});

d3.addEventListener("change", function(){
    console.log("체인지 이벤트 발생");
});

d5.addEventListener("change", function(){
    console.log("체인지 이벤트 발생");
});

d4.addEventListener("keyup", function(){
    console.log("키업 이벤트 발생");
    let v2 = d4.value;
    for(let i=0; i<v2.length;i++){
        console.log(v2.length);
        let t = "";
        if(v2.length>0){
            t=1000*(i+1);
            d6.innerText=t;
        }else {
            d6.innerText=t;
        }
    }
});