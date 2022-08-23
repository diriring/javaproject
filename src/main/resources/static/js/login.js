$("#loginBtn").on("click", function () {
   $.ajax({
       type: "POST",
       url: "/member/login",
       data: {
           id: $("#id").val(),
           password: $("#password").val(),
       },
       success: function(result) {
           // console.log(result);

           if(result == 1) {
               alert("로그인 성공");
               location.href="../";

           }else {
               alert("로그인 실패");
               location.href="./login";
           }
       },
       error: function() {
           alert("로그인 에러");
       }
   });
});