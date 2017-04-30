<#ftl encoding='UTF-8'>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#include "header.ftl">
<div>
    <h2>Информация о преподавателе</h2>
</div>

<#assign week = ['ПН','ВТ','СР','ЧТ','ПТ','СБ']>
<#assign time = ['10:00','12:00','14:00','16:00','18:00']>
<@security.authorize  access="hasRole('ROLE_ADMIN')">
<form name="newtraining" action="/admin/catalog/trainings/new" method="POST">
    <select name="day">
        <#list week as w>
            <option value="${w?counter}">${w}</option>
        </#list>
    </select>
    <select name="time">
        <#list time as t>
            <option value="${t}">${t}</option>
        </#list>
    </select>
    <input type="hidden" name="teacherid" value="${teacher.id}">
    <input type="submit" value="Добавить">
</form>
</@security.authorize>
<h2>Данные преподавателя</h2>
<div>
    <table>
        <tr>
            <th>Имя:</th>
            <td>${teacher.fullName}</td>
        </tr>
        <tr>
            <th>Возраст:</th>
            <td>${teacher.age}</td>
        </tr>
        <tr>
            <th>Контактный телефон:</th>
            <td>${teacher.phoneNumber}</td>
        </tr>
        <tr>
            <th>Регалии:</th>
            <td>${teacher.regalia}</td>
        </tr>
        <tr>
            <th>Опыт работы:</th>
            <td>${teacher.workExperience}</td>
        </tr>
    </table>
</div>

<h3>Расписание</h3>
<div>
<#if trainings?has_content>
    <table>
        <tr>
            <th></th>
            <#list week as w>
                <th>${w}</th>
            </#list>
        </tr>
        <#list trainings?keys as key >
            <tr>
                <th>${key}</th>
                <#list trainings[key] as l>
                    <td>
                        <#if l == 0>
                            -
                        <#else >
                            +
                            <@security.authorize  access="hasRole('ROLE_ADMIN')">
                                <form action="/admin/catalog/trainings/delete" method="GET">
                                    <input type="hidden" name="teacherid" value="${teacher.id}">
                                    <input type="hidden" name="trainingid" value="${l}">
                                    <input type="submit" value="Удалить">
                                </form>
                            </@security.authorize>
                        </#if>
                    </td>
                </#list>
            </tr>
        </#list>
    </table>
<#else>
    <h5>К сожалению в данном разделе отсутствуют какие-либо пункты.</h5>
</#if>
</div>