<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">
<div>
    <h2 class="text-center">Преподаватели</h2>
</div>
<div class="jumbotron" style="margin-top: 20px;">
    <div class="text-center">
        <div class="form-group">
            <input type="text" id="mySearch" onkeyup="search()" class="form-control" placeholder="Поиск">
        </div>
    <@security.authorize access="hasRole('ROLE_ADMIN')">
        <label>Новый преподаватель для данной секции и клуба</label>
        <form name="newteacher" action="/admin/catalog/teachers/new" method="POST">
            <input type="hidden" name="sportsclubid" value="${sportsclubid}">
            <input type="hidden" name="sectionid" value="${sectionid}">
            <input type="text" placeholder="Полное имя преподавателя" name="newteachername">
            <input type="number" placeholder="Возраст" name="age">
            <input type="number" placeholder="Телефон" name="phone">
            <input type="text" placeholder="Регалии" name="regalia">
            <input type="number" placeholder="Опыт работы" name="experience">
            <input class="btn btn-success" type="submit" value="Добавить">
        </form>
    </@security.authorize>

        <div>
        <#if teachers?has_content>
            <ul class="list-group" id="teachersUL">
                <#list teachers as t >
                    <li class="list-group-item">
                        <a href="/catalog/schedule?teacherid=${t.id}"> ${t.fullName}</a>
                        <@security.authorize  access="hasRole('ROLE_ADMIN')">
                            <form action="/admin/catalog/teachers/delete" method="GET">
                                <input type="hidden" name="deletingteacherid" value="${t.id}">
                                <input type="hidden" name="scid" value="${sportsclubid}">
                                <input type="hidden" name="sid" value="${sectionid}">
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
            ul = document.getElementById("teachersUL");
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