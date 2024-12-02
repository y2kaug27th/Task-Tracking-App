# Task-Tracking-App
![Imgur Image](https://i.imgur.com/y6Xn3hA.png)
## 專案介紹

此專案用意在於幫助使用者高效地管理和追蹤任務。
使用者可以創建不同的任務清單，每個清單中可以包含多個任務，
並能夠對任務進行編輯、刪除、標記為完成等操作。

## 系統架構圖
```mermaid
flowchart LR
    User[使用者] -->|操作任務| React[Vite + React]

    subgraph Frontend [前端]
        React
    end

    subgraph Backend [後端]
        React -->|發送 REST API 請求| SpringBoot[Spring Boot]
        SpringBoot -->|透過 ORM 操作資料| PostgreSQL[PostgreSQL 資料庫]
    end

    subgraph Database [資料庫]
        Docker[Docker 容器]
        Docker --> PostgreSQL
    end
```

## 建構環境

* 前端：使用 Vite 搭配 React 作為前端框架，構建用戶界面。前端負責與後端 API 進行數據交互，顯示任務清單與任務，並提供交互方式。
* 後端：使用 Spring Boot 作為後端框架，提供 RESTful API 來處理任務清單與任務的 CRUD 操作。利用 ORM 來簡化資料庫操作，負責處理資料儲存、內容認證等功能。
* 資料庫：利用 Docker 搭建 PostgreSQL 資料庫來儲存所有的任務與任務清單資料。


## 功能介紹
1. 任務清單管理：<br/>使用者可以創建、更新和刪除不同的任務清單，每個清單都可以包含多個任務，讓使用者可以根據專案或任務類型進行分類和管理。

2. 任務管理：<br/>在每個任務清單中，使用者可以新增、編輯或刪除任務。每個任務會包含標題、描述、截止日期和優先順序，並且可以標記為完成。

3. 任務追蹤：<br/>使用者可以查看任務的完成進度，幫助自己了解目前已完成的任務比例。


## 用戶流程
```mermaid
sequenceDiagram

    participant User as 使用者
    participant App as 應用程式

    User->>App: 點擊「新增任務清單」按鈕
    Note right of App: 儲存新任務清單
    App-->>User: 顯示新增的清單
    
    User->>App: 點擊任務清單，進入任務管理
    User->>App: 新增任務並設定優先級和到期日
    Note right of App: 儲存新任務資料
    App-->>User: 顯示更新後的任務列表

    User->>App: 修改任務內容 (更新標題、描述等)
    Note right of App: 更新任務資料
    App-->>User: 顯示修改後的任務

    User->>App: 標記任務為完成
    Note right of App: 更新任務狀態
    App-->>User: 顯示完成進度百分比
```


## 安裝步驟
### 前置準備：

* JDK (Java Development Kit)：確保安裝 JDK 21 版本
* Node.js：安裝 Node.js（建議版本 18 或以上）
* Git：安裝 Git，用於拉取專案代碼
* Docker：安裝Dcker，用於容器化資料庫環境

### 運行專案：
本專案需要三個終端進行操作（確保終端窗口保持開啟以正常運行）

1. 用於啟動資料庫：
```
git clone https://github.com/y2kaug27th/Task-Tracking-App.git
cd Task-Tracking-App
docker-compose up
```
2. 用於啟動後端服務：
```
cd Task-Tracking-App
./mvnw verify
cd target
java -jar tasks-0.0.1-SNAPSHOT.jar
```
3. 用於啟動前端服務：
```
cd Task-Tracking-App/tasks-fe
npm install
npm run dev
```
