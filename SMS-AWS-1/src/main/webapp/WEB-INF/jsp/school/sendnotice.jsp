<%@ include file="schoolheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" scope="page" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Student Notice</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebSendSchoolNotice" method="post" enctype="multipart/form-data">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<%-- <div class="col-sm-6 col-md-6">
									<select name="classId" class="form-control mb-2 company1">
										<option selected disabled="disabled">Select Class</option>
										<c:forEach var="class1" items="${classes}" varStatus="counter">
											<option value="${class1[0]}">${class1[1]}</option>
										</c:forEach>
									</select>
								</div> --%>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="3"
										placeholder="Discription" name="notice"></textarea>
								</div>
								
								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Send</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			
			<div class="card border-info text-center mt-3">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Class Notice</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebSendClassNotice" method="post" enctype="multipart/form-data">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-12 col-md-12">
									<select name="classId" class="form-control mb-2">
										<option selected disabled="disabled">Select Class</option>
										<c:forEach var="class1" items="${classes}" varStatus="counter">
											<option value="${class1[0]}">${class1[1]}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="3"
										placeholder="Discription" name="notice"></textarea>
								</div>
								
								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Send</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			
			
			<div class="card border-info text-center mt-3">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Section Notice</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebSendSectionNotice" method="post" enctype="multipart/form-data">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
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
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="3"
										placeholder="Discription" name="notice"></textarea>
								</div>
								
								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Send</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			
			
			<div class="card border-info text-center mt-3">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Teacher Notice</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebSendTeacherNotice" method="post" enctype="multipart/form-data">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="3"
										placeholder="Discription" name="notice"></textarea>
								</div>
								
								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Send</button>
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
