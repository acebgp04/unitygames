package org.unity

class Player {
	String controlNo
	String fullName
	String firstName
	String lastName
	String gender
	String emailAddress
	Date birthDate
	String nationality
	String contactNo
	String bloodType
	String languageDialect
	String weight
	String height
	String highestEducAttainment
	String picture
    String remarks

	String nameOfFather
	String fatherContactNo
	String nameOfMother
	String motherContactNo

	String kapisanan
	String purokGrupo
	String lokal
	String district
	Date baptismDate
	String country
	static belongsTo = [team: Team, sport:Sport,category : Category]

	String contactAbroadName
	String contactAbroadRel
	String contactAbroademailAddress
	String contactAbroadPhone
	String contactLocalName
	String contactLocalRel
	String contactLocalemailAddress
	String contactLocalPhone

	String guardian
	String guardianRel
	String guardianContactNo
	String waiver

	//Transportation

	String arrivalAirline
	Date arrivalDate
	String arrivalAirport
	String arrivalFlightNo
	String arrivalBusCompany
	String arrivalBusNo

	String departureAirline
	Date departureDate
	String departureAirport
	String departureFlightNo
	String departureBusCompany
	String departureBusNo


	//Accomodation
	String hotel
	String hotelPhoneNo
	String hotelAddress
	String hotelRoomNo

	String toString() {
		"${fullName}"
	}
	static constraints = {
		controlNo(nullable:false)
		fullName(nullable: true)
		firstName(nullable: true)
		lastName(nullable: true)
		gender(nullable: true)
		emailAddress(nullable: true)
		birthDate(nullable: true)
		nationality(nullable: true)
		contactNo(nullable: true)
		bloodType(nullable: true)
		languageDialect(nullable: true)
		weight(nullable: true)
		height(nullable: true)
		highestEducAttainment(nullable: true)
		picture(blank: true, nullable: true)
        remarks(nullable: true)

		nameOfFather(nullable: true)
		fatherContactNo(nullable: true)
		nameOfMother(nullable: true)
		motherContactNo(nullable: true)

		kapisanan(nullable: true)
		purokGrupo(nullable: true)
		lokal(nullable: true)
		district(nullable: true)
		baptismDate(nullable: true)
		country(nullable: true)
		team(nullable: true)
		sport(nullable: true)
        category(nullable: true)

		contactAbroadName(nullable: true)
		contactAbroadRel(nullable: true)
		contactAbroademailAddress(nullable: true)
		contactAbroadPhone(nullable: true)
		contactLocalName(nullable: true)
		contactLocalRel(nullable: true)
		contactLocalemailAddress(nullable: true)
		contactLocalPhone(nullable: true)

		guardian(nullable: true)
		guardianRel(nullable: true)
		guardianContactNo(nullable: true)
		waiver(nullable: true)

		arrivalAirline(nullable: true)
		arrivalDate(nullable: true)
		arrivalAirport(nullable: true)
		arrivalFlightNo(nullable: true)
		arrivalBusCompany(nullable: true)
		arrivalBusNo(nullable: true)

		departureAirline(nullable: true)
		departureDate(nullable: true)
		departureAirport(nullable: true)
		departureFlightNo(nullable: true)
		departureBusCompany(nullable: true)
		departureBusNo(nullable: true)

		hotel(nullable: true)
		hotelPhoneNo(nullable: true)
		hotelAddress(nullable: true)
		hotelRoomNo(nullable: true)
	}
}
