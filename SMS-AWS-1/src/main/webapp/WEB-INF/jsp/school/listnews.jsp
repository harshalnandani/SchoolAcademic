<%@ include file="schoolheader.jsp"%>
<c:set var="news"  value="${news}"/>

<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>Title</th>
						<th>News Body</th>
						<th>Date And Time</th>
						<th>Picture</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="news1" items="${news}" varStatus="counter">
						<tr>
							<td>${news1.getTitle()}</td>
							<td>${news1.getNewsBody()}</td>
							<td>${news1.getTimestamp()}</td>
							<td><a href="${news1.getPictureUrl()}" target="_blank">Picture</a></td>
							<td>
								
									<form method="Post" action="WebEditNews">
										<input type="hidden" value="1" name="actionId">
										<input type="hidden" value="${news1.getNewsId()}" name="newsId">
										<button type="submit" class="btn btn-info">Edit</button>
									</form>
								</td>
								<td>
									<form method="post" action="WebDeleteNews">
										<input type="hidden" value="${news1.getNewsId()}"
											name="newsId">
										<button type="submit" class="btn btn-danger">Delete</button>
									</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Title</th>
						<th>News Body</th>
						<th>Date And Time</th>
						<th>Picture</th>
						<th>Edit</th>
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