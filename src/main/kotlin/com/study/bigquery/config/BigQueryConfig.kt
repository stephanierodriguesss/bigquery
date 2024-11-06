package com.study.bigquery.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.auth.oauth2.ServiceAccountCredentials
import com.google.cloud.bigquery.BigQuery
import com.google.cloud.bigquery.BigQueryOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream

@Configuration
class BigQueryConfig {

    @Bean
    fun bigQuery(): BigQuery {
        val projectId = System.getenv("GOOGLE_CLOUD_PROJECT")
        return BigQueryOptions.newBuilder().setProjectId(projectId)
            .setCredentials(
                ServiceAccountCredentials.fromStream(FileInputStream("src/main/resources/credentials-bq.json"))
            ).build().getService()
    }
}