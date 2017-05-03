<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<p style="text-align: center">Выберите работника:</p>
<#list workers as worker>
<div  style="text-align: center" >
    <a href="${url}/${worker.id}">${worker.name}</a>  <a href="/deleteworker/${worker.id}">Delete</a>
</div>
</#list>

<@sf.form action="${url}" method="post" modelAttribute="workerForm">
<fieldset>
    <div>
        <@sf.label path="name">name</@sf.label>
        <@sf.input path="name" type="name"/>
        <@sf.errors path="name"/>
    </div>
    <div>
        <@sf.label path="age">age</@sf.label>
        <@sf.input path="age" type="age"/>
        <@sf.errors path="age"/>
    </div>
    <div>
        <@sf.label path="companyName">Company Name</@sf.label>
        <@sf.input path="companyName" type="companyName"/>
        <@sf.errors path="companyName"/>
    </div>
    <div>
        <@sf.label path="phoneNumber">Phone Number</@sf.label>
        <@sf.input path="phoneNumber" type="phoneNumber"/>
        <@sf.errors path="phoneNumber"/>
    </div>
    <div>
        <@sf.label path="regalias">Regalias</@sf.label>
        <@sf.input path="regalias" type="regalias"/>
        <@sf.errors path="regalias"/>
    </div>
    <div>
        <@sf.label path="workExperience">Work Experience</@sf.label>
        <@sf.input path="workExperience" type="workExperience"/>
        <@sf.errors path="workExperience"/>
    </div>
    <#if error??>
    ${error}
    </#if>
    <div>
        <input type="submit" value="Add Worker">
    </div>
</fieldset>
</@sf.form>


<#include "adminpagebtm.ftl">