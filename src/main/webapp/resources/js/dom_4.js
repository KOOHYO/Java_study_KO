//dom_4.js
const ch = document.getElementsByClassName("ch");
const cd = document.getElementsByClassName("cd");

// for(let i=0; i<ch.length; i++){
//     ch[i].addEventListener("click", function(){
//         alert(ch[i].value);
//     });
// }

ch[0].addEventListener("click", function(){
    for(let i=0; i<cd.length; i++){
        ch[i+1].checked='true';
    }
});