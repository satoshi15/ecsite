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
	<title>itemCreateConfirm画面</title>

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

</head>
<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>商品登録確認</p>
		</div>

		<div>
			<table>
				<s:form action="ItemCreateCompleteAction">
					<h3>商品情報は以下でよろしいですか</h3>
					<tr>
						<td>
							<span>商品名</span>
							<s:property value="#session.itemName" escape="false"/>
						</td>
					</tr>
					<tr>
						<td>
							<span>値段</span>
							<s:property value="#session.itemPrice" escape="false"/>
							<span>円</span>
						</td>
					</tr>
					<tr>
						<td>
							<span>在庫</span>
							<s:property value="#session.itemStock" escape="false"/>
							<span>個</span>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="登録"/>
						</td>
					</tr>

				</s:form>
			</table>
		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>