<#ftl encoding='UTF-8'>
<div>
    <h2>Города</h2>
</div>

<div>
<#list cities as c >
    <h5><a href="/sportsclubs?cityid=${c.id}">${c.name}</a></h5>
</#list>
</div>