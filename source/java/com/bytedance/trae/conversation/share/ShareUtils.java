package com.bytedance.trae.conversation.share;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: ShareUtils.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010J6\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0002J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0011*\u00020\u0014H\u0002J,\u0010\u0017\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bJ<\u0010\u001a\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u001cj\b\u0012\u0004\u0012\u00020\u0019`\u001d2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bJ(\u0010\u001e\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/share/ShareUtils;", "", "<init>", "()V", "CHOOSER_RECEIVER_TIMEOUT_MS", "", "shareLink", "", "context", "Landroid/content/Context;", IWeixinService.ResponseConstants.URL, "", "title", "chooserTitle", "", "onComponentChosen", "Lkotlin/Function1;", "Landroid/content/ComponentName;", "", "createChooserWithChosenComponentCallback", "Landroid/content/Intent;", "target", "chosenComponent", "shareImage", "imageUri", "Landroid/net/Uri;", "shareMultipleImages", "imageUris", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "shareImageWithText", "text", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ShareUtils {
    private static final long CHOOSER_RECEIVER_TIMEOUT_MS = 60000;
    public static final ShareUtils INSTANCE = new ShareUtils();

    private ShareUtils() {
    }

    public final boolean shareLink(Context context, String url, String title, CharSequence chooserTitle, Function1<? super ComponentName, Unit> onComponentChosen) {
        Object obj;
        Intent createChooserWithChosenComponentCallback;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", url);
        String str = title;
        if (!(str == null || str.length() == 0)) {
            intent.putExtra("android.intent.extra.SUBJECT", title);
            intent.putExtra("android.intent.extra.TITLE", title);
        }
        try {
            Result.Companion companion = Result.Companion;
            ShareUtils shareUtils = this;
            if (onComponentChosen == null) {
                createChooserWithChosenComponentCallback = Intent.createChooser(intent, chooserTitle);
            } else {
                createChooserWithChosenComponentCallback = createChooserWithChosenComponentCallback(context, intent, chooserTitle, onComponentChosen);
            }
            obj = Result.constructor-impl(createChooserWithChosenComponentCallback);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Intent.createChooser(intent, chooserTitle);
        }
        Intent intent2 = (Intent) obj;
        intent2.addFlags(268435456);
        try {
            context.startActivity(intent2);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private final Intent createChooserWithChosenComponentCallback(Context context, Intent target, CharSequence chooserTitle, final Function1<? super ComponentName, Unit> onComponentChosen) {
        BroadcastReceiver broadcastReceiver;
        final Context applicationContext = context.getApplicationContext();
        String str = applicationContext.getPackageName() + ".SHARE_CHOSEN." + UUID.randomUUID();
        Intent intent = new Intent(str).setPackage(applicationContext.getPackageName());
        Intrinsics.checkNotNullExpressionValue(intent, "setPackage(...)");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        final Function0 function0 = new Function0() { // from class: com.bytedance.trae.conversation.share.ShareUtils$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit createChooserWithChosenComponentCallback$lambda$4;
                createChooserWithChosenComponentCallback$lambda$4 = ShareUtils.createChooserWithChosenComponentCallback$lambda$4(booleanRef, applicationContext, objectRef);
                return createChooserWithChosenComponentCallback$lambda$4;
            }
        };
        objectRef.element = new BroadcastReceiver() { // from class: com.bytedance.trae.conversation.share.ShareUtils$createChooserWithChosenComponentCallback$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent2) {
                ComponentName chosenComponent = intent2 != null ? ShareUtils.INSTANCE.chosenComponent(intent2) : null;
                function0.invoke();
                if (chosenComponent != null) {
                    onComponentChosen.invoke(chosenComponent);
                }
            }
        };
        if (objectRef.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiver");
            broadcastReceiver = null;
        } else {
            broadcastReceiver = (BroadcastReceiver) objectRef.element;
        }
        ContextCompat.registerReceiver(applicationContext, broadcastReceiver, new IntentFilter(str), 4);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.trae.conversation.share.ShareUtils$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        }, 60000L);
        Intent createChooser = Intent.createChooser(target, chooserTitle, PendingIntent.getBroadcast(applicationContext, str.hashCode(), intent, (Build.VERSION.SDK_INT >= 31 ? 33554432 : 0) | 134217728).getIntentSender());
        Intrinsics.checkNotNullExpressionValue(createChooser, "createChooser(...)");
        return createChooser;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createChooserWithChosenComponentCallback$lambda$4(Ref.BooleanRef booleanRef, Context context, Ref.ObjectRef objectRef) {
        BroadcastReceiver broadcastReceiver;
        if (booleanRef.element) {
            booleanRef.element = false;
            try {
                Result.Companion companion = Result.Companion;
                if (objectRef.element == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("receiver");
                    broadcastReceiver = null;
                } else {
                    broadcastReceiver = (BroadcastReceiver) objectRef.element;
                }
                m855xb754398a(context, broadcastReceiver);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ComponentName chosenComponent(Intent intent) {
        if (Build.VERSION.SDK_INT >= 33) {
            return (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT", ComponentName.class);
        }
        return (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
    }

    public static /* synthetic */ void shareImage$default(ShareUtils shareUtils, Context context, Uri uri, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            str2 = "分享图片";
        }
        shareUtils.shareImage(context, uri, str, str2);
    }

    public final void shareImage(Context context, Uri imageUri, String title, String chooserTitle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(chooserTitle, "chooserTitle");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", imageUri);
        boolean z = true;
        intent.addFlags(1);
        String str = title;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z) {
            intent.putExtra("android.intent.extra.SUBJECT", title);
            intent.putExtra("android.intent.extra.TITLE", title);
        }
        Intent createChooser = Intent.createChooser(intent, chooserTitle);
        createChooser.addFlags(268435456);
        context.startActivity(createChooser);
    }

    public static /* synthetic */ void shareMultipleImages$default(ShareUtils shareUtils, Context context, ArrayList arrayList, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            str2 = "分享图片";
        }
        shareUtils.shareMultipleImages(context, arrayList, str, str2);
    }

    public final void shareMultipleImages(Context context, ArrayList<Uri> imageUris, String title, String chooserTitle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUris, "imageUris");
        Intrinsics.checkNotNullParameter(chooserTitle, "chooserTitle");
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType("image/*");
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", imageUris);
        boolean z = true;
        intent.addFlags(1);
        String str = title;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z) {
            intent.putExtra("android.intent.extra.SUBJECT", title);
            intent.putExtra("android.intent.extra.TITLE", title);
        }
        Intent createChooser = Intent.createChooser(intent, chooserTitle);
        createChooser.addFlags(268435456);
        context.startActivity(createChooser);
    }

    public static /* synthetic */ void shareImageWithText$default(ShareUtils shareUtils, Context context, Uri uri, String str, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = "分享";
        }
        shareUtils.shareImageWithText(context, uri, str, str2);
    }

    public final void shareImageWithText(Context context, Uri imageUri, String text, String chooserTitle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(chooserTitle, "chooserTitle");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", imageUri);
        intent.putExtra("android.intent.extra.TEXT", text);
        intent.addFlags(1);
        Intent createChooser = Intent.createChooser(intent, chooserTitle);
        createChooser.addFlags(268435456);
        context.startActivity(createChooser);
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_bytedance_trae_conversation_share_ShareUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m855xb754398a(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
