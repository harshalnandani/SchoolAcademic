<%@ include file="parentheader.jsp"%>
<c:set var="childrens" value="${childrens}" />
<!-- Page Content -->
<div class="container-fluid">
	<div class="row">

		<div class="col-md-3 nav-side-menu mt-3">
			<div class="brand">MENU</div>
			<i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse"
				data-target="#menu-content"></i>
			<div class="menu-list">
				<ul id="menu-content" class="menu-content collapse out">
					<li><a href="parenthome"> <i class="fa fa-dashboard fa-lg"></i>
							Dashboard
					</a></li>
					<li><a href="WebLogout"> <i class="fa fa-dashboard fa-lg"></i>
							Logout
					</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-9 mt-3">
			<div class="card border-info text-center">
				<div class="card-header bg-info text-white">
					<span class="form-Heading">Choose Profile</span>
				</div>
				<div class="card-body">
				<div class="row align-items-center mt-3 studentProfile">

				<c:forEach var="children" items="${childrens}" varStatus="counter">
					<div class="col-md-${Integer.valueOf(12/childrens.size())}">
						<div class="card1">

							<c:if test="${children[5]==null}">
								<img src="/images/Profile-icon-9.png" height="200px"
									width="150px" class="profilepicture">
							</c:if>
							<c:if test="${children[5]!=null}">
								<img src="${children[5]}" height="200px" width="150px"
									class="profilepicture">
							</c:if>
							<h3>${children[1]}</h3>
							<p class="title">${children[2]}/${children[3]}</p>
							<p>${children[4]}</p>
							<form action="WebParentSelectStudent" method="post">
								<p>
									<input type="hidden" name="studentId" value="${children[0]}">
									<button class="btn btn-lg btn-info btn-block">View</button>

								</p>
							</form>
						</div>

					</div>


				</c:forEach>
			</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- /.container -->

<%@ include file="parentfooter.jsp"%>