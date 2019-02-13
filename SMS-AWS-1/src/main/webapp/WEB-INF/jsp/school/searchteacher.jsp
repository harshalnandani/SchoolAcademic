<%@ include file="schoolheader.jsp"%>
<c:set var="teachers" value="${teachers}" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Search Teacher</span>
				</div>
				<div class="card-body">

					<div class="container-fluid">

						<form method="post" action="/WebSearchTeacher">
							<div class="row">

								<div class="col-sm-9 col-md-9" style="padding: 0px;">
									<input class="form-control form-control-lg" type="search"
										name="teacherName" placeholder="Enter Student Name Here">
								</div>
								<div class="col-sm-3 col-md-3" style="padding: 0px">
									<button class="btn btn-lg btn-info btn-block" type="submit">
										<i class="fa fa-search" aria-hidden="true"></i> Search
									</button>
								</div>

							</div>
						</form>
						<c:if test="${teachers!=null}">
							<div class="row mt-3">
								<div class="col-md-12">
									<div class="table-responsive table-striped table-bordered">
										<table class="table">
											<thead class="bg-info text-white text-uppercase">
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
												<c:forEach var="teacher" items="${teachers}"
													varStatus="counter">
													<tr>
														<td>${teacher.getTeacherName()}</td>
														<td>${teacher.getGender()}</td>
														<td>${teacher.getDateOfBirth()}</td>
														<td>${teacher.getLogin().getMobileNumber()}</td>

														<td>
															<button type="button" class="btn btn-success"
																data-toggle="modal"
																data-target="#myModal${teacher.getTeacherId()}">View</button>
															<!-- The Modal -->
															<div class="modal fade"
																id="myModal${teacher.getTeacherId()}">
																<div class="modal-dialog modal-lg">
																	<div class="modal-content">
																		<!-- Modal body -->
																		<div class="modal-body">
																			<div class="container-fluid">
																				<div class="row justify-content-sm-center">
																					<div class="col-md-4">
																						<c:if
																							test="${student.getProfilePictureUrl()==null}">
																							<img src="/images/Profile-icon-9.png"
																								height="200px" width="200px"
																								class="profilepicture">
																						</c:if>
																						<c:if
																							test="${student.getProfilePictureUrl()!=null}">
																							<img src="${student.getProfilePictureUrl()}"
																								height="200px" width="200px"
																								class="profilepicture">
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
																								<div class="profile-info-name">Date Of
																									Birth</div>

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
																								<div class="profile-info-name">Mobile
																									Number</div>

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
																								<div class="profile-info-name">Address
																									Line 1</div>

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
																								<div class="profile-info-name">Address
																									Line 2</div>

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
																<input type="hidden" value="0" name="actionId">
																<input type="hidden" value="${teacher.getTeacherId()}"
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
										</table>
									</div>

								</div>
							</div>

						</c:if>
					</div>
				</div>
			</div>



		</div>
	</div>

</div>







</html>















<%@ include file="schoolfooter.jsp"%>