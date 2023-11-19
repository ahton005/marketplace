package workers

import ICorChainDsl
import InnerContext
import models.InnerError
import models.InnerState
import stubs.InnerStubs
import worker

fun ICorChainDsl<InnerContext>.stubValidationBadDescription(title: String) = worker {
    this.title = title
    on { stubCase == InnerStubs.BAD_DESCRIPTION && state == InnerState.RUNNING }
    handle {
        state = InnerState.FAILING
        this.errors.add(
            InnerError(
                group = "validation",
                code = "validation-description",
                field = "description",
                message = "Wrong description field"
            )
        )
    }
}
