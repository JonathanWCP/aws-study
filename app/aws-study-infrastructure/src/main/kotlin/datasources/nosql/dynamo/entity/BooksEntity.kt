package datasources.nosql.dynamo.entity

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*

@DynamoDbBean
data class BooksEntity(
    @get:DynamoDbPartitionKey
    var id: String? = null,

    @get:DynamoDbAttribute("bookName")
    var bookName: String? = null,
)