package datasources.nosql.dynamo.repository

import datasources.nosql.dynamo.entity.BooksEntity
import org.springframework.stereotype.Component
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable

@Component
class InserirLivro {
    fun putItem(table: DynamoDbTable<BooksEntity>) {
        val item = BooksEntity(
            id = "123",
            bookName = "My Name"
        )
        table.putItem(item)
    }
}