<%@ include file="teacherheader.jsp"%>
<c:set var="news" value="${news}" />

<div class="container-fluid">

	<div class="row">

		<%@ include file="teachersidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">News</span>
				</div>
				<div class="card-body">
					<c:forEach var="news1" items="${news}" varStatus="counter">
						<figure class="snip1527 hover">
							<div class="image">
								<img
									src="${news1.getPictureUrl()}"
									alt="pr-sample24" />
							</div>
							<figcaption>
								<div class="date">
									<span class="day">${news1.getTimestamp().getDate()}</span><span class="month">${news1.getTimestamp().getMonth()} / ${news1.getTimestamp().getYear() + 1900}</span>
								</div>
								<h3>${news1.getTitle()}</h3>
								<p>${news1.getNewsBody()}</p>
							</figcaption>
						</figure>

					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="teacherfooter.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>