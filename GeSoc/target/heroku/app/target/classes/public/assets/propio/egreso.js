/*! jQuery v3.5.1 | (c) JS Foundation and other contributors | jquery.org/license */

$(function() {

  var checkbox = $("/egresorequierePresupuesto");
  var hidden = $("/egresocantPresupuestosRequeridos");

  hidden.hide();

  checkbox.change(function() {

    if (checkbox.is(':checked')) {
      hidden.show();
    } else {
      hidden.hide();
    }
  });
});