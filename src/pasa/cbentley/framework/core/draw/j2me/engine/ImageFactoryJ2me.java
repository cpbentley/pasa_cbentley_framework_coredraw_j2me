package pasa.cbentley.framework.core.draw.j2me.engine;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import pasa.cbentley.framework.core.draw.j2me.ctx.CoreDrawJ2meCtx;
import pasa.cbentley.framework.coredraw.src4.engine.ImageFactoryAbstract;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImage;

public class ImageFactoryJ2me extends ImageFactoryAbstract {

   protected final CoreDrawJ2meCtx dd;

   public ImageFactoryJ2me(CoreDrawJ2meCtx j2meCtx) {
      super(j2meCtx);
      this.dd = j2meCtx;
   }

   public IImage createImage(byte[] data, int start, int len) {
      return new ImageJ2me(Image.createImage(data, start, len), dd);
   }

   public IImage createImage(IImage source) {
      ImageJ2me img = (ImageJ2me) source;
      return createImage(img.getImage());
   }

   public IImage createImage(IImage image, int x, int y, int width, int height, int transform) {
      ImageJ2me img = (ImageJ2me) image;
      return createImage(img, x, y, width, height, transform);
   }

   public IImage createImage(Image source) {
      return new ImageJ2me(Image.createImage(source), dd);
   }

   public IImage createImage(Image image, int x, int y, int width, int height, int transform) {
      return new ImageJ2me(Image.createImage(image, x, y, width, height, transform), dd);
   }

   public IImage createImage(InputStream is) throws IOException {
      return new ImageJ2me(Image.createImage(is), dd);
   }

   public IImage createImage(int w, int h) {
      return new ImageJ2me(Image.createImage(w, h), dd);

   }

   public IImage createImage(int w, int h, int color) {
      Image i = Image.createImage(w, h);
      Graphics g = i.getGraphics();
      g.setColor(color);
      g.fillRect(0, 0, w, h);
      ImageJ2me ij = new ImageJ2me(i, dd);
      return ij;
   }

   public IImage createImage(String name) throws IOException {
      return new ImageJ2me(Image.createImage(name), dd);
   }

   public IImage createRGBImage(int[] rgb, int width, int height, boolean processAlpha) {
      return new ImageJ2me(Image.createRGBImage(rgb, width, height, processAlpha), dd);
   }

}
