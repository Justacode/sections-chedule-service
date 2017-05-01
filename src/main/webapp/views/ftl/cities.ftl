<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">
<div>
    <h2 class="text-center">Города</h2>
</div>
<div class="jumbotron" style="margin-top: 20px;">
    <div class=" text-center">
    <@security.authorize  access="hasRole('ROLE_ADMIN')">
        <label class="text-center">Новый город</label>
        <form class="center-block" name="newcity" action="/admin/catalog/cities/new" method="POST">
            <input type="text" placeholder="Название города" name="newcityname">
            <input class="btn btn-success" type="button" value="Добавить">
        </form>
    </@security.authorize>
        <div class="center-block">
        <#list cities as c >
            <h5><a href="/catalog/sportsclubs?cityid=${c.id}">${c.name}</a></h5>
            <@security.authorize  access="hasRole('ROLE_ADMIN')">
                <form action="/admin/catalog/cities/delete" method="GET">
                    <input type="hidden" name="deletingcityid" value="${c.id}">
                    <input class="btn btn-danger" type="submit" value="Удалить">
                </form>
            </@security.authorize>
        </#list>
        </div>
    </div>
</div>
<#include "footer.ftl">