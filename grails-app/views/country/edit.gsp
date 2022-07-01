<%@ page import="org.springframework.validation.FieldError" %>
<!DOCTYPE html>
<html>
    <g:render template="/components/head"/>
    <body>
        <g:render template="/components/header"/>
        <a href="#edit-country" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}">На главную</a></li>
                <li><g:link class="list" action="index">Список стран</g:link></li>
                <li><g:link class="create" action="create">Добавить страну</g:link></li>
            </ul>
        </div>
        <div id="edit-country" class="content scaffold-edit" role="main">
            <h1>Редактировать страну</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.country}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.country}" var="error">
                <li <g:if test="${error in FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.country}" method="PUT">
                <g:hiddenField name="version" value="${this.country?.version}" />
                <fieldset class="form">
                    <f:all bean="country"/>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="Отредактировать" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
