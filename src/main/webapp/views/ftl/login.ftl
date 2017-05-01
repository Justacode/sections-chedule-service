<#ftl encoding='UTF-8'>
<#include "header.ftl">
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<div class="container">
    <div class="jumbotron" style="margin-top: 20px; >
        <p class="lead"  > Введите свой логин и пароль для входа в систему</p>
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
                <input type="submit" value="Войти">
            </div>
        </fieldset>
    </@sf.form>
    </div>
</div>
<#include "footer.ftl">