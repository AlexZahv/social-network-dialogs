package ru.zahv.alex.socialnetworkdialogs.logging.kt

import feign.RequestInterceptor
import feign.RequestTemplate
import ru.zahv.alex.socialnetworkdialogs.logging.kt.Headers.Companion.TRACE_ID


class TraceIdRequestInterceptor : RequestInterceptor {
    override fun apply(requestTemplate: RequestTemplate) {
        var traceId = TraceIdHolder.traceId
        if (traceId.isNullOrEmpty()) {
            traceId = TraceIdHolder.newTraceId
        }
        requestTemplate.header(TRACE_ID, traceId)
    }
}
