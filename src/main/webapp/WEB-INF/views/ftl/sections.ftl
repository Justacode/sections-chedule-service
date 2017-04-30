<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">
<div>
    <h2>Секции доступные для данного клуба</h2>
</div>
<@security.authorize  access="hasRole('ROLE_ADMIN')">
<label>Новая секция</label>
<form name="newsection" action="/admin/catalog/sections/new" method="POST">
    <input type="hidden" name="sportsclubid" value="${sportsclubid}">
    <input type="text" placeholder="Название секции" name="newsectionname">
    <input type="submit" value="Добавить">
</form>
</@security.authorize>
<div>
<#if sections?has_content>
    <#list sections as s >
        <h5><a href="/catalog/teachers?sportsclubid=${sportsclubid}&sectionid=${s.id}">${s.name}</a></h5>
        <@security.authorize  access="hasRole('ROLE_ADMIN')">
            <form action="/admin/catalog/sections/delete" method="GET">
                <input type="hidden" name="deletingsectionid" value="${s.id}">
                <input type="hidden" name="scid" value="${sportsclubid}">
                <input type="submit" value="Удалить">
            </form>
        </@security.authorize>
</#list>
<#else >
    <p>К сожалению, для данного клуба нет доступных секций</p>
</#if>
</div>