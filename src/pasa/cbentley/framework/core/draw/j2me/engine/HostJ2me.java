package pasa.cbentley.framework.core.draw.j2me.engine;

import java.io.IOException;
import java.io.InputStream;

import pasa.cbentley.core.src4.interfaces.IExecutor;
import pasa.cbentley.core.src4.interfaces.IHost;
import pasa.cbentley.core.src4.interfaces.IHostData;
import pasa.cbentley.core.src4.interfaces.IHostFeature;
import pasa.cbentley.core.src4.interfaces.IHostService;
import pasa.cbentley.core.src4.interfaces.ITimeCtrl;
import pasa.cbentley.framework.core.draw.j2me.ctx.CoreDrawJ2meCtx;
import pasa.cbentley.framework.coredraw.src4.ctx.ObjectCDC;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechHostDataDraw;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechHostFeatureDraw;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechHostServiceDraw;

/**
 * Since J2me does not support much, we put everything in a single class
 * 
 * @author Charles Bentley
 *
 */
public class HostJ2me extends ObjectCDC implements ITechHostDataDraw, ITechHostFeatureDraw, ITechHostServiceDraw, IHostData, IHost, IHostFeature, IHostService {

   private ExecutorJ2me    executor;

   private TimeControlJ2me timeCtrl;

   public HostJ2me(CoreDrawJ2meCtx cdc) {
      super(cdc);

      executor = new ExecutorJ2me(cdc);
      timeCtrl = new TimeControlJ2me();
   }

   public boolean setHostServiceActive(int serviceID, boolean isActive) {
      //no service in j2me
      return false;
   }

   public boolean setHostServiceOn(int serviceID) {
      //no service in j2me
      return false;
   }

   public boolean setHostServiceOff(int serviceID) {
      //no service in j2me
      return false;
   }

   public boolean isHostServiceSupported(int serviceID) {
      //no service in j2me
      return false;
   }

   public boolean isHostServiceActive(int serviceID) {
      //no service in j2me
      return false;
   }

   public boolean setHostFeatureEnabled(int featureID, boolean b) {
      //no features in j2me
      return false;
   }

   public boolean setHostFeatureOn(int featureID) {
      //no features in j2me
      return false;
   }

   public boolean setHostFeatureOff(int featureID) {
      //no features in j2me
      return false;
   }

   public boolean setHostFeatureEnabledFactory(int featureID, boolean b) {
      //no features in j2me
      return false;
   }

   public boolean setHostFeatureFactoryOn(int featureID) {
      //no features in j2me
      return false;
   }

   public boolean setHostFeatureFactoryOff(int featureID) {
      // TODO Auto-generated method stub
      return false;
   }

   public boolean isHostFeatureSupported(int featureID) {
      //no features in j2me
      return false;
   }

   public boolean isHostFeatureEnabled(int featureID) {
      //no features in j2me
      return false;
   }

   public boolean isHostFeatureFactoryEnabled(int featureID) {
      //no features in j2me
      return false;
   }

   public float getHostDataFloat(int dataID) {
      return Float.NaN;
   }

   public int getHostDataInt(int dataID) {
      // TODO Auto-generated method stub
      return 0;
   }

   public Object getHostDataObject(int dataID) {
      // TODO Auto-generated method stub
      return null;
   }

   public String getHostDataString(int dataID) {
      switch (dataID) {
         case DATA_ID_STR_01_MANUFACTURER:
            return "";
         case DATA_ID_STR_02_IMEI:
            //depends
            return "00000000";
         case DATA_ID_STR_04_PLATFORM:
            return "J2me";
         case DATA_ID_STR_03_DEVICE_MODEL:
            return System.getProperty("device.model");
         case DATA_ID_STR_06_ENCODING:
            return System.getProperty("file.encoding");
         default:
            throw new IllegalArgumentException("Unknown dataID=" + dataID);
      }

   }

   public InputStream getResourceAsStream(String file) throws IOException {
      return this.getClass().getResourceAsStream(file);
   }

   public ITimeCtrl getTimeCtrl() {
      return timeCtrl;
   }

   public IExecutor getExecutor() {
      return executor;
   }

   public IHostData getHostData() {
      return this;
   }

   public IHostFeature getHostFeature() {
      return this;
   }

   public IHostService getHostService() {
      return this;
   }

}
