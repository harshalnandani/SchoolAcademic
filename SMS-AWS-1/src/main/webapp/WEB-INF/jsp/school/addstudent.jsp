<%@ include file="schoolheader.jsp"%>

<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Student</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddStudent" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-6 col-md-6">
									<select class="form-control mb-2 company1" required autofocus
										name="classId" onchange="user1_change()">
										<option selected disabled="disabled">Select Class</option>
										<c:forEach var="class1" items="${classes}" varStatus="counter">
											<option value="${class1.getClassId()}">${class1.getClassName()}</option>
										</c:forEach>
									</select>

								</div>
								<div class="col-sm-6 col-md-6">
									<select class="form-control mb-2 company11" name="sectionId"
										required autofocus>
										<option selected="selected" disabled="disabled">Select
											Section</option>
									</select>

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
								<div class="col-sm-12 col-md-12">
									<label>Parent Already Registered? </label> <input
										type="checkbox" id="trigger" name="question" 
										autofocus>
								</div>

								<div class="col-sm-6 col-md-6" id="hidden_fields">
									<input type="text" class="form-control mb-2"
										placeholder="Father's Name" name="fathersName" 
										autofocus>
								</div>
								<div class="col-sm-6 col-md-6" id="hidden_fields2">
									<input type="text" class="form-control mb-2"
										placeholder="Mother's Name" name="mothersName" 
										autofocus>
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
										type="submit">Add Student</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<br>
<br>
<br>

<%@ include file="schoolfooter.jsp"%>

<script>
	function user1_change() {
		var user1 = $(".company1").val();

		$.ajax({
			type : "Get",
			url : "WebGetSection",
			data : "user_id=" + user1,
			cache : false,
			success : function(response) {
				$(".company11").html(response);
			}
		});
	}

	$(document).ready(function() {
		var checkbox = $("#trigger");
		var hidden = $("#hidden_fields");
		var hidden2 = $("#hidden_fields2");
		hidden.show();
		hidden2.show();
		checkbox.change(function() {
			if (checkbox.is(':checked')) {
				// Show the hidden fields.
				hidden.hide();
				hidden2.hide();
			} else {
				hidden.show();
				hidden2.show();
			}
		});

	});
</script>