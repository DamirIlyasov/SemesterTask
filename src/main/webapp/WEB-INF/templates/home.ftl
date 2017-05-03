<p style="text-align: center">Выберите город:</p>
<#list cities as city>
<div  style="text-align: center" >
    <a href="/home/${city.id}">${city.name}</a>
</div>
</#list>

<#include "adminpagebtm.ftl">
