package keijumt.livedata.coroutinesbuildertest

import androidx.arch.core.executor.ArchTaskExecutor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.spekframework.spek2.dsl.Root

object ViewModelSpekHelper {
    @ExperimentalCoroutinesApi
    fun setup(root: Root): TestCoroutineDispatcher {
        val testCoroutineDispatcher = TestCoroutineDispatcher()

        root.beforeEachTest {
            Dispatchers.setMain(testCoroutineDispatcher)
            ArchTaskExecutor.getInstance().setDelegate(TestArchTaskExecutor())
        }
        root.afterEachTest {
            Dispatchers.resetMain()
            ArchTaskExecutor.getInstance().setDelegate(null)
        }

        return testCoroutineDispatcher
    }
}
