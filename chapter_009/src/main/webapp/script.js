/*$(
    $.ajax('./add', {
        method : 'get',
        complite: function(data) {
            var result =    "<tr>" +
                "<td>ID</td>\n" +
                "<td>Description</td>\n" +
                "<td>Created</td>\n" +
                "<td>Done</td>" +
                "</tr>";
            var items = JSON.parse(data.responseText);
            for (var i=0;i!=items.length;++i) {
                result += "<tr>" +
                    "<td>" + items[i].id + "</td>"+
                    "<td>" + items[i].description + "</td>"+
                    "<td>" + items[i].creted + "</td>"+
                    "<td>" + items[i].done + "</td>"+
                    "</tr>";
            }
            var table = document.getElementById("items");
            table.innerHTML = result;
        }
    })
);
function createItem() {
    $.ajax('./add', {
        method : 'post',
        data : {description : document.getElementById("inputDescription"),
            created : document.getElementById("created"),
            done : document.getElementById("done")}
    })
    return false;
}
function sendItem(url, callback) {
    var oXmlHttp = createXMLHttp();
    //подготовка и объявление запросов
    oXmlHttp.open("GET", url, true);
    oXmlHttp.setRequestHeader("Content-Type", "text/html; charset=utf-8");
}
*/
$(document).ready(function() {
    $.ajax('./add', {
        method : 'get',
        complete: function(data) {
            console.log(JSON.parse(data.responseText));
        }
    });
})



