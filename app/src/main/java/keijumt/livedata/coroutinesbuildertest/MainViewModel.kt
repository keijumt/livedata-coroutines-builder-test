package keijumt.livedata.coroutinesbuildertest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay

class MainViewModel(
    private val exampleRepository: ExampleRepository
): ViewModel() {

    val examples: LiveData<List<String>> = liveData(viewModelScope.coroutineContext) {
        delay(10000)
        emit(exampleRepository.findAll())
    }
}