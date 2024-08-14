package pasa.cbentley.framework.core.draw.j2me.ctx;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.framework.core.draw.j2me.engine.FontFactoryJ2me;
import pasa.cbentley.framework.core.draw.j2me.engine.HostJ2me;
import pasa.cbentley.framework.core.draw.j2me.engine.ImageFactoryJ2me;
import pasa.cbentley.framework.core.draw.j2me.engine.ScalerJ2me;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.IConfigCoreDraw;
import pasa.cbentley.framework.coredraw.src4.interfaces.IFontFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IImageFactory;
import pasa.cbentley.framework.coredraw.src4.interfaces.IScaler;

public class CoreDrawJ2meCtx extends CoreDrawCtx {

   private FontFactoryJ2me  factoryFont;

   private ImageFactoryJ2me factoryImage;

   private HostJ2me         hostJ2me;

   protected final MIDlet   midlet;

   private ScalerJ2me       scaler;

   /**
    * 
    * @param uc
    * @param boc
    * @param midlet
    * @param configDraw hardcoded version of the config.
    */
   public CoreDrawJ2meCtx(UCtx uc, BOCtx boc, MIDlet midlet, IConfigCoreDraw configDraw) {
      super(configDraw, boc);
      this.midlet = midlet;
      factoryFont = new FontFactoryJ2me(this);
      factoryImage = new ImageFactoryJ2me(this);
      scaler = new ScalerJ2me(this);
      hostJ2me = new HostJ2me(this);

   }


   public IFontFactory getFontFactory() {
      return factoryFont;
   }

   public HostJ2me getHostJ2me() {
      return hostJ2me;
   }

   public IImageFactory getImageFactory() {
      return factoryImage;
   }

   public MIDlet getMidlet() {
      return midlet;
   }

   public IScaler getScaler() {
      return scaler;
   }

}
