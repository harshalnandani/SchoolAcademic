<%@ include file="schoolheader.jsp"%>
<c:set var="students" value="${sessionScope.students}" scope="page" />
<c:set var="subjectsName" value="${sessionScope.subjectsName}"
	scope="page" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Result</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddResult" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="table-responsive table-striped table-bordered">
									<table class="table">
										<thead class="bg-info text-white text-uppercase">
											<tr>
												<th>Student Name/Subject</th>
												<c:forEach var="class1" items="${subjectsName}"
													varStatus="counter">
													<th>${class1}</th>
												</c:forEach>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="student" items="${students}"
												varStatus="counter">
												<tr>
												<td>${student[1]}</td>
												<c:forEach begin="1" end="${subjectsName.size()}" varStatus="loop">
    														<td><input type="text" name="marks" required="required"></td>
												</c:forEach>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>



								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Select</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<br>
<br>
<br>

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
	function user2_change() {
		var user1 = $(".company11").val();
		$.ajax({
			type : "Get",
			url : "WebGetSubject",
			data : "user_id=" + user1,
			cache : false,
			success : function(response) {
				$(".displayoption").html(response);
			}
		});
	}
</script>