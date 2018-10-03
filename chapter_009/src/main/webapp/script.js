$(document).ready(function() {
    $.ajax('./add', {
        method: 'get',
        complete: function (data) {
            //var respJson = data.responseJSON;
            //console.log(respJson);
            //console.log(respJson.size);
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
            /*
            for (var j = 0; j <respJson.length; j++) {
                for (var i = 0; i < table.rows.length; i++) {
                    table.cells[i].rows[j + 1].innerHTML = respJson[i + j];
                }
                var table = document.getElementById("items");
                table.innerHTML = result;
            } */
        }
    });
});
/*function checkedCrea() {
    if (document.getElementById('created').checked ) {
        document.getElementById('created').value = true;
    } else {
        document.getElementById('created').value = false;
        return true;
    }
    console.log(document.getElementById('created').checked);

}
function checkedDone() {
    if (document.getElementById('done').checked) {
        document.getElementById('done').value = true;
    } else {
        document.getElementById('done').value = false;
        return true;
    }
    console.log(document.getElementById('done').checked);
}
*/
function sendAjaxItem() {
    $.ajax('./add', {
        method: 'post',
        data: {
            //id: document.getElementsByName("inputDescription").value,
            description : document.getElementById('inputDescription').value,
            created: document.getElementById('created').checked,
            done:  document.getElementById('done').checked
        }
    });
    return false;
    console.log("ishe");
}