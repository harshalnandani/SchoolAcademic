<%@ include file="schoolheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" scope="page" />
<c:set var="subjectteachermapping" value="${requestScope.subjectteachermapping}" scope="page" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Subject Teacher To Class</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddSubjectTeacherToSection"
						method="post">
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
							</div>
							<div class="field_wrapper mt-3">
								<div class="row justify-content-sm-center">
									<div class="col-sm-6 col-md-5">
										<select class="form-control mb-2" name="subjectId">
											<option selected disabled="disabled">Select
												Subject</option>
											<c:set var="subjects" value="${requestScope.subjects}"
												scope="page" />
											<c:forEach var="subject" items="${subjects}"
												varStatus="counter">
												<option value="${subject[0]}">${subject[1]}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-sm-6 col-md-5">
										<select class="form-control mb-2" name="teacherId">
											<option selected disabled="disabled">Select Teacher</option>
											<c:set var="teachers" value="${requestScope.teachers}"
												scope="page" />
											<c:forEach var="teacher" items="${teachers}"
												varStatus="counter">
												<option value="${teacher[0]}">${teacher[1]}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-sm-6 col-md-2">
										<button type="button"
											class="btn btn-sm btn-info btn-block add_button">
											<i class="fa fa-plus" aria-hidden="true"></i>
										</button>
									</div>
								</div>
							</div>
							<div class="row justify-content-sm-center mt-3">
								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Add</button>
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
										<th>Class</th>
										<th>Section</th>
										<th>Teacher</th>
										<th>Subject</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="data" items="${subjectteachermapping}"
										varStatus="counter">
										<tr>
											<td>${data[0]}</td>
											<td>${data[1]}</td>
											<td>${data[2]}</td>
											<td>${data[3]}</td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									<tr>
										<th>Class</th>
										<th>Section</th>
										<th>Teacher</th>
										<th>Subject</th>
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
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var maxField = 10; //Input fields increment limitation
						var addButton = $('.add_button'); //Add button selector
						var wrapper = $('.field_wrapper'); //Input field wrapper
						var fieldHTML = '<div class="row justify-content-sm-center"> <div class="col-sm-6 col-md-5"> <select class="form-control mb-2" name="subjectId"> <option selected disabled="disabled">Select Subject</option> <c:set var="subjects" value="${requestScope.subjects}" scope="page" /> <c:forEach var="subject" items="${subjects}" varStatus="counter"> <option value="${subject[0]}">${subject[1]}</option> </c:forEach> </select> </div> <div class="col-sm-6 col-md-5"> <select class="form-control mb-2" name="teacherId"> <option selected disabled="disabled">Select Teacher</option> <c:set var="teachers" value="${requestScope.teachers}" scope="page" /> <c:forEach var="teacher" items="${teachers}" varStatus="counter"> <option value="${teacher[0]}">${teacher[1]}</option> </c:forEach> </select> </div> <div class="col-sm-6 col-md-2"> <button type="button" class="btn btn-sm btn-danger btn-block remove_button"> <i class="fa fa-minus" aria-hidden="true"></i> </button> </div> </div>'; //New input field html 
						var x = 1; //Initial field counter is 1

						//Once add button is clicked
						$(addButton).click(function() {
							//Check maximum number of input fields
							if (x < maxField) {
								x++; //Increment field counter
								$(wrapper).append(fieldHTML); //Add field html
							}
						});

						//Once remove button is clicked
						$(wrapper).on('click', '.remove_button', function(e) {
							e.preventDefault();
							$(this).parent().parent('div').remove(); //Remove field html
							x--; //Decrement field counter
						});
					});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>