<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.sms.timetable.TimeTableServiceImpl"%>
<%@page import="com.sms.beans.Period"%>
<%@page import="java.util.List"%>
<%@ include file="teacherheader.jsp"%>
<c:set var="classes" value="${requestScope.classes}" scope="page" />
<c:set var="periods" value="${sessionScope.periods}" scope="page" />
<div class="container-fluid pt-3">
	<div class="row justify-content-sm-center">
		<%@ include file="teachersidenavbar.jsp"%>
		<div class="col-sm-9 col-md-9">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
						<span class="form-Heading"> Select Class And Section</span>
				</div>
				<div class="card-body">
						<form class="form-signin" action="WebTeacherViewTimeTable" method="post">
							<div class="container-fluid">
								<div class="row justify-content-sm-center">
									<div class="col-sm-6 col-md-6">
										<select name="classId" class="form-control mb-2 company1"
											onchange="user1_change()">
											<option selected disabled="disabled">Select Class</option>
											<c:forEach var="class1" items="${classes}"
												varStatus="counter">
												<option value="${class1[0]}">${class1[1]}</option>
											</c:forEach>
										</select>
									</div>

									<div class="col-sm-6 col-md-6">
										<select class="form-control mb-2 company11" name="sectionId">
											<option selected="selected">Select Section</option>
										</select>
									</div>
									<div class="col-sm-6 col-md-4 col-offset-4">
										<button class="btn btn-lg btn-info btn-block mb-2"
											type="submit">Select</button>
									</div>
								</div>
							</div>
						</form>
						<%
						if(session.getAttribute("timetableobject")!=null && session.getAttribute("sectionId")!=null && session.getAttribute("periods")!=null){
							%>
						
						<div class="container-fluid">
							<div class="row justify-content-sm-center">
								<div class="col-sm-12 col-md-12">
									<div class="table-responsive table-striped table-bordered">
										<table class="table">
											<thead class="bg-info text-white text-uppercase">
												<tr >
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
												<%!
												int sectionId;
												TimeTableServiceImpl serviceImpl;
												List<Object[]> periods;
												%>
												
												<tr>
													<td class="bg-info text-white text-uppercase">Monday</td>
													<%
													sectionId=(Integer)session.getAttribute("sectionId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
													 periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDaySection((Integer)element[0], sectionId,"Monday");
														if(data.size()>0){
														%>
													<td>
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>
													</td>
													
													<%	
													}
													}
													%>
													
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Tuesday

													<%
													sectionId=(Integer)session.getAttribute("sectionId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
													 periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDaySection((Integer)element[0], sectionId,"Tuesday");
														if(data.size()>0){
														%>
													<td>
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>
													</td>
													
													<%	
														}
													}
													
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Wednesday

													</td>
													<%
													sectionId=(Integer)session.getAttribute("sectionId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
													 periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDaySection((Integer)element[0], sectionId,"Wednesday");
														if(data.size()>0){
														%>
													<td>
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>
													</td>
													
													<%	
														}
													}
													
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Thursday

													</td>
													<%
													sectionId=(Integer)session.getAttribute("sectionId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
													 periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDaySection((Integer)element[0], sectionId,"Thursday");
														if(data.size()>0){
														%>
													<td>
													
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>
													</td>
													
													<%	
														}
													}
													
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Friday</td>
													<%
													sectionId=(Integer)session.getAttribute("sectionId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
													 periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDaySection((Integer)element[0], sectionId,"Friday");
														if(data.size()>0){
														%>
													<td>
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>
													</td>
													
													<%	
														}
													}
													
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Saturday

													</td>
													<%
													sectionId=(Integer)session.getAttribute("sectionId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
												  periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDaySection((Integer)element[0], sectionId,"Saturday");
														if(data.size()>0){
														%>
													<td>
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>
													</td>
													
													<%	
													}
													}
													
													%>
												</tr>
											</tbody>
										</table>
									</div>
								</div>


							</div>
						</div>
						<%}
						%>
				</div>
			</div>
		</div>
	</div>
</div>

<br>
<br>
<br>

<%@ include file="teacherfooter.jsp"%>

<script>
	function user1_change() {

		var user1 = $(".company1").val();

		$.ajax({
			type : "Get",
			url : "WebGetSection",
			data : "user_id=" + user1,
			cache : false,
			success : function(response) {
				$(".company11").html(response);
			}
		});
	}
</script>