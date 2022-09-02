//dom_9.js

const d1 = document.querySelector("#d1");
const d1_2_1_2 = document.querySelector("#d1_2_1_2");
const btn = document.getElementById("btn");

console.log(d1_2_1_2.previousSibling.previousSibling);
console.log(d1_2_1_2.nextSibling.nextSibling);

console.log("----------------------------------------------");

// ParentNode
console.log(d1_2_1_2.parentNode.parentNode.parentNode);

btn.addEventListener("click", function(){
    d1_2_1_2.parentNode.parentNode.remove();
});

console.log("----------------------------------------------");

// Child

// 여기에서 text는 엔터(스페이스 한번)=1px
console.log(d1.childNodes);
console.log(d1.children);
// console.log(d1.childNodes[3].innerHTML);
console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML)
console.log(d1.children[1].children[0].children[0].innerHTML);

d1.addEventListener("click", function(){
    // li 모두 삭제
    console.log("click");
    // 1. remove
    let li = d1.children[1].children[0].children;
    // console.log(li);
    // i가 증가하면 안됌! 고로 증가는 지워야함
    for(let i=0; i!=li.length;){
        // 배열의 length가 줄어도 0번 인덱스는 계속 남아있기 때문
        li[0].remove();
    };

    // 2. removeChild()

});
