function post() {
    var questionId=$("#question_id").val();
    console.log(questionId);
    var content=$("#comment_content").val();
    console.log(content);
    comment2target(questionId,1,content);
}
function comment2target(targetId,type,content) {
    if (!content){
        alert("回复内容不能为空");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType : 'application/json',
        data : JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type,
        }),
        success : function(response){
            if (response.code ==200){
                window.location.reload();
            }else{
                if (response.code ==2003){
                    var b = confirm(response.message);
                    if(b){
                        window.open("https://github.com/login/oauth/authorize?client_id=8cda2f31eee3898728a0&redirect_uri=http://localhost:8081/callback&scpoe=user&state=1");
                    }
                }
                // alert(response.message());
            }
        },
        dataType :"json"
    });
}
function comment(e){
    var commemtId=e.getAttribute("data-id");
    var content=$("#input-"+commemtId).val();
    comment2target(commemtId,2,content);
};
// 二级评论
collapseComments=function(e) {
    var id = e.getAttribute("data-id");
    var comments=$("#comment-"+id);
    //获取一下二级评论的展开状态
    var collapse=e.getAttribute("data-collapse");
    if (collapse =="in"){
        //折叠评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    }else{
        comments.addClass("in");
        e.setAttribute("data-collapse","in");
        e.classList.add("active");
     }
}