YUI({}).use("gallery-form", function (Y) {
	
    var form = new Y.Form({
        action : 'main.html',
        id:'mainForm',
        method: 'POST',
        children : [
            {name : 'formulaVal',required : true, type : "TextField", label : "Wzór z=f(x,y)"},
            {name : 'xmaxVal', type : "TextField",label : "Xmax"},
            {name : 'xminVal', type : "TextField",label : "Xmin"},
            {name : 'ymaxVal', type : "TextField", label : "Ymax"},
            {name : 'yminVal', type : "TextField", label : "Ymin"},
            {name : 'zmaxVal', type : "TextField", label : "Zmax"},
            {name : 'zminVal', type : "TextField", label : "Zmin"},
            ]
    });
 
    
    form.subscribe('success', function (args) {
        alert ('Form submission successful');
    });
    form.subscribe('failure', function (args) {
        alert('Form submission failed' + args);
    });
 
    form.render('#form_');

    
    YUI().use('button', function(Y){
        
        // A push button widget
        var button = new Y.Button({
            srcNode: '#myButton'
        });
        Y.one('#myButton').on('click',function(a){
        	var formula = form.getField('formulaVal').get('value');
        	var xmax = form.getField('xmaxVal').get('value');
        	var xmin = form.getField('xminVal').get('value');
        	var ymax = form.getField('ymaxVal').get('value');
        	var ymin = form.getField('yminVal').get('value');
        	var zmax = form.getField('zmaxVal').get('value');
        	var zmin = form.getField('zminVal').get('value');
        	
        	form.getField('xmaxVal').set('label','asdfasdfasdf');
        	
        	console.log(xmax + ' ' + xmin + ' ' + ymax + ' ' + ymin + ' ' + zmax + ' ' + zmin);
        });
        
    });
    
    
});


YUI({

}).use('gallery-aui-form-validator', function(Y) {
// Creating a basic Validator with the form below
var validator1 = new Y.FormValidator({
	boundingBox: '#fm1',
	rules: {
		xmax: {
			required: true,
		},
		xmin: {
			required: true,
		},
		ymax: {
			required: true,
		},
		ymin: {
			required: true,
		},
		zmax: {
			required: true,
		},
		zmin: {
			required: true,
		},
		email: {
			required: true,
			email: true
		},
		age: {
			required: true,
			digits: true,
			range: [18, 50]
		}
	}
});

// Listening to validation events
validator1.on('validateField', function(event) {
	var n = event.details[0].validator.field;
	var max = n.get('value');
	var field = n._node.id;
	if(field == 'xmaxfield'){
		var xmin = Y.one('#yminfiled');
		var v = xmin.get('value');
		if(v > max ){
			return false;
		}
	}
	console.log(event);
});
validator1.on('validField', function(event) {
	// Fires when a field contains valid data
	
});

validator1.on('submit', function(){
	console.log('11111');
});

validator1.on('errorField', function(event) {
	// Fires when a field contains invalid data
});

//Y.one('#subbtn').on('click',function(e){
//	console.log('sub');
//	var xmax = form.getField('xmaxVal').get('value');
//	var xmin = form.getField('xminVal').get('value');
//	var ymax = form.getField('ymaxVal').get('value');
//	var ymin = form.getField('yminVal').get('value');
//	var zmax = form.getField('zmaxVal').get('value');
//	var zmin = form.getField('zminVal').get('value');
//})

});