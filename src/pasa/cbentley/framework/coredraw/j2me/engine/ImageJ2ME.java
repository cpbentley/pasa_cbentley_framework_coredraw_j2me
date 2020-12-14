package pasa.cbentley.framework.coredraw.j2me.engine;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import pasa.cbentley.framework.coredraw.j2me.ctx.CoreDrawJ2MECtx;
import pasa.cbentley.framework.coredraw.src4.engine.ImageAbstract;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImage;

public class ImageJ2ME extends ImageAbstract implements IImage {

   private Image           img;

   private CoreDrawJ2MECtx dd;

   public ImageJ2ME(Image img, CoreDrawJ2MECtx dd) {
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
      return new GraphicsJ2ME(g, dd);
   }
}
