<%@ include file="schoolheader.jsp"%>

<c:set var="school" value="${schooldata}" />

<c:if test="${schooldata==null}">
	<c:redirect url="/schoolhome" />
</c:if>

<div class="container-fluid">
	<div class="row">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-md-9 pt-3">
					<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Edit School</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="/WebSchoolEditSchool" method="post">
					<input type="hidden" name="schoolId" value="${school.getSchoolId()}">
    				<input type="hidden" name="actionId" value="1"> 
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-12 col-md-12">
									<input type="text" class="form-control mb-2"
										value="${school.getSchoolName()}" name="schoolName" required
										autofocus>
								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										 name="addressLine1">${school.getAddressLine1()}</textarea>
								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										placeholder="Address Line 2" name="addressLine2">${school.getAddressLine2()}</textarea>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2" value="${school.getCity()}"
										name="city" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										value="${school.getDistrict()}" name="district" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										value="${school.getState()}" name="state" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										value="${school.getPinCode()}" name="pinCode" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<button class="btn btn-lg btn-info btn-block mb-1 mt-1"
										type="submit">Edit School</button>
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