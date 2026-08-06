package com.bytedance.ttnet.mpa;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService;
import java.util.List;

/* loaded from: classes4.dex */
public class TTNetMpaService {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CRONET_MPA_SERVICE_IMPL_CLASS = "org.chromium.mpa.CronetMpaServiceImpl";
    public static final String TAG = "TTNetMpaService";
    private IMpaService mMpsService;

    /* loaded from: classes4.dex */
    public enum HookMode {
        SYMBOL,
        BYTE,
        SHADOW
    }

    /* synthetic */ TTNetMpaService(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* loaded from: classes4.dex */
    private static class SingletonInstance {
        private static final TTNetMpaService INSTANCE = new TTNetMpaService(null);

        private SingletonInstance() {
        }
    }

    private TTNetMpaService() {
    }

    public static TTNetMpaService getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public void init(IMpaService.ICallback iCallback) {
        init(iCallback, HookMode.SYMBOL);
    }

    public void init(IMpaService.ICallback iCallback, HookMode hookMode) {
        int intValue;
        if (!tryResolveCronetMpaServiceImpl()) {
            iCallback.onFinish(false, "Load CronetMpaServiceImpl Failed");
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode[hookMode.ordinal()];
        if (i == 1) {
            try {
                intValue = ((Integer) Reflect.on(Class.forName("com.bytedance.android.bytehook.ByteHook").newInstance()).call("init").get()).intValue();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (i != 2) {
            if (i == 3) {
                intValue = 0;
            }
            intValue = -1;
        } else {
            try {
                intValue = ((Integer) Reflect.on(Class.forName("com.bytedance.shadowhook.ShadowHook").newInstance()).call("init").get()).intValue();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (intValue != 0) {
            iCallback.onFinish(false, "Hook Init Error " + intValue);
        } else {
            this.mMpsService.init(iCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.ttnet.mpa.TTNetMpaService$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode;

        static {
            int[] iArr = new int[HookMode.values().length];
            $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode = iArr;
            try {
                iArr[HookMode.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode[HookMode.SHADOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode[HookMode.SYMBOL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void setAccAddress(List<String> list, IMpaService.ICallback iCallback) {
        if (list == null || list.isEmpty()) {
            if (iCallback != null) {
                iCallback.onFinish(false, "Address error");
                return;
            }
            return;
        }
        IMpaService iMpaService = this.mMpsService;
        if (iMpaService != null) {
            iMpaService.setAccAddress(list, iCallback);
        } else if (iCallback != null) {
            iCallback.onFinish(false, "MpsService is null");
        }
    }

    private boolean tryResolveCronetMpaServiceImpl() {
        if (this.mMpsService != null) {
            return true;
        }
        try {
            this.mMpsService = (IMpaService) Class.forName(CRONET_MPA_SERVICE_IMPL_CLASS).newInstance();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.mMpsService != null;
    }

    public void start(String str) {
        IMpaService iMpaService = this.mMpsService;
        if (iMpaService != null) {
            iMpaService.start();
            command("begin_user_log", str);
        }
    }

    public void stop(String str) {
        if (this.mMpsService != null) {
            command("end_user_log", str);
            this.mMpsService.stop();
        }
    }

    private void command(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Logger.e(TAG, "error command:" + str + " extraMessage:" + str2);
            return;
        }
        IMpaService iMpaService = this.mMpsService;
        if (iMpaService != null) {
            iMpaService.command(str, str2);
        }
    }
}
