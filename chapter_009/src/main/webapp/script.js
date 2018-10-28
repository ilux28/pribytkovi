$(document).ready(getData());

var el = document.getElementsByClassName('menu-item');
    for (var i = 0; i<el.length; i++) {
        el[i].addEventListener("mouseover", showSub, false);
        el[i].addEventListener("mouseleave", hideSub, false);
    }
    console.log("Exelent!");

function showSub() {
    if (this.children.length>1) {
        this.cildren[1].style.height = "auto";
        this.cildren[1].style.overflow = "visible";
        this.cildren[1].style.opacity = "1";
        console.log("showSub");
    } else {
        return false;
    }
}
function hideSub() {
    if (this.children.length>1) {
        this.cildren[1].style.height = "0px";
        this.cildren[1].style.overflow = "hidden";
        this.cildren[1].style.opacity = "0";
        console.log("hideSub");
    } else {
        return false;
    }
}
function sendData() {
    $.ajax('./add', {
        method: 'post',
        data: {
            //id: document.getElementsByName("inputDescription").value,
            description: document.getElementById('inputDescription').value,
            created: document.getElementById('created').checked,
            done: document.getElementById('done').checked
        },
        success : getData
    });
}
function getData() {
    $.ajax("./add", {
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
}



