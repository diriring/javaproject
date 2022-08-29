$(document).ready(
    //새로고침해도 기존 값 유지
    function () {
        let content = "";
        if(localStorage.getItem("content") != null) {
            content = localStorage.getItem("content");
        }
        $("#title").val(localStorage.getItem("title"));
        $("#content").summernote('code', content);
    }
)

//뒤로가기 막기
history.pushState(null, null, location.href);
window.onpopstate = function(event) { history.go(1); };

//글 등록
$("#addBtn").on("click", function() {
    $.ajax({
        type: "POST",
        url: "/board/boardWrite",
        data: {
            id: $("#id").val(),
            title: $("#title").val(),
            content: $("#content").val(),
            categoryNum: $("#categoryNum").val()
        },
        success: function(result) {
            if (1 == result.data) {
                alert("등록 성공");
                localStorage.clear();
                location.href="/board/boardList";

            } else {
                alert("등록 실패");
                location.href="/board/boardList";
            }
        },
        error: function(result) {
            json = result.responseJSON;
            alert("글 등록 에러 " + json.status + " : " + json.desc);
        }
    });

});

//페이지 이동할 때 localStorage 및 서버 파일 삭제
$("a").on("click", function(event) {
    event.preventDefault();
    deleteTemp($(event.target).attr("href"))
});

//파일 삭제
function deleteFile(fileName) {
    $.ajax({
        type: "POST",
        url: "./deleteFile",
        data: {
            fileName: fileName
        },
        success: function(result) {
            console.log(result.data);
        },
        error: function (result) {
            json = result.responseJSON;
            alert("파일 삭제 에러 " + json.status + " : " + json.desc);
        }

    });
}

//localStorage에 값 저장
function saveValue(event){
    let id = event.id;
    let val = event.value;
    localStorage.setItem(id, val);
}

//localStorage 삭제 및 서버 파일 삭제
function deleteTemp(path) {
    let check = confirm("글 내용이 저장되지 않습니다. 이동 하시겠습니까?");

    if(!check) {
        return false;
    }

    let src = new Array();

    $("img").each(function(index, item) {
        let split = item.src.split('/');
        src[index] = split[5];
    });

    src.forEach((path)=>deleteFile(path));

    localStorage.clear();
    location.href=path;
}