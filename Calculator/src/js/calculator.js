YUI({}).use("gallery-form", function (Y) {
    var form = new Y.Form({
        boundingBox: '#form',
        action : 'test.php',
        method : 'post',
        children : [
//            {name : "formLabel", label : "Wzór z=f(x,y)"},
            {name : 'formulaVal',required : true, type : "TextField", label : "Wzór z=f(x,y)"},
            {name : 'xmaxVal',required : true, type : "TextField",label : "Xmax"},
            {name : 'xminVal',required : true, type : "TextField",label : "Xmin"},
            {name : 'ymaxVal',required : true, type : "TextField", label : "Ymax"},
            {name : 'yminVal',required : true, type : "TextField", label : "Ymin"},
            {name : 'zmaxVal',required : true, type : "TextField", label : "Zmax"},
            {name : 'zminVal',required : true, type : "TextField", label : "Zmin"},
            {name : 'submitBtn', type : 'SubmitButton', value : 'Oblicz'},
//            {name : 'resetBtn', type : 'ResetButton', value : 'Wyczyść formularz'}
        ]
    });
 
    form.subscribe('success', function (args) {
        alert ('Form submission successful');
    });
    form.subscribe('failure', function (args) {
        alert('Form submission failed');
    });
 
    f = form;
    form.render('div[name="form"]');
});

var f;