<%@ include file="parentheader.jsp"%>
<c:set var="questionpapers" value="${requestScope.questionpapers}" />
<div class="container-fluid">

	<div class="row">

		<%@ include file="parentsidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Question Paper List</span>
				</div>
				<div class="card-body">
					<div class="table-responsive table-striped table-bordered">
						<table class="table">
							<thead class="bg-info text-white text-uppercase">
								<tr>
									<th>Subject Name</th>
									<th>description</th>
									<th>Download</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="questionpaper" items="${questionpapers}"
									varStatus="counter">

									<tr>
										<td>${questionpaper.getSubject().getSubjectName()}</td>
										<td>${questionpaper.getDiscription()}</td>
										<td><a
											href="${questionpaper.getFileUrl()}"
											target="_blank">Download</a></td>
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
<%@ include file="parentfooter.jsp"%>

