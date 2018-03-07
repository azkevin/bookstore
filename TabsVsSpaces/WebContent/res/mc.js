function validate() {
	var ok = true;
	var name = document.getElementById("name").value;
	var credit = document.getElementById("credit").value;
	
	if (name == null || name == "") {
		alert("Name invalid. It must exist.");
		ok = false;
	} else if (/[^a-zA-Z0-9]/.test(name)) {
		alert("Name is not alphanumeric");
		ok = false;
	}
	if (!ok)
		return false;
	
	if (isNaN(credit) || credit == "") {
		alert("Minimum credit invalid. It must exist.");
		ok = false;
	} else if (credit < 0) {
		alert("Minimum credit invalid. It must be >= 0")
		ok = false;
	}	
	if (!ok)
		return false;
	
	return ok;
}