<%@ include file="schoolheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" scope="page" />
<c:set var="sections" value="${requestScope.sections}" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Section</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddSection" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">

								<div class="col-sm-6 col-md-4 col-offset-4">
									<select name="classId"
										class="form-control form-control-lg mb-2">
										<option selected disabled="disabled">Select Class</option>
										<c:forEach var="class1" items="${classes}" varStatus="counter">
											<option value="${class1[0]}">${class1[1]}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-6 col-md-4 col-offset-4">
									<select name="sectionName"
										class="form-control form-control-lg mb-2">
										<option selected disabled="disabled">Select Section</option>
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option value="D">D</option>
									</select>
								</div>
								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Add Section</button>
								</div>
							</div>
						</div>
					</form>
					<hr class="mt-3 mb-3">
					<div class="row justify-content-sm-center mt-3">
						<div class="col-md-12">
							<table id="example" class="table table-striped table-bordered"
								style="width: 100%">
								<thead>
									<tr>
										<th>Class Name</th>
										<th>Section Name</th>
										<th>View</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="section" items="${sections}"
										varStatus="counter">
										<tr>
											<td>${section[0]}</td>
											<td>${section[2]}</td>
											<td><a href="viewsection?sectionId=${section[1]}"><button
														type="submit" class="btn btn-sm  btn-success"><i class="fa fa-eye" aria-hidden="true"></i> View</button></a></td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									<tr>
										<th>Class Name</th>
										<th>Section Name</th>
										<th>View</th>
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

<br>
<br>
<br>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@ include file="schoolfooter.jsp"%>

