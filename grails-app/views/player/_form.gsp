<%@ page import="org.unity.Player" %>



			<div class="${hasErrors(bean: playerInstance, field: 'controlNo', 'error')} ">
				<label for="controlNo" class="control-label"><g:message code="player.controlNo.label" default="Control No" /></label>
				<div>
					<g:textField class="form-control" name="controlNo" value="${playerInstance?.controlNo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'controlNo', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'fullName', 'error')} ">
				<label for="fullName" class="control-label"><g:message code="player.fullName.label" default="Full Name" /></label>
				<div>
					<g:textField class="form-control" name="fullName" value="${playerInstance?.fullName}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'fullName', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'gender', 'error')} ">
				<label for="gender" class="control-label"><g:message code="player.gender.label" default="Gender" /></label>
				<div>
					<g:textField class="form-control" name="gender" value="${playerInstance?.gender}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'gender', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'emailAddress', 'error')} ">
				<label for="emailAddress" class="control-label"><g:message code="player.emailAddress.label" default="Email Address" /></label>
				<div>
					<g:textField class="form-control" name="emailAddress" value="${playerInstance?.emailAddress}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'emailAddress', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'birthDate', 'error')} ">
				<label for="birthDate" class="control-label"><g:message code="player.birthDate.label" default="Birth Date" /></label>
				<div>
					<bs:datePicker name="birthDate" precision="day"  value="${playerInstance?.birthDate}" default="none" noSelection="['': '']" />
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'birthDate', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'nationality', 'error')} ">
				<label for="nationality" class="control-label"><g:message code="player.nationality.label" default="Nationality" /></label>
				<div>
					<g:textField class="form-control" name="nationality" value="${playerInstance?.nationality}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'nationality', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'contactNo', 'error')} ">
				<label for="contactNo" class="control-label"><g:message code="player.contactNo.label" default="Contact No" /></label>
				<div>
					<g:textField class="form-control" name="contactNo" value="${playerInstance?.contactNo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'contactNo', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'bloodType', 'error')} ">
				<label for="bloodType" class="control-label"><g:message code="player.bloodType.label" default="Blood Type" /></label>
				<div>
					<g:textField class="form-control" name="bloodType" value="${playerInstance?.bloodType}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'bloodType', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'languageDialect', 'error')} ">
				<label for="languageDialect" class="control-label"><g:message code="player.languageDialect.label" default="Language Dialect" /></label>
				<div>
					<g:textField class="form-control" name="languageDialect" value="${playerInstance?.languageDialect}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'languageDialect', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'weight', 'error')} ">
				<label for="weight" class="control-label"><g:message code="player.weight.label" default="Weight" /></label>
				<div>
					<g:textField class="form-control" name="weight" value="${playerInstance?.weight}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'weight', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'height', 'error')} ">
				<label for="height" class="control-label"><g:message code="player.height.label" default="Height" /></label>
				<div>
					<g:textField class="form-control" name="height" value="${playerInstance?.height}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'height', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'highestEducAttainment', 'error')} ">
				<label for="highestEducAttainment" class="control-label"><g:message code="player.highestEducAttainment.label" default="Highest Educ Attainment" /></label>
				<div>
					<g:textField class="form-control" name="highestEducAttainment" value="${playerInstance?.highestEducAttainment}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'highestEducAttainment', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'picture', 'error')} ">
				<label for="picture" class="control-label"><g:message code="player.picture.label" default="Picture" /></label>
				<div>

					<g:if test="${playerInstance != null}">
						<uploader:uploader id="${playerInstance?.id}" params="[player: playerInstance?.id]" multiple="false" url="${[controller:'player', action:'upload']}" />
					</g:if>
					<g:if test="${playerInstance == null}">
						<input id="pictureFile" type="file" name="pictureFile" value="${playerInstance?.picture}"/>
					</g:if>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'picture', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'remarks', 'error')} ">
				<label for="remarks" class="control-label"><g:message code="player.remarks.label" default="Remarks" /></label>
				<div>
					<g:textField class="form-control" name="remarks" value="${playerInstance?.remarks}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'remarks', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'nameOfFather', 'error')} ">
				<label for="nameOfFather" class="control-label"><g:message code="player.nameOfFather.label" default="Name Of Father" /></label>
				<div>
					<g:textField class="form-control" name="nameOfFather" value="${playerInstance?.nameOfFather}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'nameOfFather', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'fatherContactNo', 'error')} ">
				<label for="fatherContactNo" class="control-label"><g:message code="player.fatherContactNo.label" default="Father Contact No" /></label>
				<div>
					<g:textField class="form-control" name="fatherContactNo" value="${playerInstance?.fatherContactNo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'fatherContactNo', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'nameOfMother', 'error')} ">
				<label for="nameOfMother" class="control-label"><g:message code="player.nameOfMother.label" default="Name Of Mother" /></label>
				<div>
					<g:textField class="form-control" name="nameOfMother" value="${playerInstance?.nameOfMother}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'nameOfMother', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'motherContactNo', 'error')} ">
				<label for="motherContactNo" class="control-label"><g:message code="player.motherContactNo.label" default="Mother Contact No" /></label>
				<div>
					<g:textField class="form-control" name="motherContactNo" value="${playerInstance?.motherContactNo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'motherContactNo', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'kapisanan', 'error')} ">
				<label for="kapisanan" class="control-label"><g:message code="player.kapisanan.label" default="Kapisanan" /></label>
				<div>
					<g:textField class="form-control" name="kapisanan" value="${playerInstance?.kapisanan}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'kapisanan', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'purokGrupo', 'error')} ">
				<label for="purokGrupo" class="control-label"><g:message code="player.purokGrupo.label" default="Purok Grupo" /></label>
				<div>
					<g:textField class="form-control" name="purokGrupo" value="${playerInstance?.purokGrupo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'purokGrupo', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'lokal', 'error')} ">
				<label for="lokal" class="control-label"><g:message code="player.lokal.label" default="Lokal" /></label>
				<div>
					<g:textField class="form-control" name="lokal" value="${playerInstance?.lokal}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'lokal', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'district', 'error')} ">
				<label for="district" class="control-label"><g:message code="player.district.label" default="District" /></label>
				<div>
					<g:textField class="form-control" name="district" value="${playerInstance?.district}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'district', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'baptismDate', 'error')} ">
				<label for="baptismDate" class="control-label"><g:message code="player.baptismDate.label" default="Baptism Date" /></label>
				<div>
					<bs:datePicker name="baptismDate" precision="day"  value="${playerInstance?.baptismDate}" default="none" noSelection="['': '']" />
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'baptismDate', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'country', 'error')} ">
				<label for="country" class="control-label"><g:message code="player.country.label" default="Country" /></label>
				<div>
					<g:textField class="form-control" name="country" value="${playerInstance?.country}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'country', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'team', 'error')} ">
				<label for="team" class="control-label"><g:message code="player.team.label" default="Team" /></label>
				<div>
					<g:select class="form-control" id="team" name="team.id" from="${org.unity.Team.list()}" optionKey="id" value="${playerInstance?.team?.id}" class="many-to-one" noSelection="['null': '']"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'team', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'sport', 'error')} ">
				<label for="sport" class="control-label"><g:message code="player.sport.label" default="Sport" /></label>
				<div>
					<g:select required="required" name="sport" value="${playerInstance?.sport?.id}" from="${org.unity.Sport.list()}" optionKey="id" optionValue="name"
							  noSelection="['':'Choose Sport']"
							  onchange="${remoteFunction (
									  controller: 'Player',
									  action: 'findCategoriesBySport',
									  params: '\'sport=\' + this.value',
									  update: 'category'
							  )}" />
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'sport', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'category', 'error')} ">
				<label for="category" class="control-label"><g:message code="player.category.label" default="Category" /></label>
				<div>
					<g:select class="form-control" id="category" name="category.id" from="${org.unity.Category.list()}" optionKey="id" value="${playerInstance?.category?.id}" class="many-to-one" noSelection="['null': '']"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'category', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'contactAbroadName', 'error')} ">
				<label for="contactAbroadName" class="control-label"><g:message code="player.contactAbroadName.label" default="Contact Abroad Name" /></label>
				<div>
					<g:textField class="form-control" name="contactAbroadName" value="${playerInstance?.contactAbroadName}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'contactAbroadName', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'contactAbroadRel', 'error')} ">
				<label for="contactAbroadRel" class="control-label"><g:message code="player.contactAbroadRel.label" default="Contact Abroad Rel" /></label>
				<div>
					<g:textField class="form-control" name="contactAbroadRel" value="${playerInstance?.contactAbroadRel}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'contactAbroadRel', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'contactAbroademailAddress', 'error')} ">
				<label for="contactAbroademailAddress" class="control-label"><g:message code="player.contactAbroademailAddress.label" default="Contact Abroademail Address" /></label>
				<div>
					<g:textField class="form-control" name="contactAbroademailAddress" value="${playerInstance?.contactAbroademailAddress}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'contactAbroademailAddress', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'contactAbroadPhone', 'error')} ">
				<label for="contactAbroadPhone" class="control-label"><g:message code="player.contactAbroadPhone.label" default="Contact Abroad Phone" /></label>
				<div>
					<g:textField class="form-control" name="contactAbroadPhone" value="${playerInstance?.contactAbroadPhone}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'contactAbroadPhone', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'contactLocalName', 'error')} ">
				<label for="contactLocalName" class="control-label"><g:message code="player.contactLocalName.label" default="Contact Local Name" /></label>
				<div>
					<g:textField class="form-control" name="contactLocalName" value="${playerInstance?.contactLocalName}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'contactLocalName', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'contactLocalRel', 'error')} ">
				<label for="contactLocalRel" class="control-label"><g:message code="player.contactLocalRel.label" default="Contact Local Rel" /></label>
				<div>
					<g:textField class="form-control" name="contactLocalRel" value="${playerInstance?.contactLocalRel}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'contactLocalRel', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'contactLocalemailAddress', 'error')} ">
				<label for="contactLocalemailAddress" class="control-label"><g:message code="player.contactLocalemailAddress.label" default="Contact Localemail Address" /></label>
				<div>
					<g:textField class="form-control" name="contactLocalemailAddress" value="${playerInstance?.contactLocalemailAddress}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'contactLocalemailAddress', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'contactLocalPhone', 'error')} ">
				<label for="contactLocalPhone" class="control-label"><g:message code="player.contactLocalPhone.label" default="Contact Local Phone" /></label>
				<div>
					<g:textField class="form-control" name="contactLocalPhone" value="${playerInstance?.contactLocalPhone}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'contactLocalPhone', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'guardian', 'error')} ">
				<label for="guardian" class="control-label"><g:message code="player.guardian.label" default="Guardian" /></label>
				<div>
					<g:textField class="form-control" name="guardian" value="${playerInstance?.guardian}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'guardian', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'guardianRel', 'error')} ">
				<label for="guardianRel" class="control-label"><g:message code="player.guardianRel.label" default="Guardian Rel" /></label>
				<div>
					<g:textField class="form-control" name="guardianRel" value="${playerInstance?.guardianRel}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'guardianRel', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'guardianContactNo', 'error')} ">
				<label for="guardianContactNo" class="control-label"><g:message code="player.guardianContactNo.label" default="Guardian Contact No" /></label>
				<div>
					<g:textField class="form-control" name="guardianContactNo" value="${playerInstance?.guardianContactNo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'guardianContactNo', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'waiver', 'error')} ">
				<label for="waiver" class="control-label"><g:message code="player.waiver.label" default="Waiver" /></label>
				<div>
					<g:textField class="form-control" name="waiver" value="${playerInstance?.waiver}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'waiver', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'arrivalAirline', 'error')} ">
				<label for="arrivalAirline" class="control-label"><g:message code="player.arrivalAirline.label" default="Arrival Airline" /></label>
				<div>
					<g:textField class="form-control" name="arrivalAirline" value="${playerInstance?.arrivalAirline}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'arrivalAirline', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'arrivalDate', 'error')} ">
				<label for="arrivalDate" class="control-label"><g:message code="player.arrivalDate.label" default="Arrival Date" /></label>
				<div>
					<bs:datePicker name="arrivalDate" precision="day"  value="${playerInstance?.arrivalDate}" default="none" noSelection="['': '']" />
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'arrivalDate', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'arrivalAirport', 'error')} ">
				<label for="arrivalAirport" class="control-label"><g:message code="player.arrivalAirport.label" default="Arrival Airport" /></label>
				<div>
					<g:textField class="form-control" name="arrivalAirport" value="${playerInstance?.arrivalAirport}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'arrivalAirport', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'arrivalFlightNo', 'error')} ">
				<label for="arrivalFlightNo" class="control-label"><g:message code="player.arrivalFlightNo.label" default="Arrival Flight No" /></label>
				<div>
					<g:textField class="form-control" name="arrivalFlightNo" value="${playerInstance?.arrivalFlightNo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'arrivalFlightNo', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'arrivalBusCompany', 'error')} ">
				<label for="arrivalBusCompany" class="control-label"><g:message code="player.arrivalBusCompany.label" default="Arrival Bus Company" /></label>
				<div>
					<g:textField class="form-control" name="arrivalBusCompany" value="${playerInstance?.arrivalBusCompany}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'arrivalBusCompany', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'arrivalBusNo', 'error')} ">
				<label for="arrivalBusNo" class="control-label"><g:message code="player.arrivalBusNo.label" default="Arrival Bus No" /></label>
				<div>
					<g:textField class="form-control" name="arrivalBusNo" value="${playerInstance?.arrivalBusNo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'arrivalBusNo', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'departureAirline', 'error')} ">
				<label for="departureAirline" class="control-label"><g:message code="player.departureAirline.label" default="Departure Airline" /></label>
				<div>
					<g:textField class="form-control" name="departureAirline" value="${playerInstance?.departureAirline}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'departureAirline', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'departureDate', 'error')} ">
				<label for="departureDate" class="control-label"><g:message code="player.departureDate.label" default="Departure Date" /></label>
				<div>
					<bs:datePicker name="departureDate" precision="day"  value="${playerInstance?.departureDate}" default="none" noSelection="['': '']" />
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'departureDate', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'departureAirport', 'error')} ">
				<label for="departureAirport" class="control-label"><g:message code="player.departureAirport.label" default="Departure Airport" /></label>
				<div>
					<g:textField class="form-control" name="departureAirport" value="${playerInstance?.departureAirport}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'departureAirport', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'departureFlightNo', 'error')} ">
				<label for="departureFlightNo" class="control-label"><g:message code="player.departureFlightNo.label" default="Departure Flight No" /></label>
				<div>
					<g:textField class="form-control" name="departureFlightNo" value="${playerInstance?.departureFlightNo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'departureFlightNo', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'departureBusCompany', 'error')} ">
				<label for="departureBusCompany" class="control-label"><g:message code="player.departureBusCompany.label" default="Departure Bus Company" /></label>
				<div>
					<g:textField class="form-control" name="departureBusCompany" value="${playerInstance?.departureBusCompany}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'departureBusCompany', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'departureBusNo', 'error')} ">
				<label for="departureBusNo" class="control-label"><g:message code="player.departureBusNo.label" default="Departure Bus No" /></label>
				<div>
					<g:textField class="form-control" name="departureBusNo" value="${playerInstance?.departureBusNo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'departureBusNo', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'hotel', 'error')} ">
				<label for="hotel" class="control-label"><g:message code="player.hotel.label" default="Hotel" /></label>
				<div>
					<g:textField class="form-control" name="hotel" value="${playerInstance?.hotel}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'hotel', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'hotelPhoneNo', 'error')} ">
				<label for="hotelPhoneNo" class="control-label"><g:message code="player.hotelPhoneNo.label" default="Hotel Phone No" /></label>
				<div>
					<g:textField class="form-control" name="hotelPhoneNo" value="${playerInstance?.hotelPhoneNo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'hotelPhoneNo', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'hotelAddress', 'error')} ">
				<label for="hotelAddress" class="control-label"><g:message code="player.hotelAddress.label" default="Hotel Address" /></label>
				<div>
					<g:textField class="form-control" name="hotelAddress" value="${playerInstance?.hotelAddress}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'hotelAddress', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: playerInstance, field: 'hotelRoomNo', 'error')} ">
				<label for="hotelRoomNo" class="control-label"><g:message code="player.hotelRoomNo.label" default="Hotel Room No" /></label>
				<div>
					<g:textField class="form-control" name="hotelRoomNo" value="${playerInstance?.hotelRoomNo}"/>
					<span class="help-inline">${hasErrors(bean: playerInstance, field: 'hotelRoomNo', 'error')}</span>
				</div>
			</div>

