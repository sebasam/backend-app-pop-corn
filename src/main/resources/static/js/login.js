const loginUser = async() => {
    let data = {}
    data.email = document.getElementById('txtEmail').value
    data.contraseña = document.getElementById('txtPassword').value

    try{
        const request = await fetch('api/login', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        const response = await request.text();
        if(response != 'Error in login process'){
            localStorage.token = response
            localStorage.email = data.email
            window.location.href = 'protected.html'
        }else{
            alert('Los datos no pertenecen a ningún usuario')
        }
    }catch(e){
        console.log(e)
    }
}