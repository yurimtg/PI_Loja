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
  function ValidateField(field) {
    // logica para verificar se existem erros
    function verifyErrors() {
        let foundError = false;

        for(let error in field.validity) {
            // se não for customError
            // então verifica se tem erro
            if (field.validity[error] && !field.validity.valid ) {
                foundError = error
            }
        }
        return foundError;
    }
    function customMessage(typeError) {
        const messages = {
            text: {
                valueMissing: "Por favor, preencha este campo"
            },
            email: {
                valueMissing: "Email é obrigatório",
                typeMismatch: "Por favor, preencha um email válido"
            }
        }

        return messages[field.type][typeError]
    }

}
function is_cpf (cpf) {

  if((cpf = cpf.replace(/[^\d]/g,"")).length != 11)
    return false

 if (cpf.length != 11 ||
cpf == "00000000000" ||
cpf == "11111111111" ||
cpf == "22222222222" ||
cpf == "33333333333" ||
cpf == "44444444444" ||
cpf == "55555555555" ||
cpf == "66666666666" ||
cpf == "77777777777" ||
cpf == "88888888888" ||
cpf == "99999999999")
return false;


  var r;
  var s = 0;

  for (i=1; i<=9; i++)
    s = s + parseInt(cpf[i-1]) * (11 - i);

  r = (s * 10) % 11;

  if ((r == 10) || (r == 11))
    r = 0;

  if (r != parseInt(c[9]))
    return false;

  s = 0;

  for (i = 1; i <= 10; i++)
    s = s + parseInt(cpf[i-1]) * (12 - i);

  r = (s * 10) % 11;

  if ((r == 10) || (r == 11))
    r = 0;

  if (r != parseInt(cpf[10]))
    return false;

  return true;
}


function fMasc(objeto,mascara) {
obj=objeto
masc=mascara
setTimeout("fMascEx()",1)
}

  function fMascEx() {
obj.value=masc(obj.value)
}

function mCPF(cpf){
cpf=cpf.replace(/\D/g,"")
cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
cpf=cpf.replace(/(\d{3})(\d{1,2})$/,"$1-$2")
return cpf
}

cpfCheck = function (cpf) {
    document.getElementById('cpfResponse').innerHTML = is_cpf(cpf.value)? '<span style="color:green">CPF válido</span>' : '<span style="color:red">CPF inválido</span>';
    if(cpf.value=='') document.getElementById('cpfResponse').innerHTML = '';
}
   


