package admin.events

import admin.events.models.AdminEventsAction
import admin.events.models.AdminEventsEvent
import admin.events.models.AdminEventsViewState
import com.adeo.kviewmodel.BaseSharedViewModel

class AdminEventsViewModel :
    BaseSharedViewModel<AdminEventsViewState, AdminEventsAction, AdminEventsEvent>(
        initialState = AdminEventsViewState()
    ) {
    override fun obtainEvent(viewEvent: AdminEventsEvent) {

    }
}