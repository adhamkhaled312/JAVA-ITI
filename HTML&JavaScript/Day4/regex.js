function validateAll() {
  const email = document.getElementById('email').value;
  const mobile = document.getElementById('mobile').value;
  const visa = document.getElementById('visa').value;

  const emailPtrn = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  const mobilePtrn = /^01[0125]\d{8}$/;
  const visaPtrn = /^\d{4}-\d{4}-\d{4}-\d{4}$/;

  try {
    if (!emailPtrn.test(email)) throw "Invalid Email";
    if (!mobilePtrn.test(mobile)) throw "Invalid Mobile";
    if (!visaPtrn.test(visa)) throw "Invalid Credit Card Number";
    
    const matches = visa.match(/\d{4}/g);
    document.getElementById('visaList').value = matches ? matches.join('\n') : "";

    alert("Form is Valid!");
  } catch (err) {
    alert(err);
  }
}