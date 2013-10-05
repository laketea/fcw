/**
 * Author: 章伟
 * Date: 13-2-19
 * Time: 下午5:19
 * 远方软件有限公司
 */
$(document).ready(function () {

    function zychannelselect() {
        var url = "http://" + window.location.host + window.location.pathname;
        if ($("#hdchannelId")[0]) {
            url += "?channelId=" + $("#hdchannelId").val();

            url += "&topChlId=" + $("#hdtopChlId").val();
            url += "&vipcmp="
        } else {
            url += "?vipcmp="
        }


        url += $("#vipcmp").is(':checked') ? "1" : "0";
        url += "&regcmp="
        url += $("#regcmp").is(':checked') ? "1" : "0";
        url += "&areacmp=";
        url += $("#areacmp").val();
        if ($("#keywords")[0]) {
            url += "&keywords=" + $("#keywords").val();
        }

        window.location = url;
    }

    //资源筛选界面
    function inforselect() {
        var url = "http://" + window.location.host + window.location.pathname;


        url += "?vip=";
        url += $("#info-vip").is(':checked') ? "1" : "0";

        url += "&cid=";
        url += $("#info-chl").val();
        if ($("#keywords")[0]) {
            url += "&keywords=" + $("#keywords").val();
        }

        window.location = url;
    } ;

    //资源频道筛选界面
    function inforchlselect() {
        var url = "http://" + window.location.host + window.location.pathname;


        url += "?vip=";
        url += $("#info-chl-vip").is(':checked') ? "1" : "0";
        url += "&channelId=";
        url += $("#channelId").val();

        window.location = url;
    } ;
    
    //编辑器
//    $('#txtContent').xheditor();

    $("#vipcmp").click(function () {
        zychannelselect();
    });

    $("#areacmp").change(function () {
        zychannelselect();
    });

    $("#info-chl").change(function () {
        inforselect();
    });
    $("#info-vip").change(function () {
        inforselect();
    });
    $("#info-chl-vip").change(function () {
        inforchlselect();
    });





    $("#search-tab ul li").click(function (event) {
        var target = event.currentTarget;
        var curType = $(target).attr("curType");
        if ($(target).hasClass("curTab")) {
            return;
        }
        $(target).addClass("curTab").siblings().removeClass("curTab");

        $("#search-ipt").addClass("search-ipt-default");
        $("#search-ipt").val($(target).attr("value"));
        $("#curType").val(curType);
    });

    $("#search-ipt").focus(function () {
        var status = $("#search-ipt").attr("status");
        if ($("#search-ipt").hasClass("search-ipt-default")) {
            $("#search-ipt").removeClass("search-ipt-default");
            $("#search-ipt").val("");

        }
    });

    $(".swap-city a").mouseover(function () {
//        $("#city-pnl").css("display","block");
    });
    $("#city-pnl").mouseleave(function () {
//        $("#city-pnl").css("display","none");
    })

    $(".has-menu").mouseover(function (event) {
        var target = $(event.currentTarget);
        target.addClass("hd-menu-hover");
        target.children(".hd-menu").css("display", "block");
    });
    $(".has-menu").mouseleave(function (event) {
        var target = $(event.currentTarget);
        target.removeClass("hd-menu-hover");
        target.children(".hd-menu").css("display", "none");
    })
    $("li.item").mouseover(function (event) {
        var target = $(event.currentTarget);
        var curindex = $(this).index();
        if (curindex == 3) {
            target.addClass("lastcon");
        }
        target.addClass("hover");
    });
    $("li.item").mouseleave(function (event) {
        var target = $(event.currentTarget);
        var curindex = $(this).index();
        if (curindex == 3) {
            target.removeClass("lastcon");
        }
        target.removeClass("hover");
    });
    $(".zy-nav-item h3").click(function (event) {
        var target = $(event.currentTarget);
        if (target.parent().hasClass("current")) {
            target.parent().removeClass("current");
        } else {
            target.parent().addClass("current");
        }
    });
    $("#_tj1").mouseover(function () {
        if ($("#_tj_list1").hasClass("Hidebox")) {
            $("#_tj_list1").removeClass("Hidebox").addClass("showbox");
            $("#_tj1").removeClass("sss02").addClass("sss01");
        }
        if ($("#_tj_list2").hasClass("showbox")) {
            $("#_tj_list2").removeClass("showbox").addClass("Hidebox");
            $("#_tj2").removeClass("sss01").addClass("sss02");
        }

    });

    $("#_tj2").mouseover(function () {
        if ($("#_tj_list2").hasClass("Hidebox")) {
            $("#_tj_list2").removeClass("Hidebox").addClass("showbox");
            $("#_tj2").removeClass("sss02").addClass("sss01");
        }
        if ($("#_tj_list1").hasClass("showbox")) {
            $("#_tj_list1").removeClass("showbox").addClass("Hidebox");
            $("#_tj1").removeClass("sss01").addClass("sss02");
        }
    });
    //top-exnav
    $("#top-cur-column").mouseover(function () {
        var target = $("#top-exnav");
        if (target.hasClass("isDefault")) {
            return;
        }
        target.css("display", "block");
    })

    $("#top-cur-column").mouseleave(function () {
        var target = $("#top-exnav");
        if (target.hasClass("isDefault")) {
            return;
        }
        target.css("display", "none");
    });
    $("#commentSubmit").click(function () {
        if (!($("#txtContent")[0])) {
            alert("请登录后再发表评论!");
        } else {
            var sourceId = $("#sourceId").val();
            var typeId = $("#typeId").val();
            var content = $("#txtContent").val();
            var url = $("#txtUrl").val();
            
            var score =$(".pl-core")?$(".pl-core").html():'';
            if(!content){
                alert("评论内容不能为空!");
                return;
            }
            var path = typeId==10?'reward!reply.action':"comment!comment.action";
//            content = encodeURI(encodeURI(content));
            $.ajax({
                type: 'POST',
                url:path,
                data:{
                    sourceId:sourceId,
                    typeId:typeId,
                    content:content,
                    score:score,
                    url:url
                },
                success:function (data) {
                    if (data == 0) {
                        alert("评论失败!");
                        return;
                    } else {
                        alert("评论成功!");
                        $("#txtContent").val("");
                        location.reload();
//                        window.location.href="usercenter.html";
                    }
                }
            });

        }
    });

    $(".down-link").click(function(eve){
        var target = $(eve.currentTarget);
        var id = target.attr("did");
        $.ajax({
            url:"download!checkup.action",
            async:false,
            data:{
                id:id
            },
            success:function (data) {
                if (data == 0) {
                    return true;
                }
                if (data == 1) {
                    alert("您还没有登录，请登录后再下载！");
                    eve.preventDefault();
                    return false;
                }
                if (data == 2) {
                    alert("该资料仅VIP可下载!");
                    eve.preventDefault();
                    return false;
                }
                if (data == 3) {
                    alert("您的剩余积分不足!");
                    eve.preventDefault();
                    return false;
                }
            }
        });

    })

    //首页搜索
    $("#tp-search-btn").click(function () {
        var keywords = $("#search-ipt").val();
        var curType = $("#curType").attr("value");
        if (!keywords) {
            return;
        }
        var url = "./";
        if (curType == 1 || curType == '1') {
            url += "resource!search.action?keywords=";
        }

        if (curType == 2 || curType == '2') {
            url += "information!search.action?keywords=";
        }

        if (curType == 3 || curType == '3') {
            url += "business!search.action?keywords=";
        }

        if (curType == 4 || curType == '4') {
            url += "newschannel!search.action?keywords=";
        }
        url += encodeURI(encodeURI(keywords));
        window.location = url;
    });

    var tbViewAlet = function (event) {
        var target = $(event.currentTarget);
        if (target.hasClass("needLogin")) {
            alert("您还没有登录，该信息仅会员可见！");
            return false;
        }

        if (target.hasClass("needVip")) {
            alert("该信息仅VIP会员可见！");
            return false;
        }

        return true;
    }

    $(".tb_name").click(function (event) {
        return tbViewAlet(event);
    });

    $(".tb-view").click(function (event) {
        return  tbViewAlet(event);
    });


//    $("#dialog-form").dialog({
//        autoOpen:false,
//        height:300,
//        width:350,
//        modal:true,
//        buttons:{
//            "提交":function () {
//                if(!$("#ly-content").val()){
//                    alert("留言内容不能为空!");
//                    return false;
//                }
//                $(this).dialog("close");
//                var id=$("#sid").val();
//                var content=$("#ly-content").val();
//                $.ajax({
//                    type: 'POST',
//                    url:"business!comment.action",
//                    data:{
//                        id:id,
//                        content:content
//                    },
//                    success:function (data) {
//                        if (data == 0) {
//                            alert("您还没有登录,请登录下再留言!");
//                            return;
//                        } else {
//                            alert("留言成功!");
//                            $("#ly-content").val("");
//                            window.location.reload();
//                        }
//                    }
//                });
//
//
//            },
//            取消:function () {
//                $(this).dialog("close");
//            }
//        },
//        close:function () {
//
//        }
//    });

    $(".showTb").click(function (event) {
        var target = $(event.currentTarget);
        var id =target.attr("sid");
        var pre = target.prev();
        if(pre.hasClass("overdue")){
            return false;
        }
        if(pre.hasClass("overdue")){
            return false;
        }
        if(pre.hasClass("needVip")){
            alert("该招标信息仅对VIP开放!");
            return false;
        }
        if(pre.hasClass("needLogin")){
            alert("您还没有登录，请登录后再留言");
            return false;
        }
        $("#sid").val(id);
        $("#dialog-form").dialog("open");
    });

    $(".sw-login").click(function(){
        window.location = "../user/login.jsp";
    });

    $(".sw-reg").click(function(){
        window.location = "../user/reg.jsp";
    });

    $(".star-icon").mouseover(function(event){
        var target = $(event.currentTarget);
        var sn = target.attr("sn");
        sn = parseInt(sn);
        for(var i=1;i<=sn;i++){
            var cur = $(".star"+i);
            if(cur.hasClass("star-big-off")){
                cur.removeClass("star-big-off").addClass("star-big-on")
            }
        }
        if(sn!=5){
            for(var i=sn+1;i<=5;i++){
                var cur = $(".star"+i);
                if(cur.hasClass("star-big-on")){
                    cur.removeClass("star-big-on").addClass("star-big-off")
                }
            }
        }
    })
    $(".star-icon").click(function(event){
        var target = $(event.currentTarget);
        var sn = target.attr("sn");
        $(".pl-core").html(sn);
    });
    $(".icon-grp").mouseleave(function(){
        var sn =  $(".pl-core").html();
        sn = parseInt(sn);
        for(var i=1;i<=sn;i++){
            var cur = $(".star"+i);
            if(cur.hasClass("star-big-off")){
                cur.removeClass("star-big-off").addClass("star-big-on")
            }
        }
        if(sn!=5){
            for(var i=sn+1;i<=5;i++){
                var cur = $(".star"+i);
                if(cur.hasClass("star-big-on")){
                    cur.removeClass("star-big-on").addClass("star-big-off")
                }
            }
        }
    });
})