$("#deleteBtn").on("click", function() {

    let src = new Array();

    $("#content img").each(function(index, item) {
        let split = item.src.split('/');
        src[index] = split[5];
    });

    $.ajax({
        type: "POST",
        url: "/board/boardDelete",
        data: {
            boardNum: $("#boardNum").val()
        },
        success: function(result) {
            if (1 == result.data) {
                src.forEach((path)=>deleteFile(path));
                alert("삭제 성공");
                location.href="/board/boardList";
            } else {
                alert("삭제 실패");
                location.href="/board/boardList";
            }
        },
        error: function(result) {
            json = result.responseJSON;
            alert("글 삭제 에러 " + json.status + " : " + json.desc);
        }
    });
});

$("#replyAddBtn").on("click", function() {
    $.ajax({
        type: "POST",
        url: "/reply/setAdd",
        data: {
            boardNum: $("#boardNum").val(),
            id: $("#sessionId").val(),
            content: $("#replyContent").val()
        },
        success: function(result) {
            if (1 == result.data) {
                alert("댓글 등록 성공");
                //댓글 목록 갱신
                location.reload();
            } else {
                alert("댓글 등록 실패");
            }
        },
        error: function(result) {
            json = result.responseJSON;
            alert("댓글 등록 에러 " + json.status + " : " + json.desc);
        }
    });
});

$("#replyResult").on("click", ".replyUpdateBtn", function(event) {
    $("#updateModal").modal("show");
    let replyNum = $(event.target).attr("data-num");
    $("#replyNum").val(replyNum);
    $("#modalText").html($("#" + replyNum).text());
});

$("#modalUpdateBtn").on("click", function() {
    $.ajax({
        type: "POST",
        url: "/reply/setUpdate",
        data: {
            replyNum: $("#replyNum").val(),
            content: $("#modalText").val()
        },
        success: function(result) {
            if(1 == result.data) {
                alert("댓글 수정 성공");
                location.reload();
            }else {
                alert("댓글 수정 실패");
                location.reload();
            }
        },
        error: function(result) {
            json = result.responseJSON;
            alert("댓글 수정 에러 " + json.status + " : " + json.desc);
        }
    });

});

$("#replyResult").on("click", ".replyDelBtn", function(event) {
    $.ajax({
        type: "POST",
        url: "/reply/setDelete",
        data: {
            replyNum: $(event.target).attr("data-num")
        },
        success: function(result) {
            if(1 == result.data) {
                alert("댓글 삭제 성공");
                location.reload();
            }else {
                alert("댓글 삭제 실패");
                location.reload();
            }
        },
        error: function(result) {
            json = result.responseJSON;
            alert("댓글 삭제 에러 " + json.status + " : " + json.desc);
        }

    });

});

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