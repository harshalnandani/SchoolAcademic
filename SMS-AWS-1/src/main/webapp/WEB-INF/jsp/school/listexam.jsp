<%@ include file="schoolheader.jsp"%>
<c:set var="exams" value="${requestScope.exams}" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Exam List</span>
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
												<th>Session</th>
												<th>Delete</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="class1" items="${exams}"
												varStatus="counter">
												<tr>
													<td>${class1.getExamName()}</td>
													<td>${class1.getSession()}</td>
													<td>
														<form method="post" action="">
															<input type="hidden" value="${exams}"
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