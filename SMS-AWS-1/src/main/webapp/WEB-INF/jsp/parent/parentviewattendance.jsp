<%@ include file="parentheader.jsp"%>
<c:set var="assignments" value="${requestScope.assignments}" />
<div class="container-fluid">
	<div class="row">
		<%@ include file="parentsidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Attendance</span>
				</div>
				<div class="card-body">
					<div class="table-responsive table-striped table-bordered">
						<table class="table">
							<thead class="bg-info text-white text-uppercase">
								<tr>
									<th>Month</th>
									<th>Total</th>
									<th>Present</th>
									<th>Absent</th>
									<th>Percentage</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="assignment" items="${assignments}"
									varStatus="counter">

									<tr>
										<td>${assignment[0]}</td>
										<td>${assignment[1]}</td>
										<td>${assignment[2]}</td>
										<td>${assignment[3]}</td>
										<td>${assignment[4]}</td>
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
<%@ include file="parentfooter.jsp"%>

