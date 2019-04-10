var data = JSON.stringify({"id":1,"name":"blue"});
$.ajaxSetup({
    xhrFields: {withCredentials: true}
});
function insert() {
    $.ajax({
        type:"post",
        url:Link_test+"/add",
        dataType:"json",
        contentType:"application/json",
        // xhrFields:{withCredentials:true},
        // crossDomain: true,
        data:data,
        success:function (data) {
        }
    })
}
function addSession() {
    $.ajax({
        url:Link_test+"/addSession",
        data:data,
        dataType:'json',
        type:"POST",
        // xhrFields: {
        //     withCredentials: true
        // },
        // crossDomain: true,
        contentType: "application/json",
        success:function (data) {
        }
    })
}
function checkSession() {
    $.ajax({
        type:"post",
        url:Link_test2+"/checkSession",
        dataType:"json",
        contentType:"application/json",
        // xhrFields:{withCredentials:true},
        // crossDomain: true,
        data:data,
        success:function (data) {
        }
    })
}