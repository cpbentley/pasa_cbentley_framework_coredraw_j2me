package pasa.cbentley.framework.core.draw.j2me.engine;

import javax.microedition.lcdui.Font;

import pasa.cbentley.framework.core.draw.j2me.ctx.CoreDrawJ2meCtx;
import pasa.cbentley.framework.coredraw.src4.engine.FontAbstract;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;

public class FontJ2me extends FontAbstract implements IMFont {

   protected final CoreDrawJ2meCtx cdc;

   /**
    * 
    */
   private Font                    f;

   public FontJ2me(CoreDrawJ2meCtx cdc, Font f) {
      super(cdc);
      this.cdc = cdc;
      this.f = f;
   }

   public int charsWidth(char[] c, int ofs, int len) {
      return f.charsWidth(c, ofs, len);
   }

   public int charWidth(char ch) {
      return f.charWidth(ch);
   }

   public int getBaselinePosition() {
      return 0;
   }

   public int getFace() {
      return f.getFace();
   }

   public Font getFont() {
      return f;
   }

   public int getHeight() {
      return f.getHeight();
   }

   public String getName() {
      return "J2MEFont";
   }

   public int getSize() {
      return f.getSize();
   }

   public int getStyle() {
      return f.getStyle();
   }

   public int getWidthWeigh() {
      return stringWidth("m");
   }

   public boolean isMonospace() {
      if (f.getFace() == ITechFont.FACE_MONOSPACE) {
         return true;
      }
      return stringWidth("m") == stringWidth("i");
   }

   public boolean isSupported(int flag) {
      return false;
   }

   public int stringWidth(String s) {
      return f.stringWidth(s);
   }

   public int substringWidth(String s, int offset, int length) {
      return f.substringWidth(s, offset, length);
   }

}
