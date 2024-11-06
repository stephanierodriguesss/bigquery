package com.study.bigquery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class BigqueryApplication

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<BigqueryApplication>(*args)
}