function loginCheck(){
    const login = document.getElementById("login");
    const btn = document.getElementById("btn");
    const userName = document.getElementById("userName");
    const password = document.getElementById("password");
    const al = document.getElementById("alert");
    
    btn.addEventListener("click", function(){
        console.log("서브밋 버튼 클릭");
        let u = userName.value;
        console.log(u.length);
        let p = password.value;
    
        if(u==""){
            al.innerHTML="아이디는 필수 입니다";
            return;
        }
    
        if(p==""){
            al.innerHTML="비밀번호는 필수 입니다";
            return;
        }
        // Event 강제 실행
        login.submit(); 
    
        // if(u.length>0 && p.length>0){
        //     // Event 강제 실행
        //     login.submit();
        // }else {
        //     alert("아이디와 비번은 필수입니다");
        // }
    
    });
}

function check(){
    const all = document.getElementById("all");
    const ch = document.getElementsByClassName("ch");
    const join = document.getElementById("join");
    const frm = document.getElementById("frm");
    const req = document.getElementsByClassName("req");
    
    join.addEventListener("click", function(){
        
        let result=true;
        for(let i=0; i<req.length; i++){
            if(!req[i].checked){
                result=false;
                break;
            }
        }
        if(result){
            frm.submit();
        }else {
            alert("필수 약관에 동의 해야 합니다");
        }
        
        // if(all.checked){
        //     frm.submit();
        // }else {
        //     alert("약관에 동의 해야 합니다");
        // }
    });
            
    all.addEventListener("click", function(){
        // console.log(all.checked);
        for(let i=0; i<ch.length; i++){
            ch[i].checked=all.checked;
        }
     });
            
    for(let i=0; i<ch.length; i++){
        ch[i].addEventListener("click", function(){
            let result = true;
             for(let j=0; j<ch.length; j++){
                if(!ch[j].checked){
                    result=false;
                    break;
                }
            }
             all.checked=result;
        });
    }
}

function joinCheck(){
    //선택자
    const joinform = document.getElementById("joinform");
    const joinbtn = document.getElementById("joinbtn");

    //Check 결과
    let idCheck=false;
    let pwCheck=false;
    let pw2Check=false;
    let nameCheck=false;
    let emailCheck=false;
    let phoneCheck=false;

    const id = document.getElementById("id");
    const pw = document.getElementById("pw");
    const pw2 = document.getElementById("pw2");
    const name = document.getElementById("name");
    const email = document.getElementById("email");
    const phone = document.getElementById("phone");

    const d1 = document.getElementById("d1");
    const d2 = document.getElementById("d2");
    const d3 = document.getElementById("d3");
    const d4 = document.getElementById("d4");
    const d5 = document.getElementById("d5");
    const d6 = document.getElementById("d6");

    const idbtn = document.getElementById("idbtn");
    const pwbtn = document.getElementById("pwbtn");

    id.addEventListener("blur", function(){
        idCheck=false;
        if(id.value.length>1){
            // id.focus();
            d1.innerHTML="";
            idCheck=true;
        }else {
            //idCheck=false;
            d1.innerHTML="아이디는 2글자 이상 입력하세요";
        }

    });

    // 1. pw 길이 체크
    pw.addEventListener("change", function(){
        if(v2.value.length>5){
            pwCheck=true;
            // id.focus();
            d2.innerHTML="";
            pw2.value="";
        }else {
            pwCheck=false;
            d2.innerHTML="비밀번호는 6글자 이상 입력하세요";
        }

    });

    // 2. pw가 같은지 체크
    pw2.addEventListener("blur", function(){
        
        if(pw.value==pw2.value){
            pw2Check=true;
            d3.innerHTML="";
        }else {
            pw2Check=false;
            d3.value="";
            d3.innerHTML="불일치합니다 다시입력해주세요";
        }

    });

    name.addEventListener("keyup", function(){
        let name2 = name.value;
        let t3 = "";
        for(let i=0; i<name2.length; i++){
            if(name.length==0){
                 console.log(name2.length);
                 t3="1글자 이상 이름을 입력하세요"
                 d3.innerHTML=t3;
                 break;
            }
        }
    });

    joinbtn.addEventListener("click", function(){

        if(idCheck&&pwCheck&&pw2Check&&nameCheck&&emailCheck&&phoneCheck){
            alert("서버 전송 합니다");
        }else {
            alert("필수 입력 사항을 입력해주세요");
        }

        
    });
    
    //    let name2 = name.value;
    //    let email2 = email.value;
    //    let phone2 = phone.value;

    //    let t3 = "";
    //    for(let i=0; i<name2.length; i++){
    //        console.log(name2.length);
    //        if(name.value==""){
    //             t3="1글자 이상 이름을 입력하세요"
    //             d3.innerHTML=t3;
    //             break;
    //        }
    //    }

    //    for(let i=0; i<email2.length; i++){
    //         if(email2.length=0){
    //             t3="1글자 이상 이메일을 입력하세요"
    //             d3.innerHTML=t3;
    //         }
    //     }

    //     for(let i=0; i<phone2.length; i++){
    //         if(phone2.length=0){
    //             t3="1글자 이상 전화번호를 입력하세요"
    //             d3.innerHTML=t3;
    //         }
    //     }
}