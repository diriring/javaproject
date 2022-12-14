let uniqueEmail = false;

$("#emailCheckBtn").on("click", function() {
    $.ajax({
        type: "POST",
        url: "./checkMember",
        data: {
            id: $("#id").val(),
            email: $("#email").val()
        },
        success: function(result) {
            if(1 == result.data) {
                alert("이미 사용중인 이메일입니다.");
            }else {
                alert("사용하실 수 있는 이메일입니다.");
                uniqueEmail = true;
            }
        },
        error: function(result) {
            json = result.responseJSON;
            alert("이메일 체크 에러 " + json.status + " : " + json.desc);
        }
    });
});

$("#email").on("change", function() {
    uniqueEmail = false;
});

$("#updateBtn").on("click", function() {
    if(!uniqueEmail) {
        alert("이메일 중복 확인을 해주세요.")
        return false;
    }
    $.ajax({
        type: "POST",
        url: "./memberUpdate",
        data: {
            name: $("#name").val(),
            email: $("#email").val(),
            phone: $("#phone").val(),
        },
        success: function(result) {
            if(1 == result.data) {
                alert("수정 성공");
                location.href="./myPage";

            }else {
                alert("수정 실패");
                location.href="./myPage";
            }
        },
        error: function(result) {
            json = result.responseJSON;
            alert("회원 정보 수정 에러 " + json.status + " : " + json.desc);
        }
    });
});