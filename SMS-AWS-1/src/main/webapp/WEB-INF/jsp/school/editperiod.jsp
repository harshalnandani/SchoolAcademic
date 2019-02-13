<%@ include file="schoolheader.jsp"%>
<c:set var="period" value="${requestScope.period}" scope="page" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Edit Period</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddPeriod" method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-12 col-md-12">
									<input  type="hidden" value="${period.getPeriodId()}" name="periodId">
									<input  type="hidden" value="2" name="actionId">
									<input type="text" class="form-control mb-2"
										value="${period.getName()}" name="name" required
										autofocus>
								</div>
								<div class="col-sm-6 col-md-6">
									   <div class="form-group">
                                        <div class="input-group date" id="datetimepicker3"
                                            data-target-input="nearest">
                                            <input type="text" class="form-control datetimepicker-input"
                                                data-target="#datetimepicker3" value="${period.getStartTime()}" name="startTime"/>
                                            <div class="input-group-append"
                                                data-target="#datetimepicker3" data-toggle="datetimepicker">
                                                <div class="input-group-text">
                                                    <i class="fa fa-clock-o"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

								</div>
								<div class="col-sm-6 col-md-6">
									   <div class="form-group">
                                        <div class="input-group date" id="datetimepicker2"
                                            data-target-input="nearest">
                                            <input type="text" class="form-control datetimepicker-input"
                                                data-target="#datetimepicker2"value="${period.getEndTime()}" name="endTime"/>
                                            <div class="input-group-append"
                                                data-target="#datetimepicker2" data-toggle="datetimepicker">
                                                <div class="input-group-text">
                                                    <i class="fa fa-clock-o"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

								</div>
								<div class="col-sm-6 col-md-4 col-offset-4">
									<button class="btn btn-lg btn-info btn-block mb-2"
										type="submit">Edit Period</button>
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

