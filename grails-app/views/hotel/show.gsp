<!DOCTYPE html>
<html>
    <g:render template="/components/head"/>
    <body>
        <g:render template="/components/header"/>
        <a href="#show-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}">На главную</a></li>
                <li><g:link class="list" action="index">Список отелей</g:link></li>
                <li><g:link class="create" action="create">Добавить отель</g:link></li>
            </ul>
        </div>
        <div id="show-hotel" class="content scaffold-show" role="main">
            <h1>Отель: ${this.hotel.title}</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="hotel" />
            <g:form resource="${this.hotel}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.hotel}">Редактировать</g:link>
                    <input class="delete" type="submit" value="Удалить" onclick="return confirm('Вы уверены, что хотите удалить этот отель?');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
