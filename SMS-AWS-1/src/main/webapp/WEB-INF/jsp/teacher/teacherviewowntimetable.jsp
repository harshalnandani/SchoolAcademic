<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.sms.timetable.TimeTableServiceImpl"%>
<%@page import="com.sms.beans.Period"%>
<%@page import="java.util.List"%>
<%@ include file="teacherheader.jsp"%>
<c:set var="periods" value="${sessionScope.periods}" scope="page" />
<div class="container-fluid">

	<div class="row">

		<%@ include file="teachersidenavbar.jsp"%>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-body">
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
												int teacherId;
												TimeTableServiceImpl serviceImpl;
												List<Object[]> periods;
												%>
												
												<tr>
													<td class="bg-info text-white text-uppercase">Monday</td>
													<%
													teacherId=(Integer)session.getAttribute("teacherId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
													 periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDayTeacher((Integer)element[0],teacherId,"Monday");
														%>
													<td>
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>/<%=data.get(0)[2]%>
													</td>
													
													<%	
													}
													
													%>
													
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Tuesday

													<%
													teacherId=(Integer)session.getAttribute("teacherId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
													 periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDayTeacher((Integer)element[0], teacherId,"Tuesday");
														%>
													<td>
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>/<%=data.get(0)[2]%>
													</td>
													
													<%	
													}
													
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Wednesday

													</td>
													<%
													teacherId=(Integer)session.getAttribute("teacherId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
													 periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDayTeacher((Integer)element[0], teacherId,"Wednesday");
														%>
													<td>
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>/<%=data.get(0)[2]%>
													</td>
													
													<%	
													}
													
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Thursday

													</td>
													<%
													teacherId=(Integer)session.getAttribute("teacherId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
													 periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDayTeacher((Integer)element[0], teacherId,"Thursday");
														%>
													<td>
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>/<%=data.get(0)[2]%>
													</td>
													
													<%	
													}
													
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Friday</td>
													<%
													teacherId=(Integer)session.getAttribute("teacherId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
													 periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDayTeacher((Integer)element[0], teacherId,"Friday");
														%>
													<td>
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>/<%=data.get(0)[2]%>
													</td>
													
													<%	
													}
													
													%>
												</tr>
												<tr>
													<td class="bg-info text-white text-uppercase">Saturday

													</td>
													<%
													teacherId=(Integer)session.getAttribute("teacherId");
													serviceImpl=(TimeTableServiceImpl)session.getAttribute("timetableobject");
												  periods=(List<Object[]>)session.getAttribute("periods");
													for (Object[] element : periods) {
														List<Object[]> data=serviceImpl.getTimeTableByPeriodDayTeacher((Integer)element[0], teacherId,"Saturday");
														%>
													<td>
													<%=data.get(0)[0]%><br>
													<%=data.get(0)[1]%>/<%=data.get(0)[2]%>
													</td>
													
													<%	
													}
													
													%>
												</tr>
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

<br>
<br>
<br>

<%@ include file="teacherfooter.jsp"%>