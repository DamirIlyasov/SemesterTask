<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<p style="text-align: center">Выберите сервис:</p>

<#list services as service>
<div  style="text-align: center" >
    <a href="${url}${service.id}">${service.name}</a>
</div>
</#list>

<#include "homebtn.ftl">

