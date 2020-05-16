package keijumt.livedata.coroutinesbuildertest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel by viewModels<MainViewModel> {
            MainViewModelFactory(ExampleRepository(listOf("a", "b", "c")))
        }

        mainViewModel.examples.observe(this) {
            println(it)
        }
    }
}

class MainViewModelFactory(
    private val exampleRepository: ExampleRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(exampleRepository) as T
        }
        throw IllegalArgumentException("unexpected model class $modelClass")
    }
}
