package com.lesson16.task1631;
import com.lesson16.task1631.common.*;

public class ImageReaderFactory {

   public static ImageReader getImageReader(ImageTypes imageTypes) {

       try {
           if (imageTypes.equals(ImageTypes.BMP)) return new BmpReader();
           if (imageTypes.equals(ImageTypes.JPG)) return new JpgReader();
           if (imageTypes.equals(ImageTypes.PNG)) return new PngReader();
           else throw new IllegalArgumentException("Неизвестный тип картинки");
       } catch (NullPointerException ee) {
           throw new IllegalArgumentException("Неизвестный тип картинки");
       } catch (IllegalArgumentException e) {
        System.out.println(e.getLocalizedMessage());
    }
       return null;
   }
}
