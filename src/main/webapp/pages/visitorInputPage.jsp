<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:include page="/header"/>
<section style="padding:10px;min-height:400px;">
	
	<h3>Visitor Registration</h3>
	<form method="post">
		<label>Name:
			<input type="text" name="firstName" placeholder="first Name" required/>
			<input type="text" name="lastName" placeholder="last Name" required/>
		</label>
		<br/>
		<label>Date Of Birth:
			<input type="date" name="dateOfBirth"  required/>
		</label>
		<br/>
		<button>Register</button>
	</form>
</section>
<jsp:include page="/footer"/>