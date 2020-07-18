function checknull(id) {
    var display = document.getElementById("us_id");
    if(id.value =="") {
        display.innerHTML="不可為空，請輸入!"
        id.focus();
    }
    else{display.innerHTML=""}
}

function checknull(id) {
    var display = document.getElementById("suus_id");
    if(id.value =="") {
        display.innerHTML="不可為空，請輸入!"
        id.focus();
    }
    else{display.innerHTML=""}
}