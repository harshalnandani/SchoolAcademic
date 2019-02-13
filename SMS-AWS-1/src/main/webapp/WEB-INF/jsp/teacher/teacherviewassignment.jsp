<%@ include file="teacherheader.jsp"%>
<c:set var="assignments" value="${requestScope.assignments}" />
<div class="container-fluid">

	<div class="row">

		<%@ include file="teachersidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Assignmemt List</span>
				</div>
				<div class="card-body">

					<div class="container-fluid">
						<div class="row mt-3">
							<div class="col-md-12">
								<table id="example" class="table table-striped table-bordered"
									style="width: 100%">
									<thead>
										<tr>
											<th>Subject Name</th>
											<th>Class</th>
											<th>Section</th>
											<th>Name</th>
											<th>description</th>
											<th>Download</th>
											<th>Date</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="assignment" items="${assignments}" varStatus="counter">
											
												<tr>
													
													<td>${assignment.getSubject().getSubjectName()}</td>
													<td>${assignment.getSection().getClass1().getClassName()}</td>
													<td>${assignment.getSection().getSectionName()}</td>
													<td>${assignment.getName()}</td>
													<td>${assignment.getDescription()}</td>
													<td><a
														href="data:${syllabus.getFileType()};base64,${questionPaper.getBase64Encoded()}"
														download>Download</a></td>
													<td>${assignment.getDate()}</td>
												</tr>
											</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th>Subject Name</th>
											<th>Class</th>
											<th>Section</th>
											<th>Name</th>
											<th>description</th>
											<th>Download</th>
											<th>Date</th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>


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


<%@ include file="teacherfooter.jsp"%>

