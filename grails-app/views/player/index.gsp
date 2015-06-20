
<%@ page import="org.unity.Player" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'player.label', default: 'Player')}" />
	<title><g:message code="default.index.label" args="[entityName]" /></title>
</head>

<body>

<section id="index-player" class="first">

	<table class="table table-bordered margin-top-medium">
		<thead>
			<tr>
			
				<g:sortableColumn property="controlNo" title="${message(code: 'player.controlNo.label', default: 'Control No')}" />
			
				<g:sortableColumn property="fullName" title="${message(code: 'player.fullName.label', default: 'Full Name')}" />
			
				<g:sortableColumn property="gender" title="${message(code: 'player.gender.label', default: 'Gender')}" />
			
				<g:sortableColumn property="emailAddress" title="${message(code: 'player.emailAddress.label', default: 'Email Address')}" />
			
				<g:sortableColumn property="birthDate" title="${message(code: 'player.birthDate.label', default: 'Birth Date')}" />
			
				<g:sortableColumn property="nationality" title="${message(code: 'player.nationality.label', default: 'Nationality')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${playerInstanceList}" status="i" var="playerInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${playerInstance.id}">${fieldValue(bean: playerInstance, field: "controlNo")}</g:link></td>
			
				<td>${fieldValue(bean: playerInstance, field: "fullName")}</td>
			
				<td>${fieldValue(bean: playerInstance, field: "gender")}</td>
			
				<td>${fieldValue(bean: playerInstance, field: "emailAddress")}</td>
			
				<td><g:formatDate date="${playerInstance.birthDate}" /></td>
			
				<td>${fieldValue(bean: playerInstance, field: "nationality")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div>
		<bs:paginate total="${playerInstanceCount}" />
	</div>
</section>

</body>

</html>
