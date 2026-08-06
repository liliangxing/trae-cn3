package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import com.bytedance.tobshadow.applog.event.AutoTrackEventType;
import com.bytedance.tobshadow.applog.exception.AppCrashType;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.mpaas.IEncryptor;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0474n implements EventBus.DataFetcher {

    /* renamed from: a */
    public final /* synthetic */ InitConfig f821a;

    /* renamed from: b */
    public final /* synthetic */ C0467m f822b;

    public C0474n(C0467m c0467m, InitConfig initConfig) {
        this.f822b = c0467m;
        this.f821a = initConfig;
    }

    @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
    public Object fetch() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.f822b.f784m);
            jSONObject.put(Constant.KEY_CHANNEL, this.f821a.getChannel());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("AppLog 版本号", "6.17.11-tobshadow");
            jSONObject2.put("AppLog 版本地区", "国内");
            jSONObject2.put("AppLog版本序号", 6171190);
            jSONObject2.put("请求加密开关", this.f822b.f765E);
            jSONObject2.put("响应加密开关", this.f821a.isResponseEncryptEnabled());
            if (this.f822b.f765E) {
                IEncryptor encryptor = this.f821a.getEncryptor();
                jSONObject2.put("是否配置了自定义加密", encryptor == null ? "未配置" : "客户端已配置");
                String str2 = "默认加密类型";
                if ((encryptor instanceof C0440i0) && !IEncryptorType.DEFAULT_ENCRYPTOR.equals(((C0440i0) encryptor).encryptorType())) {
                    str2 = ((C0440i0) encryptor).encryptorType();
                }
                jSONObject2.put("自定义加密类型", str2);
            }
            jSONObject2.put("日志开关", this.f821a.isLogEnable());
            jSONObject2.put("自定义日志打印", this.f821a.getLogger() != null);
            jSONObject2.put("AB实验开关", this.f821a.isAbEnable());
            jSONObject2.put("自动启动图开关", this.f821a.autoStart());
            jSONObject2.put("自动激活开关", this.f821a.isAutoActive());
            jSONObject2.put("H5 打通开关", this.f821a.isH5BridgeEnable());
            jSONObject2.put("H5 全埋点注入", this.f821a.isH5CollectEnable());
            jSONObject2.put("H5 打通是否允许更新用户信息开关", this.f821a.isUseBridgeUpdateUUIDEnabled());
            if (this.f821a.getH5BridgeAllowlist() != null && !this.f821a.getH5BridgeAllowlist().isEmpty()) {
                jSONObject2.put("H5 域名白名单", TextUtils.join("、", this.f821a.getH5BridgeAllowlist()));
            }
            jSONObject2.put("不过滤 H5 域名开关", this.f821a.isH5BridgeAllowAll());
            jSONObject2.put("全埋点开关", this.f821a.isAutoTrackEnabled());
            ArrayList arrayList = new ArrayList();
            if (AutoTrackEventType.m227a(this.f821a.getAutoTrackEventType(), 4)) {
                arrayList.add("点击事件");
            }
            if (AutoTrackEventType.m227a(this.f821a.getAutoTrackEventType(), 2)) {
                arrayList.add("页面事件");
            }
            if (AutoTrackEventType.m227a(this.f821a.getAutoTrackEventType(), 8)) {
                arrayList.add("页面离开事件");
            }
            if (!arrayList.isEmpty()) {
                jSONObject.put("全埋点类型", TextUtils.join("、", arrayList));
            }
            jSONObject2.put("视图曝光开关", this.f821a.isExposureEnabled());
            jSONObject2.put("采集屏幕方向开关", this.f821a.isScreenOrientationEnabled());
            jSONObject2.put("初始化 UUID", this.f821a.getUserUniqueId());
            jSONObject2.put("初始化 UUID 类型", this.f821a.getUserUniqueIdType());
            jSONObject2.put("采集 OAID 开关", this.f821a.isOaidEnabled());
            jSONObject2.put("补偿 OAID 开关", this.f821a.isReportOaidEnable());
            jSONObject2.put("采集 MAC 开关", this.f821a.isMacEnable());
            jSONObject2.put("采集 ANDROID ID 开关", this.f821a.isAndroidIdEnabled());
            jSONObject2.put("采集运营商信息开关", this.f821a.isOperatorInfoEnabled());
            jSONObject2.put("采集 SerialNumber 开关", this.f821a.isSerialNumberEnable());
            jSONObject2.put("自动采集 FRAGMENT 开关", this.f821a.isAutoTrackFragmentEnabled());
            jSONObject2.put("后台静默开关", this.f821a.isSilenceInBackground());
            jSONObject2.put("鸿蒙设备采集开关", this.f821a.isHarmonyEnabled());
            jSONObject2.put("隐私模式开关", this.f822b.f795x);
            jSONObject2.put("采集 Crash", AppCrashType.hasCrashType(this.f821a.getTrackCrashType(), 1) ? "JAVA" : "不采集");
            jSONObject2.put("ALINK 监听", this.f822b.f797z != null);
            jSONObject2.put("自定义激活参数", this.f822b.f761A != null);
            jSONObject2.put("延迟深度链接开关", this.f821a.isDeferredALinkEnabled());
            jSONObject2.put("缓存文件名称", this.f821a.getSpName());
            jSONObject2.put("数据库文件名称", this.f821a.getDbName());
            jSONObject2.put("监听生命周期", this.f821a.isHandleLifeCycle());
            jSONObject2.put("小版本号", this.f821a.getVersionMinor());
            jSONObject2.put("版本号编码", String.valueOf(this.f821a.getVersionCode()));
            jSONObject2.put("版本号", this.f821a.getVersion());
            jSONObject2.put("应用名称", this.f821a.getAppName());
            jSONObject2.put("圈选配置", this.f821a.getPicker() != null);
            jSONObject2.put("当前进程", this.f822b.f786o.m323j() ? "主进程" : "子进程");
            jSONObject2.put("地区", this.f821a.getRegion());
            jSONObject2.put("语言", this.f821a.getLanguage());
            jSONObject2.put("PLAY 开关", this.f821a.isPlayEnable());
            jSONObject2.put("Gaid 开关", this.f821a.isGaidEnabled());
            jSONObject2.put("屏幕信息开关", this.f821a.isDisplayDensityAndDpiEnabled());
            jSONObject2.put("CPU Abi 开关", this.f821a.isCPUAbiEnabled());
            jSONObject2.put("曝光事件是否重复产生开关", this.f821a.isAbTestExposureEventRepeatEnabled());
            jSONObject2.put("LaunchTerminate 开关", this.f821a.isLaunchTerminateEnabled());
            if (this.f821a.isGaidEnabled()) {
                jSONObject2.put("GAID 获取超时时间", this.f821a.getGaidTimeOutMilliSeconds());
            }
            jSONObject2.put("PageMeta 接口注解开关", this.f821a.isPageMetaAnnotationEnable());
            if (this.f821a.getUriConfig() != null) {
                ArrayList arrayList2 = new ArrayList();
                if (this.f821a.getUriConfig().getSendUris() != null) {
                    arrayList2.addAll(Arrays.asList(this.f821a.getUriConfig().getSendUris()));
                }
                if (C0411e.m379d(this.f821a.getUriConfig().getRegisterUri())) {
                    arrayList2.add(this.f821a.getUriConfig().getRegisterUri());
                }
                if (C0411e.m379d(this.f821a.getUriConfig().getSettingUri())) {
                    arrayList2.add(this.f821a.getUriConfig().getSettingUri());
                }
                if (C0411e.m379d(this.f821a.getUriConfig().getAbUri())) {
                    arrayList2.add(this.f821a.getUriConfig().getAbUri());
                }
                if (C0411e.m379d(this.f821a.getUriConfig().getActiveUri())) {
                    arrayList2.add(this.f821a.getUriConfig().getActiveUri());
                }
                if (C0411e.m379d(this.f821a.getUriConfig().getSettingUri())) {
                    arrayList2.add(this.f821a.getUriConfig().getSettingUri());
                }
                if (C0411e.m379d(this.f821a.getUriConfig().getBusinessUri())) {
                    arrayList2.add(this.f821a.getUriConfig().getBusinessUri());
                }
                if (C0411e.m379d(this.f821a.getUriConfig().getProfileUri())) {
                    arrayList2.add(this.f821a.getUriConfig().getProfileUri());
                }
                if (C0411e.m379d(this.f821a.getUriConfig().getReportOaidUri())) {
                    arrayList2.add(this.f821a.getUriConfig().getReportOaidUri());
                }
                if (C0411e.m379d(this.f821a.getUriConfig().getAlinkAttributionUri())) {
                    arrayList2.add(this.f821a.getUriConfig().getAlinkAttributionUri());
                }
                if (C0411e.m379d(this.f821a.getUriConfig().getAlinkQueryUri())) {
                    arrayList2.add(this.f821a.getUriConfig().getAlinkQueryUri());
                }
                str = TextUtils.join("、", arrayList2);
            } else {
                str = "SaaS 默认";
            }
            jSONObject2.put("服务域名配置", str);
            jSONObject.put("config", jSONObject2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
