<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Admins</h1>
				<p>All the available admins in our store</p>
			</div>
		</div>
	</section>
	
	<a href='<c:url value="/welcome"/>'>Welcome Page</a>
	<section class="container">
		<div class="row">
			<c:forEach items="${admins}" var="admin">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${admin.id}</h3>
							<p>${admin.nombre}</p>
							<p>${admin.cargo}</p>
							<p>${admin.fechaCreacion}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
