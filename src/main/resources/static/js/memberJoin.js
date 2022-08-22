
$("#joinBtn").on("click", function() {


    console.log("회원가입 가능");
    $.ajax({
        type: "POST",
        url: "/member/memberJoin",
        data: {
            id: $("#id").val(),
            password: $("#password").val(),
            name: $("#name").val(),
            email: $("#email").val(),
            phone: $("#phone").val()
        },
        success: function(result) {
            console.log(result);
            if(result == 1) {
                alert("회원가입 성공");
                location.href="../";

            }else {
                alert("회원가입 실패");
                location.href="./";
            }
        },
        error: function() {
            alert("회원가입 에러");
        }
    });
});


// $("#id").on("change", function() {
//     uniqueId = false;
// });
//
// $("#email").on("change", function() {
//     uniqueEmail = false;
// });

//아이디 중복체크
// $("#idCheckBtn").on("click", function() {
//     console.log($("#id").val());
//     $.ajax({
//         type: "POST",
//         url: "/member/MemberMapper.php",
//         data: {
//             id: $("#id").val(),
//             call_name: "getIdCheck"
//         },
//         success: function(result) {
//             console.log(result);
//             if(result == 1) {
//                 alert("이미 사용중인 아이디입니다.");
//
//             }else {
//                 alert("사용하실 수 있는 아이디입니다.");
//                 uniqueId = true;
//             }
//         },
//         error: function() {
//             alert("아이디 체크 에러");
//         }
//     });
// });

//이메일 중복체크
// $("#emailCheckBtn").on("click", function() {
//     console.log($("#email").val());
//     $.ajax({
//         type: "POST",
//         url: "/member/MemberMapper.php",
//         data: {
//             email: $("#email").val(),
//             call_name: "getEmailCheck"
//         },
//         success: function(result) {
//             console.log(result);
//             if(result == 1) {
//                 alert("이미 사용중인 이메일입니다.");
//
//             }else {
//                 alert("사용하실 수 있는 이메일입니다.");
//                 uniqueEmail = true;
//             }
//         },
//         error: function() {
//             alert("아이디 체크 에러");
//         }
//     });
// });

//비밀번호 확인 체크
function chkRePW() {
    let pw = $("#password").val();
    let rePw = $("#rePassword").val();

    $("#rePwCheckResult").html("비밀번호가 일치하지 않습니다.");

    if(pw == rePw) {
        $("#rePwCheckResult").html("비밀번호가 일치");
        return true;
    }

    return false;
}
