package pasa.cbentley.framework.core.draw.j2me.engine;

import java.io.InputStream;

import javax.microedition.lcdui.Font;

import pasa.cbentley.framework.core.draw.j2me.ctx.CoreDrawJ2meCtx;
import pasa.cbentley.framework.coredraw.src4.engine.FontFactoryAbstract;
import pasa.cbentley.framework.coredraw.src4.engine.VisualState;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;
import pasa.cbentley.layouter.src4.tech.ITechLayout;

public class FontFactoryJ2me extends FontFactoryAbstract {

   protected final CoreDrawJ2meCtx cdc;

   FontJ2me                        defaultFont;

   public FontFactoryJ2me(CoreDrawJ2meCtx j2meCtx) {
      super(j2meCtx);
      this.cdc = j2meCtx;
   }

   protected IMFont createFont(int face, int style, int size) {
      face = getMapFace(face);
      style = getMapStyle(style);
      size = getMapSize(size);
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



   private int getMapFace(int face) {
      switch (face) {
         case ITechFont.FACE_01_MONOSPACE:
            return Font.FACE_MONOSPACE;
         case ITechFont.FACE_02_PROPORTIONAL:
            return Font.FACE_PROPORTIONAL;
         default:
            return Font.FACE_SYSTEM;
      }
   }

   private int getMapStyle(int style) {
      switch (style) {
         case ITechFont.STYLE_1_BOLD:
            return Font.STYLE_BOLD;
         case ITechFont.STYLE_2_ITALIC:
            return Font.STYLE_ITALIC;
         case ITechFont.STYLE_3_UNDERLINED:
            return Font.STYLE_UNDERLINED;
         default:
            return Font.STYLE_PLAIN;
      }
   }
   private int getMapSize(int size) {
      if (size == IMFont.SIZE_5_HUGE) {
         size = Font.SIZE_LARGE;
      } else if (size == IMFont.SIZE_1_TINY) {
         size = Font.SIZE_SMALL;
      }
      return size;
   }

   /**
    * J2ME does not support custom fonts. Returns the default font
    */
   public IMFont getFont(String face, int style, int fontPoint) {
      return getDefaultFont();
   }


   /**
    * 
    * @param string
    * @return
    */
   public int getFontFaceID(String string) {
      return IMFont.FACE_00_SYSTEM;
   }

   public String[] getFontFamilies() {
      // TODO Auto-generated method stub
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
      //not supported
   }

   public void setFontName(String name) {

   }

   public void setFontRatio(int ratio, int etalon) {

   }

}
