$("#deleteBtn").on("click", function() {
    console.log($("#password").val());
    $.ajax({
        type: "POST",
        url: "./memberDelete",
        data: {
            password: $("#password").val()
        },
        success: function(result) {
            console.log(result);
            if(1 == result.data) {
                alert("탈퇴되었습니다.");
                location.href="../";

            }else if(0 == result.data) {
                alert("탈퇴 실패");
                location.href="./myPage";
            }else {
                alert("비밀번호가 일치하지 않습니다.");
            }
        },
        error: function(result) {
            json = result.responseJSON;
            alert("회원탈퇴 에러 " + json.status + " : " + json.desc);
        }

    });
});