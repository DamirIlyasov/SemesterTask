<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<p style="text-align: center">Выберите город:</p>
<#list cities as city>
<div  style="text-align: center" >
    <a href="/admin/${city.id}">${city.name}</a>  <a href="/deletecity/${city.id}">Dlete</a>
</div>
</#list>

<@sf.form action="/admin" method="post" modelAttribute="cityForm">
<fieldset>
    <div>
        <@sf.label path="name">City Name</@sf.label>
        <@sf.input path="name" type="name"/>
        <@sf.errors path="name"/>
    </div>
    <#if error??>
        ${error}
    </#if>
    <div>
        <input type="submit" value="Add City">
    </div>
</fieldset>
</@sf.form>

<#include "adminpagebtm.ftl">
