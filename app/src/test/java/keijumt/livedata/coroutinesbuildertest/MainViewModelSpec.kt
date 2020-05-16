package keijumt.livedata.coroutinesbuildertest

import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

@ExperimentalCoroutinesApi
class MainViewModelSpec: Spek({
    val testCoroutinesDispatcher = ViewModelSpekHelper.setup(this)

    Feature("MainViewModel") {

        val repository by memoized { mockk<ExampleRepository>() }
        val subject by memoized { MainViewModel(repository) }

        Scenario("observe examples") {
            val mockData = listOf("a", "b", "c", "d", "e")

            Given("Returning mock data with findAll"){
                coEvery { repository.findAll() } returns mockData
            }

            lateinit var examples: List<String>

            When("Observe ViewModel#examples") {
                examples = subject.examples.getOrAwaitValue {
                    testCoroutinesDispatcher.advanceUntilIdle()
                }
            }

            Then("Matches mock data") {
                assertThat(examples).isEqualTo(mockData)
            }
        }
    }
})
