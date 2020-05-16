package keijumt.livedata.coroutinesbuildertest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExampleRepository(
    private val provideData: List<String>
) {
    suspend fun findAll(): List<String> = withContext(Dispatchers.IO) {
        provideData
    }
}