package com.library.resource.http

import datasources.nosql.dynamo.configuration.createDynamoDbClient
import datasources.nosql.dynamo.configuration.createEnhancedClient
import datasources.nosql.dynamo.configuration.getDynamoDbTable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import datasources.nosql.dynamo.repository.InserirLivro;

@RestController
@RequestMapping("/health")
class HealthCheckController {

    val InserirLivro: InserirLivro = InserirLivro()
    val dynamoDbClient = createDynamoDbClient()
    val enhancedClient = createEnhancedClient(dynamoDbClient)
    val table = getDynamoDbTable(enhancedClient)

    @GetMapping
    fun demo() :String{
        return "Hello World!"
    }

    @PostMapping
    fun createBook() :String{
        InserirLivro.putItem(table)
        return "Ok"
    }
}