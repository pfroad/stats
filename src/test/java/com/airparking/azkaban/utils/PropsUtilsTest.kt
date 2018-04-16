package com.airparking.azkaban.utils

import org.junit.Test

class PropsUtilsTest {
    @Test
    fun testGet() {
        val port: Int = PropsUtils.getInt("port", 3306)
        val host: String = PropsUtils.get("host")
        assert(port == 3306)
        assert(host == "10.35.22.61")
    }
}