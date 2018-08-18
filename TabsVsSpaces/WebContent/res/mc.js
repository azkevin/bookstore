// Cart checkout 
function cartCheckOut() {
    if (confirm("Do you want to checkout?")) {
    	return true;
    } else {
        return false;
    }
}

//UC M5: Add an individual book to the shopping cart
function cartUpdated() {
	alert("This book has been added to your cart.");
	return true;
}

// Prompt the user to sign in before adding a review or a book to the cart
function pleaseSignIn() {
	alert("Please sign in first.");
	return true;
}

// UC M3: Add a review for the book
function validateReviewText() {
	var ok = true;
	if(document.getElementById("reviewText").value == '') {
		alert("Please enter a review with 1-800 characters.");
		ok = false;
	}
	return ok;
}

// UC M4: Search (text) for a book title in the store 
function searchText() {
    var input, filter, bookDiv, columns, ele, i;
    input = document.getElementById('searchInput');
    filter = input.value.toUpperCase();
    bookDiv = document.getElementById('bookDiv');
    columns = bookDiv.getElementsByClassName('columns');

    for (i = 0; i < columns.length; i++) {
        ele = columns[i].getElementsByClassName("header")[0];
        if (ele.innerHTML.toUpperCase().indexOf(filter) > -1) {
        	columns[i].style.display = "";
        } else {
        	columns[i].style.display = "none";
        }
    }
}

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

function acc_form_validate() {
    var ok = true;
    //var objArr = [];
    console.log("ac");
    
    try {
        var email = document.getElementById("email").value;
        var acc_pass = document.getElementById("acc_password").value;
        var acc_c_pass = document.getElementById("acc_c_password").value;
        var firstname = document.getElementById("firstname").value;
        var lastname = document.getElementById("lastname").value;
        var streetname = document.getElementById("streetname").value;
        var province_regex = "^[A-Z]{2}";
        var province = document.getElementById("province").value;
        var country = document.getElementById("country").value;
        var zip = document.getElementById("zip").value;
        var phone_regex = "^[0-9]{3}-[0-9]{3}-[0-9]{4}";
        var phone = document.getElementById("phone").value;
        var card_regex = "^[0-9]{10}";
        var card_num = document.getElementById("card_num").value;
        var card_type = document.getElementById("card_type").value;
        var month = document.getElementById("month").value;
        var year_regex = "^[2-9][0-9]{3}";
        var year = document.getElementById("year").value;
    }
    catch(e) {
    	if(e instanceof TypeError)
    	{
    		console.log(e);
    		console.log("Here");
    		ok = false;
            alert("One or more field(s) are entered incorrectly!");
    	}   
    }

    if(email.indexOf('@') == -1)
    {
        alert("Invalid email address");
        ok = false;
    }

    if(acc_pass !== acc_c_pass)
    {
        alert("Passwords don't match!");
        ok = false;
    }

    if(acc_pass.length < 8)
    {
        alert("Password must be atleast 8 chars long");
        ok = false;
    }

    if(province.match(province_regex) == null)
    {
        alert("Invalid province! Eg - ON");
        ok = false;
    }
    
    if(phone.match(phone_regex) == null)
    {
        alert("Invalid phone number! Eg - 416-756-9987");
        ok = false;
    }

    if(card_num.match(card_regex) == null)
    {
        alert("Invalid credit card number! Eg - Enter 10 valid digits");
        ok = false;
    }

    if(year.match(year_regex) == null)
    {
        alert("Invalid expiration year! Eg - 2020");
        ok = false;
    }
    // if(!cvv.match(cvv_regex))
    // {
    //     alert("Invalid CVV! Enter valid 3");
    //     ok = false;
    // }

    return ok;
}