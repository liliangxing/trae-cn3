package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import kotlin.Metadata;

/* compiled from: IRouterAbilityProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IRouterAbilityProvider;", "", "close", "", "getBid", "", "getBulletTag", "getBundle", "getChannel", "getContainerId", "getSchema", "Landroid/net/Uri;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IRouterAbilityProvider {

    /* compiled from: IRouterAbilityProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static String getBulletTag(IRouterAbilityProvider iRouterAbilityProvider) {
            return null;
        }

        public static String getContainerId(IRouterAbilityProvider iRouterAbilityProvider) {
            return "";
        }

        public static Uri getSchema(IRouterAbilityProvider iRouterAbilityProvider) {
            return null;
        }
    }

    void close();

    String getBid();

    String getBulletTag();

    String getBundle();

    String getChannel();

    String getContainerId();

    Uri getSchema();
}
