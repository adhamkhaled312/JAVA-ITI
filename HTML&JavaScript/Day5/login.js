window.onload = function() {
    const usernameInput = document.getElementById("username");
    const rememberCheckbox = document.getElementById("remember");

    if (hasCookie("username")) {
        usernameInput.value = getCookie("username");
        rememberCheckbox.checked = true;
    }

    document.getElementById("loginForm").addEventListener("submit", function(e) {
        e.preventDefault();
        const username = usernameInput.value;

        if (rememberCheckbox.checked) {
            setCookie("username", username, 7);
        } else {
            deleteCookie("username");
        }

        alert("Form submitted! Username: " + username);
    });
};