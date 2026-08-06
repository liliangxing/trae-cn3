package com.bytedance.common.process.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.push_common_lib.ICrossProcessAIDL;
import java.util.List;

/* loaded from: classes3.dex */
public class BaseCrossProcessService extends Service {
    public static final String EXTRA_KEY_IS_FROM_ON_BIND = "is_from_on_bind";
    public static final String EXTRA_KEY_PROCESS = "process";
    private final String TAG = "BaseCrossProcessService";
    private Context mContext = this;
    private final ICrossProcessAIDL.Stub mBinder = new ICrossProcessAIDL.Stub() { // from class: com.bytedance.common.process.service.BaseCrossProcessService.1
        @Override // com.ss.android.push_common_lib.ICrossProcessAIDL
        public String invoke(String str, String str2, List list) throws RemoteException {
            Logger.d("BaseCrossProcessService", ToolUtils.getCurProcess(BaseCrossProcessService.this.mContext) + " process method " + str + "is called");
            return CrossProcessHelper.getInstance().onMethodCall(ProcessEnum.parseProcess(str2), str, list);
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ProcessEnum curProcess = ToolUtils.getCurProcess(this.mContext);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String string = extras.getString("process");
            if (!extras.getBoolean(EXTRA_KEY_IS_FROM_ON_BIND)) {
                Logger.d("BaseCrossProcessService", curProcess + " process service is called by " + string);
                AppProvider.initApp(getApplication());
                CrossProcessHelper.getInstance().onServiceBind(string);
            }
        }
        return this.mBinder;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 2;
    }
}
