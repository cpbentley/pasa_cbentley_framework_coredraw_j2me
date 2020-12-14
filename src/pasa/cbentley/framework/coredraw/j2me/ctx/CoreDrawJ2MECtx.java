package pasa.cbentley.framework.coredraw.j2me.ctx;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.byteobjects.src4.ctx.IConfigBO;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.framework.coredraw.j2me.engine.J2MEFontFactory;
import pasa.cbentley.framework.coredraw.j2me.engine.J2MEImageFactory;
import pasa.cbentley.framework.coredraw.j2me.engine.ScalerJ2ME;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.IConfigCoreDraw;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImageFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IScaler;

public class CoreDrawJ2MECtx extends CoreDrawCtx {

   private J2MEFontFactory  factoryFont;

   private J2MEImageFactory factoryImage;

   private ScalerJ2ME       scaler;

   protected final MIDlet   midlet;

   /**
    * 
    * @param uc
    * @param boc
    * @param midlet
    * @param configDraw hardcoded version of the config.
    */
   public CoreDrawJ2MECtx(UCtx uc, BOCtx boc, MIDlet midlet, IConfigCoreDraw configDraw) {
      super(configDraw, boc);
      this.midlet = midlet;
      factoryFont = new J2MEFontFactory(this);
      factoryImage = new J2MEImageFactory(this);
      scaler = new ScalerJ2ME(this);
   }
   

   protected void matchConfig(IConfigBO config, ByteObject settings) {

   }

   public IImageFactory getImageFactory() {
      return factoryImage;
   }
   
   public MIDlet getMidlet() {
      return midlet;
   }

   public IFontFactory getFontFactory() {
      return factoryFont;
   }

   protected String getDefaultFontNameSystemSub() {
      return "Courier New";
   }

   protected String getDefaultFontNamePropSub() {
      return "Courier New";
   }

   public IScaler getScaler() {
      return scaler;
   }

   public boolean hasFeatureSupport(int supportID) {
      switch (supportID) {
         case SUP_ID_06_CUSTOM_FONTS:
            return false;
         case SUP_ID_07_IMAGE_SCALING:
            return false;
         default:
            break;
      }
      return false;
   }


   public void callSerially(Runnable run) {
      Display display = Display.getDisplay(midlet);
      display.callSerially(run);
   }


   public int getFeatureInt(int featureID) {
      // TODO Auto-generated method stub
      return 0;
   }


   public Object getFeatureObject(int featureID) {
      // TODO Auto-generated method stub
      return null;
   }


   public boolean featureEnable(int featureID, boolean b) {
      // TODO Auto-generated method stub
      return false;
   }


   public boolean isFeatureEnabled(int featureID) {
      // TODO Auto-generated method stub
      return false;
   }

}
