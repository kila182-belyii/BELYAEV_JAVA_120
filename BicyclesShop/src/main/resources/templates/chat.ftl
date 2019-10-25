<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>

    <title><@spring.message 'chat'/></title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link href="/css/bootstrap.css" rel='stylesheet' type="text/css" media="all"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/css/chat.css" rel="stylesheet" type="text/css" media="all">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/jquery.easydropdown.js"></script>

</head>
<body>
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
    <input type="hidden" id="userId" value="${user.id}">
    <div id="username-page">
        <div class="username-page-container">
            <h1 class="title"><@spring.message 'type_your_username'/></h1>
            <form id="usernameForm" name="usernameForm">
                <div class="form-group">
                    <input type="text" id="name" placeholder="Username" autocomplete="off" class="form-control" />
                </div>
                <div class="form-group">
                    <button type="submit" class="accent username-submit"><@spring.message 'start_chating'/></button>
                </div>
            </form>
        </div>
    </div>
    <div id="chat-page" class="hidden">
        <div class="chat-container">
            <div class="chat-header">
                <h2><@spring.message 'welcome'/> ${user.firstName} !</h2>
            </div>
            <div class="connecting">
                <@spring.message 'connecting'/>...
            </div>
            <ul id="messageArea">
            </ul>
            <form id="messageForm" name="messageForm">
                <div class="form-group">
                    <div class="input-group clearfix">
                        <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                        <button type="submit" class="primary"><@spring.message 'send'/></button>
                        <button type="submit" class="primary" onclick="disconnect()"><@spring.message 'disconnect'></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="/js/chat.js"></script>
<div class="footer">
    <div class="container wrap">
        <div class="logo2">
            <a href="/index"><img src="images/logo2.png" alt=""/></a>
        </div>
    </div>
</div>
</body>

