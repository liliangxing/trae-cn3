package com.bytedance.kmp.network.requet;

import com.bytedance.kmp.network.UrlEncoderUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;

/* compiled from: FormRequestBody.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B#\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/kmp/network/requet/FormRequestBody;", "Lcom/bytedance/kmp/network/requet/RequestBody;", "names", "", "", "values", "(Ljava/util/List;Ljava/util/List;)V", "bufferString", "encodedNames", "encodedValues", "checkContent", "", "contentLength", "", "contentType", "writeTo", "sink", "Lokio/BufferedSink;", "Builder", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FormRequestBody extends RequestBody {
    private String bufferString;
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    public /* synthetic */ FormRequestBody(List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2);
    }

    @Override // com.bytedance.kmp.network.requet.RequestBody
    /* renamed from: contentType */
    public String get$contentType() {
        return "application/x-www-form-urlencoded";
    }

    private FormRequestBody(List<String> list, List<String> list2) {
        this.encodedNames = CollectionsKt.toList(list);
        this.encodedValues = CollectionsKt.toList(list2);
        this.bufferString = "";
    }

    private final void checkContent() {
        if (this.bufferString.length() > 0) {
            return;
        }
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                this.bufferString += '&';
            }
            this.bufferString += this.encodedNames.get(i);
            this.bufferString += '=';
            this.bufferString += this.encodedValues.get(i);
        }
    }

    @Override // com.bytedance.kmp.network.requet.RequestBody
    /* renamed from: contentLength */
    public long get$contentLength() {
        checkContent();
        return this.bufferString.length();
    }

    @Override // com.bytedance.kmp.network.requet.RequestBody
    public void writeTo(BufferedSink sink) {
        if (sink == null) {
            return;
        }
        checkContent();
        sink.writeUtf8(this.bufferString);
    }

    /* compiled from: FormRequestBody.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u001c\u0010\n\u001a\u00020\u00002\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/network/requet/FormRequestBody$Builder;", "", "()V", "names", "", "", "values", "add", "name", "value", "addAll", "data", "", "build", "Lcom/bytedance/kmp/network/requet/FormRequestBody;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Builder {
        private final List<String> names = new ArrayList();
        private final List<String> values = new ArrayList();

        public final Builder add(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.names.add(UrlEncoderUtil.encode$default(name, null, false, 6, null));
            this.values.add(UrlEncoderUtil.encode$default(value, null, false, 6, null));
            return this;
        }

        public final Builder addAll(Map<String, String> data) {
            if (data != null) {
                for (Map.Entry<String, String> entry : data.entrySet()) {
                    add(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public final FormRequestBody build() {
            return new FormRequestBody(this.names, this.values, null);
        }
    }
}
