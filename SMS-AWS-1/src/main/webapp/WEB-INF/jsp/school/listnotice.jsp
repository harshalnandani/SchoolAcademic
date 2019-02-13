<%@ include file="schoolheader.jsp"%>
<c:set var="notices" value="${requestScope.notices}" />

<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>Class</th>
						<th>Section</th>
						<th>Notice</th>
						<th>TimeStamp</th>
						<th>Type</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="notice" items="${notices}" varStatus="counter">
						<tr>
							<td>${notice[0]}</td>
							<td>${notice[1]}</td>
							<td>${notice[2]}</td>
							<td>${notice[3]}</td>
							<td>${notice[4]}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Class</th>
						<th>Section</th>
						<th>Notice</th>
						<th>TimeStamp</th>
						<th>Type</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>

<%@ include file="schoolfooter.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>