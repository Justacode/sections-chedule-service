<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">
<div>
    <h2>Города</h2>
</div>
<@security.authorize  access="hasRole('ROLE_ADMIN')">
<label>Новый город</label>
<form name="newcity" action="/admin/catalog/cities/new" method="POST">
    <input type="text" placeholder="Название города" name="newcityname">
    <input type="submit" value="Добавить">
</form>
</@security.authorize>
<div>
<#list cities as c >
    <h5><a href="/catalog/sportsclubs?cityid=${c.id}">${c.name}</a></h5>
    <@security.authorize  access="hasRole('ROLE_ADMIN')">
        <form action="/admin/catalog/cities/delete" method="GET">
            <input type="hidden" name="deletingcityid" value="${c.id}">
            <input type="submit" value="Удалить">
        </form>
    </@security.authorize>
</#list>
</div>