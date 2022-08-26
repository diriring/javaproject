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
    //console.log("클릭");
    // console.log($("#categoryNum").val());

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

            console.log(result);

            if (result.data == 1) {
                alert("등록 성공");
                location.href="/board/boardList";

            } else {
                alert("등록 실패");
                location.href="/board/boardList";
            }
        },
        error: function() {
            alert("에러");
        }
    });

});

//페이지 이동할 때 localStorage 및 서버 파일 삭제
$("a").on("click", function(event) {
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
        }

    });
}

//localStorage에 값 저장
function saveValue(event){
    let id = event.id;
    let val = event.value;
    localStorage.setItem(id, val);
    console.log(localStorage)
}

//localStorage 삭제 및 서버 파일 삭제
function deleteTemp(path) {
    let check = confirm("글 내용이 저장되지 않습니다. 이동 하시겠습니까?");

    if(!check) {
        return false;
    }

    // console.log($("img").attr("src"));

    let src = new Array();

    $("img").each(function(index, item) {
        let split = item.src.split('/');
        console.log(split);
        let path = "../" + split[3] + "/" + split[4] + "/" + split[5];
        src[index] = split[5];
    });

    console.log(src);

    src.forEach((path)=>deleteFile(path));

    localStorage.clear();
    location.href="./boardList";
}