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
        <@security.authorize access="hasRole('ROLE_USER')">
            <#if sections_user?has_content>
                <#list sections_user as s >
                    <h5><a href="/catalog/teachers?sportsclubid=${sportsclubid}&sectionid=${s.id}">${s.name}</a></h5>
                </#list>
            <#else >
                <p>К сожалению, для данного клуба нет доступных секций</p>
            </#if>
        </@security.authorize>
        <@security.authorize  access="hasRole('ROLE_ADMIN')">
            <#if sections_admin?has_content>
                <#list sections_admin as s >
                    <h5><a href="/catalog/teachers?sportsclubid=${sportsclubid}&sectionid=${s.id}">${s.name}</a></h5>
                    <form action="/admin/catalog/sections/delete" method="GET">
                        <input type="hidden" name="deletingsectionid" value="${s.id}">
                        <input type="hidden" name="scid" value="${sportsclubid}">
                        <input class="btn btn-danger" type="submit" value="Удалить">
                    </form>
                </#list>
            <#else >
                <p>К сожалению, для данного клуба нет доступных секций</p>
            </#if>
        </@security.authorize>
        </div>
    </div>
</div>
<#include "footer.ftl">