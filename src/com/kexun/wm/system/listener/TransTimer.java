package com.kexun.wm.system.listener;

import java.util.TimerTask;

public class TransTimer extends TimerTask {

	@Override
	public void run() {
 		try {
			/*自动的*/
//        CodeTransAction codeTransAction=new CodeTransAction();
//        codeTransAction.updateCodeTrans();
  		} catch (Exception e) {
 			e.printStackTrace();
		}
	}

}
