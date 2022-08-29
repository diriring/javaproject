$("#loginBtn").on("click", function () {
   $.ajax({
       type: "POST",
       url: "/member/login",
       data: {
           id: $("#id").val(),
           password: $("#password").val(),
       },
       success: function(result) {
           if(1 == result.data) {
               alert("로그인 성공");
               location.href="../";
           }else {
               alert("로그인 실패");
               location.href="./login";
           }
       },
       error: function(result) {
           json = result.responseJSON;
           alert("로그인 에러 " + json.status + " : " + json.desc);
       }
   });
});