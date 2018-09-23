$(document).ready(function() {
    $.ajax('./add', {
        method : 'get',
        complete: function(data) {
            data = JSON.parse(data);
            for(var key in data) {
                console.log("key: " + key + "value: " + data[key]);
            }

        }
    });
});



