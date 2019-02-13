<%@ include file="schoolheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" />
<c:set var="eventCalenders"  value="${requestScope.eventCalenders}"/>
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>Event Date</th>
						<th>Event Name</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="eventCalender" items="${eventCalenders}" varStatus="counter">
						<tr>
							<td>${eventCalender[1]}</td>
							<td>${eventCalender[2]}</td>
							<td>
									<form method="post" action="WebDeleteEventCalender">
										<input type="hidden" value="${eventCalender[0]}"
											name="eventCalenderId">
										<button type="submit" class="btn btn-danger">Delete</button>
									</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Event Date</th>
						<th>Event Name</th>
						<th>Delete</th>
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