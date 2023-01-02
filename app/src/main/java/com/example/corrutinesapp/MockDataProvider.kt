package com.example.corrutinesapp

class MockDataProvider {

    companion object {
        val instance = MockDataProvider()
    }

    fun doHeavyTask():Int{
        Thread.sleep(3000)
        return 3000
    }
}