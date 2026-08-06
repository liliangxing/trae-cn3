package com.bytedance.ies.argus.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: UrlListVerifyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/util/UrlListVerifyHelper;", "", "()V", "innerWhiteParentDomainMap", "", "", "", "innerWholeDomainMap", "InnerDomainVerifier", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class UrlListVerifyHelper {
    public static final UrlListVerifyHelper INSTANCE = new UrlListVerifyHelper();
    private static final Map<String, Integer> innerWhiteParentDomainMap;
    private static final Map<String, Integer> innerWholeDomainMap;

    private UrlListVerifyHelper() {
    }

    /* compiled from: UrlListVerifyHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\u00002\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0016\u0010\r\u001a\u00020\u00002\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0016\u0010\u000e\u001a\u00020\u00002\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0016\u0010\u000f\u001a\u00020\u00002\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/argus/util/UrlListVerifyHelper$InnerDomainVerifier;", "", "()V", "excludeWhiteUrlReg", "", "", "extraWhiteParentDomainMap", "", "", "extraWhiteUrlReg", "extraWhiteWholeDomainMap", "addExcludeWhiteUrlReg", "list", "addWhiteParentDomain", "addWhiteUrlReg", "addWhiteWholeDomain", "verify", "", "url", "urlHost", "parentHost", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class InnerDomainVerifier {
        private List<String> excludeWhiteUrlReg;
        private Map<String, Integer> extraWhiteParentDomainMap;
        private List<String> extraWhiteUrlReg;
        private Map<String, Integer> extraWhiteWholeDomainMap;

        public final InnerDomainVerifier addWhiteWholeDomain(List<String> list) {
            if (list != null) {
                List<String> list2 = list;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                for (Object obj : list2) {
                    linkedHashMap.put(obj, 1);
                }
                this.extraWhiteWholeDomainMap = linkedHashMap;
            }
            return this;
        }

        public final InnerDomainVerifier addWhiteParentDomain(List<String> list) {
            if (list != null) {
                List<String> list2 = list;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                for (Object obj : list2) {
                    linkedHashMap.put(obj, 1);
                }
                this.extraWhiteParentDomainMap = linkedHashMap;
            }
            return this;
        }

        public final InnerDomainVerifier addWhiteUrlReg(List<String> list) {
            if (list != null) {
                this.extraWhiteUrlReg = list;
            }
            return this;
        }

        public final InnerDomainVerifier addExcludeWhiteUrlReg(List<String> list) {
            if (list != null) {
                this.excludeWhiteUrlReg = list;
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0057 A[Catch: all -> 0x00a2, TryCatch #0 {all -> 0x00a2, blocks: (B:3:0x0007, B:5:0x000d, B:6:0x0020, B:8:0x0026, B:10:0x0035, B:15:0x003b, B:16:0x003d, B:20:0x0046, B:24:0x0057, B:26:0x005d, B:31:0x0068, B:34:0x0073, B:37:0x007b, B:39:0x007f, B:43:0x008a, B:47:0x0095, B:49:0x009b, B:50:0x00a0, B:52:0x004e, B:53:0x0053), top: B:2:0x0007 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean verify(String url, String urlHost, String parentHost) {
            Map<String, Integer> map;
            boolean z;
            Intrinsics.checkNotNullParameter(url, "url");
            try {
                Result.Companion companion = Result.INSTANCE;
                List<String> list = this.excludeWhiteUrlReg;
                if (list != null) {
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        if (CommonUtils.INSTANCE.matchReg(url, (String) it.next())) {
                            return false;
                        }
                        arrayList.add(Unit.INSTANCE);
                    }
                    ArrayList arrayList2 = arrayList;
                }
                map = this.extraWhiteWholeDomainMap;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m10253constructorimpl(ResultKt.createFailure(th));
            }
            if (map != null) {
                if (map == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                }
                if (map.containsKey(urlHost)) {
                    z = true;
                    if (!z) {
                        Map map2 = UrlListVerifyHelper.innerWholeDomainMap;
                        if (map2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                        }
                        if (!map2.containsKey(urlHost)) {
                            if (parentHost == null) {
                                parentHost = urlHost != null ? CommonUtils.INSTANCE.getParentHostBaseHost(urlHost) : null;
                                if (parentHost == null) {
                                    parentHost = CommonUtils.INSTANCE.getParentHostBaseUrl(url);
                                }
                            }
                            if (parentHost != null) {
                                Map<String, Integer> map3 = this.extraWhiteParentDomainMap;
                                if ((map3 != null && map3.containsKey(parentHost)) || UrlListVerifyHelper.innerWhiteParentDomainMap.containsKey(parentHost)) {
                                    return true;
                                }
                            }
                            Result.m10253constructorimpl(Unit.INSTANCE);
                            return false;
                        }
                    }
                    return true;
                }
            }
            z = false;
            if (!z) {
            }
            return true;
        }
    }

    static {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"lf-dy-sourcecdn-tos.bytegecko.com", "lf-ecom-gr-sourcecdn.bytegecko.com", "lf-webcast-gr-sourcecdn.bytegecko.com", "lf-dy-gr-sourcecdn.bytegecko.com", "lf1-cdn-tos.bytegoofy.com", "m.baike.com", "sf1-scmcdn-tos.pstatp.com", "api.amemv.com", "aweme.snssdk.com", "lf3-cdn-tos.bytegoofy.com", "leads.oceanengine.com", "ugh5.cn", "lf1-cdn-tos.bytescm.com", "creator.amemv.com", "alliance.jinritemai.com", "fe.amemv.com", "f-cashloan.snssdk.com", "douplus-fe.amemv.com", "interactive.douyin.com", "api.fanqiesdk.com", "zjsms.com"});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listOf, 10)), 16));
        for (Object obj : listOf) {
            linkedHashMap.put(obj, 1);
        }
        innerWholeDomainMap = linkedHashMap;
        List listOf2 = CollectionsKt.listOf((Object[]) new String[]{"douyin.com", "bytegoofy.com", "baike.com", "amemv.com", "snssdk.com", "bytescm.com", "jinritemai.com", "bytedance.com", "toutiaoapi.com", "ecombdpage.com", "baohuaxia.com", "bytesfield.com", "dcdapp.com", "xingtu.cn", "juliangyinqing.com", "douyinhanyu.com", "toutiao.com", "open-douyin.com", "cluerich.com", "zhuxiaobang.com", "bytednsdoc.com", "xiaohe-jiankang.com", "ulikecam.com", "zijieapi.com", "searchpstatp.com", "scsjsd.com", "dcarstatic.com", "changdunovel.com", "iaoligame.com", "jishitailai.com", "yangyi07.com", "magich5page.com", "xflapp.com", "pipix.com", "draftstatic.com", "xiaohe.cn", "shidianguji.com", "ulpay.com", "retouchpics.com", "bytedance.net", "byteug.com", "dcarapi.com", "zlinkurl.cn", "byteky.com", "bytetos.com", "douyinpay.com", "douyinec.com", "huoshan.com", "ixigua.com", "oceancus.com", "moonton.com", "csjdeveloper.com", "fanqienovel.com", "nextvid.net", "iyincaishijiao.com", "editorjianying.com", "shidianhanyu.com", "lifexue.com", "doupay.com", "volcengine.com", "bestv.com.cn", "douyinpay.com", "iesdouyin.com", "xsgtvacct.com"});
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listOf2, 10)), 16));
        for (Object obj2 : listOf2) {
            linkedHashMap2.put(obj2, 1);
        }
        innerWhiteParentDomainMap = linkedHashMap2;
    }
}
