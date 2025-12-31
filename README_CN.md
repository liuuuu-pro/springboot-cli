# SpringBoot-CLI

[English](README.md)

> 一款企业级 **Spring Boot + Spring Cloud + Spring AI 微服务脚手架**，助力开发者快速构建 AI 原生、生产就绪的微服务系统，集成现代中间件和行业最佳实践。

---

## 🚀 项目简介

**SpringBoot-CLI** 是一个面向企业应用的前沿微服务起步模板，将 **AI 作为一等公民**。

基于最新一代 Java 和 Spring 生态（**JDK 25 + Spring Boot 4.0 + Spring Cloud 2025**），提供简洁、可扩展、面向生产的架构，涵盖服务发现、配置管理、认证、缓存、限流和可观测性等基础能力。

**本项目完全开源，仅用于学习、研究和技术交流。**

**项目仓库**: https://github.com/liuuuu-pro/springboot-cli

---

## ✨ 核心特性

- ✅ **最新技术栈**：JDK 25 + Spring Boot 4.0.0 + Spring Cloud 2025.1.0
- ✅ **AI 原生**：基于 Spring AI 2.0.0 提供智能化能力
- ✅ **Spring Cloud Alibaba**：2025.1.0.x（官方适配中）
- ✅ **微服务架构**：模块化服务，职责清晰分离
- ✅ **中间件集成**：MySQL 8.x、Redis 7.x、Nacos、Sentinel
- ✅ **API 网关**：集中式路由与服务隔离
- ✅ **容器支持**：Docker Compose 本地开发环境
- ✅ **企业最佳实践**：生产级设计模式与结构

---

## 🧱 技术栈

| 分类 | 技术 | 版本 |
|------|------|------|
| **JDK** | OpenJDK（推荐） | 25+ |
| **核心框架** | Spring Boot | 4.0.0 |
| **微服务框架** | Spring Cloud | 2025.1.0 |
| **微服务框架** | Spring Cloud Alibaba | 2025.1.0.x（适配中） |
| **AI** | Spring AI | 2.0.0 |
| **数据库** | MySQL | 8.0+ |
| **缓存** | Redis | 7.0+ |
| **注册中心** | Nacos | 3.1.1+ |
| **限流保护** | Sentinel | - |
| **构建工具** | Maven | 3.9+ |

---

## 📁 项目结构

```
springboot-cli
├── common/                     # 公共模块
│   ├── common-core             # 通用工具类、DTO、异常体系
│   └── common-redis            # Redis 封装
├── gateway/                    # API 网关（端口：9080）
├── service-ai/                 # AI 服务（端口：9000）
├── service-ai-mcp/             # MCP 服务（端口：9003）
├── service-order/              # 订单服务（端口：9001）
├── service-user/               # 用户服务（端口：9002）
├── docker/                     # Docker Compose 配置
└── docs/                       # 技术文档、设计说明
```

---

## 🛠️ 快速开始

### 环境要求

| 组件 | 版本 | 说明 |
|------|------|------|
| **JDK** | 25+ | 推荐使用 OpenJDK |
| **Maven** | 3.9+ | 项目构建工具 |
| **MySQL** | 8.0+ | 数据库（本地开发可选） |
| **Redis** | 7.0+ | 缓存（本地开发可选） |
| **Docker** | - | 通过 Docker Compose 运行中间件 |

---

### 部署 Nacos（Windows 示例）

1. **下载**: [nacos-server-3.1.1.tar.gz](https://github.com/alibaba/nacos/releases)
2. **解压**并进入 `nacos/bin` 目录
3. **启动**单机模式:
   ```bash
   startup.cmd -m standalone
   ```
4. **生成** Token 密钥（通过 PowerShell）:
   ```powershell
   [Convert]::ToBase64String((1..32 | ForEach-Object {Get-Random -Maximum 256}))
   ```
   将生成的值配置为 `nacos.core.auth.plugin.nacos.token.secret.key`
5. **访问** Nacos 控制台: http://localhost:8080

### 使用 Docker Compose 运行

```bash
cd docker
docker-compose up -d
```

这将启动 MySQL、Redis 和其他所需中间件。

---

## 🤝 贡献指南

欢迎并非常感谢任何形式的贡献！

### 贡献流程

1. **Fork** 本仓库
2. **创建**功能分支: `git checkout -b feature/your-feature-name`
3. **提交**代码并使用语义化提交信息:
   - `feat`: 新功能
   - `fix`: 修复问题
   - `docs`: 文档更新
   - `refactor`: 代码重构
   - `test`: 添加或更新测试
4. **提交** Pull Request 并提供清晰描述

**提交信息示例:**
```
feat: 新增用户认证模块
fix: 修复 Redis 连接超时问题
docs: 更新部署指南
```

本项目**正在积极维护**，欢迎长期社区贡献。

---

## 📄 开源协议

本项目基于 **Apache License 2.0** 开源。  
详情请阅读 [LICENSE](./LICENSE) 文件。

---

## 💡 JetBrains 开源支持

本项目符合 [JetBrains 开源许可支持](https://www.jetbrains.com/community/opensource/#support) 要求：

- ✅ 完全开源，代码可自由访问
- ✅ 采用 Apache License 2.0 协议
- ✅ 非商业用途，面向教育和社区驱动
- ✅ 积极维护并欢迎贡献

**特别感谢 [JetBrains](https://www.jetbrains.com/?from=springboot-cli) 为开源社区提供优秀的开发工具支持！** ❤️

---

## 📬 联系与社区

| 渠道 | 信息 |
|------|------|
| **项目主页** | https://github.com/liuuuu-pro/springboot-cli |
| **作者邮箱** | liujiazhong0618@gmail.com |
| **Issue 反馈** | [GitHub Issues](https://github.com/liuuuu-pro/springboot-cli/issues)（推荐） |

---

**提示**: 请通过 GitHub Issues 报告问题、提出功能建议或提问，以便更好地进行社区协作。
