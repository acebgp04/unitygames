<%@ page import="org.unity.Player" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'player.label', default: 'Player')}" />
	<title><g:message code="default.create.label" args="[entityName]" /></title>
</head>

<body>

	<section id="create-player" class="first">

		<g:hasErrors bean="${playerInstance}">
		<div class="alert alert-danger">
			<g:renderErrors bean="${playerInstance}" as="list" />
		</div>
		</g:hasErrors>

		<g:uploadForm action="save" class="form-horizontal">
			<g:render template="form"/>

			<div class="form-actions margin-top-medium">
				<g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
	            <button class="btn" type="reset"><g:message code="default.button.reset.label" default="Reset" /></button>
			</div>
		</g:uploadForm>

	</section>

</body>

</html>
