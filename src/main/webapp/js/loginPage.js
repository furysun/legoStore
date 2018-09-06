function test() {
    var loginInput = document.getElementById("login");
    var passwordInput = document.getElementById("password");

    if(loginInput.value==="" || passwordInput.value===""){
        alert("fill in the fields");
    }
}