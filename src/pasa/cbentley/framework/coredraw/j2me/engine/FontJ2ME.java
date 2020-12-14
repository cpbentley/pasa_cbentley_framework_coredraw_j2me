package pasa.cbentley.framework.coredraw.j2me.engine;

import javax.microedition.lcdui.Font;

import pasa.cbentley.framework.coredraw.j2me.ctx.CoreDrawJ2MECtx;
import pasa.cbentley.framework.coredraw.src4.engine.FontAbstract;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;

public class FontJ2ME extends FontAbstract implements IMFont {

   /**
    * 
    */
   private Font                    f;

   private Font                    definition;

   protected final CoreDrawJ2MECtx cdc;

   public FontJ2ME(CoreDrawJ2MECtx cdc, Font f) {
      super(cdc);
      this.cdc = cdc;
      this.f = f;
      this.definition = f;
   }

   public boolean isSupported(int flag) {
      return false;
   }

   public int getFace() {
      return f.getFace();
   }

   public int getStyle() {
      return f.getStyle();
   }

   public int getSize() {
      return f.getSize();
   }

   public int getWidthWeigh() {
      return stringWidth("m");
   }

   public int charsWidth(char[] c, int ofs, int len) {
      return f.charsWidth(c, ofs, len);
   }

   public int charWidth(char ch) {
      return f.charWidth(ch);
   }

   public int stringWidth(String s) {
      return f.stringWidth(s);
   }

   public int substringWidth(String s, int offset, int length) {
      return f.substringWidth(s, offset, length);
   }

   public int getHeight() {
      return f.getHeight();
   }

   public Font getFont() {
      return f;
   }

   public String getName() {
      return "J2MEFont";
   }

   public int getBaselinePosition() {
      return 0;
   }
   
   
}
