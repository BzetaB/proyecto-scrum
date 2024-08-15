// licoreria.js
function listarProductos() {
    $.ajax({
        type: "GET",
        url: "/producto/listar",
        dataType: "json",
        success: function (resultado) {
                // Limpiar contenedores
            $("#todosContainer, #ronesContainer, #espumantesContainer, #whiskiesContainer, #vodkasContainer, #vinosContainer, #piscosContainer, #tequilasContainer").html("");

            $.each(resultado, function (index, value) {
                const cardHtml = `
                    <div class="card m-2" style="width: 18rem;">
                        <img src="/images/${value.codproducto}.jpg" class="card-img-top" alt="${value.nombreprod}">
                        <div class="card-body">
                             <h5 class="card-title">${value.nombreprod}</h5>
                             <p class="card-text">Precio: ${value.precioprod} USD</p>
                             <p class="card-text">Código: ${value.codproducto}</p>
                             <button class="btn btn-primary agregarCarrito" data-id="${value.codproducto}">Agregar al Carrito</button>
                        </div>
                    </div>
                `;

                // Añadir tarjeta al contenedor adecuado
                $(`#${value.nombrecategoria.toLowerCase()}Container`).append(cardHtml);
                $("#todosContainer").append(cardHtml); // Agregar a la sección "Todos"
            });

            // Manejar clic en el botón de agregar al carrito
            $(".agregarCarrito").click(function() {
                var productoId = $(this).data("id");
                $.ajax({
                        type: "POST",
                        url: "/carrito/agregar",
                        data: { idProducto: productoId },
                        success: function(response) {
                            alert("Producto agregado al carrito");
                        },
                        error: function(xhr, status, error) {
                            alert("Error al agregar producto al carrito. Intenta de nuevo.");
                            console.error("Error:", error);
                        }
                });
            });

        },
        error: function(xhr, status, error) {
            console.error("Error al listar productos:", error);
        }
    });
}

$(document).ready(function () {
        listarProductos();
        setInterval(listarProductos, 10000);
});