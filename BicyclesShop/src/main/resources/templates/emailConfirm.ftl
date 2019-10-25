<#import "spring.ftl" as spring />
<!doctype html>
<html lang="en">
<head>

    <title><@spring.message 'email_confirm'/></title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link href="/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/css/nav.css" rel="stylesheet" type="text/css" media="all"/>

    <script src="/js/jquery.min.js"></script>
</head>
<body>
<div class="banner-bg banner-bg1">
    <div class="container">
        <div class="header">
            <div class="logo">
                <img src="../images/logo.png" alt=""/>
                    <form action="/email/confirm" method="post">
                        <input type="text" name="email" placeholder="email for registration">
                        <br>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <br>
                        <input type="submit" value="SignUp">
                    </form>
            </div>
        </div>
    </div>
    <div class="caption">
        <div class="slider">
            <div class="callbacks_container">
                <ul class="rslides" id="slider">
                    <li><h1>HANDMADE BICYCLE</h1></li>
                    <li><h1>SPEED BICYCLE</h1></li>
                    <li><h1>MOUINTAIN BICYCLE</h1></li>
                </ul>
                <p>You <span>create</span> the <span>journey,</span> we supply the <span>parts</span></p>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="container wrap">
        <div class="logo2">
            <a href="/index"><img src="../images/logo2.png" alt=""/></a>
        </div>
    </div>
</div>
</body>
</html>
