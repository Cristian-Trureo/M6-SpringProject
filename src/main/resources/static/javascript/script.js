// PARA ALERTA PERSONALIZADA AL ELIMINAR
function confirmarEliminacion(form) {
    var nombre = form.getAttribute('data-nombre');
    Swal.fire({
        title: 'Confirmación',
        text: '¿Estás seguro de que deseas eliminar a ' + nombre + '?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Sí, eliminar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            form.submit();
        }
    });
    return false;
}
