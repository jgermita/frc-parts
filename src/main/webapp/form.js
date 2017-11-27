/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var $form = $('form#makeawish'),
    url = 'https://script.google.com/macros/s/AKfycbykKxvTLMlCoWAqPDhGnXjQx_APctltCPP795pYQ0FqUdxBwM4/exec';

$('#submit-form').on('click', function(e) {
  e.preventDefault();
  var jqxhr = $.ajax({
    url: url,
    method: "GET",
    dataType: "json",
    data: $form.serializeObject()
  }).success(
    // do something
  );
});