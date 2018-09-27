$(document).ready(function() {
    $.ajax('./add', {
        method: 'get',
        complete: function (data) {
            var respJson = data.responseJSON;
            console.log(respJson);
            var resp = data.responseText;
            console.log(resp);
            var respJsonParse = JSON.parse(resp);
            console.log(respJsonParse);
            var JSONArray = data.array.data;
            for (var i in JSONArray) {
                console.log(JSONArray.toString());
                console.log(JSONArray.valueOf());
            }

            /*
            console.log(respJson.desc);
            console.log(respJson.created);
            console.log(respJson.done);


             //data = JSON.parse(data);
             /* for(var key in data) {
                 console.log("key: " + key + "value: " + data[key]);
             */
            /* var result = "<tr>" +
                "<td>ID</td>" +
                "<td>Description</td>" +
                "<td>Created</td>" +
                "<td>Done</td>" +
                "</tr>";
            var items = JSON.parse(data.responseText);
            for (var i = 0; i != items.length; ++i) {
                result += "<tr>" +
                    "<td>" + items[i].id + "</td>" +
                    "<td>" + items[i].desc + "</td>" +
                    "<td>" + items[i].created + "</td>" +
                    "<td>" + items[i].done + "</td>" +
                    "</tr>";
            }
            var table = document.getElementById("items");
            table.innerHTML(result);
            */
        }
    })
});



