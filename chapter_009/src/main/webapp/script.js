$(document).ready(function(){
    $("#button").click(function(){
        var data = {};
        data = {"description":$("#inputDescription").val(), "created":$("#created").val(), "done":$("#done")};
        //
        $.ajax
        ({
            type: "POST",//Метод передачи
            data: data,//Передаваемые данные в JSON - формате
            url: 'AddServlet',//Название сервлета
            success:function(serverData)//Если запрос удачен
            {
                $("#auth-info").css({"background-color":serverData.backgroundColor, "height": "50px", "color":"white"});
                $("#auth-info").html(serverData.serverInfo);
            },
            error: function(e)//Если запрос не удачен
            {
                $("#auth-info").css({"background-color":"#CC6666", "height": "50px", "color":"white"});
                $("#auth-info").html("Запрос не удался!");
            }
        });
    });
});
