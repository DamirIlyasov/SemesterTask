<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<p style="text-align: center">Выберите работника:</p>
<#list workers as worker>
<div  style="text-align: center" >
    <a href="${url}${worker.id}">${worker.name}</a>
</div>
</#list>

<#include "homebtn.ftl">

