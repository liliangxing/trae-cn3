package com.bytedance.trae.push.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.trae.push.api.IPushService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IPushService.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J*\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H&J\u001a\u0010\u0014\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\u0010H&J\u0010\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018H&J&\u0010\u001a\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&¨\u0006 "}, d2 = {"Lcom/bytedance/trae/push/api/IPushService;", "", "initAndStart", "", "asyncStartPush", "isNotificationPermissionGranted", "", "openSystemNotificationSetting", "applyRedBadgeCount", "count", "", "requestNotificationPermission", "trackClickPush", "context", "Landroid/content/Context;", "pushModel", "", "isFromNotification", "extra", "Lorg/json/JSONObject;", "onPushClick", PraiseDialogConstant.FROM, "getPushContentType", "getPushActivityClazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "showNotification", "intent", "Landroid/content/Intent;", "body", "Lcom/bytedance/trae/push/api/TraeNotificationBody;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPushService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void applyRedBadgeCount(int count);

    void asyncStartPush();

    Class<? extends Activity> getPushActivityClazz();

    String getPushContentType();

    void initAndStart();

    boolean isNotificationPermissionGranted();

    void onPushClick(String pushModel, int from);

    void openSystemNotificationSetting();

    void requestNotificationPermission();

    boolean showNotification(Context context, Intent intent, TraeNotificationBody body);

    void trackClickPush(Context context, String pushModel, boolean isFromNotification, JSONObject extra);

    /* compiled from: IPushService.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J*\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001fH\u0016J&\u0010!\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006&"}, d2 = {"Lcom/bytedance/trae/push/api/IPushService$Companion;", "Lcom/bytedance/trae/push/api/IPushService;", "<init>", "()V", "inst", "getInst", "()Lcom/bytedance/trae/push/api/IPushService;", "inst$delegate", "Lkotlin/Lazy;", "initAndStart", "", "asyncStartPush", "isNotificationPermissionGranted", "", "openSystemNotificationSetting", "applyRedBadgeCount", "count", "", "requestNotificationPermission", "trackClickPush", "context", "Landroid/content/Context;", "pushModel", "", "isFromNotification", "extra", "Lorg/json/JSONObject;", "onPushClick", PraiseDialogConstant.FROM, "getPushContentType", "getPushActivityClazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "showNotification", "intent", "Landroid/content/Intent;", "body", "Lcom/bytedance/trae/push/api/TraeNotificationBody;", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion implements IPushService {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* renamed from: inst$delegate, reason: from kotlin metadata */
        private static final Lazy<IPushService> inst = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.push.api.IPushService$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                IPushService inst_delegate$lambda$0;
                inst_delegate$lambda$0 = IPushService.Companion.inst_delegate$lambda$0();
                return inst_delegate$lambda$0;
            }
        });

        private Companion() {
        }

        private final IPushService getInst() {
            return (IPushService) inst.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final IPushService inst_delegate$lambda$0() {
            try {
                return (IPushService) ServiceManager.get().getService(IPushService.class);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // com.bytedance.trae.push.api.IPushService
        public void initAndStart() {
            IPushService inst2 = getInst();
            if (inst2 != null) {
                inst2.initAndStart();
            }
        }

        @Override // com.bytedance.trae.push.api.IPushService
        public void asyncStartPush() {
            IPushService inst2 = getInst();
            if (inst2 != null) {
                inst2.asyncStartPush();
            }
        }

        @Override // com.bytedance.trae.push.api.IPushService
        public boolean isNotificationPermissionGranted() {
            IPushService inst2 = getInst();
            if (inst2 != null) {
                return inst2.isNotificationPermissionGranted();
            }
            return false;
        }

        @Override // com.bytedance.trae.push.api.IPushService
        public void openSystemNotificationSetting() {
            IPushService inst2 = getInst();
            if (inst2 != null) {
                inst2.openSystemNotificationSetting();
            }
        }

        @Override // com.bytedance.trae.push.api.IPushService
        public void applyRedBadgeCount(int count) {
            IPushService inst2 = getInst();
            if (inst2 != null) {
                inst2.applyRedBadgeCount(count);
            }
        }

        @Override // com.bytedance.trae.push.api.IPushService
        public void requestNotificationPermission() {
            IPushService inst2 = getInst();
            if (inst2 != null) {
                inst2.requestNotificationPermission();
            }
        }

        @Override // com.bytedance.trae.push.api.IPushService
        public void trackClickPush(Context context, String pushModel, boolean isFromNotification, JSONObject extra) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(extra, "extra");
            IPushService inst2 = getInst();
            if (inst2 != null) {
                inst2.trackClickPush(context, pushModel, isFromNotification, extra);
            }
        }

        @Override // com.bytedance.trae.push.api.IPushService
        public void onPushClick(String pushModel, int from) {
            IPushService inst2 = getInst();
            if (inst2 != null) {
                inst2.onPushClick(pushModel, from);
            }
        }

        @Override // com.bytedance.trae.push.api.IPushService
        public String getPushContentType() {
            String pushContentType;
            IPushService inst2 = getInst();
            return (inst2 == null || (pushContentType = inst2.getPushContentType()) == null) ? "" : pushContentType;
        }

        @Override // com.bytedance.trae.push.api.IPushService
        public Class<? extends Activity> getPushActivityClazz() {
            Class<? extends Activity> pushActivityClazz;
            IPushService inst2 = getInst();
            return (inst2 == null || (pushActivityClazz = inst2.getPushActivityClazz()) == null) ? Activity.class : pushActivityClazz;
        }

        @Override // com.bytedance.trae.push.api.IPushService
        public boolean showNotification(Context context, Intent intent, TraeNotificationBody body) {
            IPushService inst2 = getInst();
            if (inst2 != null) {
                return inst2.showNotification(context, intent, body);
            }
            return false;
        }
    }
}
