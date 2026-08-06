package com.bytedance.ug.sdk.clipboard_handler;

import android.content.ClipData;
import android.content.Context;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ug.sdk.deeplink.ClipboardCompat;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.ZlinkApi;
import com.bytedance.ug.sdk.deeplink.api.IClipboardHandler;
import com.bytedance.ug.sdk.deeplink.api.internal.IClipboardInternalApi;
import com.bytedance.ug.sdk.deeplink.interfaces.AbstractClipboardObserver;
import com.bytedance.ug.sdk.deeplink.settings.SettingsUpdateListener;
import com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsApi;
import com.bytedance.ug.sdk.deeplink.utils.UGZlinkLogger;
import kotlin.Metadata;

/* compiled from: ClipboardHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0004\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u001c\u0010\u0015\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ug/sdk/clipboard_handler/ClipboardHandler;", "Lcom/bytedance/ug/sdk/deeplink/api/IClipboardHandler;", "()V", "checkSchemeAsyncListener", "com/bytedance/ug/sdk/clipboard_handler/ClipboardHandler$checkSchemeAsyncListener$1", "Lcom/bytedance/ug/sdk/clipboard_handler/ClipboardHandler$checkSchemeAsyncListener$1;", "checkSchemeListener", "com/bytedance/ug/sdk/clipboard_handler/ClipboardHandler$checkSchemeListener$1", "Lcom/bytedance/ug/sdk/clipboard_handler/ClipboardHandler$checkSchemeListener$1;", "clipboardInternalApi", "Lcom/bytedance/ug/sdk/clipboard_handler/ClipboardInternalApi;", "appendTextToClipboard", "", "context", "Landroid/content/Context;", "text", "", "checkScheme", "clipData", "Landroid/content/ClipData;", "checkSchemeAsync", "clearClipBoard", "", "getClipBoardContent", "allowDistribute", "", "getClipboardInternalApi", "Lcom/bytedance/ug/sdk/deeplink/api/internal/IClipboardInternalApi;", "registerClipboardObserver", "abstractClipboardObserver", "Lcom/bytedance/ug/sdk/deeplink/interfaces/AbstractClipboardObserver;", "writeTextToClipboard", SchemaConstants.QUERY_KEY_TITLE, "clipboard_handler_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ClipboardHandler implements IClipboardHandler {
    private final ClipboardInternalApi clipboardInternalApi = new ClipboardInternalApi();
    private final ClipboardHandler$checkSchemeAsyncListener$1 checkSchemeAsyncListener = new SettingsUpdateListener() { // from class: com.bytedance.ug.sdk.clipboard_handler.ClipboardHandler$checkSchemeAsyncListener$1
        @Override // com.bytedance.ug.sdk.deeplink.settings.SettingsUpdateListener
        public void onSettingsUpdateListener() {
            ZlinkSettingsApi.removeSettingsListener(this);
            ClipboardHelper.getInstance().checkSchemeAsync();
        }
    };
    private final ClipboardHandler$checkSchemeListener$1 checkSchemeListener = new SettingsUpdateListener() { // from class: com.bytedance.ug.sdk.clipboard_handler.ClipboardHandler$checkSchemeListener$1
        @Override // com.bytedance.ug.sdk.deeplink.settings.SettingsUpdateListener
        public void onSettingsUpdateListener() {
            ZlinkSettingsApi.removeSettingsListener(this);
        }
    };

    @Override // com.bytedance.ug.sdk.deeplink.api.IClipboardHandler
    public IClipboardInternalApi getClipboardInternalApi() {
        return this.clipboardInternalApi;
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.IClipboardHandler
    public void checkScheme() {
        UGZlinkLogger.startClipBoardInvoke();
        UGZlinkLogger.onClipBoardStart();
        if (ZlinkApi.INSTANCE.isInited()) {
            if (ZlinkSettingsApi.isRequestedOrHasSettingsCache()) {
                ClipboardHelper.getInstance().checkScheme();
            } else {
                ZlinkSettingsApi.addSettingsListener(this.checkSchemeListener);
            }
        }
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.IClipboardHandler
    public void checkScheme(ClipData clipData) {
        UGZlinkLogger.startClipBoardInvoke();
        UGZlinkLogger.onClipBoardStart();
        if (ZlinkApi.INSTANCE.isInited()) {
            ClipboardHelper.getInstance().checkScheme(clipData);
        }
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.IClipboardHandler
    public void checkSchemeAsync() {
        UGZlinkLogger.startClipBoardInvoke();
        UGZlinkLogger.onClipBoardStart();
        if (ZlinkApi.INSTANCE.isInited()) {
            if (ZlinkSettingsApi.isRequestedOrHasSettingsCache()) {
                ClipboardHelper.getInstance().checkSchemeAsync();
            } else {
                ZlinkSettingsApi.addSettingsListener(this.checkSchemeAsyncListener);
            }
        }
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.IClipboardHandler
    public ClipData getClipBoardContent(boolean allowDistribute) {
        UGZlinkLogger.startClipBoardInvoke();
        UGZlinkLogger.onClipBoardStart();
        if (!ZlinkApi.INSTANCE.isInited()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ClipData clipBoardContent = ClipboardCompat.getClipBoardContent(GlobalContext.INSTANCE.getApplication());
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (allowDistribute) {
            ZlinkClipboardManager.distributeClipboard(clipBoardContent, currentTimeMillis2);
        }
        return clipBoardContent;
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.IClipboardHandler
    public void appendTextToClipboard(Context context, CharSequence text) {
        ClipboardCompat.appendTextToClipboard(context, text);
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.IClipboardHandler
    public void writeTextToClipboard(Context context, CharSequence title, CharSequence text) {
        ClipboardCompat.writeClipBoard(context, title, text);
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.IClipboardHandler
    public void clearClipBoard(String text, ClipData clipData) {
        if (!ZlinkApi.INSTANCE.isInited() && HostCommonServices.isDebug()) {
            throw new IllegalStateException("the method clearClipBoard must be invoked after the initialization of SDK !");
        }
        ClipboardCompat.clearClipBoard(GlobalContext.INSTANCE.getApplication(), text, clipData);
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.IClipboardHandler
    public void clearClipBoard() {
        if (!ZlinkApi.INSTANCE.isInited() && HostCommonServices.isDebug()) {
            throw new IllegalStateException("the method clearClipBoard must be invoked after the initialization of SDK !");
        }
        ClipboardCompat.clearClipBoard(GlobalContext.INSTANCE.getApplication());
    }

    @Override // com.bytedance.ug.sdk.deeplink.api.IClipboardHandler
    public void registerClipboardObserver(AbstractClipboardObserver abstractClipboardObserver) {
        ZlinkClipboardManager.registerClipboardObserver(abstractClipboardObserver);
    }
}
