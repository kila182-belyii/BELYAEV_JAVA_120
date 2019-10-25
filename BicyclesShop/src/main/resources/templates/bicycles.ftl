<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>

	<title><@spring.message 'bicycles'/></title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link href="/css/bootstrap.css" rel='stylesheet' type="text/css" media="all"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/css/table.css" rel="stylesheet" type="text/css" media="all">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/jquery.easydropdown.js"></script>
	<script src="/js/bicycles.js"></script>

</head>
<body>
<div class="banner-bg banner-bg1">
	<div class="container">
		<div class="header">
			<div class="logo">
				<a href="/index"><img src="/images/logo.png" alt=""/></a>
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
					<a class="shop" href="/cart"><img src="/images/cart.png" alt=""/></a>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
		<table id='articles' class="table">
			<thead class="thead-dark">
			<tr>
				<th>ID</th>
				<th><@spring.message 'name'/></th>
				<th><@spring.message 'price'/></th>
				<th><@spring.message 'add_to_cart'/></th>
			</tr>
			</thead>
			<#list articles as article>
				<tr>
					<td>${article.id}</td>
					<td>${article.name}</td>
					<td>${article.price}</td>
					<td><a onclick="addArticleToCart('${_csrf.token}', ${user.cartId}, ${article.id})" href = "#"><@spring.message 'add_to_cart'/></a></td>
				</tr>
			</#list>
		</table>
		<#if user.role == 'ADMIN'>
			<div id = "addBlock">
				<input type="text" name="name" placeholder="<@spring.message 'name'/>" id = "name">
				<br>
				<input type="number" name="price" placeholder="<@spring.message 'price'/>" id = "price">
				<br>
				<input type="type" name="type" placeholder="<@spring.message 'type'/>" list="typeList" id = "type">
				<datalist id="typeList">
					<option value="<@spring.message 'bicycles'/>">
					<option value="<@spring.message 'parts'/>">
					<option value="<@spring.message 'accessories'/>">
				</datalist>
				<br>
				<input type="button" value=Add onclick="addArticle('${_csrf.token}', $('#name').val(), $('#price').val(), $('#type').val(), ${user.cartId})"/>
			</div>
		</#if>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</div>
</div>
<div class="footer">
	<div class="container wrap">
		<div class="logo2">
			<a href="/index"><img src="/images/logo2.png" alt=""/></a>
		</div>
	</div>
</div>
</body>

