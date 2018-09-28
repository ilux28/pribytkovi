$(document).ready(function() {
    $.ajax('./add', {
        method: 'get',
        complete: function (data) {
            var respJson = data.responseJSON;
            console.log(respJson);
            //console.log(respJson.size);
            var result = "<tr>" +
                "<td>ID</td>" +
                "<td>Description</td>" +
                "<td>Created</td>" +
                "<td>Done</td>" +
                "</tr>";
            var table = document.getElementById("items");
            var items = JSON.parse(data.responseText);
            console.log(items);
            var j = 0;
            for (var key in items) {
                var itemKey = items[key];
                var newI = document.createElement("tr");
                var i = 0;
                for (keyz in itemKey) {
                    var newV = document.createElement("td");
                    newV.innerHTML = itemKey[keyz];
                    newI.insertBefore(newV, newI.children[i]);
                    i++;
                }
                table.appendChild(newI);
                j++;
            }
            /*
            for (var j = 0; j <respJson.length; j++) {
                for (var i = 0; i < table.rows.length; i++) {
                    table.cells[i].rows[j + 1].innerHTML = respJson[i + j];
                }
                var table = document.getElementById("items");
                table.innerHTML = result;
            } */
        }
    })
});



