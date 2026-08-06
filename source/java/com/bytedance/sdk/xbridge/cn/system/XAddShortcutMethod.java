package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.bytedance.android.anniex.ability.service.IAnnieXCustomActivityService;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.p003ui.impl.DefaultHostSytleUIDependImpl;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.DialogBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection;
import com.bytedance.sdk.xbridge.cn.runtime.thread.ThreadUtils;
import com.bytedance.sdk.xbridge.cn.runtime.utils.IStreamResponseCallback;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.sdk.xbridge.cn.system.AbsXAddShortcutMethodIDL;
import com.bytedance.sdk.xbridge.cn.system.utils.ShortcutUtil;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XAddShortcutMethod.kt */
@XBridgeMethod(name = "x.addShortcut")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J&\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J>\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XAddShortcutMethod;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXAddShortcutMethodIDL;", "()V", "ADD_SHORTCUT_FAILED", "", "DIALOG_MESSAGE", "DIALOG_NEGATIVE_BTN_TEXT", "DIALOG_POSTIVE_BTN_TEXT", "DIALOG_TITLE", "LOAD_ICON_FAILED", "addShortcutWithRequiredIcon", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "context", "Landroid/app/Activity;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXAddShortcutMethodIDL$XAddShortcutResultModel;", "shortInfo", "Landroidx/core/content/pm/ShortcutInfoCompat$Builder;", IWeixinService.ResponseConstants.URL, "handle", "params", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXAddShortcutMethodIDL$XAddShortcutParamModel;", "handleAddShortcut", "targetActivityClazz", "Ljava/lang/Class;", "showDialog", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XAddShortcutMethod extends AbsXAddShortcutMethodIDL {
    private final String ADD_SHORTCUT_FAILED = "add shortcut failed";
    private final String LOAD_ICON_FAILED = "load icon failed";
    private final String DIALOG_POSTIVE_BTN_TEXT = "前往设置";
    private final String DIALOG_MESSAGE = "若添加失败，请前往系统设置，为本应用打开\"创建桌面快捷方式\"的权限";
    private final String DIALOG_TITLE = "已尝试添加到桌面";
    private final String DIALOG_NEGATIVE_BTN_TEXT = "取消";

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
    
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock<com.bytedance.sdk.xbridge.cn.system.AbsXAddShortcutMethodIDL$XAddShortcutResultModel>, com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock, java.lang.Object] */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(IBDXBridgeContext bridgeContext, AbsXAddShortcutMethodIDL.XAddShortcutParamModel params, CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> callback) {
        Class cls;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter((Object) callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        IAnnieXCustomActivityService iAnnieXCustomActivityService = (IAnnieXCustomActivityService) bridgeContext.getService(IAnnieXCustomActivityService.class);
        if (iAnnieXCustomActivityService != null) {
            Class xShortcutStartActivityClazz = iAnnieXCustomActivityService.getXShortcutStartActivityClazz(params.getSchema());
            cls = xShortcutStartActivityClazz;
        }
        Activity activity = XBridgeMethodHelper.INSTANCE.getActivity(ownerActivity);
        cls = activity != null ? activity.getClass() : null;
        Class cls2 = cls;
        if (cls2 == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context can not convert to activity", null, 4, null);
            return;
        }
        if (params.getName().length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "The name key is required.", null, 4, null);
            return;
        }
        if (params.getId().length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "The id key is required.", null, 4, null);
            return;
        }
        if (params.getSchema().length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "The schema key is required.", null, 4, null);
        } else {
            if (ShortcutUtil.INSTANCE.hasShortcut(ownerActivity, params.getId(), params.getName())) {
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXAddShortcutMethodIDL.XAddShortcutResultModel.class));
                ((AbsXAddShortcutMethodIDL.XAddShortcutResultModel) createXModel).setCode((Number) 1);
                callback.onSuccess((XBaseResultModel) createXModel, "shortcut already exists");
                return;
            }
            handleAddShortcut(bridgeContext, ownerActivity, cls2, params, callback);
        }
    }

    private final void handleAddShortcut(IBDXBridgeContext bridgeContext, Activity context, Class<? extends Activity> targetActivityClazz, AbsXAddShortcutMethodIDL.XAddShortcutParamModel params, CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> callback) {
        Activity activity = context;
        ShortcutInfoCompat.Builder intent = new ShortcutInfoCompat.Builder(activity, params.getId()).setShortLabel(params.getName()).setIntent(new Intent("android.intent.action.VIEW", Uri.parse(params.getSchema()), activity, targetActivityClazz));
        Intrinsics.checkNotNullExpressionValue(intent, "Builder(context, params.…       .setIntent(intent)");
        String icon = params.getIcon();
        if (icon == null || icon.length() == 0) {
            if (ShortcutManagerCompat.requestPinShortcut(activity, intent.build(), (IntentSender) null)) {
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXAddShortcutMethodIDL.XAddShortcutResultModel.class));
                ((AbsXAddShortcutMethodIDL.XAddShortcutResultModel) createXModel).setCode((Number) 1);
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
                showDialog(context, bridgeContext);
                return;
            }
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, this.ADD_SHORTCUT_FAILED, null, 4, null);
            showDialog(context, bridgeContext);
            return;
        }
        String icon2 = params.getIcon();
        Intrinsics.checkNotNull(icon2);
        addShortcutWithRequiredIcon(bridgeContext, context, callback, intent, icon2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialog(final Activity context, IBDXBridgeContext bridgeContext) {
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.xbridge.cn.system.XAddShortcutMethod$showDialog$positiveClickListener$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ShortcutUtil.INSTANCE.goSettingPage(context);
            }
        };
        XAddShortcutMethod$showDialog$negativeClickListener$1 xAddShortcutMethod$showDialog$negativeClickListener$1 = new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.xbridge.cn.system.XAddShortcutMethod$showDialog$negativeClickListener$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        };
        Activity activity = context;
        DialogBuilder dialogBuilder = new DialogBuilder(activity, this.DIALOG_TITLE, this.DIALOG_MESSAGE, this.DIALOG_POSTIVE_BTN_TEXT, onClickListener, this.DIALOG_NEGATIVE_BTN_TEXT, xAddShortcutMethod$showDialog$negativeClickListener$1, null, true);
        IHostStyleUIDepend uIDependInstance = RuntimeHelper.INSTANCE.getUIDependInstance(bridgeContext);
        if (Intrinsics.areEqual(uIDependInstance != null ? uIDependInstance.showDialog(dialogBuilder) : null, true)) {
            return;
        }
        new DefaultHostSytleUIDependImpl().showDialog(dialogBuilder);
    }

    private final void addShortcutWithRequiredIcon(final IBDXBridgeContext bridgeContext, final Activity context, final CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> callback, final ShortcutInfoCompat.Builder shortInfo, final String url) {
        RuntimeHelper.INSTANCE.getExecutorService(bridgeContext).execute(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.system.XAddShortcutMethod$addShortcutWithRequiredIcon$1
            @Override // java.lang.Runnable
            public final void run() {
                final ShortcutInfoCompat.Builder builder = shortInfo;
                final Activity activity = context;
                final CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock = callback;
                final XAddShortcutMethod xAddShortcutMethod = this;
                final IBDXBridgeContext iBDXBridgeContext = bridgeContext;
                XBridgeAPIRequestUtils.INSTANCE.downloadFile(url, new LinkedHashMap<>(), new IStreamResponseCallback() { // from class: com.bytedance.sdk.xbridge.cn.system.XAddShortcutMethod$addShortcutWithRequiredIcon$1$responseCallback$1
                    /* JADX WARN: Finally extract failed */
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IStreamResponseCallback
                    public void handleConnection(AbsStreamConnection connection) {
                        if (connection == null) {
                            Handler mainThreadHandler = ThreadUtils.getMainThreadHandler();
                            final CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock2 = completionBlock;
                            final XAddShortcutMethod xAddShortcutMethod2 = xAddShortcutMethod;
                            mainThreadHandler.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.system.XAddShortcutMethod$addShortcutWithRequiredIcon$1$responseCallback$1$handleConnection$1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    String str;
                                    CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock3 = completionBlock2;
                                    str = xAddShortcutMethod2.LOAD_ICON_FAILED;
                                    CompletionBlock.DefaultImpls.onFailure$default(completionBlock3, 0, str, null, 4, null);
                                }
                            });
                            return;
                        }
                        InputStream inputStreamResponseBody = connection.getInputStreamResponseBody();
                        if (inputStreamResponseBody == null) {
                            Handler mainThreadHandler2 = ThreadUtils.getMainThreadHandler();
                            final CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock3 = completionBlock;
                            final XAddShortcutMethod xAddShortcutMethod3 = xAddShortcutMethod;
                            mainThreadHandler2.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.system.XAddShortcutMethod$addShortcutWithRequiredIcon$1$responseCallback$1$handleConnection$2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    String str;
                                    CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock4 = completionBlock3;
                                    str = xAddShortcutMethod3.LOAD_ICON_FAILED;
                                    CompletionBlock.DefaultImpls.onFailure$default(completionBlock4, 0, str, null, 4, null);
                                }
                            });
                            return;
                        }
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[4096];
                        BufferedInputStream bufferedInputStream = null;
                        try {
                            try {
                                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStreamResponseBody);
                                while (true) {
                                    try {
                                        int read = bufferedInputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        } else {
                                            byteArrayOutputStream.write(bArr, 0, read);
                                        }
                                    } catch (Throwable unused) {
                                        bufferedInputStream = bufferedInputStream2;
                                        try {
                                            Handler mainThreadHandler3 = ThreadUtils.getMainThreadHandler();
                                            final CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock4 = completionBlock;
                                            mainThreadHandler3.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.system.XAddShortcutMethod$addShortcutWithRequiredIcon$1$responseCallback$1$handleConnection$7
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    CompletionBlock.DefaultImpls.onFailure$default(completionBlock4, 0, null, null, 6, null);
                                                }
                                            });
                                            connection.cancel();
                                            if (bufferedInputStream != null) {
                                                bufferedInputStream.close();
                                            }
                                            byteArrayOutputStream.close();
                                            return;
                                        } catch (Throwable th) {
                                            try {
                                                connection.cancel();
                                                if (bufferedInputStream != null) {
                                                    bufferedInputStream.close();
                                                }
                                                byteArrayOutputStream.close();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            throw th;
                                        }
                                    }
                                }
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                                if (decodeByteArray == null) {
                                    Handler mainThreadHandler4 = ThreadUtils.getMainThreadHandler();
                                    final CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock5 = completionBlock;
                                    final XAddShortcutMethod xAddShortcutMethod4 = xAddShortcutMethod;
                                    mainThreadHandler4.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.system.XAddShortcutMethod$addShortcutWithRequiredIcon$1$responseCallback$1$handleConnection$4
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            String str;
                                            CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock6 = completionBlock5;
                                            str = xAddShortcutMethod4.LOAD_ICON_FAILED;
                                            CompletionBlock.DefaultImpls.onFailure$default(completionBlock6, 0, str, null, 4, null);
                                        }
                                    });
                                    try {
                                        connection.cancel();
                                        bufferedInputStream2.close();
                                        byteArrayOutputStream.close();
                                        return;
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        return;
                                    }
                                }
                                builder.setIcon(IconCompat.createWithBitmap(decodeByteArray));
                                if (ShortcutManagerCompat.requestPinShortcut(activity, builder.build(), (IntentSender) null)) {
                                    Handler mainThreadHandler5 = ThreadUtils.getMainThreadHandler();
                                    final CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock6 = completionBlock;
                                    final XAddShortcutMethod xAddShortcutMethod5 = xAddShortcutMethod;
                                    final Activity activity2 = activity;
                                    final IBDXBridgeContext iBDXBridgeContext2 = iBDXBridgeContext;
                                    mainThreadHandler5.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.system.XAddShortcutMethod$addShortcutWithRequiredIcon$1$responseCallback$1$handleConnection$5
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock7 = completionBlock6;
                                            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXAddShortcutMethodIDL.XAddShortcutResultModel.class));
                                            ((AbsXAddShortcutMethodIDL.XAddShortcutResultModel) createXModel).setCode((Number) 1);
                                            CompletionBlock.DefaultImpls.onSuccess$default(completionBlock7, (XBaseResultModel) createXModel, null, 2, null);
                                            xAddShortcutMethod5.showDialog(activity2, iBDXBridgeContext2);
                                        }
                                    });
                                } else {
                                    Handler mainThreadHandler6 = ThreadUtils.getMainThreadHandler();
                                    final CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock7 = completionBlock;
                                    final XAddShortcutMethod xAddShortcutMethod6 = xAddShortcutMethod;
                                    final Activity activity3 = activity;
                                    final IBDXBridgeContext iBDXBridgeContext3 = iBDXBridgeContext;
                                    mainThreadHandler6.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.system.XAddShortcutMethod$addShortcutWithRequiredIcon$1$responseCallback$1$handleConnection$6
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            String str;
                                            CompletionBlock<AbsXAddShortcutMethodIDL.XAddShortcutResultModel> completionBlock8 = completionBlock7;
                                            str = xAddShortcutMethod6.ADD_SHORTCUT_FAILED;
                                            CompletionBlock.DefaultImpls.onFailure$default(completionBlock8, 0, str, null, 4, null);
                                            xAddShortcutMethod6.showDialog(activity3, iBDXBridgeContext3);
                                        }
                                    });
                                }
                                connection.cancel();
                                bufferedInputStream2.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }, RuntimeHelper.INSTANCE.getNetworkDependInstance(bridgeContext), false);
            }
        });
    }
}
