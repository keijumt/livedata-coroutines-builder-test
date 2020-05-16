package keijumt.livedata.coroutinesbuildertest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExampleRepository {
    suspend fun findAll(): List<String> = withContext(Dispatchers.IO) {
        listOf("aaa","bbb","ccc")
    }
}