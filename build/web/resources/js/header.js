$(document).ready(function (){
     
   var favicon = document.querySelector('link[rel="shortcut icon"]');
    
  
        favicon = document.createElement('link');
        favicon.setAttribute('rel', 'shortcut icon');
        var head = document.querySelector('head');
        head.appendChild(favicon);
    
    
    
    favicon.setAttribute('type', 'image/png');
    favicon.setAttribute('href', "resources/img/bb-logo.png");
   
   
   
});


function  saltarConta(param){
    var parametro = param;
    
    if(parametro.length===3){
        
        $("#txtConta").focus();
    }
    
    
   
    
   
    
}
function  formataConta(param){
        var valor = param;
        var num;
        var numero = "";
        var i;
        for(i=0;i<valor.length;i++){
           num = valor.substring(i,i+1);
         
         
         if(num === "0" || num === "1"||num === "2" ||num === "3" ||num === "4" ||num === "5" ||num === "6" ||num === "7" ||num === "8" ||num === "9"){
             
          numero = numero + num;
        }
        
        if(i === valor.length - 6 || i === valor.length - 10 || i === valor.length - 14 || i === valor.length - 17){
          numero = numero + "." ;
        }
        
         
         if(i === valor.length - 2){
           numero = numero + "-";
         }
        
       
          
            
        }
       
        
       
       
        $("#txtConta").val((numero));
        
        
}


 function informarValorAcima(param){
         var parametro = param;
         
         
     
   swal(parametro);
        
        
    }