# Docker 本地开发环境

本目录用于管理 **开发所需的基础服务**，基于 **Docker Compose**。

---

## 当前集成

| Component  | Version | Notes |
|------------|---------|------|
| MySQL      | 8.0.36  |  |
| PostgreSQL | 18+     |  |


## 目录结构

```text
docker/
├── mysql/
│   └── data/              # 数据持久化目录
├── .env.example           # 环境变量
├── docker-compose.yml     # 配置
└── README.md