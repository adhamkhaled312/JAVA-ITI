
function setCookie(name, value, days) {
    let expires = "";
    const date = new Date();
    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
    expires = "; expires=" + date.toUTCString();
	document.cookie =name + "=" + encodeURIComponent(value) + expires +"; path=/; SameSite=None;secure";
}

function getCookie(name) {
    const cname = name + "=";
    const cookiesArray = document.cookie.split(';');
    for (let i = 0; i < cookiesArray.length; i++) {
        let c = cookiesArray[i];
        while (c.charAt(0) === ' ') c = c.substring(1);
        if (c.indexOf(cname) === 0) {
            return decodeURIComponent(c.substring(cname.length));
        }
    }
    return "";
}

function deleteCookie(name) {
    document.cookie = name + "=; Max-Age=-99999999; path=/";
}

function hasCookie(name) {
    return getCookie(name) !== "";
}
