package com.bytedance.salamander.anniex;

import android.net.Uri;
import com.bytedance.rts.foundation.console;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorFoundationImplAnnieXUri.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXUri;", "Lcom/bytedance/salamander/anniex/IUri;", "s", "", "(Ljava/lang/String;)V", "_uri", "Landroid/net/Uri;", "getHost", "getPath", "getQueryParameter", "key", "getScheme", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class AnnieXUri implements IUri {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Uri _uri;

    public AnnieXUri(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        Uri parse = Uri.parse(s);
        Intrinsics.checkNotNull(parse);
        this._uri = parse;
    }

    @Override // com.bytedance.salamander.anniex.IUri
    public String getHost() {
        Uri uri = this._uri;
        if (uri != null) {
            return uri.getHost();
        }
        return null;
    }

    @Override // com.bytedance.salamander.anniex.IUri
    public String getPath() {
        Uri uri = this._uri;
        if (uri != null) {
            return uri.getPath();
        }
        return null;
    }

    @Override // com.bytedance.salamander.anniex.IUri
    public String getScheme() {
        Uri uri = this._uri;
        if (uri != null) {
            return uri.getScheme();
        }
        return null;
    }

    @Override // com.bytedance.salamander.anniex.IUri
    public String getQueryParameter(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Uri uri = this._uri;
            if (uri != null) {
                return uri.getQueryParameter(key);
            }
            return null;
        } catch (Throwable th) {
            console.INSTANCE.log(th);
            return null;
        }
    }

    /* compiled from: AnniexMonitorFoundationImplAnnieXUri.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXUri$Companion;", "", "()V", "createUri", "Lcom/bytedance/salamander/anniex/AnnieXUri;", "uriStr", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public AnnieXUri createUri(String uriStr) {
            Intrinsics.checkNotNullParameter(uriStr, "uriStr");
            try {
                return new AnnieXUri(uriStr);
            } catch (Throwable th) {
                console.INSTANCE.log(th);
                return null;
            }
        }
    }
}
