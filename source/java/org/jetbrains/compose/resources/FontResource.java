package org.jetbrains.compose.resources;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontResources.android.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lorg/jetbrains/compose/resources/FontResource;", "Lorg/jetbrains/compose/resources/Resource;", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class FontResource extends Resource {
    public static final int $stable = 0;
    private final String path;

    public final String getPath() {
        return this.path;
    }

    public FontResource(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
    }
}
