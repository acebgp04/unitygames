<%@ page import="org.unity.Player" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'player.label', default: 'Player')}" />
	<title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>

<body>

	<section id="edit-player" class="first">

		<g:hasErrors bean="${playerInstance}">
		<div class="alert alert-danger">
			<g:renderErrors bean="${playerInstance}" as="list" />
		</div>
		</g:hasErrors>

		<g:uploadForm method="post" class="form-horizontal" role="form" >
			<g:hiddenField name="id" value="${playerInstance?.id}" />
			<g:hiddenField name="version" value="${playerInstance?.version}" />
			<g:hiddenField name="_method" value="PUT" />
			
			<g:render template="form"/>
			
			<div class="form-actions margin-top-medium">
				<g:actionSubmit class="btn btn-primary" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
	            <button class="btn" type="reset"><g:message code="default.button.reset.label" default="Reset" /></button>
			</div>
		</g:uploadForm>

	</section>

</body>

</html>
