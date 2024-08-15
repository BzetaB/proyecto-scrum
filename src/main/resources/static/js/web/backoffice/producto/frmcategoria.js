$(document).on("click","#btnagregar",function(){
    $("#txtnombrecategoria").val("");
    $("#hddidcate").val("0");
    $("#modalcategoria").modal("show");
})


$(document).on("click",".btnactualizar",function(){
    $("#txtnombrecategoria").val($(this).attr("data-catnombre"));
    $("#hddidcate").val($(this).attr("data-catid"));
    listarCategorias();
    $("#modalcategoria").modal("show");
});



$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"POST",
        url:"/categoria/registrar",
        contentType:"application/json",
        data: JSON.stringify({
            idcategoria: $("#hddidcate").val(),
            nomcategoria: $("#txtnombrecategoria").val(),
        }),
        success: function(resultado){
            if(resultado.resultado){
                listarCategorias()
            }
            alert(resultado.mensaje)
        }
    });
    $("#modalcategoria").modal("hide");
});


function listarCategorias(){
    $.ajax({
        type: "GET",
        url: "/categoria/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblcategoria > tbody").html("")
            $.each(resultado, function(index, value){
                $("#tblcategoria > tbody").append("<tr>"+
                `<td>${value.idcategoria}</td>`+
                `<td>${value.nomcategoria}</td>`+
                `<td><button type="button" class="btn btn-info btnactualizar" `+
                ` data-catid="${value.idcategoria}" `+
                ` data-catnombre="${value.nomcategoria}">Actualizar</button></td></tr>`
                )

            })
        }
    })
}