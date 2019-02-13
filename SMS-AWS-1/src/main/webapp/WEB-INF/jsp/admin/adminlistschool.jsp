<%@ include file="adminheader.jsp"%>
<c:set var="schools" value="${requestScope.schools}" />
<div class="container mt-3">
	<div class="row">
		<div class="col-md-12">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>Name</th>
						<th>Mobile Number</th>
						<th>Email Id</th>
					    <th>Address</th>
					    <th>Creation Date</th>
					    <th>Action</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="schoolData" items="${schools}" varStatus="counter">
					
						<tr>
							<td>${schoolData[1]}</td>
							<td>${schoolData[2]}</td>
							<td>${schoolData[3]}</td>
							<td>${schoolData[4]},${schoolData[5]},${schoolData[6]},${schoolData[7]},${schoolData[8]}-${schoolData[9]}</td>
							<td>${schoolData[10]}</td>
							<td>
									<form method="get" action="editschool">
										<input type="hidden" value="${schoolData[0]}"
											name="schoolId">
										<button type="submit" class="btn btn-info">Edit</button>
									</form>
							</td>
						</tr>
						
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Name</th>
						<th>Mobile Number</th>
						<th>Email Id</th>
					    <th>Address</th>
					    <th>Creation Date</th>
					     <th>Action</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>

<%@ include file="adminfooter.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>