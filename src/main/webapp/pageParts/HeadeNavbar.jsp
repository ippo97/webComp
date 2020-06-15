	<!-- IMPOSTRANTE PER FAR FUNZIONARE JSTL -->
	<%@ page isELIgnored="false" %>
	<!-- IMPOSTRANTE PER FAR FUNZIONARE JSTL -->
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- HEADER -->
	<header>
		<!-- header -->
		<div id="header">
			<div class="container">
				<div class="pull-left">
					<!-- Logo -->
					<div class="header-logo">
						<a class="logo" href="#">
							<img src="./img/logo.png" alt="">
						</a>
					</div>
					<!-- /Logo -->
					<!-- Search -->
					<div class="header-search">
						<form>
							<input class="input search-input" type="text" placeholder="Cerca la tua auto">
							<button class="search-btn"><i class="fa fa-search"></i></button>
						</form>
					</div>
					<!-- /Search -->
				</div>
				<div class="pull-right">
					<ul class="header-btns">
						<!-- Account -->
						<li class="header-account dropdown default-dropdown">
							<div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
								<div class="header-btns-icon">
									<i class="fa fa-user-o"></i>
								</div>
								<strong class="text-uppercase">My Account <i class="fa fa-caret-down"></i></strong>
							</div>
							<!-- Gestione Login -->
							<c:if test="${not empty email}">
							<a href="LogOutController" class="text-uppercase">LogOut</a> 
							</c:if>
							
							<c:if test="${empty email}">
							<a href="LoginController" class="text-uppercase">Login</a> / <a href="InserisciPersonaController" class="text-uppercase">Sign In</a>
							</c:if>
							<!-- Gestione Login -->
							<ul class="custom-menu">
								<li><a href="#"><i class="fa fa-exchange"></i> Compare</a></li>
								<li><a href="LogOutController"><i class="fa fa-check"></i> LogOut</a></li>
								<li><a href="LoginController"><i class="fa fa-unlock-alt"></i> Login</a></li>
								<li><a href="InserisciPersonaController"><i class="fa fa-user-plus"></i> Crea un Account</a></li>
							</ul>
						</li>
						<!-- /Account -->
						
						<!-- Mobile nav toggle-->
						<li class="nav-toggle">
							<button class="nav-toggle-btn main-btn icon-btn"><i class="fa fa-bars"></i></button>
						</li>
						<!-- / Mobile nav toggle -->
					</ul>
				</div>
			</div>
			<!-- header -->
		</div>
		<!-- container -->
	</header>
	<!-- /HEADER -->

	<!-- NAVIGATION -->
	<div id="navigation">
		<!-- container -->
		<div class="container">
			<div id="responsive-nav">
			<!-- menu nav -->
				<div class="menu-nav">
					<span class="menu-header">Menu <i class="fa fa-bars"></i></span>
					<ul class="menu-list">
						<li><a href="indexAstaController">Home</a></li>
						<li><a href="InserisciAnnuncioController">Inserisci Annuncio</a></li>
						<li><a href="InserisciastaController">Inserisci Asta</a></li>
						
						<li><a href="#">Sales</a></li>
						<li class="dropdown default-dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">Pagine (UTILISSIME) <i class="fa fa-caret-down"></i></a>
							<ul class="custom-menu">
								<li><a href="products.jsp">Products</a></li>
								<li><a href="product-page.jsp">Product Details</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<!-- menu nav -->
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /NAVIGATION -->
