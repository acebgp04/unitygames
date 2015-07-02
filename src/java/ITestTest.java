import com.lowagie.text.*;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.*;
import org.unity.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by ace on 6/14/15.
 */
class ITestTest {
    public  static  void main(String[] args) throws DocumentException, MalformedURLException, IOException {
        new ITestTest().manipulatePdf("/Users/ace/Desktop/unity/Athlete Final New.pdf", "/Users/ace/Desktop/unity/TestForm.pdf");
    }


    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfContentByte contentByte = stamper.getOverContent(1);

        AcroFields form = stamper.getAcroFields();
        PushbuttonField ad = form.getNewPushbuttonFromField("picture");

        PushbuttonField btnSport = form.getNewPushbuttonFromField("sport");
        btnSport.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        btnSport.setProportionalIcon(true);
        btnSport.setImage(Image.getInstance("/Users/ace/Desktop//sports/Soccer.png"));
        form.replacePushbuttonField("sport",btnSport.getField());

        PushbuttonField btnControlNo = form.getNewPushbuttonFromField("controlNo");
        btnControlNo.setText("SK888AT");
        btnControlNo.setLayout(PushbuttonField.LAYOUT_LABEL_ONLY);
        form.replacePushbuttonField("controlNo", btnControlNo.getField());
        PushbuttonField flagHolder = form.getNewPushbuttonFromField("picture");

        ad.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        ad.setProportionalIcon(true);
        flagHolder.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        flagHolder.setProportionalIcon(true);

        form.setField("lastName", "DELOS SANTOS");
        form.setField("firstName", "Juan Manuel A.");
        form.setField("team", "Philippines");
        form.setField("district", "Northern Luzon");
        Image img = Image.getInstance("/Users/ace/Downloads/unity-games davao del norte players 2015/Allen Ruales - Chess.jpg");
        Image flagImg = Image.getInstance("/Users/ace/Desktop/flags/Philippines.jpg");
        ad.setImage(img);
        flagHolder.setImage(Image.getInstance("/Users/ace/Desktop/flags/Philippines.jpg"));
        form.replacePushbuttonField("picture", ad.getField());
        flagImg.setAbsolutePosition(27,135);
        flagImg.scaleAbsoluteHeight(50f);
        flagImg.scaleAbsoluteWidth(73f);
        contentByte.addImage(flagImg);
        stamper.close();
        reader.close();
    }
}
