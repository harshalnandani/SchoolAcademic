<%@ include file="schoolheader.jsp"%>
<c:set var="student" value="${editstudent}" scope="page" />
<c:set var="parent" value="${student.getParent()}" scope="page" />
<c:if test="${student==null}">
	<c:redirect url="/schoolhome" />
</c:if>
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Edit Student</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="/WebEditStudent" method="post">
					<input type="hidden" name="studentId" value="${student.getStudentId()}">
    				<input type="hidden" name="actionId" value="1"> 
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-12 col-md-12">
									<input type="text" class="form-control mb-2"
										value="${student.getStudentName()}" name="studentName" required
										autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<select class="form-control mb-2" required autofocus
										name="gender">
										<c:if test="${student.getGender().equals('Male')}">
										<option value="Male" selected="selected">Male</option>
										<option value="Female">Female</option>
										</c:if>
										<c:if test="${student.getGender().equals('Female')}">
										<option value="Male" >Male</option>
										<option value="Female" selected="selected">Female</option>
										</c:if>
									</select>

								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										value="${student.getDateOfBirth()}" name="dateOfBirth" required
										autofocus onfocus="(this.type='date')">

								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										 name="addressLine1">${student.getAddressLine1()}</textarea>
								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										placeholder="Address Line 2" name="addressLine2">${student.getAddressLine2()}</textarea>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2" value="${student.getCity()}"
										name="city" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										value="${student.getDistrict()}" name="district" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										value="${student.getState()}" name="state" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										value="${student.getPinCode()}" name="pinCode" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<button class="btn btn-lg btn-info btn-block mb-1 mt-1"
										type="submit">Edit Student</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>

			<br>

			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Edit Parent</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="/WebEditParent" method="post">
					<input type="hidden" name="studentId" value="${student.getStudentId()}">
     				<input type="hidden" name="parentId" value="${parent.getParentId()}">
     				<input type="hidden" name="actionId" value="1"> 
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-6 col-md-6" id="hidden_fields">
									<input type="text" class="form-control mb-2"
										value="${parent.getFathersName()}" name="fathersName" autofocus>
								</div>
								<div class="col-sm-6 col-md-6" id="hidden_fields2">
									<input type="text" class="form-control mb-2"
										value="${parent.getMothersName()}" name="mothersName" autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<button class="btn btn-lg btn-info btn-block mb-1 mt-1"
										type="submit">Edit Parent</button>
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
			type : "POST",
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