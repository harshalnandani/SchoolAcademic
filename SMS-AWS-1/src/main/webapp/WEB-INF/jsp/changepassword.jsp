<%@ include file="header.jsp"%>
<!-- Contact -->
<section id="loginmain">
	<div class="container-fluid ">
		<div class="row">
			<div class="col-md-6 offset-3" id="changepassword">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h2 class="section-heading text-uppercase">Change Password</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<form id="contactForm" name="sentMessage" novalidate="novalidate" method="post" action="NewPass">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<input class="form-control" name="newpassword" type="password"
											placeholder="Enter new password here" required="required"
											data-validation-required-message="Please enter the details.">
										<p class="help-block text-danger"></p>
									</div>
								</div>
								<div class="clearfix"></div>
								<div class="col-lg-12 text-center">
									<div id="success"></div>
									<button id="sendMessageButton"
										class="btn btn-primary btn-xs text-uppercase" type="submit">Change Password</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="footer.jsp"%>