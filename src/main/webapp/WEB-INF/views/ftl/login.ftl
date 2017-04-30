<#ftl encoding='UTF-8'>
<!doctype html>
<html>
<head>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../css/bootstrap-theme.min.css">
</head>
<body>
<#include "header.ftl">
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<h3>Введите свой логин и пароль для входа в систему</h3>
<#if error??>
Введен неверный логин или пароль!
</#if>
<@sf.form cssClass="vForm" role="form" action='/login/process' method="post" modelAttribute="authForm">
<fieldset>
    <div class="field">
        <@sf.label path="login">Login</@sf.label>
        <@sf.input cssClass="vField1" path="login" type="text"/>
        <@sf.errors path="login"/>
    </div>
    <div class="field">
        <@sf.label path="password">Password</@sf.label>
        <@sf.input cssClass="vField2" path="password" type="password"/>
        <@sf.errors path="password"/>
    </div>
    <div>
        <input type="submit" value="Sign in">
    </div>
</fieldset>
</@sf.form>
</body>
</html>