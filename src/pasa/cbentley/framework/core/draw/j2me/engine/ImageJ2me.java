package pasa.cbentley.framework.core.draw.j2me.engine;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import pasa.cbentley.framework.core.draw.j2me.ctx.CoreDrawJ2meCtx;
import pasa.cbentley.framework.coredraw.src4.engine.ImageAbstract;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImage;

public class ImageJ2me extends ImageAbstract implements IImage {

   private Image           img;

   private CoreDrawJ2meCtx dd;

   public ImageJ2me(Image img, CoreDrawJ2meCtx dd) {
      super(dd);
      this.img = img;
      this.dd = dd;
   }

   public Image getImage() {
      return img;
   }

   public int getWidth() {
      return img.getWidth();
   }

   public int getHeight() {
      return img.getHeight();
   }

   public boolean isMutable() {
      return img.isMutable();
   }

   public void getRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height) {
      img.getRGB(rgbData, offset, scanlength, x, y, width, height);
   }

   public IGraphics getGraphics() {
      Graphics g = img.getGraphics();
      return new GraphicsJ2me(g, dd);
   }
}
