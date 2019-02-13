<%@ include file="schoolheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" scope="page" />
<c:set var="exams" value="${requestScope.exams}" scope="page" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Exam Time Table</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddExamTimeTable"
						method="post" enctype="multipart/form-data">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-6 col-md-6">
									<select name="examId" class="form-control mb-2">
										<option selected disabled="disabled">Select Exam</option>
										<c:forEach var="exam" items="${exams}" varStatus="counter">
											<option value="${exam.getExamId()}">${exam.getExamName()}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-6 col-md-6">
									<select name="classId" class="form-control mb-2 company1">
										<option selected disabled="disabled">Select Class</option>
										<c:forEach var="class1" items="${classes}" varStatus="counter">
											<option value="${class1[0]}">${class1[1]}</option>
										</c:forEach>
									</select>
								</div>

								<div class="col-sm-6 col-md-6">
									<input type="file" class="form-control mb-2"
										placeholder="Insert Your File" name="file" required autofocus>
								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										placeholder="Discription" name="discription"></textarea>
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

