<%@ include file="schoolheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Class List</span>
				</div>
				<div class="card-body">

					<div class="container-fluid">
						<div class="row mt-3">
							<div class="col-md-12">
								<div class="table-responsive table-striped table-bordered">
									<table class="table">
										<thead class="bg-info text-white text-uppercase">
											<tr>
												<th>Name</th>
												<th>View</th>
												<th>Delete</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="class1" items="${classes}"
												varStatus="counter">
												<tr>
													<td>${class1[1]}</td>
													<td><a href="viewclass?classId=${class1[0]}"><button
																type="submit" class="btn btn-success">View</button></a></td>
													<td>
														<form method="post" action="">
															<input type="hidden" value="${class1[0]}"
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


					</div>
				</div>
			</div>



		</div>
	</div>

</div>







</html>















<%@ include file="schoolfooter.jsp"%>