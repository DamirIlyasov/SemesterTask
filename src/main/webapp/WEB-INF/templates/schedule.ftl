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
<#include "homebtn.ftl">
