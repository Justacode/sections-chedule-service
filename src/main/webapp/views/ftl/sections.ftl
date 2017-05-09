<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">
<div>
    <h2 class="text-center">Секции</h2>
</div>

<div class="jumbotron" style="margin-top: 20px;">
    <div class="text-center">
        <div class="form-group">
            <input type="text" id="mySearch" onkeyup="search()" class="form-control" placeholder="Поиск">
        </div>
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
                <ul class="list-group" id="sectionsUL">
                    <#list sections_user as s >
                        <li class="list-group-item">
                            <a href="/catalog/teachers?sportsclubid=${sportsclubid}&sectionid=${s.id}">${s.name}</a>
                        </li>
                    </#list>
                </ul>
            <#else >
                <p>К сожалению, для данного клуба нет доступных секций</p>
            </#if>
        </@security.authorize>
        <@security.authorize  access="hasRole('ROLE_ADMIN')">
            <#if sections_admin?has_content>
                <ul class="list-group" id="sectionsUL">
                    <#list sections_admin as s >
                        <li class="list-group-item">
                            <a href="/catalog/teachers?sportsclubid=${sportsclubid}&sectionid=${s.id}">${s.name}</a>
                            <form action="/admin/catalog/sections/delete" method="GET">
                                <input type="hidden" name="deletingsectionid" value="${s.id}">
                                <input type="hidden" name="scid" value="${sportsclubid}">
                                <input class="btn btn-danger" type="submit" value="Удалить">
                            </form>
                        </li>
                    </#list>
                </ul>
            <#else >
                <p>К сожалению, для данного клуба нет доступных секций</p>
            </#if>
        </@security.authorize>
        </div>
    </div>
    <script type="text/javascript">
        function search() {
            var input, filter, ul, li, a, i;
            input = document.getElementById('mySearch');
            filter = input.value.toUpperCase();
            ul = document.getElementById("sectionsUL");
            li = ul.getElementsByTagName('li');

            for (i = 0; i < li.length; i++) {
                a = li[i].getElementsByTagName("a")[0];
                if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
                    li[i].style.display = "";
                } else {
                    li[i].style.display = "none";
                }
            }
        }
    </script>
</div>
<#include "footer.ftl">