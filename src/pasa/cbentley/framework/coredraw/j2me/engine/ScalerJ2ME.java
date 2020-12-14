package pasa.cbentley.framework.coredraw.j2me.engine;


import pasa.cbentley.framework.coredraw.j2me.ctx.CoreDrawJ2MECtx;
import pasa.cbentley.framework.coredraw.src4.interfaces.IScaler;

public class ScalerJ2ME implements IScaler {

   protected final CoreDrawJ2MECtx cdsc;

   public ScalerJ2ME(CoreDrawJ2MECtx cdsc) {
      this.cdsc = cdsc;
   }

   public int getScalePixel(int valu, int fun) {
      throw new RuntimeException();
   }
   
}
