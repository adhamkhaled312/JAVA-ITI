
    document.getElementById("contactForm").addEventListener("submit", function(e){

        e.preventDefault();

        let name = document.getElementById("name").value.trim();
        let password = document.getElementById("password").value;
        let confirm = document.getElementById("confirmPassword").value;
        let card = document.getElementById("card").value.trim();
        let email = document.getElementById("email").value.trim();
        let phone = document.getElementById("phone").value.trim();
        let browser = document.getElementById("browser").value.trim();

        let namePattern = /^[A-Za-z\s]+$/;
        let cardPattern = /^\d{16}$/;        
        let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        let phonePattern = /^01[0125]\d{8}$/;

        if(!namePattern.test(name)){
            alert("Name must contain letters only.");
            return;
        }

        if(password.length < 6 || password.length > 8){
            alert("Password must be between 6 and 8 characters.");
            return;
        }

        if(password !== confirm){
            alert("Passwords do not match.");
            return;
        }

        if(!cardPattern.test(card)){
            alert("Credit card must be 16 digits.");
            return;
        }

        if(!emailPattern.test(email)){
            alert("Invalid email format.");
            return;
        }

        if(!phonePattern.test(phone)){
            alert("Invalid mobile number.");
            return;
        }

        if(browser === ""){
            alert("Please enter your favorite browser.");
            return;
        }

        openResultWindow(name, email, phone, browser, card);

    });

function openResultWindow(name, email, phone, browser, card){

    let win = window.open("","_blank", "width=500,height=500");

    win.document.write(`
        <html>
        <head>
            <title>Submitted Data</title>
        </head>

        <body>

            <h2>Your Submitted Data</h2>

            <p><b>Name:</b> ${name}</p>
            <p><b>Email:</b> ${email}</p>
            <p><b>Phone:</b> ${phone}</p>
            <p><b>Browser:</b> ${browser}</p>
            <p><b>Credit Card:</b> ${card}</p>

        </body>
        </html>
    `);

    win.document.close();
}
