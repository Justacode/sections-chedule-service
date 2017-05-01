<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script src="../../js/validation.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Сервис поиска спортивных расписаний</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <@security.authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
            <ul class="nav navbar-nav">
                <li><a href="/catalog/">В начало каталога</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout">Выйти</a></li>
            </ul>
        </@security.authorize>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>