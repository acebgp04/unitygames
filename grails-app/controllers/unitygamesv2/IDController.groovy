package unitygamesv2

import com.lowagie.text.Image
import com.lowagie.text.pdf.AcroFields
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfReader
import com.lowagie.text.pdf.PdfStamper
import com.lowagie.text.pdf.PushbuttonField
import org.unity.Player

/**
 * IDController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class IDController {

    def root = "/Users/ace/Documents/Pictures/unitygames/players"
	def index = {
		def players = Player.findAllByPictureIsNotNull()
		players.each { player ->
            new File("/Users/ace/Desktop", "/payload/${player.getTeam().name}").mkdir()
			if(player.getTeam().name.equalsIgnoreCase('MIN') || player.getTeam().name.equalsIgnoreCase('VIS') || player.getTeam().name.equalsIgnoreCase('NLZ') || player.getTeam().name.equalsIgnoreCase('SLZ')) {
				createID("/Users/ace/Desktop/unity/Athlete Final New.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${player.getFullName()}.pdf", player, null)
			} else {
				createID("/Users/ace/Desktop/unity/Athlete Final New Int.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${player.getFullName()}.pdf", player, null)
			}
		}
		println players

	}

    def updatePictures = {
        new File(root).eachDirRecurse { team ->
            if(team.isDirectory()) {
                new File(team.getAbsolutePath()).eachFile { file ->
					Player player = Player.findByControlNo(file.name.substring(0, file.name.lastIndexOf('.')))
					if(player) {
						new File("/Users/ace/Desktop", "/payload/${player.getTeam().name}").mkdir()
						if(!new File("/Users/ace/Desktop/payload/${player.getTeam().name}/${player.getFullName()}.pdf").exists()) {
							if(player.getTeam().name.equalsIgnoreCase('MIN') || player.getTeam().name.equalsIgnoreCase('VIS') || player.getTeam().name.equalsIgnoreCase('NLZ') || player.getTeam().name.equalsIgnoreCase('SLZ')) {
								createID("/Users/ace/Desktop/unity/Athlete Final New.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${player.getFullName()}.pdf", player, file.getAbsolutePath())
							} else {
								new File("/Users/ace/Desktop", "/payload/${player.getTeam().name}/${new Date().getMonth()}-${new Date().getDay()}").mkdir()
								createID("/Users/ace/Desktop/unity/Athlete Final New Int.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${player.getFullName()}.pdf", player, file.getAbsolutePath())
								createID("/Users/ace/Desktop/unity/Athlete Final New Int.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${new Date().getMonth()}-${new Date().getDay()}/${player.getFullName()}.pdf", player, file.getAbsolutePath())

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
		PushbuttonField ad = form.getNewPushbuttonFromField("picture");

		PushbuttonField btnSport = form.getNewPushbuttonFromField("sport");
		btnSport.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
		btnSport.setProportionalIcon(true);
		btnSport.setImage(Image.getInstance("/Users/ace/Desktop/sports/${getSportIcon(player.getSport().getName())}"));
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
		//form.setField("country", "PHILIPPINES");
		Image img = Image.getInstance(picture);
		ad.setImage(img);
		form.replacePushbuttonField("picture", ad.getField());

		Image flagImg = Image.getInstance("/Users/ace/Desktop/flags/${getFlag(player.getTeam().name)}");
		flagImg.setAbsolutePosition(27,135);
		flagImg.scaleAbsoluteHeight(50f);
		flagImg.scaleAbsoluteWidth(73f);
		contentByte.addImage(flagImg);
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
		if(team.equalsIgnoreCase("MIN") || team.equalsIgnoreCase("VIS") || team.equalsIgnoreCase("SLZ") || team.equalsIgnoreCase("NLZ")) {
			flag = "Philippines.jpg"
		} else if(team.equalsIgnoreCase("USA")) {
			flag = "USA.jpg"
		} else if(team.equalsIgnoreCase("QTR")) {
			flag = "Qatar.jpg"
		} else if(team.equalsIgnoreCase("UAE")) {
			flag = "United Arab Emirates.jpg"
		} else if(team.equalsIgnoreCase("SKO")) {
			flag = "Korea (South).jpg"
		} else if(team.equalsIgnoreCase("AUS")) {
			flag = "Australia.jpg"
		} else if(team.equalsIgnoreCase("CHN")) {
			flag = "China.jpg"
		} else if(team.equalsIgnoreCase("CND")) {
			flag = "Canada.jpg"
		} else if(team.equalsIgnoreCase("UK")) {
			flag = "United Kingdom.jpg"
		} else if(team.equalsIgnoreCase("JPN")) {
			flag = "Japan.jpg"
		} else {
			flag = "Philippines.jpg"
		}
		return flag
	}
	 def getTeam(String teamCode) {
		String team = "";
		if(teamCode.equalsIgnoreCase("AFR")) {
			team = "Africa";
		} else if(teamCode.equalsIgnoreCase("AUS")) {
			team = "Australia";
		} else if(teamCode.equalsIgnoreCase("CND")) {
			team = "Canada";
		} else if(teamCode.equalsIgnoreCase("CHN")) {
			team = "China";
		} else if(teamCode.equalsIgnoreCase("JPN")) {
			team = "Japan";
		} else if(teamCode.equalsIgnoreCase("NEUR")) {
			team = "Northern Europe";
		} else if(teamCode.equalsIgnoreCase("SEUR")) {
			team = "Southern Europe";
		} else if(teamCode.equalsIgnoreCase("UK")) {
			team = "United Kingdom";
		} else if(teamCode.equalsIgnoreCase("EUR")) {
			team = "Eastern Europe";
		} else if(teamCode.equalsIgnoreCase("MDE")) {
			team = "Middle East";
		} else if(teamCode.equalsIgnoreCase("SEA2")) {
			team = "South East Asia 2";
		} else if(teamCode.equalsIgnoreCase("SEA1")) {
			team = "South Ease Asia 1";
		} else if(teamCode.equalsIgnoreCase("SKO")) {
			team = "South Korea";
		} else if(teamCode.equalsIgnoreCase("USA")) {
			team = "USA";
		} else if(teamCode.equalsIgnoreCase("UAE")) {
			team = "UAE";
		}else if(teamCode.equalsIgnoreCase("MIN")) {
			team = "Mindanao";
		} else if(teamCode.equalsIgnoreCase("NLZ")) {
			team = "Northern Luzon";
		} else if(teamCode.equalsIgnoreCase("SLZ")) {
			team = "Southern Luzon";
		} else if(teamCode.equalsIgnoreCase("VIS")) {
			team = "Visayas";
		}

		return team;
	}
}
