<%@ include file="schoolheader.jsp"%>
<c:set var="periods" value="${requestScope.periods}" scope="page" />
<c:set var="subjects" value="${requestScope.subjects}" scope="page" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Add Period To Subject</span>
				</div>
				<div class="card-body">
					<form class="form-signin" action="WebAddPeriodSubjectMapping"
						method="post">
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-12 col-md-12">
									<div class="table-responsive table-striped table-bordered">
										<table class="table">
											<thead class="bg-info text-white text-uppercase">
												<tr>
													<td rowspan="2">Day/Period</td>
													<c:forEach var="period" items="${periods}"
														varStatus="counter">
														<td>${period[1]}</td>
													</c:forEach>
												</tr>
											</thead>
											<tbody>
												<tr class="bg-info text-white text-uppercase">
													<td></td>
													<c:forEach var="period" items="${periods}"
														varStatus="counter">
														<td>${period[2]}-${period[2]}</td>
													</c:forEach>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Monday</td>

													<c:forEach var="period" items="${periods}"
														varStatus="counter">
														<input type="hidden" value="${period[0]}" name="periodId">
														<input type="hidden" value="Monday" name="dayOftheWeek">
														<td><select name="subjectId">
																<c:forEach var="subject" items="${subjects}"
																	varStatus="counter">
																	<option value="${subject[0]}">${subject[1]}</option>
																</c:forEach>
														</select></td>
													</c:forEach>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Tuesday

													</td>
													<c:forEach var="period" items="${periods}"
														varStatus="counter">
														<input type="hidden" value="${period[0]}" name="periodId">
														<input type="hidden" value="Tuesday" name="dayOftheWeek">
														<td><select name="subjectId">
																<c:forEach var="subject" items="${subjects}"
																	varStatus="counter">
																	<option value="${subject[0]}">${subject[1]}</option>
																</c:forEach>
														</select></td>
													</c:forEach>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Wednesday

													</td>
													<c:forEach var="period" items="${periods}"
														varStatus="counter">
														<input type="hidden" value="${period[0]}" name="periodId">
														<input type="hidden" value="Wednesday" name="dayOftheWeek">
														<td><select name="subjectId">
																<c:forEach var="subject" items="${subjects}"
																	varStatus="counter">
																	<option value="${subject[0]}">${subject[1]}</option>
																</c:forEach>
														</select></td>
													</c:forEach>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Thursday

													</td>
													<c:forEach var="period" items="${periods}"
														varStatus="counter">
														<input type="hidden" value="${period[0]}" name="periodId">
														<input type="hidden" value="Thursday" name="dayOftheWeek">
														<td><select name="subjectId">
																<c:forEach var="subject" items="${subjects}"
																	varStatus="counter">
																	<option value="${subject[0]}">${subject[1]}</option>
																</c:forEach>
														</select></td>
													</c:forEach>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Friday</td>
													<c:forEach var="period" items="${periods}"
														varStatus="counter">
														<input type="hidden" value="${period[0]}" name="periodId">
														<input type="hidden" value="Friday" name="dayOftheWeek">
														<td><select name="subjectId">
																<c:forEach var="subject" items="${subjects}"
																	varStatus="counter">
																	<option value="${subject[0]}">${subject[1]}</option>
																</c:forEach>
														</select></td>
													</c:forEach>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Saturday

													</td>
													<c:forEach var="period" items="${periods}"
														varStatus="counter">
														<input type="hidden" value="${period[0]}" name="periodId">
														<input type="hidden" value="Saturday" name="dayOftheWeek">
														<td><select name="subjectId">
																<c:forEach var="subject" items="${subjects}"
																	varStatus="counter">
																	<option value="${subject[0]}">${subject[1]}</option>
																</c:forEach>
														</select></td>
													</c:forEach>
												</tr>
											</tbody>
										</table>
									</div>
								</div>



								<div class="col-sm-6 col-md-4 col-offset-4 mt-3">
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

