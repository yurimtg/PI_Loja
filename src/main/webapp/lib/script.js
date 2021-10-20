//---------------------Mostar opções de cadastro/Lista--------------------------
$(document).ready(function () {

    $("#divCadastro").mouseenter(function () {
        $("#dropCadastro").first().fadeIn("slow", "linear");
    });
    
     $("#divLista").mouseenter(function () {
        $("#dropLista").first().fadeIn("slow", "linear");
    });
    
    $("#divCadastro").mouseleave(function () {
        $("#dropCadastro").first().fadeOut()("slow", "linear");
    });
    
     $("#divLista").mouseleave(function () {
        $("#dropLista").first().fadeOut("slow", "linear");
    });


});
//------------------------------------------------------------------------------        



