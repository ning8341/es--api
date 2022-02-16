# es--api
es-调用api

程序入口ElasticController



### @Document

作用在类，标记实体类为文档对象

### indexName：

对应索引库名称，是一个逻辑命名空间，相当于数据库名 必须为小写

### type：

对应在索引库中的类型

### shards：

分片数量，默认5默认情况下，Elasticsearch为每个索引创建一个主分片和一个副本。这意味着每个索引将包含一个主分片，每个分片将具有一个副本。Elasticsearch自动管理这些分片的排列，用户无需担心细节。

允许你水平分割/扩展你的内容容量 允许你在分片（潜在地，位于多个节点上）之上进行分布式的、并行的操作，进而提高性能/吞吐量 有两种类型的分片：primary shard和replica shard Primary shard: 每个文档都存储在一个Primary shard。 Replica shard: 每个主分片可以具有零个或多个副本。

- 增加故障转移：如果主要故障，可以将副本分片提升为主分片
- 提高性能：get和search请求可以由主shard或副本shard处理。 replicas： 副本数量，默认1，分配多个分片和副本是分布式搜索功能设计的本质，提供高可用性和快速访问索引中的文档。主副本和副本分片之间的主要区别在于只有主分片可以接受索引请求。副本和主分片都可以提供查询请求。number_of_shards值与索引有关，而不是与整个群集有关。此值指定每个索引的分片数（不是群集中的主分片总数）。

indexStoreType 文件存储类型，index.store.type可以在节点的elasticsearch.yml里设置，也可以在索引的setting里设置，但只有索引创建时才可以。

可选的存储类型有：

fs ：默认实现，取决于操作系统 simplefs ：对应Lucene SimpleFsDirectory niofs ：对应Lucene NIOFSDirectory mmapfs ：对应Lucene MMapDirectory
