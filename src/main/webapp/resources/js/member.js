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