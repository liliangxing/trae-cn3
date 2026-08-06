package com.bytedance.pia.core.bridge.binding;

import android.net.Uri;
import com.bytedance.pia.core.api.bridge.IAuthorizer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAuthorizer.kt */
@Deprecated(message = "legacy usage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/pia/core/bridge/binding/IAuthorizer;", "", "auth", "Lcom/bytedance/pia/core/api/bridge/IAuthorizer$Privilege;", "url", "Landroid/net/Uri;", "Companion", "Privilege", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IAuthorizer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    IAuthorizer.Privilege auth(Uri url);

    /* compiled from: IAuthorizer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/pia/core/bridge/binding/IAuthorizer$Privilege;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Public", "Protected", "Private", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public enum Privilege {
        Public(0),
        Protected(1),
        Private(2);

        private final int value;

        Privilege(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: IAuthorizer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/pia/core/bridge/binding/IAuthorizer$Companion;", "", "()V", "DefaultInstance", "Lcom/bytedance/pia/core/bridge/binding/IAuthorizer;", "getDefaultInstance", "()Lcom/bytedance/pia/core/bridge/binding/IAuthorizer;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IAuthorizer DefaultInstance = new IAuthorizer() { // from class: com.bytedance.pia.core.bridge.binding.IAuthorizer$Companion$DefaultInstance$1
            @Override // com.bytedance.pia.core.bridge.binding.IAuthorizer
            public IAuthorizer.Privilege auth(Uri url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return IAuthorizer.Privilege.Private;
            }
        };

        private Companion() {
        }

        public final IAuthorizer getDefaultInstance() {
            return DefaultInstance;
        }
    }
}
