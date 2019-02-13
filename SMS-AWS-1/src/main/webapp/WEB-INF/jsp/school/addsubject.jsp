<%@ include file="schoolheader.jsp"%>
<c:set var="subjects" value="${requestScope.subjects}" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Subject</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddSubject" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-6 col-md-12">
									<div class="field_wrapper">
										<div class="row justify-content-sm-center">
											<div class="col-sm-6 col-md-6">
												<input type="text" class="form-control form-control-lg mb-2"
													name="subjectName" placeholder="Enter Subject Name Here"
													required autofocus />
											</div>
											<div class="col-sm-6 col-md-2">
												<button type="button"
													class="btn  btn-info btn-block add_button">
													<i class="fa fa-plus" aria-hidden="true"></i> Option
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-3 col-offset-3 mt-3">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Add Subject</button>
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

									<c:forEach var="subject" items="${subjects}"
										varStatus="counter">
										<tr>
											<td>${subject[1]}</td>
											<td><a href="viewsubject?subjectId=${subject[0]}"><button
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
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var maxField = 10; //Input fields increment limitation
						var addButton = $('.add_button'); //Add button selector
						var wrapper = $('.field_wrapper'); //Input field wrapper
						var fieldHTML = '<div class="row justify-content-sm-center"><div class="col-sm-6 col-md-6">	<input type="text" class="form-control form-control-lg mb-2"	name="subjectName" placeholder="Enter Subject Name Here" required autofocus /></div><div class="col-sm-6 col-md-2"><button type="button" class="btn  btn-danger btn-block remove_button"><i class="fa fa-minus" aria-hidden="true"></i> Option</button></div></div>'; //New input field html 
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
<%@ include file="schoolfooter.jsp"%>

