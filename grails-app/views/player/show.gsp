
<%@ page import="org.unity.Player" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'player.label', default: 'Player')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-player" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.controlNo.label" default="Control No" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "controlNo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.fullName.label" default="Full Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "fullName")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.gender.label" default="Gender" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "gender")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.emailAddress.label" default="Email Address" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "emailAddress")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.birthDate.label" default="Birth Date" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${playerInstance?.birthDate}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.nationality.label" default="Nationality" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "nationality")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.contactNo.label" default="Contact No" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "contactNo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.bloodType.label" default="Blood Type" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "bloodType")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.languageDialect.label" default="Language Dialect" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "languageDialect")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.weight.label" default="Weight" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "weight")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.height.label" default="Height" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "height")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.highestEducAttainment.label" default="Highest Educ Attainment" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "highestEducAttainment")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.picture.label" default="Picture" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "picture")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.remarks.label" default="Remarks" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "remarks")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.nameOfFather.label" default="Name Of Father" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "nameOfFather")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.fatherContactNo.label" default="Father Contact No" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "fatherContactNo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.nameOfMother.label" default="Name Of Mother" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "nameOfMother")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.motherContactNo.label" default="Mother Contact No" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "motherContactNo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.kapisanan.label" default="Kapisanan" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "kapisanan")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.purokGrupo.label" default="Purok Grupo" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "purokGrupo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.lokal.label" default="Lokal" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "lokal")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.district.label" default="District" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "district")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.baptismDate.label" default="Baptism Date" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${playerInstance?.baptismDate}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.country.label" default="Country" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "country")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.team.label" default="Team" /></td>
				
				<td valign="top" class="value"><g:link controller="team" action="show" id="${playerInstance?.team?.id}">${playerInstance?.team?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.sport.label" default="Sport" /></td>
				
				<td valign="top" class="value"><g:link controller="sport" action="show" id="${playerInstance?.sport?.id}">${playerInstance?.sport?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.category.label" default="Category" /></td>
				
				<td valign="top" class="value"><g:link controller="category" action="show" id="${playerInstance?.category?.id}">${playerInstance?.category?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.contactAbroadName.label" default="Contact Abroad Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "contactAbroadName")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.contactAbroadRel.label" default="Contact Abroad Rel" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "contactAbroadRel")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.contactAbroademailAddress.label" default="Contact Abroademail Address" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "contactAbroademailAddress")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.contactAbroadPhone.label" default="Contact Abroad Phone" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "contactAbroadPhone")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.contactLocalName.label" default="Contact Local Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "contactLocalName")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.contactLocalRel.label" default="Contact Local Rel" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "contactLocalRel")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.contactLocalemailAddress.label" default="Contact Localemail Address" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "contactLocalemailAddress")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.contactLocalPhone.label" default="Contact Local Phone" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "contactLocalPhone")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.guardian.label" default="Guardian" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "guardian")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.guardianRel.label" default="Guardian Rel" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "guardianRel")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.guardianContactNo.label" default="Guardian Contact No" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "guardianContactNo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.waiver.label" default="Waiver" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "waiver")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.arrivalAirline.label" default="Arrival Airline" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "arrivalAirline")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.arrivalDate.label" default="Arrival Date" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${playerInstance?.arrivalDate}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.arrivalAirport.label" default="Arrival Airport" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "arrivalAirport")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.arrivalFlightNo.label" default="Arrival Flight No" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "arrivalFlightNo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.arrivalBusCompany.label" default="Arrival Bus Company" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "arrivalBusCompany")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.arrivalBusNo.label" default="Arrival Bus No" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "arrivalBusNo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.departureAirline.label" default="Departure Airline" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "departureAirline")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.departureDate.label" default="Departure Date" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${playerInstance?.departureDate}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.departureAirport.label" default="Departure Airport" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "departureAirport")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.departureFlightNo.label" default="Departure Flight No" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "departureFlightNo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.departureBusCompany.label" default="Departure Bus Company" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "departureBusCompany")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.departureBusNo.label" default="Departure Bus No" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "departureBusNo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.hotel.label" default="Hotel" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "hotel")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.hotelPhoneNo.label" default="Hotel Phone No" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "hotelPhoneNo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.hotelAddress.label" default="Hotel Address" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "hotelAddress")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="player.hotelRoomNo.label" default="Hotel Room No" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: playerInstance, field: "hotelRoomNo")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
