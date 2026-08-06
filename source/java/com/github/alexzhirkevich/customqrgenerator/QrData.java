package com.github.alexzhirkevich.customqrgenerator;

import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.common.Scopes;
import com.heytap.mcssdk.constant.C0879b;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import com.lynx.tasm.DefaultLogicExecutor;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: QrData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u000f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0013"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "", "encode", "", "BizCard", "Bookmark", "Email", "EnterpriseWifi", "Event", "GeoPos", "GooglePlay", "MeCard", "Phone", "SMS", "Text", "Url", "VCard", "Wifi", "YouTube", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrData {
    String encode();

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$Text;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "encode", "equals", "", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Text implements QrData {
        private final String value;

        public static /* synthetic */ Text copy$default(Text text, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = text.value;
            }
            return text.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final Text copy(String value) {
            Intrinsics.checkNotNullParameter(value, CustomDataTagHandler.VALUE_ATTRIBUTE);
            return new Text(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Text) && Intrinsics.areEqual(this.value, ((Text) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Text(value=" + this.value + ')';
        }

        public Text(String str) {
            Intrinsics.checkNotNullParameter(str, CustomDataTagHandler.VALUE_ATTRIBUTE);
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            return this.value;
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$Url;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "encode", "equals", "", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Url implements QrData {
        private final String url;

        public static /* synthetic */ Url copy$default(Url url, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = url.url;
            }
            return url.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final Url copy(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new Url(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Url) && Intrinsics.areEqual(this.url, ((Url) other).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "Url(url=" + this.url + ')';
        }

        public Url(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            this.url = str;
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            return this.url;
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$Email;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", Scopes.EMAIL, "", "copyTo", "subject", "body", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBody", "()Ljava/lang/String;", "getCopyTo", "getEmail", "getSubject", "component1", "component2", "component3", "component4", "copy", "encode", "equals", "", "other", "", "escape", "text", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Email implements QrData {
        private final String body;
        private final String copyTo;
        private final String email;
        private final String subject;

        public static /* synthetic */ Email copy$default(Email email, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = email.email;
            }
            if ((i & 2) != 0) {
                str2 = email.copyTo;
            }
            if ((i & 4) != 0) {
                str3 = email.subject;
            }
            if ((i & 8) != 0) {
                str4 = email.body;
            }
            return email.copy(str, str2, str3, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCopyTo() {
            return this.copyTo;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSubject() {
            return this.subject;
        }

        /* renamed from: component4, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        public final Email copy(String email, String copyTo, String subject, String body) {
            Intrinsics.checkNotNullParameter(email, Scopes.EMAIL);
            return new Email(email, copyTo, subject, body);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Email)) {
                return false;
            }
            Email email = (Email) other;
            return Intrinsics.areEqual(this.email, email.email) && Intrinsics.areEqual(this.copyTo, email.copyTo) && Intrinsics.areEqual(this.subject, email.subject) && Intrinsics.areEqual(this.body, email.body);
        }

        public int hashCode() {
            int hashCode = this.email.hashCode() * 31;
            String str = this.copyTo;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.subject;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.body;
            return hashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Email(email=" + this.email + ", copyTo=" + this.copyTo + ", subject=" + this.subject + ", body=" + this.body + ')';
        }

        public Email(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, Scopes.EMAIL);
            this.email = str;
            this.copyTo = str2;
            this.subject = str3;
            this.body = str4;
        }

        public /* synthetic */ Email(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getCopyTo() {
            return this.copyTo;
        }

        public final String getSubject() {
            return this.subject;
        }

        public final String getBody() {
            return this.body;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            boolean z;
            StringBuilder sb = new StringBuilder();
            sb.append("mailto:" + this.email);
            List<String> listOf = CollectionsKt.listOf(new String[]{this.copyTo, this.subject, this.body});
            if (!(listOf instanceof Collection) || !listOf.isEmpty()) {
                for (String str : listOf) {
                    if (!(str == null || str.length() == 0)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                sb.append("?");
            }
            List createListBuilder = CollectionsKt.createListBuilder();
            String str2 = this.copyTo;
            if (!(str2 == null || str2.length() == 0)) {
                createListBuilder.add("cc=" + this.copyTo);
            }
            String str3 = this.subject;
            if (!(str3 == null || str3.length() == 0)) {
                StringBuilder sb2 = new StringBuilder("subject=");
                String str4 = this.subject;
                Intrinsics.checkNotNull(str4);
                createListBuilder.add(sb2.append(escape(str4)).toString());
            }
            String str5 = this.body;
            if (!(str5 == null || str5.length() == 0)) {
                StringBuilder sb3 = new StringBuilder("body=");
                String str6 = this.body;
                Intrinsics.checkNotNull(str6);
                createListBuilder.add(sb3.append(escape(str6)).toString());
            }
            sb.append(CollectionsKt.joinToString$default(CollectionsKt.build(createListBuilder), ContainerUtils.FIELD_DELIMITER, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            String sb4 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            return sb4;
        }

        private final String escape(String text) {
            String encode = URLEncoder.encode(text, Charsets.UTF_8.name());
            Intrinsics.checkNotNullExpressionValue(encode, "encode(text, Charsets.UTF_8.name())");
            return StringsKt.replace$default(encode, "+", " ", false, 4, (Object) null);
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$GeoPos;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "lat", "", "lon", "(FF)V", "getLat", "()F", "getLon", "component1", "component2", "copy", "encode", "", "equals", "", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class GeoPos implements QrData {
        private final float lat;
        private final float lon;

        public static /* synthetic */ GeoPos copy$default(GeoPos geoPos, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = geoPos.lat;
            }
            if ((i & 2) != 0) {
                f2 = geoPos.lon;
            }
            return geoPos.copy(f, f2);
        }

        /* renamed from: component1, reason: from getter */
        public final float getLat() {
            return this.lat;
        }

        /* renamed from: component2, reason: from getter */
        public final float getLon() {
            return this.lon;
        }

        public final GeoPos copy(float lat, float lon) {
            return new GeoPos(lat, lon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GeoPos)) {
                return false;
            }
            GeoPos geoPos = (GeoPos) other;
            return Intrinsics.areEqual(Float.valueOf(this.lat), Float.valueOf(geoPos.lat)) && Intrinsics.areEqual(Float.valueOf(this.lon), Float.valueOf(geoPos.lon));
        }

        public int hashCode() {
            return (Float.hashCode(this.lat) * 31) + Float.hashCode(this.lon);
        }

        public String toString() {
            return "GeoPos(lat=" + this.lat + ", lon=" + this.lon + ')';
        }

        public GeoPos(float f, float f2) {
            this.lat = f;
            this.lon = f2;
        }

        public final float getLat() {
            return this.lat;
        }

        public final float getLon() {
            return this.lon;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            return "GEO:" + this.lat + ',' + this.lon;
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$Bookmark;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "url", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "encode", "equals", "", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Bookmark implements QrData {
        private final String title;
        private final String url;

        public static /* synthetic */ Bookmark copy$default(Bookmark bookmark, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bookmark.url;
            }
            if ((i & 2) != 0) {
                str2 = bookmark.title;
            }
            return bookmark.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final Bookmark copy(String url, String title) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(title, "title");
            return new Bookmark(url, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Bookmark)) {
                return false;
            }
            Bookmark bookmark = (Bookmark) other;
            return Intrinsics.areEqual(this.url, bookmark.url) && Intrinsics.areEqual(this.title, bookmark.title);
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + this.title.hashCode();
        }

        public String toString() {
            return "Bookmark(url=" + this.url + ", title=" + this.title + ')';
        }

        public Bookmark(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.url = str;
            this.title = str2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getTitle() {
            return this.title;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            StringBuilder sb = new StringBuilder("MEBKM:");
            sb.append("URL:" + this.url + ';');
            sb.append("TITLE:" + this.title + ';');
            sb.append(";");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$Wifi;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "authentication", "Lcom/github/alexzhirkevich/customqrgenerator/QrData$Wifi$Authentication;", "ssid", "", "psk", "hidden", "", "(Lcom/github/alexzhirkevich/customqrgenerator/QrData$Wifi$Authentication;Ljava/lang/String;Ljava/lang/String;Z)V", "getAuthentication", "()Lcom/github/alexzhirkevich/customqrgenerator/QrData$Wifi$Authentication;", "getHidden", "()Z", "getPsk", "()Ljava/lang/String;", "getSsid", "component1", "component2", "component3", "component4", "copy", "encode", "equals", "other", "", "hashCode", "", "toString", "Authentication", "Companion", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Wifi implements QrData {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Authentication authentication;
        private final boolean hidden;
        private final String psk;
        private final String ssid;

        public Wifi() {
            this(null, null, null, false, 15, null);
        }

        public static /* synthetic */ Wifi copy$default(Wifi wifi, Authentication authentication, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                authentication = wifi.authentication;
            }
            if ((i & 2) != 0) {
                str = wifi.ssid;
            }
            if ((i & 4) != 0) {
                str2 = wifi.psk;
            }
            if ((i & 8) != 0) {
                z = wifi.hidden;
            }
            return wifi.copy(authentication, str, str2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final Authentication getAuthentication() {
            return this.authentication;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSsid() {
            return this.ssid;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPsk() {
            return this.psk;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getHidden() {
            return this.hidden;
        }

        public final Wifi copy(Authentication authentication, String ssid, String psk, boolean hidden) {
            return new Wifi(authentication, ssid, psk, hidden);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Wifi)) {
                return false;
            }
            Wifi wifi = (Wifi) other;
            return this.authentication == wifi.authentication && Intrinsics.areEqual(this.ssid, wifi.ssid) && Intrinsics.areEqual(this.psk, wifi.psk) && this.hidden == wifi.hidden;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Authentication authentication = this.authentication;
            int hashCode = (authentication == null ? 0 : authentication.hashCode()) * 31;
            String str = this.ssid;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.psk;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z = this.hidden;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "Wifi(authentication=" + this.authentication + ", ssid=" + this.ssid + ", psk=" + this.psk + ", hidden=" + this.hidden + ')';
        }

        public Wifi(Authentication authentication, String str, String str2, boolean z) {
            this.authentication = authentication;
            this.ssid = str;
            this.psk = str2;
            this.hidden = z;
        }

        public /* synthetic */ Wifi(Authentication authentication, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : authentication, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z);
        }

        public final Authentication getAuthentication() {
            return this.authentication;
        }

        public final String getSsid() {
            return this.ssid;
        }

        public final String getPsk() {
            return this.psk;
        }

        public final boolean getHidden() {
            return this.hidden;
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: QrData.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$Wifi$Authentication;", "", "(Ljava/lang/String;I)V", "WEP", "WPA", "OPEN", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Authentication {
            public static final Authentication WEP = new Authentication("WEP", 0);
            public static final Authentication WPA = new Authentication("WPA", 1);
            public static final Authentication OPEN = new OPEN("OPEN", 2);
            private static final /* synthetic */ Authentication[] $VALUES = $values();

            private static final /* synthetic */ Authentication[] $values() {
                return new Authentication[]{WEP, WPA, OPEN};
            }

            public /* synthetic */ Authentication(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, i);
            }

            public static Authentication valueOf(String str) {
                return (Authentication) Enum.valueOf(Authentication.class, str);
            }

            public static Authentication[] values() {
                return (Authentication[]) $VALUES.clone();
            }

            private Authentication(String str, int i) {
            }

            /* compiled from: QrData.kt */
            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$Wifi$Authentication$OPEN;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData$Wifi$Authentication;", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
            static final class OPEN extends Authentication {
                @Override // java.lang.Enum
                public String toString() {
                    return "nopass";
                }

                OPEN(String str, int i) {
                    super(str, i, null);
                }
            }
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            StringBuilder sb = new StringBuilder("WIFI:");
            if (this.ssid != null) {
                sb.append("S:" + INSTANCE.escape(this.ssid) + ';');
            }
            if (this.authentication != null) {
                sb.append("T:" + this.authentication + ';');
            }
            if (this.psk != null) {
                sb.append("P:" + INSTANCE.escape(this.psk) + ';');
            }
            sb.append("H:" + this.hidden + ';');
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }

        /* compiled from: QrData.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$Wifi$Companion;", "", "()V", "escape", "", "text", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String escape(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(text, "\\", "\\\\", false, 4, (Object) null), ",", "\\,", false, 4, (Object) null), ";", "\\;", false, 4, (Object) null), ".", "\\.", false, 4, (Object) null), "\"", "\\\"", false, 4, (Object) null), "'", "\\'", false, 4, (Object) null);
            }
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$EnterpriseWifi;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "ssid", "", "psk", "hidden", "", "user", "eap", "phase", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEap", "()Ljava/lang/String;", "getHidden", "()Z", "getPhase", "getPsk", "getSsid", "getUser", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "encode", "equals", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class EnterpriseWifi implements QrData {
        private final String eap;
        private final boolean hidden;
        private final String phase;
        private final String psk;
        private final String ssid;
        private final String user;

        public EnterpriseWifi() {
            this(null, null, false, null, null, null, 63, null);
        }

        public static /* synthetic */ EnterpriseWifi copy$default(EnterpriseWifi enterpriseWifi, String str, String str2, boolean z, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = enterpriseWifi.ssid;
            }
            if ((i & 2) != 0) {
                str2 = enterpriseWifi.psk;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                z = enterpriseWifi.hidden;
            }
            boolean z2 = z;
            if ((i & 8) != 0) {
                str3 = enterpriseWifi.user;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str4 = enterpriseWifi.eap;
            }
            String str8 = str4;
            if ((i & 32) != 0) {
                str5 = enterpriseWifi.phase;
            }
            return enterpriseWifi.copy(str, str6, z2, str7, str8, str5);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSsid() {
            return this.ssid;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPsk() {
            return this.psk;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getHidden() {
            return this.hidden;
        }

        /* renamed from: component4, reason: from getter */
        public final String getUser() {
            return this.user;
        }

        /* renamed from: component5, reason: from getter */
        public final String getEap() {
            return this.eap;
        }

        /* renamed from: component6, reason: from getter */
        public final String getPhase() {
            return this.phase;
        }

        public final EnterpriseWifi copy(String ssid, String psk, boolean hidden, String user, String eap, String phase) {
            return new EnterpriseWifi(ssid, psk, hidden, user, eap, phase);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EnterpriseWifi)) {
                return false;
            }
            EnterpriseWifi enterpriseWifi = (EnterpriseWifi) other;
            return Intrinsics.areEqual(this.ssid, enterpriseWifi.ssid) && Intrinsics.areEqual(this.psk, enterpriseWifi.psk) && this.hidden == enterpriseWifi.hidden && Intrinsics.areEqual(this.user, enterpriseWifi.user) && Intrinsics.areEqual(this.eap, enterpriseWifi.eap) && Intrinsics.areEqual(this.phase, enterpriseWifi.phase);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.ssid;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.psk;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            boolean z = this.hidden;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode2 + i) * 31;
            String str3 = this.user;
            int hashCode3 = (i2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.eap;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.phase;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "EnterpriseWifi(ssid=" + this.ssid + ", psk=" + this.psk + ", hidden=" + this.hidden + ", user=" + this.user + ", eap=" + this.eap + ", phase=" + this.phase + ')';
        }

        public EnterpriseWifi(String str, String str2, boolean z, String str3, String str4, String str5) {
            this.ssid = str;
            this.psk = str2;
            this.hidden = z;
            this.user = str3;
            this.eap = str4;
            this.phase = str5;
        }

        public /* synthetic */ EnterpriseWifi(String str, String str2, boolean z, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
        }

        public final String getSsid() {
            return this.ssid;
        }

        public final String getPsk() {
            return this.psk;
        }

        public final boolean getHidden() {
            return this.hidden;
        }

        public final String getUser() {
            return this.user;
        }

        public final String getEap() {
            return this.eap;
        }

        public final String getPhase() {
            return this.phase;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            StringBuilder sb = new StringBuilder("WIFI:");
            if (this.ssid != null) {
                sb.append("S:" + Wifi.INSTANCE.escape(this.ssid) + ';');
            }
            if (this.user != null) {
                sb.append("U:" + Wifi.INSTANCE.escape(this.user) + ';');
            }
            if (this.psk != null) {
                sb.append("P:" + Wifi.INSTANCE.escape(this.psk) + ';');
            }
            if (this.eap != null) {
                sb.append("E:" + Wifi.INSTANCE.escape(this.eap) + ';');
            }
            if (this.phase != null) {
                sb.append("PH:" + Wifi.INSTANCE.escape(this.phase) + ';');
            }
            sb.append("H:" + this.hidden + ';');
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$Phone;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "phoneNumber", "", "(Ljava/lang/String;)V", "getPhoneNumber", "()Ljava/lang/String;", "component1", "copy", "encode", "equals", "", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Phone implements QrData {
        private final String phoneNumber;

        public static /* synthetic */ Phone copy$default(Phone phone, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = phone.phoneNumber;
            }
            return phone.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final Phone copy(String phoneNumber) {
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            return new Phone(phoneNumber);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Phone) && Intrinsics.areEqual(this.phoneNumber, ((Phone) other).phoneNumber);
        }

        public int hashCode() {
            return this.phoneNumber.hashCode();
        }

        public String toString() {
            return "Phone(phoneNumber=" + this.phoneNumber + ')';
        }

        public Phone(String str) {
            Intrinsics.checkNotNullParameter(str, "phoneNumber");
            this.phoneNumber = str;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            return "TEL:" + this.phoneNumber;
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$SMS;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "phoneNumber", "", "subject", "isMMS", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getPhoneNumber", "()Ljava/lang/String;", "getSubject", "component1", "component2", "component3", "copy", "encode", "equals", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class SMS implements QrData {
        private final boolean isMMS;
        private final String phoneNumber;
        private final String subject;

        public static /* synthetic */ SMS copy$default(SMS sms, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sms.phoneNumber;
            }
            if ((i & 2) != 0) {
                str2 = sms.subject;
            }
            if ((i & 4) != 0) {
                z = sms.isMMS;
            }
            return sms.copy(str, str2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSubject() {
            return this.subject;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsMMS() {
            return this.isMMS;
        }

        public final SMS copy(String phoneNumber, String subject, boolean isMMS) {
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            Intrinsics.checkNotNullParameter(subject, "subject");
            return new SMS(phoneNumber, subject, isMMS);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SMS)) {
                return false;
            }
            SMS sms = (SMS) other;
            return Intrinsics.areEqual(this.phoneNumber, sms.phoneNumber) && Intrinsics.areEqual(this.subject, sms.subject) && this.isMMS == sms.isMMS;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.phoneNumber.hashCode() * 31) + this.subject.hashCode()) * 31;
            boolean z = this.isMMS;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public String toString() {
            return "SMS(phoneNumber=" + this.phoneNumber + ", subject=" + this.subject + ", isMMS=" + this.isMMS + ')';
        }

        public SMS(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "phoneNumber");
            Intrinsics.checkNotNullParameter(str2, "subject");
            this.phoneNumber = str;
            this.subject = str2;
            this.isMMS = z;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final String getSubject() {
            return this.subject;
        }

        public final boolean isMMS() {
            return this.isMMS;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            return (this.isMMS ? "MMS" : "SMS") + ':' + this.phoneNumber + (this.subject.length() > 0 ? ":" + this.subject : "");
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006#"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$BizCard;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "firstName", "", "secondName", "job", "company", "address", "phone", Scopes.EMAIL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getCompany", "getEmail", "getFirstName", "getJob", "getPhone", "getSecondName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "encode", "equals", "", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class BizCard implements QrData {
        private final String address;
        private final String company;
        private final String email;
        private final String firstName;
        private final String job;
        private final String phone;
        private final String secondName;

        public BizCard() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ BizCard copy$default(BizCard bizCard, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bizCard.firstName;
            }
            if ((i & 2) != 0) {
                str2 = bizCard.secondName;
            }
            String str8 = str2;
            if ((i & 4) != 0) {
                str3 = bizCard.job;
            }
            String str9 = str3;
            if ((i & 8) != 0) {
                str4 = bizCard.company;
            }
            String str10 = str4;
            if ((i & 16) != 0) {
                str5 = bizCard.address;
            }
            String str11 = str5;
            if ((i & 32) != 0) {
                str6 = bizCard.phone;
            }
            String str12 = str6;
            if ((i & 64) != 0) {
                str7 = bizCard.email;
            }
            return bizCard.copy(str, str8, str9, str10, str11, str12, str7);
        }

        /* renamed from: component1, reason: from getter */
        public final String getFirstName() {
            return this.firstName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSecondName() {
            return this.secondName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getJob() {
            return this.job;
        }

        /* renamed from: component4, reason: from getter */
        public final String getCompany() {
            return this.company;
        }

        /* renamed from: component5, reason: from getter */
        public final String getAddress() {
            return this.address;
        }

        /* renamed from: component6, reason: from getter */
        public final String getPhone() {
            return this.phone;
        }

        /* renamed from: component7, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        public final BizCard copy(String firstName, String secondName, String job, String company, String address, String phone, String email) {
            return new BizCard(firstName, secondName, job, company, address, phone, email);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BizCard)) {
                return false;
            }
            BizCard bizCard = (BizCard) other;
            return Intrinsics.areEqual(this.firstName, bizCard.firstName) && Intrinsics.areEqual(this.secondName, bizCard.secondName) && Intrinsics.areEqual(this.job, bizCard.job) && Intrinsics.areEqual(this.company, bizCard.company) && Intrinsics.areEqual(this.address, bizCard.address) && Intrinsics.areEqual(this.phone, bizCard.phone) && Intrinsics.areEqual(this.email, bizCard.email);
        }

        public int hashCode() {
            String str = this.firstName;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.secondName;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.job;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.company;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.address;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.phone;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.email;
            return hashCode6 + (str7 != null ? str7.hashCode() : 0);
        }

        public String toString() {
            return "BizCard(firstName=" + this.firstName + ", secondName=" + this.secondName + ", job=" + this.job + ", company=" + this.company + ", address=" + this.address + ", phone=" + this.phone + ", email=" + this.email + ')';
        }

        public BizCard(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.firstName = str;
            this.secondName = str2;
            this.job = str3;
            this.company = str4;
            this.address = str5;
            this.phone = str6;
            this.email = str7;
        }

        public /* synthetic */ BizCard(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final String getSecondName() {
            return this.secondName;
        }

        public final String getJob() {
            return this.job;
        }

        public final String getCompany() {
            return this.company;
        }

        public final String getAddress() {
            return this.address;
        }

        public final String getPhone() {
            return this.phone;
        }

        public final String getEmail() {
            return this.email;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            StringBuilder sb = new StringBuilder("BIZCARD:");
            if (this.firstName != null) {
                sb.append("N:" + this.firstName + ';');
            }
            if (this.secondName != null) {
                sb.append("X:" + this.secondName + ';');
            }
            if (this.job != null) {
                sb.append("T:" + this.job + ';');
            }
            if (this.company != null) {
                sb.append("C:" + this.company + ';');
            }
            if (this.address != null) {
                sb.append("A:" + this.address + ';');
            }
            if (this.phone != null) {
                sb.append("B:" + this.phone + ';');
            }
            if (this.email != null) {
                sb.append("E:" + this.email + ';');
            }
            sb.append(";");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006&"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$VCard;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "", "company", "title", "phoneNumber", Scopes.EMAIL, "address", "website", "note", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getCompany", "getEmail", "getName", "getNote", "getPhoneNumber", "getTitle", "getWebsite", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "encode", "equals", "", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class VCard implements QrData {
        private final String address;
        private final String company;
        private final String email;
        private final String name;
        private final String note;
        private final String phoneNumber;
        private final String title;
        private final String website;

        public VCard() {
            this(null, null, null, null, null, null, null, null, JfifUtil.MARKER_FIRST_BYTE, null);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCompany() {
            return this.company;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component4, reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        /* renamed from: component5, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* renamed from: component6, reason: from getter */
        public final String getAddress() {
            return this.address;
        }

        /* renamed from: component7, reason: from getter */
        public final String getWebsite() {
            return this.website;
        }

        /* renamed from: component8, reason: from getter */
        public final String getNote() {
            return this.note;
        }

        public final VCard copy(String name, String company, String title, String phoneNumber, String email, String address, String website, String note) {
            return new VCard(name, company, title, phoneNumber, email, address, website, note);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VCard)) {
                return false;
            }
            VCard vCard = (VCard) other;
            return Intrinsics.areEqual(this.name, vCard.name) && Intrinsics.areEqual(this.company, vCard.company) && Intrinsics.areEqual(this.title, vCard.title) && Intrinsics.areEqual(this.phoneNumber, vCard.phoneNumber) && Intrinsics.areEqual(this.email, vCard.email) && Intrinsics.areEqual(this.address, vCard.address) && Intrinsics.areEqual(this.website, vCard.website) && Intrinsics.areEqual(this.note, vCard.note);
        }

        public int hashCode() {
            String str = this.name;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.company;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.title;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.phoneNumber;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.email;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.address;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.website;
            int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.note;
            return hashCode7 + (str8 != null ? str8.hashCode() : 0);
        }

        public String toString() {
            return "VCard(name=" + this.name + ", company=" + this.company + ", title=" + this.title + ", phoneNumber=" + this.phoneNumber + ", email=" + this.email + ", address=" + this.address + ", website=" + this.website + ", note=" + this.note + ')';
        }

        public VCard(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.name = str;
            this.company = str2;
            this.title = str3;
            this.phoneNumber = str4;
            this.email = str5;
            this.address = str6;
            this.website = str7;
            this.note = str8;
        }

        public /* synthetic */ VCard(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) == 0 ? str8 : null);
        }

        public final String getName() {
            return this.name;
        }

        public final String getCompany() {
            return this.company;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getAddress() {
            return this.address;
        }

        public final String getWebsite() {
            return this.website;
        }

        public final String getNote() {
            return this.note;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            StringBuilder sb = new StringBuilder("BEGIN:VCARD\nVERSION:3.0\n");
            if (this.name != null) {
                sb.append("N:" + this.name + '\n');
            }
            if (this.company != null) {
                sb.append("ORG:" + this.company + '\n');
            }
            if (this.title != null) {
                sb.append("TITLE" + this.title + '\n');
            }
            if (this.phoneNumber != null) {
                sb.append("TEL:" + this.phoneNumber + '\n');
            }
            if (this.website != null) {
                sb.append("URL:" + this.website + '\n');
            }
            if (this.email != null) {
                sb.append("EMAIL:" + this.email + '\n');
            }
            if (this.address != null) {
                sb.append("ADR:" + this.address + '\n');
            }
            if (this.note != null) {
                sb.append("NOTE:" + this.note + '\n');
            }
            sb.append("END:VCARD");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$MeCard;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "", "address", "phoneNumber", Scopes.EMAIL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getEmail", "getName", "getPhoneNumber", "component1", "component2", "component3", "component4", "copy", "encode", "equals", "", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class MeCard implements QrData {
        private final String address;
        private final String email;
        private final String name;
        private final String phoneNumber;

        public MeCard() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ MeCard copy$default(MeCard meCard, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = meCard.name;
            }
            if ((i & 2) != 0) {
                str2 = meCard.address;
            }
            if ((i & 4) != 0) {
                str3 = meCard.phoneNumber;
            }
            if ((i & 8) != 0) {
                str4 = meCard.email;
            }
            return meCard.copy(str, str2, str3, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAddress() {
            return this.address;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        /* renamed from: component4, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        public final MeCard copy(String name, String address, String phoneNumber, String email) {
            return new MeCard(name, address, phoneNumber, email);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MeCard)) {
                return false;
            }
            MeCard meCard = (MeCard) other;
            return Intrinsics.areEqual(this.name, meCard.name) && Intrinsics.areEqual(this.address, meCard.address) && Intrinsics.areEqual(this.phoneNumber, meCard.phoneNumber) && Intrinsics.areEqual(this.email, meCard.email);
        }

        public int hashCode() {
            String str = this.name;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.address;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.phoneNumber;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.email;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "MeCard(name=" + this.name + ", address=" + this.address + ", phoneNumber=" + this.phoneNumber + ", email=" + this.email + ')';
        }

        public MeCard(String str, String str2, String str3, String str4) {
            this.name = str;
            this.address = str2;
            this.phoneNumber = str3;
            this.email = str4;
        }

        public /* synthetic */ MeCard(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }

        public final String getName() {
            return this.name;
        }

        public final String getAddress() {
            return this.address;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final String getEmail() {
            return this.email;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            StringBuilder sb = new StringBuilder("MECARD:");
            if (this.name != null) {
                sb.append("N:" + this.name + ';');
            }
            if (this.address != null) {
                sb.append("ADR:" + this.address + ';');
            }
            if (this.phoneNumber != null) {
                sb.append("TEL:" + this.phoneNumber + ';');
            }
            if (this.email != null) {
                sb.append("EMAIL:" + this.email + ';');
            }
            sb.append(";");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$YouTube;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "videoId", "", "(Ljava/lang/String;)V", "getVideoId", "()Ljava/lang/String;", "component1", "copy", "encode", "equals", "", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class YouTube implements QrData {
        private final String videoId;

        public static /* synthetic */ YouTube copy$default(YouTube youTube, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = youTube.videoId;
            }
            return youTube.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getVideoId() {
            return this.videoId;
        }

        public final YouTube copy(String videoId) {
            Intrinsics.checkNotNullParameter(videoId, "videoId");
            return new YouTube(videoId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof YouTube) && Intrinsics.areEqual(this.videoId, ((YouTube) other).videoId);
        }

        public int hashCode() {
            return this.videoId.hashCode();
        }

        public String toString() {
            return "YouTube(videoId=" + this.videoId + ')';
        }

        public YouTube(String str) {
            Intrinsics.checkNotNullParameter(str, "videoId");
            this.videoId = str;
        }

        public final String getVideoId() {
            return this.videoId;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            return "YOUTUBE:" + this.videoId;
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006 "}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$Event;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "uid", "", "stamp", "organizer", "start", "end", "summary", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnd", "()Ljava/lang/String;", "getOrganizer", "getStamp", "getStart", "getSummary", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "encode", "equals", "", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Event implements QrData {
        private final String end;
        private final String organizer;
        private final String stamp;
        private final String start;
        private final String summary;
        private final String uid;

        public Event() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ Event copy$default(Event event, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = event.uid;
            }
            if ((i & 2) != 0) {
                str2 = event.stamp;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = event.organizer;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = event.start;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = event.end;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = event.summary;
            }
            return event.copy(str, str7, str8, str9, str10, str6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUid() {
            return this.uid;
        }

        /* renamed from: component2, reason: from getter */
        public final String getStamp() {
            return this.stamp;
        }

        /* renamed from: component3, reason: from getter */
        public final String getOrganizer() {
            return this.organizer;
        }

        /* renamed from: component4, reason: from getter */
        public final String getStart() {
            return this.start;
        }

        /* renamed from: component5, reason: from getter */
        public final String getEnd() {
            return this.end;
        }

        /* renamed from: component6, reason: from getter */
        public final String getSummary() {
            return this.summary;
        }

        public final Event copy(String uid, String stamp, String organizer, String start, String end, String summary) {
            return new Event(uid, stamp, organizer, start, end, summary);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            return Intrinsics.areEqual(this.uid, event.uid) && Intrinsics.areEqual(this.stamp, event.stamp) && Intrinsics.areEqual(this.organizer, event.organizer) && Intrinsics.areEqual(this.start, event.start) && Intrinsics.areEqual(this.end, event.end) && Intrinsics.areEqual(this.summary, event.summary);
        }

        public int hashCode() {
            String str = this.uid;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.stamp;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.organizer;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.start;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.end;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.summary;
            return hashCode5 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            return "Event(uid=" + this.uid + ", stamp=" + this.stamp + ", organizer=" + this.organizer + ", start=" + this.start + ", end=" + this.end + ", summary=" + this.summary + ')';
        }

        public Event(String str, String str2, String str3, String str4, String str5, String str6) {
            this.uid = str;
            this.stamp = str2;
            this.organizer = str3;
            this.start = str4;
            this.end = str5;
            this.summary = str6;
        }

        public /* synthetic */ Event(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
        }

        public final String getUid() {
            return this.uid;
        }

        public final String getStamp() {
            return this.stamp;
        }

        public final String getOrganizer() {
            return this.organizer;
        }

        public final String getStart() {
            return this.start;
        }

        public final String getEnd() {
            return this.end;
        }

        public final String getSummary() {
            return this.summary;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            StringBuilder sb = new StringBuilder("BEGIN:VEVENT\n");
            if (this.uid != null) {
                sb.append("UID:" + this.uid + '\n');
            }
            if (this.stamp != null) {
                sb.append("DTSTAMP:" + this.stamp + '\n');
            }
            if (this.organizer != null) {
                sb.append("ORGANIZER:" + this.organizer + '\n');
            }
            if (this.start != null) {
                sb.append("DTSTART:" + this.start + '\n');
            }
            if (this.end != null) {
                sb.append("DTEND:" + this.end + '\n');
            }
            if (this.summary != null) {
                sb.append("SUMMARY:" + this.summary + '\n');
            }
            sb.append("END:VEVENT");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    /* compiled from: QrData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrData$GooglePlay;", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", C0879b.f561e, "", "(Ljava/lang/String;)V", "getAppPackage", "()Ljava/lang/String;", "component1", "copy", "encode", "equals", "", "other", "", "hashCode", "", "toString", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class GooglePlay implements QrData {
        private final String appPackage;

        public static /* synthetic */ GooglePlay copy$default(GooglePlay googlePlay, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = googlePlay.appPackage;
            }
            return googlePlay.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAppPackage() {
            return this.appPackage;
        }

        public final GooglePlay copy(String appPackage) {
            Intrinsics.checkNotNullParameter(appPackage, C0879b.f561e);
            return new GooglePlay(appPackage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GooglePlay) && Intrinsics.areEqual(this.appPackage, ((GooglePlay) other).appPackage);
        }

        public int hashCode() {
            return this.appPackage.hashCode();
        }

        public String toString() {
            return "GooglePlay(appPackage=" + this.appPackage + ')';
        }

        public GooglePlay(String str) {
            Intrinsics.checkNotNullParameter(str, C0879b.f561e);
            this.appPackage = str;
        }

        public final String getAppPackage() {
            return this.appPackage;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.QrData
        public String encode() {
            return "{{{market://details?id=%" + this.appPackage + "}}}";
        }
    }
}
