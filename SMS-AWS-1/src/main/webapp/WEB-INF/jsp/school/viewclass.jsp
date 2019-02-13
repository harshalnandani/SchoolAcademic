<%@ include file="schoolheader.jsp"%>
<c:set var="class1" value="${requestScope.class1}" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Class - ${class1.getClassName()}</span>
				</div>
				<div class="card-body">
					<div class="container-fluid">
						<div class="row justify-content-sm-center">

							<div class="col-sm-12 col-md-12 viewclass">
								<button class="accordion">Section</button>
								<div class="panel">
									<div class="table-responsive table-striped table-bordered">
										<table class="table">
											<thead class="bg-info text-white text-uppercase">
												<tr>
													<th>Name</th>
													<th>View</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="section" items="${class1.getSections()}"
													varStatus="counter">
													<tr>
														<td>${section.getSectionName()}</td>
														<td><a
															href="viewsection?sectionId=${section.getSectionId()}"><button
																	type="submit" class="btn btn-success">View</button></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>

								<button class="accordion">Question Paper</button>
								<div class="panel">
									<div class="table-responsive table-striped table-bordered">
										<table class="table">
											<thead class="bg-info text-white text-uppercase">
												<tr>
													<th>Subject</th>
													<th>Discription</th>
													<th>Download</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="questionPaper"
													items="${class1.getQuestionPapers()}" varStatus="counter">
													<tr>
														<td>${questionPaper.getSubject().getSubjectName()}</td>
														<td>${questionPaper.getDiscription()}</td>
														<td><a href="${questionPaper.getFileUrl()}" download>Download</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>

								<button class="accordion">Syllabus</button>
								<div class="panel">
									<div class="table-responsive table-striped table-bordered">
										<table class="table">
											<thead class="bg-info text-white text-uppercase">
												<tr>
													<th>Subject</th>
													<th>Discription</th>
													<th>Download</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="syllabus" items="${class1.getSyllabus()}"
													varStatus="counter">
													<tr>
														<td>${syllabus.getSubject().getSubjectName()}</td>
														<td>${syllabus.getDiscription()}</td>
														<td><a href="${syllabus.getFileUrl()}" download>Download</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>

								<button class="accordion">Exam Time Table</button>
								<div class="panel">
									<div class="table-responsive table-striped table-bordered">
										<table class="table">
											<thead class="bg-info text-white text-uppercase">
												<tr>
													<th>Exam</th>
													<th>Description</th>
													<th>Download</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="questionPaper"
													items="${class1.getExamTimeTables()}" varStatus="counter">
													<tr>
														<td>${questionPaper.getExam().getExamName()}</td>
														<td>${questionPaper.getDiscription()}</td>
														<td><a href="${questionPaper.getFileUrl()}" download>Download</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>

								<button class="accordion">Notice</button>
								<div class="panel">
									<div class="table-responsive table-striped table-bordered">
										<table class="table">
											<thead class="bg-info text-white text-uppercase">
												<tr>
													<th>Notice</th>
													<th>Date And Time</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="notice1" items="${class1.getNotices()}"
													varStatus="counter">
													<tr>
														<td>${notice1.getNotice()}</td>
														<td>${notice1.getTimestamp()}</td>
													</tr>
												</c:forEach>
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
	</div>
</div>

<br>
<br>
<br>

<%@ include file="schoolfooter.jsp"%>
<script>
	var acc = document.getElementsByClassName("accordion");
	var i;

	for (i = 0; i < acc.length; i++) {
		acc[i].addEventListener("click", function() {
			this.classList.toggle("active");
			var panel = this.nextElementSibling;
			if (panel.style.maxHeight) {
				panel.style.maxHeight = null;
			} else {
				panel.style.maxHeight = panel.scrollHeight + "px";
			}
		});
	}
</script>
