package pasa.cbentley.framework.core.draw.j2me.engine;

import pasa.cbentley.core.src4.interfaces.ITimeCtrl;

public class TimeControlJ2me implements ITimeCtrl {

   /**
    * This method can only be used to measure elapsed time and is not related to any other notion of system or wall-clock time. The value returned represents nanoseconds since some fixed but arbitrary time (perhaps in the future, so values may be negative). This method provides nanosecond precision, but not necessarily nanosecond accuracy. No guarantees are made about how frequently values change. Differences in successive calls that span greater than approximately 292 years (263 nanoseconds) will not accurately compute elapsed time due to numerical overflow.
    */
   public long getTickNano() {
      return System.currentTimeMillis() * 1000000;
   }

   public long getNowClock() {
      return System.currentTimeMillis();
   }

   /**
    * This method can only be used to measure elapsed time and is not related to any other notion of system or wall-clock time. The value returned represents nanoseconds since some fixed but arbitrary time (perhaps in the future, so values may be negative). This method provides nanosecond precision, but not necessarily nanosecond accuracy. No guarantees are made about how frequently values change. Differences in successive calls that span greater than approximately 292 years (263 nanoseconds) will not accurately compute elapsed time due to numerical overflow.
    */
   public long getTickMillis() {
      return System.currentTimeMillis();
   }
}
