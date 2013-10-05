$(document).ready(function () {

    $("#guestSubmit").click(function () {

        var id = $("#blogId").val();
        id=id ?id:'0';
        var content = $("#guestTXT").val();

        if (!content) {
            alert("评论内容不能为空!");
            return;
        }
        $.ajax({
            type:'POST',
            url:'blogguest!message.action',
            data:{
                id:id,
                content:content
            },
            success:function (data) {
                if (data == 3) {
                    alert("留言成功!");
                    location.reload();
                    return;
                }
                if (data == 1){
                    alert("您还没有登录，请登录后再留言!");
                    return ;
                }
                if (data == 2){
                    alert("您还没有开通博客，请开通博客后再留言!");
                    return ;
                }
            }
        });

    });

    $("#recordSubmit").click(function () {

        var id = $("#blogId").val();
        var content = $("#recordTXT").val();

        if (!content) {
            alert("记录内容不能为空!");
            return;
        }
        $.ajax({
            type:'POST',
            url:'blogrecord!message.action',
            data:{
                id:id,
                content:content
            },
            success:function (data) {
                if (data == 3) {
                    alert("发布成功!");
                    location.reload();
                    return;
                }
                if (data == 1){
                    alert("您还没有登录，请登录后再发布!");
                    return ;
                }
                if (data == 2){

                    return ;
                }
                if (data == 0){
                    return ;
                }
            }
        });

    });


});
