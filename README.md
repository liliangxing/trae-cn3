# TRAE CN3 逆向工程与对话提取功能仓库

> 本仓库包含 TRAE CN3 Android App（`com.bytedance.trae.cn3`）的逆向修改代码、全量反编译 Java 源码、构建脚本和文档。
> 任何 AI Agent 或开发者都可以基于本仓库的代码进行修改和重新打包。

---

## 核心原则：Java 是唯一源码

> **自定义代码只存 Java，不存 Smali。**
> Smali 文件由 Java 编译生成（javac → d8 → baksmali），是构建过程中的中间产物。
> 你只需要修改 `source/java/` 下的 Java 文件，构建脚本会自动编译成 Smali 并打包。

---

## 仓库结构

```
trae-cn3/
├── README.md                  ← 你正在看的这个文件
├── AGENTS_GUIDE.md            ← AI Agent 专属操作指引（必读！）
├── 搭建指南/                  ← 完整搭建文档（从原始 APK 到修改到打包）
│   └── trae_cn3-APK逆向修改与Smali转Java完整指南.md
├── BUILD_SCRIPT/              ← 构建相关规范
│   ├── APK_BUILD_SPEC.md      ← APK 打包签名规范（签名密码、工具命令）
│   ├── BUILD.md               ← 功能改动说明（改了哪些文件、为什么改）
│   └── PACKAGE_POLICY.md      ← 打包策略（避免 package info is null 闪退）
├── source/
│   ├── java/                  ← Java 源码（唯一源码！）
│   │   ├── com/bytedance/trae/conversation/extract/
│   │   │   ├── ExtractHelper.java        ← 手写版：对话提取核心逻辑
│   │   │   ├── ApiMessageFetcher.java    ← 手写版：API 拉取消息（含 SSL）
│   │   │   ├── FileLogger.java           ← 手写版：文件日志工具
│   │   │   └── GitHubPusher.java         ← 手写版：GitHub 推送
│   │   └── ...（37,983 个 jadx 反编译的 Java 文件，仅供阅读）
│   ├── smali/                 ← 原版 APK 的 Smali（不含自定义类！）
│   │   └── ...（6,732 个文件，原版反编译结果，打包时需要）
│   │       注意：extract 目录下只有 conversation_popup_menu_modified.xml
│   │       自定义类的 Smali 不在这里，由 Java 编译生成
│   └── res/                   ← 修改过的资源文件
│       ├── layout/conversation_popup_menu.xml
│       └── values/
│           ├── public.xml
│           └── strings.xml
├── releases/v4/               ← 发布产物
│   ├── manifest_patched.xml
│   ├── resources.arsc
│   └── README.md
└── docs/                      ← 项目文档
    ├── BUILD_GUIDE.md
    ├── TRAE-Android-API-Documentation.md
    └── Redmi K90 APK Packet Capture.md
```

---

## 自定义类清单（核心改动）

所有自定义类位于 `com.bytedance.trae.conversation.extract` 包下，**只有 Java 源码，没有 Smali**：

| 类名 | Java 文件 | 作用 |
|------|----------|------|
| `ExtractHelper` | `source/java/.../ExtractHelper.java` | 对话提取入口，数据库查询 + API 回退 + Markdown 生成 |
| `ApiMessageFetcher` | `source/java/.../ApiMessageFetcher.java` | 从服务器 API 拉取消息（含 SSL TrustManager 内部类） |
| `FileLogger` | `source/java/.../FileLogger.java` | 文件日志（写到 /sdcard/douyinguanjia/Log/trae-cn3.log） |
| `GitHubPusher` | `source/java/.../GitHubPusher.java` | 异步推送到 GitHub 仓库（带重试） |

> **重要：** `source/java/` 下的 4 个自定义 Java 文件是**手写版本**，比 jadx 反编译的版本可读性更好。
> 其余 37,983 个 Java 文件是 jadx 全量反编译的结果，仅供阅读理解原版 App 逻辑。

---

## 如何重新打包 APK

核心流程（Java → Smali → APK）：

1. 修改 `source/java/` 下的 Java 文件
2. 编译 Java → .class → .dex → .smali（需要 stub 类解决依赖，详见 `AGENTS_GUIDE.md`）
3. 把生成的 Smali 复制到 apktool 解包目录的 `smali_classes9/`
4. 删除 `build/` 缓存
5. `apktool b <解包目录> -o output.apk`
6. 用 uber-apk-signer 签名（密码 `trae123`，必须 v2+v3）

详细步骤见 `AGENTS_GUIDE.md` 和 `BUILD_SCRIPT/APK_BUILD_SPEC.md`。

---

## 相关文档

- **完整搭建指南**：`搭建指南/trae_cn3-APK逆向修改与Smali转Java完整指南.md`
- **构建说明**：`BUILD_SCRIPT/BUILD.md`
- **API 文档**：`docs/TRAE-Android-API-Documentation.md`
- **Agent 指引**：`AGENTS_GUIDE.md`（如果你是 AI Agent，请先读这个）

---

## 已知问题

1. **GitHubPusher 中的 Token 已失效**：BuildConfig 中硬编码的 GitHub Token 被 GitHub 自动吊销，推送功能需要更新 Token
2. **ApiMessageFetcher 的 SSL 信任管理**：为了连接内部域名 `trae-api-cn.mchost.guru`，实现了信任所有证书的 TrustManager，这在生产环境中是不安全的
3. **API 参数 before_limit=10**：之前用过 200 和 50 都被 API 拒绝（400 错误），10 是 App 默认值
