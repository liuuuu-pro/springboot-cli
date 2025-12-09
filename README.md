# 🌱 SpringBoot-CLI

> 一款企业级 **Spring Boot + Spring Cloud 微服务脚手架**，集成最新主流中间件和最佳实践。


## 🚀 项目简介

该项目致力于提供一个 **最新的、可快速上手的企业级微服务开发模板**。集成了最新的 **SpringBoot4 + SpringCloud2025** 技术体系，内置注册中心、配置中心、认证、日志、限流等基础设施，帮助开发者快速构建微服务体系。

## 🎯 核心特性

- ✅ 基于 **Spring Boot 4.0.x** 与 **Spring Cloud 2025.x**
- ⚙️ 支持 **Nacos 注册中心 & 配置中心**
- 💾 集成 **MySQL + Redis**
- 🧩 内置 **统一异常、日志、响应规范**
- 🔐 集成 **JWT 认证**
- 🐳 **Docker Compose** 一键启动所有服务

## 🏗️ 技术栈

| 分类      | 技术                                    |
|---------|---------------------------------------|
| 核心框架    | Spring Boot 4.0.x、Spring Cloud 2025.x |
| Alibaba | Spring Cloud Alibaba 2025.0.0.x       |
| 数据存储    | MySQL 8.x                             |
| 缓存中间件   | Redis 7.x                             |
| 接口文档    | Swagger3 (Knife4j)                    |
| 服务调用    | OpenFeign                             |
| 限流保护    | Sentinel                              |
| 构建工具    | Maven 3.9+                            |
| 容器部署    | Docker Compose                        |

## ⚙️ 项目结构

```
springboot-cli
 ├── common/                    # 公共模块
 │   ├── common-core            # 通用工具类、DTO、异常体系
 │   ├── common-redis           # Redis 封装
 ├── gateway/                   # 服务网关
 ├── order-service/             # 订单服务
 ├── user-service/              # 用户中心服务
 ├── docker/                    # Docker Compose 配置
 └── docs/                      # 技术文档、设计说明
```

## 🔧 快速开始

### 1️⃣ 环境准备

| 组件 | 版本   | 说明 |
|------|------|------|
| JDK | 25+  | 推荐使用 OpenJDK |
| Maven | 3.9+ | 项目构建工具 |
| MySQL | 8.0+ | 数据库 |
| Redis | 7.0+ | 缓存 |
| Docker | 24+  | 一键容器启动环境 |

## 🤝 贡献指南

欢迎任何形式的贡献 🙌  
请遵循以下流程：

1. Fork 本仓库
2. 新建分支：`feature/xxx`
3. 提交代码并遵守规范 (`feat`, `fix`, `docs`, `refactor`, `test` 等语义化提交)
4. 提交 Pull Request

贡献规范参考：
```
feat: 新增用户模块接口
fix: 修复Redis连接问题
docs: 完善README文档
```

## 📜 开源协议

本项目基于 **Apache License 2.0** 开源，详情请阅读 [LICENSE](LICENSE)。

## 💡 JetBrains 开源支持声明

本项目为遵循 [JetBrains Open Source License Support](https://www.jetbrains.com/community/opensource/#support) 条件的公开项目：
- 仓库完全开放，源码可自由访问
- 采用 Apache 2.0 开源协议
- 仅面向社区学习与技术交流，不用于商业用途

感谢 [JetBrains](https://www.jetbrains.com/?from=springboot-cli) 为本项目提供的优秀开发工具支持 ❤️

## 💬 联系与社区

| 渠道 | 信息                                                                                           |
|------|----------------------------------------------------------------------------------------------|
| 项目主页 | [https://github.com/liuuuu-pro/springboot-cli](https://github.com/liuuuu-pro/springboot-cli) |
| 作者邮箱 | liuuuu-pro@mailuuuu.com                                                          |
| Issue反馈 | 欢迎在 GitHub 提交 Issue                                                                          |

