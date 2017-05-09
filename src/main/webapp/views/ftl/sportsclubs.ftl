<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">
<div>
    <h2 class="text-center">Спортклубы</h2>
</div>
<div class="jumbotron" style="margin-top: 20px;">
    <div class="text-center">
        <div class="form-group">
            <input type="text" id="mySearch" onkeyup="search()" class="form-control" placeholder="Поиск">
        </div>
    <@security.authorize access="hasRole('ROLE_ADMIN')">
        <label>Новый спортивный клуб для выбранного города</label>
        <form name="newsportsclub" action="/admin/catalog/sportsclubs/new" method="POST">
            <input type="hidden" name="cityid" value="${cityid}">
            <input type="text" placeholder="Название клуба" name="newsportsclubname">
            <input class="btn btn-success" type="submit" value="Добавить">
        </form>
    </@security.authorize>

        <div>
        <#if sportsClubs?has_content>
            <ul class="list-group" id="sportsclubsUL">
            <#list sportsClubs as s >
                <li class="list-group-item">
                <a href="/catalog/sections?sportsclubid=${s.id}"> ${s.name}</a>
                <@security.authorize access="hasRole('ROLE_ADMIN')">
                    <form action="/admin/catalog/sportsclubs/delete" method="GET">
                        <input type="hidden" name="cid" value="${cityid}">
                        <input type="hidden" name="deletingsportsclubid" value="${s.id}">
                        <input class="btn btn-danger" type="submit" value="Удалить">
                    </form>
                </@security.authorize>
                </li>
            </#list>
            </ul>
        <#else>
            <h5>К сожалению в данном разделе отсутствуют какие-либо пункты.</h5>
        </#if>
        </div>
    </div>
    <script type="text/javascript">
        function search() {
            var input, filter, ul, li, a, i;
            input = document.getElementById('mySearch');
            filter = input.value.toUpperCase();
            ul = document.getElementById("sportsclubsUL");
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