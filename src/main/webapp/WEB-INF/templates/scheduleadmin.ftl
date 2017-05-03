<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#if schedules??>
    <#list schedules as schedule>

    <table border="1" width="100%" cellpadding="5">
        <tr>
            <th>Monday</th>
            <th>Tuesday</th>
            <th>Wednsday</th>
            <th>Thursday</th>
            <th>Friday</th>
            <th>Saturday</th>
            <th>Sunday</th>
        </tr>
        <tr>
            <td>${schedule.monday}</td>
            <td>${schedule.tuesday}</td>
            <td>${schedule.wednesday}</td>
            <td>${schedule.thursday}</td>
            <td>${schedule.friday}</td>
            <td>${schedule.saturday}</td>
            <td>${schedule.sunday}</td>
        </tr>
    </table>

    </#list>
</#if>


<br>
<br>
<br>
<br>
<br>


<@sf.form action="${url}" method="post" modelAttribute="scheduleForm">
<fieldset>
    <div>
        <@sf.label path="monday">Monday</@sf.label>
        <@sf.input path="monday" type="monday"/>
        <@sf.errors path="monday"/>
    </div>
    <div>
        <@sf.label path="tuesday">Tuesday</@sf.label>
        <@sf.input path="tuesday" type="tuesday"/>
        <@sf.errors path="tuesday"/>
    </div>
    <div>
        <@sf.label path="wednesday">Wednesday</@sf.label>
        <@sf.input path="wednesday" type="wednesday"/>
        <@sf.errors path="wednesday"/>
    </div>
    <div>
        <@sf.label path="thursday">Thursday</@sf.label>
        <@sf.input path="thursday" type="thursday"/>
        <@sf.errors path="thursday"/>
    </div>
    <div>
        <@sf.label path="friday">Friday</@sf.label>
        <@sf.input path="friday" type="friday"/>
        <@sf.errors path="friday"/>
    </div>
    <div>
        <@sf.label path="saturday">Saturday</@sf.label>
        <@sf.input path="saturday" type="saturday"/>
        <@sf.errors path="saturday"/>
    </div>
    <div>
        <@sf.label path="sunday">Sunday</@sf.label>
        <@sf.input path="sunday" type="sunday"/>
        <@sf.errors path="sunday"/>
    </div>


    <#if error??>
    ${error}
    </#if>
    <div>
        <input type="submit" value="Update/add schedule">
    </div>
</fieldset>
</@sf.form>

<#include "adminpagebtm.ftl">