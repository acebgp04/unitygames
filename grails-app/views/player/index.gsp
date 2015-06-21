
<%@ page import="org.unity.Player" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'player.label', default: 'Player')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<script type="application/javascript">
		$(document).ready(function() {
			$.noConflict();
			$("#comauto").autocomplete({
				source: function(request, response){
					$.ajax({
						url: "/unitygamesV2/player/complist?teamID=${session.getAttribute('team')}&subTeamID=${session.getAttribute('subTeam')}", // remote datasource
						data: request,
						success: function(data){
							response(data); // set the response
						},
						error: function(){ // handle server errors
							$.jGrowl("Unable to retrieve Companies", {
								theme: 'ui-state-error ui-corner-all'
							});
						}
					});
				},
				minLength: 2, // triggered only after minimum 2 characters have been entered.
				select: function(event, ui) { // event handler when user selects a company from the list.
					$("#player\\.id").val(ui.item.id); // update the hidden field.
					$("#empId").val(ui.item.nasSymbol + "-") // populate the employee field with the nasdaq symbol.
					if(ui.item.id != 0)
						location.href='/unitygamesV2/player/show/'+ui.item.id;
				}
			});
		});
	</script>
</head>

<body>

<g:hiddenField name="player.id"></g:hiddenField><br />
<div class="form-group fieldcontain text-center">
	<input name="query" type="text" id="comauto" class="form-control nav-search" placeholder="${message(code: 'search.navbar.placeholder', default: 'Search ...')}" value="${query}">
	<a>Total Players Count: ${org.unity.Player.count}</a><br />
	<a>Total Unique Players Count: ${org.unity.Player.executeQuery("select distinct p.fullName from Player p").size()}</a>
</div>
<section id="list-player" class="first">
	<table class="table table-bordered margin-top-medium">
		<thead>
		<tr>

			<g:sortableColumn property="controlNo" title="${message(code: 'player.controlNo.label', default: 'Control No')}" />

			<g:sortableColumn property="fullName" title="${message(code: 'player.fullName.label', default: 'Full Name')}" />

			<g:sortableColumn property="gender" title="${message(code: 'player.gender.label', default: 'Gender')}" />

			<g:sortableColumn property="team" title="${message(code: 'player.team.label', default: 'Team')}" />

			<g:sortableColumn property="sport" title="${message(code: 'player.sport.label', default: 'Sport')}" />

			<g:sortableColumn property="category" title="${message(code: 'player.category.label', default: 'Category')}" />

		</tr>
		</thead>
		<tbody>
		<g:each in="${playerInstanceList}" status="i" var="playerInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

				<td><g:link action="show" id="${playerInstance.id}">${fieldValue(bean: playerInstance, field: "controlNo")}</g:link></td>

				<td>${fieldValue(bean: playerInstance, field: "fullName")}</td>

				<td>${fieldValue(bean: playerInstance, field: "gender")}</td>

				<td>${fieldValue(bean: playerInstance, field: "team")}</td>

				<td>${fieldValue(bean: playerInstance, field: "sport")}</td>

				<td>${fieldValue(bean: playerInstance, field: "category")}</td>

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
