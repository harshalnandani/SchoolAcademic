<%@ include file="schoolheader.jsp"%>
<c:set var="datas" value="${enquiryForms}" />

<div class="container-fluid mt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-md-9">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>Name</th>
						<th>Date</th>
						<th>Student Name</th>
						<th>Gender</th>
						<th>Father's Name</th>
						<th>Mobile Number</th>
						<th>Email Id</th>
						<th>View</th>
						<th>View</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="data" items="${datas}" varStatus="counter">
						<tr>
							<td>${data[2]}</td>
							<td>${data[1]}</td>
							<td>${data[3]}</td>
							<td>${data[5]}</td>
							<td>${data[14]}</td>
							<td>${data[17]}</td>
							<td>${data[16]}</td>
							<td>
								<button type="button" class="btn btn-info" data-toggle="modal"
									data-target="#myModal${counter.index}">View</button>
								<div class="modal fade" id="myModal${counter.index}">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<!-- Modal Header -->
											<div class="modal-header">
												<h4 class="modal-title">Student Details</h4>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>
											<!-- Modal body -->
											<div class="modal-body">
												<div class="container-fluid">
													<div class="row justify-content-sm-center">
														<div class="col-md-6">
															<div class="profile-user-info">
																<div class="profile-info-row">
																	<div class="profile-info-name">Date</div>
																	<div class="profile-info-value">
																		<span>${data[1]}</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">Student Name</div>
																	<div class="profile-info-value">
																		<span>${data[3]}</span>
																	</div>
																</div>


																<div class="profile-info-row">
																	<div class="profile-info-name">Gender</div>

																	<div class="profile-info-value">
																		<span>${data[5]}</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">Previous Class
																		Passed</div>

																	<div class="profile-info-value">
																		<span>${data[7]}</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">Medium</div>

																	<div class="profile-info-value">
																		<span>${data[9]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Previous Board</div>

																	<div class="profile-info-value">
																		<span>${data[11]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Achievement</div>

																	<div class="profile-info-value">
																		<span>${data[13]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Mother's Name</div>

																	<div class="profile-info-value">
																		<span>${data[15]}</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">Mobile Number</div>

																	<div class="profile-info-value">
																		<span>${data[17]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Address Line 2</div>

																	<div class="profile-info-value">
																		<span>${data[19]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">District</div>

																	<div class="profile-info-value">
																		<span>${data[21]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">pinCode</div>

																	<div class="profile-info-value">
																		<span>${data[22]}</span>
																	</div>
																</div>
															</div>
														</div>
														<div class="col-md-6">
															<div class="profile-user-info">
																<div class="profile-info-row">
																	<div class="profile-info-name">Academic Session</div>

																	<div class="profile-info-value">
																		<span>${data[2]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Student DOB</div>

																	<div class="profile-info-value">
																		<span>${data[4]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Class To Admission</div>

																	<div class="profile-info-value">
																		<span>${data[6]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Year Of Passing</div>

																	<div class="profile-info-value">
																		<span>${data[8]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Previous School</div>

																	<div class="profile-info-value">
																		<span>${data[10]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Marks Obtained</div>

																	<div class="profile-info-value">
																		<span>${data[12]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Father's Name</div>

																	<div class="profile-info-value">
																		<span>${data[14]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Email Id</div>

																	<div class="profile-info-value">
																		<span>${data[16]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Address Line 1</div>

																	<div class="profile-info-value">
																		<span>${data[18]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">City</div>

																	<div class="profile-info-value">
																		<span>${data[20]}</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">State</div>

																	<div class="profile-info-value">
																		<span>${data[22]}</span>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<!-- Modal footer -->
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>
							</td>
							<td>

								<form method="Post" action="WebEditNews">
									<input type="hidden" value="1" name="actionId"> <input
										type="hidden" value="${data[0]}" name="newsId">
									<button type="submit" class="btn btn-info">Edit</button>
								</form>
							</td>
							<td>
								<form method="post" action="WebDeleteNews">
									<input type="hidden" value="${data[0]}" name="newsId">
									<button type="submit" class="btn btn-danger">Delete</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Name</th>
						<th>Date</th>
						<th>Student Name</th>
						<th>Gender</th>
						<th>Father's Name</th>
						<th>Mobile Number</th>
						<th>Email Id</th>
						<th>View</th>
						<th>View</th>
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