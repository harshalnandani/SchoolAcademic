<%@ include file="schoolheader.jsp"%>
<c:set var="teachers" value="${requestScope.teachers}" />



<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>Name</th>
						<th>Gender</th>
						<th>DOB</th>
						<th>Mobile Number</th>
						<th>View</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="teacher" items="${teachers}" varStatus="counter">
						<tr>
							<td>${teacher.getTeacherName()}</td>
							<td>${teacher.getGender()}</td>
							<td>${teacher.getDateOfBirth()}</td>
							<td>${teacher.getLogin().getMobileNumber()}</td>

							<td>
								<button type="button" class="btn btn-success"
									data-toggle="modal"
									data-target="#myModal${teacher.getTeacherId()}">View</button> <!-- The Modal -->
								<div class="modal fade" id="myModal${teacher.getTeacherId()}">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<!-- Modal body -->
											<div class="modal-body">
												<div class="container-fluid">
													<div class="row justify-content-sm-center">
														<div class="col-md-4">
															<c:if test="${student.getProfilePictureUrl()==null}">
																<img src="/images/Profile-icon-9.png" height="200px"
																	width="200px" class="profilepicture">
															</c:if>
															<c:if test="${student.getProfilePictureUrl()!=null}">
																<img src="${student.getProfilePictureUrl()}"
																	height="200px" width="200px" class="profilepicture">
															</c:if>
															<button type="submit"
																class="btn btn-info mt-1 profilepicturebutton">Change
																Profile Picture</button>
														</div>
														<div class="col-md-8">

															<h4 class="name text-center">${teacher.getTeacherName()}
															</h4>

															<div class="profile-user-info">

																<div class="profile-info-row">
																	<div class="profile-info-name">Date Of Birth</div>

																	<div class="profile-info-value">
																		<span>${teacher.getDateOfBirth()}</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">Gender</div>
																	<div class="profile-info-value">
																		<span>${teacher.getGender()}</span>
																	</div>

																</div>



																<div class="profile-info-row">
																	<div class="profile-info-name">Mobile Number</div>

																	<div class="profile-info-value">
																		<span>${teacher.getLogin().getMobileNumber()}</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">Email Id</div>

																	<div class="profile-info-value">
																		<span>${teacher.getLogin().getEmailId()}</span>
																	</div>
																</div>

															</div>
														</div>
													</div>
													<hr>
													<div class="row justify-content-sm-center">
														<div class="col-md-6">
															<div class="profile-user-info">
																<div class="profile-info-row">
																	<div class="profile-info-name">Address Line 1</div>

																	<div class="profile-info-value">
																		<span>${teacher.getAddressLine1()}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">City</div>

																	<div class="profile-info-value">
																		<span>${teacher.getCity()}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">State</div>

																	<div class="profile-info-value">
																		<span>${teacher.getState()}</span>
																	</div>
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="profile-user-info">

																<div class="profile-info-row">
																	<div class="profile-info-name">Address Line 2</div>

																	<div class="profile-info-value">
																		<span>${teacher.getAddressLine2()}</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">District</div>

																	<div class="profile-info-value">
																		<span>${teacher.getDistrict()}</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">Pincode</div>

																	<div class="profile-info-value">
																		<span>${teacher.getPinCode()}</span>
																	</div>
																</div>
															</div>
														</div>
													</div>

												</div>



											</div>
										</div>
									</div>
								</div>
							</td>
							<td>
								<form method="post" action="/WebEditTeacher">
									<input type="hidden" value="0" name="actionId"> <input
										type="hidden" value="${teacher.getTeacherId()}"
										name="teacherId">
									<button type="submit" class="btn btn-info">Edit</button>
								</form>
							</td>
							<td>
								<form method="post" action="/WebDeleteStudent">
									<input type="hidden" value="${teacher.getTeacherId()}"
										name="studentId">
									<button type="submit" class="btn btn-danger">Delete</button>
								</form>
							</td>

						</tr>
					</c:forEach>





				</tbody>
				<tfoot>
					<tr>
						<th>Name</th>
						<th>Gender</th>
						<th>DOB</th>
						<th>Father's Name</th>
						<th>View</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>














<%@ include file="schoolfooter.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>