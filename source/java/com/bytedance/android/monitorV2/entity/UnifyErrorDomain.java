package com.bytedance.android.monitorV2.entity;

import kotlin.Metadata;

/* compiled from: UnifyError.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/monitorV2/entity/UnifyErrorDomain;", "", "errorDomain", "", "desc", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getErrorDomain", "()I", "AnnieXUnifyErrorDomainReserved", "AnnieXUnifyErrorDomainContainerInit", "AnnieXUnifyErrorDomainContainerPlugin", "AnnieXUnifyErrorDomainContainerJSB", "AnnieXUnifyErrorDomainEngineWeb", "AnnieXUnifyErrorDomainEngineLynx", "AnnieXUnifyErrorDomainResourceLoader", "AnnieXUnifyErrorDomainFetch", "AnnieXUnifyErrorDomainStaticResource", "AnnieXUnifyErrorDomainJS", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum UnifyErrorDomain {
    AnnieXUnifyErrorDomainReserved(99999999, "保留"),
    AnnieXUnifyErrorDomainContainerInit(33000000, "容器层初始化阶段"),
    AnnieXUnifyErrorDomainContainerPlugin(35000000, "容器层其他模块预留,如 prefetch、preload 和 prerender 等"),
    AnnieXUnifyErrorDomainContainerJSB(37000000, "容器层 JSB 模块"),
    AnnieXUnifyErrorDomainEngineWeb(47000000, "Web 引擎层错误"),
    AnnieXUnifyErrorDomainEngineLynx(50000000, "Lynx 引擎层错误"),
    AnnieXUnifyErrorDomainResourceLoader(63000000, "资源加载 / Forest"),
    AnnieXUnifyErrorDomainFetch(65000000, "fetch, x.request"),
    AnnieXUnifyErrorDomainStaticResource(67000000, "静态资源"),
    AnnieXUnifyErrorDomainJS(70000000, "JS 层");

    private final int errorDomain;

    UnifyErrorDomain(int i, String str) {
        this.errorDomain = i;
    }

    public final int getErrorDomain() {
        return this.errorDomain;
    }
}
