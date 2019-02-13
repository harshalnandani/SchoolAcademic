<%@ include file="schoolheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Class</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddClass" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">

								<div class="col-sm-6 col-md-4 col-offset-4">
									<select class="form-control form-control-lg mb-2"
										name="className" required autofocus>
										<option selected disabled="disabled">Select Class</option>
										<option value="1st">1st</option>
										<option value="2nd">2nd</option>
										<option value="3rd">3rd</option>
										<option value="4th">4th</option>
										<option value="1st">5th</option>
										<option value="2nd">6th</option>
										<option value="3rd">7th</option>
										<option value="4th">8th</option>
										<option value="4th">9th</option>
										<option value="4th">10th</option>
										<option value="4th">11th</option>
										<option value="4th">12th</option>
									</select>

								</div>
								<div class="col-sm-6 col-md-4 col-offset-4">
									<select id="multi-select-demo" multiple="multiple" name="sectionName"
										required autofocus>
										<option selected disabled="disabled">Select Section</option>
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option value="D">D</option>
										<option value="E">E</option>
										<option value="F">F</option>
										<option value="G">G</option>
										<option value="H">H</option>
										<option value="I">I</option>
									</select>
								</div>
								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Add Class</button>
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
													<th>Name</th>
													<th>View</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach var="class1" items="${classes}"
													varStatus="counter">
													<tr>
														<td>${class1[1]}</td>
														<td><a href="viewclass?classId=${class1[0]}"><button
																	type="submit" class="btn btn-success">View</button></a></td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<th>Name</th>
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
<script>
	$(document).ready(function() {
		$('#multi-select-demo').multiselect({
			buttonWidth : '100%'
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<%@ include file="schoolfooter.jsp"%>

