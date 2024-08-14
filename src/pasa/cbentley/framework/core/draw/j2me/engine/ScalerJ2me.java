package pasa.cbentley.framework.core.draw.j2me.engine;


import pasa.cbentley.framework.core.draw.j2me.ctx.CoreDrawJ2meCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.ObjectCDC;
import pasa.cbentley.framework.coredraw.src4.interfaces.IScaler;

public class ScalerJ2me extends ObjectCDC implements IScaler {


   public ScalerJ2me(CoreDrawJ2meCtx cdc) {
      super(cdc);
   }

   public int getScalePixel(int valu, int fun) {
      throw new RuntimeException();
   }
   
}
