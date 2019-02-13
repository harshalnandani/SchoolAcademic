<%@ include file="schoolheader.jsp"%>
<c:set var="subject" value="${requestScope.subject}" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Subject-
						${subject.getSubjectName()}</span>
				</div>
				<div class="card-body">
					<div class="container-fluid">
						<div class="row justify-content-sm-center">

							<div class="col-sm-12 col-md-12 viewclass">
								

								<button class="accordion">Question Paper</button>
								<div class="panel">
									<div class="table-responsive table-striped table-bordered">
										<table class="table">
											<thead class="bg-info text-white text-uppercase">
												<tr>
													<th>Subject</th>
													<th>File Name</th>
													<th>File Type</th>
													<th>Discription</th>
													<th>Download</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="questionPaper"
													items="${subject.getQuestionPapers()}" varStatus="counter">
													<tr>
														<td>${questionPaper.getSubject().getSubjectName()}</td>
														<td>${questionPaper.getFileName()}</td>
														<td>${questionPaper.getFileType()}</td>
														<td>${questionPaper.getDiscription()}</td>
														<td><a
															href="data:${questionPaper.getFileType()};base64,${questionPaper.getBase64Encoded()}"
															download>Download</a></td>
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
													<th>File Name</th>
													<th>File Type</th>
													<th>Discription</th>
													<th>Download</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="syllabus" items="${subject.getSyllabus()}"
													varStatus="counter">
													<tr>
														<td>${syllabus.getSubject().getSubjectName()}</td>
														<td>${syllabus.getFileName()}</td>
														<td>${syllabus.getFileType()}</td>
														<td>${syllabus.getDiscription()}</td>
														<td><a
															href="data:${syllabus.getFileType()};base64,${questionPaper.getBase64Encoded()}"
															download>Download</a></td>
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
