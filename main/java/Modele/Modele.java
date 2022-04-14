package Modele;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Modele {
    public final static String DEFAULT_FOLDERNAME = "\\Screenshots";
    public int cpt;
    public String systemPath;
    public String folderPath;
    private String filename;
    private BufferedImage bufferedImage;
    private File savedScreenshot;
    private File folder;
    public boolean createdFolder;
    public boolean createdFile;
    public boolean isSaved;
    private String screenshotPath;

    public Modele() {}

    public void saveFile(String filename, String folderPath) throws AWTException, IOException {
        this.cpt = 1;
        bufferedImage = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        this.systemPath = System.getProperty("user.dir");
        this.filename = filename;
        this.folderPath = folderPath;
        this.folder = new File(systemPath + this.folderPath);
        this.createdFolder = folder.mkdir();
        this.folderPath = folder.getPath();
        this.savedScreenshot = new File(folder.getAbsolutePath() + "/" + filename + ".png");
        System.out.println("Test3");
        savedScreenshot.getPath();
        if (Files.exists(Path.of(String.valueOf(savedScreenshot)))) {
            savedScreenshot.renameTo(new File(folder.getAbsolutePath() + "/" + filename + "_" + cpt + ".png"));
            //ImageIO.write(bufferedImage,"png",new File(folder.getAbsolutePath() + "/" + filename + "_" + cpt + ".png"));
        }
        isSaved = ImageIO.write(bufferedImage,"png",savedScreenshot);
        System.out.println("Test4");

        System.out.println("Test5");
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public File getSavedScreenshot() {
        return savedScreenshot;
    }

    public String getFilename() {
        return savedScreenshot.getAbsolutePath();
    }
}
