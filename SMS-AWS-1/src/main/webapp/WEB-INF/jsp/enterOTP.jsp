<%@ include file="header.jsp"%>
<!-- Contact -->
<section id="loginmain">
	<div class="container-fluid ">
		<div class="row">
			<div class="col-md-6 offset-3" id="EnterOTP">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h2 class="section-heading text-uppercase">Enter OTP</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<form id="contactForm" name="sentMessage" novalidate="novalidate" method="post" action="ChangePass">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<input class="form-control" name="enteredOTP" type="text"
											placeholder="Enter OTP" required="required"
											data-validation-required-message="Please enter the details.">
										<p class="help-block text-danger"></p>
									</div>
								</div>
								<div class="clearfix"></div>
								<div class="col-lg-12 text-center">
									<div id="success"></div>
									<button id="sendMessageButton"
										class="btn btn-primary btn-xs text-uppercase" type="submit">Submit OTP</button>
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