package com.study.bigquery.gateway

import com.google.cloud.bigquery.BigQuery
import com.google.cloud.bigquery.QueryJobConfiguration
import com.google.cloud.bigquery.TableResult
import org.springframework.stereotype.Service

@Service
class BigQueryGateway(
    private val bigQuery: BigQuery
) {
    fun executeQuery(jobConfiguration: QueryJobConfiguration): TableResult {
        return bigQuery.query(jobConfiguration)
    }
}