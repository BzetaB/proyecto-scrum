function listarClientes(){
    $.ajax({
        type: "GET",
        url: "/clientes/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblclientes > tbody").html("")
            $.each(resultado, function(index, value){
                $("#tblclientes > tbody").append("<tr>"+
                `<td>${value.idcliente}</td>`+
                `<td>${value.tipodocumento}</td>`+
                `<td>${value.documento}</td>`+
                `<td>${value.nombres}</td>`+
                `<td>${value.apellidos}</td>`+
                `<td>${value.telefono}</td>`+
                `<td>${value.correo}</td>`+
                `<td>${value.fechanacimiento}</td>`+
                `<td>${value.sexo}</td>`+
                `<td>${value.direccion}</td>`+
                `<td>${value.username}</td></tr>`
                )
            })
        }
    })
}