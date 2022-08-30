// ID 선택자로 값 불러오기
const btn = document.getElementById("btn");
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");


// Event 등록 3
btn.addEventListener("click", function(){
    console.log("work");
    console.log(d1.value);
    console.log(d2.value);
    
    // 입력은 숫자지만 받을땐 문자열로 받음
    // 하지만 곱하기&나누기는 숫자로 바꿔서 받음
    d3.value=d1.value/1+d2.value/1;
});

//
btn2.addEventListener("click", function(){
    alert("BTN2");
});

btn3.addEventListener("click", function(){
    btn2.click();
});