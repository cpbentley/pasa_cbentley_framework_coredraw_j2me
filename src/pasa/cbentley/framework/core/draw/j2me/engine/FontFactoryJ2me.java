package pasa.cbentley.framework.core.draw.j2me.engine;

import java.io.InputStream;

import javax.microedition.lcdui.Font;

import pasa.cbentley.framework.core.draw.j2me.ctx.CoreDrawJ2meCtx;
import pasa.cbentley.framework.coredraw.src4.engine.FontFactoryAbstract;
import pasa.cbentley.framework.coredraw.src4.engine.VisualState;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;
import pasa.cbentley.layouter.src4.tech.ITechLayout;

public class FontFactoryJ2me extends FontFactoryAbstract {

   protected final CoreDrawJ2meCtx cdc;

   FontJ2me                        defaultFont;

   /**
    * <li> {@link ISizer#SIZE_0_NONE} = 0
    * <li> {@link ISizer#SIZE_1_SMALLEST} = 1
    * <li> {@link ISizer#SIZE_2_SMALL} = 2
    * <li> {@link ISizer#SIZE_3_MEDIUM} = 3
    * <li> {@link ISizer#SIZE_4_BIG} = 5
    * <li> {@link ISizer#SIZE_5_BIGGEST} = 10
    * 
    */
   int[]                           scalePadding = new int[] { 0, 2, 4, 5, 6, 8, 10 };

   public FontFactoryJ2me(CoreDrawJ2meCtx j2meCtx) {
      super(j2meCtx);
      this.cdc = j2meCtx;
   }

   protected IMFont createFont(int face, int style, int size) {
      Font f = Font.getFont(face, style, size);
      return new FontJ2me(cdc, f);
   }

   public VisualState fontSizeDecrease() {
      // TODO Auto-generated method stub
      return null;
   }

   /**
    * Increasing the Font sizes means {@link FontJ2me} increase
    * <li> small
    * <li> small bold
    * <li> normal
    * <li> normal bold
    * <br>
    * <br>
    * 
    * TODO update the font cache by changing the font
    * TODO canvas settings: number of font increases from the default setting
    * <br>
    * <br>
    * Compared to J2SE, we cannot increase font points.
    */
   public VisualState fontSizeIncrease() {
      // TODO Auto-generated method stub
      return null;
   }

   public IMFont getDefaultFont() {
      if (defaultFont == null) {
         defaultFont = new FontJ2me(cdc, Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
      }
      return defaultFont;
   }

   public IMFont getDefaultFontMono() {
      return null;
   }

   public IMFont getDefaultFontProportional() {
      return null;
   }

   public IMFont getFont(int face, int style, int size) {
      if (size == IMFont.SIZE_5_HUGE) {
         size = Font.SIZE_LARGE;
      } else if (size == IMFont.SIZE_1_TINY) {
         size = Font.SIZE_SMALL;
      }
      return new FontJ2me(cdc, Font.getFont(face, style, size));
   }

   /**
    * J2ME does not support custom fonts. Returns the default font
    */
   public IMFont getFont(String face, int style, int fontPoint) {
      return getDefaultFont();
   }

   public IMFont getFontDebug() {
      if (z_refFontDebug == null)
         z_refFontDebug = getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
      return z_refFontDebug;
   }

   /**
    * 
    * @param string
    * @return
    */
   public int getFontFaceID(String string) {
      return IMFont.FACE_SYSTEM;
   }

   public String[] getFontFamilies() {
      // TODO Auto-generated method stub
      return null;
   }

   public String getFontName() {
      return null;
   }

   public String[] getFontNames() {
      return null;
   }

   public int getFontPoint(int size) {
      return 0;
   }

   public int getFontPointExtraShift() {
      return 0;
   }

   public int[] getFontPoints() {
      //not supported
      return null;
   }

   public float getFontScale(int size) {
      return 1;
   }

   public IMFont getFontScaled(int sizeHint, int w, int h) {
      return getDefaultFont();
   }

   public int getScalePixel(int valu, int fun) {
      if (fun == ITechLayout.SCALE_0_PADDING) {
         return scalePadding[fun];
      } else if (fun == ITechLayout.SCALE_1_EXPO) {
         return scalePadding[fun];
      } else {
         throw new IllegalArgumentException();
      }
   }

   /**
    * Look up in the ressources for the font.
    * returns Face ID or -1 if not found
    * @param string
    * @return
    */
   public int loadCustomFont(String string) {
      return -1;
   }

   public void loadFont(InputStream is, String string) {
      // TODO Auto-generated method stub

   }

   public void paintDone() {

   }

   public void setFontName(String name) {

   }

   public void setFontRatio(int ratio, int etalon) {

   }

}
