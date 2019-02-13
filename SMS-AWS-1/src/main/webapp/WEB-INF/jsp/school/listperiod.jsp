<%@ include file="schoolheader.jsp"%>
<c:set var="periods" value="${requestScope.periods}" scope="page" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Period List</span>
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
												<th>Start Time</th>
												<th>End Time</th>
												<th>Edit</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="period" items="${periods}"
												varStatus="counter">
												<tr>
													<td>${period[1]}</td>
													<td>${period[2]}</td>
													<td>${period[3]}</td>
													<td>
														<form method="post" action="WebEditPeriod">
														<input value="1" type="hidden" name="actionId">
															<input type="hidden" value="${period[0]}"
																name="periodId">
															<button type="submit" class="btn btn-info">Edit</button>
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