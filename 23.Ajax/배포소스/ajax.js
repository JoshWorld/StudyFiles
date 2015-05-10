/**
 * Ajax 비동기 데이터통신 
 */
function ajax(args){
	var method = args.method ? args.method.toUpperCase() : "GET";
	var url = args.url;
	var data =  args.data; // name=value
	var funct = args.funct;
	
	if(method == "GET"){
		if(data){
			url += ("?" + data);
		}
	}
	
	var xhr = getXMLHttpRequest();
	xhr.open(method, url, true);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				funct(xhr);
			}else{
				alert(xhr.statusText);				
			}
		}
	};
	
	if(method=="GET"){
		xhr.send();
	}else{
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send(data);
	}
}

function getXMLHttpRequest(){
	var xhr = null;
	try{
		if(window.ActiveXObject){
			xhr = new ActiveXObject("Msxml2.XMLHTTP");
		}else{ 
			xhr = new XMLHttpRequest();
		}
	}catch(ex){}
	return xhr;
}