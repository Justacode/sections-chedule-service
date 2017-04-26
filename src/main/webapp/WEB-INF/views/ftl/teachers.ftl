<#ftl encoding='UTF-8'>
<div>
    <h2>Преподаватели</h2>
</div>

<div>
<#if teachers?has_content>
    <#list teachers as t >
        <h5><a href="/schedule?teacherid=${t.id}"> ${t.fullName}</a></h5>
    </#list>
<#else>
    <h5>К сожалению в данном разделе отсутствуют какие-либо пункты.</h5>
</#if>
</div>