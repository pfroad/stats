package com.airparking.azkaban.common

import org.junit.BeforeClass
import org.junit.Test

class ClasspathScannerTests {
    companion object {
        private var scanner:ClasspathScanner? = null

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            scanner = ClasspathScanner("com.airparking.azkaban", "org.slf4j")
        }
    }

    @Test
    fun scanTest() {
        val classes: List<Class<*>> = scanner?.scan()!!

        classes.forEach { it ->
            run {
                println(it.name)
            }
        }
    }
}