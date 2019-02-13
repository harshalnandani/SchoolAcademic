<%@ include file="teacherheader.jsp"%>
<c:set var="teacher" value="${requestScope.teacher}" scope="page" />
<div class="container-fluid">

	<div class="row">

		<%@ include file="teachersidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Teacher Profile</span>
				</div>
				<div class="card-body">
					<div class="container-fluid">
						<div class="row justify-content-sm-center">
							<div class="col-sm-12 col-md-12">
								<div class="container-fluid">
									<div class="row justify-content-sm-center">
										<div class="col-md-4">
											<c:if test="${teacher.getProfilePictureUrl()==null}">
												<img src="/images/Profile-icon-9.png" height="200px"
													width="200px" class="profilepicture">
											</c:if>
											<c:if test="${teacher.getProfilePictureUrl()!=null}">
												<img src="${teacher.getProfilePictureUrl()}" height="200px"
													width="200px" class="profilepicture">
											</c:if>

											<button type="button"
												class="btn btn-info profilepicturebutton"
												data-toggle="modal" data-target="#myModal1">Change
												Picture</button>

											<!-- The Modal -->
											<div class="modal fade" id="myModal1">
												<div class="modal-dialog">
													<div class="modal-content">

														<!-- Modal Header -->
														<div class="modal-header">
															<h4 class="modal-title">Change Picture</h4>
															<button type="button" class="close" data-dismiss="modal">&times;</button>
														</div>

														<!-- Modal body -->
														<div class="modal-body">
															<form class="form-signin"
																action="WebEditTeacherProfilePicture" method="post"
																enctype="multipart/form-data">
																<div class="container-fluid">
																	<div class="row justify-content-sm-center">
																		<div class="col-sm-6 col-md-6">
																			<input type="file" class="form-control mb-2"
																				placeholder="Insert Your File" name="file" required
																				autofocus>
																		</div>
																		<div class="col-sm-6 col-md-6">
																			<button class="btn btn-lg btn-info btn-block mb-2"
																				type="submit">Upload</button>
																		</div>
																	</div>
																</div>
															</form>
														</div>

														<!-- Modal footer -->
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Close</button>
														</div>

													</div>
												</div>
											</div>
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
									<form class="form-signin" action="WebEditTeacherProfile"
										method="post" enctype="multipart/form-data">
										<div class="container-fluid">
											<div class="row justify-content-sm-center">

												<input type="hidden" name="teacherId"
													value="${teacher.getTeacherId()}"> <input
													type="hidden" name="actionId" value="0">

												<div class="col-sm-6 col-md-6 col-offset-4">
													<button class="btn btn-lg btn-info btn-block mb-2 mt-3"
														type="submit">Edit Profile</button>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<br>
<br>
<br>

<%@ include file="teacherfooter.jsp"%>
