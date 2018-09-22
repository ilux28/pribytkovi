$(document).ready(function() {
    $.ajax('./add', {
        method : 'get',
        complete: function(data) {
            console.log(JSON.parse(data.responseText));
        }
    });
});



