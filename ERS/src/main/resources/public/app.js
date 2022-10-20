let loginBtn = document.getElementById('loginButton');
loginBtn.addEventListener('click', logIn);
async function logIn() {
    const credentials = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };
    console.log("im in Login");
    console.log(credentials.username);
    console.log("Im here!");
    console.log(credentials.password);
    let credentialJSON = JSON.stringify(credentials);