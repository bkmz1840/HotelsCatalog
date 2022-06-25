<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<g:render template="/components/head"/>

<body>
<g:render template="/components/header"/>

<div class="d-flex justify-content-center align-items-center" id="found_hotels_main">
    <div id="found_hotels_block">
        <g:if test="${hotels != null && hotels.size() > 0}">
            <div id="found_hotels_table">
                <p class="fs-3 text-center table_header">Звездность</p>
                <p class="fs-3 text-center table_header">Название</p>
                <g:each in="${hotels}">
                    <hr><hr>
                    <div class="hotel_info_block">
                        <div class="hotel_rate">
                            <g:each var="i" in="${(0..<it.rate)}">
                                <i class="fa-solid fa-star"></i>
                            </g:each>
                        </div>
                        <g:if test="${it.link != null}">
                            <a href="${it.link}" class="btn btn-primary mt-2" target="_blank">Перейти на сайт</a>
                        </g:if>
                    </div>
                    <div class="hotel_title_block">
                        <p class="fs-4 hotel_title">${it.title}</p>
                    </div>
                </g:each>
            </div>
        </g:if>
        <g:else>
            <span class="fs-3 table_header">По Вашему запросу ничего не найдено</span>
        </g:else>
        <div class="d-flex justify-content-center mt-5">
            <g:link resource="" class="btn btn-success">Новый поиск</g:link>
        </div>
    </div>
</div>

<script src="https://kit.fontawesome.com/a611d072c2.js" crossorigin="anonymous"></script>
</body>
</html>