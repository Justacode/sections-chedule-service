<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">
<div>
    <h2 class="text-center">Города</h2>
</div>
<div class="jumbotron" style="margin-top: 20px;">
    <div class=" text-center">
        <div class="form-group">
            <input type="text" id="mySearch" onkeyup="search()" class="form-control" placeholder="Поиск">
        </div>
    <@security.authorize  access="hasRole('ROLE_ADMIN')">
        <label class="text-center">Новый город</label>
        <form class="center-block" name="newcity" action="/admin/catalog/cities/new" method="POST">
            <input type="text" placeholder="Название города" name="newcityname">
            <input class="btn btn-success" type="button" value="Добавить">
        </form>
    </@security.authorize>
        <div class="center-block">
            <ul id="citiesUL" class="list-group">
            <#list cities as c >
                <li class="list-group-item">
                    <a href="/catalog/sportsclubs?cityid=${c.id}">${c.name}</a>
                    <@security.authorize  access="hasRole('ROLE_ADMIN')">
                        <form action="/admin/catalog/cities/delete" method="GET">
                            <input type="hidden" name="deletingcityid" value="${c.id}">
                            <input class="btn btn-danger" type="submit" value="Удалить">
                        </form>
                    </@security.authorize>
                </li>
            </#list>
            </ul>
        </div>
    </div>
    <script type="text/javascript">
        function search() {
            var input, filter, ul, li, a, i;
            input = document.getElementById('mySearch');
            filter = input.value.toUpperCase();
            ul = document.getElementById("citiesUL");
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