<%@page import="com.sms.beans.Section"%>
<%@page import="java.util.List"%>
<%@page import="com.sms.timetable.TimeTableServiceImpl"%>
<%@ include file="schoolheader.jsp"%>
<c:set var="section1" value="${requestScope.sections}" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="schoolsidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Class / Section -
						${section1.getClass1().getClassName()} /
						${section1.getSectionName()}</span>
				</div>
				<div class="card-body">
					<div class="container-fluid">
						<div class="row justify-content-sm-center">

							<div class="col-sm-12 col-md-12 viewclass">
								<button class="accordion">Students</button>
								<div class="panel">
									<table id="example" class="table table-striped table-bordered"
										style="width: 100%">
										<thead>
											<tr>
												<th>Name</th>
												<th>Gender</th>
												<th>DOB</th>
												<th>Father's Name</th>
												<th>View</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="student" items="${section1.getStudents()}"
												varStatus="counter">
												<tr>
													<td>${student.getStudentName()}</td>
													<td>${student.getGender()}</td>
													<td>${student.getDateOfBirth()}</td>
													<td>${student.getParent().getFathersName()}</td>

													<td>
														<button type="button" class="btn btn-success"
															data-toggle="modal"
															data-target="#myModal${student.getStudentId()}">View</button>
														<!-- The Modal -->
														<div class="modal fade"
															id="myModal${student.getStudentId()}">
															<div class="modal-dialog modal-lg">
																<div class="modal-content">
																	<!-- Modal body -->
																	<div class="modal-body">
																		<div class="container-fluid">
																			<div class="row justify-content-sm-center">
																				<div class="col-md-4">
																					<c:if
																						test="${student.getProfilePictureUrl()==null}">
																						<img src="/images/Profile-icon-9.png"
																							height="200px" width="200px"
																							class="profilepicture">
																					</c:if>
																					<c:if
																						test="${student.getProfilePictureUrl()!=null}">
																						<img src="${student.getProfilePictureUrl()}"
																							height="200px" width="200px"
																							class="profilepicture">
																					</c:if>

																				</div>
																				<div class="col-md-8">

																					<h4 class="name text-center">${student.getStudentName()}
																					</h4>

																					<div class="profile-user-info">
																						<div class="profile-info-row">
																							<div class="profile-info-name">Class/Section</div>

																							<div class="profile-info-value">
																								<span>${student.getSection().getClass1().getClassName()}/${student.getSection().getSectionName()}</span>
																							</div>
																						</div>
																						<div class="profile-info-row">
																							<div class="profile-info-name">Date Of
																								Birth</div>

																							<div class="profile-info-value">
																								<span>${student.getDateOfBirth()}</span>
																							</div>
																						</div>

																						<div class="profile-info-row">
																							<div class="profile-info-name">Gender</div>
																							<div class="profile-info-value">
																								<span>${student.getGender()}</span>
																							</div>

																						</div>

																						<div class="profile-info-row">
																							<div class="profile-info-name">Father's
																								Name</div>

																							<div class="profile-info-value">
																								<span>${student.getParent().getFathersName()}</span>
																							</div>
																						</div>

																						<div class="profile-info-row">
																							<div class="profile-info-name">Mother's
																								Name</div>

																							<div class="profile-info-value">
																								<span>${student.getParent().getMothersName()}</span>
																							</div>
																						</div>

																						<div class="profile-info-row">
																							<div class="profile-info-name">Mobile
																								Number</div>

																							<div class="profile-info-value">
																								<span>${student.getParent().getLogin().getMobileNumber()}</span>
																							</div>
																						</div>

																						<div class="profile-info-row">
																							<div class="profile-info-name">Email Id</div>

																							<div class="profile-info-value">
																								<span>${student.getParent().getLogin().getEmailId()}</span>
																							</div>
																						</div>

																					</div>
																				</div>
																			</div>
																			<hr>
																			<div class="row justify-content-sm-center">
																				<div class="col-md-6">
																					<div class="profile-user-info">
																						<div class="profile-info-row">
																							<div class="profile-info-name">Address Line
																								1</div>

																							<div class="profile-info-value">
																								<span>${student.getAddressLine1()}</span>
																							</div>
																						</div>
																						<div class="profile-info-row">
																							<div class="profile-info-name">City</div>

																							<div class="profile-info-value">
																								<span>${student.getCity()}</span>
																							</div>
																						</div>
																						<div class="profile-info-row">
																							<div class="profile-info-name">State</div>

																							<div class="profile-info-value">
																								<span>${student.getState()}</span>
																							</div>
																						</div>
																					</div>
																				</div>
																				<div class="col-md-6">
																					<div class="profile-user-info">

																						<div class="profile-info-row">
																							<div class="profile-info-name">Address Line
																								2</div>

																							<div class="profile-info-value">
																								<span>${student.getAddressLine2()}</span>
																							</div>
																						</div>

																						<div class="profile-info-row">
																							<div class="profile-info-name">District</div>

																							<div class="profile-info-value">
																								<span>${student.getDistrict()}</span>
																							</div>
																						</div>

																						<div class="profile-info-row">
																							<div class="profile-info-name">Pincode</div>

																							<div class="profile-info-value">
																								<span>${student.getPinCode()}</span>
																							</div>
																						</div>
																					</div>
																				</div>
																			</div>

																		</div>



																	</div>
																</div>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>





										</tbody>
										<tfoot>
											<tr>
												<th>Name</th>
												<th>Gender</th>
												<th>DOB</th>
												<th>Father's Name</th>
												<th>View</th>
											</tr>
										</tfoot>
									</table>
								</div>



								<button class="accordion">Time Table</button>
								<div class="panel">
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
													<td>Timing</td>
													<c:forEach var="period" items="${periods}"
														varStatus="counter">
														<td>${period[2]}-${period[2]}</td>
													</c:forEach>
												</tr>
												<%!int sectionId;
	TimeTableServiceImpl serviceImpl;
	List<Object[]> periods;
	Section section;%>

												<tr>
													<td class="bg-info text-white text-uppercase">Monday</td>
													<%
														section = (Section) request.getAttribute("sections");
														sectionId = section.getSectionId();
														serviceImpl = (TimeTableServiceImpl) session.getAttribute("timetableobject");
														periods = (List<Object[]>) session.getAttribute("periods");
														for (Object[] element : periods) {
															List<Object[]> data = serviceImpl.getTimeTableByPeriodDaySection((Integer) element[0], sectionId,
																	"Monday");
															if (data.size() > 0) {
													%>
													<td><%=data.get(0)[0]%><br> <%=data.get(0)[1]%></td>

													<%
														}
														}
													%>

												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Tuesday

														<%
														section = (Section) request.getAttribute("sections");
														sectionId = section.getSectionId();
														serviceImpl = (TimeTableServiceImpl) session.getAttribute("timetableobject");
														periods = (List<Object[]>) session.getAttribute("periods");
														for (Object[] element : periods) {
															List<Object[]> data = serviceImpl.getTimeTableByPeriodDaySection((Integer) element[0], sectionId,
																	"Tuesday");
															if (data.size() > 0) {
													%>
													
													<td><%=data.get(0)[0]%><br> <%=data.get(0)[1]%></td>

													<%
														}
														}
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Wednesday

													</td>
													<%
														section = (Section) request.getAttribute("sections");
														sectionId = section.getSectionId();
														serviceImpl = (TimeTableServiceImpl) session.getAttribute("timetableobject");
														periods = (List<Object[]>) session.getAttribute("periods");
														for (Object[] element : periods) {
															List<Object[]> data = serviceImpl.getTimeTableByPeriodDaySection((Integer) element[0], sectionId,
																	"Wednesday");
															if (data.size() > 0) {
													%>
													<td><%=data.get(0)[0]%><br> <%=data.get(0)[1]%></td>

													<%
														}
														}
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Thursday

													</td>
													<%
														section = (Section) request.getAttribute("sections");
														sectionId = section.getSectionId();
														serviceImpl = (TimeTableServiceImpl) session.getAttribute("timetableobject");
														periods = (List<Object[]>) session.getAttribute("periods");
														for (Object[] element : periods) {
															List<Object[]> data = serviceImpl.getTimeTableByPeriodDaySection((Integer) element[0], sectionId,
																	"Thursday");
															if (data.size() > 0) {
													%>
													<td><%=data.get(0)[0]%><br> <%=data.get(0)[1]%></td>

													<%
														}
														}
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Friday</td>
													<%
														section = (Section) request.getAttribute("sections");
														sectionId = section.getSectionId();
														serviceImpl = (TimeTableServiceImpl) session.getAttribute("timetableobject");
														periods = (List<Object[]>) session.getAttribute("periods");
														for (Object[] element : periods) {
															List<Object[]> data = serviceImpl.getTimeTableByPeriodDaySection((Integer) element[0], sectionId,
																	"Friday");
															if (data.size() > 0) {
													%>
													<td><%=data.get(0)[0]%><br> <%=data.get(0)[1]%></td>

													<%
														}
														}
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Saturday

													</td>
													<%
														section = (Section) request.getAttribute("sections");
														sectionId = section.getSectionId();
														serviceImpl = (TimeTableServiceImpl) session.getAttribute("timetableobject");
														periods = (List<Object[]>) session.getAttribute("periods");
														for (Object[] element : periods) {
															List<Object[]> data = serviceImpl.getTimeTableByPeriodDaySection((Integer) element[0], sectionId,
																	"Saturday");
															if (data.size() > 0) {
													%>
													<td><%=data.get(0)[0]%><br> <%=data.get(0)[1]%></td>

													<%
														}
														}
													%>
												</tr>
											</tbody>
										</table>
									</div>
								</div>

								<button class="accordion">Home Work</button>
								<div class="panel">
									<div style="overflow: hidden;">
										<div class="form-group ">
											<div class="row justify-content-sm-center">
												<div class="col-md-6 col-offset-6">
													<div id="datetimepicker13" onchange="user1_change()"></div>
												</div>
											</div>
										</div>
										<script type="text/javascript">
											$(function() {
												$('#datetimepicker13')
														.datetimepicker(
																{
																	inline : true,
																	format : 'YYYY-MM-DD'
																});
											});
										</script>
									</div>
									
									<div class="row justify-content-sm-center mt-3">
						<div class="col-md-12">
							<div class="table-responsive table-striped table-bordered">
									<table class="table">
										<thead class="bg-info text-white text-uppercase">
											<tr>
												<th>Subject Name</th>
												<th>Name</th>
												<th>description</th>
												<th>Date</th>
											</tr>
										</thead>
										<tbody class="company11">
											
										</tbody>
									</table>
								</div>
						</div>
					</div>
								</div>

								<button class="accordion">Notice</button>
								<div class="panel">
									<div class="table-responsive table-striped table-bordered">
										<table class="table">
											<thead class="bg-info text-white text-uppercase">
												<tr>
													<th>Notice</th>
													<th>Date And Time</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="notice1" items="${section1.getNotices()}"
													varStatus="counter">
													<tr>
														<td>${notice1.getNotice()}</td>
														<td>${notice1.getTimestamp()}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>

								<button class="accordion">Subject/Teacher</button>
								<div class="panel">
									<div class="table-responsive table-striped table-bordered">
										<table class="table">
											<thead class="bg-info text-white text-uppercase">
												<tr>
													<th>Subject</th>
													<th>Teacher</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="entry" items="${section1.getSubjects()}">
													<tr>
														<td>${entry.key.getSubjectName()}</td>
														<td>${entry.value.getTeacherName()}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>


							</div>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>

<br>
<br>
<br>

<%@ include file="schoolfooter.jsp"%>
<script>
	function user1_change() {

		var user1 = $("#datetimepicker13").data().date;
		$.ajax({
			type : "Get",
			url : "WebGetSectionHomeWork?sectionId=${section1.getSectionId()}",
			data : "user_id=" + user1,
			cache : false,
			success : function(response) {
				$(".company11").html(response);
			}
		});
	}
</script>
<script>
	var acc = document.getElementsByClassName("accordion");
	var i;

	for (i = 0; i < acc.length; i++) {
		acc[i].addEventListener("click", function() {
			this.classList.toggle("active");
			var panel = this.nextElementSibling;
			if (panel.style.maxHeight) {
				panel.style.maxHeight = null;
			} else {
				panel.style.maxHeight = panel.scrollHeight + "px";
			}
		});
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
