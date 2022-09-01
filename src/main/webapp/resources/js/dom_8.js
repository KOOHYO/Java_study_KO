
const count = document.getElementById("count");
const btn = document.getElementById("btn");
const result = document.getElementById("result");
const c1 = document.getElementsByClassName("c1");
const d1 = document.getElementById("d1");
const d1_1 = document.getElementById("d1_1");
const d1_1_1 = document.getElementById("d1_1_1");
const google = document.getElementById("google");

google.addEventListener("click", function(event){
    alert("Hello google");
    event.preventDefault();
});

d1.addEventListener("click", function(event){
    console.log("d1 click");
    console.log(event);
    //부모영역
    console.log(event.currentTarget);
    //실제 클릭 영역
    console.log(event.target);

    if(event.target.className=='buttons'){
        alert("button");
        console.log("this : ",this);
        alert(event.target.innerHTML);
    }
}, false);


btn.addEventListener("click", function(){
    // console.log(count.value);

    for(let i=0; i<count.value; i++){
        let btn2 = document.createElement("button");
        let t = document.createTextNode("CLICK"+i);
        btn2.appendChild(t);
        let attr = document.createAttribute("class");
        attr.value="c1";
        btn2.setAttributeNode(attr);

        result.append(btn2);
    }

});


//-----------------------------
result.addEventListener("click", function(event){
    if(event.target.className=='c1'){
        alert(event.target.innerHTML);
    }
});