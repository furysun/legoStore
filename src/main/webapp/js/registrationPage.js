function validateConfirm() {

    var passwordInput = document.getElementById("password");
    var confirmPasswordInput = document.getElementById("confirmPassword");

    var errorMessage = document.getElementById("error-message");
    var submit = document.getElementById("submit");

    if (passwordInput.value !== confirmPasswordInput.value) {
        submit.disabled = true;
        errorMessage.hidden = false;
    } else {
        submit.disabled = false;
        errorMessage.hidden = true ;
    }
}