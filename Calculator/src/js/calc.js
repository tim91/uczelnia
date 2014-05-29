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
	 
	 
	form.render('#form_');
	
    YUI().use('button', function(Y){
        
        // A push button widget
        var button = new Y.Button({
            srcNode: '#myButton'
        });
        Y.one('#myButton').on('click',function(a){
        	var formula = form.getField('formulaVal').get('value');
        	
        	var resp = validate(formula);
        	
        	if(formula == null || formula.length == 0){
        		alert('Nie podano wzoru');
        		return;
        	}
        	
        	if(resp != true){
        		alert('Podany wzór jest niepoprawny');
        		return;
        	}
        	
        		var xmax = parseInt(form.getField('xmaxVal').get('value'));
        		if(isNaN(xmax)){
        			alert('Wartość Xmax nie jest poprawna');
        			return;
        		}
            	var xmin = parseInt(form.getField('xminVal').get('value'));
            	if(isNaN(xmin)){
        			alert('Wartość Xmin nie jest poprawna');
        			return;
        		}
            	var ymax = parseInt(form.getField('ymaxVal').get('value'));
            	if(isNaN(ymax)){
        			alert('Wartość Ymax nie jest poprawna');
        			return;
        		}
            	var ymin = parseInt(form.getField('yminVal').get('value'));
            	if(isNaN(ymin)){
        			alert('Wartość Ymin nie jest poprawna');
        			return;
        		}
            	var zmax = parseInt(form.getField('zmaxVal').get('value'));
            	if(isNaN(zmax)){
        			alert('Wartość Zmax nie jest poprawna');
        			return;
        		}
            	var zmin = parseInt(form.getField('zminVal').get('value'));
            	if(isNaN(zmin)){
        			alert('Wartość Zmin nie jest poprawna');
        			return;
        		}
        	
        	
        	console.log(xmax + ' ' + xmin + ' ' + ymax + ' ' + ymin + ' ' + zmax + ' ' + zmin );
        	
        	if(xmax < xmin){
        		alert('Wartosc Xmax : ' + xmax + ' jest mniejsza od Xmin: ' + xmin);
        		return;
        	}
        	
        	if(ymax < ymin){
        		alert('Wartosc Ymax : ' + ymax + ' jest mniejsza od Ymin: ' + ymin);
        		return;
        	}
        	
        	if(zmax < zmin){
        		alert('Wartosc Zmax : ' + zmax + ' jest mniejsza od Zmin: ' + zmin);
        		return;
        	}
        	
        	var params = [xmax,xmin,ymax,ymin,zmax,zmin];
        	
        	drawPlot(formula,params);
        	
        });
        
    });
    
});


function validate(formula){
	
	for(var i=0;i<allowedWords.length;i++){
		var w = allowedWords[i];
		console.log("znak: " + w);
		formula = formula.replace(w,'');
		console.log(formula);
	}
	if(formula.length == 0)
		return true;
	
	return false;
	
}

var allowedWords = [new RegExp(/sin/g),
                    new RegExp(/cos/g),
                    new RegExp(/x/g),
                    new RegExp(/y/g),
                    new RegExp(/\(/g),
                    new RegExp(/\)/g),
                    new RegExp(/\+/g),
                    new RegExp(/-/g),
                    new RegExp(/\*/g),
                    new RegExp(/\//g),
                    new RegExp(/\ /g),
                    new RegExp(/sqrt/g),
                    new RegExp(/\d/g)
                   ];

function drawPlot(formula,params){
	var canvas = document.getElementById('canvas');
	var ctx = canvas.getContext('2d');
	var middlePoint = point(canvas.width/2,canvas.height/2,0);
	draw(ctx,formula,middlePoint,params);
};

function initCanvas(){
	
	return ctx;
};

function point(x, y, z)
{       
  return [x, y, z]; // Return a 3 x 1 vector representing a traditional (x, y, z) surface point. This vector form eases matrix multiplication.
}


function draw(context,formula,middlePoint,params){
	
	var middleX = middlePoint[0];
	var middleY = middlePoint[1];
	
	console.log('Wzor: ' + formula);
	context.clearRect(0, 0, canvas.width, canvas.height);
    
    context.beginPath();
    context.strokeStyle = "green";
    context.moveTo(middleX, 1);
    context.lineTo(middleX, middleY);
    context.lineWidth = 2;
    context.stroke();

    context.beginPath();
    context.moveTo(middleX, middleY);
    context.lineTo(middleX-200, middleY+200);
    context.lineWidth = 2;
    context.stroke();

    context.beginPath();
    context.moveTo(middleX, middleY);
    context.lineTo(middleX+200, middleY+200);
    context.lineWidth = 2;
    context.stroke();
    
    var xmax = params[0];
    var xmin = params[1];
    var ymax = params[2];
    var ymin = params[3];
    var zmax = params[4];
    var zmin = params[5];
    
    wzorF = formula;
    var sin = Math.sin;
    var cos = Math.cos;
    var sqrt = Math.sqrt;
            
            
    for(var x=xmin;x<xmax;x+=10){
        context.beginPath();            
        context.strokeStyle = "#000";
        context.lineWidth = 1;
        for(var y=ymin;y<ymax;y+=1)
        {          
            var z = 0;
            try{
                z = eval(wzorF);
            } catch (e) {
                alert(e.message);
                return false;
            }
			
			if(z >= zmin && z <= zmax){
				var g1=middleX-x+y;
				var g2=middleY+x+y-z;
				context.lineTo(g1, g2);
			}
            
        }
        context.stroke();
    }
    
    for(var y=ymin;y<ymax;y+=10){
        context.beginPath();            
        context.strokeStyle = "#000";
        context.lineWidth = 1;
        for(var x=xmin;x<xmax;x+=1)
        {                      
            try{
                z = eval(wzorF);
            } catch (e) {
                alert(e.message);
                return false;
            }
			if(z >= zmin && z <= zmax){
				var g1=middleX-x+y;
				var g2=middleY+x+y-z;
				context.lineTo(g1, g2);
			}
        }
        context.stroke();
    }
};