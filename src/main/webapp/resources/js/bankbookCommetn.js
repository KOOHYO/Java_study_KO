// bankbookComment.js

// const commentAdd = document.getElementById("commentAdd");
const commentAdd = document.querySelector("#commentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");
const more = document.querySelector("#more");

//page 번호 담는 변수
let page=1;
//bookNum을 담을 변수
const bookNum = commentAdd.getAttribute("data-book-num");
getCommentList(page, bookNum);

commentAdd.addEventListener("click", function(){

    let wv = writer.value;
    let cv = contents.value;

    //------------------ Ajax ---------------------------
    // 1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    // 2. Method, URL 준비
    xhttp.open("POST","./commentAdd");

    // 3. Enctype 
    // 요청 header 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // 4. 요청 발생 (POST일 경우prammeter 추가)
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    //5. 응답 처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result = xhttp.responseText.trim();
            console.log(result);
            result = JSON.parse(result);
            console.log(result.result);
            writer.value="";
            contents.value="";
            if(result.result==1){
                alert("댓글 등록 성공!");

                for(let i=0; i<commentList.children.length;){
                    commentList.children[0].remove();
                }

                // if(commentList.children.length !=0){
                //     commentList.children[0].remove();
                // }

                page=1;

                getCommentList(page, bookNum);
            }else{

            }
        }
    }

});//click Event 끝

function getCommentList(p, bn){
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL
    xhttp.open("GET","./commentList?page="+p+"&bookNum="+bn);

    //3. 요청 전송
    xhttp.send();

    //4. 응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(xhttp.readyState==4 && xhttp.status==200){
            //1. jsp 사용한 결과물
            //commentList.innerHTML = xhttp.responseText.trim();

            //2. JSON 결과물
            let result = JSON.parse(xhttp.responseText.trim());
            // let result = document.createElement("table");
            // let resultAttr = document.createAttribute("class");
            // resultAttr.value="row";
            // result.setAttributeNode(resultAttr);

            let pager = result.pager; //commentPager
            let ar = result.list;     //댓글리스트

            for(let i=0; i<ar.length; i++){
                let tr = document.createElement("tr");

                let td = document.createElement("td");
                let tdText = document.createTextNode(ar[i].contents);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].writer);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].regDate);
                td.appendChild(tdText);
                tr.appendChild(td);
                
                td = document.createElement("td");
                tdText = document.createTextNode("수정");
                let tdAttr = document.createAttribute("class");
                tdAttr.value="update";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value=ar[i].num;
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode("삭제");
                tdAttr = document.createAttribute("class");
                tdAttr.value="delete";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value=ar[i].num;
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                tr.appendChild(td);

                commentList.append(tr);

                if(page >= pager.totalPage){
                    more.classList.add("disabled");
                }else {
                    more.classList.remove("disabled");
                }
            }

            // console.log(result);
            // console.log(commentList.children);

            // let t = commentList.children;

            // if(t.leangth != 0){
            //     commentList.children[0].remove();
            // }

            // try{
            //     console.log(commentList.children());
            //     throw new Error("에러 메세지");
            // }catch(exeception){

            // }finally{

            // }
            // commentList.append(result);
        }
    });

}

//--------------- 더보기 ----------------
more.addEventListener("click", function(){
    page++; //page=page+1;
    console.log(page);
    console.log(bookNum);

    getCommentList(page, bookNum);

});

//--------------- delete ----------------------------
commentList.addEventListener("click", function(event){

    //------------------- Update -------------------------------
    if (event.target.className=="update"){
        // let contents = event.target.previousSibling.previousSibling.previousSibling
        // console.log(contents);
        // let v = contents.innerHTML;
        // contents.innerHTML="<textarea>"+v+"</textarea>";

        let contents = event.target.previousSibling.previousSibling.previousSibling.innerHTML
        let writer = event.target.previousSibling.previousSibling.innerHTML
        let num = event.target.getAttribute("data-comment-num");
        console.log(event.target.getAttribute("data-comment-num"));
        console.log(contents);
        document.querySelector("#updateContents").innerHTML=contents;
        document.querySelector("#updateWriter").value=writer;
        document.querySelector("#up").click();
        document.querySelector("#num").value=num;

    }

    //------------------- Delete -------------------------------
    if(event.target.className=="delete"){
        let check = window.confirm("삭제 하시겠습니까??");
        if(check==true){
            let num = event.target.getAttribute("data-comment-num");
            console.log(num);
            //1. XMLHttpRequest 객체 생성
            const xhttp = new XMLHttpRequest();

            //2. 요청정보(URL, Method)
            xhttp.open("POST", "commentDelete");

            //3. Header(enctype)
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            //4. 요청 발생
            xhttp.send("num="+num);

            //5. 응답 결과 처리
            xhttp.onreadystatechange=function(){
                if(xhttp.readyState==4&&xhttp.status==200){
                    let result = xhttp.responseText.trim();
                    if(result==1){
                        alert("삭제 성공");

                        page=1;
                        for(let i=0; i<commentList.children.length;){
                            commentList.children[0].remove();
                        }

                        getCommentList(page, bookNum);
                    }else {
                        alert("삭제 실패")
                    }
                }
            }

        }
    }
});

//-------------------------- Modal Update button Click ----------------------------
const update = document.querySelector("#update");

update.addEventListener("click", function(){
    // modal에서 num, contents
    let num = document.getElementById("num").value;
    let contents = document.querySelector("#updateContents").value;

    //-------------------- Ajax --------------------------
    //1. XHTTPRequest 객체 생성
    const xhttp = new XMLHttpRequest();

    //2. 메서드, URL정보
    xhttp.open("POST", "commentUpdate");

    //3. 헤더 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 요청 발생
    xhttp.send("num="+num+"&contents="+contents);

    //5. 응답 처리
    xhttp.onreadystatechange=function(){
        if(xhttp.readyState==4&&xhttp.status==200){
            let result = xhttp.responseText.trim();
            console.log(result);
            if(result>0){
                alert("댓글 수정 성공!!");
                page=1;
                for(let i=0; i<commentList.children.length;){
                    commentList.children[0].remove();
                }

                getCommentList(page, bookNum);
            }else{
                alert("댓글 수정 실패..")
            }
        }
    }

});