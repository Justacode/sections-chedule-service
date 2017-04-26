<#ftl encoding='UTF-8'>
<div>
    <h2>Секции доступные для данного клуба</h2>
</div>

<div>
<#if sections?has_content>
    <#list sections as s >
        <h5><a href="/teachers?sportsclubid=${sportsclubid}&sectionid=${s.id}">${s.name}</a></h5>
    </#list>
<#else >
        <p>К сожалению, для данного клуба нет доступных секций</p>
</#if>
</div>