<%@ include file = "adminheader.jsp" %>
	
	
	
	
	<br>
	<br>
	<br>
	<div class="container pt-3">
		<div class="row justify-content-sm-center">
			<div class="col-sm-6 col-md-5">

				<div class="card border-info text-center">
					<div class="card-header bg-info text-white">
						<span class="form-Heading">Add School</span>
					</div>
					<div class="card-body">
						<form class="form-signin" action="WebAddSchool" method="post">
							<div class="container-fluid">
								<div class="row">
									<div class="col-sm-12 col-md-12">
										<input type="text" class="form-control mb-2"
											placeholder="School Name" name="schoolName" required
											autofocus>
									</div>
									<div class="col-sm-12 col-md-12">
										<input type="email" class="form-control mb-2"
											placeholder="Email Id" name="emailId"  required
											autofocus>
									</div>
									<div class="col-sm-12 col-md-12">
										<input type="text" class="form-control mb-2"
											placeholder="Mobile Number" name="mobileNumber" required
											autofocus>
									</div>
									<div class="col-sm-12 col-md-12">
										<button class="btn btn-lg btn-info btn-block mb-1" type="submit">Add School</button>
									</div>
								</div>
							</div>
						<a href="#" class="float-right">Need help?</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>

<%@ include file = "adminfooter.jsp" %>
	
