//dom_10.js

//const d2 = document.getElementById("d2");
//선택자를 꼭 맨 위에만 써야하는 것은 아님!
const d2 = document.querySelector("#d2");
const d1 = document.querySelector("#d1");
const d3 = document.querySelector("#d3");
const d4 = document.querySelector("#d4");

d2.addEventListener("mouseenter", function(){
    console.log("Enter");
    console.log(d1.class);
    console.log(d1.getAttribute("class"));
    //d1.className="c2";
    d1.classList.replace("c3", "c2");
});

d2.addEventListener("mouseleave",function(){
    console.log("Leave");
    // "c1 c2"
    console.log(d1.className);
    // DOMTokenList(2) ['c1', 'c2', value: 'c1 c2']
    console.log(d1.classList);
    d1.classList.add("c4");
});

d3.addEventListener("click", function(){
    console.log("toggle");
    d2.classList.toggle("c2");
    console.log(d2.classList.contains("c2"));
})

d4.addEventListener("click", function(){
    console.log("request");
    console.log("origin : "+location.origin);
    console.log("hostname : "+location.hostname);
    console.log("pathname : "+location.pathname);
    console.log("search : "+location.search);
    //location.href="./dom_9.html?a=10";
});
