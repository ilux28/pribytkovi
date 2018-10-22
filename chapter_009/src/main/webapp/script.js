$(document).ready( $.ajax("./add", {
        method: 'get',
        complete : function (data) {
            var table = document.getElementById("items");
            var items = JSON.parse(data.responseText);
            console.log(items);
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
            }
        }
})
);
$('#myButton').click(
    $.ajax('./add', {
        method: 'post',
        data: {
            //id: document.getElementsByName("inputDescription").value,
            description: document.getElementById('inputDescription').value,
            created: document.getElementById('created').checked,
            done: document.getElementById('done').checked
        }
    }), complete())



