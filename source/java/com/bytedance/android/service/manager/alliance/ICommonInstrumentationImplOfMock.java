package com.bytedance.android.service.manager.alliance;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes3.dex */
public class ICommonInstrumentationImplOfMock implements ICommonInstrumentation {
    @Override // com.bytedance.android.service.manager.alliance.ICommonInstrumentation
    public void initInstrumentation() {
    }

    @Override // com.bytedance.android.service.manager.alliance.ICommonInstrumentation
    public int getStartInstrumentationFlag() {
        Log.w("ICommonInstrumentation", "cur getStartInstrumentationFlag method is empty impl in ICommonInstrumentationImplOfMockClass");
        return 0;
    }

    @Override // com.bytedance.android.service.manager.alliance.ICommonInstrumentation
    public IBinder getBinder() {
        Log.w("ICommonInstrumentation", "cur getBinder method is empty impl in ICommonInstrumentationImplOfMockClass");
        return null;
    }

    @Override // com.bytedance.android.service.manager.alliance.ICommonInstrumentation
    public boolean startInstrumentation(ComponentName componentName, Bundle bundle) {
        Log.w("ICommonInstrumentation", "cur startInstrumentation method is empty impl in ICommonInstrumentationImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.ICommonInstrumentation
    public boolean startInstrumentation(ComponentName componentName, Bundle bundle, int i) {
        Log.w("ICommonInstrumentation", "cur startInstrumentation method is empty impl in ICommonInstrumentationImplOfMockClass");
        return false;
    }
}
