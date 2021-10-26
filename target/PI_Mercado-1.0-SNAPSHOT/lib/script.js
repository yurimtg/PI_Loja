//---------------------Mostar opções de cadastro/Lista--------------------------
$(document).ready(function () {

    $("#divCadastro").click(function () {
        $("#dropCadastro").toggle();

         var src = ($("#imgShow").attr('src') === '../img/add.png')
            ? '../img/minus.png'
            : '../img/add.png';
         $("#imgShow").attr('src', src);
    
    });
    
     $("#divLista").click(function () {
        $("#dropLista").toggle();

         var src = ($("#imgShow1").attr('src') === '../img/add.png')
            ? '../img/minus.png'
            : '../img/add.png';
         $("#imgShow1").attr('src', src);
    
    });
   
});
//------------------------------------------------------------------------------        



