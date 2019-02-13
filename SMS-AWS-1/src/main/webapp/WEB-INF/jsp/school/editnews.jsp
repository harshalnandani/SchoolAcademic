<%@ include file="schoolheader.jsp"%>
<c:set var="news1" value="${news}" />
<c:if test="${news1==null}">
	<c:redirect url="/schoolhome" />
</c:if>
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Edit News</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebEditNews" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<input type="hidden" value="2" name="actionId"> <input
									type="hidden" name="newsId" value="${news1.getNewsId()}">

								<div class="col-sm-12 col-md-12">
									<input type="text" class="form-control mb-2"
										value="${news1.getTitle()}" name="title" required autofocus>
								</div>
								<div class="col-sm-12 col-md-12">
									<textarea class="form-control mb-2" rows="2" name="newsBody">${news1.getNewsBody()}</textarea>
								</div>
								<div class="col-sm-6 col-md-6">
									<button class="btn btn-lg btn-info btn-block mb-1 mt-1"
										type="submit">Edit News</button>
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