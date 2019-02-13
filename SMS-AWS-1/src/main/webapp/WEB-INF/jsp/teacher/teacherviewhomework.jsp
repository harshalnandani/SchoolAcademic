<%@ include file="teacherheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" scope="page" />
<div class="container-fluid">

	<div class="row">

		<%@ include file="teachersidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">View Home Work</span>
				</div>
				<div class="card-body">
					<div style="overflow: hidden;">
						<div class="form-group ">
							<div class="row justify-content-sm-center">
								<div class="col-md-6 col-offset-6">
									<div id="datetimepicker13" onchange="user1_change()"></div>
								</div>
							</div>
						</div>
						<script type="text/javascript">
							$(function() {
								$('#datetimepicker13').datetimepicker({
									inline : true,
									format : 'YYYY-MM-DD'
								});
							});
						</script>
					</div>

					<div class="row justify-content-sm-center mt-3">
						<div class="col-md-12">
							<div class="table-responsive table-striped table-bordered">
									<table class="table">
										<thead class="bg-info text-white text-uppercase">
											<tr>
												<th>Subject Name</th>
												<th>Class</th>
												<th>Section</th>
												<th>Name</th>
												<th>description</th>
												<th>Date</th>
											</tr>
										</thead>
										<tbody class="company11">
											
										</tbody>
									</table>
								</div>
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

<%@ include file="teacherfooter.jsp"%>
<script>
	function user1_change() {

		var user1 = $("#datetimepicker13").data().date;
		$.ajax({
			type : "Get",
			url : "WebGetTeacherHomeWork",
			data : "user_id=" + user1,
			cache : false,
			success : function(response) {
				$(".company11").html(response);
			}
		});
	}
</script>
