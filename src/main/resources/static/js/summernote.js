$( document ).ready(function() {
    summernoteInit("content");
});

function summernoteInit(selector){

    //summernote
    $("#"+selector).summernote({
        height: 600,
        width: '100%',

    });


    //내용 추가
    // $("#"+selector).summernote('code', code);
}