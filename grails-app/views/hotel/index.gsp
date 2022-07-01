<!DOCTYPE html>
<html>
    <g:render template="/components/head"/>
    <body>
        <g:render template="/components/header"/>
        <a href="#list-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}">В начало</a></li>
                <li><g:link class="create" action="create">Добавить отель</g:link></li>
            </ul>
        </div>
        <div id="list-hotel" class="content scaffold-list" role="main">
            <h1>Список отелей</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${hotelList}" />

            <div class="pagination">
                <g:paginate total="${hotelCount ?: 0}" />
            </div>
        </div>
    </body>
</html>