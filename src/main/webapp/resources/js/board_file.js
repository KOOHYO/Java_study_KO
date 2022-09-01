const addFiles = document.getElementById("addFiles");
// const mb-3 = document.getElementById("mb-3");

//마우스 클릭 횟수 
let count=0;

addFiles.addEventListener("click", function(){
    
    count++;

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
    //선택자 외부 위에 추가
    
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
    
    addFiles.before(div);
});