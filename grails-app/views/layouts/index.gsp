<!doctype html>
<html>

<g:render template="/components/head"/>

<body>
<g:render template="/components/header"/>

<div class="d-flex flex-column justify-content-center align-items-center mt-5">
    <div id="find_hotel_block">
        <h3>Найдите отель, который вам понравится</h3>
        <g:form action="foundHotels" class="mt-4">

            <div class="mb-3">
                <input type="text" name="hotelTitle" class="form-control fs-5" id="input_hotel_title" placeholder="Название отеля">
            </div>

            <div class="mb-3">
                <select class="form-select" name="countryId" aria-label="Выбор страны">
                    <option value="-1" selected>Выберите страну поиска</option>
                    <g:each in="${countries}">
                        <option value="${it.id}">${it.title}</option>
                    </g:each>
                </select>
            </div>

            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-success fs-4">Найти</button>
            </div>

        </g:form>
    </div>
</div>

<asset:javascript src="application.js"/>
</body>
</html>
