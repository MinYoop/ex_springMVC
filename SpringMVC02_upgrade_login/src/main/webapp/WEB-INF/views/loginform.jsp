<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

   $(function(){
   $("#loginchk").hide();
   });
   
   function login(){
      var idVal = $("#id").val();
      var pwVal = $("#pw").val();
      
      if(idVal==null || idVal==""){
         alert("ID를 확인해 주세요 !")
      }else if(pwVal==null||pwVal==""){
         alert("PW를 확인해 주세요 !")
      }else{
         $("#loginchk").show();
         
         $.ajax({
            type:"post",
            url:"loginajax.do",
            data:"id="+idVal+"&pw="+pwVal,
            success:function(msg){
               if(msg.lc==true){
                  location.href="list.do";
               }else{
                  document.getElementById("loginchk").innerHTML="ID/PW를 확인해 주세요.";
               }
            },
            error:function(){
               alert("로그인 실패");
            }
         });
      }
   }
</script>
</head>
<body>

   <table>
      
      <tr>
         <td>ID</td>
         <td><input type="text" id="id"></td>
      </tr>
      
      <tr>
         <td>PW</td>
         <td><input type="password" id="pw"></td>
      </tr>
      
      <tr>
         <td colspan="2">
         <input type="button" value="로그인" onclick="login();"></td>
      </tr>

      <tr >
         <td colspan="2" id="loginchk">
         </td>
      </tr>
   </table>
</body>
</html>