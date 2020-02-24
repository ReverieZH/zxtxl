function MyCheck() {
	var name = document.getElementById("name").value;
	name = trim(name);
	if (name == "") {
		alert("请输入姓名!");
	   return false;
	}
	var phone=document.getElementById("phone").value;
	phone = trim(phone);
	if (phone == "") {
		alert("请输入电话号码!");
		return false;
	}
	return true;
}