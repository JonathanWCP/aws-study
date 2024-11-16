package datasources.nosql.dynamo.configuration

import datasources.nosql.dynamo.entity.BooksEntity
import software.amazon.awssdk.auth.credentials.*
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import java.net.URI

fun createDynamoDbClient(): DynamoDbClient {
    return DynamoDbClient.builder()
        .region(Region.SA_EAST_1)
        .endpointOverride(URI.create("http://localhost:4566"))
        .credentialsProvider(
            StaticCredentialsProvider.create(
                AwsBasicCredentials.create("test", "test")
            )
        )
        .build()
}

fun createEnhancedClient(dynamoDbClient: DynamoDbClient): DynamoDbEnhancedClient {
    return DynamoDbEnhancedClient.builder()
        .dynamoDbClient(dynamoDbClient)
        .build()
}

fun getDynamoDbTable(enhancedClient: DynamoDbEnhancedClient): DynamoDbTable<BooksEntity> {
    return enhancedClient.table("books", TableSchema.fromBean(BooksEntity::class.java))
}
