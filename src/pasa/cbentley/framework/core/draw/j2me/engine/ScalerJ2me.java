package pasa.cbentley.framework.core.draw.j2me.engine;

import pasa.cbentley.framework.core.draw.j2me.ctx.CoreDrawJ2meCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.ObjectCDC;
import pasa.cbentley.framework.coredraw.src4.interfaces.IScaler;
import pasa.cbentley.layouter.src4.tech.ITechLayout;

public class ScalerJ2me extends ObjectCDC implements IScaler {

   /**
    * <li> {@link ISizer#SIZE_0_NONE} = 0
    * <li> {@link ISizer#SIZE_1_SMALLEST} = 1
    * <li> {@link ISizer#SIZE_2_SMALL} = 2
    * <li> {@link ISizer#SIZE_3_MEDIUM} = 3
    * <li> {@link ISizer#SIZE_4_BIG} = 5
    * <li> {@link ISizer#SIZE_5_BIGGEST} = 10
    * 
    */
   int[] scalePadding = new int[] { 0, 2, 4, 5, 6, 8, 10 };

   public ScalerJ2me(CoreDrawJ2meCtx cdc) {
      super(cdc);
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
}
