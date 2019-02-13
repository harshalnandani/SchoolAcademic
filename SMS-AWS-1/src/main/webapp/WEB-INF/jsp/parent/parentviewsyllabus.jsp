<%@ include file="parentheader.jsp"%>
<c:set var="syallubus" value="${requestScope.syallubus}" />
<div class="container-fluid">
	<div class="row">
		<%@ include file="parentsidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Syllabus</span>
				</div>
				<div class="card-body">
				<object width="100%" height="600" data="${syallubus.getFileUrl()}"></object>
				</div>
			</div>



		</div>
	</div>

</div>
<%@ include file="parentfooter.jsp"%>

