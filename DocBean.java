package com.lsd.bean;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "ems", type = "_doc", shards = 1, replicas = 0)
public class DocBean {


    /**
     * @Field作用在成员变量，标记为文档的字段，并指定字段映射属性：
     * type：字段类型，是枚举：FieldType，可以是text、long、short、date、integer、object等
     * text：存储数据时候，会自动分词，并生成索引
     * keyword：存储数据时候，不会分词建立索引
     * Numerical：数值类型，分两类
     * 基本数据类型：long、interger、short、byte、double、float
     * half_float 浮点数的高精度类型：scaled_float 需要指定一个精度因子，比如10或100。  elasticsearch会把真实值乘以这个因子后存储，取出时再还原。
     * Date：日期类型 elasticsearch可以对日期格式化为字符串存储，但是建议我们存储为毫秒值，存储为long，节省空间。
     * index：是否索引，布尔类型，默认是true
     * store：是否存储，布尔类型，默认是false
     * analyzer：分词器名称，这里的ik_max_word即使用ik分词器
     * Auto：自动加载
     */

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String firstCode;

    @Field(type = FieldType.Keyword)
    private String secordCode;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;

    @Field(type = FieldType.Integer)
    private Integer type;

    public DocBean(Long id, String firstCode, String secordCode, String content, Integer type) {
        this.id = id;
        this.firstCode = firstCode;
        this.secordCode = secordCode;
        this.content = content;
        this.type = type;
    }
}

