const addFiles = document.getElementById("addFiles");
const fileAdd = document.getElementById("fileAdd");
// const mb-3 = document.getElementById("mb-3");

//마우스 클릭 횟수 
let count=0;
let idx=0;

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
    //div id file1
    //button title="1"
    if(event.target.classList[0]=='del'){
        alert("삭제 하시겠습니까?");
        // console.log(event.target.title)
        for(let i=0; i<idx; i++){
            if(event.target.title==i){
                fileAdd.div.remove();
            }

        }
    }
});