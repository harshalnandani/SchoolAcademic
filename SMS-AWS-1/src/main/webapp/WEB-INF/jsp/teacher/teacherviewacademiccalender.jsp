<%@ include file="teacherheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" />
<c:set var="eventCalenders" value="${requestScope.eventCalenders}" />
<div class="container-fluid">
	<div class="row">
		<%@ include file="teachersidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Academic Calendar</span>
				</div>
				<div class="card-body">

					<div class="container-fluid">
						<div class="row mt-3">
							<div class="col-md-12">
								<div class="table-responsive table-striped table-bordered">
									<table class="table">
										<thead class="bg-info text-white text-uppercase">
											<tr>
												<th>Event Date</th>
												<th>Event Name</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="eventCalender" items="${eventCalenders}"
												varStatus="counter">
												<tr>
													<td>${eventCalender[1]}</td>
													<td>${eventCalender[2]}</td>
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
<%@ include file="teacherfooter.jsp"%>