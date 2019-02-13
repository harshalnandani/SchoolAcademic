<%@ include file="schoolheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" scope="page" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Time Table</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddTimeTable" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-12 col-md-12">
									<input type="text" class="form-control mb-2"
										placeholder="Enter Name" name="name" required
										autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<select name="classId" class="form-control mb-2 company1"
										onchange="user1_change()">
										<option selected disabled="disabled">Select Class</option>
										<c:forEach var="class1" items="${classes}" varStatus="counter">
											<option value="${class1[0]}">${class1[1]}</option>
										</c:forEach>
									</select>
								</div>

								<div class="col-sm-6 col-md-6">
									<select class="form-control mb-2 company11" name="sectionId">
										<option selected="selected">Select Section</option>
									</select>
								</div>
								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Add</button>
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
</script>