package pasa.cbentley.framework.coredraw.j2me.engine;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.utils.BitUtils;
import pasa.cbentley.framework.coredraw.j2me.ctx.CoreDrawJ2MECtx;
import pasa.cbentley.framework.coredraw.src4.engine.GraphicsAbstract;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImage;
import pasa.cbentley.framework.coredraw.src4.interfaces.IMFont;

public class GraphicsJ2ME extends GraphicsAbstract implements IGraphics {

   private Graphics        g;

   private CoreDrawJ2MECtx dd;

   private int             fwFlags;

   public GraphicsJ2ME(Graphics g, CoreDrawJ2MECtx dd) {
      super(dd);
      this.g = g;
      this.dd = dd;
   }

   public boolean hasImplementationFlag(int flag) {
      return BitUtils.hasFlag(fwFlags, flag);
   }

   public void clipRect(int x, int y, int width, int height) {
      g.clipRect(x, y, width, height);
   }

   public void copyArea(int x_src, int y_src, int width, int height, int x_dest, int y_dest, int anchor) {
      g.copyArea(x_src, y_src, width, height, x_dest, y_dest, anchor);
   }

   public void drawArc(int x, int y, int w, int h, int sa, int aa) {
      g.drawArc(x, y, w, h, sa, aa);
   }

   public void drawChar(char character, int x, int y, int anchor) {
      g.drawChar(character, x, y, anchor);
   }

   public void drawChars(char[] data, int offset, int length, int x, int y, int anchor) {
      g.drawChars(data, offset, length, x, y, anchor);
   }

   public void drawImage(IImage img, int x, int y, int anchor) {
      ImageJ2ME i = (ImageJ2ME) img;
      g.drawImage((Image) i.getImage(), x, y, anchor);
   }

   public void drawLine(int x1, int y1, int x2, int y2) {
      g.drawLine(x1, y1, x2, y2);
   }

   public void drawRect(int x, int y, int width, int height) {
      g.drawRect(x, y, width, height);
   }

   public void drawRegion(IImage src, int x_src, int y_src, int width, int height, int transform, int x_dst, int y_dst, int anchor) {
      ImageJ2ME i = (ImageJ2ME) src;
      g.drawRegion((Image) i.getImage(), x_src, y_src, width, height, transform, x_dst, y_dst, anchor);
   }

   public void drawRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height, boolean processAlpha) {
      g.drawRGB(rgbData, offset, scanlength, x, y, width, height, processAlpha);
   }

   public void drawRoundRect(int x, int y, int w, int h, int r1, int r2) {
      g.drawRoundRect(x, y, w, h, r1, r2);
   }

   public void drawString(String str, int x, int y, int anchor) {
      g.drawString(str, x, y, anchor);
   }

   public void drawSubstring(String str, int offset, int len, int x, int y, int anchor) {
      g.drawSubstring(str, offset, len, x, y, anchor);

   }

   public void fillArc(int x, int y, int w, int h, int sa, int aa) {
      g.fillArc(x, y, w, h, sa, aa);
   }

   public void fillRect(int x, int y, int width, int height) {
      g.fillRect(x, y, width, height);
   }

   public void fillRoundRect(int x, int y, int w, int h, int r1, int r2) {
      g.fillRoundRect(x, y, w, h, r1, r2);
   }

   public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
      g.fillTriangle(x1, y1, x2, y2, x3, y3);
   }

   public int getBlueComponent() {
      return g.getBlueComponent();
   }

   public int getClipHeight() {
      return g.getClipHeight();
   }

   public int getClipWidth() {
      return g.getClipWidth();
   }

   public int getClipX() {
      return g.getClipX();
   }

   public int getClipY() {
      return g.getClipY();
   }

   public int getColor() {
      return g.getColor();
   }

   public int getDisplayColor(int color) {
      return g.getDisplayColor(color);
   }

   protected IMFont myFont;

   public IMFont getFont() {
      return myFont;
   }

   /**
    * Creates a new Font
    */
   public IMFont getFont(int face, int style, int size) {
      return dd.getFontFactory().getFont(face, style, size);
   }

   public int getGrayScale() {
      return g.getGrayScale();
   }

   public int getGreenComponent() {
      return g.getGreenComponent();
   }

   public int getRedComponent() {
      return g.getRedComponent();
   }

   public int getStrokeStyle() {
      return g.getStrokeStyle();
   }

   public int getTranslateX() {
      return g.getTranslateX();
   }

   public int getTranslateY() {
      return g.getTranslateY();
   }

   public void setClip(int x, int y, int width, int height) {
      g.setClip(x, y, width, height);
   }

   public void setColor(int RGB) {
      g.setColor(RGB);
   }

   public void setColor(int red, int green, int blue) {
      g.setColor(red, green, blue);
   }

   public synchronized void setFont(IMFont font) {
      myFont = font;
      if (font instanceof FontJ2ME) {
         g.setFont((((FontJ2ME) font).getFont()));
      }
   }

   public void setGrayScale(int v) {
      g.setGrayScale(v);
   }

   public void setStrokeStyle(int style) {
      g.setStrokeStyle(style);
   }

   public boolean hasFeatureEnabled(int featureID) {
      return false;
   }

   public boolean featureEnable(int featureID, boolean enable) {
      return false;
   }

   public void translate(int x, int y) {
      g.translate(x, y);
   }

   //#mdebug

   public void toString(Dctx dc) {
      dc.root(this, "GraphicsJ2SE");
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "GraphicsJ2SE");
   }
   //#enddebug

}
