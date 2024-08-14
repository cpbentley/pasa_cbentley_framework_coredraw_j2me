package pasa.cbentley.framework.core.draw.j2me.engine;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.interfaces.IExecutor;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.thread.WorkerThread;
import pasa.cbentley.framework.core.draw.j2me.ctx.CoreDrawJ2meCtx;

public class ExecutorJ2me implements IExecutor {
   private CoreDrawJ2meCtx cdc;

   private Thread          mainThread;

   private WorkerThread    wt;

   public ExecutorJ2me(CoreDrawJ2meCtx cdc) {
      this.cdc = cdc;
   }

   public void executeMainLater(Runnable run) {
      MIDlet midlet = cdc.getMidlet();
      Display display = Display.getDisplay(midlet);
      display.callSerially(run);
   }

   public void executeMainNow(Runnable run) {
      if (this.isMainThread()) {
         run.run();
      } else {
         executeMainLater(run);
      }
   }

   public void executeWorker(Runnable run) {
      WorkerThread wt = getWT();
      wt.addToQueue(run);
   }

   public WorkerThread getWT() {
      if (wt == null) {
         wt = new WorkerThread(cdc.getUC());
      }
      return wt;
   }

   /**
    * Call this assumes no other thread is created outside
    * 2 cases. either 
    */
   public boolean isMainThread() {
      Thread current = Thread.currentThread();
      if (mainThread == null) {
         //assume we are the main thea
         if (wt == current) {
            return false;
         } else {
            return true;
         }
      } else {
         return mainThread == current;
      }
   }

   public void setMainThread(Thread t) {
      this.mainThread = t;
   }

   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, ExecutorJ2me.class, 48);
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ExecutorJ2me.class);
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return cdc.getUC();
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
