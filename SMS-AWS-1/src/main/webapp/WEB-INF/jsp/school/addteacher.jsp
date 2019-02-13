<%@ include file="schoolheader.jsp"%>

<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Teacher</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddTeacher" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-12 col-md-12">
									<input type="text" class="form-control mb-2"
										placeholder="Teacher Name" name="teacherName" required
										autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<select class="form-control mb-2" required autofocus
										name="gender">
										<option selected disabled="disabled">Select Gender</option>
										<option value="Male">Male</option>
										<option value="Female">Female</option>
									</select>

								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Date Of Birth" name="dateOfBirth" required autofocus
										onfocus="(this.type='date')">

								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										placeholder="Address Line 1" name="addressLine1"></textarea>
								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										placeholder="Address Line 2" name="addressLine2"></textarea>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2" placeholder="City"
										name="city" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="District" name="district" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="State" name="state" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Pincode" name="pinCode" required autofocus>

								</div>
								<div class="col-sm-6 col-md-6">
									<input type="email" class="form-control mb-2"
										placeholder="Email Id" name="emailId" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Mobile Number" name="mobileNumber" required
										autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<button class="btn btn-lg btn-info btn-block mb-1 mt-1"
										type="submit">Add Teacher</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>



<%@ include file="schoolfooter.jsp"%>

