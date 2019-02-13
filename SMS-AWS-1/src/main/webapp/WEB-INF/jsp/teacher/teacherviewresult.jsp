<%@page import="software.amazon.ion.Span"%>
<%@page import="java.util.List"%>
<%@page import="com.amazonaws.services.athena.model.ResultSet"%>
<%@ include file="teacherheader.jsp"%>
<c:set var="subjects" value="${sessionScope.subjects}" scope="page" />
<c:set var="results" value="${sessionScope.results}" scope="page" />
<div class="container-fluid">

	<div class="row">

		<%@ include file="teachersidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">View Result</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebTeacherViewResult" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">

								<div class="col-sm-3 col-md-3">
									<select name="examId" class="form-control mb-2">
										<option selected disabled="disabled">Select Exam</option>
										<c:forEach var="exam" items="${exams}" varStatus="counter">
											<option value="${exam.getExamId()}">${exam.getExamName()}</option>
										</c:forEach>
									</select>
								</div>

								<div class="col-sm-3 col-md-3">
									<select name="classId" class="form-control mb-2 company1"
										onchange="user1_change()">
										<option selected disabled="disabled">Select Class</option>
										<c:forEach var="class1" items="${classes}" varStatus="counter">
											<option value="${class1[0]}">${class1[1]}</option>
										</c:forEach>
									</select>
								</div>

								<div class="col-sm-3 col-md-3">
									<select class="form-control mb-2 company11"
										onchange="user2_change()" name="sectionId">
										<option selected="selected">Select Section</option>
									</select>
								</div>
								<div class="col-sm-3 col-md-3">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Select</button>
								</div>
							</div>
						</div>
					</form>


					<div class="container-fluid">
						<div class="row justify-content-sm-center">
							<%
								int i = 0;
								int j = 0;
								List<Object[]> results = (List<Object[]>) session.getAttribute("results");
								List<String> subjects = (List<String>) session.getAttribute("subjects");
								if (subjects != null) {
									if (results == null) {
							%>
							<span>No Result Found</span>
							<%
								} else {
							%>
							<div class="table-responsive table-striped table-bordered">
								<table class="table">
									<thead class="bg-info text-white text-uppercase">
										<tr>
											<th>Student Name/Subject</th>
											<c:forEach var="subject" items="${subjects}"
												varStatus="counter">
												<th>${subject}</th>
											</c:forEach>
										</tr>
									</thead>
									<tbody>
										<%
											for (i = 0; i < results.size()/subjects.size(); i++) {
										%>
										<tr>
											<td><%=results.get(i)[0]%></td>
											<%
												j = 0;
															for (j = 0; j < subjects.size(); j++) {
											%>
											<td><%=results.get((i + (j*(results.size()/2))))[2]%></td>
											<%
												}
														}
											%>
										</tr>
										<%
											}
											}
										%>
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