<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">

<@security.authorize  access="hasRole('ROLE_ADMIN')">
<p>Вы находитесь в режиме администратора</p>
</@security.authorize>
<div>
    <a href="/catalog/cities">TRY!!!</a>
</div>

<#include "footer.ftl">