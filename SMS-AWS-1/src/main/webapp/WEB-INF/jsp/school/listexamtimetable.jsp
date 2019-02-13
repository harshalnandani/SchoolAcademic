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
						<th>Exam</th>
						<th>Description</th>
						<th>Download</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="class1" items="${classes}" varStatus="counter">
						<c:forEach var="questionPaper" items="${class1.getExamTimeTables()}" varStatus="counter">
						<tr>
							<td>${questionPaper.getClass1().getClassName()}</td>
							<td>${questionPaper.getExam().getExamName()}</td>
							<td>${questionPaper.getDiscription()}</td>
							<td><a href="${questionPaper.getFileUrl()}" download>Download</a></td>
							<td>
									<form method="post" action="WebDeleteExamTimeTable">
										<input type="hidden" value="${questionPaper.getId()}"
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