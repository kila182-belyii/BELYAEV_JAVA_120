<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
<title><@spring.message 'bike_shop'/></title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link href="/css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href='http://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400' rel='stylesheet' type='text/css'>
	<link href="css/nav.css" rel="stylesheet" type="text/css" media="all"/>

	<script src="/js/jquery.min.js"></script>
	<script type="application/x-javascript">
	addEventListener("load",
			function() { setTimeout(hideURLbar, 0); }, false);
	function hideURLbar(){ window.scrollTo(0,1); }
	</script>
	<script src="js/jquery.easydropdown.js"></script>
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
			});
		});
	</script>

</head>
<body>
<!--banner-->
<script src="js/responsiveslides.min.js"></script>
<script>  
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true
      });
    });
  </script>
<div class="banner-bg banner-bg1">	
	  <div class="container">
			 <div class="header">
			       <div class="logo">
						 <a href="/index"><img src="images/logo.png" alt=""/></a>
				   </div>
				 <div class="top-nav">
					 <label class="mobile_menu" for="mobile_menu">
						 <span><@spring.message 'menu'/></span>
					 </label>
					 <input id="mobile_menu" type="checkbox">
					 <ul class="nav">
						 <li class="dropdown1"><a href="/bicycles"><@spring.message 'bicycles'/></a>
							 <ul class="dropdown2">
								 <li><a href="/bicycles"><@spring.message 'fixed/single_speed'/></a></li>
								 <li><a href="/bicycles"><@spring.message 'city_bikes'/></a></li>
								 <li><a href="/bicycles"><@spring.message 'premium_series'/></a></li>
							 </ul>
						 </li>
						 <li class="dropdown1"><a href="/parts"><@spring.message 'parts'/></a>
							 <ul class="dropdown2">
								 <li><a href="/parts"><@spring.message 'chains'/></a></li>
								 <li><a href="/parts"><@spring.message 'tubes'/></a></li>
								 <li><a href="/parts"><@spring.message 'tires'/></a></li>
								 <li><a href="/parts"><@spring.message 'disk_breaks'/></a></li>
							 </ul>
						 </li>
						 <li class="dropdown1"><a href="/accessories"><@spring.message 'accessories'/></a>
							 <ul class="dropdown2">
								 <li><a href="/accessories"><@spring.message 'locks'/></a></li>
								 <li><a href="/accessories"><@spring.message 'helmets'/></a></li>
								 <li><a href="/accessories"><@spring.message 'arm_covers'/></a></li>
								 <li><a href="/accessories"><@spring.message 'jerseys'/></a></li>
							 </ul>
						 </li>
						 <li class="dropdown1"><a href="/404"><@spring.message 'extras'/></a>
							 <ul class="dropdown2">
								 <li><a href="/404"><@spring.message 'classic_bell'/></a></li>
								 <li><a href="/404"><@spring.message 'bottle_cage'/></a></li>
								 <li><a href="/404"><@spring.message 'truck_grip'/></a></li>
							 </ul>
						 </li>
						 <li class="dropdown1"><a href="/404"><@spring.message 'menu'/></a>
							 <ul class="dropdown2">
								 <li><a href="?lang=ru">Русский</a></li>
								 <li><a href="?lang=en">English</a></li>
								 <li><a href="/chat"><@spring.message 'chat'/></a></li>
								 <li><a href="/profile"><@spring.message 'profile'/></a></li>
								 <li><a href="/logout"><@spring.message 'logout'/></a></li>
								 <#if user.role == 'ADMIN'>
									 <li><a href="/users"><@spring.message 'users'/></a></li>
									 <li><a href="/users/carts"><@spring.message 'carts'/></a></li>
								 </#if>
							 </ul>
						 </li>
						  <a class="shop" href="/cart"><img src="images/cart.png" alt=""/></a>
					  </ul>
				 </div>
				 <div class="clearfix"></div>
			 </div>
	  </div>	 
	 <div class="caption">
		 <div class="slider">
					   <div class="callbacks_container">
						   <ul class="rslides" id="slider">
							    <li><h1>HANDMADE BICYCLES></h1></li>
								<li><h1>SPEED BICYCLES</h1></li>
								<li><h1>MOUINTAIN BICYCLES</h1></li>
						  </ul>
						  <p>You <span>create</span> the <span>journey,</span> we supply the <span>parts</span></p>
						  <a class="morebtn" href="/bicycles"><@spring.message 'bike_shop'/></a>
					  </div>
				  </div>
	 </div>
	 <div class="dwn">
		<a class="scroll" href="#cate"><img src="/images/scroll.png" alt=""/></a>
	 </div>				 
</div>
<!--/banner-->
<div id="cate" class="categories">
	 <div class="container">
		 <h3>CATEGORIES</h3>
		 <div class="categorie-grids">
			 <a href="/bicycles"><div class="col-md-4 cate-grid grid1">
				 <h4>FIXED / SINGLE SPEED</h4>
				 <p>Are you ready for the 27.5 Revloution ?</p>
				 <a class="store" href="/bicycles">GO TO STORE</a>
			 </div></a>
			 <a href="/bicycles"><div class="col-md-4 cate-grid grid2">
				 <h4>PREMIMUM SERIES</h4>
				 <p>Exclusive Bike Components</p>
				 <a class="store" href="/bicycles">GO TO STORE</a>
			 </div></a>
			 <a href="/bicycles"><div class="col-md-4 cate-grid grid3">
				 <h4>CITY BIKES</h4>
				 <p>Street Playground</p>
				 <a class="store" href="/bicycles">GO TO STORE</a>
			 </div></a>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>
<div class="footer">
	 <div class="container wrap">
		<div class="logo2">
			 <a href="/index"><img src="images/logo2.png" alt=""/></a>
		</div>
		<div class="ftr-menu">
			<ul>
				<li><a href="/chat"><@spring.message 'chat'/></a></li>
				<li><a href="/bicycles"><@spring.message 'bicycles'/></a></li>
				<li><a href="/parts"><@spring.message 'parts'/></a></li>
				<li><a href="/accessories"><@spring.message 'accessories'/></a></li>
				<li><a href="/404"><@spring.message 'extras'/></a></li>
			</ul>
		</div>
		<div class="clearfix"></div>
	 </div>
</div>
</body>

