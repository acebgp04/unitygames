package org.unity

class Player {

	String firstName
	String middleName
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
	static belongsTo = [team: Team, sport:Sport]
	static hasMany = [categories : Category]

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
		"${firstName} ${middleName} ${lastName}"
	}
	static constraints = {
		firstName(nullable: false)
		middleName(nullable: false)
		lastName(nullable: false)
		gender(nullable: false)
		emailAddress(nullable: false)
		birthDate(nullable: false)
		nationality(nullable: false)
		contactNo(nullable: false)
		bloodType(nullable: false)
		languageDialect(nullable: false)
		weight(nullable: false)
		height(nullable: false)
		highestEducAttainment(nullable: false)
		picture(blank: true, nullable: true)

		nameOfFather(nullable: true)
		fatherContactNo(nullable: true)
		nameOfMother(nullable: true)
		motherContactNo(nullable: true)

		kapisanan(nullable: false)
		purokGrupo(nullable: false)
		lokal(nullable: false)
		district(nullable: false)
		baptismDate(nullable: false)
		country(nullable: false)
		team(nullable: false)
//		sports(nullable: true)

		contactAbroadName(nullable: true)
		contactAbroadRel(nullable: true)
		contactAbroademailAddress(nullable: true)
		contactAbroadPhone(nullable: true)
		contactLocalName(nullable: true)
		contactLocalRel(nullable: true)
		contactLocalemailAddress(nullable: true)
		contactLocalPhone(nullable: true)

		guardian(nullable: false)
		guardianRel(nullable: false)
		guardianContactNo(nullable: false)
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
