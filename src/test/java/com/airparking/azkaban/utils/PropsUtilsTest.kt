package com.airparking.azkaban.utils

import org.junit.Test
import java.util.*

class PropsUtilsTest {
    @Test
    fun testGet() {
        val port: Int = PropsUtils.getInt("port", 3306)
        val host: String = PropsUtils.get("host")
        assert(port == 3306)
        assert(host == "10.35.22.61")
    }

    @Test
    fun testResourceLoader() {
        val classLoader = ClassUtils.getDefaultClassLoader()
        val `in` = classLoader!!.getResourceAsStream("datax_order.job ")
        val props: Properties = Properties()
        props.load(`in`)

        props.entries.forEach(
                {
                    val str = it.key.toString() + ": " + it.value.toString() + "\n"
                    print(str)
                }
        )

    }
}