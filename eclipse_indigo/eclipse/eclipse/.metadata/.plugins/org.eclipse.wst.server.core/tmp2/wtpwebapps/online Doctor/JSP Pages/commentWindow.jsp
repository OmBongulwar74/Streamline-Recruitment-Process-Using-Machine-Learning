<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <title>Message Embed Page</title>
        
        <!-- The stylesheet -->
        <link rel="stylesheet" href="../css/commentwindow.css" />
        
        <style>

        h1{
            text-align:center;
            margin-top:160px;
            font-weight:normal;
        }

        #close{
            display:block;
            width:100px;
            margin:20px auto;
            text-align:center;
        }

        #msgbox{
            font:inherit;
            font-size:14px;
            padding:7px 12px;
            border-radius:3px;
            margin-right:3px;
            border:1px solid #bbb;
        }

        #sendmsg{
            font-size:14px;
        }

        .center{
            padding:30px 0 18px 0;
            text-align: center;
        }
        </style>

        <!--[if lt IE 9]>
          <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>
    
    <body class="framePage">

        <h1>Please write your comment</h1>

        <div class="center">
            <input type="text" id="msgbox" placeholder="Enter your comment here" />
            <a class="button1" id="sendmsg" onclick="sendComment();frameWarp.hide();">Send</a>
        </div>
<p id="path" style="visibility: hidden;" ><%=request.getContextPath()%></p>
        <a href="#" class="button2" id="close" onclick="frameWarp.hide();">Close Window</a>
        
        <script>
function sendComment()
{
	var path=document.getElementById('path').innerHTML;
	alert(path);
	 window.location.href=path+"/BussinessController?button=comment&value="+msgbox.value;
	 
	}
            // Using plain javascript to listen for clicks on the send button. You can use jQuery as well.

            var msgbox = document.getElementById('msgbox');

            document.getElementById('sendmsg').addEventListener('click',function(){
            	
                frameWarp.sendMessage(msgbox.value);

                // Emptying the msgbox
                msgbox.value = '';
               
                return false;
            },false);
           

        </script>

    </body>
</html>