$(document).on("click","#btnagregar",function(){
    $("#txtnombreproducto").val("");
    $("#txtprecioproducto").val("");
    $("#txtdetalle").val("");
    $("#unidades").val("1");
    $("#switchproducto").hide();
    $("#cbactivo").prop("checked",false);
    $("#hddidprod").val("0");
    $("#hddstock").val("0");
    $("#cbocategoria").empty();
    listarCatProduc($(this).attr("data-prodcat"));
    $("#modalproducto").modal("show");
})


$(document).on("click",".btnactualizar",function(){
    $("#txtnombreproducto").val($(this).attr("data-prodnom"));
    $("#txtprecioproducto").val($(this).attr("data-prodprecio"));
    $("#txtdetalle").val($(this).attr("data-proddetalles"));
    $("#unidades").val($(this).attr("data-produnidades"));
    $("#switchproducto").show();
    if ($(this).attr("data-prodactivo")==="true"){
        $("#cbactivo").prop("checked",true);
    }else{
        $("#cbactivo").prop("checked",false);
    }
    $("#hddidprod").val($(this).attr("data-prodid"));
    $("#hddstock").val($(this).attr("data-prodstock"));
    $("#cbocategoria").empty();
    listarCatProduc($(this).attr("data-prodcat"));
    $("#modalproducto").modal("show");
});


$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"POST",
        url:"/producto/registrar",
        contentType:"application/json",
        data: JSON.stringify({
            idproducto: $("#hddidprod").val(),
            nombre: $("#txtnombreproducto").val(),
            precio: $("#txtprecioproducto").val(),
            detalles: $("#txtdetalle").val(),
            unidades: $("#unidades").val(),
            stock: $("#hddstock").val(),
            idcategoria: $("#cbocategoria").val(),
            activo: $("#cbactivo").prop("checked")
        }),
        success: function(resultado){
            if(resultado.resultado){
                listarProductos()
            }
            alert(resultado.mensaje)
        }
    });
    $("#modalproducto").modal("hide");
});


function listarProductos(){
    $.ajax({
        type: "GET",
        url: "/producto/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblproducto > tbody").html("")
            $.each(resultado, function(index, value){
                $("#tblproducto > tbody").append("<tr>"+
                `<td>${value.idproducto}</td>`+
                `<td>${value.nombre}</td>`+
                `<td>${value.nomcategoria}</td>`+
                `<td>${value.precio}</td>`+
                `<td>${value.detalles}</td>`+
                `<td>${value.unidades}</td>`+
                `<td>${value.activo}</td>`+
                `<td>${value.stock}</td>`+
                `<td><button type="button" class="btn btn-info btnactualizar" `+
                ` data-prodid="${value.idproducto}" `+
                ` data-prodnom="${value.nombre}" `+
                ` data-prodcat="${value.nomcategoria}" `+
                ` data-prodprecio="${value.precio}" `+
                ` data-proddetalles="${value.detalles}" `+
                ` data-produnidades="${value.unidades}" `+
                ` data-prodactivo="${value.activo}" `+
                ` data-prodstock="${value.stock}">Actualizar</button></td></tr>`
                )
            })
        }
    })
}


function listarCatProduc(idcate){
     $.ajax({
     type:"GET",
     url:"/categoria/listar",
     dataType:"json",
     success:function(resultado){
        console.log(resultado);
         $.each(resultado,function(index,value){
             $("#cbocategoria").append(`<option value="${value.idcategoria}">${value.nomcategoria}</option>`)
         });
         if(idcate > 0)
             $("#cbocategoria").val(idcate);
         }
     });
 }