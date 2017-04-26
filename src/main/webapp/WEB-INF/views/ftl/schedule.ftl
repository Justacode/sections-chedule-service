<#ftl encoding='UTF-8'>
<div>
    <h2>Расписание выбранного преподавателя</h2>
</div>

<div>
<#if trainings?has_content>
    <#assign week = ['','ПН','ВТ','СР','ЧТ','ПТ','СБ']>
    <table>
        <tr>
            <#list week as w>
                <th>${w}</th>
            </#list>
        </tr>
        <#list trainings?keys as key >
            <tr>
                <th>${key}</th>
                <#list trainings[key] as l>
                <td>${l}</td>
                </#list>
            </tr>
        </#list>
    </table>
<#else>
    <h5>К сожалению в данном разделе отсутствуют какие-либо пункты.</h5>
</#if>
</div>