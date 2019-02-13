<%@ include file="schoolheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" />

<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>Class</th>
						<th>Subject</th>
						<th>Discription</th>
						<th>Download</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="class1" items="${classes}" varStatus="counter">
						<c:forEach var="syllabus" items="${class1.getSyllabus()}" varStatus="counter">
						<tr>
							<td>${syllabus.getClass1().getClassName()}</td>
							<td>${syllabus.getSubject().getSubjectName()}</td>
							<td>${syllabus.getDiscription()}</td>
							<td><a href="${syllabus.getFileUrl()}" download>Download</a></td>
							<td>
									<form method="post" action="WebDeleteSyllabus">
										<input type="hidden" value="${syllabus.getId()}"
											name="questionPaperId">
										<button type="submit" class="btn btn-danger">Delete</button>
									</form>
							</td>
						</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Class</th>
						<th>Subject</th>
						<th>Discription</th>
						<th>Download</th>
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