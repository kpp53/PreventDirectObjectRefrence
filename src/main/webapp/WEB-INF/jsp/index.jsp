<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>AES Example</title>
</head>
<body>
<form action="aes" method="post">
<input type="hidden" id="uname" name="uname">
<input type="hidden" id="pwd" name="pwd">
<input type="hidden" id="iv" name="iv">
<input type="hidden" id="salt" name="salt">
<h1>Multiplication Test</h1>
<div>
<input id="userName" placeholder="Quantity" type="text"></input>
</div>
<div>
<input id="password" type="password" placeholder="Price"/>
</div>
<div>
<input type="submit" id="btn" value="Calulate">
</div>
</form>
<c:if test="${Total ne ''}">
   <div id="result">${Total}</div>
</c:if>

<script type="text/javascript" src="js/lib/excluded/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/lib/aes.js"></script>
<script type="text/javascript" src="js/lib/pbkdf2.js"></script>
<script type="text/javascript" src="js/lib/common.js"></script>
<script type="text/javascript" src="js/AesUtil.js"></script>
<script type="text/javascript">
$(function(){
  $('#btn').click(function() {
    var userName = $('#userName').val();
    var password = $('#password').val();
    
    var encryptUserName=encryptString (userName);
    var encryptPassword=encryptString (password);
    
    $('#uname').val(encryptUserName);
    $('#pwd').val(encryptPassword);
    
   /*  $.post('/aes', {
    	uname: encryptString ($("#userName").val()),
        pwd: encryptString ($("#password").val())
      }, function(data) {
         alert('Plaintext: ' + data);
      }); */
  });
});
</script>
</body>
</html>