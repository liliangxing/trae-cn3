package com.bytedance.ies.bullet.pool;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.CacheItem;
import com.bytedance.ies.bullet.service.base.Event;
import com.bytedance.ies.bullet.service.base.IEventObserver;
import com.bytedance.ies.bullet.service.base.IPreRenderConfig;
import com.bytedance.ies.bullet.service.base.IUniqueSchemaConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PreRenderConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/pool/PreRenderConfig;", "Lcom/bytedance/ies/bullet/service/base/IPreRenderConfig;", "builder", "Lcom/bytedance/ies/bullet/pool/PreRenderConfig$Builder;", "(Lcom/bytedance/ies/bullet/pool/PreRenderConfig$Builder;)V", "getEventObserver", "Lcom/bytedance/ies/bullet/service/base/IEventObserver;", "getPreRenderPoolSize", "", "getReUsePoolSize", "getUniqueSchemaConverter", "Lcom/bytedance/ies/bullet/service/base/IUniqueSchemaConverter;", "Builder", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PreRenderConfig implements IPreRenderConfig {
    private static final int DEFAULT_POOL_SIZE = 3;
    private final Builder builder;
    private static final PreRenderConfig$Companion$DEFAULT_UNIQUE_CONVERTER$1 DEFAULT_UNIQUE_CONVERTER = new IUniqueSchemaConverter() { // from class: com.bytedance.ies.bullet.pool.PreRenderConfig$Companion$DEFAULT_UNIQUE_CONVERTER$1
        @Override // com.bytedance.ies.bullet.service.base.IUniqueSchemaConverter
        public Uri convert(Uri schema) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            return schema;
        }
    };
    private static final PreRenderConfig$Companion$DEFAULT_EVENT_OBSERVER$1 DEFAULT_EVENT_OBSERVER = new IEventObserver() { // from class: com.bytedance.ies.bullet.pool.PreRenderConfig$Companion$DEFAULT_EVENT_OBSERVER$1
        @Override // com.bytedance.ies.bullet.service.base.IEventObserver
        public void onClearAll(JSONObject extraInfo) {
            Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        }

        @Override // com.bytedance.ies.bullet.service.base.IEventObserver
        public void onItemFetch(Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        @Override // com.bytedance.ies.bullet.service.base.IEventObserver
        public void onItemPut(Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        @Override // com.bytedance.ies.bullet.service.base.IEventObserver
        public void onItemRemove(Event event, JSONObject extraInfo) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        }

        @Override // com.bytedance.ies.bullet.service.base.IEventObserver
        public void onItemRemove(boolean evicted, String key, CacheItem oldValue, CacheItem newValue) {
        }
    };

    public /* synthetic */ PreRenderConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PreRenderConfig(Builder builder) {
        this.builder = builder;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderConfig
    public int getPreRenderPoolSize() {
        return this.builder.getPreRenderPoolSize();
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderConfig
    public int getReUsePoolSize() {
        return this.builder.getReUsePoolSize();
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderConfig
    public IUniqueSchemaConverter getUniqueSchemaConverter() {
        return this.builder.getUniqueSchemaConverter();
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderConfig
    public IEventObserver getEventObserver() {
        return this.builder.getEventObserver();
    }

    /* compiled from: PreRenderConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/pool/PreRenderConfig$Builder;", "", "()V", "eventObserver", "Lcom/bytedance/ies/bullet/service/base/IEventObserver;", "getEventObserver", "()Lcom/bytedance/ies/bullet/service/base/IEventObserver;", "setEventObserver", "(Lcom/bytedance/ies/bullet/service/base/IEventObserver;)V", "preRenderPoolSize", "", "getPreRenderPoolSize", "()I", "setPreRenderPoolSize", "(I)V", "reUsePoolSize", "getReUsePoolSize", "setReUsePoolSize", "uniqueSchemaConverter", "Lcom/bytedance/ies/bullet/service/base/IUniqueSchemaConverter;", "getUniqueSchemaConverter", "()Lcom/bytedance/ies/bullet/service/base/IUniqueSchemaConverter;", "setUniqueSchemaConverter", "(Lcom/bytedance/ies/bullet/service/base/IUniqueSchemaConverter;)V", "build", "Lcom/bytedance/ies/bullet/pool/PreRenderConfig;", "observer", "poolSize", "convert", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {
        private int preRenderPoolSize = 3;
        private int reUsePoolSize = 3;
        private IUniqueSchemaConverter uniqueSchemaConverter = PreRenderConfig.DEFAULT_UNIQUE_CONVERTER;
        private IEventObserver eventObserver = PreRenderConfig.DEFAULT_EVENT_OBSERVER;

        public final int getPreRenderPoolSize() {
            return this.preRenderPoolSize;
        }

        /* renamed from: setPreRenderPoolSize, reason: collision with other method in class */
        public final void m7703setPreRenderPoolSize(int i) {
            this.preRenderPoolSize = i;
        }

        public final int getReUsePoolSize() {
            return this.reUsePoolSize;
        }

        /* renamed from: setReUsePoolSize, reason: collision with other method in class */
        public final void m7704setReUsePoolSize(int i) {
            this.reUsePoolSize = i;
        }

        public final IUniqueSchemaConverter getUniqueSchemaConverter() {
            return this.uniqueSchemaConverter;
        }

        /* renamed from: setUniqueSchemaConverter, reason: collision with other method in class */
        public final void m7705setUniqueSchemaConverter(IUniqueSchemaConverter iUniqueSchemaConverter) {
            Intrinsics.checkNotNullParameter(iUniqueSchemaConverter, "<set-?>");
            this.uniqueSchemaConverter = iUniqueSchemaConverter;
        }

        public final IEventObserver getEventObserver() {
            return this.eventObserver;
        }

        /* renamed from: setEventObserver, reason: collision with other method in class */
        public final void m7702setEventObserver(IEventObserver iEventObserver) {
            Intrinsics.checkNotNullParameter(iEventObserver, "<set-?>");
            this.eventObserver = iEventObserver;
        }

        public final Builder setPreRenderPoolSize(int poolSize) {
            this.preRenderPoolSize = poolSize;
            return this;
        }

        public final Builder setReUsePoolSize(int poolSize) {
            this.reUsePoolSize = poolSize;
            return this;
        }

        public final Builder setUniqueSchemaConverter(IUniqueSchemaConverter convert) {
            Intrinsics.checkNotNullParameter(convert, "convert");
            this.uniqueSchemaConverter = convert;
            return this;
        }

        public final Builder setEventObserver(IEventObserver observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.eventObserver = observer;
            return this;
        }

        public final PreRenderConfig build() {
            return new PreRenderConfig(this, null);
        }
    }
}
