import com.lowagie.text.*;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.*;

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
class ITextTest {
    public  static  void main(String[] args) throws DocumentException, MalformedURLException, IOException {
        new ITextTest().manipulatePdf("/Users/ace/Desktop/Athlete Final.pdf", "TestForm.pdf");
    }

    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfContentByte contentByte = stamper.getOverContent(1);

        AcroFields form = stamper.getAcroFields();
        PushbuttonField ad = form.getNewPushbuttonFromField("picture");

        PushbuttonField btnCountry = form.getNewPushbuttonFromField("country");
        btnCountry.setText("South Korea");
        btnCountry.setLayout(PushbuttonField.LAYOUT_LABEL_ONLY);
        form.replacePushbuttonField("country", btnCountry.getField());
        PushbuttonField btnRegion = form.getNewPushbuttonFromField("region");
        btnRegion.setText("Asia");
        btnRegion.setLayout(PushbuttonField.LAYOUT_LABEL_LEFT_ICON_RIGHT);
        form.replacePushbuttonField("region", btnRegion.getField());


        PushbuttonField btnSport = form.getNewPushbuttonFromField("sport");
        btnSport.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        btnSport.setProportionalIcon(true);
        btnSport.setImage(Image.getInstance("/Users/ace/Desktop/basketball.png"));
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

        form.setField("fullName", "Delos Santos Juan Manuel A.");
        Image img = Image.getInstance("/Users/ace/Downloads/Mancolintas Benjie (Coach).jpg");
        Image flagImg = Image.getInstance("/Users/ace/Desktop/korea.jpg");
        ad.setImage(img);
        flagHolder.setImage(Image.getInstance("/Users/ace/Desktop/korea.jpg"));
        form.replacePushbuttonField("picture", ad.getField());
        flagImg.setAbsolutePosition(28,143);
        flagImg.scaleAbsoluteHeight(40f);
        flagImg.scaleAbsoluteWidth(63f);
        contentByte.addImage(flagImg);
        stamper.close();
        reader.close();
    }
}
