<%@ include file="schoolheader.jsp"%>

<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Admission Enquiry Form</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddAdmission" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2" placeholder="Date"
										name="date" required autofocus onfocus="(this.type='date')">
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Academic Session" name="academicSession" required
										autofocus>

								</div>
								<div class="col-sm-12 col-md-12">
									<input type="text" class="form-control mb-2"
										placeholder="Student Name" name="studentName" required
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
										placeholder="Date Of Birth" name="studentDOB" required
										autofocus onfocus="(this.type='date')">

								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Class To Which Admission Is Sought"
										name="classToAdmission" required autofocus>

								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Previous Class Passed" name="previousClassPassed"
										required autofocus>

								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Year Of Passing" name="yearOfPassing" required
										autofocus>

								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Medium" name="medium" required autofocus>

								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Previous School" name="previousSchool" required
										autofocus>

								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Previous Board" name="previousBoard" required
										autofocus>

								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Marks Obtained" name="marksObtained" required
										autofocus>

								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										placeholder="Achievement" name="achievement"></textarea>
								</div>
								<div class="col-sm-6 col-md-6" id="hidden_fields">
									<input type="text" class="form-control mb-2"
										placeholder="Father's Name" name="fathersName" autofocus>
								</div>
								<div class="col-sm-6 col-md-6" id="hidden_fields2">
									<input type="text" class="form-control mb-2"
										placeholder="Mother's Name" name="mothersName" autofocus>
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
									<button class="btn btn-lg btn-info btn-block mb-1 mt-1"
										type="submit">Submit</button>
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
