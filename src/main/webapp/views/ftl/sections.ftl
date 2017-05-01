<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">
<div>
    <h2 class="text-center">Секции</h2>
</div>

<div class="jumbotron" style="margin-top: 20px;">
    <div class="text-center">
    <@security.authorize  access="hasRole('ROLE_ADMIN')">
        <label>Новая секция</label>
        <form name="newsection" action="/admin/catalog/sections/new" method="POST">
            <input type="hidden" name="sportsclubid" value="${sportsclubid}">
            <input type="text" placeholder="Название секции" name="newsectionname">
            <input class="btn btn-success" type="submit" value="Добавить">
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
                        <input class="btn btn-danger" type="submit" value="Удалить">
                    </form>
                </@security.authorize>
            </#list>
        <#else >
            <p>К сожалению, для данного клуба нет доступных преподавателей для данной секции</p>
        </#if>
        </div>
    </div>
</div>
<#include "footer.ftl">