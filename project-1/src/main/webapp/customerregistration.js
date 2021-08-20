btn1.onclick = () => {
    let url = "http://localhost:8080/project-1/register.html";
    fetch(url,{
        method : 'POST', body: JSON.stringify({
            name : document.getElementById('name').value,
            email : document.getElementById('email').value,
            username : document.getElementById('username').value,
            password : document.getElementById('password').value,
            mobileno : document.getElementById('mobileno')
        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
          },
    })
    alert("Registration Details Inserted Successfully")
    console.log(document.getElementById('name').value);
    console.log(document.getElementById('email').value);
    console.log(document.getElementById('username').value);
    console.log(document.getElementById('password').value);
    console.log(document.getElementById('mobileno').value);

}