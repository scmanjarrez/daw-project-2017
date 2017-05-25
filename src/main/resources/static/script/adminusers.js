/**
 * Created by S on 24/05/2017.
 */
$('.alert').delay(5000).fadeOut();
showAdd();
if (window.location.search === '?add'){
    showAdd();
}
if (window.location.search === '?mod'){
    showModify();
}
if (window.location.search === '?del'){
    showDelete();
}

function showAdd() {
    $('button#b_add').addClass("active");
    $('button#b_mod').removeClass("active");
    $('button#b_del').removeClass("active");
    $('div#addUser').show()
    $('div#modifyUser').hide();
    $('div#deleteUser').hide();
}
function showModify() {
    $('button#b_add').removeClass("active");
    $('button#b_mod').addClass("active");
    $('button#b_del').removeClass("active");
    $('div#addUser').hide();
    $('div#modifyUser').show();
    $('div#deleteUser').hide();
}
function showDelete() {
    $('button#b_add').removeClass("active");
    $('button#b_mod').removeClass("active");
    $('button#b_del').addClass("active");
    $('div#addUser').hide()
    $('div#modifyUser').hide();
    $('div#deleteUser').show();
}

$('#deleteUser').submit(function() {
    var c = confirm("¿Estás seguro de querer continuar?");
    return c;
});

