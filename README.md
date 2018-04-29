# 部署 SkyWalking

参考 https://github.com/apache/incubator-skywalking/blob/master/docs/cn/Quick-start-CN.md

# 启动包含 agent

skywalking 项目里有个 agent 目录，把 agent 目录拷贝到特定位置，启动 Java 应用的时候通过 -javaagent 参数指定 skywalking-agent.jar。

