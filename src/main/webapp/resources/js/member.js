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

    all.addEventListener("click", function(){
        console.log(all.checked);
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
}