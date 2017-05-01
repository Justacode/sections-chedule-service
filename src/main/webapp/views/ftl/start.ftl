<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">

<@security.authorize  access="hasRole('ROLE_ADMIN')">
<p class="text-center">Вы находитесь в режиме администратора</p>
</@security.authorize>
<div class="text-center">
    <a href="/catalog/cities" class="btn btn-info" role="button">Открыть каталог</a>
</div>

<#include "footer.ftl">