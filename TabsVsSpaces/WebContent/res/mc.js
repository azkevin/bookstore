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

// UC Analytics : Change selected value
function reportBooksSold(){
	var month = document.getElementById("admin_month").value;
	var year = document.getElementById("admin_year").value;
	
	if(month === "all")
		document.getElementById("admin_month").options[0].selected = true;
	else
		document.getElementById("admin_month").options[parseInt(month, 10)].selected = true;
	
	if(year === "all")
		document.getElementById("admin_year").options[0].selected = true;
	else
		document.getElementById("admin_year").options[parseInt(year, 10)].selected = true;
		
	document.forms["analyticsForm"].submit();
}


//UC A1: Generate a report with books sold each month.
//function reportBooksSold(){
//	//alert('In on change function');
//	var month = document.getElementById("admin_month").value;
//	var year = document.getElementById("admin_year").value;
//	console.log(month);
//	var request = new XMLHttpRequest();
//    var data={
//        'month': month,
//        'year': year
//    };
//    
//    request.open("POST", '/TabsVsSpaces/Start', true);
//    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//    alert('Hello');
//    request.onreadystatechange = function() 
//    {
//        handler(request);
//    };
//    alert('Hello now');
//    request.send(data);
//
//	return ok;
//	
//}
//
//function handler(request){
//    if ((request.readyState == 4) && (request.status == 200)){
//    	alert('Success');
//    }
//} 

function acc_form_validate() {
    var ok = true;
    
    try {
        var email = document.getElementById("email") != null ? document.getElementById("email").value : null;
        var acc_pass = document.getElementById("acc_password") != null ? document.getElementById("acc_password").value : null;
        var acc_c_pass = document.getElementById("acc_c_password") != null ? document.getElementById("acc_c_password").value : null;
        var firstname = document.getElementById("firstname") != null ? document.getElementById("firstname").value : null;
        var lastname = document.getElementById("lastname") != null ? document.getElementById("lastname").value : null;
        var streetname = document.getElementById("streetname") != null ? document.getElementById("streetname").value : null;
        var province_regex = "^[A-Z]{2}";
        var province = document.getElementById("province") != null ? document.getElementById("province").value : null;
        var country = document.getElementById("country") != null ? document.getElementById("country").value : null;
        var zip = document.getElementById("zip") != null ? document.getElementById("zip").value : null;
        var phone_regex = "^[0-9]{3}-[0-9]{3}-[0-9]{4}";
        var phone = document.getElementById("phone") != null ? document.getElementById("phone").value : null;
        var card_regex = "^[0-9]{10}";
        var card_num = document.getElementById("card_num") != null ? document.getElementById("card_num").value : null;
        var card_type = document.getElementById("card_type") != null ? document.getElementById("card_type").value : null;
        var month = document.getElementById("month") != null ? document.getElementById("month").value : null;
        var year_regex = "^[2-9][0-9]{3}";
        var year = document.getElementById("year") != null ? document.getElementById("year").value : null;
    }
    catch(e) {
    	if(e instanceof TypeError)
    	{
    		console.log(e);
    		ok = false;
            alert("One or more field(s) are entered incorrectly!");
    	}   
    }

    if(email != null && email.indexOf('@') == -1)
    {
        alert("Invalid email address");
        ok = false;
    }

    else if(acc_pass != null && acc_pass !== acc_c_pass)
    {
        alert("Passwords don't match!");
        ok = false;
    }

    else if(acc_pass != null && acc_pass.length < 8)
    {
        alert("Password must be atleast 8 chars long");
        ok = false;
    }

    else if(province != null && province.match(province_regex) == null)
    {
        alert("Invalid province! Eg - ON");
        ok = false;
    }
    
    else if(phone != null && phone.match(phone_regex) == null)
    {
        alert("Invalid phone number! Eg - 416-756-9987");
        ok = false;
    }

    else if(card_num != null && card_num.match(card_regex) == null)
    {
        alert("Invalid credit card number! Eg - Enter 10 valid digits");
        ok = false;
    }

    else if(year != null && year.match(year_regex) == null)
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