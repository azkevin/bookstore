function loginUser(address) {
	var ok = true;
	var user = document.getElementById("username").value;
    var pass = document.getElementById("password").value;
    alert(address);
    var request = new XMLHttpRequest();
    var data={
        'username': user,
        'password': pass
    };
    
    /* add your code here to grab all parameters from form*/
    request.open("POST", address, true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    alert('Hello');
//    request.onreadystatechange = function() 
//    {
//        handler(request);
//    };
    alert('Hello now');
    request.send(data);

	return ok;
}

function handler(request){
    if ((request.readyState == 4) && (request.status == 200)){
        request.open("GET", "/TabsVsSpaces/Akshay", true);
        request.send();
    }
} 