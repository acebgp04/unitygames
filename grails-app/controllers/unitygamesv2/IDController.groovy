package unitygamesv2

import com.lowagie.text.Image
import com.lowagie.text.pdf.AcroFields
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfReader
import com.lowagie.text.pdf.PdfStamper
import com.lowagie.text.pdf.PushbuttonField
import org.joda.time.DateTime
import org.unity.Import
import org.unity.Player

/**
 * IDController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class IDController {

    def root = "/Users/ace/Documents/Pictures/unitygames/players"
	def index = {
		def players = Player.findAll()
		players.each { player ->
            new File("/Users/ace/Desktop", "/Players/${player.getTeam()?.name}").mkdir()
            if(!new File("/Users/ace/Desktop/payload/${player.getTeam()?.name}/${player.getFullName()}.pdf").exists()) {
                if (player.getTeam()?.name?.equalsIgnoreCase('MIN') || player.getTeam()?.name?.equalsIgnoreCase('VIS') || player.getTeam()?.name?.equalsIgnoreCase('NLZ') || player.getTeam()?.name?.equalsIgnoreCase('SLZ')) {
                    createID("/Users/ace/Desktop/unity/Player.pdf", "/Users/ace/Desktop/Players/${player.getTeam().name}/${player.getFullName()}.pdf", player, null)
                }  else if(player?.getTeam()?.name?.equalsIgnoreCase('afr') || player?.getTeam()?.name?.equalsIgnoreCase('sea1') || player?.getTeam()?.name?.equalsIgnoreCase('sea2') || player?.getTeam()?.name?.equalsIgnoreCase('eur') || player?.getTeam()?.name?.equalsIgnoreCase('mde') || player?.getTeam()?.name?.equalsIgnoreCase('NEUR')) {
                    createIDNoFlagNew("/Users/ace/Desktop/unity/Player Intl No ID.pdf", "/Users/ace/Desktop/Players/${player.getTeam().name}/${player.getFullName()}.pdf", player, null)
                } else {
                    createID("/Users/ace/Desktop/unity/Player Intl.pdf", "/Users/ace/Desktop/Players/${player?.getTeam()?.name}/${player?.getFullName()}.pdf", player, null)
                }
            }
		}
		println players

	}

    def createPlayers = {
        def players = Player.findAll()

        players.each { player ->

        }
    }
    def updatePictures = {
        new File(root).eachDirRecurse { team ->
            if(team.isDirectory()) {
                new File(team.getAbsolutePath()).eachFile { file ->
					Player player = Player.findByControlNo(file?.name.substring(0, file?.name.lastIndexOf('.')))
					if(player && player?.team != null) {
						new File("/Users/ace/Desktop", "/payload/${player.getTeam()?.name}").mkdir()
						if(!new File("/Users/ace/Desktop/payload/${player.getTeam()?.name}/${player.getFullName()}.pdf").exists()) {
							if(player?.getTeam()?.name?.equalsIgnoreCase('MIN') || player?.getTeam()?.name?.equalsIgnoreCase('VIS') || player?.getTeam()?.name?.equalsIgnoreCase('NLZ') || player?.getTeam()?.name?.equalsIgnoreCase('SLZ')) {
                                new File("/Users/ace/Desktop", "/payload/${player.getTeam().name}/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}").mkdir()
								createID("/Users/ace/Desktop/unity/Athlete Final New.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${player.getFullName()}.pdf", player, file.getAbsolutePath())
                                createID("/Users/ace/Desktop/unity/Athlete Final New.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}/${player.getFullName()}.pdf", player, file.getAbsolutePath())
							} else if(player?.getTeam()?.name?.equalsIgnoreCase('afr') || player?.getTeam()?.name?.equalsIgnoreCase('sea1') || player?.getTeam()?.name?.equalsIgnoreCase('sea2') || player?.getTeam()?.name?.equalsIgnoreCase('eur') || player?.getTeam()?.name?.equalsIgnoreCase('mde')) {
                                new File("/Users/ace/Desktop", "/payload/${player.getTeam().name}/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}").mkdir()
                                createIDNoFlag("/Users/ace/Desktop/unity/Athlete Final New Int No Flag.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${player.getFullName()}.pdf", player, file.getAbsolutePath())
                                createIDNoFlag("/Users/ace/Desktop/unity/Athlete Final New Int No Flag.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}/${player.getFullName()}.pdf", player, file.getAbsolutePath())
                            } else {
								new File("/Users/ace/Desktop", "/payload/${player.getTeam().name}/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}").mkdir()
								createID("/Users/ace/Desktop/unity/Athlete Final New Int.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${player.getFullName()}.pdf", player, file.getAbsolutePath())
								createID("/Users/ace/Desktop/unity/Athlete Final New Int.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}/${player.getFullName()}.pdf", player, file.getAbsolutePath())

							}
						}
					}
                }
            }
        }
    }

	def createID(String src, String dest, Player player, String picture) throws IOException {
		PdfReader reader = new PdfReader(src);
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
		PdfContentByte contentByte = stamper.getOverContent(1);

		AcroFields form = stamper.getAcroFields();
		//PushbuttonField ad = form.getNewPushbuttonFromField("picture");

		PushbuttonField btnSport = form.getNewPushbuttonFromField("sport");
		btnSport.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
		btnSport.setProportionalIcon(true);
		btnSport.setImage(Image.getInstance("/Users/ace/Desktop/sports/${getSportIcon(player.getSport()?.getName())}"));
		form.replacePushbuttonField("sport",btnSport.getField());


		//ad.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
		//ad.setProportionalIcon(true);
		//flagHolder.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
		//flagHolder.setProportionalIcon(true);

		form.setField("lastName", player?.getLastName()?.toUpperCase());
		form.setField("firstName", player?.getFirstName());
		form.setField("team", getTeam(player?.getTeam()?.name));
		//form.setField("country", "PHILIPPINES");

        form.setField("controlNo", player.controlNo)

	//	Image img = Image.getInstance(picture);
		//ad.setImage(img);
	//	form.replacePushbuttonField("picture", ad.getField());
		Image flagImg = Image.getInstance("/Users/ace/Desktop/flags/${getFlag(player?.getTeam()?.name)}");
		flagImg.setAbsolutePosition(27,135);
		flagImg.scaleAbsoluteHeight(50f);
		flagImg.scaleAbsoluteWidth(73f);
		contentByte.addImage(flagImg);
		stamper.close();
		reader.close();
	}

    def createIDNoFlagNew(String src, String dest, Player player, String picture) throws IOException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfContentByte contentByte = stamper.getOverContent(1);

        AcroFields form = stamper.getAcroFields();
        //PushbuttonField ad = form.getNewPushbuttonFromField("picture");

        PushbuttonField btnSport = form.getNewPushbuttonFromField("sport");
        btnSport.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        btnSport.setProportionalIcon(true);
        btnSport.setImage(Image.getInstance("/Users/ace/Desktop/sports/${getSportIcon(player.getSport()?.getName())}"));
        form.replacePushbuttonField("sport",btnSport.getField());


        //ad.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        //ad.setProportionalIcon(true);
        //flagHolder.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        //flagHolder.setProportionalIcon(true);

        form.setField("lastName", player?.getLastName()?.toUpperCase());
        form.setField("firstName", player?.getFirstName());
        form.setField("team", getTeam(player?.getTeam()?.name));
        //form.setField("country", "PHILIPPINES");

        form.setField("controlNo", player.controlNo)

        //	Image img = Image.getInstance(picture);
        //ad.setImage(img);
        //	form.replacePushbuttonField("picture", ad.getField());
       // Image flagImg = Image.getInstance("/Users/ace/Desktop/flags/${getFlag(player?.getTeam()?.name)}");
        //flagImg.setAbsolutePosition(27,135);
        //flagImg.scaleAbsoluteHeight(50f);
        //flagImg.scaleAbsoluteWidth(73f);
        //contentByte.addImage(flagImg);
        stamper.close();
        reader.close();
    }
    def createIDOLD(String src, String dest, Player player, String picture) throws IOException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfContentByte contentByte = stamper.getOverContent(1);

        AcroFields form = stamper.getAcroFields();
        PushbuttonField ad = form.getNewPushbuttonFromField("picture");

        PushbuttonField btnSport = form.getNewPushbuttonFromField("sport");
        btnSport.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        btnSport.setProportionalIcon(true);
        btnSport.setImage(Image.getInstance("/Users/ace/Desktop/sports/${getSportIcon(player.getSport()?.getName())}"));
        form.replacePushbuttonField("sport",btnSport.getField());


        PushbuttonField flagHolder = form.getNewPushbuttonFromField("picture");
        ad.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        ad.setProportionalIcon(true);
        flagHolder.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        flagHolder.setProportionalIcon(true);

        form.setField("lastName", player?.getLastName()?.toUpperCase());
        form.setField("firstName", player?.getFirstName());
        form.setField("team", getTeam(player?.getTeam()?.name));
        form.setField("country", "PHILIPPINES");

        form.setField("controlNo", player.controlNo)

        Image img = Image.getInstance(picture);
        ad.setImage(img);
        form.replacePushbuttonField("picture", ad.getField());
        Image flagImg = Image.getInstance("/Users/ace/Desktop/flags/${getFlag(player?.getTeam()?.name)}");
        flagImg.setAbsolutePosition(27,135);
        flagImg.scaleAbsoluteHeight(50f);
        flagImg.scaleAbsoluteWidth(73f);
        contentByte.addImage(flagImg);
        stamper.close();
        reader.close();
    }
    def createIDNoFlag(String src, String dest, Player player, String picture) throws IOException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfContentByte contentByte = stamper.getOverContent(1);

        AcroFields form = stamper.getAcroFields();
        PushbuttonField ad = form.getNewPushbuttonFromField("picture");

        PushbuttonField btnSport = form.getNewPushbuttonFromField("sport");
        btnSport.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        btnSport.setProportionalIcon(true);
        btnSport.setImage(Image.getInstance("/Users/ace/Desktop/sports/${getSportIcon(player.getSport()?.getName())}"));
        form.replacePushbuttonField("sport",btnSport.getField());

        PushbuttonField btnControlNo = form.getNewPushbuttonFromField("controlNo");
        btnControlNo.setText(player.getControlNo());
        btnControlNo.setLayout(PushbuttonField.LAYOUT_LABEL_ONLY);
        form.replacePushbuttonField("controlNo", btnControlNo.getField());
        PushbuttonField flagHolder = form.getNewPushbuttonFromField("picture");

        ad.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        ad.setProportionalIcon(true);
        flagHolder.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        flagHolder.setProportionalIcon(true);

        form.setField("lastName", player.getLastName().toUpperCase());
        form.setField("firstName", player.getFirstName());
        form.setField("team", getTeam(player.getTeam().name));
        form.setField("country", "PHILIPPINES");

        Image img = Image.getInstance(picture);
        ad.setImage(img);
        form.replacePushbuttonField("picture", ad.getField());
        stamper.close();
        reader.close();
    }

    def getSportIcon(String sport) {
        String sportFilename = ""
        if(sport?.contains("Badminton")) {
            sportFilename = "Badminton.png"
        } else if(sport?.contains("Baseball")) {
            sportFilename = "Baseball.png"
        } else if(sport?.contains("Track")) {
			sportFilename = "Track & Field.png"
		} else if(sport?.contains("Long Jump")) {
			sportFilename = "Track & Field.png"
		} else if(sport?.contains("Shot-Put")) {
			sportFilename = "Track & Field.png"
		} else if(sport?.contains("Basketball")) {
			sportFilename = "Basketball.png"
		} else if(sport?.contains("Volleyball")) {
			sportFilename = "Volleyball.png"
		} else if(sport?.contains("Football")) {
			sportFilename = "Soccer.png"
		} else if(sport?.contains("Table Tennis")) {
			sportFilename = "Table Tennis.png"
		} else if(sport?.contains("Lawn Tennis")) {
			sportFilename = "Lawn Tennis.png"
		} else if(sport?.contains("Swimming")) {
			sportFilename = "Swimming.png"
		} else if(sport?.contains("Chess")) {
			sportFilename = "Chess.png"
		} else if(sport?.contains("Bowling")) {
			sportFilename = "Bowling.png"
		} else {
			sportFilename = "Karate.png"
		}

		return sportFilename
    }

	def getFlag(String team) {
		String flag = ""
		//MISING ASIA, Europe, Middle East
		if(team?.equalsIgnoreCase("MIN") || team?.equalsIgnoreCase("VIS") || team?.equalsIgnoreCase("SLZ") || team?.equalsIgnoreCase("NLZ")) {
			flag = "Philippines.jpg"
		} else if(team?.equalsIgnoreCase("USA")) {
			flag = "USA.jpg"
		} else if(team?.equalsIgnoreCase("QTR")) {
			flag = "Qatar.jpg"
		} else if(team?.equalsIgnoreCase("UAE")) {
			flag = "United Arab Emirates.jpg"
		} else if(team?.equalsIgnoreCase("SKO")) {
			flag = "Korea (South).jpg"
		} else if(team?.equalsIgnoreCase("AUS")) {
			flag = "Australia.jpg"
		} else if(team?.equalsIgnoreCase("CHN")) {
			flag = "China.jpg"
		} else if(team?.equalsIgnoreCase("CND")) {
			flag = "Canada.jpg"
		} else if(team?.equalsIgnoreCase("UK")) {
			flag = "United Kingdom.jpg"
		} else if(team?.equalsIgnoreCase("JPN")) {
			flag = "Japan.jpg"
		} else {
			flag = "Philippines.jpg"
		}
		return flag
	}
	 def getTeam(String teamCode) {
		String team = "";
		if(teamCode?.equalsIgnoreCase("AFR")) {
			team = "Africa";
		} else if(teamCode?.equalsIgnoreCase("AUS")) {
			team = "Australia";
		} else if(teamCode?.equalsIgnoreCase("CND")) {
			team = "Canada";
		} else if(teamCode?.equalsIgnoreCase("CHN")) {
			team = "China";
		} else if(teamCode?.equalsIgnoreCase("JPN")) {
			team = "Japan";
		} else if(teamCode?.equalsIgnoreCase("NEUR")) {
			team = "Europe";
		} else if(teamCode?.equalsIgnoreCase("SEUR")) {
			team = "Europe";
		} else if(teamCode?.equalsIgnoreCase("UK")) {
			team = "Europe";
		} else if(teamCode?.equalsIgnoreCase("EUR")) {
			team = "Europe";
		} else if(teamCode?.equalsIgnoreCase("MDE")) {
			team = "Middle East";
		} else if(teamCode?.equalsIgnoreCase("SEA2")) {
			team = "South East Asia 2";
		} else if(teamCode?.equalsIgnoreCase("SEA1")) {
			team = "South Ease Asia 1";
		} else if(teamCode?.equalsIgnoreCase("SKO")) {
			team = "South Korea";
		} else if(teamCode?.equalsIgnoreCase("USA")) {
			team = "USA";
		} else if(teamCode?.equalsIgnoreCase("UAE")) {
			team = "UAE";
		}else if(teamCode?.equalsIgnoreCase("MIN")) {
			team = "Mindanao";
		} else if(teamCode?.equalsIgnoreCase("NLZ")) {
			team = "Northern Luzon";
		} else if(teamCode?.equalsIgnoreCase("SLZ")) {
			team = "Southern Luzon";
		} else if(teamCode?.equalsIgnoreCase("VIS")) {
			team = "Visayas";
		}

		return team;
	}

    def createReceptionist() {
        String path = "/Users/ace/Desktop/unity/Receptionnist Final.xlsx";
        Import importer = new Import(path);
        def list = importer.getCommittees();
        list.each { Map committee ->
            //println(">> ${committee.get('controlNo')}")
            if(new File("/Users/ace/Documents/Pictures/unitygames/officials/Receptionist/${committee.get('controlNo')}.jpg").exists()) {
                if(!new File("/Users/ace/Desktop/payload/Receptionist/${committee.get('lastName')}, ${committee.get('firstName')}.pdf").exists()) {
                   // new File("/Users/ace/Desktop", "/payload/Receptionist/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}").mkdir()
                    createCommitteeID("/Users/ace/Desktop/unity/Receptionist New.pdf", "/Users/ace/Desktop/payload/Receptionist/${committee.get('controlNo')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Receptionist/${committee.get('controlNo')}.jpg")
                    //createCommitteeID("/Users/ace/Desktop/unity/Receptionist New.pdf", "/Users/ace/Desktop/payload/Receptionist/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Receptionist/${committee.get('controlNo')}.jpeg")
                }
            }
            if(new File("/Users/ace/Desktop/payload/Receptionist/${committee.get('lastName')}, ${committee.get('firstName')}.pdf").exists()) {
                println(committee.get('controlNo'));
            }
        }
        println(list.size())

    }

    def createTranspo() {
        String path = "/Users/ace/Desktop/unity/MASTERLIST.xlsx";
        Import importer = new Import(path);
        def list = importer.getCommittees();
        list.each { Map committee ->
            println(">> ${committee.get('controlNo')}")
            if(new File("/Users/ace/Documents/Pictures/unitygames/officials/Transpo/${committee.get('controlNo')}.jpg").exists()) {
                if(!new File("/Users/ace/Desktop/payload/Transpo/${committee.get('lastName')}, ${committee.get('firstName')}.pdf").exists()) {
                    new File("/Users/ace/Desktop", "/payload/Transpo/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}").mkdir()
                    createCommitteeID("/Users/ace/Desktop/unity/Volunteer.pdf", "/Users/ace/Desktop/payload/Transpo/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Transpo/${committee.get('controlNo')}.jpg")
                    createCommitteeID("/Users/ace/Desktop/unity/Volunteer.pdf", "/Users/ace/Desktop/payload/Transpo/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Transpo/${committee.get('controlNo')}.jpg")
                }
            }
        }
        println(list.size())

        
    }

    def createKalihim() {
        String path = "/Users/ace/Desktop/unity/kalihim habol.xlsx";
        Import importer = new Import(path);
        def list = importer.getCommittees();
        list.each { Map committee ->
            println(">> ${committee.get('controlNo')}")
            if(new File("/Users/ace/Documents/Pictures/unitygames/officials/Kalihim I/${committee.get('controlNo')}.jpg").exists()) {
                if(!new File("/Users/ace/Desktop/payload/Kalihim I/${committee.get('lastName')}, ${committee.get('firstName')}.pdf").exists()) {
                    new File("/Users/ace/Desktop", "/payload/Kalihim I/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}").mkdir()
                    createCommitteeID("/Users/ace/Desktop/unity/Kalihim I.pdf", "/Users/ace/Desktop/payload/Kalihim I/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Kalihim I/${committee.get('controlNo')}.jpg")
                    createCommitteeID("/Users/ace/Desktop/unity/Kalihim I.pdf", "/Users/ace/Desktop/payload/Kalihim I/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Kalihim I/${committee.get('controlNo')}.jpg")
                }
            }
        }
        println(list.size())

    }

    def createSecretariat() {
        String path = "/Users/ace/Desktop/unity/MASTERLIST.xlsx";
        Import importer = new Import(path);
        def list = importer.getCommittees();
        list.each { Map committee ->
            println(">> ${committee.get('controlNo')}")
            if(new File("/Users/ace/Documents/Pictures/unitygames/officials/Secretariat New/${committee.get('controlNo')}.jpeg").exists()) {
                if(!new File("/Users/ace/Desktop/payload/Secretariat/${committee.get('lastName')}, ${committee.get('firstName')}.pdf").exists()) {
                    new File("/Users/ace/Desktop", "/payload/Secretariat/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}").mkdir()
                    createCommitteeID("/Users/ace/Desktop/unity/Secretariat.pdf", "/Users/ace/Desktop/payload/Secretariat/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Secretariat New/${committee.get('controlNo')}.jpeg")
                    createCommitteeID("/Users/ace/Desktop/unity/Secretariat.pdf", "/Users/ace/Desktop/payload/Secretariat/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Secretariat New/${committee.get('controlNo')}.jpeg")
                }
            }
        }
        println(list.size())

    }

    def createSportOrg() {
        String path = "/Users/ace/Desktop/unity/Transpo new.xlsx";
        Import importer = new Import(path);
        def list = importer.getCommittees();
        list.each { Map committee ->
            println(">> ${committee.get('controlNo')}")
            if(new File("/Users/ace/Documents/Pictures/unitygames/officials/Transpo/${committee.get('controlNo')}.jpg").exists()) {
                if(!new File("/Users/ace/Desktop/payload/Transpo/${committee.get('lastName')}, ${committee.get('firstName')}.pdf").exists()) {
                    new File("/Users/ace/Desktop", "/payload/Transpo/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}").mkdir()
                    createCommitteeID("/Users/ace/Desktop/unity/Volunteer.pdf", "/Users/ace/Desktop/payload/Transpo/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Transpo/${committee.get('controlNo')}.jpg")
                    createCommitteeID("/Users/ace/Desktop/unity/Volunteer.pdf", "/Users/ace/Desktop/payload/Transpo/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Transpo/${committee.get('controlNo')}.jpg")
                }
            }
        }
        println(list.size())

    }

    def createFood() {
        String path = "/Users/ace/Desktop/unity/Food.xlsx";
        Import importer = new Import(path);
        def list = importer.getCommittees();
        list.each { Map committee ->
            println(">> ${committee.get('controlNo')}")
            if(new File("/Users/ace/Documents/Pictures/unitygames/officials/Food/${committee.get('controlNo')}.jpg").exists()) {
                if(!new File("/Users/ace/Desktop/payload/Food/${committee.get('lastName')}, ${committee.get('firstName')}.pdf").exists()) {
                    new File("/Users/ace/Desktop", "/payload/Food/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}").mkdir()
                    createCommitteeID("/Users/ace/Desktop/unity/Volunteer.pdf", "/Users/ace/Desktop/payload/Food/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Food/${committee.get('controlNo')}.jpg")
                    createCommitteeID("/Users/ace/Desktop/unity/Volunteer.pdf", "/Users/ace/Desktop/payload/Food/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Food/${committee.get('controlNo')}.jpg")
                }
            }
        }
        println(list.size())

    }

    def createMedia() {
        String path = "/Users/ace/Desktop/unity/EBC 2nd batch.xls";
        Import importer = new Import(path);
        def list = importer.getCommittees();
        list.each { Map committee ->
            println(">> ${committee.get('controlNo')}")
            if(new File("/Users/ace/Documents/Pictures/unitygames/officials/Media/${committee.get('controlNo')}.jpg").exists()) {
                if(!new File("/Users/ace/Desktop/payload/Media/${committee.get('lastName')}, ${committee.get('firstName')}.pdf").exists()) {
                    new File("/Users/ace/Desktop", "/payload/Media/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}").mkdir()
                    createCommitteeID("/Users/ace/Desktop/unity/Media New.pdf", "/Users/ace/Desktop/payload/Media/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Media/${committee.get('controlNo')}.jpg")
                    createCommitteeID("/Users/ace/Desktop/unity/Media New.pdf", "/Users/ace/Desktop/payload/Media/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Media/${committee.get('controlNo')}.jpg")
                }
            }
        }
        println(list.size())

    }

    def createIntCom() {
        String path = "/Users/ace/Desktop/unity/INTERNATIONAL COMMITTEE.xlsx";
        Import importer = new Import(path);
        def list = importer.getCommittees();
        list.each { Map committee ->
            println(">> ${committee.get('controlNo')}")
            if(new File("/Users/ace/Documents/Pictures/unitygames/officials/International Committee/${committee.get('controlNo')}.jpg").exists()) {
                if(!new File("/Users/ace/Desktop/payload/International Committee/${committee.get('lastName')}, ${committee.get('firstName')}.pdf").exists()) {
                    new File("/Users/ace/Desktop", "/payload/International Committee/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}").mkdir()
                    createCommitteeID("/Users/ace/Desktop/unity/International Committee 2.pdf", "/Users/ace/Desktop/payload/International Committee/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/International Committee/${committee.get('controlNo')}.jpg")
                    createCommitteeID("/Users/ace/Desktop/unity/International Committee 2.pdf", "/Users/ace/Desktop/payload/International Committee/${new DateTime().getMonthOfYear()}-${new DateTime().getDayOfMonth()}/${committee.get('lastName')}, ${committee.get('firstName')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/International Committee/${committee.get('controlNo')}.jpg")
                }
            }
        }
        println(list.size())

    }

    def createCommitteeID(String src, String dest, Map committee, String picture) throws IOException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfContentByte contentByte = stamper.getOverContent(1);

        AcroFields form = stamper.getAcroFields();
        PushbuttonField ad = form.getNewPushbuttonFromField("picture");


//        PushbuttonField btnControlNo = form.getNewPushbuttonFromField("controlNo");
//        btnControlNo.setText(committee.get('controlNo'));
//        btnControlNo.setLayout(PushbuttonField.LAYOUT_LABEL_ONLY);
//        form.replacePushbuttonField("controlNo", btnControlNo.getField());
        PushbuttonField flagHolder = form.getNewPushbuttonFromField("picture");

        ad.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        ad.setProportionalIcon(false);
        flagHolder.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        flagHolder.setProportionalIcon(true);
        String lastName = committee.get('lastName').toString().toUpperCase();
        form.setField("lastName", lastName);
        form.setField("firstName", committee.get('firstName'));
        form.setField("controlNo", committee.get('controlNo'))

        Image img = Image.getInstance(picture);
        ad.setImage(img);
        form.replacePushbuttonField("picture", ad.getField());
        stamper.close();
        reader.close();
    }

    def createAccomodation() {
        String path = "/Users/ace/Desktop/unity/officials generic.xlsx";
        Import importer = new Import(path);
        def list = importer.getCommittees();
        list.each { Map committee ->
            println(">> ${committee.get('controlNo')}")
            createGenericID("/Users/ace/Desktop/unity/Game Official Generic.pdf", "/Users/ace/Desktop/payload/Game Officials/${committee.get('controlNo')}.pdf", committee, "/Users/ace/Documents/Pictures/unitygames/officials/Game Officials/${committee.get('controlNo')}.jpg")
        }
        println(list.size())
    }

    def createGenericID(String src, String dest, Map committee, String picture) throws IOException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfContentByte contentByte = stamper.getOverContent(1);

        AcroFields form = stamper.getAcroFields();
        PushbuttonField ad = form.getNewPushbuttonFromField("picture");



        //ad.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        //   ad.setProportionalIcon(false);
        // flagHolder.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        // flagHolder.setProportionalIcon(true);

        form.setField("lastName", committee.get('lastName'));
        form.setField("firstName", committee.get('firstName'));
        form.setField("controlNo", committee.get('controlNo'))
        stamper.close();
        reader.close();
    }
}
