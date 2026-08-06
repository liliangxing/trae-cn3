package org.jetbrains.compose.resources;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceContextInit.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\b\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"composeResourceContext", "Landroid/content/Context;", "getResourceContext", "initKMPResourceContext", "", "context", "library_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ResourceContextInitKt {
    private static Context composeResourceContext;

    public static final Context getResourceContext() {
        Context context = composeResourceContext;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Make sure call org.jetbrains.compose.resources.initResourceContext to init compose resource context");
    }

    public static final void initKMPResourceContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        composeResourceContext = context;
    }
}
