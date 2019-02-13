<%@ include file="teacherheader.jsp"%>
<c:set var="students" value="${requestScope.students}" scope="page" />


<div class="container-fluid">
	<div class="row">
		<%@ include file="teachersidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Take Attendance</span>
				</div>
				<div class="card-body">

					<div class="container-fluid">
						<form action="WebTakeAttendance" method="post">
							<div class="row mt-3">

								<div class="col-md-12">
									<div class="table-responsive table-striped table-bordered">

										<table class="table">
											<thead class="bg-info text-white text-uppercase">
												<tr>
													<th>Student Name</th>
													<th>Present</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="student" items="${students}"
													varStatus="counter">
													<input type="hidden" value="${student[0]}" name="studentId">
													<tr>
														<td>${student[1]}</td>
														<td><select class="form-control mb-2" name="status">
																<option selected="selected" value="true">Present</option>
																<option value="false">Absent</option>
														</select></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

									</div>

								</div>
								<div class="col-md-4 offset-md-4 mt-3">
									<button class="btn btn-lg btn-info btn-block" type="submit">
										Submit</button>
								</div>

							</div>
						</form>
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

