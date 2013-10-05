$( document ).ready( function() {
	$("#btnSubmit").click(function(){
        var name = $("#txtName").val();
        var pwd = $("#txtPassword").val();
        var code = $("#txtVerifycode").val();
        if(!(name&&pwd)){
            alert("用户名或密码不能为空!");
            return;
        }
        if(!code){
            alert('验证码不能为空!');
            return;
        }
        $.ajax({
            url: "user!ajaxLogin.action",
            data: {
                name: name,
                pwd:pwd,
                code:code
            },
            success: function( data ) {
                if(data===0||data==='0'){
                    alert("用户名或密码错误!");
                    return;
                }else if(data===2||data==='2'){
                    alert("验证码错误，请重新输入验证码!");
                    return;
                }else{
                    alert("登陆成功!");
                    window.location.href="../userinfo!edit.action";
                }
            }
        });


    })
	
	
	
	
});