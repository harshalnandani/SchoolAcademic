<%@ include file="teacherheader.jsp"%>
<c:set var="teacher" value="${teacher}" scope="page" />

<c:if test="${teacher==null}">
	<c:redirect url="/teacherhome" />
</c:if>
<div class="container-fluid">

	<div class="row">

		<%@ include file="teachersidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Edit Teacher</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebEditTeacherProfile" method="post">
					<input type="hidden" name="teacherId" value="${teacher.getTeacherId()}">
    				<input type="hidden" name="actionId" value="1"> 
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-12 col-md-12">
									<input type="text" class="form-control mb-2"
										value="${teacher.getTeacherName()}" name="teacherName" required
										autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<select class="form-control mb-2" required autofocus
										name="gender">
										<c:if test="${teacher.getGender().equals('Male')}">
										<option value="Male" selected="selected">Male</option>
										<option value="Female">Female</option>
										</c:if>
										<c:if test="${teacher.getGender().equals('Female')}">
										<option value="Male" >Male</option>
										<option value="Female" selected="selected">Female</option>
										</c:if>
									</select>

								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										value="${teacher.getDateOfBirth()}" name="dateOfBirth" required
										autofocus onfocus="(this.type='date')">

								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										 name="addressLine1">${teacher.getAddressLine1()}</textarea>
								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										placeholder="Address Line 2" name="addressLine2">${teacher.getAddressLine2()}</textarea>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2" value="${teacher.getCity()}"
										name="city" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										value="${teacher.getDistrict()}" name="district" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										value="${teacher.getState()}" name="state" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										value="${teacher.getPinCode()}" name="pinCode" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<button class="btn btn-lg btn-info btn-block mb-1 mt-1"
										type="submit">Edit Teacher</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>

			<br>

			

		</div>
	</div>
</div>

<br>
<br>
<br>

<%@ include file="teacherfooter.jsp"%>

