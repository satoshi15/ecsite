<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<title>admin画面</title>

	<style type="text/css">
		body{
			margin:0;
			padding:0;
			letter-apacing:1px;
			font-family:Verdana,Helvetica,sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
		}

		table{
			text-align:center;
			margin:0 auto;
		}

		#top{
			width:780px;
			margin:30px auto;
			border:1px solid #333;
		}

		#header{
			width:100%;
			height:80px;
			background-color:black;
		}

		#main{
			width:100%;
			height:500px;
			text-align:center;
		}

		#footer{
			width:100%;
			height:80px;
			background-color:black;
			clear:both;
		}
	</style>

<title>admin画面</title>
</head>
<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>管理者画面</p>
		</div>
		<div>

			<span>商品</span>
			<s:form action="ItemCreateAction">
				<s:submit value="新規登録"/>
			</s:form>
			<s:form action="ItemListAction">
				<s:submit value="一覧"/>
			</s:form>

			<span>ユーザー</span>
			<s:form action="UserCreateAction">
				<s:submit value="新規登録"/>
			</s:form>
			<s:form action="UserListAction">
				<s:submit value="一覧"/>
			</s:form>

			<p>ホーム画面に戻る場合は
				<a href="<s:url action='GoHomeAction'/>">こちら</a>
			</p>

		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>