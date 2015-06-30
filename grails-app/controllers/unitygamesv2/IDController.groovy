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
	def index = {
		def players = Player.findAllByPictureIsNotNull()
		players.each { player ->
            new File("/Users/ace/Desktop", "/payload/${player.getTeam().name}").mkdir()
            createID("/Users/ace/Desktop/Athlete Final.pdf", "/Users/ace/Desktop/payload/${player.getTeam().name}/${player.getFullName()}.pdf", player)
		}
		println players

	}

	def createID(String src, String dest, Player player) throws IOException {
		PdfReader reader = new PdfReader(src);
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
		PdfContentByte contentByte = stamper.getOverContent(1);

		AcroFields form = stamper.getAcroFields();
		PushbuttonField ad = form.getNewPushbuttonFromField("picture");

		PushbuttonField btnCountry = form.getNewPushbuttonFromField("country");
		btnCountry.setText(getTeam(player.team.getName()));
		btnCountry.setLayout(PushbuttonField.LAYOUT_LABEL_ONLY);
		form.replacePushbuttonField("country", btnCountry.getField());
		PushbuttonField btnRegion = form.getNewPushbuttonFromField("region");
		btnRegion.setText(player.getDistrict());
		btnRegion.setLayout(PushbuttonField.LAYOUT_LABEL_LEFT_ICON_RIGHT);
		form.replacePushbuttonField("region", btnRegion.getField());


		PushbuttonField btnSport = form.getNewPushbuttonFromField("sport");
		btnSport.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
		btnSport.setProportionalIcon(true);
		btnSport.setImage(Image.getInstance("/Users/ace/Desktop/baseball.png"));
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

		form.setField("fullName", player.getFullName());
		Image img = Image.getInstance(player.getPicture());
		Image flagImg = Image.getInstance("/Users/ace/Desktop/philippines.png");
		ad.setImage(img);
		flagHolder.setImage(Image.getInstance("/Users/ace/Desktop/philippines.png"));
		form.replacePushbuttonField("picture", ad.getField());
		flagImg.setAbsolutePosition(28,143);
		flagImg.scaleAbsoluteHeight(40f);
		flagImg.scaleAbsoluteWidth(63f);
		contentByte.addImage(flagImg);
		stamper.close();
		reader.close();
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
