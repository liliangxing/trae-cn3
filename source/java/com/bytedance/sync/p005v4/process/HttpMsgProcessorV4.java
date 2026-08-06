package com.bytedance.sync.p005v4.process;

import android.content.Context;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.sync.SyncConstants;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.ICompensatorServiceV4;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.IHttpMsgProcessor;
import com.bytedance.sync.p005v4.presistence.DBServiceImplV4;
import com.bytedance.sync.settings.SyncSettings;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpMsgProcessorV4.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0016J*\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sync/v4/process/HttpMsgProcessorV4;", "Lcom/bytedance/sync/v4/intf/IHttpMsgProcessor;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "check", "", "clearDatabase", "closeSync", "process", "", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "headers", "", "bodyString", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HttpMsgProcessorV4 implements IHttpMsgProcessor {
    private final Context context;

    public HttpMsgProcessorV4(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.bytedance.sync.p005v4.intf.IHttpMsgProcessor
    public String process(SsResponse<?> ssResponse) {
        ArrayList headers;
        boolean z;
        if (ssResponse == null) {
            headers = null;
        } else {
            try {
                headers = ssResponse.headers();
            } catch (Throwable unused) {
                return null;
            }
        }
        if (headers == null) {
            headers = new ArrayList();
        }
        String valueOf = String.valueOf(ssResponse == null ? null : ssResponse.body());
        Iterator it = headers.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Header header = (Header) it.next();
            String name = header.getName();
            Intrinsics.checkNotNullExpressionValue(name, "header.name");
            String lowerCase = name.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (Intrinsics.areEqual(lowerCase, SyncConstants.FLAG_SYNC)) {
                String value = header.getValue();
                if (Intrinsics.areEqual(value, SyncConstants.FLAG_CLOSE_SYNC)) {
                    closeSync();
                } else {
                    if (Intrinsics.areEqual(value, SyncConstants.FLAG_CLOSE_AND_CLEAR)) {
                        closeSync();
                        clearDatabase();
                    }
                    z = true;
                }
                valueOf = null;
                z = true;
            }
        }
        if (!z) {
            check();
        }
        return valueOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0060 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #0 {all -> 0x0064, blocks: (B:9:0x0003, B:10:0x000b, B:12:0x0011, B:14:0x001f, B:17:0x0031, B:19:0x003f, B:5:0x0060, B:22:0x0044, B:24:0x004c, B:27:0x0055, B:28:0x005c), top: B:8:0x0003 }] */
    @Override // com.bytedance.sync.p005v4.intf.IHttpMsgProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String process(Map<String, String> headers, String bodyString) {
        boolean z;
        if (headers != null) {
            try {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    String key = entry.getKey();
                    if (key == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase = key.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (Intrinsics.areEqual(lowerCase, SyncConstants.FLAG_SYNC)) {
                        String value = entry.getValue();
                        if (Intrinsics.areEqual(value, SyncConstants.FLAG_CLOSE_SYNC)) {
                            closeSync();
                        } else {
                            if (Intrinsics.areEqual(value, SyncConstants.FLAG_CLOSE_AND_CLEAR)) {
                                closeSync();
                                clearDatabase();
                            }
                            z = true;
                            if (!z) {
                                check();
                            }
                            return bodyString;
                        }
                        bodyString = null;
                        z = true;
                        if (!z) {
                        }
                        return bodyString;
                    }
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        z = false;
        if (!z) {
        }
        return bodyString;
    }

    private final void closeSync() {
        ((ICompensatorServiceV4) UgBusFramework.getService(ICompensatorServiceV4.class)).reset();
        SyncSettings.inst(this.context).setEnable(false);
    }

    private final void clearDatabase() {
        try {
            ICompensatorServiceV4 iCompensatorServiceV4 = (ICompensatorServiceV4) UgBusFramework.getService(ICompensatorServiceV4.class);
            if (iCompensatorServiceV4 != null) {
                iCompensatorServiceV4.reset();
            }
            DBServiceImplV4 dBServiceImplV4 = (IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class);
            if (dBServiceImplV4 == null) {
                dBServiceImplV4 = new DBServiceImplV4(this.context);
            }
            dBServiceImplV4.deleteAllTableData();
        } catch (Throwable unused) {
        }
    }

    private final void check() {
        if (SyncSettings.inst(this.context).getEnable()) {
            return;
        }
        LogUtils.m187i("no flag or header is null, tryS y open sync and compensator");
        SyncSettings.inst(this.context).setEnable(true);
        ((ICompensatorServiceV4) UgBusFramework.getService(ICompensatorServiceV4.class)).startOnce();
    }
}
