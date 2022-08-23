$("#deleteBtn").on("click", function() {

    $.ajax({
        type: "POST",
        url: "./memberDelete",
        data: {
            password: $("#password").val()
        },
        success: function(result) {
            console.log(result);
            if(result == 1) {
                alert("탈퇴되었습니다.");
                location.href="../";

            }else if(result == 0) {
                alert("탈퇴 실패");
                location.href="./myPage";
            }else {
                alert("비밀번호가 일치하지 않습니다.");
            }
        },
        error: function() {
            alert("에러");
        }

    });
});