package coil3.network.bytedance.internal;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import coil3.Uri;
import coil3.fetch.Fetcher;
import coil3.network.bytedance.KtorNetworkFetcher;
import coil3.util.FetcherServiceLoaderTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: KmpNetworkFetcherServiceLoaderTarget.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcoil3/network/bytedance/internal/KmpNetworkFetcherServiceLoaderTarget;", "Lcoil3/util/FetcherServiceLoaderTarget;", "Lcoil3/Uri;", "()V", "factory", "Lcoil3/network/NetworkFetcher$Factory;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lkotlin/reflect/KClass;", "coil_network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class KmpNetworkFetcherServiceLoaderTarget implements FetcherServiceLoaderTarget<Uri> {
    @Override // coil3.util.FetcherServiceLoaderTarget
    public KClass<Uri> type() {
        return Reflection.getOrCreateKotlinClass(Uri.class);
    }

    @Override // coil3.util.FetcherServiceLoaderTarget
    public Fetcher.Factory<Uri> factory() {
        return KtorNetworkFetcher.factory();
    }
}
