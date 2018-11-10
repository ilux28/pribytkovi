$(document).ready(getData());
$(document).ready(function() {
    var el = document.getElementsByClassName('menu-item');
    var eli = document.getElementsByClassName('sub-menu');
    for (var i = 0; i < el.length; i++) {
        el[i].addEventListener("mouseenter", showSub, false);
        el[i].addEventListener("mouseleave", hideSub, false);
    }
    /*for (var i = 0; i < eli.length; i++) {
        for (var j = 0; j < eli[i].childElementCount; j++) {
            eli[i].children[j].addEventListener(onclick(), funcShow, false);
        }
    }*/
    console.log("Exelent!")
});

function funcShow() {

}

function showSub() {
    if (this.children.length>1) {
        this.children[1].style.height = "auto";
        this.children[1].style.overflow = "visible";
        this.children[1].style.opacity = "1";
        console.log("showSub");
    } else {
        return false;
    }
}
function hideSub() {
    if (this.children.length>1) {
        this.children[1].style.height = "0px";
        this.children[1].style.overflow = "hidden";
        this.children[1].style.opacity = "0";
        console.log("hideSub");
    } else {
        return false;
    }
}
function sendData() {
    var formArr = $(".add-forms :input");
    console.log(formArr.length);
    var item = {};
    console.log(formArr);
    for (var i = 0; i < formArr.length - 1; i++) {
        if (formArr[i].type == 'checkbox') {
            item[formArr[i]['name']] = formArr[i]['checked'];
        } else {
            item[formArr[i]['name']] = formArr[i]['value'];
        }
        console.log(formArr[i]['type']);
    }
    var itemJSON = JSON.stringify(item);
    console.log(item);
    console.log(itemJSON);
    $.ajax('./add', {
        method: 'post',
        data: itemJSON,
/*{
            id: document.getElementsByName("inputId").value,
            description: document.getElementById('inputDescription').value,
            created: document.getElementById('created').checked,
            done: document.getElementById('done').checked
        },
*/
        //processData: false,
        //contentType: false,
        dataType: 'JSON',
        success : getData()
    });
}
function getData() {
    $.ajax("./add", {
        method: 'get',
        complete : function (data) {
            var table = document.getElementById("items");
            var items = JSON.parse(data.responseText);
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
            console.log("Receive data success!");
        }
    })
}



