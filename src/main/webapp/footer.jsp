<!DOCTYPE html>
<jsp:useBean id="sitebean" scope="application" class="com.frcparts.Site" />
<footer>



	<div class="pure-g">
	<div class="pure-u-1-8"></div>
	<div class="pure-u-3-4" style="text-align: left">
		<br>
		<hr>
		<div class="pure-g">
			<div class="pure-u-1-2" style="text-align: left">
				<small><a href="http://jgermita.me" target="_blank">jgermita.me</a><br>
				<i>Disclaimer: Information not guaranteed to be up to date. <br>
					Information presented does not represent an official endorsement by any team. </i>
				</small>

			</div>
			<div class="pure-u-1-2" style="text-align: right">
				<small>
					<a href="https://docs.google.com/forms/d/e/1FAIpQLSeWyY8v3RgOty-MyWmh9U0iivNYN_molChYyS-0U-o-kOAv_g/viewform" target="_blank">send feedback</a><br>

					Current app build: <code><%= sitebean.sha %></code>

				</small>
			</div>
		</div>
	</div>
	<div class="pure-u-1-8"></div>
	</div>
	<br><br>


</footer>
