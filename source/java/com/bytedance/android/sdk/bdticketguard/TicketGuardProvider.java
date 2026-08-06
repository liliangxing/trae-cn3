package com.bytedance.android.sdk.bdticketguard;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0006H\u0016JO\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\u0010 \u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0018H\u0002J;\u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardProvider;", "Landroid/content/ContentProvider;", "()V", "authority", "", "hasInit", "", "mainManager", "Lcom/bytedance/android/sdk/bdticketguard/MainTicketGuardManager;", "uriMatcher", "Landroid/content/UriMatcher;", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "notifyInitChange", "", "id", "type", "initResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "onCreate", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "tryInit", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TicketGuardProvider extends ContentProvider {
    private String authority;
    private volatile boolean hasInit;
    private MainTicketGuardManager mainManager;
    private UriMatcher uriMatcher;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    private final void tryInit() {
        String providerAuthority;
        if (this.hasInit) {
            if (this.mainManager == null) {
                TicketGuardManager manager = TicketGuardInnerFrameWork.INSTANCE.getManager();
                if (!(manager instanceof MainTicketGuardManager)) {
                    manager = null;
                }
                this.mainManager = (MainTicketGuardManager) manager;
                return;
            }
            return;
        }
        this.hasInit = true;
        providerAuthority = TicketGuardProviderKt.getProviderAuthority(getContext());
        this.authority = providerAuthority;
        UriMatcher uriMatcher = new UriMatcher(-1);
        String str = this.authority;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str, TicketGuardProviderKt.PATH_QUERY_CSR, 101);
        String str2 = this.authority;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str2, TicketGuardProviderKt.PATH_QUERY_CLIENT_CERT, 102);
        String str3 = this.authority;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str3, TicketGuardProviderKt.PATH_QUERY_SERVER_CERT, 103);
        String str4 = this.authority;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str4, TicketGuardProviderKt.PATH_QUERY_TICKET_DATA, 104);
        String str5 = this.authority;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str5, TicketGuardProviderKt.PATH_SIGN, 105);
        String str6 = this.authority;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str6, TicketGuardProviderKt.PATH_ENCRYPT, 106);
        String str7 = this.authority;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str7, TicketGuardProviderKt.PATH_DECRYPT, 107);
        String str8 = this.authority;
        if (str8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str8, "delta_public_key", 108);
        String str9 = this.authority;
        if (str9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str9, TicketGuardProviderKt.PATH_REE_PUB_KEY, 109);
        String str10 = this.authority;
        if (str10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str10, TicketGuardProviderKt.PATH_QUERY_NEED_REE, 110);
        String str11 = this.authority;
        if (str11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str11, TicketGuardProviderKt.PATH_QUERY_TEE_CREATE_LOG, 111);
        String str12 = this.authority;
        if (str12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str12, TicketGuardProviderKt.PATH_QUERY_REE_CREATE_LOG, 112);
        String str13 = this.authority;
        if (str13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str13, TicketGuardProviderKt.PATH_QUERY_TEE_EVER_FAIL, 113);
        String str14 = this.authority;
        if (str14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str14, TicketGuardProviderKt.PATH_QUERY_TEE_PUB, 114);
        String str15 = this.authority;
        if (str15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str15, TicketGuardProviderKt.PATH_QUERY_LOAD, 115);
        String str16 = this.authority;
        if (str16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str16, TicketGuardProviderKt.PATH_UPDATE_TICKET_DATA, 200);
        String str17 = this.authority;
        if (str17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str17, TicketGuardProviderKt.PATH_UPDATE_CERT, 201);
        String str18 = this.authority;
        if (str18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str18, TicketGuardProviderKt.PATH_CLEAR_SERVER_CERT, 202);
        String str19 = this.authority;
        if (str19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        uriMatcher.addURI(str19, TicketGuardProviderKt.PATH_UPDATE_TEE_EVER_FAIL, TicketGuardProviderKt.CODE_UPDATE_TEE_EVER_FAIL);
        this.uriMatcher = uriMatcher;
    }

    public final void notifyInitChange(String id, String type, Boolean initResult) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(type, "type");
        StringBuilder sb = new StringBuilder("content://");
        String str = this.authority;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        Uri build = Uri.parse(sb.append(str).append("/load_result").toString()).buildUpon().appendQueryParameter("id", id).appendQueryParameter("type", type).appendQueryParameter("result", String.valueOf(TicketGuardProviderKt.boolToInt(initResult))).build();
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        context.getContentResolver().notifyChange(build, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0428, code lost:
    
        if (r8 != null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0464, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0465, code lost:
    
        r9.newRow().add(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x046e, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x042b, code lost:
    
        r12 = r8.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0432, code lost:
    
        if (r12 == 157663823) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0437, code lost:
    
        if (r12 == 157665745) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0441, code lost:
    
        if (r8.equals(com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt.VALUE_SIGN_TYPE_TEE) == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0443, code lost:
    
        r8 = r7.mainManager;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0445, code lost:
    
        if (r8 == null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0447, code lost:
    
        if (r11 == null) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0449, code lost:
    
        r2 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x044a, code lost:
    
        r8 = r8.sign(r10, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0456, code lost:
    
        if (r8.equals(com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt.VALUE_SIGN_TYPE_REE) == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0458, code lost:
    
        r8 = r7.mainManager;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x045a, code lost:
    
        if (r8 == null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x045c, code lost:
    
        if (r11 == null) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x045e, code lost:
    
        r2 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x045f, code lost:
    
        r8 = r8.reeSign(r10, r2);
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String str;
        ServerCert serverCert;
        TicketDataBean ticketDataBean;
        String message;
        String message2;
        MainTicketGuardManager mainTicketGuardManager;
        MainTicketGuardManager mainTicketGuardManager2;
        MainTicketGuardManager mainTicketGuardManager3;
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        tryInit();
        UriMatcher uriMatcher = this.uriMatcher;
        if (uriMatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uriMatcher");
        }
        int i = 1;
        str = "";
        byte[] bArr = null;
        switch (uriMatcher.match(uri)) {
            case 101:
                TicketGuardProviderKt.log("query, uri=" + uri + ", csr");
                try {
                    MatrixCursor matrixCursor = new MatrixCursor(new String[]{TicketGuardProviderKt.COL_CSR});
                    MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
                    MainTicketGuardManager mainTicketGuardManager4 = this.mainManager;
                    newRow.add(mainTicketGuardManager4 != null ? mainTicketGuardManager4.getCsr() : null);
                    return matrixCursor;
                } catch (Exception e) {
                    TicketGuardProviderKt.log("query csr failed, e=" + Log.getStackTraceString(e));
                    break;
                }
            case 102:
                TicketGuardProviderKt.log("query, uri=" + uri + ", client cert");
                try {
                    MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"client_cert"});
                    MatrixCursor.RowBuilder newRow2 = matrixCursor2.newRow();
                    MainTicketGuardManager mainTicketGuardManager5 = this.mainManager;
                    newRow2.add(mainTicketGuardManager5 != null ? mainTicketGuardManager5.getClientCert() : null);
                    return matrixCursor2;
                } catch (Exception e2) {
                    TicketGuardProviderKt.log("query client cert failed, e=" + Log.getStackTraceString(e2));
                    break;
                }
            case 103:
                TicketGuardProviderKt.log("query, uri=" + uri + ", server cert");
                try {
                    MatrixCursor matrixCursor3 = new MatrixCursor(new String[]{TicketGuardProviderKt.COL_SERVER_CERT_STRING, "serial_number", TicketGuardProviderKt.COL_PUBLIC_KEY});
                    MainTicketGuardManager mainTicketGuardManager6 = this.mainManager;
                    if (mainTicketGuardManager6 != null && (serverCert = mainTicketGuardManager6.getServerCert()) != null) {
                        matrixCursor3.newRow().add(serverCert.getCertString()).add(serverCert.getSerialNumber()).add(serverCert.getPublicKey());
                        return matrixCursor3;
                    }
                } catch (Exception e3) {
                    TicketGuardProviderKt.log("query server cert failed, e=" + Log.getStackTraceString(e3));
                }
                return null;
            case 104:
                TicketGuardProviderKt.log("query, uri=" + uri + ", ticket data");
                try {
                    MatrixCursor matrixCursor4 = new MatrixCursor(new String[]{"ts_sign", "ts_sign_ree", "type", "cert"});
                    String queryParameter = uri.getQueryParameter("ticket");
                    MainTicketGuardManager mainTicketGuardManager7 = this.mainManager;
                    if (mainTicketGuardManager7 != null) {
                        if (queryParameter == null) {
                            Intrinsics.throwNpe();
                        }
                        ticketDataBean = mainTicketGuardManager7.getTicketData(queryParameter);
                    } else {
                        ticketDataBean = null;
                    }
                    if (ticketDataBean != null) {
                        matrixCursor4.newRow().add(ticketDataBean.getTs_sign()).add(ticketDataBean.getTs_sign_ree()).add(ticketDataBean.getType()).add(ticketDataBean.getCert());
                        return matrixCursor4;
                    }
                } catch (Exception e4) {
                    TicketGuardProviderKt.log("query ticket data failed, e=" + Log.getStackTraceString(e4));
                }
                return null;
            case 105:
                TicketGuardProviderKt.log("query, uri=" + uri + ", sign");
                try {
                    MatrixCursor matrixCursor5 = new MatrixCursor(new String[]{TicketGuardProviderKt.COL_BASE64_SIGNED});
                    String queryParameter2 = uri.getQueryParameter(TicketGuardProviderKt.PARAM_UNSIGNED);
                    String queryParameter3 = uri.getQueryParameter("path");
                    String queryParameter4 = uri.getQueryParameter(TicketGuardProviderKt.PARAM_SIGN_TYPE);
                    String str2 = queryParameter2;
                    if (str2 != null && str2.length() != 0) {
                        i = 0;
                        break;
                    }
                } catch (Exception e5) {
                    TicketGuardProviderKt.log("query sign failed, e=" + Log.getStackTraceString(e5));
                }
                return null;
            case 106:
                TicketGuardProviderKt.log("query, uri=" + uri + ", encrypt");
                MatrixCursor matrixCursor6 = new MatrixCursor(new String[]{TicketGuardProviderKt.COL_ENCRYPTED, TicketGuardProviderKt.COL_EXCEPTION_MESSAGE});
                try {
                    String queryParameter5 = uri.getQueryParameter("content");
                    MainTicketGuardManager mainTicketGuardManager8 = this.mainManager;
                    if (mainTicketGuardManager8 == null) {
                        Intrinsics.throwNpe();
                    }
                    byte[] decode = Base64.decode(queryParameter5, 0);
                    Intrinsics.checkExpressionValueIsNotNull(decode, "Base64.decode(content, Base64.DEFAULT)");
                    bArr = mainTicketGuardManager8.encrypt(decode);
                    message = null;
                } catch (Exception e6) {
                    TicketGuardProviderKt.log("query encrypt failed, e=" + Log.getStackTraceString(e6));
                    message = e6.getMessage();
                }
                matrixCursor6.newRow().add(bArr).add(message);
                return matrixCursor6;
            case 107:
                TicketGuardProviderKt.log("query, uri=" + uri + ", decrypt");
                MatrixCursor matrixCursor7 = new MatrixCursor(new String[]{TicketGuardProviderKt.COL_DECRYPTED, TicketGuardProviderKt.COL_EXCEPTION_MESSAGE});
                try {
                    String queryParameter6 = uri.getQueryParameter("content");
                    MainTicketGuardManager mainTicketGuardManager9 = this.mainManager;
                    if (mainTicketGuardManager9 == null) {
                        Intrinsics.throwNpe();
                    }
                    byte[] decode2 = Base64.decode(queryParameter6, 0);
                    Intrinsics.checkExpressionValueIsNotNull(decode2, "Base64.decode(content, Base64.DEFAULT)");
                    bArr = mainTicketGuardManager9.decrypt(decode2);
                    message2 = null;
                } catch (Exception e7) {
                    TicketGuardProviderKt.log("query decrypt failed, e=" + Log.getStackTraceString(e7));
                    message2 = e7.getMessage();
                }
                matrixCursor7.newRow().add(bArr).add(message2);
                return matrixCursor7;
            case 108:
                TicketGuardProviderKt.log("query, uri=" + uri + ", delta public key");
                try {
                    MatrixCursor matrixCursor8 = new MatrixCursor(new String[]{"delta_public_key"});
                    MatrixCursor.RowBuilder newRow3 = matrixCursor8.newRow();
                    MainTicketGuardManager mainTicketGuardManager10 = this.mainManager;
                    newRow3.add(mainTicketGuardManager10 != null ? mainTicketGuardManager10.getDeltaPublicKey() : null);
                    return matrixCursor8;
                } catch (Exception e8) {
                    TicketGuardProviderKt.log("query delta public key failed, e=" + Log.getStackTraceString(e8));
                    break;
                }
            case 109:
                TicketGuardProviderKt.log("query, uri=" + uri + ", ree public key");
                try {
                    MatrixCursor matrixCursor9 = new MatrixCursor(new String[]{TicketGuardProviderKt.COL_REE_PUB_KEY});
                    MatrixCursor.RowBuilder newRow4 = matrixCursor9.newRow();
                    MainTicketGuardManager mainTicketGuardManager11 = this.mainManager;
                    newRow4.add(mainTicketGuardManager11 != null ? mainTicketGuardManager11.getBase64ReePub() : null);
                    return matrixCursor9;
                } catch (Exception e9) {
                    TicketGuardProviderKt.log("query ree public key failed, e=" + Log.getStackTraceString(e9));
                    break;
                }
            case 110:
                TicketGuardProviderKt.log("query, uri=" + uri + ", need ree");
                try {
                    MatrixCursor matrixCursor10 = new MatrixCursor(new String[]{TicketGuardProviderKt.COL_NEED_REE});
                    MatrixCursor.RowBuilder newRow5 = matrixCursor10.newRow();
                    MainTicketGuardManager mainTicketGuardManager12 = this.mainManager;
                    if (mainTicketGuardManager12 == null || !mainTicketGuardManager12.needRee()) {
                        i = 0;
                    }
                    newRow5.add(Integer.valueOf(i));
                    return matrixCursor10;
                } catch (Exception e10) {
                    TicketGuardProviderKt.log("query need ree failed, e=" + Log.getStackTraceString(e10));
                    break;
                }
                break;
            case 111:
                TicketGuardProviderKt.log("query, uri=" + uri + ", query tee create log");
                try {
                    MatrixCursor matrixCursor11 = new MatrixCursor(new String[]{TicketGuardProviderKt.COL_TEE_CREATE_LOG});
                    MatrixCursor.RowBuilder newRow6 = matrixCursor11.newRow();
                    MainTicketGuardManager mainTicketGuardManager13 = this.mainManager;
                    newRow6.add(mainTicketGuardManager13 != null ? mainTicketGuardManager13.getTeeCreateLog() : null);
                    return matrixCursor11;
                } catch (Exception e11) {
                    TicketGuardProviderKt.log("query tee create log failed, e=" + Log.getStackTraceString(e11));
                    break;
                }
            case 112:
                TicketGuardProviderKt.log("query, uri=" + uri + ", query ree create log");
                try {
                    MatrixCursor matrixCursor12 = new MatrixCursor(new String[]{TicketGuardProviderKt.COL_REE_CREATE_LOG});
                    MatrixCursor.RowBuilder newRow7 = matrixCursor12.newRow();
                    MainTicketGuardManager mainTicketGuardManager14 = this.mainManager;
                    newRow7.add(mainTicketGuardManager14 != null ? mainTicketGuardManager14.getReeCreateLog() : null);
                    return matrixCursor12;
                } catch (Exception e12) {
                    TicketGuardProviderKt.log("query ree create log failed, e=" + Log.getStackTraceString(e12));
                    break;
                }
            case 113:
                TicketGuardProviderKt.log("query, uri=" + uri + ", query tee ever fail");
                try {
                    MatrixCursor matrixCursor13 = new MatrixCursor(new String[]{TicketGuardProviderKt.COL_TEE_EVER_FAIL});
                    MatrixCursor.RowBuilder newRow8 = matrixCursor13.newRow();
                    MainTicketGuardManager mainTicketGuardManager15 = this.mainManager;
                    newRow8.add(mainTicketGuardManager15 != null ? Boolean.valueOf(mainTicketGuardManager15.getTeeEverFail()) : null);
                    return matrixCursor13;
                } catch (Exception e13) {
                    TicketGuardProviderKt.log("query tee ever fail failed, e=" + Log.getStackTraceString(e13));
                    break;
                }
            case 114:
                TicketGuardProviderKt.log("query, uri=" + uri + ", query tee 04 public key");
                try {
                    MatrixCursor matrixCursor14 = new MatrixCursor(new String[]{TicketGuardProviderKt.COL_TEE_PUB});
                    MatrixCursor.RowBuilder newRow9 = matrixCursor14.newRow();
                    MainTicketGuardManager mainTicketGuardManager16 = this.mainManager;
                    newRow9.add(mainTicketGuardManager16 != null ? mainTicketGuardManager16.getTeePublic() : null);
                    return matrixCursor14;
                } catch (Exception e14) {
                    TicketGuardProviderKt.log("query tee 04 public key failed, e=" + Log.getStackTraceString(e14));
                    break;
                }
            case 115:
                TicketGuardProviderKt.log("query, uri=" + uri + ", load");
                final String queryParameter7 = uri.getQueryParameter("id");
                if (queryParameter7 != null) {
                    Intrinsics.checkExpressionValueIsNotNull(queryParameter7, "uri.getQueryParameter(PARAM_ID) ?: return null");
                    final String queryParameter8 = uri.getQueryParameter("type");
                    if (queryParameter8 != null) {
                        Intrinsics.checkExpressionValueIsNotNull(queryParameter8, "uri.getQueryParameter(PARAM_TYPE) ?: return null");
                        String queryParameter9 = uri.getQueryParameter("scene");
                        str = queryParameter9 != null ? queryParameter9 : "";
                        Intrinsics.checkExpressionValueIsNotNull(str, "uri.getQueryParameter(PARAM_SCENE) ?: \"\"");
                        TicketInitCallback ticketInitCallback = new TicketInitCallback() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardProvider$query$callback$1
                            @Override // com.bytedance.android.sdk.bdticketguard.TicketInitCallback
                            public void onFinish(Boolean initResult) {
                                TicketGuardProvider.this.notifyInitChange(queryParameter7, queryParameter8, initResult);
                            }
                        };
                        int hashCode = queryParameter8.hashCode();
                        if (hashCode != -1512632445) {
                            if (hashCode != 112786) {
                                if (hashCode == 114708 && queryParameter8.equals(TicketGuardApiKt.INIT_STATUS_TEE) && (mainTicketGuardManager3 = this.mainManager) != null) {
                                    mainTicketGuardManager3.loadTee(str, ticketInitCallback);
                                }
                            } else if (queryParameter8.equals(TicketGuardApiKt.INIT_STATUS_REE) && (mainTicketGuardManager2 = this.mainManager) != null) {
                                mainTicketGuardManager2.loadRee(str, ticketInitCallback);
                            }
                        } else if (queryParameter8.equals(TicketGuardApiKt.INIT_STATUS_ENCRYPTION) && (mainTicketGuardManager = this.mainManager) != null) {
                            mainTicketGuardManager.loadEncryption(str, ticketInitCallback);
                        }
                        return null;
                    }
                }
                return null;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        tryInit();
        StringBuilder sb = new StringBuilder("vnd.android.cursor.item/vnd.");
        String str = this.authority;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authority");
        }
        return sb.append(str).append(".item").toString();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
    
        if (r8 == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e0, code lost:
    
        return 0;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        tryInit();
        UriMatcher uriMatcher = this.uriMatcher;
        if (uriMatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uriMatcher");
        }
        switch (uriMatcher.match(uri)) {
            case 200:
                TicketGuardProviderKt.log("update, ticket data");
                String queryParameter = uri.getQueryParameter("type");
                String queryParameter2 = uri.getQueryParameter("ticket");
                String queryParameter3 = uri.getQueryParameter("ts_sign");
                String queryParameter4 = uri.getQueryParameter("ts_sign_ree");
                String queryParameter5 = uri.getQueryParameter("cert");
                String str = queryParameter;
                boolean z = true;
                if (!(str == null || str.length() == 0)) {
                    String str2 = queryParameter2;
                    if (!(str2 == null || str2.length() == 0)) {
                        String str3 = queryParameter3;
                        if (str3 == null || str3.length() == 0) {
                            String str4 = queryParameter4;
                            if (str4 != null && str4.length() != 0) {
                                z = false;
                                break;
                            }
                        }
                        MainTicketGuardManager mainTicketGuardManager = this.mainManager;
                        if (mainTicketGuardManager != null) {
                            mainTicketGuardManager.updateTicketData(new TicketDataBean(queryParameter, queryParameter2, queryParameter3, queryParameter4, queryParameter5));
                            break;
                        }
                    }
                }
                break;
            case 201:
                TicketGuardProviderKt.log("update cert");
                String queryParameter6 = uri.getQueryParameter("client_cert");
                String queryParameter7 = uri.getQueryParameter(TicketGuardProviderKt.PARAM_SERVER_CERT);
                MainTicketGuardManager mainTicketGuardManager2 = this.mainManager;
                if (mainTicketGuardManager2 != null) {
                    mainTicketGuardManager2.updateLocalCert(queryParameter6, queryParameter7);
                    break;
                }
                break;
            case 202:
                TicketGuardProviderKt.log("clear server cert");
                MainTicketGuardManager mainTicketGuardManager3 = this.mainManager;
                if (mainTicketGuardManager3 != null) {
                    mainTicketGuardManager3.invalidServerCert();
                    break;
                }
                break;
            case TicketGuardProviderKt.CODE_UPDATE_TEE_EVER_FAIL /* 203 */:
                TicketGuardProviderKt.log("update tee ever fail");
                String queryParameter8 = uri.getQueryParameter(TicketGuardProviderKt.PARAM_TEE_FAIL_REASON);
                if (queryParameter8 == null) {
                    queryParameter8 = "";
                }
                Intrinsics.checkExpressionValueIsNotNull(queryParameter8, "uri.getQueryParameter(PARAM_TEE_FAIL_REASON) ?: \"\"");
                MainTicketGuardManager mainTicketGuardManager4 = this.mainManager;
                if (mainTicketGuardManager4 != null) {
                    mainTicketGuardManager4.setTeeEverFail(queryParameter8);
                    break;
                }
                break;
        }
    }
}
