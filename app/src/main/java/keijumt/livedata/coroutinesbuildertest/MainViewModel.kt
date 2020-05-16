package keijumt.livedata.coroutinesbuildertest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope

class MainViewModel(
    private val exampleRepository: ExampleRepository
): ViewModel() {

    val examples: LiveData<List<String>> = liveData(viewModelScope.coroutineContext) {
        emit(exampleRepository.findAll())
    }
}