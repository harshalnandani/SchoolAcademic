<%@ include file="schoolheader.jsp"%>

<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add News</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddNews" method="post" enctype="multipart/form-data">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								
								
								<div class="col-sm-12 col-md-12">
									<input type="text" class="form-control mb-2"
										placeholder="Enter News Title" name="title" required
										autofocus>
								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2"
										placeholder="Enter News Body" name="newsBody"></textarea>
								</div>
								<div class="col-sm-12 col-md-12">
									<input type="file" class="form-control mb-2"
										placeholder="Insert Your File" name="file" required
										autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									<button class="btn btn-lg btn-info btn-block mb-1 mt-1"
										type="submit">Add News</button>
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