const addFiles = document.getElementById("addFiles");
const fileAdd = document.getElementById("fileAdd");
// const mb-3 = document.getElementById("mb-3");
const fileDelete = document.querySelectorAll(".fileDelete");
//const fileDelete = document.getElementsByClassName("fileDelete"); 안됌!!

//--------------------------- Update시 file Delete ------------------------------

try{
fileDelete.forEach(function(f){
    f.addEventListener("click", function(){

        console.log("p : ", f.parentNode);

        //확인버튼==true 취소버튼==false를 받는다
        let check = window.confirm("삭제를 하면 되돌릴 수 없다");

        if(!check){
            return;
        }

        let fileNum = f.getAttribute("data-file-num");

        //Ajax
        const xhttp = new XMLHttpRequest();

        xhttp.open("POST", "./fileDelete");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("fileNum="+fileNum);

        xhttp.onreadystatechange=function(){
            if(xhttp.readyState==4&&xhttp.status==200){
                let result = xhttp.responseText.trim();
                if(result==1){
                    console.log(result);
                    f.parentNode.remove();
                    count--;
                }else {
                    console.log(result);
                }
            }
        }

        });
    });
}catch(e){
    console.log(e);
}

// for(fi of fileDelete){
//     console.log(fi);
// }

//------------------------ Add시 file add -----------------------

//마우스 클릭 횟수 
let count=0;
let idx=0;

function setCount(c){
    if(c>=0){
        count=c;
    }
}

try{

fileAdd.addEventListener("click", function(){
    
    //클릭횟수 증가시키는 순서도 중요함!
    count++;
    idx++;

    if(count>5){
        alert("파일은 최대 5개만 가능합니다")
        return;
    }

    //div Element 생성
    let div = document.createElement("div");
    //클래스 속성 추가
    let c = document.createAttribute("class");
    c.value="mb-3";
    div.setAttributeNode(c);
    c = document.createAttribute("id");
    c.value="file"+idx;
    div.setAttributeNode(c);
    
    //라벨 추가
    let lab = document.createElement("label");
    //라벨 안에 콘텐츠 추가
    let labText = document.createTextNode("File");
    lab.appendChild(labText);
    //라벨 속성 추가
    let f = document.createAttribute("for");
    f.value="contents";
    lab.setAttributeNode(f);

    let labc = document.createAttribute("class");
    labc.value="form-label";
    lab.setAttributeNode(labc);
    //div안에 라벨 추가
    div.appendChild(lab);
    
    //인풋 추가
    let input = document.createElement("input");
    //인풋 속성 추가
    let inputAtt = document.createAttribute("type");
    inputAtt.value="file";
    input.setAttributeNode(inputAtt);

    inputAtt = document.createAttribute("name");
    inputAtt.value="files";
    input.setAttributeNode(inputAtt);

    inputAtt = document.createAttribute("class");
    inputAtt.value="form-control";
    input.setAttributeNode(inputAtt);

    inputAtt = document.createAttribute("id");
    inputAtt.value="files";
    input.setAttributeNode(inputAtt);
    //div안에 input추가
    div.appendChild(input);

    let button = document.createElement("button");
    let buttonText = document.createTextNode("삭제");
    button.appendChild(buttonText);
    let buttonAtt = document.createAttribute("type");
    buttonAtt.value="button";
    button.setAttributeNode(buttonAtt);
    buttonAtt = document.createAttribute("class");
    buttonAtt.value="del btn btn-danger";
    button.setAttributeNode(buttonAtt);

    buttonAtt = document.createAttribute("title");
    buttonAtt.value=idx;
    button.setAttributeNode(buttonAtt);

    div.appendChild(button);
    
    addFiles.append(div);
});

addFiles.addEventListener("click", function(event){
    let button = event.target;
    if(button.classList[0]=='del'){
        document.getElementById("file"+button.title).remove();
        count--;
    }
});

}catch(e){

}