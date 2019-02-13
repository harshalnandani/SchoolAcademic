<%@ include file="header.jsp"%>
<!-- Contact -->
<section id="loginmain">
	<div class="container-fluid ">
		<div class="row">
			<div class="col-md-6 offset-5" id="login">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h2 class="section-heading text-uppercase">Login</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<form id="contactForm" name="sentMessage" novalidate="novalidate" method="post" action="WebLogin">
							<div class="row">
								<div class="col-md-6 offset-3">
									<div class="form-group">
										<input class="form-control" name="username" type="text"
											placeholder="Your Username *" required="required"
											data-validation-required-message="Please enter your username.">
										<p class="help-block text-danger"></p>
									</div>
									<div class="form-group">
										<input class="form-control" name="password" type="password"
											placeholder="Your Password *" required="required"
											data-validation-required-message="Please enter your password.">
										<p class="help-block text-danger"></p>
									</div>
								</div>
								<div class="clearfix"></div>
								<div class="col-lg-12 text-center">
									<div id="success"></div>
									<button id="sendMessageButton"
										class="btn btn-primary btn-xs text-uppercase" type="submit">Login</button>
								</div>
								<br/><br/>
								<div class="col-lg-12 text-center">
									<div id="forgotPass"></div>
									<a href="/ForgPass">
									<button id="forgotPasswordButton"
										class="btn btn-primary btn-xs text-uppercase" type="button">Forgot Password</button></a>
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