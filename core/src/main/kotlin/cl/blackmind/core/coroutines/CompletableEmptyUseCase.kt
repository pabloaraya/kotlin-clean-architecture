package cl.blackmind.core.coroutines

import cl.blackmind.core.extension.LiveCompletable
import cl.blackmind.core.extension.postCancel
import cl.blackmind.core.extension.postComplete
import cl.blackmind.core.extension.postLoading
import cl.blackmind.core.extension.postThrowable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.CancellationException
import kotlin.coroutines.CoroutineContext

abstract class CompletableEmptyUseCase(
    override val backgroundContext: CoroutineContext,
    override val foregroundContext: CoroutineContext
) : BaseUnitUseCase<LiveCompletable>(
    backgroundContext, foregroundContext
) {
    protected abstract suspend fun executeOnBackground()

    override fun execute(liveData: LiveCompletable) {
        CoroutineScope(foregroundContext + newJob()).launch {
            liveData.postLoading()

            runCatching {
                withContext(backgroundContext) { executeOnBackground() }
            }.onSuccess {
                liveData.postComplete()
            }.onFailure { throwable ->
                when (throwable) {
                    is CancellationException -> liveData.postCancel()
                    else -> liveData.postThrowable(throwable)
                }
            }
        }
    }
}
