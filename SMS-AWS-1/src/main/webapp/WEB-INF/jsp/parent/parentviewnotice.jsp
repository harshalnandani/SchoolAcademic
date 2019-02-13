<%@ include file="parentheader.jsp"%>
<c:set var="notices" value="${requestScope.notices}" />

<div class="container-fluid">

	<div class="row">

		<%@ include file="parentsidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
		<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Notices</span>
				</div>
				<div class="card-body">
			<div class="table-responsive table-striped table-bordered">
				<table class="table">
					<thead class="bg-info text-white text-uppercase">
						<tr>
							<th>Notice</th>
							<th>TimeStamp</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="notice" items="${notices}" varStatus="counter">
							<tr>
								<td>${notice[2]}</td>
								<td>${notice[3]}</td>
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

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>