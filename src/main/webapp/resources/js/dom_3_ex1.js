// ID 선택자로 값 불러오기
const btn = document.getElementById("btn");
const btn2 = document.getElementById("btn2");
const btn3 = document.getElementById("btn3");
const btn4 = document.getElementById("btn4");
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const select = document.getElementById("select");
const c1 = document.getElementsByClassName("c1");

// Event 등록 3
btn.addEventListener("click", function(){
    console.log("work");
    console.log(select.value);
    let or = select.value;


    if(or=="+"){
        d3.value=d1.value*1+d2.value*1;
    }else if(or=="-"){
        d3.value=d1.value*1-d2.value*1;
    }else if(or=="*"){
        d3.value=d1.value*d2.value;
    }else if(or=="/"){
        d3.value=d1.value/d2.value;
    }else {
        d3.value=d1.value%d2.value;
    }

    // console.log(d1.value);
    // console.log(d2.value);
    
    // 입력은 숫자지만 받을땐 문자열로 받음
    // 하지만 곱하기&나누기는 숫자로 바꿔서 받음
    // d3.value=d1.value/1+d2.value/1;
});

// 선택자.addEventListener("이벤트명", 익명함수선언 또는 함수 호출)
btn2.addEventListener("click", function(){
    alert("BTN2");
});

btn3.addEventListener("click", function(){
    btn2.click();
});

btn4.addEventListener("click", function(){
    alert(c1);
    console.log(c1);
    // console.log(c1.value);

    for(let i=0; i<c1.length; i++){
        console.log(c1[i].selected);
    }

    c1[1].selected=true;

});