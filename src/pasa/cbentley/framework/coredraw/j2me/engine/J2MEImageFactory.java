package pasa.cbentley.framework.coredraw.j2me.engine;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import pasa.cbentley.framework.coredraw.j2me.ctx.CoreDrawJ2MECtx;
import pasa.cbentley.framework.coredraw.src4.engine.ImageFactoryAbstract;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImage;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFeaturesDraw;

public class J2MEImageFactory extends ImageFactoryAbstract {

   protected final CoreDrawJ2MECtx dd;

   public J2MEImageFactory(CoreDrawJ2MECtx j2meCtx) {
      super(j2meCtx);
      this.dd = j2meCtx;
   }

   public IImage createImage(InputStream is) throws IOException {
      return new ImageJ2ME(Image.createImage(is), dd);
   }

   public IImage createImage(int w, int h) {
      return new ImageJ2ME(Image.createImage(w, h), dd);

   }

   public IImage createImage(byte[] data, int start, int len) {
      return new ImageJ2ME(Image.createImage(data, start, len), dd);
   }

   public IImage createImage(Image image, int x, int y, int width, int height, int transform) {
      return new ImageJ2ME(Image.createImage(image, x, y, width, height, transform), dd);
   }

   public IImage createRGBImage(int[] rgb, int width, int height, boolean processAlpha) {
      return new ImageJ2ME(Image.createRGBImage(rgb, width, height, processAlpha), dd);
   }

   public IImage createImage(String name) throws IOException {
      return new ImageJ2ME(Image.createImage(name), dd);
   }

   public IImage createImage(Image source) {
      return new ImageJ2ME(Image.createImage(source), dd);
   }

   public IImage createImage(int w, int h, int color) {
      Image i = Image.createImage(w, h);
      Graphics g = i.getGraphics();
      g.setColor(color);
      g.fillRect(0, 0, w, h);
      ImageJ2ME ij = new ImageJ2ME(i, dd);
      return ij;
   }

   public IImage createImage(IImage image, int x, int y, int width, int height, int transform) {
      // TODO Auto-generated method stub
      return null;
   }

   public IImage createImage(IImage source) {
      // TODO Auto-generated method stub
      return null;
   }

   public boolean hasFeatureSupport(int supportID) {
      if (supportID == ITechFeaturesDraw.SUP_ID_06_CUSTOM_FONTS) {
         return false;
      } else if (supportID == ITechFeaturesDraw.SUP_ID_07_IMAGE_SCALING) {
         return false;
      }
      return false;
   }

}
