<%@ include file="parentheader.jsp"%>
<c:set var="assignments" value="${requestScope.assignments}" />
<div class="container-fluid">

	<div class="row">

		<%@ include file="parentsidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Assignment List</span>
				</div>
				<div class="card-body">
					<div class="table-responsive table-striped table-bordered">
						<table class="table">
							<thead class="bg-info text-white text-uppercase">
								<tr>
									<th>Subject Name</th>
									<th>Teacher Name</th>
									<th>Name</th>
									<th>description</th>
									<th>Download</th>
									<th>Date</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="assignment" items="${assignments}"
									varStatus="counter">

									<tr>
										<td>${assignment.getSubject().getSubjectName()}</td>
										<td>${assignment.getTeacher().getTeacherName()}</td>
										<td>${assignment.getName()}</td>
										<td>${assignment.getDescription()}</td>
										<td><a
											href="${assignment.getFileUrl()}"
											target="_blank">Download</a></td>
										<td>${assignment.getDate()}</td>
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







<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>


<%@ include file="parentfooter.jsp"%>

