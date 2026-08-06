package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import android.os.Environment;
import bolts.Task;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.BidConstants;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.im.model.MessagePart;
import java.io.File;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UserDomainLocalStorageMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u000eJF\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/UserDomainLocalStorageMonitor;", "", "()V", "REPORTEVENT", "", "TAG", "calculateStorageSize", "", "storageName", "context", "Landroid/content/Context;", "getFolderSize", MessagePart.TYPE_FILE, "Ljava/io/File;", "(Ljava/io/File;)Ljava/lang/Long;", "report", "", IWeixinService.ResponseConstants.URL, "currentDataSize", "methodName", "platForm", PageDataManager.EXTRA_STATUS, "costTime", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserDomainLocalStorageMonitor {
    public static final UserDomainLocalStorageMonitor INSTANCE = new UserDomainLocalStorageMonitor();
    private static final String REPORTEVENT = "bdx_monitor_userdomain_localstorage";
    private static final String TAG = "UserDomainLocalStorageMonitor";

    private UserDomainLocalStorageMonitor() {
    }

    private final Long getFolderSize(File file) {
        long length;
        try {
            File[] listFiles = file.listFiles();
            Intrinsics.checkNotNullExpressionValue(listFiles, "fileList");
            long j = 0;
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    Intrinsics.checkNotNullExpressionValue(file2, "item");
                    Long folderSize = getFolderSize(file2);
                    length = folderSize != null ? folderSize.longValue() : 0L;
                } else {
                    length = file2.length();
                }
                j += length;
            }
            return Long.valueOf(j);
        } catch (Exception e) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "UserDomainLocalStorageMonitor-getFolderSize, error happen:" + e, (LogLevel) null, (String) null, 6, (Object) null);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long calculateStorageSize(String storageName, Context context) {
        Long folderSize;
        String packageName = context.getPackageName();
        try {
            File file = new File(Environment.getDataDirectory() + "/data/" + packageName + "/shared_prefs/" + (storageName + "_xbridge_storage.xml"));
            if (file.exists() && file.isFile()) {
                return file.length();
            }
            File file2 = new File(Environment.getDataDirectory() + "/data/" + packageName + "/files/keva/repo/" + (storageName + "_xbridge_storage"));
            if (file2.exists() && file2.isDirectory() && (folderSize = getFolderSize(file2)) != null) {
                return folderSize.longValue();
            }
            return 0L;
        } catch (Exception e) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "UserDomainLocalStorageMonitor-calcuteFileSize.Wrong Happen. ErrorMessage: " + e, (LogLevel) null, (String) null, 6, (Object) null);
            return 0L;
        }
    }

    public final void report(final String storageName, final Context context, final String url, final long currentDataSize, final String methodName, final String platForm, final String status, final long costTime) {
        Intrinsics.checkNotNullParameter(storageName, "storageName");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(platForm, "platForm");
        Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
        Task.callInBackground(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainLocalStorageMonitor$report$1
            @Override // java.util.concurrent.Callable
            public final Unit call() {
                long calculateStorageSize;
                calculateStorageSize = UserDomainLocalStorageMonitor.INSTANCE.calculateStorageSize(storageName, context);
                if (calculateStorageSize < 0) {
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "UserDomainLocalStorageMonitor-report.Wrong Happen.Calcute Size: " + calculateStorageSize, (LogLevel) null, (String) null, 6, (Object) null);
                    return Unit.INSTANCE;
                }
                ReportInfo reportInfo = new ReportInfo("bdx_monitor_userdomain_localstorage", (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
                String str = platForm;
                String str2 = methodName;
                String str3 = url;
                String str4 = status;
                long j = currentDataSize;
                long j2 = costTime;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("method_name", str2);
                jSONObject.put("origin_url", str3);
                jSONObject.put(PageDataManager.EXTRA_STATUS, str4);
                reportInfo.setCategory(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("current_data_size", j);
                jSONObject2.put("stored_data_size", calculateStorageSize);
                jSONObject2.put("cost_time", j2);
                reportInfo.setMetrics(jSONObject2);
                reportInfo.setPlatform(str);
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "UserDomainLocalStorageMonitor-report. Info: " + reportInfo.getMetrics() + ',' + reportInfo.getCategory(), (LogLevel) null, (String) null, 6, (Object) null);
                IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(BidConstants.DEFAULT, IMonitorReportService.class);
                if (iMonitorReportService == null) {
                    return null;
                }
                iMonitorReportService.report(reportInfo);
                return Unit.INSTANCE;
            }
        });
    }
}
