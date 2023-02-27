//var token = $("meta[name='_csrf']").attr("content");
//var header = $("meta[name='_csrf_header']").attr("content");
//$(function() {
//    $(document).ajaxSend(function(e, xhr, options) {
//        xhr.setRequestHeader(header, token);
//    });
//});


var isEmailSend = false;



// loading UI
function run_waitMe(el, num, effect){
    text = 'Please wait...';
    fontSize = '';
    switch (num) {
        case 1:
        maxSize = '';
        textPos = 'vertical';
        break;
        case 2:
        text = '';
        maxSize = 30;
        textPos = 'vertical';
        break;
        case 3:
        maxSize = 30;
        textPos = 'horizontal';
        fontSize = '18px';
        break;
    }
    el.waitMe({
        effect: effect,
        text: text,
        bg: 'rgba(0, 0, 0,0.55)',
        color: '#fff',
        maxSize: maxSize,
        waitTime: -1,
        source: 'img/waitMe-img.svg',
        textPos: textPos,
        fontSize: fontSize,
        onClose: function(el) {}
    });
}



function fn_emailSend_Valid(){
    if(!$("#userNm").val().trim()){
        alert("이름을 입력하세요");
        return true;
    }

    if(!$("#userHp").val().trim()){
        alert("연락처를 입력하세요");
        return true;
    }

    if(!$("#userDesc").val().trim()){
        alert("연락처를 입력하세요");
        return true;
    }
    if(!$('#agree-btn').is(':checked')){
        alert("개인정보 수집에 동의해주세요")
        return true;
    }
}

function emailSend(){
    if(isEmailSend){
        alert("잠시후 다시 시도해 주세요")
        return;
    }
    if(fn_emailSend_Valid()){
        return;
    }
    run_waitMe($('body'), 1, 'stretch');
    isEmailSend =true;
    var param = {
              "userNm" : $("#userNm").val().trim() ,
              "userHp" : $("#userHp").val().trim() ,
              "userDesc" : $("#userDesc").val() ,
     };
    $.ajax({
        type:"get",
        url:"/onlineconsulting/mail" ,
        data: param,
        success(data){
            if(data > 0){
                alert("문의가 접수되었습니다. 빠른시일내에 답변드리겟습니다.");
                location.reload(true);
            }else{
                alert("이메일 전송오류");
                location.reload(true);
            }


        },
        error:function(request,status,error){
          alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
         }
      });
}


function privacy_popup_close(){
        $('.modal-custom').css('display','none')

        }
        function privacy_popup_open(){
        $('.modal-custom').css('display','block')

        }
