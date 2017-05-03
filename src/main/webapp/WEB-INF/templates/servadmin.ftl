<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<p style="text-align: center">Выберите сервис:</p>
<#list services as service>
<div  style="text-align: center" >
    <a href="${url}/${service.id}">${service.name}</a> <a href="/deleteservice/${service.id}">Delete</a>
</div>
</#list>

<@sf.form action="${url}" method="post" modelAttribute="serviceForm">
<fieldset>
    <div>
        <@sf.label path="name">Service Name</@sf.label>
        <@sf.input path="name" type="name"/>
        <@sf.errors path="name"/>
    </div>
    <#if error??>
    ${error}
    </#if>
    <div>
        <input type="submit" value="Add Service">
    </div>
</fieldset>
</@sf.form>

<#include "adminpagebtm.ftl">