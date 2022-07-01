<!DOCTYPE html>
<html>
    <g:render template="/components/head"/>
    <body>
        <g:render template="/components/header"/>
        <a href="#list-country" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}">На главную</a></li>
                <li><g:link class="create" action="create">Добавить страну</g:link></li>
            </ul>
        </div>
        <div id="list-country" class="content scaffold-list" role="main">
            <h1>Список стран</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${countryList}" />

            <div class="pagination">
                <g:paginate total="${countryCount ?: 0}" />
            </div>
        </div>
    </body>
</html>