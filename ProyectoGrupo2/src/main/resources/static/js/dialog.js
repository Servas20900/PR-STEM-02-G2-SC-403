const baseUrl = '/admin';
const modulosDeleteUrlMapper = {
    'clases': `${baseUrl}/clases/eliminar`,
    'productos': `${baseUrl}/productos/eliminar`,
    'blogs': `${baseUrl}/blogs/eliminar`,
}

let dialogDelete = document.getElementById('dialogEliminar');
let openDialogBtn = document.querySelectorAll('.openDialogBtn');
let confirmDeleteBtn = document.getElementById('eliminarItemBtn');

openDialogBtn.forEach(btn => {
    btn.addEventListener('click', e => {
        e.preventDefault();
        dialogDelete.showModal();
        let url = `${modulosDeleteUrlMapper[btn.dataset.modulo]}/${btn.dataset.id}`;

        confirmDeleteBtn.setAttribute('href', url);
    })
})
