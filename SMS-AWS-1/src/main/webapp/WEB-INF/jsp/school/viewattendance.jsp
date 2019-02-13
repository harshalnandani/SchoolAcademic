<%@ include file="schoolheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" scope="page" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">View Attendance</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebViewAttendance"
						method="post" enctype="multipart/form-data">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">

								<div class="col-sm-6 col-md-6">
									<select name="classId" class="form-control mb-2 company1"
										onchange="user1_change()" autofocus required="required">
										<option selected disabled="disabled">Select Class</option>
										<c:forEach var="class1" items="${classes}" varStatus="counter">
											<option value="${class1[0]}">${class1[1]}</option>
										</c:forEach>
									</select>
								</div>

								<div class="col-sm-6 col-md-6">
									<select class="form-control mb-2 company11" name="sectionId"
										autofocus required="required">
										<option selected="selected">Select Section</option>
									</select>
								</div>
								<div class="col-sm-6 col-md-6">
									<select class="form-control mb-2" name="monthId" required="required">
										<option selected disabled="disabled">Select Month</option>
										<option value='1'>January</option>
										<option value='2'>February</option>
										<option value='3'>March</option>
										<option value='4'>April</option>
										<option value='5'>May</option>
										<option value='6'>June</option>
										<option value='7'>July</option>
										<option value='8'>August</option>
										<option value='9'>September</option>
										<option value='10'>October</option>
										<option value='11'>November</option>
										<option value='12'>December</option>
									</select>
								</div>

								<div class="col-sm-6 col-md-6">
									<select class="form-control mb-2" name="yearId" required="required">
										<option selected disabled="disabled">Select Year</option>
										<option value='2018'>2018</option>
										<option value='2019'>2019</option>
									</select>
								</div>
								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block"
										type="submit">View</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>

			<c:set var="students" value="${sessionScope.students}" scope="page" />
			<c:if test="${students!=null}">
				<div class="row justify-content-sm-center mt-3">
					<div class="col-md-12">
						<div class="table-responsive table-striped table-bordered">
							<table class="table">
								<thead class="bg-info text-white text-uppercase">
									<tr>
										<th>Name</th>
										<th>Total</th>
										<th>Presence</th>
										<th>Absent</th>
										<th>Percentage</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="student" items="${students}" varStatus="counter">
												<tr>
												<td>${student[0]}</td>
												<td>${student[1]}</td>
												<td>${student[2]}</td>
												<td>${student[3]}</td>
												<td>${student[4]}%</td>
												</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</c:if>

		</div>
	</div>
</div>
<%@ include file="schoolfooter.jsp"%>
<script>
	function user1_change() {

		var user1 = $(".company1").val();

		$.ajax({
			type : "Get",
			url : "WebGetSection",
			data : "user_id=" + user1,
			cache : false,
			success : function(response) {
				$(".company11").html(response);
			}
		});
	}
</script>
