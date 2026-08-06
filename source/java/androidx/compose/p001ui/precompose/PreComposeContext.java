package androidx.compose.p001ui.precompose;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Delegates.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0003J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/precompose/PreComposeContext;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "<init>", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "context", "Ljava/lang/ref/WeakReference;", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "replaceContext", "", "startActivity", "intent", "Landroid/content/Intent;", "getResources", "Landroid/content/res/Resources;", "getAssets", "Landroid/content/res/AssetManager;", "getBaseContext", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PreComposeContext extends ContextThemeWrapper {
    public static final int $stable = 8;
    private WeakReference<Context> context;

    public final WeakReference<Context> getContext() {
        return this.context;
    }

    public final void setContext(WeakReference<Context> weakReference) {
        this.context = weakReference;
    }

    public PreComposeContext(Context context, int i) {
        super(context.getApplicationContext(), i);
        this.context = new WeakReference<>(context);
    }

    public PreComposeContext(Context context) {
        super(context, 0);
        this.context = new WeakReference<>(context);
    }

    public final void replaceContext(Context context) {
        this.context = new WeakReference<>(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        WeakReference<Context> weakReference = this.context;
        if ((weakReference != null ? weakReference.get() : null) instanceof Activity) {
            WeakReference<Context> weakReference2 = this.context;
            Context context = weakReference2 != null ? weakReference2.get() : null;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).startActivity(intent);
            return;
        }
        throw new IllegalStateException("Context is null or not an Activity".toString());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Context context;
        Resources resources;
        WeakReference<Context> weakReference = this.context;
        return (weakReference == null || (context = weakReference.get()) == null || (resources = context.getResources()) == null) ? super.getResources() : resources;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        Context context;
        Resources resources;
        AssetManager assets;
        WeakReference<Context> weakReference = this.context;
        return (weakReference == null || (context = weakReference.get()) == null || (resources = context.getResources()) == null || (assets = resources.getAssets()) == null) ? super.getAssets() : assets;
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        WeakReference<Context> weakReference = this.context;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
