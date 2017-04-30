<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">
<div>
    <h2>Преподаватели</h2>
</div>

<@security.authorize access="hasRole('ROLE_ADMIN')">
<label>Новый преподаватель для данной секции и клуба</label>
<form name="newteacher" action="/admin/catalog/teachers/new" method="POST">
    <input type="hidden" name="sportsclubid" value="${sportsclubid}">
    <input type="hidden" name="sectionid" value="${sectionid}">
    <input type="text" placeholder="Полное имя преподавателя" name="newteachername">
    <input type="number" placeholder="Возраст" name="age">
    <input type="text" placeholder="Телефон" name="phone">
    <input type="text" placeholder="Регалии" name="regalia">
    <input type="number" placeholder="Опыт работы" name="experience">
    <input type="submit" value="Добавить">
</form>
</@security.authorize>

<div>
<#if teachers?has_content>
    <#list teachers as t >
        <h5><a href="/catalog/schedule?teacherid=${t.id}"> ${t.fullName}</a></h5>
        <@security.authorize  access="hasRole('ROLE_ADMIN')">
            <form action="/admin/catalog/teachers/delete" method="GET">
                <input type="hidden" name="deletingteacherid" value="${t.id}">
                <input type="hidden" name="scid" value="${sportsclubid}">
                <input type="hidden" name="sid" value="${sectionid}">
                <input type="submit" value="Удалить">
            </form>
        </@security.authorize>
    </#list>
<#else>
    <h5>К сожалению в данном разделе отсутствуют какие-либо пункты.</h5>
</#if>
</div>