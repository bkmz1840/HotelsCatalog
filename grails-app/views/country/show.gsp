<!DOCTYPE html>
<html>
    <g:render template="/components/head"/>
    <body>
        <g:render template="/components/header"/>
        <a href="#show-country" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}">На главную</a></li>
                <li><g:link class="list" action="index">Список стран</g:link></li>
                <li><g:link class="create" action="create">Добавить страну</g:link></li>
            </ul>
        </div>
        <div id="show-country" class="content scaffold-show" role="main">
            <h1>Страна: ${this.country.title}</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="country" />
            <g:form resource="${this.country}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.country}">Редактировать</g:link>
                    <input class="delete" type="submit" value="Удалить" onclick="return confirm('Вы уверены, что хотите удалить эту страну?');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
