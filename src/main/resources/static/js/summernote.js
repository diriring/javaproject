$( document ).ready(function() {
    summernoteInit("content");
});

function summernoteInit(selector){

    //summernote
    $("#"+selector).summernote({
        height: 600,
        width: '100%',

        callbacks: {
            onChange: function(contents) {
                localStorage.setItem("content", contents);
            },
            onImageUpload: function(files) {
                //files : 업로드한 이미지 파일 객체
                let formData = new FormData();
                formData.append("mf", files[0]);

                // /board/summerFileUpload
                $.ajax({
                    type: "POST",
                    url: "./uploadFile",
                    enctype: 'multipart/form-data',
                    processData: false,
                    contentType: false,
                    data: formData,
                    success: function(result) {
                        $(".note-image-input").val('');
                        $("#"+selector).summernote('editor.insertImage', result.data.trim());
                    }
                });
            },
            onMediaDelete: function(files) {
                let fileName = $(files[0]).attr("src");
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
        }

    });
}