<%@ include file="schoolheader.jsp"%>
<c:set var="data" value="${schooldata}" />
<div class="container-fluid">
	<div class="row">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-md-9 pt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">School Profile</span>
				</div>
				<div class="card-body">
					<div class="container-fluid">
						<div class="row">
						<c:if test="${data.getBannerUrl()==null}">
					<div class="col-md-12 schooleditbannerpicture"
								style="background: url('./images/index.jpg');">
				</c:if>
				<c:if test="${data.getBannerUrl()!=null}">
					<div class="col-md-12 schooleditbannerpicture"
								style="background: url('${data.getBannerUrl()}');">
				</c:if>
								<button type="button"
									class="btn btn-info schooleditbannerpicturebutton"
									data-toggle="modal" data-target="#myModal1">Change
									Picture</button>

								<!-- The Modal -->
								<div class="modal fade" id="myModal1">
									<div class="modal-dialog">
										<div class="modal-content">

											<!-- Modal Header -->
											<div class="modal-header">
												<h4 class="modal-title">Change Banner Picture</h4>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>

											<!-- Modal body -->
											<div class="modal-body">
												<form class="form-signin"
													action="WebSchoolUploadBanner" method="post"
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
						</div>
					</div>
					<div class="container-fluid">
						<div class="row justify-content-sm-center">
							<div class="col-sm-12 col-md-12">
								<div class="container-fluid">
									<div class="row justify-content-sm-center">
										<div class="col-md-4">
											<c:if test="${data.getLogoURl()==null}">
												<img src="/images/Profile-icon-9.png" height="200px"
													width="200px" class="profilepicture">
											</c:if>
											<c:if test="${data.getLogoURl()!=null}">
												<img src="${data.getLogoURl()}"
													height="200px" width="200px" class="profilepicture">
											</c:if>
											<button type="button"
												class="btn btn-info mt-1 profilepicturebutton"
												data-toggle="modal" data-target="#myModal">Change
												Profile Picture</button>

											<div class="modal fade" id="myModal">
												<div class="modal-dialog">
													<div class="modal-content">
														<!-- Modal Header -->
														<div class="modal-header">
															<h4 class="modal-title">Change Profile Picture</h4>
															<button type="button" class="close" data-dismiss="modal">&times;</button>
														</div>
														<!-- Modal body -->
														<div class="modal-body">
															<form class="form-signin"
																action="WebSchoolUploadLogo" method="post"
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

											<h4 class="name text-center mt-3">${data.getSchoolName()}
											</h4>

											<div class="profile-user-info">
												<div class="profile-info-row">
													<div class="profile-info-name">Registration Date</div>

													<div class="profile-info-value">
														<span>${data.getDate()}</span>
													</div>
												</div>
												<div class="profile-info-row">
													<div class="profile-info-name">Mobile Number</div>

													<div class="profile-info-value">
														<span>${data.getLogin().getMobileNumber()}</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Email Id</div>

													<div class="profile-info-value">
														<span>${data.getLogin().getEmailId()}</span>
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
														<span>${data.getAddressLine1()}</span>
													</div>
												</div>
												<div class="profile-info-row">
													<div class="profile-info-name">City</div>

													<div class="profile-info-value">
														<span>${data.getCity()}</span>
													</div>
												</div>
												<div class="profile-info-row">
													<div class="profile-info-name">State</div>

													<div class="profile-info-value">
														<span>${data.getState()}</span>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="profile-user-info">

												<div class="profile-info-row">
													<div class="profile-info-name">Address Line 2</div>

													<div class="profile-info-value">
														<span>${data.getAddressLine2()}</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">District</div>

													<div class="profile-info-value">
														<span>${data.getDistrict()}</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Pincode</div>

													<div class="profile-info-value">
														<span>${data.getPinCode()}</span>
													</div>
												</div>




											</div>
										</div>

									</div>
									<form class="form-signin" action="schooleditschool"
										method="get" enctype="multipart/form-data">
										<input type="hidden" name="schoolId" value="${school.getSchoolId()}">
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





<%@ include file="schoolfooter.jsp"%>