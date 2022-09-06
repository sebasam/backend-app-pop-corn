const registerUser = async() => {
    let data = {}
    data.email = document.getElementById('txtEmail').value
    data.nombre = document.getElementById('txtUser').value
    data.contraseña = document.getElementById('txtPassword').value

    try{
        const request = await fetch('api/registrar', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        alert('Usuario creado exitosamente!!')
    }catch(e){
        console.log(e)
    }
}