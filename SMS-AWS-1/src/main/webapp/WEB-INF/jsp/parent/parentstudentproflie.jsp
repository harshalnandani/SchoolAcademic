<%@ include file="parentheader.jsp"%>
<c:set var="currentstudent" value="${sessionScope.currentstudent}"
	scope="page" />
<div class="container-fluid">

	<div class="row">

		<%@ include file="parentsidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Student Profile</span>
				</div>
				<div class="card-body">
					<div class="container-fluid">
						<div class="row justify-content-sm-center">
							<div class="col-sm-12 col-md-12">
								<div class="container-fluid">
									<div class="row justify-content-sm-center">
										<div class="col-md-4">
											<c:if test="${currentstudent.getProfilePictureUrl()==null}">
												<img src="/images/Profile-icon-9.png" height="200px"
													width="200px" class="profilepicture">
											</c:if>
											<c:if test="${currentstudent.getProfilePictureUrl()!=null}">
												<img src="${currentstudent.getProfilePictureUrl()}"
													height="200px" width="200px" class="profilepicture">
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
																action="WebEditStudentProfilePicture" method="post"
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

											<h4 class="name text-center">${currentstudent.getStudentName()}
											</h4>

											<div class="profile-user-info">
												<div class="profile-info-row">
													<div class="profile-info-name">Date Of Birth</div>

													<div class="profile-info-value">
														<span>${currentstudent.getDateOfBirth()}</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Gender</div>
													<div class="profile-info-value">
														<span>${currentstudent.getGender()}</span>
													</div>

												</div>


												<div class="profile-info-row">
													<div class="profile-info-name">Mobile Number</div>

													<div class="profile-info-value">
														<span>${currentstudent.getParent().getLogin().getMobileNumber()}</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Email Id</div>

													<div class="profile-info-value">
														<span>${currentstudent.getParent().getLogin().getEmailId()}</span>
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
														<span>${currentstudent.getAddressLine1()}</span>
													</div>
												</div>
												<div class="profile-info-row">
													<div class="profile-info-name">City</div>

													<div class="profile-info-value">
														<span>${currentstudent.getCity()}</span>
													</div>
												</div>
												<div class="profile-info-row">
													<div class="profile-info-name">State</div>

													<div class="profile-info-value">
														<span>${currentstudent.getState()}</span>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="profile-user-info">

												<div class="profile-info-row">
													<div class="profile-info-name">Address Line 2</div>

													<div class="profile-info-value">
														<span>${currentstudent.getAddressLine2()}</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">District</div>

													<div class="profile-info-value">
														<span>${currentstudent.getDistrict()}</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Pincode</div>

													<div class="profile-info-value">
														<span>${currentstudent.getPinCode()}</span>
													</div>
												</div>




											</div>
										</div>

									</div>
									<form class="form-signin" action="parenteditstudentprofile"
										method="get" enctype="multipart/form-data">
										<div class="container-fluid">
											<div class="row justify-content-sm-center">
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

<%@ include file="parentfooter.jsp"%>
