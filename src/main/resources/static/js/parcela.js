
$(document).ready( function () {
    
	
	   var contador = 1;
       
       //Adiciona um novo item na tabela
          function adiciona(){

          var vid = $('#codigo').val();
              var vdescricao = $('#produto').val();
                
                 $('#produtosAdicionados').append('<tr><td><input type="text" name="produto['+ contador +'].id" id="produto['+ contador +'].id" value="' + vid +'"></td>'+
                   '<td><input type=text name="produto['+contador+'].descricao" id="produto['+contador+'].descricao" value="'+vdescricao+'"></td>'+
                   '<td><input type="button" value="Deletar" onclick="javascript:removeLinha(this)"></td></tr>');
                 contador++;
          }

          //Remove o item da tabela
    function removeLinha(row) {
          $(row).parent().parent().remove();
    }
} );