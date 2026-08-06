package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.xbridge.cn.runtime.model.SettingKeyEntry;
import com.bytedance.sdk.xbridge.cn.runtime.model.SettingValueEntry;
import com.bytedance.webx.core.webview.WebViewContainer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostContextDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u0000 \"2\u00020\u0001:\u0001\"J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\n\u0010\f\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0005H&J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012H&J\b\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0005H&J\b\u0010\u0018\u001a\u00020\u0005H&J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u0005H&J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001dH&J\b\u0010\u001f\u001a\u00020\u001dH&J\b\u0010 \u001a\u00020\u001dH&J\b\u0010!\u001a\u00020\u001dH&¨\u0006#"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend;", "", "getAppId", "", "getAppName", "", "getApplication", "Landroid/app/Application;", "getApplicationContext", "Landroid/content/Context;", "getBoeChannel", "getChannel", "getCurrentTelcomCarrier", "getDeviceId", "getLanguage", "getPPEChannel", "getPackageName", WebViewContainer.EVENT_getSettings, "", "Lcom/bytedance/sdk/xbridge/cn/runtime/model/SettingValueEntry;", "settingKeys", "Lcom/bytedance/sdk/xbridge/cn/runtime/model/SettingKeyEntry;", "getSkinName", "getSkinType", "getUpdateVersion", "getVersionCode", "", "getVersionName", "isBaseMode", "", "isBoeEnable", "isDebuggable", "isPPEEnable", "isTeenMode", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostContextDepend {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String SKIN_TYPE_BLACK = "black";
    public static final String SKIN_TYPE_WHITE = "white";

    int getAppId();

    String getAppName();

    Application getApplication();

    Context getApplicationContext();

    String getBoeChannel();

    String getChannel();

    String getCurrentTelcomCarrier();

    String getDeviceId();

    String getLanguage();

    String getPPEChannel();

    String getPackageName();

    List<SettingValueEntry> getSettings(List<SettingKeyEntry> settingKeys);

    String getSkinName();

    String getSkinType();

    String getUpdateVersion();

    long getVersionCode();

    String getVersionName();

    boolean isBaseMode();

    boolean isBoeEnable();

    boolean isDebuggable();

    boolean isPPEEnable();

    boolean isTeenMode();

    /* compiled from: IHostContextDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend$Companion;", "", "()V", "SKIN_TYPE_BLACK", "", "SKIN_TYPE_WHITE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String SKIN_TYPE_BLACK = "black";
        public static final String SKIN_TYPE_WHITE = "white";

        private Companion() {
        }
    }

    /* compiled from: IHostContextDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static Context getApplicationContext(IHostContextDepend iHostContextDepend) {
            Context applicationContext = iHostContextDepend.getApplication().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplication().applicationContext");
            return applicationContext;
        }
    }
}
