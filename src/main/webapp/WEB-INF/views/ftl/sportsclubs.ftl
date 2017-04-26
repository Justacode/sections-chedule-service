<#ftl encoding='UTF-8'>
<div>
    <h2>Спортклубы</h2>
</div>

<div>
<#if sportsClubs?has_content>
    <#list sportsClubs as s >
        <h5><a href="/sections?sportsclubid=${s.id}"> ${s.name}</a></h5>
    </#list>
<#else>
    <h5>К сожалению в данном разделе отсутствуют какие-либо пункты.</h5>
</#if>
</div>