<%@ include file="schoolheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" scope="page" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Syllabus</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddSyllabus" method="post" enctype="multipart/form-data">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">

								<div class="col-sm-6 col-md-6">
									<select name="classId" class="form-control mb-2 company1">
										<option selected disabled="disabled">Select Class</option>
										<c:forEach var="class1" items="${classes}" varStatus="counter">
											<option value="${class1[0]}">${class1[1]}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-6 col-md-6">
									<select class="form-control mb-2" name="subjectId">
										<option selected disabled="disabled">Select
											Subject...</option>
										<c:set var="subjects" value="${requestScope.subjects}"
											scope="page" />
										<c:forEach var="subject" items="${subjects}"
											varStatus="counter">
											<option value="${subject[0]}">${subject[1]}</option>
										</c:forEach>
									</select>
								</div>
									
								<div class="col-sm-12 col-md-12">
									<input type="file" class="form-control mb-2"
										placeholder="Insert Your File" name="file" required
										autofocus>
								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										placeholder="Discription" name="discription"></textarea>
								</div>
								
								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Add Syllabus</button>
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

