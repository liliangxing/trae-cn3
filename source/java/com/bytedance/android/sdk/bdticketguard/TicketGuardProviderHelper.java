package com.bytedance.android.sdk.bdticketguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.bytedance.bdturing.methods.JsCallParser;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001BB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J \u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0006J\b\u0010!\u001a\u0004\u0018\u00010\"J\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\u0006J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u0006J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,J\u0018\u0010-\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,J\u0018\u0010.\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0006H\u0002J\u0012\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\rH\u0002J\u0018\u00104\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0006H\u0002J\"\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u001a\u00108\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0006H\u0002J\u000e\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u0006J\u0010\u0010;\u001a\u00020<2\u0006\u00103\u001a\u00020\rH\u0002J\u001a\u0010=\u001a\u00020\u00122\b\u0010>\u001a\u0004\u0018\u00010\u00062\b\u0010?\u001a\u0004\u0018\u00010\u0006J\u000e\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardProviderHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authority", "", "baseUrl", "getContext", "()Landroid/content/Context;", "ticketContentObserver", "Lcom/bytedance/android/sdk/bdticketguard/TicketGuardProviderHelper$TicketContentObserver;", "buildUri", "Landroid/net/Uri;", "path", "params", "", "clearServerCert", "", TicketGuardProviderKt.PATH_DECRYPT, "", "content", TicketGuardProviderKt.PATH_ENCRYPT, "getBase64ReePub", "getBase64Signed", TicketGuardProviderKt.PARAM_UNSIGNED, "signType", "getClientCert", "getCsr", "getDeltaPublicKey", "getNeedRee", "", "getReeCreateLog", "getServerCert", "Lcom/bytedance/android/sdk/bdticketguard/ServerCert;", "getTeeCreateLog", "getTeeEverFail", "getTeePublic", "getTicketData", "Lcom/bytedance/android/sdk/bdticketguard/TicketDataBean;", "ticket", "loadEncryption", "scene", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/android/sdk/bdticketguard/TicketInitCallback;", "loadRee", "loadTee", "log", "msg", "query", "Landroid/database/Cursor;", "uri", "queryBoolean", "colName", "queryLoad", "type", "queryString", "setTeeEverFail", "reason", "update", "", "updateLocalCert", "clientCert", "serverCert", "updateTicketData", "ticketData", "TicketContentObserver", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TicketGuardProviderHelper {
    private final String authority;
    private final String baseUrl;
    private final Context context;
    private final TicketContentObserver ticketContentObserver;

    public TicketGuardProviderHelper(Context context) {
        String providerAuthority;
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
        providerAuthority = TicketGuardProviderKt.getProviderAuthority(context);
        this.authority = providerAuthority;
        String str = "content://" + providerAuthority;
        this.baseUrl = str;
        TicketContentObserver ticketContentObserver = new TicketContentObserver(new Handler(Looper.getMainLooper()));
        this.ticketContentObserver = ticketContentObserver;
        context.getContentResolver().registerContentObserver(Uri.parse(str + "/load_result"), false, ticketContentObserver);
    }

    public final Context getContext() {
        return this.context;
    }

    /* compiled from: TicketGuardProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\bR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardProviderHelper$TicketContentObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "callbackMap", "", "", "Lcom/bytedance/android/sdk/bdticketguard/TicketInitCallback;", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "registerCallback", "id", JsCallParser.VALUE_CALLBACK, "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class TicketContentObserver extends ContentObserver {
        private final Map<String, TicketInitCallback> callbackMap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TicketContentObserver(Handler handler) {
            super(handler);
            Intrinsics.checkParameterIsNotNull(handler, "handler");
            this.callbackMap = new LinkedHashMap();
        }

        public final void registerCallback(String id, TicketInitCallback callback) {
            Intrinsics.checkParameterIsNotNull(id, "id");
            if (callback != null) {
                this.callbackMap.put(id, callback);
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            String queryParameter;
            Boolean bool;
            super.onChange(selfChange, uri);
            if (selfChange || uri == null || !Intrinsics.areEqual(uri.getPath(), "/load_result") || (queryParameter = uri.getQueryParameter("id")) == null) {
                return;
            }
            Intrinsics.checkExpressionValueIsNotNull(queryParameter, "uri.getQueryParameter(PARAM_ID) ?: return");
            String queryParameter2 = uri.getQueryParameter("result");
            if (queryParameter2 != null) {
                int parseInt = Integer.parseInt(queryParameter2);
                if (parseInt != -1) {
                    bool = parseInt != 1 ? null : true;
                } else {
                    bool = false;
                }
                TicketInitCallback ticketInitCallback = this.callbackMap.get(queryParameter);
                if (ticketInitCallback != null) {
                    ticketInitCallback.onFinish(bool);
                }
                this.callbackMap.remove(queryParameter);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Uri buildUri$default(TicketGuardProviderHelper ticketGuardProviderHelper, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return ticketGuardProviderHelper.buildUri(str, map);
    }

    private final Uri buildUri(String path, Map<String, String> params) {
        Uri parse = Uri.parse(this.baseUrl + '/' + path);
        if (!(params == null || params.isEmpty())) {
            Uri.Builder buildUpon = parse.buildUpon();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            parse = buildUpon.build();
        }
        Intrinsics.checkExpressionValueIsNotNull(parse, "result");
        return parse;
    }

    private final void log(String msg) {
        TicketGuardInnerFrameWork.log(msg);
    }

    private final Cursor query(Uri uri) {
        return this.context.getContentResolver().query(uri, null, null, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
    
        if (r5 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0026, code lost:
    
        if (r5 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0053, code lost:
    
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String queryString(String path, String colName) {
        Cursor cursor;
        ?? r1 = 0;
        r1 = null;
        r1 = null;
        r1 = null;
        String str = null;
        try {
            try {
                cursor = query(buildUri$default(this, path, null, 2, null));
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str = cursor.getString(cursor.getColumnIndexOrThrow(colName));
                        }
                    } catch (Exception e) {
                        e = e;
                        log("get " + colName + " from provider failed, e=" + Log.getStackTraceString(e));
                    }
                }
            } catch (Throwable th) {
                th = th;
                r1 = path;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean queryBoolean(String path, String colName) {
        Cursor cursor = null;
        boolean z = false;
        try {
            try {
                cursor = query(buildUri$default(this, path, null, 2, null));
                if (cursor != null && cursor.moveToFirst()) {
                    if (cursor.getInt(cursor.getColumnIndexOrThrow(colName)) == 1) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                log("get " + colName + " from provider failed, e=" + Log.getStackTraceString(e));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final void loadRee(String scene, TicketInitCallback callback) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        queryLoad(TicketGuardApiKt.INIT_STATUS_REE, scene, callback);
    }

    public final void loadTee(String scene, TicketInitCallback callback) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        queryLoad(TicketGuardApiKt.INIT_STATUS_TEE, scene, callback);
    }

    public final void loadEncryption(String scene, TicketInitCallback callback) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        queryLoad(TicketGuardApiKt.INIT_STATUS_ENCRYPTION, scene, callback);
    }

    private final void queryLoad(String type, String scene, TicketInitCallback callback) {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        this.ticketContentObserver.registerCallback(uuid, callback);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", type);
        linkedHashMap.put("scene", scene);
        linkedHashMap.put("id", uuid);
        query(buildUri(TicketGuardProviderKt.PATH_QUERY_LOAD, linkedHashMap));
    }

    public final String getCsr() {
        return queryString(TicketGuardProviderKt.PATH_QUERY_CSR, TicketGuardProviderKt.COL_CSR);
    }

    public final String getClientCert() {
        return queryString(TicketGuardProviderKt.PATH_QUERY_CLIENT_CERT, "client_cert");
    }

    public final String getBase64ReePub() {
        return queryString(TicketGuardProviderKt.PATH_REE_PUB_KEY, TicketGuardProviderKt.COL_REE_PUB_KEY);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        r1 = new com.bytedance.android.sdk.bdticketguard.ServerCert(r3, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009a, code lost:
    
        if (r2 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x007a, code lost:
    
        if (r2 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x007c, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x009d, code lost:
    
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051 A[Catch: Exception -> 0x0078, all -> 0x009e, TryCatch #1 {Exception -> 0x0078, blocks: (B:10:0x0017, B:12:0x001e, B:14:0x0045, B:19:0x0051, B:21:0x0056, B:26:0x0062, B:28:0x0067, B:33:0x0071), top: B:9:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062 A[Catch: Exception -> 0x0078, all -> 0x009e, TryCatch #1 {Exception -> 0x0078, blocks: (B:10:0x0017, B:12:0x001e, B:14:0x0045, B:19:0x0051, B:21:0x0056, B:26:0x0062, B:28:0x0067, B:33:0x0071), top: B:9:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ServerCert getServerCert() {
        Cursor cursor;
        Object[] objArr;
        Object[] objArr2;
        Cursor cursor2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        ServerCert serverCert = null;
        try {
            cursor = query(buildUri$default(this, TicketGuardProviderKt.PATH_QUERY_SERVER_CERT, null, 2, null));
            if (cursor != null) {
                try {
                    try {
                        boolean z = true;
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndexOrThrow(TicketGuardProviderKt.COL_SERVER_CERT_STRING));
                            String string2 = cursor.getString(cursor.getColumnIndexOrThrow("serial_number"));
                            String string3 = cursor.getString(cursor.getColumnIndexOrThrow(TicketGuardProviderKt.COL_PUBLIC_KEY));
                            String str = string;
                            if (str != null && str.length() != 0) {
                                objArr = false;
                                if (objArr == false) {
                                    String str2 = string2;
                                    if (str2 != null && str2.length() != 0) {
                                        objArr2 = false;
                                        if (objArr2 == false) {
                                            String str3 = string3;
                                            if (str3 != null && str3.length() != 0) {
                                                z = false;
                                            }
                                        }
                                    }
                                    objArr2 = true;
                                    if (objArr2 == false) {
                                    }
                                }
                            }
                            objArr = true;
                            if (objArr == false) {
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        log("get server cert from provider failed, e=" + Log.getStackTraceString(e));
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
    
        if (r7 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0051, code lost:
    
        if (r7 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0053, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0074, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getBase64Signed(String unsigned, String path, String signType) {
        Cursor cursor;
        Intrinsics.checkParameterIsNotNull(unsigned, TicketGuardProviderKt.PARAM_UNSIGNED);
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(signType, "signType");
        Cursor cursor2 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        String str = null;
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(TicketGuardProviderKt.PARAM_UNSIGNED, unsigned);
            linkedHashMap.put("path", path);
            linkedHashMap.put(TicketGuardProviderKt.PARAM_SIGN_TYPE, signType);
            cursor = query(buildUri(TicketGuardProviderKt.PATH_SIGN, linkedHashMap));
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            str = cursor.getString(cursor.getColumnIndexOrThrow(TicketGuardProviderKt.COL_BASE64_SIGNED));
                        }
                    } catch (Exception e) {
                        e = e;
                        log("sign from provider failed, e=" + Log.getStackTraceString(e));
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0086, code lost:
    
        if (r2 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0066, code lost:
    
        if (r2 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0068, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0089, code lost:
    
        return r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TicketDataBean getTicketData(String ticket) {
        Cursor cursor;
        Intrinsics.checkParameterIsNotNull(ticket, "ticket");
        SQLiteCursor sQLiteCursor = 0;
        r3 = null;
        r3 = null;
        r3 = null;
        TicketDataBean ticketDataBean = null;
        try {
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("ticket", ticket);
                cursor = query(buildUri(TicketGuardProviderKt.PATH_QUERY_TICKET_DATA, linkedHashMap));
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndexOrThrow("type"));
                            String string2 = cursor.getString(cursor.getColumnIndexOrThrow("ts_sign"));
                            String string3 = cursor.getString(cursor.getColumnIndexOrThrow("ts_sign_ree"));
                            String string4 = cursor.getString(cursor.getColumnIndexOrThrow("cert"));
                            Intrinsics.checkExpressionValueIsNotNull(string, "type");
                            ticketDataBean = new TicketDataBean(string, ticket, string2, string3, string4);
                        }
                    } catch (Exception e) {
                        e = e;
                        log("get ticket data from provider failed, e=" + Log.getStackTraceString(e));
                    }
                }
            } catch (Throwable th) {
                th = th;
                sQLiteCursor = "ticket";
                if (sQLiteCursor != 0) {
                    sQLiteCursor.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteCursor != 0) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] encrypt(byte[] content) {
        Cursor cursor;
        byte[] bArr;
        String str;
        String string;
        Intrinsics.checkParameterIsNotNull(content, "content");
        Cursor cursor2 = null;
        r1 = null;
        String str2 = null;
        byte[] bArr2 = null;
        boolean z = true;
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String encodeToString = Base64.encodeToString(content, 0);
            Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(content, Base64.DEFAULT)");
            linkedHashMap.put("content", encodeToString);
            cursor = query(buildUri(TicketGuardProviderKt.PATH_ENCRYPT, linkedHashMap));
        } catch (Exception unused) {
            cursor = null;
            bArr = null;
        } catch (Throwable th) {
            th = th;
        }
        if (cursor != null) {
            try {
                try {
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                bArr = null;
            }
            if (cursor.moveToFirst()) {
                bArr = cursor.getBlob(cursor.getColumnIndexOrThrow(TicketGuardProviderKt.COL_ENCRYPTED));
                try {
                    bArr2 = bArr;
                    string = cursor.getString(cursor.getColumnIndex(TicketGuardProviderKt.COL_EXCEPTION_MESSAGE));
                    if (cursor != null) {
                        cursor.close();
                    }
                    byte[] bArr3 = bArr2;
                    str2 = string;
                    bArr = bArr3;
                } catch (Exception unused3) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    str = str2;
                    if (str != null) {
                    }
                    if (z) {
                    }
                }
                str = str2;
                if (str != null && str.length() != 0) {
                    z = false;
                }
                if (z) {
                    return bArr;
                }
                throw new RuntimeException(str2);
            }
        }
        string = null;
        if (cursor != null) {
        }
        byte[] bArr32 = bArr2;
        str2 = string;
        bArr = bArr32;
        str = str2;
        if (str != null) {
            z = false;
        }
        if (z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0081, code lost:
    
        if (r9.length() != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0084, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0085, code lost:
    
        if (r3 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0087, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008f, code lost:
    
        throw new java.lang.RuntimeException(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
    
        if (r9 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0054, code lost:
    
        if (r9 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0056, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0078, code lost:
    
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x007b, code lost:
    
        if (r9 == null) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] decrypt(byte[] content) {
        Cursor cursor;
        byte[] bArr;
        Intrinsics.checkParameterIsNotNull(content, "content");
        ?? r2 = 0;
        r2 = null;
        r2 = null;
        String str = null;
        boolean z = true;
        try {
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String encodeToString = Base64.encodeToString(content, 0);
                Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(content, Base64.DEFAULT)");
                linkedHashMap.put("content", encodeToString);
                cursor = query(buildUri(TicketGuardProviderKt.PATH_DECRYPT, linkedHashMap));
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            bArr = cursor.getBlob(cursor.getColumnIndexOrThrow(TicketGuardProviderKt.COL_DECRYPTED));
                            try {
                                str = cursor.getString(cursor.getColumnIndex(TicketGuardProviderKt.COL_EXCEPTION_MESSAGE));
                            } catch (Exception e) {
                                e = e;
                                log("get decrypt data from provider failed, e=" + Log.getStackTraceString(e));
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bArr = null;
                    }
                }
                bArr = null;
            } catch (Throwable th) {
                th = th;
                r2 = content;
                if (r2 != 0) {
                    r2.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            bArr = null;
        } catch (Throwable th2) {
            th = th2;
            if (r2 != 0) {
            }
            throw th;
        }
    }

    public final String getDeltaPublicKey() {
        return queryString("delta_public_key", "delta_public_key");
    }

    public final boolean getNeedRee() {
        return queryBoolean(TicketGuardProviderKt.PATH_QUERY_NEED_REE, TicketGuardProviderKt.COL_NEED_REE);
    }

    public final boolean getTeeEverFail() {
        return queryBoolean(TicketGuardProviderKt.PATH_QUERY_TEE_EVER_FAIL, TicketGuardProviderKt.COL_TEE_EVER_FAIL);
    }

    public final String getTeePublic() {
        String queryString = queryString(TicketGuardProviderKt.PATH_QUERY_TEE_PUB, TicketGuardProviderKt.COL_TEE_PUB);
        return queryString != null ? queryString : "";
    }

    public final String getTeeCreateLog() {
        String queryString = queryString(TicketGuardProviderKt.PATH_QUERY_TEE_CREATE_LOG, TicketGuardProviderKt.COL_TEE_CREATE_LOG);
        return queryString != null ? queryString : "";
    }

    public final String getReeCreateLog() {
        String queryString = queryString(TicketGuardProviderKt.PATH_QUERY_REE_CREATE_LOG, TicketGuardProviderKt.COL_REE_CREATE_LOG);
        return queryString != null ? queryString : "";
    }

    private final int update(Uri uri) {
        return this.context.getContentResolver().update(uri, new ContentValues(), null, null);
    }

    public final void updateLocalCert(String clientCert, String serverCert) {
        String str = clientCert;
        if (str == null || str.length() == 0) {
            String str2 = serverCert;
            if (str2 == null || str2.length() == 0) {
                return;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!(str == null || str.length() == 0)) {
            linkedHashMap.put("client_cert", clientCert);
        }
        String str3 = serverCert;
        if (!(str3 == null || str3.length() == 0)) {
            linkedHashMap.put(TicketGuardProviderKt.PARAM_SERVER_CERT, serverCert);
        }
        update(buildUri(TicketGuardProviderKt.PATH_UPDATE_CERT, linkedHashMap));
    }

    public final void updateTicketData(TicketDataBean ticketData) {
        Intrinsics.checkParameterIsNotNull(ticketData, "ticketData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", ticketData.getType());
        linkedHashMap.put("ticket", ticketData.getTicket());
        String ts_sign = ticketData.getTs_sign();
        if (ts_sign != null) {
            linkedHashMap.put("ts_sign", ts_sign);
        }
        String ts_sign_ree = ticketData.getTs_sign_ree();
        if (ts_sign_ree != null) {
            linkedHashMap.put("ts_sign_ree", ts_sign_ree);
        }
        String cert = ticketData.getCert();
        if (cert == null) {
            cert = "";
        }
        linkedHashMap.put("cert", cert);
        update(buildUri(TicketGuardProviderKt.PATH_UPDATE_TICKET_DATA, linkedHashMap));
    }

    public final void clearServerCert() {
        update(buildUri(TicketGuardProviderKt.PATH_CLEAR_SERVER_CERT, null));
    }

    public final void setTeeEverFail(String reason) {
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(TicketGuardProviderKt.PARAM_TEE_FAIL_REASON, reason);
        update(buildUri(TicketGuardProviderKt.PATH_UPDATE_TEE_EVER_FAIL, linkedHashMap));
    }
}
