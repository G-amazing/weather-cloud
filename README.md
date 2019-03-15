# 各个模块功能介绍

### micro-weather-eureka-server

这个是eureka注册中心，所有的服务都注册这里

### msa-weather-city-server

这个模块的功能是提供城市列表。从跟路径下读取citylist.xml，并返回城市列表

### msa-weather-collection-server

这个模块的功能是获取天气数据，并存入redis中。实现过程：从**msa-weather-city-server**服务中获取城市列表，调用第三方天气接口查询每个城市的天气，最后把这些数据存入redis中。这里会有一个定时任务，每个2小时更新一次缓存中的数据

### msa-weather-data-server

根据城市的id或者名称从redis中查询数据

### msa-weather-report-server

前端展示数据。这个服务会调用**msa-weather-city-server**服务获取城市数据，会调用**msa-weather-data-server**获取每个城市的天气信息

### msa-weather-gateway

网关