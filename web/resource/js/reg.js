/**
 * Author: 章伟
 * Date: 13-2-19
 * Time: 下午2:19
 * 远方软件有限公司
 */
$( document ).ready( function() {
    var err1=true;
    var err2=true;
    var err3=true;
    var err4=true;

    //email检验
    $("#Email").blur(function(){
        var errSpan =  $(this).next();
        var email = $(this).val();
        if(!email){
            errSpan.html("email不能为空!");
            return;
        }
        $.ajax({
            url: "user!checkEmailExsit.action",
            data: {
                email: email
            },
            success: function( data ) {
                errSpan.html(data==1?"email已经注册，请使用其他email!":"");
                err1 =data==1?false:true;
            }
        });
    })

    //nick检验
    $("#NID").blur(function(){
        var errSpan =  $(this).next();
        var nick = $(this).val();
        if(!nick){
            errSpan.html("昵称不能为空!");
            return;
        }
        $.ajax({
            url: "user!checkNickExsit.action",
            data: {
                nick: nick
            },
            success: function( data ) {
                errSpan.html(data==2?"nick已经注册，请使用其他nick!":"");
                err1 =data==2?false:true;
            }
        });
    })

    $("#code").blur(function(){
        var errSpan =  $(this).next().next();
        var code = $(this).val();
        errSpan.html(code?"":"验证码不能为空!");
        err4 = code?true:false;
    });

    $("#PasswordAgain").blur(function(){
        var errSpan =  $(this).next();
        var pwdAgain = $(this).val();
        var pwd = $("#Password").val();
       errSpan.html(pwdAgain==pwd?"":"两次密码不一样，请确认您重新输入得密码!");
        err1 =pwdAgain==pwd?true:false;
    })

    $("#regSubmit").click(function(){
       return err1&&err2&&err3&&err4;
    })

})

function showRtnMsg(err){
    var msg= "";
    if(err=="1"){
        msg ="用户邮箱已注册!";
    }
    if(err=="2"){
        msg ="用户昵称已存在!";
    }
    if(err=="3"){
        msg ="用户两次密码不一致!";
    }
    if(err=="4"){
        msg ="用户信息不完整!";
    }
    if(err=="5"){
        msg ="验证码错误!";
    }
    alert(msg);

}
