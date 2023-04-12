# OOAD_Final_Project
#### 1.Executive abstract 

本项⽬旨在实现⼀个更加简单易⽤的代码托管⽹站, 实现github 版本控制，分⽀管理等核⼼操作，提供给⽤户良好 的体验。本项⽬我们主要会实现 仓库管理 , ⽤户管理, 分⽀管理与版本管理 四⼤核⼼功能，⽀持⽤户的创建仓库、 管理权限、⽂件回溯、⽂件托管等需求。我们使⽤ Jgit 与spring boot作为整个项⽬的后端框架, ⽤Vue 与 bootstrap 作为整个项⽬的前端框架，以保障⽹站性能的稳定性, 安全性，⽹站界⾯的美观

#### 1.Motivation 

开发中，代码托管平台可以给开发者们提供便利，提⾼团队开发表现 

**可协同**: 在功能层⾯要包含仓库管理、分⽀管理、权限管理、提交管理、代码评审等代码存储和版本管理等功能, 让 多开发者更好的协同⼯作; 

**同步开发**：不同终端上进⾏同步开发；不同终端，不同开发者可以同步进度 

**备份**：提交了⼀些我们不希望的⽂件；在⼀次产品上线之后，出现了紧急Bug，⼀时半会⽆法修复，为了保证线 上稳定，需要做代码回滚。 

代码托管平台对于⼩队开发⾮常的重要，因此我们构建了实现git等代码管理功能的代码管理平台。我们将遵循⼀般 的代码托管平台范式，本地设有代码仓库，并与部署在远程服务器代码仓库交互，实现代码托管的功能。

#### 2.Requirements

2.1. Functional requirements 

仓库管理：创建，销毁，⽂件管理、权限管理（开发者被仓库管理员授权后共同管理项⽬）和信息管理 

⽤户管理：⽤户注册、登录和注销，PR 功能，issue、fork，⽤户社区 分⽀管理: 分⽀的创建、删除、merge 以及冲突检测 

版本管理: ⽂件/⽂件夹commit、rollback、历史版本展示 

2.2. Non-functional requirements 

Performance: 能承受⼀定并发压⼒， 保证传输速度 

Storage requirements: 易扩容，低容量预警 

Cost per user for deployment：易部署，低配置，开箱即⽤

#### 4.Technologies 

##### 前端 

html、css、js：前端⻚⾯⽣成的基本⽂件对应的内容、样式、脚本 

npm： 前端项⽬管理 

vue：前端项⽬框架 

vue-router： ⻚⾯跳转 

elementUI：⽤于构建前端部分组件与样式 

bootstrap： ⽤于构建前端⻚⾯的响应式布局、部分样式和部分组件 

axios： 完成ajax请求，实现前后端交互 

##### 后端 

服务端：spring-boot ，mybatis

连接池：Druid

数据库：MySQL, Redis 

鉴权原理：Token, JWT

调试⽇志： Springfox-swagger Log4j 
