<%@ include file="schoolheader.jsp"%>

<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Event To Calendar</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddEventCalender" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">

								<div class="col-sm-6 col-md-6 col-offset-3">
								<input class="form-control"  name="eventName"
										placeholder="Enter Event Name Here" required autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<input type="text" class="form-control mb-2"
										placeholder="Event Date" name="eventDate" required autofocus
										onfocus="(this.type='date')">

								</div>
								<div class="col-sm-6 col-md-3 col-offset-3">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Add</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<br>
<br>
<br>

<%@ include file="schoolfooter.jsp"%>

