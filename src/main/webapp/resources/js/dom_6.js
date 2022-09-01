//dom_6.js

//Button에 click event 등록
const btn = document.getElementById("btn"); //button
const d1 = document.getElementById("d1"); //div
const add = document.getElementById("add"); //add button
const list = document.getElementById("list"); //ul
const add2 = document.getElementById("add2"); //add2 button
const list2 = document.getElementById("list2"); //ol
const add3 = document.getElementById("add3"); //add3 button
const d2 = document.getElementById("d2"); //div
const add4 = document.getElementById("add4"); //add3 button
const add5 = document.getElementById("add5"); //add3 button
const d3 = document.getElementById("d3"); //div

btn.addEventListener("click", function(){
    d1.innerHTML='<img src="/resources/images/title_3.jpg">'
});

add.addEventListener("click", function(){
    let li = document.createElement("li"); //<li></li>
    let t = document.createTextNode("test"); //test
    li.appendChild(t);
    list.append(li);
});

add2.addEventListener("click", function(){
    let li = document.createElement("li"); //<li></li>
    let h = document.createElement("h3"); //<h3></h3>
    let t = document.createTextNode("Hello"); //Hello
    h.appendChild(t);                       //<h3>Hello</h3>
    li.appendChild(h);                      //<li>li</li>
    list2.prepend(li);
});

//add3을 클릭하면 div#d2(#은 아이디가 d2) 내에 input Element를 Append
add3.addEventListener("click", function(){
    let input = document.createElement('input'); //<input>
    let ch = document.createAttribute("type"); //type=
    ch.value="checkbox";                       //type="checkbox"
    input.setAttributeNode(ch);                //<input type="checkbox">
    d2.appendChild(input);
});

//add4를 클릭하면 div#d3에 before
add4.addEventListener("click", function(){
    let h = document.createElement("h3");
    let t = document.createTextNode("before");
    h.appendChild(t);
    d3.before(h);
});

//add5를 클릭하면 div#d3에 after : <h3>after</h3>
add5.addEventListener("click", function(){
    let h = document.createElement("h3");
    let t = document.createTextNode("After");
    h.appendChild(t);
    d3.after(h);
});