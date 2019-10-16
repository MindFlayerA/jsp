<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
  
</head>
<body>

<nav class="navbar navbar-inverted">
	<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="https://www.codeSeeker.com">CodeSeeker</a>
			</div>
			<ul class="nav navbar-nav">
			
			<li class="active"><a href="index.jsp">Home</a></li>
			<li><a href="login.jsp">Login</a></li>
      		<li><a href="display.jsp">Display</a></li>
      		</ul>
      		</div>
      		</nav>
      		
     <div class="container">
	<form action="save.jsp" method="post">
	<h2>Please login here</h2>
	
	<div class="input-group">
	
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
      
    </div>
		
	<div class="input-group">
	
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
    <a href="register.html">Signup</a>
    
		
	
	</form>
</div>

</body>
</html>