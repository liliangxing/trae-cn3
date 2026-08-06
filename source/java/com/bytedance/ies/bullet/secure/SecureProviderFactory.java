package com.bytedance.ies.bullet.secure;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.kit.web.IWebSecureDelegate;
import kotlin.Metadata;

/* compiled from: ArgusWebDelegateAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/secure/SecureProviderFactory;", "", "enablePIA", "", "()Ljava/lang/Boolean;", "getContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getExternDelegate", "Lcom/bytedance/ies/bullet/kit/web/IWebSecureDelegate;", "getSchema", "", "getSecLinkScene", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface SecureProviderFactory {

    /* compiled from: ArgusWebDelegateAdapter.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static Boolean enablePIA(SecureProviderFactory secureProviderFactory) {
            return null;
        }

        public static IWebSecureDelegate getExternDelegate(SecureProviderFactory secureProviderFactory) {
            return null;
        }

        public static String getSchema(SecureProviderFactory secureProviderFactory) {
            return null;
        }

        public static String getSecLinkScene(SecureProviderFactory secureProviderFactory) {
            return null;
        }
    }

    Boolean enablePIA();

    BulletContext getContext();

    IWebSecureDelegate getExternDelegate();

    String getSchema();

    String getSecLinkScene();
}
